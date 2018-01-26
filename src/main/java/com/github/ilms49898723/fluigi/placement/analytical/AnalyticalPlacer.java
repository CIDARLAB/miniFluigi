package com.github.ilms49898723.fluigi.placement.analytical;

import org.cidarlab.fluigi.layout.Net;
import org.cidarlab.fluigi.layout.Placement;
import org.cidarlab.fluigi.place.Placer;

public class AnalyticalPlacer extends Placer {
    public AnalyticalPlacer() {
        super();
    }

    public AnalyticalPlacer(Placement problem) {
        super();
        loadProblem(problem);
    }

    private void initialize() {
    }

    @Override
    public void place() {
        initialize();
        globalDistribute();
        legalize();
    }

    private void globalDistribute() {

    }

    private void legalize() {

    }
}
