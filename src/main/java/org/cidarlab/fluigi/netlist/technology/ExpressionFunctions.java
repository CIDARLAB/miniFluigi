package org.cidarlab.fluigi.netlist.technology;

import java.util.Stack;

public class ExpressionFunctions {

    public static void log2(Stack<Double> stack){
        double value = stack.pop();
        stack.push(Math.log(value)/Math.log(2));
    }

    public static void gt(Stack<Double> stack){
        throw new UnsupportedOperationException();
    }

    public static void lt(Stack<Double> stack){
        throw new UnsupportedOperationException();
    }
}
