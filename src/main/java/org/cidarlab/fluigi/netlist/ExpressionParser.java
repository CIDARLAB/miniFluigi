package org.cidarlab.fluigi.netlist;

import org.apache.commons.lang3.StringUtils;
import org.cidarlab.fluigi.netlist.expressiongrammar.expressiongrammarBaseListener;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by krishna on 8/16/17.
 */
public class ExpressionParser extends expressiongrammarBaseListener {

    private HashMap<String, Double> expressionPrams;
    private double expressionvalue;

    public ExpressionParser(){
        expressionPrams = new HashMap<>();
    }

    public void setExpressionPrams(Map<String, String> parameters){
        expressionPrams.clear();
        for(String key : parameters.keySet()){
            String value = parameters.get(key);
            if(StringUtils.isNumeric(value)){
                expressionPrams.put(key, Double.parseDouble(value));
            }
        }
    }

    public double computeExpression(){
        throw new UnsupportedOperationException("Implement the computation of the expression");
//        return expressionvalue;
    }
}
