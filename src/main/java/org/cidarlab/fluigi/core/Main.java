/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cidarlab.fluigi.core;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.commons.cli.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.cidarlab.fluigi.layout.Placement;
import org.cidarlab.fluigi.layout.PlacementCellMapper.CellMapper;
import org.cidarlab.fluigi.layout.PlacementCellMapper.NaiveCellMapper;
import org.cidarlab.fluigi.netlist.mintgrammar.mintgrammarLexer;
import org.cidarlab.fluigi.netlist.mintgrammar.mintgrammarParser;
import org.cidarlab.fluigi.netlist.DesignTree;
import org.cidarlab.fluigi.netlist.Device;
import org.cidarlab.fluigi.netlist.JSONNetlistParser;
import org.cidarlab.fluigi.netlist.mintnetlistparser.MINTNetlistParser;
import org.cidarlab.fluigi.output.JSONNetlist;
import org.cidarlab.fluigi.place.simulatedannealing.SAPlacer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author krishna
 */
public class Main {

    private static String paramPathName;
    private static String outputDirectory;
    private static boolean isDebugPrintEnabled;

    private static List<String> inputPaths = new ArrayList<>();

    private static Logger logger = LogManager.getRootLogger();

    /**
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
     * @param options <p>
     *                <p>
     *                <p>
     */
    private static void outputCommandLineHelp(final Options options) {
        final HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("fluigi <filenames> [-i <initialization_file>] [-o output directory] [-f output format]", options);
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

            //Set the output directory parameter
            Parameters.OUTPUT_DIRECTORY_PATH = outputDirectory;
        }


        isDebugPrintEnabled = cl.hasOption("debug");

        if ((null != cl) && cl.hasOption("help")) {
            outputCommandLineHelp(options);
        }

        inputPaths.addAll(cl.getArgList());

        System.out.println("InputFiles to be processed");
        for (String inpuname : inputPaths) {
            System.out.println(inpuname);
        }

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

        DesignTree designTree = new DesignTree();

        //Loading the Libraries for MiniFluigeeeeee
        logger.info("Initializing Library Manager");
        LibraryManager.initLibrary();
        Device device;


        for (String inputpathname : inputPaths) {
            File inputfile = new File(inputpathname);
            if (!inputfile.exists()) {
                System.err.println("Input file does not exist");
                System.exit(ErrorCodes.INPUT_FILE_NOT_FOUND);
            }

            if (inputfile.getName().endsWith("json")) {
                JSONNetlistParser jsonparser = new JSONNetlistParser(inputpathname);
                device = jsonparser.generateDevice();
            } else {
                ANTLRInputStream input = null;
                try {
                    System.out.println("Parsing File: " + inputpathname);
                    input = new ANTLRFileStream(inputpathname);
                } catch (IOException ex) {
                    System.exit(ErrorCodes.INPUT_FILE_NOT_FOUND);
                }
                mintgrammarLexer lexer = new mintgrammarLexer(input);
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                mintgrammarParser mintparser = new mintgrammarParser(tokens);
                ParseTree tree = mintparser.netlist(); // parse
                ParseTreeWalker walker = new ParseTreeWalker(); // create standard walker

                // Pass the delgate instance of the designtree so that it can access the device list
                MINTNetlistParser fluigiNetlistParser = new MINTNetlistParser();
                walker.walk(fluigiNetlistParser, tree);
                device = fluigiNetlistParser.getDevice();
                designTree.addDevice(device);
            }

        }


       /*
        TODO: Integrate Design tree, iterate through the designs and then
        recursively do the place and route.
        */

        //This will generate the design tree
        designTree.generateDesignTree();

        //Now we will have an iterator that will give us each of the devices
        Iterator<Device> iterator = designTree.iterator();
        List<Placement> placementproblems;
        CellMapper cellMapper;
        while (iterator.hasNext()) {
            device = iterator.next();
            cellMapper = new NaiveCellMapper(device);
            placementproblems = cellMapper.generateLayouts();

            for (Placement placementproblem : placementproblems) {
                SAPlacer placer = new SAPlacer();

                placer.loadProblem(placementproblem);

                placer.place();

                /*
                TODO: Create a verification system to ensure that the placement is working correctly.
                */

                cellMapper.importLayout(placementproblem);
            }

        }


        /*
        TODO: Do routing for each of the routes. Call and implement the flowrouter.
        */

        JSONNetlist output = new JSONNetlist();
        output.setOutputDirectory(Parameters.OUTPUT_DIRECTORY_PATH);
        output.generateOutput(designTree);
    }
}
