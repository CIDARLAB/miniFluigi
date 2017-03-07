/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cidarlab.minifluigi.core;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.cidarlab.minifluigi.layout.Placement;
import org.cidarlab.minifluigi.netlist.Device;
import org.cidarlab.minifluigi.netlist.JSONNetlistParser;
import org.cidarlab.minifluigi.output.JSONNetlist;
import org.cidarlab.minifluigi.place.UCRPlacer;

/**
 *
 * @author krishna
 */
public class Main {

    private static String paramPathName;
    private static String outputDirectory;
    private static boolean isDebugPrintEnabled;
    private static String inputPathName;

    /**
     *
     * @return
     */
    private static Options createCommandLineOptions() {
        final Options options = new Options();
        options.addOption("i", "init", true, "Give the initialization (*.ini) file, 3D initalization (*_3d.ini) file.");
        options.addOption("o", "out", true, "Specify the output directory, Defaults to the output folder");
        options.addOption("h", "help", false, "Show help information.");
        options.addOption("d", "debug", false, "This enables all the debug printing");
        options.addOption("c", "cello", false, "This enables Cello Mode of operation");
        options.addOption("u", "user", true, "Give the username");
        options.addOption("p", "pass", true, "Give the password");
        options.addOption("x", "convert", false, "This enables the MINT conversion mode");
        return options;
    }

    /**
     *
     * @param options
     * <p>
     * <p>
     * <p>
     */
    private static void outputCommandLineHelp(final Options options) {
        final HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("fluigi <filename> [-i <initialization_file>] [-o output directory] [-f output format]", options);
        System.exit(0);
    }

    private static void processCommandline(final CommandLine cl, Options options) throws IllegalArgumentException {

        if ((null != cl) && cl.hasOption("init")) {
            paramPathName = cl.getOptionValue("init");
            if (null == paramPathName) {
                System.exit(ErrorCodes.MISSING_ARG_VALUES);
            }
        }

        if ((null != cl) && cl.hasOption("out")) {
            //outputFormat = cl.getOptionValue("out").toLowerCase();
            outputDirectory = cl.getOptionValue("out");
            if (null == outputDirectory) {
                System.exit(ErrorCodes.MISSING_ARG_VALUES);
            }
        }


        isDebugPrintEnabled = cl.hasOption("debug");

        if ((null != cl) && cl.hasOption("help")) {
            outputCommandLineHelp(options);
        }

        inputPathName = cl.getArgs()[0];

        System.out.println(inputPathName);

    }

    public static void main(String[] args) {
        final Options options = createCommandLineOptions();

        CommandLineParser parser = new DefaultParser();

        if (0 == args.length) {
                outputCommandLineHelp(options);
                System.exit(ErrorCodes.NO_ARGS);
        } else {
            try {
                // parse the command line arguments
                CommandLine cl = parser.parse(options, args);
                processCommandline(cl, options);
            } catch (ParseException exp) {
                // oops, something went wrong
                System.err.println("Parsing failed.  Reason: " + exp.getMessage());
                System.exit(ErrorCodes.BAD_ARGS);
            }
        }
        
        JSONNetlistParser jsonparser = new JSONNetlistParser(inputPathName);
        
        Device device = jsonparser.generateDevice();
        
       /*
        TODO: Integrate Design tree, iterate through the designs and then 
        recursively do the place and route.
        */
        
        Placement placementproblem = device.getPlacement();
        
        UCRPlacer placer = new UCRPlacer();
        
        placer.loadProblem(placementproblem);
        
        placer.place();
        
        /*
        Create a verification system to ensure that the placement is working correctly.
        */
        
        device.loadPlacement(placementproblem);
        
        /*
        TODO: Do routing for each of the routes. Call and implement the flowrouter.
        */
        
        JSONNetlist output = new JSONNetlist();
        output.setOutputDirectory(outputDirectory);
        output.generateOutput(device);
    }
}
