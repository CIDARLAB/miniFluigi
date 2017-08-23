/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cidarlab.fluigi.output;

import org.cidarlab.fluigi.netlist.DesignTree;

import java.io.File;

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
         */
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setOutputDirectory(String outputDirectory) {
        this.outputDirectory = outputDirectory;
    }
    
}
