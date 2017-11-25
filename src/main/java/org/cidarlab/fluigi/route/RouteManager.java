package org.cidarlab.fluigi.route;

import org.cidarlab.fluigi.layout.Net;
import org.cidarlab.fluigi.layout.ObstacleMap;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RouteManager {

    private static ObstacleMap obstaclemap;

    private static List<Net> orderedRoutingEvents;
    private static List<Net> successes;
    private static List<Net> failures;
    private static ExecutorService threadexecutor;

    public static void setup(ObstacleMap obstacleMap){

        obstaclemap = obstacleMap;
        threadexecutor = Executors.newFixedThreadPool(2);

        orderedRoutingEvents = new ArrayList<>();
        successes = new ArrayList<>();
        failures = new ArrayList<>();
        /*
        TODO: Need to implement the ordering system for the rip-n-reroute
         */
    }

    public void beginRouting(){
        //
        for(Net routingevent : orderedRoutingEvents){
            FlowRouter frouter = new FlowRouter(routingevent, obstaclemap);
            Thread frouterthread = new Thread(frouter);
            threadexecutor.execute(frouterthread);
        }

        try {
            threadexecutor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException ex) {
            throw new UnsupportedOperationException("ERROR ! - Routing threads interrupted.");
        }
    }


}
