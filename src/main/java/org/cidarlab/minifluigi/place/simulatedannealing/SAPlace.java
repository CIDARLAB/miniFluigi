/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cidarlab.minifluigi.place.simulatedannealing;

import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;

import org.cidarlab.minifluigi.layout.Cell;
import org.cidarlab.minifluigi.layout.Placement;
import org.cidarlab.minifluigi.place.Placer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author cassie
 */
public class SAPlace extends Placer {

    XorShift64 rand;
    int lambda;
    int maxDeviceWidth = 101600;
    int maxDeviceLength = 101600;
    private int movesPerTempPerModule = 250;

    protected SALayout layout;

    //the simulated annealing placement algorithm based on the VPR algorithm with minor tweaks.
    //uses the same cooling schedule as the vpr algorithm
    //protected static Random rand;  //random number generator
    private static final int SIGMA_MULTIPLIER = 20;

    //Assumption:  the final device is going to be smaller than 225cm^2 (6" x 6", give or take)
    //range of initial x and y will be 1.5*10e6, so ~2^17
    private static int rangeX;  // range of motion for layout, changes as temperature decreases
    private static int rangeY;  // range of motion for layout, changes as temperature decreases

    private static double temp;  //temperature
    private static double initTemp = Integer.MAX_VALUE;  //starting temperature
    private static double rateAccept = 0.0;  //acceptance of moves

    private static ArrayList<Cell> listComponents; //use to randomly select something from the layout

    // layou.layoutGraph.vertexSet() converted to an arraylist

    public SAPlace() {
        layout = new SALayout();
        long seed = System.nanoTime();
        
        //if(Fluigi.isDebugPrintEnabled){
            System.out.println("Randomizer Seed: " + seed);
        //}
        rand = new XorShift64(seed);

        rangeX = maxDeviceWidth/lambda;
        rangeY = maxDeviceLength/lambda;
        listComponents = new ArrayList<>();
    }

    public void cleanup(){
        //reset();
        listComponents = null;
        layout = null;
    }
    
//    @Override
//    public void reset(){
//        //layout.clear();
//        listComponents.clear();
//        rangeX = maxDeviceWidth/lambda;
//        rangeY = maxDeviceLength/lambda;
//    }
    
