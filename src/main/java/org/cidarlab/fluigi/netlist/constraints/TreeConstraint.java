package org.cidarlab.fluigi.netlist.constraints;

import org.cidarlab.fluigi.layout.Point;
import org.cidarlab.fluigi.model.Component;

import java.util.HashMap;
import java.util.List;

public class TreeConstraint extends Constraint{

    public TreeConstraint(List<Component> components){
        super(components);
    }

    @Override
    public HashMap<Component, Point> getRelativePositions() {
        throw new UnsupportedOperationException();
    }

    @Override
    public HashMap<Component, Float> getRelativeRotations() {
        throw new UnsupportedOperationException();
    }
}
