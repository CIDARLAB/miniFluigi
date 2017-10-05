package org.cidarlab.fluigi.core;

import org.cidarlab.fluigi.netlist.TechEntity;
import org.cidarlab.fluigi.netlist.TechLibrary;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by krishna on 3/7/17.
 */
public class LibraryManager {
    /**
     * TODO: Generate the execution and the entity library.
     */

    public static TechLibrary techLibrary;
    public static HashMap<String, String> deviceLibrary;

    public static void initLibrary(){
        deviceLibrary = new HashMap<>();
        techLibrary = new TechLibrary("mint");
        /*
        TODO: Read through the directory and create new tech entities that have to be loaded.
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
                techLibrary.addEntity(techEntity);
                System.out.println("--> Added: "+ techfile.getName());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        //TODO: Read old place and route data

    }
}
