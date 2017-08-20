package org.cidarlab.fluigi.place.simulatedannealing;

import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.cidarlab.fluigi.layout.Cell;
import org.cidarlab.fluigi.layout.Net;
import org.cidarlab.fluigi.place.Placer;
import org.cidarlab.fluigi.place.XorShift64;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by krishna on 4/6/17.
 */
public class SAPlacer extends Placer {

    static double temp;
    static double cost;
    XorShift64 randomgenerator = new XorShift64(System.nanoTime());
    List<Cell> cells;
    Logger logger = LogManager.getRootLogger();

    /*
    NOTE- I am limiting the entire canvas to be positive integers and it will not include any negative coordinates
    as a target range for the positions. This I hope will simplify stuff at a later point
     */
    static int rangeX = SAConstants.SA_MAX_WIDTH;
    static int rangeY = SAConstants.SA_MAX_HEIGHT;

    public SAPlacer(){
        super();
        oldCost = new ArrayList<>();
        oldArea = new ArrayList<>();
        oldOverlap = new ArrayList<>();
        oldWirelength = new ArrayList<>();
    }

    private void initSA() {
        //Seed the layout
        double[] costHistory = new double[problem.getCells().size()];
        int cost;
        Cell cell;
        for(int index = 0; index<problem.getCells().size(); index++ ){
            //Assign random position to the cell
            cell = problem.getCells().get(index);
            cell.setX(generateRandomCoordinate());
            cell.setY(generateRandomCoordinate());
            costHistory[index] = calcCurrentCost();
        }

        StandardDeviation stdev = new StandardDeviation();

        temp = SAConstants.SIGMA_MULTIPLIER * stdev.evaluate(costHistory);
        logger.info("Initial Temperature = " + temp);
    }

    @Override
    public void place() {
        //TODO - Review the entire algorithm
        //Calculate initial temperature

        //Calculate initial cost

        //init X,Y Range for the device

        //Start doing the SA
        cells = this.problem.getCells();
        int num_components = this.problem.getCells().size();

        //Initialize the layout
        initSA();

        while((temp > 0.005 * cost / num_components) && (temp>2)){

            //Do all the moves
            int acceptedmoves = 0;
            int totalmoves = num_components * SAConstants.NUMBER_OF_MOVES_PER_COMPONENT;

            //Pick a component
            int randomindex = randomgenerator.nextInt(cells.size());

            for(int i=0; i<totalmoves; i++){

                //Calculate the current cost
                cost = calcCurrentCost();

                //Generate the new move

                //Randomly select new component to place
                Cell cell = cells.get(randomindex);

                int newx = cell.getX();
                int newy = cell.getY();

                //P=0.5 to perturb either the X Coordinate or Y Coordinate
                if(randomgenerator.nextBoolean()){
                    newx += generatePertubation(rangeX);
                } else {
                    newy += generatePertubation(rangeY);
                }

                //Adjust newx, newy if they are out of the limits
                if(newx > rangeX){
                    newx = rangeX;
                }

                if(newx < 0){
                    newx = 0;
                }

                if(newy > rangeY){
                    newy = rangeY;
                }

                if(newy < rangeY){
                    newy = 0;
                }


                //Calculate cost of new placement
                double newcost = calcNewCost(cell, newx, newy);
                if(newcost < cost){
                    //Do the damn move
                    cell.setX(newx);
                    cell.setY(newy);

                    //Increment the number of accepted moves
                    acceptedmoves++;
                } else {
                    //if newcost > cost then do hill climbing
                    //TODO: Check if the hill climbing condition is correct is correct
                    if (randomgenerator.nextDouble() < Math.exp((cost-newcost)/temp)){
                        //Do the damn move
                        cell.setX(newx);
                        cell.setY(newy);

                        //Increment the number of accepted moves
                        acceptedmoves++;
                    } else {
                        //Undo the move
                        newx = 0;
                        newy = 0;
                    }
                }

            }

            double acceptrate = acceptedmoves/totalmoves;
            System.out.println("Accepted Rate: " + acceptrate);

            //Decrease temperature based on the acceptrate

            if(acceptrate > 0.96){
                temp = temp * 0.5;
            }else if(acceptrate>0.8 && acceptrate<=0.96){
                temp = temp * 0.9;
            }else if(acceptrate>0.15 && acceptrate<=0.8){
                temp = temp * 0.95;
            }else if(acceptrate<=0.15){
                temp = temp * 0.8;
            }

            //Reduce the range based on the accept rate
            //This is ported right out of the old fluigi code
            rangeX = (int) (Math.floor((double) (rangeX) * (1.0 - 0.44 + acceptrate)));
            rangeY = (int) (Math.floor((double) (rangeY) * (1.0 - 0.44 + acceptrate)));


            //Print the temperature
            System.out.println("-> Temp = " + temp);

        }

        //Printing the final temperature
        System.out.println("--> Final Temp = " + temp);

        finishSA();

        //Print out a snapshot of the placements
        //PlacementSnapshot snapshot = new PlacementSnapshot("placmentsnapshot", problem);
    }

