package org.cidarlab.fluigi.netlist.constraints;

import org.cidarlab.fluigi.geometry.Point;
import org.cidarlab.fluigi.netlist.Component;

import java.util.HashMap;
import java.util.List;

public class GridConstraint extends Constraint {
    public GridConstraint(int horizontalspacing, int verticalspacing, List<Component> constraintContextComponents) {
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
