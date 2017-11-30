// Generated from /Users/krishna/CIDAR/MiniFluigi/src/main/ANTLR/expressiongrammar.g4 by ANTLR 4.7
package org.cidarlab.fluigi.netlist.expressiongrammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link expressiongrammarParser}.
 */
public interface expressiongrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link expressiongrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(expressiongrammarParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link expressiongrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(expressiongrammarParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link expressiongrammarParser#parameter_atom}.
	 * @param ctx the parse tree
	 */
	void enterParameter_atom(expressiongrammarParser.Parameter_atomContext ctx);
	/**
	 * Exit a parse tree produced by {@link expressiongrammarParser#parameter_atom}.
	 * @param ctx the parse tree
	 */
	void exitParameter_atom(expressiongrammarParser.Parameter_atomContext ctx);
	/**
	 * Enter a parse tree produced by {@link expressiongrammarParser#number_atom}.
	 * @param ctx the parse tree
	 */
	void enterNumber_atom(expressiongrammarParser.Number_atomContext ctx);
	/**
	 * Exit a parse tree produced by {@link expressiongrammarParser#number_atom}.
	 * @param ctx the parse tree
	 */
	void exitNumber_atom(expressiongrammarParser.Number_atomContext ctx);
	/**
	 * Enter a parse tree produced by {@link expressiongrammarParser#signed_atom}.
	 * @param ctx the parse tree
	 */
	void enterSigned_atom(expressiongrammarParser.Signed_atomContext ctx);
	/**
	 * Exit a parse tree produced by {@link expressiongrammarParser#signed_atom}.
	 * @param ctx the parse tree
	 */
	void exitSigned_atom(expressiongrammarParser.Signed_atomContext ctx);
	/**
	 * Enter a parse tree produced by {@link expressiongrammarParser#function_expression}.
	 * @param ctx the parse tree
	 */
	void enterFunction_expression(expressiongrammarParser.Function_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link expressiongrammarParser#function_expression}.
	 * @param ctx the parse tree
	 */
	void exitFunction_expression(expressiongrammarParser.Function_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link expressiongrammarParser#primary_expression}.
	 * @param ctx the parse tree
	 */
	void enterPrimary_expression(expressiongrammarParser.Primary_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link expressiongrammarParser#primary_expression}.
	 * @param ctx the parse tree
	 */
	void exitPrimary_expression(expressiongrammarParser.Primary_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link expressiongrammarParser#bracket_expression}.
	 * @param ctx the parse tree
	 */
	void enterBracket_expression(expressiongrammarParser.Bracket_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link expressiongrammarParser#bracket_expression}.
	 * @param ctx the parse tree
	 */
	void exitBracket_expression(expressiongrammarParser.Bracket_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link expressiongrammarParser#multiplicative_expression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicative_expression(expressiongrammarParser.Multiplicative_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link expressiongrammarParser#multiplicative_expression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicative_expression(expressiongrammarParser.Multiplicative_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link expressiongrammarParser#additive_expression}.
	 * @param ctx the parse tree
	 */
	void enterAdditive_expression(expressiongrammarParser.Additive_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link expressiongrammarParser#additive_expression}.
	 * @param ctx the parse tree
	 */
	void exitAdditive_expression(expressiongrammarParser.Additive_expressionContext ctx);
}