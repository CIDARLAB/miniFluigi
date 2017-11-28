package org.cidarlab.fluigi.manufacturing.process;

import org.cidarlab.fluigi.manufacturing.Feature;
import org.cidarlab.fluigi.manufacturing.FeatureType;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Softlithography extends ManufacturingOutput {

    @Override
    public void generateDeviceOutput(List<Feature> features) {
        throw new UnsupportedOperationException("Need to implement eps output alg");
    }

    @Override
    protected Graphics2D generateCanvas(int xspan, int yspan, boolean invertx) {
        throw new UnsupportedOperationException("Need to implement the eps canvas generation");
    }

    @Override
    protected void flushCanvas(Graphics2D canvas, String filename) {
        throw new UnsupportedOperationException("Need to implement the eps filewrite");

    }
}
