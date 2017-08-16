package org.cidarlab.fluigi.netlist;

import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONObject;

import java.util.HashMap;

/**
 * Created by krishna on 3/7/17.
 */
public class TechEntity {

    private String name;

    private String mintname;

    private ComponentType type;

    private HashMap<String, ParameterType> paramsTypes;

    private HashMap<String, Object>  paramDefaults;


    public TechEntity(){
        paramsTypes = new HashMap<>();
        paramDefaults = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void importFromJSON(JSONObject entityjson){
        this.name = (String) entityjson.get("name");
        this.mintname = (String) entityjson.get("mint");
        String typestring = (String) entityjson.get("type");
        switch (typestring){
            case "PRIMITIVE":
                this.type = ComponentType.PRIMITIVE;
                break;
            case "COMPOSITE":
                this.type = ComponentType.COMPOSITE;
                break;
        }
        JSONObject paramtypeshmobject = (JSONObject) entityjson.get("params");

        //go through all the parameter keys and Types
        ParameterType paramtype;
        for(Object key : paramtypeshmobject.keySet()){

            switch ((String) paramtypeshmobject.get(key)){
                case "INT":
                    paramtype = ParameterType.INT;
                    break;
                case "ORIENTATION":
                    paramtype = ParameterType.ORIENTATION;
                    break;
                case "DIRECTION":
                    paramtype = ParameterType.DIRECTION;
                    break;
                case "BOOL":
                    paramtype = ParameterType.BOOL;
                    break;
                default:
                    paramtype = ParameterType.INT;
            }

            paramsTypes.put((String)key, paramtype);

        }

        //TODO: It should go through all the default values for the parameters
    }

    public ParamVerification verifyParam(String parameter, String valuestring){

        //Checking if the parameter is defined in the techfile
        if(paramsTypes.containsKey(parameter)){
            //Parameter is defined in the techfile description
            //Now check for correct type
            ParameterType parameterType = paramsTypes.get(parameter);
            switch (parameterType){
                case INT:
                    if(StringUtils.isNumeric(valuestring)){
                        return ParamVerification.VALID;
                    } else {
                        return ParamVerification.INVALID_VALUE;
                    }
                case BOOL:
                    if("YES" == valuestring || "NO" == valuestring){
                        return ParamVerification.VALID;
                    } else {
                        return ParamVerification.INVALID_VALUE;
                    }
                case DIRECTION:
                    if("LEFT" == valuestring || "RIGHT" == valuestring || "UP" == valuestring || "DOWN" == valuestring){
                        return ParamVerification.VALID;
                    } else {
                        return ParamVerification.INVALID_VALUE;
                    }
                case ORIENTATION:
                    if("V" == valuestring || "H" == valuestring){
                        return ParamVerification.VALID;
                    } else {
                        return ParamVerification.INVALID_VALUE;
                    }
                default:
                    //If the type is wrong
                    return ParamVerification.INVALID_TYPE;
            }
        } else {
            //Parameter is not defined in the techfile description
            return ParamVerification.INVALID_NAME;
        }
    }

    public Object getDefaultParamValue(String paramkey){
        if(!paramDefaults.containsKey(paramkey)){
            return null;
        }
        return paramDefaults.get(paramkey);
    }

    public String getMINTName() {
        return mintname;
    }

    public enum ParamVerification {
        VALID,
        INVALID_NAME,
        INVALID_TYPE,
        INVALID_VALUE
    }

    public enum ParameterType{
        INT,
        ORIENTATION,
        DIRECTION,
        BOOL
    }

    public enum ComponentType{
        PRIMITIVE,
        COMPOSITE
    }


}
