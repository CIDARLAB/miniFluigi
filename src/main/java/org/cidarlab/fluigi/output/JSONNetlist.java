/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cidarlab.fluigi.output;

import org.cidarlab.fluigi.core.Parameters;
import org.cidarlab.fluigi.layout.Placement;
import org.cidarlab.fluigi.layout.PlacementCellMapper.CellMapper;
import org.cidarlab.fluigi.layout.PlacementCellMapper.NaiveCellMapper;
import org.cidarlab.fluigi.netlist.DesignTree;
import org.cidarlab.fluigi.netlist.Device;
import org.cidarlab.fluigi.place.simulatedannealing.SAPlacer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import static org.cidarlab.fluigi.core.Parameters.FILE_SEPARATOR;

/**
 *
 * @author krishna
 */
public class JSONNetlist {

    private String outputDirectory;

    public void generateOutput(DesignTree designTree) {
        /*
        TODO:
        1. Go through the design tree and generate all the JSON files for every device
        2. Write write the output for each of these devices
         */
        Iterator<Device> iterator = designTree.iterator();
        InterchangeV1 interchangeV1;
        Device device;
        outputDirectory = Parameters.OUTPUT_DIRECTORY_PATH + designTree.getRootLeaf().getArchiteypedevice().getName()
                + FILE_SEPARATOR;
        Utils.generateFolder(outputDirectory);
        while (iterator.hasNext()) {
            device = iterator.next();
            interchangeV1 =  new InterchangeV1(device);

            try (FileWriter file = new FileWriter(outputDirectory + device.getName() + ".json")) {
                file.write(interchangeV1.getJSONString());
                file.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public void setOutputDirectory(String outputDirectory) {
        this.outputDirectory = outputDirectory;
    }
    
}
