package org.cidarlab.fluigi.netlist.constraints;

import org.cidarlab.fluigi.geometry.Point;
import org.cidarlab.fluigi.model.Component;

import java.util.HashMap;
import java.util.List;

public class BankConstraint extends Constraint{
    private final int spacing;

    public BankConstraint(int componentspacing, List<Component> constraintContextComponents) {
        super(constraintContextComponents);
        this.spacing = componentspacing;
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
