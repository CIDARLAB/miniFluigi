package org.cidarlab.fluigi.netlist.constraints;

import org.cidarlab.fluigi.geometry.Point;
import org.cidarlab.fluigi.model.Component;

import java.util.HashMap;
import java.util.List;

public class OrientationConstraint extends Constraint{

    private float rotation;

    public OrientationConstraint(){
        super();
    }

    @Override
    public HashMap<Component, Point> getRelativePositions() {
        throw new UnsupportedOperationException();
    }

    @Override
    public HashMap<Component, Float> getRelativeRotations() {
        throw new UnsupportedOperationException();
    }

    public OrientationConstraint(float rotation,  List<Component> constraintContextComponents) {
       this();
       this.rotation = rotation;
    }
}
