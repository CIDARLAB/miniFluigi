package org.cidarlab.fluigi.netlist;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.commons.lang3.StringUtils;
import org.cidarlab.fluigi.netlist.expressiongrammar.expressiongrammarBaseListener;
import org.cidarlab.fluigi.netlist.expressiongrammar.expressiongrammarParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by krishna on 8/16/17.
 */
public class ExpressionParser extends expressiongrammarBaseListener {

    private static final String ADD = "+";
    private static final String SUB = "-";
    private static final String MUL = "*";
    private static final String DIV = "/";

    private HashMap<String, Double> expressionPrams;
    private Stack<Double> atomstack;

    public ExpressionParser(){
        expressionPrams = new HashMap<>();
        atomstack = new Stack<>();
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
        return atomstack.pop();
    }

    @Override
    public void enterParameter_atom(expressiongrammarParser.Parameter_atomContext ctx) {
        String paramkey = ctx.ID().getText();
        double paramvalue = expressionPrams.get(paramkey);
        atomstack.push(paramvalue);
    }

    @Override
    public void enterNumber_atom(expressiongrammarParser.Number_atomContext ctx) {
        atomstack.push(Double.parseDouble(ctx.getText()));
    }

    @Override
    public void enterSigned_atom(expressiongrammarParser.Signed_atomContext ctx) {
        if(ctx.isnegative != null){ //This might have to change
            double stackvalue = -1 * atomstack.pop();
            atomstack.push(stackvalue);
        }
    }

    @Override
    public void exitMultiplicative_expression(expressiongrammarParser.Multiplicative_expressionContext ctx) {
        if(null!=ctx.operator.getText()) {
            double value2 = atomstack.pop();
            double value1 = atomstack.pop();
            switch (ctx.operator.getText()) {
                case ADD:
                    atomstack.push(value1 + value2);
                    break;
                case SUB:
                    atomstack.push(value1 - value2);
                    break;
            }
        }
    }

    @Override
    public void exitAdditive_expression(expressiongrammarParser.Additive_expressionContext ctx) {
        if(null!=ctx.operator.getText()) {
            double value2 = atomstack.pop();
            double value1 = atomstack.pop();
            switch (ctx.operator.getText()) {
                case MUL:
                    atomstack.push(value1 * value2);
                    break;
                case DIV:
                    if(0==value2){
                        System.exit(10000);
                    }
                    atomstack.push(value1 / value2);
                    break;
            }
        }

    }


    public class UnspecifiedParameterException extends Exception {
        public UnspecifiedParameterException(String message){
            super();
            System.err.println(message);
        }
    }

    public class ZeroValueExpression extends Exception {
        public ZeroValueExpression(){
            System.err.println("REally a zero division ? you goto do better than this....");
        }
    }
}
