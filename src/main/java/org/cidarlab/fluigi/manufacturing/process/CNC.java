package org.cidarlab.fluigi.manufacturing.process;

import org.cidarlab.fluigi.manufacturing.Feature;
import org.cidarlab.fluigi.manufacturing.FeatureType;
import org.jfree.graphics2d.svg.SVGGraphics2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CNC extends ManufacturingOutput {

    public static final double SVG_DEFAULT_PT_TO_UM = 0.00283464567;

    private final int xspan;
    private final int yspan;

    private List<Feature> zfeatures;
    private List<Feature> edgefeatures;
    private List<Feature> xyfeatures;
    private List<Feature> xyzfeatures;

    public CNC(int xspan, int yspan){
        this.xspan = xspan;
        this.yspan = yspan;
    }

    Color drawcolor;

    @Override
    public void generateDeviceOutput(List<Feature> features) {
        /*
        Step 1: Get all the Z features
        Step 2: Get the EDGE features
        Step 3: Get all the XY features
        Step 4: Get all the XYZ features
         */
        zfeatures = new ArrayList<>();
        edgefeatures = new ArrayList<>();
        xyfeatures = new ArrayList<>();
        xyzfeatures = new ArrayList<>();

        for (Feature feature: features) {
            switch (feature.getType()){
                case EDGE:
                    edgefeatures.add(feature);
                    break;
                case XY:
                    xyfeatures.add(feature);
                    break;
                case Z:
                    zfeatures.add(feature);
                    break;
                case XYZ:
                    xyzfeatures.add(feature);
                    break;
            }
        }

        drawEdges();
        drawPorts(false);
        drawHeightLayers(false);
        generateSTLs();
    }

    @Override
    protected Graphics2D generateCanvas(int xspan, int yspan, boolean invertx){
        SVGGraphics2D svgcanvas = new SVGGraphics2D(xspan, yspan);
        svgcanvas.setGeometryDP(10);
        if(invertx){
            svgcanvas.scale(SVG_DEFAULT_PT_TO_UM, SVG_DEFAULT_PT_TO_UM);
        }else{
            svgcanvas.scale(-SVG_DEFAULT_PT_TO_UM, SVG_DEFAULT_PT_TO_UM);
        }

        return svgcanvas;
    }

    private void generateSTLs() {
        throw new UnsupportedOperationException("Need to add methods to generate / do the STLs");

    }

    private void drawHeightLayers(boolean iscontrol) {
        //TODO: Do the 2.5D alg
        throw new UnsupportedOperationException("Implement the 2.5D algorithm");


    }

    private void drawPorts(boolean iscontrol) {
        //TODO: Draw the ports
        Graphics2D svgcanvas = generateCanvas(xspan, yspan, iscontrol);

        for (Feature feature : zfeatures) {
            svgcanvas.translate(feature.getX(), feature.getY());
            // Need to draw stuff
            svgcanvas.translate(-feature.getX(), -feature.getY());
        }
    }

    private void drawEdges() {
        //TODO: Draw the edges
        throw new UnsupportedOperationException("Draw the edges");
    }
}
