package org.cidarlab.minifluigi.place;

import org.cidarlab.minifluigi.layout.Placement;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

/**
 * Created by krishna on 3/7/17.
 */
public abstract class Placer {

    Placement problem;

    public void loadProblem(Placement placementproblem){
        this.problem = placementproblem;
    }

    abstract void place();
}
