package org.cidarlab.minifluigi.core;

import org.cidarlab.minifluigi.netlist.TechEntity;
import org.cidarlab.minifluigi.netlist.TechLibrary;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by krishna on 3/7/17.
 */
public class LibraryManager {
    /**
     * TODO: Generate the execution and the entity library.
     */

    public static TechLibrary techlibrary = new TechLibrary("MINT");

    public static Object DesignLibrary;

    public static void loadLibraryFromDiskLocation(String filepath){
        /*
        Step 1: Iterate through the folder and eat all the entity JSONs
        Step 2: Parse the entity JSONs
        Step 3: Build up the library
         */



        File techlibraryfolder = new File(filepath);

        if(!techlibraryfolder.exists()){
            System.exit(ErrorCodes.TECH_LIBRARY_NOT_FOUND);
        }

        FileFilter filter = pathname -> pathname.getName().endsWith(".json") ? true : false;

        JSONParser parser = new JSONParser();
        JSONObject entityjson;
        TechEntity techEntity;

        for(File f : techlibraryfolder.listFiles(filter)){
            System.out.println(f.getName());
            try {
                entityjson = (JSONObject) parser.parse(new FileReader(f));
                techEntity = new TechEntity(entityjson);
                techlibrary.addEntity(techEntity);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

}
