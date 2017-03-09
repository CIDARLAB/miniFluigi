package org.cidarlab.minifluigi.netlist;

import org.json.simple.JSONObject;

import java.io.File;
import java.util.HashMap;

/**
 * Created by krishna on 3/7/17.
 */
public class TechEntity {

    private String name;
    private HashMap<String, String> parameters;
    private Component.ComponentType type;

    public String getName() {
        return name;
    }

    public TechEntity(){
        parameters = new HashMap<>();
    }

    public TechEntity(JSONObject entityjson){
        this();
        importFromJSON(entityjson);
    }

    public void importFromJSON(JSONObject entityjson){
        this.name = (String) entityjson.get("name");
        switch ((String)entityjson.get("type")){
            case "PRIMITIVE":
                this.type = Component.ComponentType.PRIMITIVE;
                break;
            case "COMPOSITE":
                this.type = Component.ComponentType.COMPOSITE;
                break;
        }
        JSONObject parametersobject = (JSONObject) entityjson.get("params");
        for(Object key : parametersobject.keySet()){
            parameters.put((String)key, (String)parametersobject.get(key));
        }
    }
}
