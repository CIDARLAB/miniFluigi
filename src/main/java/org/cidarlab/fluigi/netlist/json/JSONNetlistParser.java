/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cidarlab.fluigi.netlist.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.cidarlab.fluigi.model.Component;
import org.cidarlab.fluigi.model.Connection;
import org.cidarlab.fluigi.model.Device;
import org.cidarlab.fluigi.model.LogicalLayer;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author krishna
 */
public class JSONNetlistParser {

    JSONObject netlistJSONObject;
    Device device;

    public JSONNetlistParser(String filepath) {
        JSONParser parser = new JSONParser();

        try {
            netlistJSONObject = (JSONObject) parser.parse(new FileReader(filepath));

        } catch (FileNotFoundException ex) {
            Logger.getLogger(JSONNetlistParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JSONNetlistParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(JSONNetlistParser.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Device generateDevice() {

        device = new Device(getName(netlistJSONObject));
        device.setComments(getComments(netlistJSONObject));

        //Extract Layers
        extractLayers();

        //Extract Components
        extractComponents();

        //Extract Connections
        extractConnections();
                
        return device;
    }

    /*
    Extraction Helpers
     */
    private void extractLayers() {
        /*
        Cycle through all the layers in the json
         */
        JSONArray layersArray = (JSONArray) netlistJSONObject.get("layers");
        for (Iterator it = layersArray.iterator(); it.hasNext();) {
            JSONObject jsonlayer = (JSONObject) it.next();
            LogicalLayer layer = new LogicalLayer(getID(jsonlayer));
            layer.importFromJSON(jsonlayer);
            device.addLayer(layer);
        }
    }

    private void extractComponents() {
        /*
        Cycle through all the components in the json 
        add them to the device
         */
        JSONArray componentsArray = (JSONArray) netlistJSONObject.get("components");

        for (Iterator it = componentsArray.iterator(); it.hasNext();) {
            JSONObject jsoncomponent = (JSONObject) it.next();
            Component component = new Component(getID(jsoncomponent));
            component.importFromJSON(jsoncomponent);
            device.addComponent(component, (String)jsoncomponent.get("layer"));
        }
    }

    private void extractConnections() {
        JSONArray layersArray = (JSONArray) netlistJSONObject.get("connections");
        for (Iterator it = layersArray.iterator(); it.hasNext();) {
            JSONObject jsonconnection = (JSONObject) it.next();
            Connection connection = new Connection(getID(jsonconnection));
            connection.importFromJSON(jsonconnection);
            device.addConnection(connection, (String)jsonconnection.get("layer"));
        }
    }

    /*
    Trivial Helpers
     */
    private String getComments(JSONObject netlistJSONObject) {
        return (String) netlistJSONObject.get(JSONKeyWords.COMMENTS);
    }

    private String getName(JSONObject netlistJSONObject) {
        return (String) netlistJSONObject.get(JSONKeyWords.NAME);
    }
    
    private String getID(JSONObject netlistJSONObject) {
        return (String) netlistJSONObject.get(JSONKeyWords.ID);
    }


}