    private void finishSA() {
        //This method should inlcude some of the cleanup of the finishing stuff
        //Need to translate the entire device to the where the min x and min y = 0

        //Translate the entire device using these min values
        int minx = Integer.MAX_VALUE;
        int miny = Integer.MAX_VALUE;


        //Loop through all the cells
        for(Cell c : problem.getCells()){

            //Check for lowest x, y value
            if(c.getX() < minx){
                minx = c.getX();
            }

            if(c.getY() < miny){
                miny = c.getY();
            }
        }

        //Translate the device
        System.out.println("Translating placement: " + -minx + ", " +  -miny);
        problem.translateCells(-minx, -miny);

        System.out.println("Placement Width: " + problem.getWidth());
        System.out.println("Placement Height: " + problem.getHeight());

    }

    private int generatePertubation(int range) {
        //The limit of the range of pertubation is range/2
        double magnitude  = randomgenerator.nextDouble() * range/2; //generating magnitude
        return (randomgenerator.nextDouble() > 0.5)? (int) magnitude : (int) magnitude * -1; //generating the direction
    }

    private int generateRandomCoordinate() {
        //Need to figure out how I should limit the canvas size
        Double randomnumber = randomgenerator.nextDouble();
        int coordinate = (int) ((rangeX) * randomnumber); //This is the rounded integer coordinate
        int remainder = coordinate % SAConstants.SA_LAMBDA;

        //Now round it off to the floor lambda
        return coordinate - remainder;
    }


    /*
    Book Keeping Variables for tracking the layout costs
     */
    ArrayList<Double> oldCost;
    double newCost;

    ArrayList<Double> oldArea;
    double newArea;

    ArrayList<Double> oldWirelength;
    double newWirelength;

    ArrayList<Double> oldOverlap;
    double newOverlap;

    /**
     *
     * @return
     */
    private double calcNewCost(Cell perturbedcell, int newx, int newy) {
        //Save old costs
        oldCost.add(newCost);

        //Calculates the new costs
        newArea = calculateNewArea(perturbedcell, newx, newy);
        newWirelength = calculateNewWirelength(perturbedcell, newx, newy);
        newOverlap = calculateNewOverlap(perturbedcell, newx, newy);
        newCost = newWirelength * SAConstants.SA_WIRE_PENALTY +
                newArea * SAConstants.SA_AREA_PENALTY +
                newOverlap * SAConstants.SA_OVERLAP_PENALTY;

        return newCost;
    }

    /**
     *
     * @param perturbedcell
     * @param newx
     * @param newy
     * @return
     */
    private double calculateNewOverlap(Cell perturbedcell, int newx, int newy) {
        oldOverlap.add(newOverlap);
        /*
        TODO: Insert line search algorithm here to replace the shitty n^2 naive comparision algorithm I am using here
         */

        double overlap  = 0;
        double tempoverlap = 0;
        ArrayList<Cell> cells = problem.getCells();
        for(int indexA = 0 ; indexA < cells.size() ; indexA++){
            for(int indexB = indexA+1 ; indexB < cells.size() ; indexB++){
                Cell cellA = cells.get(indexA);
                if(cellA.getID().equals(perturbedcell.getID())){
                    cellA = perturbedcell;
                }

                Cell cellB = cells.get(indexB);
                if(cellB.getID().equals(perturbedcell.getID())){
                    cellB = perturbedcell;
                }

                tempoverlap = calculateOverlap(cellA, cellB);
                overlap+=tempoverlap;
            }
        }

        return overlap;
    }

    /**
     *
     * @param perturbedcell
     * @param newx
     * @param newy
     * @return
     */
    private double calculateNewWirelength(Cell perturbedcell, int newx, int newy) {
        oldCost.add(newCost);
        /*
        1) Get all the connections in the placement problems.
        2) Loop through them and then calculate the wirelengths.
        3) If the cell is the same as the perturbedcell don't use the cell x,y . Use the newx,newy.
         */


        int totalwirelength = 0;
        int sourcex, sourcey, targetx, targety;

        for(Net net : problem.getNets()){
            Cell sourcecell = problem.getNetSource(net);
            Cell targetcell = problem.getNetTarget(net);

            //Check if perturbed cell
            if (sourcecell == perturbedcell){
                //Then set source cell
                sourcecell = perturbedcell;
            } else if (targetcell == perturbedcell){
                //Then set target cell
                targetcell = perturbedcell;
            }

            //Calculate the manhatten wirelengths from the cell centers
            totalwirelength += Math.abs(sourcecell.getCenterX() - targetcell.getCenterX()) +
                    Math.abs(sourcecell.getCenterY() - targetcell.getCenterY());
        }

        return totalwirelength;
    }

