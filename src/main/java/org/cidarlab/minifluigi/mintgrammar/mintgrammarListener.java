// Generated from /Users/krishna/CIDAR/MiniFluigi/src/main/ANTLR/mintgrammar.g4 by ANTLR 4.6
package org.cidarlab.minifluigi.mintgrammar;
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
	 * Enter a parse tree produced by {@link mintgrammarParser#portStat}.
	 * @param ctx the parse tree
	 */
	void enterPortStat(mintgrammarParser.PortStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#portStat}.
	 * @param ctx the parse tree
	 */
	void exitPortStat(mintgrammarParser.PortStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#portBankStat}.
	 * @param ctx the parse tree
	 */
	void enterPortBankStat(mintgrammarParser.PortBankStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#portBankStat}.
	 * @param ctx the parse tree
	 */
	void exitPortBankStat(mintgrammarParser.PortBankStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#verticalPortBankStatParams}.
	 * @param ctx the parse tree
	 */
	void enterVerticalPortBankStatParams(mintgrammarParser.VerticalPortBankStatParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#verticalPortBankStatParams}.
	 * @param ctx the parse tree
	 */
	void exitVerticalPortBankStatParams(mintgrammarParser.VerticalPortBankStatParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#verticalPortBankStatParam}.
	 * @param ctx the parse tree
	 */
	void enterVerticalPortBankStatParam(mintgrammarParser.VerticalPortBankStatParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#verticalPortBankStatParam}.
	 * @param ctx the parse tree
	 */
	void exitVerticalPortBankStatParam(mintgrammarParser.VerticalPortBankStatParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#horizontalPortBankStatParams}.
	 * @param ctx the parse tree
	 */
	void enterHorizontalPortBankStatParams(mintgrammarParser.HorizontalPortBankStatParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#horizontalPortBankStatParams}.
	 * @param ctx the parse tree
	 */
	void exitHorizontalPortBankStatParams(mintgrammarParser.HorizontalPortBankStatParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#horizontalPortBankStatParam}.
	 * @param ctx the parse tree
	 */
	void enterHorizontalPortBankStatParam(mintgrammarParser.HorizontalPortBankStatParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#horizontalPortBankStatParam}.
	 * @param ctx the parse tree
	 */
	void exitHorizontalPortBankStatParam(mintgrammarParser.HorizontalPortBankStatParamContext ctx);
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
	 * Enter a parse tree produced by {@link mintgrammarParser#nodeStat}.
	 * @param ctx the parse tree
	 */
	void enterNodeStat(mintgrammarParser.NodeStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#nodeStat}.
	 * @param ctx the parse tree
	 */
	void exitNodeStat(mintgrammarParser.NodeStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#cellTrapStat}.
	 * @param ctx the parse tree
	 */
	void enterCellTrapStat(mintgrammarParser.CellTrapStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#cellTrapStat}.
	 * @param ctx the parse tree
	 */
	void exitCellTrapStat(mintgrammarParser.CellTrapStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#cellTrapStatParams}.
	 * @param ctx the parse tree
	 */
	void enterCellTrapStatParams(mintgrammarParser.CellTrapStatParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#cellTrapStatParams}.
	 * @param ctx the parse tree
	 */
	void exitCellTrapStatParams(mintgrammarParser.CellTrapStatParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#cellTrapStatParam}.
	 * @param ctx the parse tree
	 */
	void enterCellTrapStatParam(mintgrammarParser.CellTrapStatParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#cellTrapStatParam}.
	 * @param ctx the parse tree
	 */
	void exitCellTrapStatParam(mintgrammarParser.CellTrapStatParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#cellTrapBankStat}.
	 * @param ctx the parse tree
	 */
	void enterCellTrapBankStat(mintgrammarParser.CellTrapBankStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#cellTrapBankStat}.
	 * @param ctx the parse tree
	 */
	void exitCellTrapBankStat(mintgrammarParser.CellTrapBankStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#cellTrapBankStatParams}.
	 * @param ctx the parse tree
	 */
	void enterCellTrapBankStatParams(mintgrammarParser.CellTrapBankStatParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#cellTrapBankStatParams}.
	 * @param ctx the parse tree
	 */
	void exitCellTrapBankStatParams(mintgrammarParser.CellTrapBankStatParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#cellTrapBankStatParam}.
	 * @param ctx the parse tree
	 */
	void enterCellTrapBankStatParam(mintgrammarParser.CellTrapBankStatParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#cellTrapBankStatParam}.
	 * @param ctx the parse tree
	 */
	void exitCellTrapBankStatParam(mintgrammarParser.CellTrapBankStatParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#logicArrayStat}.
	 * @param ctx the parse tree
	 */
	void enterLogicArrayStat(mintgrammarParser.LogicArrayStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#logicArrayStat}.
	 * @param ctx the parse tree
	 */
	void exitLogicArrayStat(mintgrammarParser.LogicArrayStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#logicArrayStatParams}.
	 * @param ctx the parse tree
	 */
	void enterLogicArrayStatParams(mintgrammarParser.LogicArrayStatParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#logicArrayStatParams}.
	 * @param ctx the parse tree
	 */
	void exitLogicArrayStatParams(mintgrammarParser.LogicArrayStatParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#logicArrayStatParam}.
	 * @param ctx the parse tree
	 */
	void enterLogicArrayStatParam(mintgrammarParser.LogicArrayStatParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#logicArrayStatParam}.
	 * @param ctx the parse tree
	 */
	void exitLogicArrayStatParam(mintgrammarParser.LogicArrayStatParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#muxStat}.
	 * @param ctx the parse tree
	 */
	void enterMuxStat(mintgrammarParser.MuxStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#muxStat}.
	 * @param ctx the parse tree
	 */
	void exitMuxStat(mintgrammarParser.MuxStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#muxStatParams}.
	 * @param ctx the parse tree
	 */
	void enterMuxStatParams(mintgrammarParser.MuxStatParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#muxStatParams}.
	 * @param ctx the parse tree
	 */
	void exitMuxStatParams(mintgrammarParser.MuxStatParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#muxStatParam}.
	 * @param ctx the parse tree
	 */
	void enterMuxStatParam(mintgrammarParser.MuxStatParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#muxStatParam}.
	 * @param ctx the parse tree
	 */
	void exitMuxStatParam(mintgrammarParser.MuxStatParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#treeStat}.
	 * @param ctx the parse tree
	 */
	void enterTreeStat(mintgrammarParser.TreeStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#treeStat}.
	 * @param ctx the parse tree
	 */
	void exitTreeStat(mintgrammarParser.TreeStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#treeStatParams}.
	 * @param ctx the parse tree
	 */
	void enterTreeStatParams(mintgrammarParser.TreeStatParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#treeStatParams}.
	 * @param ctx the parse tree
	 */
	void exitTreeStatParams(mintgrammarParser.TreeStatParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#treeStatParam}.
	 * @param ctx the parse tree
	 */
	void enterTreeStatParam(mintgrammarParser.TreeStatParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#treeStatParam}.
	 * @param ctx the parse tree
	 */
	void exitTreeStatParam(mintgrammarParser.TreeStatParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#setCoordStat}.
	 * @param ctx the parse tree
	 */
	void enterSetCoordStat(mintgrammarParser.SetCoordStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#setCoordStat}.
	 * @param ctx the parse tree
	 */
	void exitSetCoordStat(mintgrammarParser.SetCoordStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#mixerStat}.
	 * @param ctx the parse tree
	 */
	void enterMixerStat(mintgrammarParser.MixerStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#mixerStat}.
	 * @param ctx the parse tree
	 */
	void exitMixerStat(mintgrammarParser.MixerStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#mixerStatParams}.
	 * @param ctx the parse tree
	 */
	void enterMixerStatParams(mintgrammarParser.MixerStatParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#mixerStatParams}.
	 * @param ctx the parse tree
	 */
	void exitMixerStatParams(mintgrammarParser.MixerStatParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#mixerStatParam}.
	 * @param ctx the parse tree
	 */
	void enterMixerStatParam(mintgrammarParser.MixerStatParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#mixerStatParam}.
	 * @param ctx the parse tree
	 */
	void exitMixerStatParam(mintgrammarParser.MixerStatParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#gradGenStat}.
	 * @param ctx the parse tree
	 */
	void enterGradGenStat(mintgrammarParser.GradGenStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#gradGenStat}.
	 * @param ctx the parse tree
	 */
	void exitGradGenStat(mintgrammarParser.GradGenStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#gradGenStatParams}.
	 * @param ctx the parse tree
	 */
	void enterGradGenStatParams(mintgrammarParser.GradGenStatParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#gradGenStatParams}.
	 * @param ctx the parse tree
	 */
	void exitGradGenStatParams(mintgrammarParser.GradGenStatParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#gradGenStatParam}.
	 * @param ctx the parse tree
	 */
	void enterGradGenStatParam(mintgrammarParser.GradGenStatParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#gradGenStatParam}.
	 * @param ctx the parse tree
	 */
	void exitGradGenStatParam(mintgrammarParser.GradGenStatParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#rotaryStat}.
	 * @param ctx the parse tree
	 */
	void enterRotaryStat(mintgrammarParser.RotaryStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#rotaryStat}.
	 * @param ctx the parse tree
	 */
	void exitRotaryStat(mintgrammarParser.RotaryStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#rotaryStatParams}.
	 * @param ctx the parse tree
	 */
	void enterRotaryStatParams(mintgrammarParser.RotaryStatParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#rotaryStatParams}.
	 * @param ctx the parse tree
	 */
	void exitRotaryStatParams(mintgrammarParser.RotaryStatParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#rotaryStatParam}.
	 * @param ctx the parse tree
	 */
	void enterRotaryStatParam(mintgrammarParser.RotaryStatParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#rotaryStatParam}.
	 * @param ctx the parse tree
	 */
	void exitRotaryStatParam(mintgrammarParser.RotaryStatParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#dropletGenStat}.
	 * @param ctx the parse tree
	 */
	void enterDropletGenStat(mintgrammarParser.DropletGenStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#dropletGenStat}.
	 * @param ctx the parse tree
	 */
	void exitDropletGenStat(mintgrammarParser.DropletGenStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#dropletGenStatParams}.
	 * @param ctx the parse tree
	 */
	void enterDropletGenStatParams(mintgrammarParser.DropletGenStatParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#dropletGenStatParams}.
	 * @param ctx the parse tree
	 */
	void exitDropletGenStatParams(mintgrammarParser.DropletGenStatParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#dropletGenStatParam}.
	 * @param ctx the parse tree
	 */
	void enterDropletGenStatParam(mintgrammarParser.DropletGenStatParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#dropletGenStatParam}.
	 * @param ctx the parse tree
	 */
	void exitDropletGenStatParam(mintgrammarParser.DropletGenStatParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#valve3DStat}.
	 * @param ctx the parse tree
	 */
	void enterValve3DStat(mintgrammarParser.Valve3DStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#valve3DStat}.
	 * @param ctx the parse tree
	 */
	void exitValve3DStat(mintgrammarParser.Valve3DStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#valve3DStatParams}.
	 * @param ctx the parse tree
	 */
	void enterValve3DStatParams(mintgrammarParser.Valve3DStatParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#valve3DStatParams}.
	 * @param ctx the parse tree
	 */
	void exitValve3DStatParams(mintgrammarParser.Valve3DStatParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#valve3DStatParam}.
	 * @param ctx the parse tree
	 */
	void enterValve3DStatParam(mintgrammarParser.Valve3DStatParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#valve3DStatParam}.
	 * @param ctx the parse tree
	 */
	void exitValve3DStatParam(mintgrammarParser.Valve3DStatParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#viaStat}.
	 * @param ctx the parse tree
	 */
	void enterViaStat(mintgrammarParser.ViaStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#viaStat}.
	 * @param ctx the parse tree
	 */
	void exitViaStat(mintgrammarParser.ViaStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#transposerStat}.
	 * @param ctx the parse tree
	 */
	void enterTransposerStat(mintgrammarParser.TransposerStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#transposerStat}.
	 * @param ctx the parse tree
	 */
	void exitTransposerStat(mintgrammarParser.TransposerStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#transposerStatParams}.
	 * @param ctx the parse tree
	 */
	void enterTransposerStatParams(mintgrammarParser.TransposerStatParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#transposerStatParams}.
	 * @param ctx the parse tree
	 */
	void exitTransposerStatParams(mintgrammarParser.TransposerStatParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#transposerStatParam}.
	 * @param ctx the parse tree
	 */
	void enterTransposerStatParam(mintgrammarParser.TransposerStatParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#transposerStatParam}.
	 * @param ctx the parse tree
	 */
	void exitTransposerStatParam(mintgrammarParser.TransposerStatParamContext ctx);
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
	 * Enter a parse tree produced by {@link mintgrammarParser#ufterminalStat}.
	 * @param ctx the parse tree
	 */
	void enterUfterminalStat(mintgrammarParser.UfterminalStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#ufterminalStat}.
	 * @param ctx the parse tree
	 */
	void exitUfterminalStat(mintgrammarParser.UfterminalStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#reactionChamberStat}.
	 * @param ctx the parse tree
	 */
	void enterReactionChamberStat(mintgrammarParser.ReactionChamberStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#reactionChamberStat}.
	 * @param ctx the parse tree
	 */
	void exitReactionChamberStat(mintgrammarParser.ReactionChamberStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#reactionChamberStatParams}.
	 * @param ctx the parse tree
	 */
	void enterReactionChamberStatParams(mintgrammarParser.ReactionChamberStatParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#reactionChamberStatParams}.
	 * @param ctx the parse tree
	 */
	void exitReactionChamberStatParams(mintgrammarParser.ReactionChamberStatParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#reactionChamberStatParam}.
	 * @param ctx the parse tree
	 */
	void enterReactionChamberStatParam(mintgrammarParser.ReactionChamberStatParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#reactionChamberStatParam}.
	 * @param ctx the parse tree
	 */
	void exitReactionChamberStatParam(mintgrammarParser.ReactionChamberStatParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#radiusParam}.
	 * @param ctx the parse tree
	 */
	void enterRadiusParam(mintgrammarParser.RadiusParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#radiusParam}.
	 * @param ctx the parse tree
	 */
	void exitRadiusParam(mintgrammarParser.RadiusParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#angleParam}.
	 * @param ctx the parse tree
	 */
	void enterAngleParam(mintgrammarParser.AngleParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#angleParam}.
	 * @param ctx the parse tree
	 */
	void exitAngleParam(mintgrammarParser.AngleParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#lengthParam}.
	 * @param ctx the parse tree
	 */
	void enterLengthParam(mintgrammarParser.LengthParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#lengthParam}.
	 * @param ctx the parse tree
	 */
	void exitLengthParam(mintgrammarParser.LengthParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#verticalDirectionParam}.
	 * @param ctx the parse tree
	 */
	void enterVerticalDirectionParam(mintgrammarParser.VerticalDirectionParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#verticalDirectionParam}.
	 * @param ctx the parse tree
	 */
	void exitVerticalDirectionParam(mintgrammarParser.VerticalDirectionParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#horizontalDirectionParam}.
	 * @param ctx the parse tree
	 */
	void enterHorizontalDirectionParam(mintgrammarParser.HorizontalDirectionParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#horizontalDirectionParam}.
	 * @param ctx the parse tree
	 */
	void exitHorizontalDirectionParam(mintgrammarParser.HorizontalDirectionParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#numChambersParam}.
	 * @param ctx the parse tree
	 */
	void enterNumChambersParam(mintgrammarParser.NumChambersParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#numChambersParam}.
	 * @param ctx the parse tree
	 */
	void exitNumChambersParam(mintgrammarParser.NumChambersParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#chamberWidthParam}.
	 * @param ctx the parse tree
	 */
	void enterChamberWidthParam(mintgrammarParser.ChamberWidthParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#chamberWidthParam}.
	 * @param ctx the parse tree
	 */
	void exitChamberWidthParam(mintgrammarParser.ChamberWidthParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#chamberLengthParam}.
	 * @param ctx the parse tree
	 */
	void enterChamberLengthParam(mintgrammarParser.ChamberLengthParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#chamberLengthParam}.
	 * @param ctx the parse tree
	 */
	void exitChamberLengthParam(mintgrammarParser.ChamberLengthParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#chamberSpacingParam}.
	 * @param ctx the parse tree
	 */
	void enterChamberSpacingParam(mintgrammarParser.ChamberSpacingParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#chamberSpacingParam}.
	 * @param ctx the parse tree
	 */
	void exitChamberSpacingParam(mintgrammarParser.ChamberSpacingParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#spacingParam}.
	 * @param ctx the parse tree
	 */
	void enterSpacingParam(mintgrammarParser.SpacingParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#spacingParam}.
	 * @param ctx the parse tree
	 */
	void exitSpacingParam(mintgrammarParser.SpacingParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#channelWidthParam}.
	 * @param ctx the parse tree
	 */
	void enterChannelWidthParam(mintgrammarParser.ChannelWidthParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#channelWidthParam}.
	 * @param ctx the parse tree
	 */
	void exitChannelWidthParam(mintgrammarParser.ChannelWidthParamContext ctx);
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
	 * Enter a parse tree produced by {@link mintgrammarParser#flowChannelWidthParam}.
	 * @param ctx the parse tree
	 */
	void enterFlowChannelWidthParam(mintgrammarParser.FlowChannelWidthParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#flowChannelWidthParam}.
	 * @param ctx the parse tree
	 */
	void exitFlowChannelWidthParam(mintgrammarParser.FlowChannelWidthParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#controlChannelWidthParam}.
	 * @param ctx the parse tree
	 */
	void enterControlChannelWidthParam(mintgrammarParser.ControlChannelWidthParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#controlChannelWidthParam}.
	 * @param ctx the parse tree
	 */
	void exitControlChannelWidthParam(mintgrammarParser.ControlChannelWidthParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#numBendsParam}.
	 * @param ctx the parse tree
	 */
	void enterNumBendsParam(mintgrammarParser.NumBendsParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#numBendsParam}.
	 * @param ctx the parse tree
	 */
	void exitNumBendsParam(mintgrammarParser.NumBendsParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#bendSpacingParam}.
	 * @param ctx the parse tree
	 */
	void enterBendSpacingParam(mintgrammarParser.BendSpacingParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#bendSpacingParam}.
	 * @param ctx the parse tree
	 */
	void exitBendSpacingParam(mintgrammarParser.BendSpacingParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#bendLengthParam}.
	 * @param ctx the parse tree
	 */
	void enterBendLengthParam(mintgrammarParser.BendLengthParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#bendLengthParam}.
	 * @param ctx the parse tree
	 */
	void exitBendLengthParam(mintgrammarParser.BendLengthParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#oilChannelWidthParam}.
	 * @param ctx the parse tree
	 */
	void enterOilChannelWidthParam(mintgrammarParser.OilChannelWidthParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#oilChannelWidthParam}.
	 * @param ctx the parse tree
	 */
	void exitOilChannelWidthParam(mintgrammarParser.OilChannelWidthParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#waterChannelWidthParam}.
	 * @param ctx the parse tree
	 */
	void enterWaterChannelWidthParam(mintgrammarParser.WaterChannelWidthParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#waterChannelWidthParam}.
	 * @param ctx the parse tree
	 */
	void exitWaterChannelWidthParam(mintgrammarParser.WaterChannelWidthParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link mintgrammarParser#gapParam}.
	 * @param ctx the parse tree
	 */
	void enterGapParam(mintgrammarParser.GapParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link mintgrammarParser#gapParam}.
	 * @param ctx the parse tree
	 */
	void exitGapParam(mintgrammarParser.GapParamContext ctx);
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
}