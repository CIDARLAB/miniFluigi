package org.cidarlab.fluigi.place;

import org.cidarlab.fluigi.layout.Placement;

/**
 * Created by krishna on 3/7/17.
 */
public abstract class Placer {

    protected Placement problem;

    public void loadProblem(Placement placementproblem){
        this.problem = placementproblem;
    }

    abstract public void place();
}