    @Override
    public void place() {
        //layout.loadDevice(d, log);
        initPlace();
        //initPlaceClusterGrowth();
        initTemp();
        temp = initTemp;
        long t1 = System.nanoTime();
        System.out.println("Initial Temp = " + temp);
        //movesPerTempPerModule = (int)(10*Math.pow(listComponents.size(), 0.33));
        while (temp >= 0.005 * layout.currentCost() / listComponents.size() && layout.currentCost() > 2) { // termination condition
            for (int i = 0; i < listComponents.size() * movesPerTempPerModule; i++) {
                //Peturb placement
                //select component to move
                //Component randC = selectRandComponent();
                Cell randC = listComponents.get(i%listComponents.size());
                int randX = (rand.nextDouble() > 0.5) ? (int) (rangeX / 2 * rand.nextDouble()) : -(int) (rangeX / 2 * rand.nextDouble());
                int randY = (rand.nextDouble() > 0.5) ? (int) (rangeY / 2 * rand.nextDouble()) : -(int) (rangeY / 2 * rand.nextDouble());
                if ((rand.nextDouble() > 0.5)){
                    randX = 0;
                } else {
                    randY = 0;
                }
                //System.out.println("x: " + randX + " y: " + randY);
                layout.calcPrevCompOverlap(randC);
                layout.calcPrevCompWirelength(randC);
                layout.grid.newMove(randC, randX, randY);
                
                
                //Calculate new cost
                layout.calcCost(randC);
                //layout.print();
                //if new cost less than old cost, accept.  otherwise accept randomly.  continue if not accept
                double test = rand.nextDouble();
                if (layout.getDeltaCost() <= 0) { //good move, accept
                    //System.out.println("deltaCost =" + Double.toString(layout.getDeltaCost()));
                    layout.grid.applyMove();
                    rateAccept = rateAccept + 1.0;
                } else if (test < Math.exp(-(layout.getDeltaCost()) / temp)) {//bad move, but accept based on current temp
                    //System.out.println("deltaCost =" + Double.toString(layout.getDeltaCost()));
                    //System.out.println("temp=" + temp);
                    //System.out.println("Prob accept: " + Double.toString(Math.exp(-(layout.getDeltaCost()) / temp)));
                    //System.out.println("actual prob: " + test);
                    layout.grid.applyMove();
                    rateAccept = rateAccept + 1.0;
                } else {//reject and move to the next iteration
                    //unpeturb
                    //System.out.println("reject");
                    layout.grid.undoMove();
                    layout.undoUpdateCost();
                }
            }
            rateAccept = rateAccept / (double) (listComponents.size() * movesPerTempPerModule);
            //update range limit
            rangeX = (int) (Math.floor((double) (rangeX) * (1.0 - 0.44 + rateAccept)));
            rangeY = (int) (Math.floor((double) (rangeY) * (1.0 - 0.44 + rateAccept)));
            if (rangeX >= maxDeviceWidth/lambda) {
                rangeX = maxDeviceWidth/lambda;
            }
            if (rangeY >= maxDeviceLength/lambda) {
                rangeY = maxDeviceLength/lambda;
            }
            //System.out.println("range x = " + rangeX);
            //System.out.println("range y = " + rangeY);
            //update temp based on rateAccept
            if (rateAccept > 0.96) {
                temp = 0.5 * temp;
            } else if (rateAccept <= 0.96 && rateAccept > 0.8) {
                temp = 0.9 * temp;
            } else if (rateAccept <= 0.8 && rateAccept > 0.15) {
                temp = 0.95 * temp;
            } else {
                temp = 0.8 * temp;
            }
            System.out.println("-> Temp = " + temp);
        }
        System.out.println("Final Temp = " + temp);
        System.out.println("Overlap =" + layout.calcOverlap());
        return layout;
    }



    @Override
    public void loadProblem(Placement placementproblem){
        super.loadProblem(placementproblem);
        //TODO: Create all the things required for the SA layout
    }


    /*
    Helper Methods
     */
    private void initPlace() {//generate initial random placement
        System.out.println("Random Initial Place");
        listComponents = ;
        for (Cell c : listComponents) {
            int randX = (int) (rangeX * rand.nextDouble());
            int randY = (int) (rangeY * rand.nextDouble());
            //limit randX, randY 1/19/15
            //System.out.println("x: " + randX + " y: " + randY);
            c.setX(randX);
            c.setY(randY);
            c.updateTerminals();
            layout.grid.addComponent(c);
        }
        layout.calcInitCost();
        //layout.print();
    }

    private void initTemp() {
        System.out.println("Initial Temp");
        double[] costHistory = new double[listComponents.size()];
        for (int i = 0; i < listComponents.size(); i++) {
            int randX = (rand.nextDouble() > 0.5) ? (int) (rangeX / 2 * rand.nextDouble()) : -(int) (rangeX / 2 * rand.nextDouble());
            int randY = (rand.nextDouble() > 0.5) ? (int) (rangeY / 2 * rand.nextDouble()) : -(int) (rangeY / 2 * rand.nextDouble());
            Cell randC = selectRandComponent();
            //System.out.println("x: " + randX + " y: " + randY);
            layout.calcPrevCompOverlap(randC);
            layout.calcPrevCompWirelength(randC);
            layout.grid.newMove(randC, randX, randY);            
            layout.grid.applyMove();
            layout.calcCost(randC);
            //layout.print();
            costHistory[i] = layout.currentCost();
        }
        
        StandardDeviation stdev2 = new StandardDeviation();
        initTemp = SIGMA_MULTIPLIER * stdev2.evaluate(costHistory);
    }

    private Cell selectRandComponent() {
        int randInd = (int) (listComponents.size() * rand.nextDouble());
        Cell randC = listComponents.get(randInd);
        return randC;
    }

}
