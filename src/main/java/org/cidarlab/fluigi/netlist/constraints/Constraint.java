package org.cidarlab.fluigi.netlist.constraints;

import org.cidarlab.fluigi.geometry.Point;
import org.cidarlab.fluigi.model.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class Constraint {

    public ArrayList<Component> components;

    public Constraint(){
        components = new ArrayList<>();
    }

    public Constraint(List<Component> components) {
        this();
        components.addAll(components);
    }

    public abstract HashMap<Component, Point> getRelativePositions();

    public abstract HashMap<Component, Float> getRelativeRotations();
}
