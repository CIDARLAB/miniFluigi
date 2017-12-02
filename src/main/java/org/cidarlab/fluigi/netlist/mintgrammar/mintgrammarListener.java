// Generated from /Users/krishna/CIDAR/MiniFluigi/src/main/ANTLR/mintgrammar.g4 by ANTLR 4.7
package org.cidarlab.fluigi.netlist.mintgrammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link mintgrammarParser}.
 */
public interface mintgrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#netlist}.
	 * @param ctx the parse tree
	 */
	void enterNetlist(mintgrammarParser.NetlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#netlist}.
	 * @param ctx the parse tree
	 */
	void exitNetlist(mintgrammarParser.NetlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#importBlock}.
	 * @param ctx the parse tree
	 */
	void enterImportBlock(mintgrammarParser.ImportBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#importBlock}.
	 * @param ctx the parse tree
	 */
	void exitImportBlock(mintgrammarParser.ImportBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#importStat}.
	 * @param ctx the parse tree
	 */
	void enterImportStat(mintgrammarParser.ImportStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#importStat}.
	 * @param ctx the parse tree
	 */
	void exitImportStat(mintgrammarParser.ImportStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#header}.
	 * @param ctx the parse tree
	 */
	void enterHeader(mintgrammarParser.HeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#header}.
	 * @param ctx the parse tree
	 */
	void exitHeader(mintgrammarParser.HeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#ufmoduleBlock}.
	 * @param ctx the parse tree
	 */
	void enterUfmoduleBlock(mintgrammarParser.UfmoduleBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#ufmoduleBlock}.
	 * @param ctx the parse tree
	 */
	void exitUfmoduleBlock(mintgrammarParser.UfmoduleBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#ufmoduleStat}.
	 * @param ctx the parse tree
	 */
	void enterUfmoduleStat(mintgrammarParser.UfmoduleStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#ufmoduleStat}.
	 * @param ctx the parse tree
	 */
	void exitUfmoduleStat(mintgrammarParser.UfmoduleStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#layerBlocks}.
	 * @param ctx the parse tree
	 */
	void enterLayerBlocks(mintgrammarParser.LayerBlocksContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#layerBlocks}.
	 * @param ctx the parse tree
	 */
	void exitLayerBlocks(mintgrammarParser.LayerBlocksContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#layerBlock}.
	 * @param ctx the parse tree
	 */
	void enterLayerBlock(mintgrammarParser.LayerBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#layerBlock}.
	 * @param ctx the parse tree
	 */
	void exitLayerBlock(mintgrammarParser.LayerBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#flowBlock}.
	 * @param ctx the parse tree
	 */
	void enterFlowBlock(mintgrammarParser.FlowBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#flowBlock}.
	 * @param ctx the parse tree
	 */
	void exitFlowBlock(mintgrammarParser.FlowBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#controlBlock}.
	 * @param ctx the parse tree
	 */
	void enterControlBlock(mintgrammarParser.ControlBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#controlBlock}.
	 * @param ctx the parse tree
	 */
	void exitControlBlock(mintgrammarParser.ControlBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#integrationBlock}.
	 * @param ctx the parse tree
	 */
	void enterIntegrationBlock(mintgrammarParser.IntegrationBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#integrationBlock}.
	 * @param ctx the parse tree
	 */
	void exitIntegrationBlock(mintgrammarParser.IntegrationBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#flowStat}.
	 * @param ctx the parse tree
	 */
	void enterFlowStat(mintgrammarParser.FlowStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#flowStat}.
	 * @param ctx the parse tree
	 */
	void exitFlowStat(mintgrammarParser.FlowStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#controlStat}.
	 * @param ctx the parse tree
	 */
	void enterControlStat(mintgrammarParser.ControlStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#controlStat}.
	 * @param ctx the parse tree
	 */
	void exitControlStat(mintgrammarParser.ControlStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#integrationStat}.
	 * @param ctx the parse tree
	 */
	void enterIntegrationStat(mintgrammarParser.IntegrationStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#integrationStat}.
	 * @param ctx the parse tree
	 */
	void exitIntegrationStat(mintgrammarParser.IntegrationStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#primitiveStat}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveStat(mintgrammarParser.PrimitiveStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#primitiveStat}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveStat(mintgrammarParser.PrimitiveStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#bankStat}.
	 * @param ctx the parse tree
	 */
	void enterBankStat(mintgrammarParser.BankStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#bankStat}.
	 * @param ctx the parse tree
	 */
	void exitBankStat(mintgrammarParser.BankStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#gridStat}.
	 * @param ctx the parse tree
	 */
	void enterGridStat(mintgrammarParser.GridStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#gridStat}.
	 * @param ctx the parse tree
	 */
	void exitGridStat(mintgrammarParser.GridStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#spanStat}.
	 * @param ctx the parse tree
	 */
	void enterSpanStat(mintgrammarParser.SpanStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#spanStat}.
	 * @param ctx the parse tree
	 */
	void exitSpanStat(mintgrammarParser.SpanStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#primitiveWithOrientationConstraintStat}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveWithOrientationConstraintStat(mintgrammarParser.PrimitiveWithOrientationConstraintStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#primitiveWithOrientationConstraintStat}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveWithOrientationConstraintStat(mintgrammarParser.PrimitiveWithOrientationConstraintStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#valveStat}.
	 * @param ctx the parse tree
	 */
	void enterValveStat(mintgrammarParser.ValveStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#valveStat}.
	 * @param ctx the parse tree
	 */
	void exitValveStat(mintgrammarParser.ValveStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#channelStat}.
	 * @param ctx the parse tree
	 */
	void enterChannelStat(mintgrammarParser.ChannelStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#channelStat}.
	 * @param ctx the parse tree
	 */
	void exitChannelStat(mintgrammarParser.ChannelStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#netStat}.
	 * @param ctx the parse tree
	 */
	void enterNetStat(mintgrammarParser.NetStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#netStat}.
	 * @param ctx the parse tree
	 */
	void exitNetStat(mintgrammarParser.NetStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#entity}.
	 * @param ctx the parse tree
	 */
	void enterEntity(mintgrammarParser.EntityContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#entity}.
	 * @param ctx the parse tree
	 */
	void exitEntity(mintgrammarParser.EntityContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#entity_element}.
	 * @param ctx the parse tree
	 */
	void enterEntity_element(mintgrammarParser.Entity_elementContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#entity_element}.
	 * @param ctx the parse tree
	 */
	void exitEntity_element(mintgrammarParser.Entity_elementContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#paramsStat}.
	 * @param ctx the parse tree
	 */
	void enterParamsStat(mintgrammarParser.ParamsStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#paramsStat}.
	 * @param ctx the parse tree
	 */
	void exitParamsStat(mintgrammarParser.ParamsStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#paramStat}.
	 * @param ctx the parse tree
	 */
	void enterParamStat(mintgrammarParser.ParamStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#paramStat}.
	 * @param ctx the parse tree
	 */
	void exitParamStat(mintgrammarParser.ParamStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#param_element}.
	 * @param ctx the parse tree
	 */
	void enterParam_element(mintgrammarParser.Param_elementContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#param_element}.
	 * @param ctx the parse tree
	 */
	void exitParam_element(mintgrammarParser.Param_elementContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#intParam}.
	 * @param ctx the parse tree
	 */
	void enterIntParam(mintgrammarParser.IntParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#intParam}.
	 * @param ctx the parse tree
	 */
	void exitIntParam(mintgrammarParser.IntParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#boolParam}.
	 * @param ctx the parse tree
	 */
	void enterBoolParam(mintgrammarParser.BoolParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#boolParam}.
	 * @param ctx the parse tree
	 */
	void exitBoolParam(mintgrammarParser.BoolParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#widthParam}.
	 * @param ctx the parse tree
	 */
	void enterWidthParam(mintgrammarParser.WidthParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#widthParam}.
	 * @param ctx the parse tree
	 */
	void exitWidthParam(mintgrammarParser.WidthParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#directionConstraintParam}.
	 * @param ctx the parse tree
	 */
	void enterDirectionConstraintParam(mintgrammarParser.DirectionConstraintParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#directionConstraintParam}.
	 * @param ctx the parse tree
	 */
	void exitDirectionConstraintParam(mintgrammarParser.DirectionConstraintParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#gridParam}.
	 * @param ctx the parse tree
	 */
	void enterGridParam(mintgrammarParser.GridParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#gridParam}.
	 * @param ctx the parse tree
	 */
	void exitGridParam(mintgrammarParser.GridParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#gridParamValue}.
	 * @param ctx the parse tree
	 */
	void enterGridParamValue(mintgrammarParser.GridParamValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#gridParamValue}.
	 * @param ctx the parse tree
	 */
	void exitGridParamValue(mintgrammarParser.GridParamValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#gridParamKey}.
	 * @param ctx the parse tree
	 */
	void enterGridParamKey(mintgrammarParser.GridParamKeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#gridParamKey}.
	 * @param ctx the parse tree
	 */
	void exitGridParamKey(mintgrammarParser.GridParamKeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#ufmodulename}.
	 * @param ctx the parse tree
	 */
	void enterUfmodulename(mintgrammarParser.UfmodulenameContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#ufmodulename}.
	 * @param ctx the parse tree
	 */
	void exitUfmodulename(mintgrammarParser.UfmodulenameContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#ufterminal}.
	 * @param ctx the parse tree
	 */
	void enterUfterminal(mintgrammarParser.UfterminalContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#ufterminal}.
	 * @param ctx the parse tree
	 */
	void exitUfterminal(mintgrammarParser.UfterminalContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#uftargets}.
	 * @param ctx the parse tree
	 */
	void enterUftargets(mintgrammarParser.UftargetsContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#uftargets}.
	 * @param ctx the parse tree
	 */
	void exitUftargets(mintgrammarParser.UftargetsContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#uftarget}.
	 * @param ctx the parse tree
	 */
	void enterUftarget(mintgrammarParser.UftargetContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#uftarget}.
	 * @param ctx the parse tree
	 */
	void exitUftarget(mintgrammarParser.UftargetContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#ufname}.
	 * @param ctx the parse tree
	 */
	void enterUfname(mintgrammarParser.UfnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#ufname}.
	 * @param ctx the parse tree
	 */
	void exitUfname(mintgrammarParser.UfnameContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#ufnames}.
	 * @param ctx the parse tree
	 */
	void enterUfnames(mintgrammarParser.UfnamesContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#ufnames}.
	 * @param ctx the parse tree
	 */
	void exitUfnames(mintgrammarParser.UfnamesContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(mintgrammarParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(mintgrammarParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#boolvalue}.
	 * @param ctx the parse tree
	 */
	void enterBoolvalue(mintgrammarParser.BoolvalueContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#boolvalue}.
	 * @param ctx the parse tree
	 */
	void exitBoolvalue(mintgrammarParser.BoolvalueContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#orientation}.
	 * @param ctx the parse tree
	 */
	void enterOrientation(mintgrammarParser.OrientationContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#orientation}.
	 * @param ctx the parse tree
	 */
	void exitOrientation(mintgrammarParser.OrientationContext ctx);
}