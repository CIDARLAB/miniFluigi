package org.cidarlab.fluigi.output;

import org.cidarlab.fluigi.core.Parameters;
import org.cidarlab.fluigi.layout.Cell;
import org.cidarlab.fluigi.layout.Placement;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by krishna on 8/1/17.
 */
public class LayoutSnapshot {

    String outputname;

    BufferedImage image;

    //These will be the image sizes
    final int XWIDTH = 500;
    int YWIDTH;
    double SCALE_FACTOR; //IT would be the same for both x and y because the image is scale with the aspect ratio



    public LayoutSnapshot(String name, Placement placement){
        outputname = name;
        //Calculate the YWIDTH for a given XWIDTH
        float aspectratio = placement.getWidth()/placement.getHeight();
        YWIDTH = Math.round(XWIDTH/aspectratio);
        SCALE_FACTOR = XWIDTH/placement.getWidth();
        image = new BufferedImage(XWIDTH, YWIDTH, BufferedImage.TYPE_INT_ARGB);
        generateImage(placement);
        writeOutput();
    }

    private void writeOutput() {
        try{
            File outputfile = new File(Parameters.OUTPUT_DIRECTORY_PATH + System.getProperty("file.separator")
                    + outputname + ".png" );
            ImageIO.write(image, "png", outputfile);
        }catch (IOException e){
            System.err.println("Error in writing the file output");
            System.exit(-1);
        }
    }

    private void generateImage(Placement placement) {
        Graphics2D g2D = image.createGraphics();
        //TODO: scale the device correctly
        g2D.scale(SCALE_FACTOR, SCALE_FACTOR);
        //Draw Rectangles for each of the cells
        for(Cell c : placement.getCells()){
            g2D.drawRect(c.getX(), c.getY(), c.getXspan(), c.getYspan());
        }
    }


}
