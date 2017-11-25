package org.cidarlab.fluigi.layout;

import java.util.ArrayList;
import java.util.List;

/**
 * The goal here is to at somepoint incorporate the obstacle map / rubberband sketch so that at each level of routing
 * we can check if the design is still routable
 */
public class ObstacleMap {

    List<Obstacle> obstaclesList;

    public ObstacleMap(){
        obstaclesList = new ArrayList<>();
    }

    public List<Obstacle> getObstacles(int xmin, int xmax, int ymin, int ymax) {
        throw new UnsupportedOperationException("Implement method to return the obstacles");
    }

    public void addObstaclesForChannel(Net net){
        throw new UnsupportedOperationException("Implement method to add obstacles for channel/net");
    }


}
