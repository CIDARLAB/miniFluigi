package org.cidarlab.fluigi.netlist.constraints;

import org.cidarlab.fluigi.geometry.Point;
import org.cidarlab.fluigi.model.Component;

import java.util.HashMap;
import java.util.List;

public class GridConstraint extends Constraint {
    private final int horizontalspacing;
    private final int verticalspacing;

    public GridConstraint(int horizontalspacing, int verticalspacing, List<Component> constraintContextComponents) {
        super(constraintContextComponents);
        this.horizontalspacing = horizontalspacing;
        this.verticalspacing = verticalspacing;
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
