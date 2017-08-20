// Generated from /Users/krishna/CIDAR/MiniFluigi/src/main/ANTLR/mintgrammar.g4 by ANTLR 4.7
package org.cidarlab.fluigi.netlist.mintgrammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class mintgrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, ID=35, ID_BIG=36, INT=37, WS=38, COMMENT=39;
	public static final int
		RULE_netlist = 0, RULE_importBlock = 1, RULE_importStat = 2, RULE_header = 3, 
		RULE_ufmoduleBlock = 4, RULE_ufmoduleStat = 5, RULE_layerBlocks = 6, RULE_layerBlock = 7, 
		RULE_flowBlock = 8, RULE_controlBlock = 9, RULE_flowStat = 10, RULE_controlStat = 11, 
		RULE_primitiveStat = 12, RULE_primitiveWithOrientationStat = 13, RULE_bankStat = 14, 
		RULE_gridStat = 15, RULE_spanStat = 16, RULE_valveStat = 17, RULE_nodeStat = 18, 
		RULE_channelStat = 19, RULE_netStat = 20, RULE_entity = 21, RULE_entity_element = 22, 
		RULE_paramsStat = 23, RULE_paramStat = 24, RULE_param_element = 25, RULE_intParam = 26, 
		RULE_boolParam = 27, RULE_widthParam = 28, RULE_verticalDirectionParam = 29, 
		RULE_horizontalDirectionParam = 30, RULE_horizontalConnectParam = 31, 
		RULE_verticalConnectionParam = 32, RULE_ufmodulename = 33, RULE_ufterminal = 34, 
		RULE_uftargets = 35, RULE_uftarget = 36, RULE_ufname = 37, RULE_ufnames = 38, 
		RULE_value = 39, RULE_boolvalue = 40, RULE_orientation = 41;
	public static final String[] ruleNames = {
		"netlist", "importBlock", "importStat", "header", "ufmoduleBlock", "ufmoduleStat", 
		"layerBlocks", "layerBlock", "flowBlock", "controlBlock", "flowStat", 
		"controlStat", "primitiveStat", "primitiveWithOrientationStat", "bankStat", 
		"gridStat", "spanStat", "valveStat", "nodeStat", "channelStat", "netStat", 
		"entity", "entity_element", "paramsStat", "paramStat", "param_element", 
		"intParam", "boolParam", "widthParam", "verticalDirectionParam", "horizontalDirectionParam", 
		"horizontalConnectParam", "verticalConnectionParam", "ufmodulename", "ufterminal", 
		"uftargets", "uftarget", "ufname", "ufnames", "value", "boolvalue", "orientation"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'IMPORT'", "'3D'", "'DEVICE'", "';'", "'LAYER FLOW'", "'END LAYER'", 
		"'LAYER CONTROL'", "'BANK'", "'of'", "'GRID'", "','", "'to'", "'VALVE'", 
		"'3DVALVE'", "'on'", "'NODE'", "'CHANNEL'", "'from'", "'NET'", "'='", 
		"'width'", "'w'", "'channelWidth'", "'dir'", "'RIGHT'", "'LEFT'", "'UP'", 
		"'DOWN'", "'horizontalConnect'", "'verticalConnect'", "'YES'", "'NO'", 
		"'V'", "'H'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, "ID", 
		"ID_BIG", "INT", "WS", "COMMENT"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "mintgrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public mintgrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class NetlistContext extends ParserRuleContext {
		public HeaderContext header() {
			return getRuleContext(HeaderContext.class,0);
		}
		public LayerBlocksContext layerBlocks() {
			return getRuleContext(LayerBlocksContext.class,0);
		}
		public TerminalNode EOF() { return getToken(mintgrammarParser.EOF, 0); }
		public ImportBlockContext importBlock() {
			return getRuleContext(ImportBlockContext.class,0);
		}
		public UfmoduleBlockContext ufmoduleBlock() {
			return getRuleContext(UfmoduleBlockContext.class,0);
		}
		public NetlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_netlist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).enterNetlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).exitNetlist(this);
		}
	}

	public final NetlistContext netlist() throws RecognitionException {
		NetlistContext _localctx = new NetlistContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_netlist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(84);
				importBlock();
				}
			}

			setState(87);
			header();
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID_BIG) {
				{
				setState(88);
				ufmoduleBlock();
				}
			}

			setState(91);
			layerBlocks();
			setState(92);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ImportBlockContext extends ParserRuleContext {
		public List<ImportStatContext> importStat() {
			return getRuleContexts(ImportStatContext.class);
		}
		public ImportStatContext importStat(int i) {
			return getRuleContext(ImportStatContext.class,i);
		}
		public ImportBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).enterImportBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).exitImportBlock(this);
		}
	}

	public final ImportBlockContext importBlock() throws RecognitionException {
		ImportBlockContext _localctx = new ImportBlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_importBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(94);
				importStat();
				}
				}
				setState(97); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ImportStatContext extends ParserRuleContext {
		public UfmodulenameContext ufmodulename() {
			return getRuleContext(UfmodulenameContext.class,0);
		}
		public ImportStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).enterImportStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).exitImportStat(this);
		}
	}

	public final ImportStatContext importStat() throws RecognitionException {
		ImportStatContext _localctx = new ImportStatContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_importStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(T__0);
			setState(100);
			ufmodulename();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HeaderContext extends ParserRuleContext {
		public Token tag;
		public Token device_name;
		public TerminalNode ID() { return getToken(mintgrammarParser.ID, 0); }
		public HeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_header; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).enterHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).exitHeader(this);
		}
	}

	public final HeaderContext header() throws RecognitionException {
		HeaderContext _localctx = new HeaderContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_header);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(102);
				((HeaderContext)_localctx).tag = match(T__1);
				}
			}

			setState(105);
			match(T__2);
			setState(106);
			((HeaderContext)_localctx).device_name = match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UfmoduleBlockContext extends ParserRuleContext {
		public List<UfmoduleStatContext> ufmoduleStat() {
			return getRuleContexts(UfmoduleStatContext.class);
		}
		public UfmoduleStatContext ufmoduleStat(int i) {
			return getRuleContext(UfmoduleStatContext.class,i);
		}
		public UfmoduleBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ufmoduleBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).enterUfmoduleBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).exitUfmoduleBlock(this);
		}
	}

	public final UfmoduleBlockContext ufmoduleBlock() throws RecognitionException {
		UfmoduleBlockContext _localctx = new UfmoduleBlockContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_ufmoduleBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(108);
				ufmoduleStat();
				}
				}
				setState(111); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID_BIG );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UfmoduleStatContext extends ParserRuleContext {
		public UfmodulenameContext ufmodulename() {
			return getRuleContext(UfmodulenameContext.class,0);
		}
		public UfnamesContext ufnames() {
			return getRuleContext(UfnamesContext.class,0);
		}
		public UfmoduleStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ufmoduleStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).enterUfmoduleStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).exitUfmoduleStat(this);
		}
	}

	public final UfmoduleStatContext ufmoduleStat() throws RecognitionException {
		UfmoduleStatContext _localctx = new UfmoduleStatContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_ufmoduleStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			ufmodulename();
			setState(114);
			ufnames();
			setState(115);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LayerBlocksContext extends ParserRuleContext {
		public List<LayerBlockContext> layerBlock() {
			return getRuleContexts(LayerBlockContext.class);
		}
		public LayerBlockContext layerBlock(int i) {
			return getRuleContext(LayerBlockContext.class,i);
		}
		public LayerBlocksContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_layerBlocks; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).enterLayerBlocks(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).exitLayerBlocks(this);
		}
	}

	public final LayerBlocksContext layerBlocks() throws RecognitionException {
		LayerBlocksContext _localctx = new LayerBlocksContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_layerBlocks);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(117);
				layerBlock();
				}
				}
				setState(120); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__4 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LayerBlockContext extends ParserRuleContext {
		public FlowBlockContext flowBlock() {
			return getRuleContext(FlowBlockContext.class,0);
		}
		public ControlBlockContext controlBlock() {
			return getRuleContext(ControlBlockContext.class,0);
		}
		public LayerBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_layerBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).enterLayerBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).exitLayerBlock(this);
		}
	}

	public final LayerBlockContext layerBlock() throws RecognitionException {
		LayerBlockContext _localctx = new LayerBlockContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_layerBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			flowBlock();
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(123);
				controlBlock();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FlowBlockContext extends ParserRuleContext {
		public List<FlowStatContext> flowStat() {
			return getRuleContexts(FlowStatContext.class);
		}
		public FlowStatContext flowStat(int i) {
			return getRuleContext(FlowStatContext.class,i);
		}
		public FlowBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flowBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).enterFlowBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).exitFlowBlock(this);
		}
	}

	public final FlowBlockContext flowBlock() throws RecognitionException {
		FlowBlockContext _localctx = new FlowBlockContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_flowBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(T__4);
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__9) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__16) | (1L << T__18) | (1L << T__32) | (1L << T__33) | (1L << ID_BIG))) != 0)) {
				{
				{
				setState(127);
				flowStat();
				}
				}
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(133);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ControlBlockContext extends ParserRuleContext {
		public List<ControlStatContext> controlStat() {
			return getRuleContexts(ControlStatContext.class);
		}
		public ControlStatContext controlStat(int i) {
			return getRuleContext(ControlStatContext.class,i);
		}
		public ControlBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_controlBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).enterControlBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).exitControlBlock(this);
		}
	}

	public final ControlBlockContext controlBlock() throws RecognitionException {
		ControlBlockContext _localctx = new ControlBlockContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_controlBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(T__6);
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__12) | (1L << T__13) | (1L << T__16) | (1L << T__18) | (1L << T__32) | (1L << T__33) | (1L << ID_BIG))) != 0)) {
				{
				{
				setState(136);
				controlStat();
				}
				}
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(142);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FlowStatContext extends ParserRuleContext {
		public PrimitiveStatContext primitiveStat() {
			return getRuleContext(PrimitiveStatContext.class,0);
		}
		public PrimitiveWithOrientationStatContext primitiveWithOrientationStat() {
			return getRuleContext(PrimitiveWithOrientationStatContext.class,0);
		}
		public NodeStatContext nodeStat() {
			return getRuleContext(NodeStatContext.class,0);
		}
		public ChannelStatContext channelStat() {
			return getRuleContext(ChannelStatContext.class,0);
		}
		public NetStatContext netStat() {
			return getRuleContext(NetStatContext.class,0);
		}
		public ValveStatContext valveStat() {
			return getRuleContext(ValveStatContext.class,0);
		}
		public BankStatContext bankStat() {
			return getRuleContext(BankStatContext.class,0);
		}
		public GridStatContext gridStat() {
			return getRuleContext(GridStatContext.class,0);
		}
		public SpanStatContext spanStat() {
			return getRuleContext(SpanStatContext.class,0);
		}
		public FlowStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flowStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).enterFlowStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).exitFlowStat(this);
		}
	}

	public final FlowStatContext flowStat() throws RecognitionException {
		FlowStatContext _localctx = new FlowStatContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_flowStat);
		try {
			setState(153);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(144);
				primitiveStat();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(145);
				primitiveWithOrientationStat();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(146);
				nodeStat();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(147);
				channelStat();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(148);
				netStat();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(149);
				valveStat();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(150);
				bankStat();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(151);
				gridStat();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(152);
				spanStat();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ControlStatContext extends ParserRuleContext {
		public ValveStatContext valveStat() {
			return getRuleContext(ValveStatContext.class,0);
		}
		public ChannelStatContext channelStat() {
			return getRuleContext(ChannelStatContext.class,0);
		}
		public NetStatContext netStat() {
			return getRuleContext(NetStatContext.class,0);
		}
		public BankStatContext bankStat() {
			return getRuleContext(BankStatContext.class,0);
		}
		public PrimitiveStatContext primitiveStat() {
			return getRuleContext(PrimitiveStatContext.class,0);
		}
		public ControlStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_controlStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).enterControlStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).exitControlStat(this);
		}
	}

	public final ControlStatContext controlStat() throws RecognitionException {
		ControlStatContext _localctx = new ControlStatContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_controlStat);
		try {
			setState(160);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
			case T__13:
				enterOuterAlt(_localctx, 1);
				{
				setState(155);
				valveStat();
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 2);
				{
				setState(156);
				channelStat();
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 3);
				{
				setState(157);
				netStat();
				}
				break;
			case T__7:
			case T__32:
			case T__33:
				enterOuterAlt(_localctx, 4);
				{
				setState(158);
				bankStat();
				}
				break;
			case ID_BIG:
				enterOuterAlt(_localctx, 5);
				{
				setState(159);
				primitiveStat();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimitiveStatContext extends ParserRuleContext {
		public EntityContext entity() {
			return getRuleContext(EntityContext.class,0);
		}
		public UfnamesContext ufnames() {
			return getRuleContext(UfnamesContext.class,0);
		}
		public ParamsStatContext paramsStat() {
			return getRuleContext(ParamsStatContext.class,0);
		}
		public PrimitiveStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).enterPrimitiveStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).exitPrimitiveStat(this);
		}
	}

	public final PrimitiveStatContext primitiveStat() throws RecognitionException {
		PrimitiveStatContext _localctx = new PrimitiveStatContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_primitiveStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			entity();
			setState(163);
			ufnames();
			setState(164);
			paramsStat();
			setState(165);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimitiveWithOrientationStatContext extends ParserRuleContext {
		public OrientationContext orientation() {
			return getRuleContext(OrientationContext.class,0);
		}
		public EntityContext entity() {
			return getRuleContext(EntityContext.class,0);
		}
		public UfnamesContext ufnames() {
			return getRuleContext(UfnamesContext.class,0);
		}
		public ParamsStatContext paramsStat() {
			return getRuleContext(ParamsStatContext.class,0);
		}
		public PrimitiveWithOrientationStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveWithOrientationStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).enterPrimitiveWithOrientationStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).exitPrimitiveWithOrientationStat(this);
		}
	}

	public final PrimitiveWithOrientationStatContext primitiveWithOrientationStat() throws RecognitionException {
		PrimitiveWithOrientationStatContext _localctx = new PrimitiveWithOrientationStatContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_primitiveWithOrientationStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			orientation();
			setState(168);
			entity();
			setState(169);
			ufnames();
			setState(170);
			paramsStat();
			setState(171);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BankStatContext extends ParserRuleContext {
		public Token dim;
		public UfnameContext ufname() {
			return getRuleContext(UfnameContext.class,0);
		}
		public EntityContext entity() {
			return getRuleContext(EntityContext.class,0);
		}
		public ParamsStatContext paramsStat() {
			return getRuleContext(ParamsStatContext.class,0);
		}
		public TerminalNode INT() { return getToken(mintgrammarParser.INT, 0); }
		public OrientationContext orientation() {
			return getRuleContext(OrientationContext.class,0);
		}
		public BankStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bankStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).enterBankStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).exitBankStat(this);
		}
	}

	public final BankStatContext bankStat() throws RecognitionException {
		BankStatContext _localctx = new BankStatContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_bankStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__32 || _la==T__33) {
				{
				setState(173);
				orientation();
				}
			}

			setState(176);
			match(T__7);
			setState(177);
			ufname();
			setState(178);
			match(T__8);
			setState(179);
			((BankStatContext)_localctx).dim = match(INT);
			setState(180);
			entity();
			setState(181);
			paramsStat();
			setState(182);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GridStatContext extends ParserRuleContext {
		public Token xdim;
		public Token ydim;
		public UfnameContext ufname() {
			return getRuleContext(UfnameContext.class,0);
		}
		public EntityContext entity() {
			return getRuleContext(EntityContext.class,0);
		}
		public ParamsStatContext paramsStat() {
			return getRuleContext(ParamsStatContext.class,0);
		}
		public List<TerminalNode> INT() { return getTokens(mintgrammarParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(mintgrammarParser.INT, i);
		}
		public GridStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gridStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).enterGridStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).exitGridStat(this);
		}
	}

	public final GridStatContext gridStat() throws RecognitionException {
		GridStatContext _localctx = new GridStatContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_gridStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			match(T__9);
			setState(185);
			ufname();
			setState(186);
			match(T__8);
			setState(187);
			((GridStatContext)_localctx).xdim = match(INT);
			setState(188);
			match(T__10);
			setState(189);
			((GridStatContext)_localctx).ydim = match(INT);
			setState(190);
			entity();
			setState(191);
			paramsStat();
			setState(192);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SpanStatContext extends ParserRuleContext {
		public EntityContext entity() {
			return getRuleContext(EntityContext.class,0);
		}
		public UfnameContext ufname() {
			return getRuleContext(UfnameContext.class,0);
		}
		public List<TerminalNode> INT() { return getTokens(mintgrammarParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(mintgrammarParser.INT, i);
		}
		public ParamsStatContext paramsStat() {
			return getRuleContext(ParamsStatContext.class,0);
		}
		public OrientationContext orientation() {
			return getRuleContext(OrientationContext.class,0);
		}
		public SpanStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_spanStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).enterSpanStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).exitSpanStat(this);
		}
	}

	public final SpanStatContext spanStat() throws RecognitionException {
		SpanStatContext _localctx = new SpanStatContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_spanStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__32 || _la==T__33) {
				{
				setState(194);
				orientation();
				}
			}

			setState(197);
			entity();
			setState(198);
			ufname();
			setState(199);
			match(INT);
			setState(200);
			match(T__11);
			setState(201);
			match(INT);
			setState(202);
			paramsStat();
			setState(203);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValveStatContext extends ParserRuleContext {
		public Token valve_entity;
		public List<UfnameContext> ufname() {
			return getRuleContexts(UfnameContext.class);
		}
		public UfnameContext ufname(int i) {
			return getRuleContext(UfnameContext.class,i);
		}
		public ParamsStatContext paramsStat() {
			return getRuleContext(ParamsStatContext.class,0);
		}
		public ValveStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valveStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).enterValveStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).exitValveStat(this);
		}
	}

	public final ValveStatContext valveStat() throws RecognitionException {
		ValveStatContext _localctx = new ValveStatContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_valveStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			((ValveStatContext)_localctx).valve_entity = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==T__12 || _la==T__13) ) {
				((ValveStatContext)_localctx).valve_entity = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(206);
			ufname();
			setState(207);
			match(T__14);
			setState(208);
			ufname();
			setState(209);
			paramsStat();
			setState(210);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NodeStatContext extends ParserRuleContext {
		public UfnamesContext ufnames() {
			return getRuleContext(UfnamesContext.class,0);
		}
		public NodeStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nodeStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).enterNodeStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).exitNodeStat(this);
		}
	}

	public final NodeStatContext nodeStat() throws RecognitionException {
		NodeStatContext _localctx = new NodeStatContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_nodeStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			match(T__15);
			setState(213);
			ufnames();
			setState(214);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ChannelStatContext extends ParserRuleContext {
		public UftargetContext source;
		public UftargetContext sink;
		public UfnameContext ufname() {
			return getRuleContext(UfnameContext.class,0);
		}
		public WidthParamContext widthParam() {
			return getRuleContext(WidthParamContext.class,0);
		}
		public List<UftargetContext> uftarget() {
			return getRuleContexts(UftargetContext.class);
		}
		public UftargetContext uftarget(int i) {
			return getRuleContext(UftargetContext.class,i);
		}
		public ChannelStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_channelStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).enterChannelStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).exitChannelStat(this);
		}
	}

	public final ChannelStatContext channelStat() throws RecognitionException {
		ChannelStatContext _localctx = new ChannelStatContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_channelStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			match(T__16);
			setState(217);
			ufname();
			setState(218);
			match(T__17);
			setState(219);
			((ChannelStatContext)_localctx).source = uftarget();
			setState(220);
			match(T__11);
			setState(221);
			((ChannelStatContext)_localctx).sink = uftarget();
			setState(222);
			widthParam();
			setState(223);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NetStatContext extends ParserRuleContext {
		public UftargetContext source;
		public UftargetsContext sinks;
		public UfnameContext ufname() {
			return getRuleContext(UfnameContext.class,0);
		}
		public WidthParamContext widthParam() {
			return getRuleContext(WidthParamContext.class,0);
		}
		public UftargetContext uftarget() {
			return getRuleContext(UftargetContext.class,0);
		}
		public UftargetsContext uftargets() {
			return getRuleContext(UftargetsContext.class,0);
		}
		public NetStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_netStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).enterNetStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).exitNetStat(this);
		}
	}

	public final NetStatContext netStat() throws RecognitionException {
		NetStatContext _localctx = new NetStatContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_netStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			match(T__18);
			setState(226);
			ufname();
			setState(227);
			match(T__17);
			setState(228);
			((NetStatContext)_localctx).source = uftarget();
			setState(229);
			match(T__11);
			setState(230);
			((NetStatContext)_localctx).sinks = uftargets();
			setState(231);
			widthParam();
			setState(232);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EntityContext extends ParserRuleContext {
		public List<Entity_elementContext> entity_element() {
			return getRuleContexts(Entity_elementContext.class);
		}
		public Entity_elementContext entity_element(int i) {
			return getRuleContext(Entity_elementContext.class,i);
		}
		public EntityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entity; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).enterEntity(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).exitEntity(this);
		}
	}

	public final EntityContext entity() throws RecognitionException {
		EntityContext _localctx = new EntityContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_entity);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(234);
				entity_element();
				}
				}
				setState(237); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID_BIG );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Entity_elementContext extends ParserRuleContext {
		public TerminalNode ID_BIG() { return getToken(mintgrammarParser.ID_BIG, 0); }
		public Entity_elementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entity_element; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).enterEntity_element(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).exitEntity_element(this);
		}
	}

	public final Entity_elementContext entity_element() throws RecognitionException {
		Entity_elementContext _localctx = new Entity_elementContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_entity_element);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			match(ID_BIG);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamsStatContext extends ParserRuleContext {
		public List<ParamStatContext> paramStat() {
			return getRuleContexts(ParamStatContext.class);
		}
		public ParamStatContext paramStat(int i) {
			return getRuleContext(ParamStatContext.class,i);
		}
		public ParamsStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramsStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).enterParamsStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).exitParamsStat(this);
		}
	}

	public final ParamsStatContext paramsStat() throws RecognitionException {
		ParamsStatContext _localctx = new ParamsStatContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_paramsStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__28) | (1L << T__29) | (1L << ID))) != 0)) {
				{
				{
				setState(241);
				paramStat();
				}
				}
				setState(246);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamStatContext extends ParserRuleContext {
		public IntParamContext intParam() {
			return getRuleContext(IntParamContext.class,0);
		}
		public BoolParamContext boolParam() {
			return getRuleContext(BoolParamContext.class,0);
		}
		public VerticalDirectionParamContext verticalDirectionParam() {
			return getRuleContext(VerticalDirectionParamContext.class,0);
		}
		public HorizontalDirectionParamContext horizontalDirectionParam() {
			return getRuleContext(HorizontalDirectionParamContext.class,0);
		}
		public VerticalConnectionParamContext verticalConnectionParam() {
			return getRuleContext(VerticalConnectionParamContext.class,0);
		}
		public HorizontalConnectParamContext horizontalConnectParam() {
			return getRuleContext(HorizontalConnectParamContext.class,0);
		}
		public WidthParamContext widthParam() {
			return getRuleContext(WidthParamContext.class,0);
		}
		public ParamStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).enterParamStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).exitParamStat(this);
		}
	}

	public final ParamStatContext paramStat() throws RecognitionException {
		ParamStatContext _localctx = new ParamStatContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_paramStat);
		try {
			setState(254);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(247);
				intParam();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(248);
				boolParam();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(249);
				verticalDirectionParam();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(250);
				horizontalDirectionParam();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(251);
				verticalConnectionParam();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(252);
				horizontalConnectParam();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(253);
				widthParam();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Param_elementContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(mintgrammarParser.ID, 0); }
		public Param_elementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_element; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).enterParam_element(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).exitParam_element(this);
		}
	}

	public final Param_elementContext param_element() throws RecognitionException {
		Param_elementContext _localctx = new Param_elementContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_param_element);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntParamContext extends ParserRuleContext {
		public Param_elementContext param_element() {
			return getRuleContext(Param_elementContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public IntParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).enterIntParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).exitIntParam(this);
		}
	}

	public final IntParamContext intParam() throws RecognitionException {
		IntParamContext _localctx = new IntParamContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_intParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			param_element();
			setState(259);
			match(T__19);
			setState(260);
			value();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoolParamContext extends ParserRuleContext {
		public Param_elementContext param_element() {
			return getRuleContext(Param_elementContext.class,0);
		}
		public BoolvalueContext boolvalue() {
			return getRuleContext(BoolvalueContext.class,0);
		}
		public BoolParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).enterBoolParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).exitBoolParam(this);
		}
	}

	public final BoolParamContext boolParam() throws RecognitionException {
		BoolParamContext _localctx = new BoolParamContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_boolParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			param_element();
			setState(263);
			match(T__19);
			setState(264);
			boolvalue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WidthParamContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public WidthParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_widthParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).enterWidthParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).exitWidthParam(this);
		}
	}

	public final WidthParamContext widthParam() throws RecognitionException {
		WidthParamContext _localctx = new WidthParamContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_widthParam);
		try {
			setState(275);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__20:
				enterOuterAlt(_localctx, 1);
				{
				setState(266);
				match(T__20);
				setState(267);
				match(T__19);
				setState(268);
				value();
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 2);
				{
				setState(269);
				match(T__21);
				setState(270);
				match(T__19);
				setState(271);
				value();
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 3);
				{
				setState(272);
				match(T__22);
				setState(273);
				match(T__19);
				setState(274);
				value();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VerticalDirectionParamContext extends ParserRuleContext {
		public Token dir;
		public VerticalDirectionParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_verticalDirectionParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).enterVerticalDirectionParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).exitVerticalDirectionParam(this);
		}
	}

	public final VerticalDirectionParamContext verticalDirectionParam() throws RecognitionException {
		VerticalDirectionParamContext _localctx = new VerticalDirectionParamContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_verticalDirectionParam);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			match(T__23);
			setState(278);
			match(T__19);
			setState(279);
			((VerticalDirectionParamContext)_localctx).dir = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==T__24 || _la==T__25) ) {
				((VerticalDirectionParamContext)_localctx).dir = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HorizontalDirectionParamContext extends ParserRuleContext {
		public Token dir;
		public HorizontalDirectionParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_horizontalDirectionParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).enterHorizontalDirectionParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).exitHorizontalDirectionParam(this);
		}
	}

	public final HorizontalDirectionParamContext horizontalDirectionParam() throws RecognitionException {
		HorizontalDirectionParamContext _localctx = new HorizontalDirectionParamContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_horizontalDirectionParam);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			match(T__23);
			setState(282);
			match(T__19);
			setState(283);
			((HorizontalDirectionParamContext)_localctx).dir = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==T__26 || _la==T__27) ) {
				((HorizontalDirectionParamContext)_localctx).dir = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HorizontalConnectParamContext extends ParserRuleContext {
		public BoolvalueContext boolvalue() {
			return getRuleContext(BoolvalueContext.class,0);
		}
		public HorizontalConnectParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_horizontalConnectParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).enterHorizontalConnectParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).exitHorizontalConnectParam(this);
		}
	}

	public final HorizontalConnectParamContext horizontalConnectParam() throws RecognitionException {
		HorizontalConnectParamContext _localctx = new HorizontalConnectParamContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_horizontalConnectParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			match(T__28);
			setState(286);
			match(T__19);
			setState(287);
			boolvalue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VerticalConnectionParamContext extends ParserRuleContext {
		public BoolvalueContext boolvalue() {
			return getRuleContext(BoolvalueContext.class,0);
		}
		public VerticalConnectionParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_verticalConnectionParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).enterVerticalConnectionParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).exitVerticalConnectionParam(this);
		}
	}

	public final VerticalConnectionParamContext verticalConnectionParam() throws RecognitionException {
		VerticalConnectionParamContext _localctx = new VerticalConnectionParamContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_verticalConnectionParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
			match(T__29);
			setState(290);
			match(T__19);
			setState(291);
			boolvalue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UfmodulenameContext extends ParserRuleContext {
		public TerminalNode ID_BIG() { return getToken(mintgrammarParser.ID_BIG, 0); }
		public UfmodulenameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ufmodulename; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).enterUfmodulename(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).exitUfmodulename(this);
		}
	}

	public final UfmodulenameContext ufmodulename() throws RecognitionException {
		UfmodulenameContext _localctx = new UfmodulenameContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_ufmodulename);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			match(ID_BIG);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UfterminalContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(mintgrammarParser.INT, 0); }
		public UfterminalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ufterminal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).enterUfterminal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).exitUfterminal(this);
		}
	}

	public final UfterminalContext ufterminal() throws RecognitionException {
		UfterminalContext _localctx = new UfterminalContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_ufterminal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(295);
			match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UftargetsContext extends ParserRuleContext {
		public List<UftargetContext> uftarget() {
			return getRuleContexts(UftargetContext.class);
		}
		public UftargetContext uftarget(int i) {
			return getRuleContext(UftargetContext.class,i);
		}
		public UftargetsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_uftargets; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).enterUftargets(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).exitUftargets(this);
		}
	}

	public final UftargetsContext uftargets() throws RecognitionException {
		UftargetsContext _localctx = new UftargetsContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_uftargets);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(297);
			uftarget();
			setState(300); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(298);
				match(T__10);
				setState(299);
				uftarget();
				}
				}
				setState(302); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__10 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UftargetContext extends ParserRuleContext {
		public Token target_name;
		public Token target_terminal;
		public TerminalNode ID() { return getToken(mintgrammarParser.ID, 0); }
		public TerminalNode INT() { return getToken(mintgrammarParser.INT, 0); }
		public UftargetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_uftarget; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).enterUftarget(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).exitUftarget(this);
		}
	}

	public final UftargetContext uftarget() throws RecognitionException {
		UftargetContext _localctx = new UftargetContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_uftarget);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(304);
			((UftargetContext)_localctx).target_name = match(ID);
			setState(306);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INT) {
				{
				setState(305);
				((UftargetContext)_localctx).target_terminal = match(INT);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UfnameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(mintgrammarParser.ID, 0); }
		public UfnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ufname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).enterUfname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).exitUfname(this);
		}
	}

	public final UfnameContext ufname() throws RecognitionException {
		UfnameContext _localctx = new UfnameContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_ufname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UfnamesContext extends ParserRuleContext {
		public List<UfnameContext> ufname() {
			return getRuleContexts(UfnameContext.class);
		}
		public UfnameContext ufname(int i) {
			return getRuleContext(UfnameContext.class,i);
		}
		public UfnamesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ufnames; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).enterUfnames(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).exitUfnames(this);
		}
	}

	public final UfnamesContext ufnames() throws RecognitionException {
		UfnamesContext _localctx = new UfnamesContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_ufnames);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(310);
			ufname();
			setState(315);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(311);
				match(T__10);
				setState(312);
				ufname();
				}
				}
				setState(317);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(mintgrammarParser.INT, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).exitValue(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(318);
			match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoolvalueContext extends ParserRuleContext {
		public BoolvalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolvalue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).enterBoolvalue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).exitBoolvalue(this);
		}
	}

	public final BoolvalueContext boolvalue() throws RecognitionException {
		BoolvalueContext _localctx = new BoolvalueContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_boolvalue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			_la = _input.LA(1);
			if ( !(_la==T__30 || _la==T__31) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrientationContext extends ParserRuleContext {
		public OrientationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orientation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).enterOrientation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).exitOrientation(this);
		}
	}

	public final OrientationContext orientation() throws RecognitionException {
		OrientationContext _localctx = new OrientationContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_orientation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(322);
			_la = _input.LA(1);
			if ( !(_la==T__32 || _la==T__33) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3)\u0147\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\3"+
		"\2\5\2X\n\2\3\2\3\2\5\2\\\n\2\3\2\3\2\3\2\3\3\6\3b\n\3\r\3\16\3c\3\4\3"+
		"\4\3\4\3\5\5\5j\n\5\3\5\3\5\3\5\3\6\6\6p\n\6\r\6\16\6q\3\7\3\7\3\7\3\7"+
		"\3\b\6\by\n\b\r\b\16\bz\3\t\3\t\5\t\177\n\t\3\n\3\n\7\n\u0083\n\n\f\n"+
		"\16\n\u0086\13\n\3\n\3\n\3\13\3\13\7\13\u008c\n\13\f\13\16\13\u008f\13"+
		"\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u009c\n\f\3\r\3"+
		"\r\3\r\3\r\3\r\5\r\u00a3\n\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\20\5\20\u00b1\n\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\5\22\u00c6"+
		"\n\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\6\27\u00ee\n\27"+
		"\r\27\16\27\u00ef\3\30\3\30\3\31\7\31\u00f5\n\31\f\31\16\31\u00f8\13\31"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u0101\n\32\3\33\3\33\3\34\3\34"+
		"\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\5\36\u0116\n\36\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3!\3!\3!\3!\3\""+
		"\3\"\3\"\3\"\3#\3#\3$\3$\3%\3%\3%\6%\u012f\n%\r%\16%\u0130\3&\3&\5&\u0135"+
		"\n&\3\'\3\'\3(\3(\3(\7(\u013c\n(\f(\16(\u013f\13(\3)\3)\3*\3*\3+\3+\3"+
		"+\2\2,\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<"+
		">@BDFHJLNPRT\2\7\3\2\17\20\3\2\33\34\3\2\35\36\3\2!\"\3\2#$\2\u0140\2"+
		"W\3\2\2\2\4a\3\2\2\2\6e\3\2\2\2\bi\3\2\2\2\no\3\2\2\2\fs\3\2\2\2\16x\3"+
		"\2\2\2\20|\3\2\2\2\22\u0080\3\2\2\2\24\u0089\3\2\2\2\26\u009b\3\2\2\2"+
		"\30\u00a2\3\2\2\2\32\u00a4\3\2\2\2\34\u00a9\3\2\2\2\36\u00b0\3\2\2\2 "+
		"\u00ba\3\2\2\2\"\u00c5\3\2\2\2$\u00cf\3\2\2\2&\u00d6\3\2\2\2(\u00da\3"+
		"\2\2\2*\u00e3\3\2\2\2,\u00ed\3\2\2\2.\u00f1\3\2\2\2\60\u00f6\3\2\2\2\62"+
		"\u0100\3\2\2\2\64\u0102\3\2\2\2\66\u0104\3\2\2\28\u0108\3\2\2\2:\u0115"+
		"\3\2\2\2<\u0117\3\2\2\2>\u011b\3\2\2\2@\u011f\3\2\2\2B\u0123\3\2\2\2D"+
		"\u0127\3\2\2\2F\u0129\3\2\2\2H\u012b\3\2\2\2J\u0132\3\2\2\2L\u0136\3\2"+
		"\2\2N\u0138\3\2\2\2P\u0140\3\2\2\2R\u0142\3\2\2\2T\u0144\3\2\2\2VX\5\4"+
		"\3\2WV\3\2\2\2WX\3\2\2\2XY\3\2\2\2Y[\5\b\5\2Z\\\5\n\6\2[Z\3\2\2\2[\\\3"+
		"\2\2\2\\]\3\2\2\2]^\5\16\b\2^_\7\2\2\3_\3\3\2\2\2`b\5\6\4\2a`\3\2\2\2"+
		"bc\3\2\2\2ca\3\2\2\2cd\3\2\2\2d\5\3\2\2\2ef\7\3\2\2fg\5D#\2g\7\3\2\2\2"+
		"hj\7\4\2\2ih\3\2\2\2ij\3\2\2\2jk\3\2\2\2kl\7\5\2\2lm\7%\2\2m\t\3\2\2\2"+
		"np\5\f\7\2on\3\2\2\2pq\3\2\2\2qo\3\2\2\2qr\3\2\2\2r\13\3\2\2\2st\5D#\2"+
		"tu\5N(\2uv\7\6\2\2v\r\3\2\2\2wy\5\20\t\2xw\3\2\2\2yz\3\2\2\2zx\3\2\2\2"+
		"z{\3\2\2\2{\17\3\2\2\2|~\5\22\n\2}\177\5\24\13\2~}\3\2\2\2~\177\3\2\2"+
		"\2\177\21\3\2\2\2\u0080\u0084\7\7\2\2\u0081\u0083\5\26\f\2\u0082\u0081"+
		"\3\2\2\2\u0083\u0086\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085"+
		"\u0087\3\2\2\2\u0086\u0084\3\2\2\2\u0087\u0088\7\b\2\2\u0088\23\3\2\2"+
		"\2\u0089\u008d\7\t\2\2\u008a\u008c\5\30\r\2\u008b\u008a\3\2\2\2\u008c"+
		"\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u0090\3\2"+
		"\2\2\u008f\u008d\3\2\2\2\u0090\u0091\7\b\2\2\u0091\25\3\2\2\2\u0092\u009c"+
		"\5\32\16\2\u0093\u009c\5\34\17\2\u0094\u009c\5&\24\2\u0095\u009c\5(\25"+
		"\2\u0096\u009c\5*\26\2\u0097\u009c\5$\23\2\u0098\u009c\5\36\20\2\u0099"+
		"\u009c\5 \21\2\u009a\u009c\5\"\22\2\u009b\u0092\3\2\2\2\u009b\u0093\3"+
		"\2\2\2\u009b\u0094\3\2\2\2\u009b\u0095\3\2\2\2\u009b\u0096\3\2\2\2\u009b"+
		"\u0097\3\2\2\2\u009b\u0098\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009a\3\2"+
		"\2\2\u009c\27\3\2\2\2\u009d\u00a3\5$\23\2\u009e\u00a3\5(\25\2\u009f\u00a3"+
		"\5*\26\2\u00a0\u00a3\5\36\20\2\u00a1\u00a3\5\32\16\2\u00a2\u009d\3\2\2"+
		"\2\u00a2\u009e\3\2\2\2\u00a2\u009f\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a1"+
		"\3\2\2\2\u00a3\31\3\2\2\2\u00a4\u00a5\5,\27\2\u00a5\u00a6\5N(\2\u00a6"+
		"\u00a7\5\60\31\2\u00a7\u00a8\7\6\2\2\u00a8\33\3\2\2\2\u00a9\u00aa\5T+"+
		"\2\u00aa\u00ab\5,\27\2\u00ab\u00ac\5N(\2\u00ac\u00ad\5\60\31\2\u00ad\u00ae"+
		"\7\6\2\2\u00ae\35\3\2\2\2\u00af\u00b1\5T+\2\u00b0\u00af\3\2\2\2\u00b0"+
		"\u00b1\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3\7\n\2\2\u00b3\u00b4\5L"+
		"\'\2\u00b4\u00b5\7\13\2\2\u00b5\u00b6\7\'\2\2\u00b6\u00b7\5,\27\2\u00b7"+
		"\u00b8\5\60\31\2\u00b8\u00b9\7\6\2\2\u00b9\37\3\2\2\2\u00ba\u00bb\7\f"+
		"\2\2\u00bb\u00bc\5L\'\2\u00bc\u00bd\7\13\2\2\u00bd\u00be\7\'\2\2\u00be"+
		"\u00bf\7\r\2\2\u00bf\u00c0\7\'\2\2\u00c0\u00c1\5,\27\2\u00c1\u00c2\5\60"+
		"\31\2\u00c2\u00c3\7\6\2\2\u00c3!\3\2\2\2\u00c4\u00c6\5T+\2\u00c5\u00c4"+
		"\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c8\5,\27\2\u00c8"+
		"\u00c9\5L\'\2\u00c9\u00ca\7\'\2\2\u00ca\u00cb\7\16\2\2\u00cb\u00cc\7\'"+
		"\2\2\u00cc\u00cd\5\60\31\2\u00cd\u00ce\7\6\2\2\u00ce#\3\2\2\2\u00cf\u00d0"+
		"\t\2\2\2\u00d0\u00d1\5L\'\2\u00d1\u00d2\7\21\2\2\u00d2\u00d3\5L\'\2\u00d3"+
		"\u00d4\5\60\31\2\u00d4\u00d5\7\6\2\2\u00d5%\3\2\2\2\u00d6\u00d7\7\22\2"+
		"\2\u00d7\u00d8\5N(\2\u00d8\u00d9\7\6\2\2\u00d9\'\3\2\2\2\u00da\u00db\7"+
		"\23\2\2\u00db\u00dc\5L\'\2\u00dc\u00dd\7\24\2\2\u00dd\u00de\5J&\2\u00de"+
		"\u00df\7\16\2\2\u00df\u00e0\5J&\2\u00e0\u00e1\5:\36\2\u00e1\u00e2\7\6"+
		"\2\2\u00e2)\3\2\2\2\u00e3\u00e4\7\25\2\2\u00e4\u00e5\5L\'\2\u00e5\u00e6"+
		"\7\24\2\2\u00e6\u00e7\5J&\2\u00e7\u00e8\7\16\2\2\u00e8\u00e9\5H%\2\u00e9"+
		"\u00ea\5:\36\2\u00ea\u00eb\7\6\2\2\u00eb+\3\2\2\2\u00ec\u00ee\5.\30\2"+
		"\u00ed\u00ec\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00ed\3\2\2\2\u00ef\u00f0"+
		"\3\2\2\2\u00f0-\3\2\2\2\u00f1\u00f2\7&\2\2\u00f2/\3\2\2\2\u00f3\u00f5"+
		"\5\62\32\2\u00f4\u00f3\3\2\2\2\u00f5\u00f8\3\2\2\2\u00f6\u00f4\3\2\2\2"+
		"\u00f6\u00f7\3\2\2\2\u00f7\61\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f9\u0101"+
		"\5\66\34\2\u00fa\u0101\58\35\2\u00fb\u0101\5<\37\2\u00fc\u0101\5> \2\u00fd"+
		"\u0101\5B\"\2\u00fe\u0101\5@!\2\u00ff\u0101\5:\36\2\u0100\u00f9\3\2\2"+
		"\2\u0100\u00fa\3\2\2\2\u0100\u00fb\3\2\2\2\u0100\u00fc\3\2\2\2\u0100\u00fd"+
		"\3\2\2\2\u0100\u00fe\3\2\2\2\u0100\u00ff\3\2\2\2\u0101\63\3\2\2\2\u0102"+
		"\u0103\7%\2\2\u0103\65\3\2\2\2\u0104\u0105\5\64\33\2\u0105\u0106\7\26"+
		"\2\2\u0106\u0107\5P)\2\u0107\67\3\2\2\2\u0108\u0109\5\64\33\2\u0109\u010a"+
		"\7\26\2\2\u010a\u010b\5R*\2\u010b9\3\2\2\2\u010c\u010d\7\27\2\2\u010d"+
		"\u010e\7\26\2\2\u010e\u0116\5P)\2\u010f\u0110\7\30\2\2\u0110\u0111\7\26"+
		"\2\2\u0111\u0116\5P)\2\u0112\u0113\7\31\2\2\u0113\u0114\7\26\2\2\u0114"+
		"\u0116\5P)\2\u0115\u010c\3\2\2\2\u0115\u010f\3\2\2\2\u0115\u0112\3\2\2"+
		"\2\u0116;\3\2\2\2\u0117\u0118\7\32\2\2\u0118\u0119\7\26\2\2\u0119\u011a"+
		"\t\3\2\2\u011a=\3\2\2\2\u011b\u011c\7\32\2\2\u011c\u011d\7\26\2\2\u011d"+
		"\u011e\t\4\2\2\u011e?\3\2\2\2\u011f\u0120\7\37\2\2\u0120\u0121\7\26\2"+
		"\2\u0121\u0122\5R*\2\u0122A\3\2\2\2\u0123\u0124\7 \2\2\u0124\u0125\7\26"+
		"\2\2\u0125\u0126\5R*\2\u0126C\3\2\2\2\u0127\u0128\7&\2\2\u0128E\3\2\2"+
		"\2\u0129\u012a\7\'\2\2\u012aG\3\2\2\2\u012b\u012e\5J&\2\u012c\u012d\7"+
		"\r\2\2\u012d\u012f\5J&\2\u012e\u012c\3\2\2\2\u012f\u0130\3\2\2\2\u0130"+
		"\u012e\3\2\2\2\u0130\u0131\3\2\2\2\u0131I\3\2\2\2\u0132\u0134\7%\2\2\u0133"+
		"\u0135\7\'\2\2\u0134\u0133\3\2\2\2\u0134\u0135\3\2\2\2\u0135K\3\2\2\2"+
		"\u0136\u0137\7%\2\2\u0137M\3\2\2\2\u0138\u013d\5L\'\2\u0139\u013a\7\r"+
		"\2\2\u013a\u013c\5L\'\2\u013b\u0139\3\2\2\2\u013c\u013f\3\2\2\2\u013d"+
		"\u013b\3\2\2\2\u013d\u013e\3\2\2\2\u013eO\3\2\2\2\u013f\u013d\3\2\2\2"+
		"\u0140\u0141\7\'\2\2\u0141Q\3\2\2\2\u0142\u0143\t\5\2\2\u0143S\3\2\2\2"+
		"\u0144\u0145\t\6\2\2\u0145U\3\2\2\2\26W[ciqz~\u0084\u008d\u009b\u00a2"+
		"\u00b0\u00c5\u00ef\u00f6\u0100\u0115\u0130\u0134\u013d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}