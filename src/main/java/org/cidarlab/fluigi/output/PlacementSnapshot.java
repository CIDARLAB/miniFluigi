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
public class PlacementSnapshot {

    String outputname;

    BufferedImage image;

    public PlacementSnapshot(String name, Placement placement){
        outputname = name;
        image = new BufferedImage(placement.getWidth(), placement.getHeight(), BufferedImage.TYPE_INT_ARGB);

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
        //Draw Rectangles for each of the cells
        for(Cell c : placement.getCells()){
            g2D.drawRect(c.getX(), c.getY(), c.getW(), c.getH());
        }
    }


}
