package org.cidarlab.fluigi.netlist;

import org.cidarlab.fluigi.netlist.expressiongrammar.expressiongrammarBaseListener;

import java.util.HashMap;

/**
 * Created by krishna on 8/16/17.
 */
public class ExpressionParser extends expressiongrammarBaseListener {

    private HashMap<String, Double> expressionPrams;
    private double expressionvalue;

    public ExpressionParser(HashMap<String, Double> parameters){
        expressionPrams = parameters;
    }

    public void setExpressionPrams(HashMap<String, Double> parameters){
        expressionPrams = parameters;
    }

    public double computeExpression(){
        return expressionvalue;
    }
}
