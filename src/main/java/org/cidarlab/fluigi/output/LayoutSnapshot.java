package org.cidarlab.fluigi.output;

import org.cidarlab.fluigi.core.Parameters;
import org.cidarlab.fluigi.layout.Cell;
import org.cidarlab.fluigi.layout.Placement;
import org.jfree.graphics2d.svg.SVGGraphics2D;
import org.jfree.graphics2d.svg.SVGUnits;
import org.jfree.graphics2d.svg.SVGUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by krishna on 8/1/17.
 */
public class LayoutSnapshot {

    private String outputname;
    SVGGraphics2D snapshot;

    public LayoutSnapshot(String name, Placement placement){
        System.out.println("Writing the SVG snapshot....");
        outputname = name;
        //Calculate the YWIDTH for a given XWIDTH
        System.out.println("X-Span: " + placement.getXSpan());
        System.out.println("Y-Span: " + placement.getYSpan());
        snapshot = new SVGGraphics2D(placement.getXSpan(), placement.getYSpan());
        generateImage(placement);
        writeOutput();
    }

    private void writeOutput() {
        try{
            File outputfile = new File(Parameters.OUTPUT_DIRECTORY_PATH + System.getProperty("file.separator")
                    + outputname + ".svg" );
            SVGUtils.writeToSVG(outputfile, snapshot.getSVGElement());
//            BufferedWriter writer = new BufferedWriter(new FileWriter(outputfile));
//            writer.write(svgtext);

        }catch (IOException e){
            System.err.println("Error in writing the file output");
            System.exit(-1);
        }
    }

    private void generateImage(Placement placement) {
        Graphics2D g2D = snapshot;
        snapshot.setColor(Color.GREEN);
        System.out.println("Print Corner Markers");
        g2D.fillRect(0,0,1000,1000); //Top left mark
        g2D.fillRect(placement.getXSpan() - 1000,0,1000,1000); //Top right
        g2D.fillRect(0,placement.getYSpan() - 1000,1000,1000); //bottom left
        g2D.fillRect(placement.getXSpan() - 1000,placement.getYSpan() - 1000,1000,1000); //bottom right
        //TODO: scale the device correctly
        //Draw Rectangles for each of the cells
        snapshot.setColor(Color.BLUE);
        System.out.println("Print each of the layout cells:");
        for(Cell c : placement.getCells()){
            System.out.println("--> X: " + c.getX() + " Y: " + c.getY() + " X-Span: " + c.getXspan() + " Y-Span: "
                    + c.getYspan());
            g2D.fillRect(c.getX(), c.getY(), c.getXspan(), c.getYspan());
        }
    }


}
