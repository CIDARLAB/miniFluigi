package org.cidarlab.fluigi.netlist.constraints;

import org.cidarlab.fluigi.layout.Point;
import org.cidarlab.fluigi.model.Component;

import java.util.HashMap;

public class TreeConstraint extends Constraint{
    @Override
    public HashMap<Component, Point> getRelativePositions() {
        throw new UnsupportedOperationException();
    }

    @Override
    public HashMap<Component, Float> getRelativeRotations() {
        throw new UnsupportedOperationException();
    }
}
