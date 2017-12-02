package org.cidarlab.fluigi.netlist.technology;

import com.sun.istack.internal.NotNull;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.commons.lang3.StringUtils;
import org.cidarlab.fluigi.model.Terminal;
import org.cidarlab.fluigi.netlist.expressiongrammar.expressiongrammarLexer;
import org.cidarlab.fluigi.netlist.expressiongrammar.expressiongrammarParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.*;

import static org.cidarlab.fluigi.netlist.technology.TechEntity.TechEntityType.*;

/**
 * Created by krishna on 3/7/17.
 */
public class TechEntity {

    private String name;

    private String mintname;

    private String xspanexpression;

    private String yspanexpression;

    private TechEntityType type;

    private HashMap<String, ParameterType> paramsTypes;

    private HashMap<String, String> paramDefaults;

    private HashMap<String, TechTerminal> terminalHashMap;

    public TechEntity() {
        paramsTypes = new HashMap<>();
        paramDefaults = new HashMap<>();
        terminalHashMap = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void importFromJSON(JSONObject entityjson) {
        this.name = (String) entityjson.get("name");
        this.mintname = (String) entityjson.get("mint");
        this.xspanexpression = (String) entityjson.get("xspan");
        this.yspanexpression = (String) entityjson.get("yspan");
        String typestring = (String) entityjson.get("type");
        switch (typestring) {
            case "PRIMITIVE":
                this.type = PRIMITIVE;
                break;
            case "COMPOSITE":
                this.type = COMPOSITE;
                break;
            case "SCALING":
                this.type = SCALING;
                break;
            case "FEATURE":
                this.type = FEATURE;
                break;
        }
        JSONObject paramtypeshmobject = (JSONObject) entityjson.get("params");

        //go through all the parameter keys and Types
        ParameterType paramtype;
        for (Object key : paramtypeshmobject.keySet()) {

            switch ((String) paramtypeshmobject.get(key)) {
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

            paramsTypes.put((String) key, paramtype);

        }

        //Go through all the default values for the parameters
        if (entityjson.containsKey("defaults")) {
            JSONObject tempdefaulvalues = (JSONObject) entityjson.get("defaults");
            for (Object key : tempdefaulvalues.keySet()) {
                String keystring = (String) key;
                paramDefaults.put(keystring, tempdefaulvalues.get(key).toString());
            }
        } else {
            throw new UnsupportedOperationException("Implement warning if there are no default param values");
        }

        //Import all the design rules into the default params
        if (this.type != FEATURE) {

            if (entityjson.containsKey("designRules")) {
                JSONObject tempdesignrules = (JSONObject) entityjson.get("designRules");
                for (Object key : tempdesignrules.keySet()) {
                    String keystring = (String) key;
                    paramDefaults.put(keystring, tempdesignrules.get(key).toString());
                }
            } else {
                throw new UnsupportedOperationException("Implement warning if there are no design rules");
            }
        }

        //Import all the terminal information if its a composite or a primitive, there needs to be more mojo if its scaling
        if (this.type == COMPOSITE || this.type == PRIMITIVE) {
            if (entityjson.containsKey("terminals")) {
                JSONArray terminalarray = (JSONArray) entityjson.get("terminals");
                Iterator it = terminalarray.listIterator();
                while (it.hasNext()) {
                    JSONObject terminalobject = (JSONObject) it.next();
                    TechTerminal techTerminal = new TechTerminal((String) terminalobject.get("label")); //Sets the label
                    techTerminal.setXposexpression((String) terminalobject.get("x"));
                    techTerminal.setYposexpression((String) terminalobject.get("y"));
                    techTerminal.setLayer((String) terminalobject.get("layer"));

                    this.terminalHashMap.put(techTerminal.getLabel(), techTerminal);
                }
            }
        } else if (this.type == SCALING) {
            if (entityjson.containsKey("terminals")) {
                JSONArray terminalarray = (JSONArray) entityjson.get("terminals");
                Iterator it = terminalarray.listIterator();
                while (it.hasNext()) {
                    JSONObject terminalobject = (JSONObject) it.next();
                    TechTerminal techTerminal = new TechTerminal(
                            (String) terminalobject.get("start")
                                    + terminalobject.get("label") + terminalobject.get("end")
                    ); //Sets the label
                    techTerminal.setXposexpression((String) terminalobject.get("x"));
                    techTerminal.setYposexpression((String) terminalobject.get("y"));
                    techTerminal.setLayer((String) terminalobject.get("layer"));
                    techTerminal.setStart((String) terminalobject.get("start"));
                    techTerminal.setEnd((String) terminalobject.get("end"));
                    techTerminal.setLabelexpression((String) terminalobject.get("label"));

                    this.terminalHashMap.put(techTerminal.getLabel(), techTerminal);
                }
            }
        } else if (this.type == FEATURE) {
            //Noop
        } else {
            throw new UnsupportedOperationException("Unsupported component type");
        }

    }

    public ParamVerificationResult verifyParam(String parameter, String valuestring) {

        //Checking if the parameter is defined in the techfile
        if (paramsTypes.containsKey(parameter)) {
            //Parameter is defined in the techfile description
            //Now check for correct type
            ParameterType parameterType = paramsTypes.get(parameter);
            switch (parameterType) {
                case INT:
                    if (StringUtils.isNumeric(valuestring)) {
                        return ParamVerificationResult.VALID;
                    } else {
                        return ParamVerificationResult.INVALID_VALUE;
                    }
                case BOOL:
                    if ("YES" == valuestring || "NO" == valuestring) {
                        return ParamVerificationResult.VALID;
                    } else {
                        return ParamVerificationResult.INVALID_VALUE;
                    }
                case DIRECTION:
                    if ("LEFT" == valuestring || "RIGHT" == valuestring || "UP" == valuestring || "DOWN" == valuestring) {
                        return ParamVerificationResult.VALID;
                    } else {
                        return ParamVerificationResult.INVALID_VALUE;
                    }
                case ORIENTATION:
                    if ("VERTICAL" == valuestring || "HORIZONTAL" == valuestring) {
                        return ParamVerificationResult.VALID;
                    } else {
                        return ParamVerificationResult.INVALID_VALUE;
                    }
                default:
                    //If the type is wrong
                    return ParamVerificationResult.INVALID_TYPE;
            }
        } else {
            //Parameter is not defined in the techfile description
            return ParamVerificationResult.INVALID_NAME;
        }
    }

    public String getDefaultParamValue(String paramkey) {
        if (!paramDefaults.containsKey(paramkey)) {
            return null;
        }
        return paramDefaults.get(paramkey);
    }

    public String getMINTName() {
        return mintname;
    }

    public List<Terminal> getComponentTerminals(HashMap<String, String> componentparams) {
        List<Terminal> ret = new ArrayList<>();
        HashMap<String, String> tempparams = new HashMap<>();
        tempparams.putAll(componentparams);
        Terminal terminal;
        TechTerminal techterminal;
        if (this.type == COMPOSITE || this.type == PRIMITIVE) {
            for (String key : terminalHashMap.keySet()) {
                terminal = new Terminal();
                techterminal = terminalHashMap.get(key);
                terminal.setLabel(key);
                terminal.setXOffset(this.parseExpression(techterminal.getXposexpression(), tempparams));
                terminal.setYOffset(this.parseExpression(techterminal.getYposexpression(), tempparams));
                terminal.setLayer(terminalHashMap.get(key).getLayer());
                ret.add(terminal);
            }
        } else if (this.type == SCALING) {
            //Loop through each of the terminals. Start the index at the given start expression value
            HashMap<String, Terminal> temp = new HashMap<>();
            int i, N;
            for (String key : terminalHashMap.keySet()) {
                techterminal = terminalHashMap.get(key);
                //We figure out the start location from the label which is the start for the scaling component
                i = parseExpression(techterminal.getStart(), tempparams);
                N = parseExpression(techterminal.getEnd(), tempparams);
                //Now put tech terminals until N, we effective replace the terminal sets as we keep doing the iterations
                while (i <= N) {
                    terminal = new Terminal();
                    //Now that we know the i value put it back in for the scaling primitive to work
                    tempparams.put("i", Integer.toString(i));
                    terminal.setLabel((Integer.toString(this.parseExpression(techterminal.getLabelexpression(), tempparams))));
                    terminal.setXOffset(this.parseExpression(techterminal.getXposexpression(), tempparams));
                    terminal.setYOffset(this.parseExpression(techterminal.getYposexpression(), tempparams));
                    terminal.setLayer(terminalHashMap.get(key).getLayer());
                    temp.put(terminal.getLabel(), terminal);
                    i++;
                }
            }
            //Dump all the values into the return list
            ret.addAll(temp.values());
        } else {
            throw new UnsupportedOperationException("This should not have any implementation");
        }
        return ret;

    }

    HashMap<String, String> expressionParams;

    /**
     * Parses the given expression
     *
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
     *
     * @param params
     * @return
     */
    @NotNull
    public int getXSpan(Map<String, String> params) {
        return parseExpression(xspanexpression, params);
    }

    /**
     * Returns the Y Span (Length) of the device
     *
     * @param params
     * @return
     */
    @NotNull
    public int getYSpan(Map<String, String> params) {
        return parseExpression(yspanexpression, params);
    }

    public TechEntityType getType() {
        return type;
    }

    public enum ParamVerificationResult {
        VALID,
        INVALID_NAME,
        INVALID_TYPE,
        INVALID_VALUE
    }

    public enum ParameterType {
        INT,
        ORIENTATION,
        DIRECTION,
        BOOL
    }

    public enum TechEntityType {
        PRIMITIVE,
        COMPOSITE,
        FEATURE,
        SCALING
    }


}
