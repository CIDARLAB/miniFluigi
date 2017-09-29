package org.cidarlab.fluigi.netlist.constraints;

import org.cidarlab.fluigi.geometry.Point;
import org.cidarlab.fluigi.netlist.Component;

import java.util.HashMap;

public class GridConstraint extends Constraint {
    @Override
    public HashMap<Component, Point> getRelativePositions() {
        throw new UnsupportedOperationException();
    }

    @Override
    public HashMap<Component, Float> getRelativeRotations() {
        throw new UnsupportedOperationException();
    }
}
