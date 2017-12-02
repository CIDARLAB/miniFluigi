package org.cidarlab.fluigi.manufacturing.process;

import com.sun.xml.internal.ws.config.metro.dev.FeatureReader;
import org.cidarlab.fluigi.manufacturing.DrawLayer;
import org.cidarlab.fluigi.manufacturing.Feature;

import java.awt.*;
import java.util.List;

public class Softlithography3 extends ManufacturingOutput {

    public static final double EPS_DEFULT_PT_TO_UM = 0.00283464567; //TODO:UPDATE THIS ASAP
    private static final int WAFER_X_SPAN = 65000;
    private static final int WAFER_Y_SPAN = 65000;

    private List<Feature> cellfeatures;
    private List<Feature> flowfeatures;
    private List<Feature> controlfeatures;

    Graphics2D epscanvas;

    @Override
    public void generateDeviceOutput(List<DrawLayer> drawLayers) {
        /*
        TODO: Go through each of the draw layers, then based on wether the draw layer is control or not make the features
         */

        /*
        Prepare the canvas. Every layerblock goes into a different wafer
        Step 1: Get all cell features
        Step 2: Get all the flow features
        Step 3: Get all the edge features
         */

        generateCanvas(WAFER_X_SPAN, WAFER_Y_SPAN, true);

        List<Feature> features;

        for(DrawLayer drawlayer : drawLayers){
            features = drawlayer.getFeatures();

            for(Feature feature : features){
                if(drawlayer.getParam("type").equals("CONTROL")){
                    drawControl(feature);
                }else if(drawlayer.getParam("type").equals("FLOW")){
                    drawFlow(feature);
                }else if(drawlayer.getParam("type").equals("FLOW")) {
                    drawCell(feature);
                }else {
                    throw new UnsupportedOperationException("Draw layer is missing a \"type\" parameter");
                }
            }
        }
    }

    private void drawCell(Feature feature) {
        //TODO: Translate on canvas
        epscanvas.scale(-EPS_DEFULT_PT_TO_UM, EPS_DEFULT_PT_TO_UM);
        //TODO: cycle through replicate points
        //TODO: Do the draw function
        //TODO: Undo translate on canvas

        throw new UnsupportedOperationException();


    }

    private void drawFlow(Feature feature) {
        //TODO: Translate on canvas
        //TODO: cycle through replicate points
        //TODO: Do the draw function
        //TODO: Undo translate on canvas

        throw new UnsupportedOperationException();


    }

    private void drawControl(Feature feature) {
        //TODO: Translate on canvas
        //TODO: cycle through replicate points
        //TODO: Do the draw function
        //TODO: Undo translate on canvas

        throw new UnsupportedOperationException();


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
