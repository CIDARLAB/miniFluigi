package org.cidarlab.fluigi.layout;

import org.jgrapht.graph.DefaultEdge;

/**
 * Created by krishna on 7/14/17.
 *
 * I'm gonna assume that each of the layout NETs will have only 1 source and 1 target, this way we make sure that
 * only individual connections will be stored. Not sure if this is the best way though.... Though I had this figured
 * out. So much for me boasting to Doug that I know what the architecture should be.
 *
 * So this will be most basic unit of doing routing, it will replace the routing event system I had in the old codebase
 * and it will be how all the routing is accounted for.
 */
public class Net extends DefaultEdge {

    //I might need to add more information here later on.

    private Point source;
    private Point target;

    @Override
    public Point getSource() {
        return source;
    }

    public void setSource(Point source) {
        this.source = source;
    }

    @Override
    public Point getTarget() {
        return target;
    }

    public void setTarget(Point target) {
        this.target = target;
    }
}
