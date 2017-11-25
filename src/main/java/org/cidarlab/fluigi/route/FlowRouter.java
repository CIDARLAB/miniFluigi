package org.cidarlab.fluigi.route;

import org.cidarlab.fluigi.layout.*;
import org.cidarlab.fluigi.route.hadlock.Grid;
import org.cidarlab.fluigi.route.hadlock.GridPoint;

import java.util.ArrayList;
import java.util.List;

import static org.cidarlab.fluigi.route.hadlock.DefaultParams.blockingCost;
import static org.cidarlab.fluigi.route.hadlock.DefaultParams.lambda;

/**
 * Created by krishna on 3/7/17.
 */
public class FlowRouter implements Runnable {

    private final ObstacleMap layout;
    Net routingEvent;
    private int routingSpacing = 200;
    List<Obstacle> obstacles;
    Grid routinggrid;


    public FlowRouter(Net routingEvent, ObstacleMap layout) {
        this.routingEvent = routingEvent;
        this.layout = layout;

        //This figures out how big the routing region is, etc.
        initializeRoutingingRegionHelper();
        obstacles = this.layout.getObstacles(xmin, xmax , ymin, ymax);

        //TODO: Figure out how to transform this back into
        int gridxspan = (xmax - xmin) / lambda;
        int gridyspan = (ymax - ymin) / lambda;

        routinggrid = new Grid(gridxspan, gridyspan);

        //TODO: Figure out if anything special has to be done for nodes since we don't have the entire global grid being generated

        translateObstaclesHelper(xmin, ymin);

        //TODO: Set gridpoint costs based on whether a its occupied or is spacing or whatever
        GridPoint gp;
        //Get each obstacle
        for (Cell obstacle : obstacles){
            //Go through each x and y of the obstacle
            for (int x = obstacle.getX(); x<obstacle.getMaxX(); x++){
                for(int y = obstacle.getY(); y<obstacle.getMaxY(); y++){
                    //If point is within the region
                    if((x>=xmin && x<xmax && y>=ymin && y<ymax)){
                        //This block means its in the region
                        //update the grid point value (keep in mind that grid coordinates change)
                        gp = routinggrid.gridPointAt(x - xmin, y - ymin); //NOTE: Grid starts from 0,0
                        gp.setBaseCost(blockingCost);
                    }
                    //TODO: Figure out how to include spacing costs
                }
            }


        }

        //Tell Grid what the source and target locations are
        //This would have to be transformed into the correct coordinate
        routinggrid.setSource(transformX(routingEvent.getSource().getX()), transformY(routingEvent.getSource().getY()));
        routinggrid.setTarget(transformX(routingEvent.getTarget().getX()), transformY(routingEvent.getTarget().getY()));

    }

    private int transformY(int y) {
        return (y - ymin) / lambda;
    }

    private int transformX(int x) {
        return (x - xmin) / lambda;
    }

    private void translateObstaclesHelper(int xmin, int ymin) {
        //TODO: Run through each of the obstacles and set their positions to be such that the xmin, ymin are zeros
        throw new UnsupportedOperationException();
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Need to implement the run router");
    }

    //Region properties

    int xmin = 0;
    int xmax = 0;
    int ymin = 0;
    int ymax = 0;


    private void initializeRoutingingRegionHelper(){
        /*
        Find the largest bounds for the grid that needs to be built
        */
        ArrayList<Integer> xpts = new ArrayList();
        ArrayList<Integer> ypts = new ArrayList<>();

        //10% greater than
        int delta = 2*routingSpacing;

        //1.
        xpts.add(routingEvent.getSource().getX());
        ypts.add(routingEvent.getSource().getY() - delta);

        //2.
        xpts.add(routingEvent.getSource().getX() + delta);
        ypts.add(routingEvent.getSource().getY());

        //3.
        xpts.add(routingEvent.getSource().getX());
        ypts.add(routingEvent.getSource().getY() + delta);

        //4.
        xpts.add(routingEvent.getSource().getX() - delta);
        ypts.add(routingEvent.getSource().getY());


        //Now the targets

        //5.
        xpts.add(routingEvent.getTarget().getX());
        ypts.add(routingEvent.getTarget().getY() - delta);

        //6.
        xpts.add(routingEvent.getTarget().getX() + delta);
        ypts.add(routingEvent.getTarget().getY());

        //7.
        xpts.add(routingEvent.getTarget().getX());
        ypts.add(routingEvent.getTarget().getY() + delta);

        //8.
        xpts.add(routingEvent.getTarget().getX() - delta);
        ypts.add(routingEvent.getTarget().getY());


        //Find the bounding points and set them as
        //the limits of the maze router
        for(int i = 0 ; i<xpts.size(); i++){
            if(xpts.get(i)<xmin){
                xmin = xpts.get(i);
            }else if(xpts.get(i)>xmax){
                xmax = xpts.get(i);
            }

            if(ypts.get(i)<ymin){
                ymin = ypts.get(i);
            }else if(ypts.get(i)>ymax){
                ymax = ypts.get(i);
            }
        }
    }


}
