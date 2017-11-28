package org.cidarlab.fluigi.manufacturing.process;

import org.cidarlab.fluigi.core.Parameters;
import org.cidarlab.fluigi.manufacturing.Feature;

import java.awt.*;
import java.util.List;

public abstract class ManufacturingOutput {

    protected String outputdirectory = Parameters.OUTPUT_DIRECTORY_PATH;
    public String devicename;

    public abstract void generateDeviceOutput(List<Feature> features);

    protected abstract Graphics2D generateCanvas(int xspan, int yspan, boolean invertx);

    protected abstract void flushCanvas(Graphics2D canvas, String filename);
}
