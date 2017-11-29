package org.cidarlab.fluigi.manufacturing.process;

import org.cidarlab.fluigi.manufacturing.Feature;
import org.jfree.graphics2d.svg.SVGGraphics2D;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.awt.BasicStroke.CAP_ROUND;
import static java.awt.BasicStroke.JOIN_ROUND;

public class CNC extends ManufacturingOutput {

    public static final double SVG_DEFAULT_PT_TO_UM = 0.00283464567;

    private final int xspan;
    private final int yspan;

    private List<Feature> zfeatures;
    private List<Feature> edgefeatures;
    private List<Feature> xyfeatures;
    private List<Feature> xyzfeatures;

    public CNC(String devicename, int xspan, int yspan){
        this.xspan = xspan;
        this.yspan = yspan;
        this.devicename = devicename;
    }

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

        drawEdges(false);
        drawEdges(true);
        drawPorts(false);
        drawPorts(true);
        drawHeightLayers(false);
        drawHeightLayers(true);
        generateSTLs();
    }

    @Override
    protected Graphics2D generateCanvas(int xspan, int yspan, boolean iscontrol){
        SVGGraphics2D svgcanvas = new SVGGraphics2D(xspan, yspan);
        svgcanvas.setGeometryDP(10);
        if(iscontrol){
            svgcanvas.scale(SVG_DEFAULT_PT_TO_UM, SVG_DEFAULT_PT_TO_UM);
            svgcanvas.setColor(Color.RED);
        }else{
            svgcanvas.scale(-SVG_DEFAULT_PT_TO_UM, SVG_DEFAULT_PT_TO_UM);
            svgcanvas.setColor(Color.BLUE);
        }

        return svgcanvas;
    }

    @Override
    protected void flushCanvas(Graphics2D canvas, String filename) {
        String fullfilename = outputdirectory + System.getProperty("file.separator") +
                filename + ".svg";
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fullfilename));
            String svgtext = ((SVGGraphics2D)canvas).getSVGDocument();
            bufferedWriter.write(svgtext);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void generateSTLs() {
        throw new UnsupportedOperationException("Need to add methods to generate / do the STLs");

    }

    private void drawHeightLayers(boolean iscontrol) {
        //Do the 2.5D alg

        //Sort the features based on height
        int z_val = 0;
        Graphics2D svgcanvas;
        HashMap<Integer, List<Feature>> depthmap = new HashMap<>();
        List<Feature> featurelist;
        for(Feature feature : xyfeatures){
            z_val = feature.getHeight();
            if(depthmap.containsKey(z_val)){
                featurelist = depthmap.get(z_val);
            } else {
                featurelist = new ArrayList<>();
                depthmap.put(z_val, featurelist);
            }
            featurelist.add(feature);
        }

        //Now that all the features are sorted, they need to be pushed into the respective
        //output layers so cycle through each of the feature lists and generate the SVG.

        for (int key : depthmap.keySet()) {
            featurelist = depthmap.get(key);
            svgcanvas = generateCanvas(xspan, yspan, iscontrol);
            for (Feature feature : featurelist) {
                svgcanvas.translate(feature.getX(), feature.getY());
                //TODO: Need to draw stuff
                svgcanvas.translate(-feature.getX(), -feature.getY());
            }
            String layertype = (iscontrol)?"control":"flow";
            flushCanvas(svgcanvas, this.devicename + "_" + layertype + "_" + z_val);
        }

    }

    private void drawPorts(boolean iscontrol) {
        //Draw the ports
        Graphics2D svgcanvas = generateCanvas(xspan, yspan, iscontrol);

        for (Feature feature : zfeatures) {
            svgcanvas.translate(feature.getX(), feature.getY());
            //TODO: Need to draw stuff
            svgcanvas.translate(-feature.getX(), -feature.getY());
        }
        String layertype = (iscontrol)?"control":"flow";
        flushCanvas(svgcanvas, this.devicename + "_" + layertype + "_ports");
    }

    private void drawEdges(boolean iscontrol) {
        //TODO: Update this to draw polyline edges
        Graphics2D svgcanvas = generateCanvas(xspan, yspan, iscontrol);

        float strokeWidth = 5;
        Stroke box = new BasicStroke(strokeWidth, CAP_ROUND, JOIN_ROUND);
        Stroke curStroke = svgcanvas.getStroke();
        svgcanvas.setStroke(box);
        svgcanvas.drawRect(0, 0, xspan, yspan);
        svgcanvas.setStroke(curStroke);

        String layertype = (iscontrol)?"control":"flow";
        flushCanvas(svgcanvas, this.devicename + "_" + layertype + "_edge");
    }
}