    /**
     *
     * @param perturbedcell
     * @param newx
     * @param newy
     * @return
     */
    private double calculateNewArea(Cell perturbedcell, int newx, int newy) {
        oldArea.add(newArea);

        /*
        1) Loop through all the cells
        2) Find the min, max - x,y co-ordinates for all the cells
         */

        //Internal bookkeeping variables
        int minx = 0, miny = 0, maxx = 0, maxy = 0;

        for(Cell cell : cells){
            //Check if perturbed cell
            if(cell == perturbedcell){
                cell = perturbedcell;
            }
            minx = cell.getX();
            maxx = cell.getX() + cell.getW();
            miny = cell.getY();
            maxy = cell.getY() + cell.getH();
        }

        return Math.abs(maxx - minx) * Math.abs(maxy - miny);
    }

    /**
     *
     * @return
     */
    private double calcCurrentCost() {
        newArea = calculateCurrentArea();
        newWirelength = calculateCurrentWirelength();
        newOverlap = calculateCurrentOverlap();
        newCost = newWirelength * SAConstants.SA_WIRE_PENALTY +
                newArea * SAConstants.SA_AREA_PENALTY +
                newOverlap * SAConstants.SA_OVERLAP_PENALTY;

        return newCost;
    }

    /**
     *
     * @return
     */
    private double calculateCurrentOverlap() {
        /*
        TODO: Insert line search algorithm here to replace the shitty n^2 naive comparision algorithm I am using here
         */

        double overlap  = 0;
        double tempoverlap = 0;
        ArrayList<Cell> cells = problem.getCells();
        for(int indexA = 0 ; indexA < cells.size() ; indexA++){
            for(int indexB = indexA+1 ; indexB < cells.size() ; indexB++){
                Cell cellA = cells.get(indexA);
                Cell cellB = cells.get(indexB);
                tempoverlap = calculateOverlap(cellA, cellB);


                overlap+=tempoverlap;
            }
        }

        return overlap;
    }

    /**
     *
     * @param cellA
     * @param cellB
     * @return
     */
    private double calculateOverlap(Cell cellA, Cell cellB) {
        double tempoverlap;//Get coordinates of Cell A

        int Ax1 = cellA.getX();
        int Ay1 = cellA.getY();
        int Ax2 = cellA.getX() + cellA.getW();
        int Ay2 = cellA.getY() + cellA.getH();

        //Get coordinates of Cell B

        int Bx1 = cellB.getX();
        int By1 = cellB.getY();
        int Bx2 = cellB.getX() + cellB.getW();
        int By2 = cellB.getY() + cellB.getH();

        //First check if they overlap

        /*

        ?x1,?y1
        ------------------------
        |                      |
        |                      |
        |                      |
        |                      |
        ------------------------
                              ?x2,?y2


        Variable map to use:

        l1.x = Ax1
        l1.y = Ay1

        r1.x = Ax2
        r1.y = Ay2

        l2.x = Bx1
        l2.y = By1

        r2.x = Bx2
        r2.y = By2
         */


        // If one rectangle is on left side of other
        if (Ax1 > Bx2 || Bx1 > Ax2){
            //Does not overlap
            return 0;
        }


        // If one rectangle is above other
        if (Ay1 < By2 || By1 < Ay2){
            //does not overlap
            return 0;
        }


        //It only reaches this point if there is no overlap between the rectangles
        tempoverlap = Math.max(0, Math.min(Ax2, Bx2) - Math.max(Ax1, Bx1))
                * Math.min(0, Math.min(Ay2, By2) - Math.max(Ay1, By1));

        return tempoverlap;
    }

    /**
     *
     * @return
     */
    private double calculateCurrentWirelength() {
        /*
        1) Get all the connections in the placement problems.
        2) Loop through them and then calculate the wirelengths.
        3) If the cell is the same as the perturbedcell don't use the cell x,y . Use the newx,newy.
         */

        int totalwirelength = 0;
        int sourcex, sourcey, targetx, targety;

        for(Net net : problem.getNets()){
            Cell sourcecell = problem.getNetSource(net);
            Cell targetcell = problem.getNetTarget(net);

            //Calculate the manhatten wirelengths from the cell centers
            totalwirelength += Math.abs(sourcecell.getCenterX() - targetcell.getCenterX()) +
                    Math.abs(sourcecell.getCenterY() - targetcell.getCenterY());
        }

        return totalwirelength;

    }

    /**
     *
     * @return
     */
    private double calculateCurrentArea() {
        /*
        1) Loop through all the cells
        2) Find the min, max - x,y co-ordinates for all the cells
         */

        //Internal bookkeeping variables
        int minx = 0, miny = 0, maxx = 0, maxy = 0;

        for(Cell cell : cells){
            //Check if perturbed cell
            minx = cell.getX();
            maxx = cell.getX() + cell.getW();
            miny = cell.getY();
            maxy = cell.getY() + cell.getH();
        }

        return Math.abs(maxx - minx) * Math.abs(maxy - miny);
    }
}
