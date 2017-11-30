package org.cidarlab.fluigi.core;

import org.cidarlab.fluigi.manufacturing.FeatureEntity;
import org.cidarlab.fluigi.manufacturing.FeatureLibrary;
import org.cidarlab.fluigi.netlist.technology.TechEntity;
import org.cidarlab.fluigi.netlist.technology.TechLibrary;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.HashMap;

/**
 * Created by krishna on 3/7/17.
 */
public class LibraryManager {
    public static HashMap<String, String> deviceLibrary;

    /**
     * Initializes the applications component and feature libraries
     */
    public static void initLibrary(){
        deviceLibrary = new HashMap<>();
        initTechLibrary();
        initFeatureLibrary();
        //TODO: Read old place and route data

    }

    private static void initFeatureLibrary() {
        FeatureLibrary.instance = new FeatureLibrary("mint");

        /*
        Read through the directory and create new feature entities that have to be loaded.
         */
        File featurelibrarfolder = new File(Parameters.FEATURE_LIBRARY_PATH);
        if(!featurelibrarfolder.exists()){
            throw new UnsupportedOperationException("Cannot find feature library folder");
        }

        FeatureEntity featureEntity;
        JSONParser parser;
        System.out.println("Read FEATURE_LIBRARY Directory:");
        System.out.println("Building Feature Library:");
        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return (pathname.isFile() && pathname.getName().endsWith(".json"));
            }
        };

        for(File featurefile : featurelibrarfolder.listFiles(filter)){
            try{
                featureEntity = new FeatureEntity();
                parser = new JSONParser();
                JSONObject featurejson = (JSONObject)parser.parse(new FileReader(featurefile));
                featureEntity.importFromJSON(featurejson);
                FeatureLibrary.instance.addEntity(featureEntity);
                System.out.println("--> Added: " + featurefile.getName());
            } catch (ParseException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void initTechLibrary() {
        TechLibrary.instance = new TechLibrary("mint");
        /*
        Read through the directory and create new tech entities that have to be loaded.
         */

        File techlibraryfolder = new File(Parameters.TECH_LIBRARY_PATH);
        if(!techlibraryfolder.exists()){
            System.err.println("Cannot find the techlibrary folder");
            System.exit(ErrorCodes.TECH_LIBRARY_NOT_FOUND);
        }

        TechEntity techEntity;
        JSONParser parser;
        System.out.println("Read TECH_LIBRARY Directory:");
        System.out.println("Building Tech Library:");
        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return (pathname.isFile() && pathname.getName().endsWith(".json"));
            }
        };

        for(File techfile : techlibraryfolder.listFiles(filter)){
            try {
                techEntity = new TechEntity();
                parser = new JSONParser();
                JSONObject entityjson = (JSONObject)parser.parse(new FileReader(techfile));
                techEntity.importFromJSON(entityjson);
                TechLibrary.instance.addEntity(techEntity);
                System.out.println("--> Added: "+ techfile.getName());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}
