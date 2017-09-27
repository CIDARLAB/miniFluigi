package org.cidarlab.fluigi.netlist;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.commons.lang3.StringUtils;
import org.cidarlab.fluigi.netlist.expressiongrammar.expressiongrammarLexer;
import org.cidarlab.fluigi.netlist.expressiongrammar.expressiongrammarParser;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by krishna on 3/7/17.
 */
public class TechEntity {

    private String name;

    private String mintname;

    private String xspanexpression;

    private String yspanexpression;

    private ComponentType type;

    private HashMap<String, ParameterType> paramsTypes;

    private HashMap<String, String>  paramDefaults;

    private HashMap<String, TechTerminal> terminalHashMap;

    public TechEntity(){
        paramsTypes = new HashMap<>();
        paramDefaults = new HashMap<>();
        terminalHashMap = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void importFromJSON(JSONObject entityjson){
        this.name = (String) entityjson.get("name");
        this.mintname = (String) entityjson.get("mint");
        this.xspanexpression = (String) entityjson.get("xspan");
        this.yspanexpression = (String) entityjson.get("yspan");
        String typestring = (String) entityjson.get("type");
        switch (typestring){
            case "PRIMITIVE":
                this.type = ComponentType.PRIMITIVE;
                break;
            case "COMPOSITE":
                this.type = ComponentType.COMPOSITE;
                break;
            case "SCALING":
                this.type = ComponentType.SCALING;
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

        //Go through all the default values for the parameters
        if(entityjson.containsKey("defaults")) {
            JSONObject tempdefaulvalues = (JSONObject) entityjson.get("defaults");
            for (Object key : tempdefaulvalues.keySet()) {
                String keystring = (String) key;
                paramDefaults.put(keystring, tempdefaulvalues.get(key).toString());
            }
        } else {
            throw new UnsupportedOperationException("Implement warning if there are no default param values");
        }
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

    HashMap<String, String> expressionParams;

    /**
     * Parses the given expression
     * @param stringtoparse
     * @param params
     * @return
     */
    private int parseExpression(String stringtoparse, Map<String, String> params) {
        expressionParams = new HashMap<>();
        expressionParams.putAll(paramDefaults);
        expressionParams.putAll(params);

        ANTLRInputStream expressionParserInput;
        ParseTree tree; // parse
        ParseTreeWalker walker; // create standard walker
        ExpressionParser expressionParser;
        expressiongrammarLexer lexer;
        CommonTokenStream tokens;
        expressiongrammarParser expressiongrammarParser;

        expressionParserInput = new ANTLRInputStream(stringtoparse);
        lexer = new expressiongrammarLexer(expressionParserInput);
        tokens = new CommonTokenStream(lexer);
        expressiongrammarParser = new expressiongrammarParser(tokens);
        tree = expressiongrammarParser.primary_expression();
        walker = new ParseTreeWalker();
        expressionParser = new ExpressionParser();
        expressionParser.setExpressionPrams(expressionParams);
        walker.walk(expressionParser, tree);
        return (int) expressionParser.computeExpression();
    }

    /**
     * Returns the XSpan (Width) of the device
     * @param params
     * @return
     */
    public int getXSpan(Map<String, String> params) {
        return parseExpression(xspanexpression, params);
    }

    /**
     * Returns the Y Span (Length) of the device
     * @param params
     * @return
     */
    public int getYSpan(Map<String, String> params){
        return parseExpression(yspanexpression, params);
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
        COMPOSITE,
        SCALING
    }


}
