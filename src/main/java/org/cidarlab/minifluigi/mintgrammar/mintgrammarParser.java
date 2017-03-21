// Generated from /Users/krishna/CIDAR/MiniFluigi/src/main/ANTLR/mintgrammar.g4 by ANTLR 4.6
package org.cidarlab.minifluigi.mintgrammar;
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
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, ID_BIG=34, ID_SMALL=35, INT=36, WS=37, COMMENT=38;
	public static final int
		RULE_netlist = 0, RULE_importBlock = 1, RULE_importStat = 2, RULE_header = 3, 
		RULE_ufmoduleBlock = 4, RULE_ufmoduleStat = 5, RULE_layerBlocks = 6, RULE_layerBlock = 7, 
		RULE_flowBlock = 8, RULE_controlBlock = 9, RULE_flowStat = 10, RULE_controlStat = 11, 
		RULE_primitiveStat = 12, RULE_compositeStat = 13, RULE_bankStat = 14, 
		RULE_gridStat = 15, RULE_spanStat = 16, RULE_valveStat = 17, RULE_channelStat = 18, 
		RULE_netStat = 19, RULE_entity = 20, RULE_entity_element = 21, RULE_paramsStat = 22, 
		RULE_paramStat = 23, RULE_param_element = 24, RULE_widthParam = 25, RULE_verticalDirectionParam = 26, 
		RULE_horizontalDirectionParam = 27, RULE_horizontalConnectParam = 28, 
		RULE_verticalConnectionParam = 29, RULE_ufmodulename = 30, RULE_ufterminal = 31, 
		RULE_uftargets = 32, RULE_uftarget = 33, RULE_ufname = 34, RULE_ufnames = 35, 
		RULE_value = 36, RULE_boolvalue = 37;
	public static final String[] ruleNames = {
		"netlist", "importBlock", "importStat", "header", "ufmoduleBlock", "ufmoduleStat", 
		"layerBlocks", "layerBlock", "flowBlock", "controlBlock", "flowStat", 
		"controlStat", "primitiveStat", "compositeStat", "bankStat", "gridStat", 
		"spanStat", "valveStat", "channelStat", "netStat", "entity", "entity_element", 
		"paramsStat", "paramStat", "param_element", "widthParam", "verticalDirectionParam", 
		"horizontalDirectionParam", "horizontalConnectParam", "verticalConnectionParam", 
		"ufmodulename", "ufterminal", "uftargets", "uftarget", "ufname", "ufnames", 
		"value", "boolvalue"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'IMPORT'", "'3D'", "'DEVICE'", "';'", "'LAYER FLOW'", "'END LAYER'", 
		"'LAYER CONTROL'", "'V'", "'H'", "'BANK'", "'of'", "'GRID'", "','", "'to'", 
		"'VALVE'", "'3DVALVE'", "'on'", "'CHANNEL'", "'from'", "'NET'", "'='", 
		"'width'", "'w'", "'channelWidth'", "'dir'", "'RIGHT'", "'LEFT'", "'UP'", 
		"'DOWN'", "'horizontalConnect'", "'verticalConnect'", "'YES'", "'NO'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, "ID_BIG", 
		"ID_SMALL", "INT", "WS", "COMMENT"
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
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(76);
				importBlock();
				}
			}

			setState(79);
			header();
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID_BIG) {
				{
				setState(80);
				ufmoduleBlock();
				}
			}

			setState(83);
			layerBlocks();
			setState(84);
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
			setState(87); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(86);
				importStat();
				}
				}
				setState(89); 
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
			setState(91);
			match(T__0);
			setState(92);
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
		public TerminalNode ID_SMALL() { return getToken(mintgrammarParser.ID_SMALL, 0); }
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
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(94);
				((HeaderContext)_localctx).tag = match(T__1);
				}
			}

			setState(97);
			match(T__2);
			setState(98);
			match(ID_SMALL);
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
			setState(101); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(100);
				ufmoduleStat();
				}
				}
				setState(103); 
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
			setState(105);
			ufmodulename();
			setState(106);
			ufnames();
			setState(107);
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
			setState(110); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(109);
				layerBlock();
				}
				}
				setState(112); 
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
			setState(114);
			flowBlock();
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(115);
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
		public FlowStatContext s;
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
			setState(118);
			match(T__4);
			setState(120); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(119);
				((FlowBlockContext)_localctx).s = flowStat();
				}
				}
				setState(122); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__11) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__19) | (1L << ID_BIG))) != 0) );
			setState(124);
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
		public ControlStatContext s;
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
			setState(126);
			match(T__6);
			setState(128); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(127);
				((ControlBlockContext)_localctx).s = controlStat();
				}
				}
				setState(130); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__19) | (1L << ID_BIG))) != 0) );
			setState(132);
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
		public CompositeStatContext compositeStat() {
			return getRuleContext(CompositeStatContext.class,0);
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
			setState(142);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(134);
				primitiveStat();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(135);
				compositeStat();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(136);
				channelStat();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(137);
				netStat();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(138);
				valveStat();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(139);
				bankStat();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(140);
				gridStat();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(141);
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
			setState(149);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__14:
			case T__15:
				enterOuterAlt(_localctx, 1);
				{
				setState(144);
				valveStat();
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 2);
				{
				setState(145);
				channelStat();
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 3);
				{
				setState(146);
				netStat();
				}
				break;
			case T__7:
			case T__8:
			case T__9:
				enterOuterAlt(_localctx, 4);
				{
				setState(147);
				bankStat();
				}
				break;
			case ID_BIG:
				enterOuterAlt(_localctx, 5);
				{
				setState(148);
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
			setState(151);
			entity();
			setState(152);
			ufnames();
			setState(153);
			paramsStat();
			setState(154);
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

	public static class CompositeStatContext extends ParserRuleContext {
		public EntityContext entity() {
			return getRuleContext(EntityContext.class,0);
		}
		public UfnamesContext ufnames() {
			return getRuleContext(UfnamesContext.class,0);
		}
		public ParamsStatContext paramsStat() {
			return getRuleContext(ParamsStatContext.class,0);
		}
		public CompositeStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compositeStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).enterCompositeStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).exitCompositeStat(this);
		}
	}

	public final CompositeStatContext compositeStat() throws RecognitionException {
		CompositeStatContext _localctx = new CompositeStatContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_compositeStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7 || _la==T__8) {
				{
				setState(156);
				_la = _input.LA(1);
				if ( !(_la==T__7 || _la==T__8) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(159);
			entity();
			setState(160);
			ufnames();
			setState(161);
			paramsStat();
			setState(162);
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
		public UfnameContext ufname() {
			return getRuleContext(UfnameContext.class,0);
		}
		public TerminalNode INT() { return getToken(mintgrammarParser.INT, 0); }
		public EntityContext entity() {
			return getRuleContext(EntityContext.class,0);
		}
		public ParamsStatContext paramsStat() {
			return getRuleContext(ParamsStatContext.class,0);
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
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7 || _la==T__8) {
				{
				setState(164);
				_la = _input.LA(1);
				if ( !(_la==T__7 || _la==T__8) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(167);
			match(T__9);
			setState(168);
			ufname();
			setState(169);
			match(T__10);
			setState(170);
			match(INT);
			setState(171);
			entity();
			setState(172);
			paramsStat();
			setState(173);
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
		public UfnameContext ufname() {
			return getRuleContext(UfnameContext.class,0);
		}
		public List<TerminalNode> INT() { return getTokens(mintgrammarParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(mintgrammarParser.INT, i);
		}
		public EntityContext entity() {
			return getRuleContext(EntityContext.class,0);
		}
		public ParamsStatContext paramsStat() {
			return getRuleContext(ParamsStatContext.class,0);
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
			setState(175);
			match(T__11);
			setState(176);
			ufname();
			setState(177);
			match(T__10);
			setState(178);
			match(INT);
			setState(179);
			match(T__12);
			setState(180);
			match(INT);
			setState(181);
			entity();
			setState(182);
			paramsStat();
			setState(183);
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
			setState(186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7 || _la==T__8) {
				{
				setState(185);
				_la = _input.LA(1);
				if ( !(_la==T__7 || _la==T__8) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(188);
			entity();
			setState(189);
			ufname();
			setState(190);
			match(INT);
			setState(191);
			match(T__13);
			setState(192);
			match(INT);
			setState(193);
			paramsStat();
			setState(194);
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
			setState(196);
			_la = _input.LA(1);
			if ( !(_la==T__14 || _la==T__15) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(197);
			ufname();
			setState(198);
			match(T__16);
			setState(199);
			ufname();
			setState(200);
			paramsStat();
			setState(201);
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
		public UfnameContext ufname() {
			return getRuleContext(UfnameContext.class,0);
		}
		public List<UftargetContext> uftarget() {
			return getRuleContexts(UftargetContext.class);
		}
		public UftargetContext uftarget(int i) {
			return getRuleContext(UftargetContext.class,i);
		}
		public WidthParamContext widthParam() {
			return getRuleContext(WidthParamContext.class,0);
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
		enterRule(_localctx, 36, RULE_channelStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			match(T__17);
			setState(204);
			ufname();
			setState(205);
			match(T__18);
			setState(206);
			uftarget();
			setState(207);
			match(T__13);
			setState(208);
			uftarget();
			setState(209);
			widthParam();
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

	public static class NetStatContext extends ParserRuleContext {
		public Token source_name;
		public Token source_terminal;
		public UfnameContext ufname() {
			return getRuleContext(UfnameContext.class,0);
		}
		public UftargetsContext uftargets() {
			return getRuleContext(UftargetsContext.class,0);
		}
		public WidthParamContext widthParam() {
			return getRuleContext(WidthParamContext.class,0);
		}
		public TerminalNode ID_SMALL() { return getToken(mintgrammarParser.ID_SMALL, 0); }
		public TerminalNode INT() { return getToken(mintgrammarParser.INT, 0); }
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
		enterRule(_localctx, 38, RULE_netStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			match(T__19);
			setState(213);
			ufname();
			setState(214);
			match(T__18);
			setState(215);
			((NetStatContext)_localctx).source_name = match(ID_SMALL);
			setState(216);
			((NetStatContext)_localctx).source_terminal = match(INT);
			setState(217);
			match(T__13);
			setState(218);
			uftargets();
			setState(219);
			widthParam();
			setState(220);
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
		enterRule(_localctx, 40, RULE_entity);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(222);
				entity_element();
				}
				}
				setState(225); 
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
		enterRule(_localctx, 42, RULE_entity_element);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
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
		enterRule(_localctx, 44, RULE_paramsStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__29) | (1L << T__30) | (1L << ID_SMALL))) != 0)) {
				{
				{
				setState(229);
				paramStat();
				}
				}
				setState(234);
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
		public Param_elementContext param_element() {
			return getRuleContext(Param_elementContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
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
		enterRule(_localctx, 46, RULE_paramStat);
		try {
			setState(244);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(235);
				param_element();
				setState(236);
				match(T__20);
				setState(237);
				value();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(239);
				verticalDirectionParam();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(240);
				horizontalDirectionParam();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(241);
				verticalConnectionParam();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(242);
				horizontalConnectParam();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(243);
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
		public TerminalNode ID_SMALL() { return getToken(mintgrammarParser.ID_SMALL, 0); }
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
		enterRule(_localctx, 48, RULE_param_element);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			match(ID_SMALL);
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
		enterRule(_localctx, 50, RULE_widthParam);
		try {
			setState(257);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__21:
				enterOuterAlt(_localctx, 1);
				{
				setState(248);
				match(T__21);
				setState(249);
				match(T__20);
				setState(250);
				value();
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 2);
				{
				setState(251);
				match(T__22);
				setState(252);
				match(T__20);
				setState(253);
				value();
				}
				break;
			case T__23:
				enterOuterAlt(_localctx, 3);
				{
				setState(254);
				match(T__23);
				setState(255);
				match(T__20);
				setState(256);
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
		enterRule(_localctx, 52, RULE_verticalDirectionParam);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			match(T__24);
			setState(260);
			match(T__20);
			setState(261);
			((VerticalDirectionParamContext)_localctx).dir = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==T__25 || _la==T__26) ) {
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
		enterRule(_localctx, 54, RULE_horizontalDirectionParam);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			match(T__24);
			setState(264);
			match(T__20);
			setState(265);
			((HorizontalDirectionParamContext)_localctx).dir = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==T__27 || _la==T__28) ) {
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
		enterRule(_localctx, 56, RULE_horizontalConnectParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			match(T__29);
			setState(268);
			match(T__20);
			setState(269);
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
		enterRule(_localctx, 58, RULE_verticalConnectionParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			match(T__30);
			setState(272);
			match(T__20);
			setState(273);
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
		enterRule(_localctx, 60, RULE_ufmodulename);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
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
		enterRule(_localctx, 62, RULE_ufterminal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
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
		enterRule(_localctx, 64, RULE_uftargets);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			uftarget();
			setState(282); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(280);
				match(T__12);
				setState(281);
				uftarget();
				}
				}
				setState(284); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__12 );
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
		public TerminalNode ID_SMALL() { return getToken(mintgrammarParser.ID_SMALL, 0); }
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
		enterRule(_localctx, 66, RULE_uftarget);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			((UftargetContext)_localctx).target_name = match(ID_SMALL);
			setState(287);
			((UftargetContext)_localctx).target_terminal = match(INT);
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
		public TerminalNode ID_SMALL() { return getToken(mintgrammarParser.ID_SMALL, 0); }
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
		enterRule(_localctx, 68, RULE_ufname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
			match(ID_SMALL);
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
		enterRule(_localctx, 70, RULE_ufnames);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			ufname();
			setState(296);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__12) {
				{
				{
				setState(292);
				match(T__12);
				setState(293);
				ufname();
				}
				}
				setState(298);
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
		enterRule(_localctx, 72, RULE_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
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
		enterRule(_localctx, 74, RULE_boolvalue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			_la = _input.LA(1);
			if ( !(_la==T__31 || _la==T__32) ) {
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3(\u0132\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\3\2\5\2P\n\2\3\2\3\2\5\2T"+
		"\n\2\3\2\3\2\3\2\3\3\6\3Z\n\3\r\3\16\3[\3\4\3\4\3\4\3\5\5\5b\n\5\3\5\3"+
		"\5\3\5\3\6\6\6h\n\6\r\6\16\6i\3\7\3\7\3\7\3\7\3\b\6\bq\n\b\r\b\16\br\3"+
		"\t\3\t\5\tw\n\t\3\n\3\n\6\n{\n\n\r\n\16\n|\3\n\3\n\3\13\3\13\6\13\u0083"+
		"\n\13\r\13\16\13\u0084\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0091"+
		"\n\f\3\r\3\r\3\r\3\r\3\r\5\r\u0098\n\r\3\16\3\16\3\16\3\16\3\16\3\17\5"+
		"\17\u00a0\n\17\3\17\3\17\3\17\3\17\3\17\3\20\5\20\u00a8\n\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\22\5\22\u00bd\n\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\6\26"+
		"\u00e2\n\26\r\26\16\26\u00e3\3\27\3\27\3\30\7\30\u00e9\n\30\f\30\16\30"+
		"\u00ec\13\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u00f7\n"+
		"\31\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u0104"+
		"\n\33\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\37"+
		"\3\37\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3\"\6\"\u011d\n\"\r\"\16\"\u011e\3"+
		"#\3#\3#\3$\3$\3%\3%\3%\7%\u0129\n%\f%\16%\u012c\13%\3&\3&\3\'\3\'\3\'"+
		"\2\2(\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>"+
		"@BDFHJL\2\7\3\2\n\13\3\2\21\22\3\2\34\35\3\2\36\37\3\2\"#\u012d\2O\3\2"+
		"\2\2\4Y\3\2\2\2\6]\3\2\2\2\ba\3\2\2\2\ng\3\2\2\2\fk\3\2\2\2\16p\3\2\2"+
		"\2\20t\3\2\2\2\22x\3\2\2\2\24\u0080\3\2\2\2\26\u0090\3\2\2\2\30\u0097"+
		"\3\2\2\2\32\u0099\3\2\2\2\34\u009f\3\2\2\2\36\u00a7\3\2\2\2 \u00b1\3\2"+
		"\2\2\"\u00bc\3\2\2\2$\u00c6\3\2\2\2&\u00cd\3\2\2\2(\u00d6\3\2\2\2*\u00e1"+
		"\3\2\2\2,\u00e5\3\2\2\2.\u00ea\3\2\2\2\60\u00f6\3\2\2\2\62\u00f8\3\2\2"+
		"\2\64\u0103\3\2\2\2\66\u0105\3\2\2\28\u0109\3\2\2\2:\u010d\3\2\2\2<\u0111"+
		"\3\2\2\2>\u0115\3\2\2\2@\u0117\3\2\2\2B\u0119\3\2\2\2D\u0120\3\2\2\2F"+
		"\u0123\3\2\2\2H\u0125\3\2\2\2J\u012d\3\2\2\2L\u012f\3\2\2\2NP\5\4\3\2"+
		"ON\3\2\2\2OP\3\2\2\2PQ\3\2\2\2QS\5\b\5\2RT\5\n\6\2SR\3\2\2\2ST\3\2\2\2"+
		"TU\3\2\2\2UV\5\16\b\2VW\7\2\2\3W\3\3\2\2\2XZ\5\6\4\2YX\3\2\2\2Z[\3\2\2"+
		"\2[Y\3\2\2\2[\\\3\2\2\2\\\5\3\2\2\2]^\7\3\2\2^_\5> \2_\7\3\2\2\2`b\7\4"+
		"\2\2a`\3\2\2\2ab\3\2\2\2bc\3\2\2\2cd\7\5\2\2de\7%\2\2e\t\3\2\2\2fh\5\f"+
		"\7\2gf\3\2\2\2hi\3\2\2\2ig\3\2\2\2ij\3\2\2\2j\13\3\2\2\2kl\5> \2lm\5H"+
		"%\2mn\7\6\2\2n\r\3\2\2\2oq\5\20\t\2po\3\2\2\2qr\3\2\2\2rp\3\2\2\2rs\3"+
		"\2\2\2s\17\3\2\2\2tv\5\22\n\2uw\5\24\13\2vu\3\2\2\2vw\3\2\2\2w\21\3\2"+
		"\2\2xz\7\7\2\2y{\5\26\f\2zy\3\2\2\2{|\3\2\2\2|z\3\2\2\2|}\3\2\2\2}~\3"+
		"\2\2\2~\177\7\b\2\2\177\23\3\2\2\2\u0080\u0082\7\t\2\2\u0081\u0083\5\30"+
		"\r\2\u0082\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0082\3\2\2\2\u0084"+
		"\u0085\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087\7\b\2\2\u0087\25\3\2\2"+
		"\2\u0088\u0091\5\32\16\2\u0089\u0091\5\34\17\2\u008a\u0091\5&\24\2\u008b"+
		"\u0091\5(\25\2\u008c\u0091\5$\23\2\u008d\u0091\5\36\20\2\u008e\u0091\5"+
		" \21\2\u008f\u0091\5\"\22\2\u0090\u0088\3\2\2\2\u0090\u0089\3\2\2\2\u0090"+
		"\u008a\3\2\2\2\u0090\u008b\3\2\2\2\u0090\u008c\3\2\2\2\u0090\u008d\3\2"+
		"\2\2\u0090\u008e\3\2\2\2\u0090\u008f\3\2\2\2\u0091\27\3\2\2\2\u0092\u0098"+
		"\5$\23\2\u0093\u0098\5&\24\2\u0094\u0098\5(\25\2\u0095\u0098\5\36\20\2"+
		"\u0096\u0098\5\32\16\2\u0097\u0092\3\2\2\2\u0097\u0093\3\2\2\2\u0097\u0094"+
		"\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0096\3\2\2\2\u0098\31\3\2\2\2\u0099"+
		"\u009a\5*\26\2\u009a\u009b\5H%\2\u009b\u009c\5.\30\2\u009c\u009d\7\6\2"+
		"\2\u009d\33\3\2\2\2\u009e\u00a0\t\2\2\2\u009f\u009e\3\2\2\2\u009f\u00a0"+
		"\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2\5*\26\2\u00a2\u00a3\5H%\2\u00a3"+
		"\u00a4\5.\30\2\u00a4\u00a5\7\6\2\2\u00a5\35\3\2\2\2\u00a6\u00a8\t\2\2"+
		"\2\u00a7\u00a6\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00aa"+
		"\7\f\2\2\u00aa\u00ab\5F$\2\u00ab\u00ac\7\r\2\2\u00ac\u00ad\7&\2\2\u00ad"+
		"\u00ae\5*\26\2\u00ae\u00af\5.\30\2\u00af\u00b0\7\6\2\2\u00b0\37\3\2\2"+
		"\2\u00b1\u00b2\7\16\2\2\u00b2\u00b3\5F$\2\u00b3\u00b4\7\r\2\2\u00b4\u00b5"+
		"\7&\2\2\u00b5\u00b6\7\17\2\2\u00b6\u00b7\7&\2\2\u00b7\u00b8\5*\26\2\u00b8"+
		"\u00b9\5.\30\2\u00b9\u00ba\7\6\2\2\u00ba!\3\2\2\2\u00bb\u00bd\t\2\2\2"+
		"\u00bc\u00bb\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00bf"+
		"\5*\26\2\u00bf\u00c0\5F$\2\u00c0\u00c1\7&\2\2\u00c1\u00c2\7\20\2\2\u00c2"+
		"\u00c3\7&\2\2\u00c3\u00c4\5.\30\2\u00c4\u00c5\7\6\2\2\u00c5#\3\2\2\2\u00c6"+
		"\u00c7\t\3\2\2\u00c7\u00c8\5F$\2\u00c8\u00c9\7\23\2\2\u00c9\u00ca\5F$"+
		"\2\u00ca\u00cb\5.\30\2\u00cb\u00cc\7\6\2\2\u00cc%\3\2\2\2\u00cd\u00ce"+
		"\7\24\2\2\u00ce\u00cf\5F$\2\u00cf\u00d0\7\25\2\2\u00d0\u00d1\5D#\2\u00d1"+
		"\u00d2\7\20\2\2\u00d2\u00d3\5D#\2\u00d3\u00d4\5\64\33\2\u00d4\u00d5\7"+
		"\6\2\2\u00d5\'\3\2\2\2\u00d6\u00d7\7\26\2\2\u00d7\u00d8\5F$\2\u00d8\u00d9"+
		"\7\25\2\2\u00d9\u00da\7%\2\2\u00da\u00db\7&\2\2\u00db\u00dc\7\20\2\2\u00dc"+
		"\u00dd\5B\"\2\u00dd\u00de\5\64\33\2\u00de\u00df\7\6\2\2\u00df)\3\2\2\2"+
		"\u00e0\u00e2\5,\27\2\u00e1\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e1"+
		"\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4+\3\2\2\2\u00e5\u00e6\7$\2\2\u00e6-"+
		"\3\2\2\2\u00e7\u00e9\5\60\31\2\u00e8\u00e7\3\2\2\2\u00e9\u00ec\3\2\2\2"+
		"\u00ea\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb/\3\2\2\2\u00ec\u00ea\3"+
		"\2\2\2\u00ed\u00ee\5\62\32\2\u00ee\u00ef\7\27\2\2\u00ef\u00f0\5J&\2\u00f0"+
		"\u00f7\3\2\2\2\u00f1\u00f7\5\66\34\2\u00f2\u00f7\58\35\2\u00f3\u00f7\5"+
		"<\37\2\u00f4\u00f7\5:\36\2\u00f5\u00f7\5\64\33\2\u00f6\u00ed\3\2\2\2\u00f6"+
		"\u00f1\3\2\2\2\u00f6\u00f2\3\2\2\2\u00f6\u00f3\3\2\2\2\u00f6\u00f4\3\2"+
		"\2\2\u00f6\u00f5\3\2\2\2\u00f7\61\3\2\2\2\u00f8\u00f9\7%\2\2\u00f9\63"+
		"\3\2\2\2\u00fa\u00fb\7\30\2\2\u00fb\u00fc\7\27\2\2\u00fc\u0104\5J&\2\u00fd"+
		"\u00fe\7\31\2\2\u00fe\u00ff\7\27\2\2\u00ff\u0104\5J&\2\u0100\u0101\7\32"+
		"\2\2\u0101\u0102\7\27\2\2\u0102\u0104\5J&\2\u0103\u00fa\3\2\2\2\u0103"+
		"\u00fd\3\2\2\2\u0103\u0100\3\2\2\2\u0104\65\3\2\2\2\u0105\u0106\7\33\2"+
		"\2\u0106\u0107\7\27\2\2\u0107\u0108\t\4\2\2\u0108\67\3\2\2\2\u0109\u010a"+
		"\7\33\2\2\u010a\u010b\7\27\2\2\u010b\u010c\t\5\2\2\u010c9\3\2\2\2\u010d"+
		"\u010e\7 \2\2\u010e\u010f\7\27\2\2\u010f\u0110\5L\'\2\u0110;\3\2\2\2\u0111"+
		"\u0112\7!\2\2\u0112\u0113\7\27\2\2\u0113\u0114\5L\'\2\u0114=\3\2\2\2\u0115"+
		"\u0116\7$\2\2\u0116?\3\2\2\2\u0117\u0118\7&\2\2\u0118A\3\2\2\2\u0119\u011c"+
		"\5D#\2\u011a\u011b\7\17\2\2\u011b\u011d\5D#\2\u011c\u011a\3\2\2\2\u011d"+
		"\u011e\3\2\2\2\u011e\u011c\3\2\2\2\u011e\u011f\3\2\2\2\u011fC\3\2\2\2"+
		"\u0120\u0121\7%\2\2\u0121\u0122\7&\2\2\u0122E\3\2\2\2\u0123\u0124\7%\2"+
		"\2\u0124G\3\2\2\2\u0125\u012a\5F$\2\u0126\u0127\7\17\2\2\u0127\u0129\5"+
		"F$\2\u0128\u0126\3\2\2\2\u0129\u012c\3\2\2\2\u012a\u0128\3\2\2\2\u012a"+
		"\u012b\3\2\2\2\u012bI\3\2\2\2\u012c\u012a\3\2\2\2\u012d\u012e\7&\2\2\u012e"+
		"K\3\2\2\2\u012f\u0130\t\6\2\2\u0130M\3\2\2\2\26OS[airv|\u0084\u0090\u0097"+
		"\u009f\u00a7\u00bc\u00e3\u00ea\u00f6\u0103\u011e\u012a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}