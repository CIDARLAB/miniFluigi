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
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		ID=39, ID_BIG=40, INT=41, WS=42, COMMENT=43;
	public static final int
		RULE_netlist = 0, RULE_importBlock = 1, RULE_importStat = 2, RULE_header = 3, 
		RULE_ufmoduleBlock = 4, RULE_ufmoduleStat = 5, RULE_layerBlocks = 6, RULE_layerBlock = 7, 
		RULE_flowBlock = 8, RULE_controlBlock = 9, RULE_integrationBlock = 10, 
		RULE_flowStat = 11, RULE_controlStat = 12, RULE_integrationStat = 13, 
		RULE_primitiveStat = 14, RULE_bankStat = 15, RULE_gridStat = 16, RULE_spanStat = 17, 
		RULE_primitiveWithOrientationConstraintStat = 18, RULE_valveStat = 19, 
		RULE_channelStat = 20, RULE_netStat = 21, RULE_entity = 22, RULE_entity_element = 23, 
		RULE_paramsStat = 24, RULE_paramStat = 25, RULE_param_element = 26, RULE_intParam = 27, 
		RULE_boolParam = 28, RULE_widthParam = 29, RULE_directionConstraintParam = 30, 
		RULE_bankParam = 31, RULE_bankParamKey = 32, RULE_gridParam = 33, RULE_gridParamValue = 34, 
		RULE_gridParamKey = 35, RULE_ufmodulename = 36, RULE_ufterminal = 37, 
		RULE_uftargets = 38, RULE_uftarget = 39, RULE_ufname = 40, RULE_ufnames = 41, 
		RULE_value = 42, RULE_boolvalue = 43, RULE_orientation = 44;
	public static final String[] ruleNames = {
		"netlist", "importBlock", "importStat", "header", "ufmoduleBlock", "ufmoduleStat", 
		"layerBlocks", "layerBlock", "flowBlock", "controlBlock", "integrationBlock", 
		"flowStat", "controlStat", "integrationStat", "primitiveStat", "bankStat", 
		"gridStat", "spanStat", "primitiveWithOrientationConstraintStat", "valveStat", 
		"channelStat", "netStat", "entity", "entity_element", "paramsStat", "paramStat", 
		"param_element", "intParam", "boolParam", "widthParam", "directionConstraintParam", 
		"bankParam", "bankParamKey", "gridParam", "gridParamValue", "gridParamKey", 
		"ufmodulename", "ufterminal", "uftargets", "uftarget", "ufname", "ufnames", 
		"value", "boolvalue", "orientation"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'IMPORT'", "'3D'", "'DEVICE'", "';'", "'LAYER FLOW'", "'END LAYER'", 
		"'LAYER CONTROL'", "'LAYER INTEGRATION'", "'BANK'", "'of'", "'GRID'", 
		"','", "'to'", "'on'", "'CHANNEL'", "'from'", "'NET'", "'='", "'width'", 
		"'w'", "'channelWidth'", "'dir'", "'RIGHT'", "'LEFT'", "'UP'", "'DOWN'", 
		"'direction'", "'spacing'", "'horizontalConnect'", "'verticalConnect'", 
		"'verticalValves'", "'horizontalValves'", "'verticalSpacing'", "'horizontalSpacing'", 
		"'YES'", "'NO'", "'V'", "'H'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, "ID", "ID_BIG", "INT", "WS", "COMMENT"
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
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(90);
				importBlock();
				}
			}

			setState(93);
			header();
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID_BIG) {
				{
				setState(94);
				ufmoduleBlock();
				}
			}

			setState(97);
			layerBlocks();
			setState(98);
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
			setState(101); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(100);
				importStat();
				}
				}
				setState(103); 
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
			setState(105);
			match(T__0);
			setState(106);
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
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(108);
				((HeaderContext)_localctx).tag = match(T__1);
				}
			}

			setState(111);
			match(T__2);
			setState(112);
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
			setState(115); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(114);
				ufmoduleStat();
				}
				}
				setState(117); 
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
			setState(119);
			ufmodulename();
			setState(120);
			ufnames();
			setState(121);
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
			setState(124); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(123);
				layerBlock();
				}
				}
				setState(126); 
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
		public IntegrationBlockContext integrationBlock() {
			return getRuleContext(IntegrationBlockContext.class,0);
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
			setState(128);
			flowBlock();
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(129);
				controlBlock();
				}
			}

			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(132);
				integrationBlock();
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
			setState(135);
			match(T__4);
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__10) | (1L << T__14) | (1L << T__16) | (1L << T__36) | (1L << T__37) | (1L << ID_BIG))) != 0)) {
				{
				{
				setState(136);
				flowStat();
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
			setState(144);
			match(T__6);
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__16) | (1L << T__36) | (1L << T__37) | (1L << ID_BIG))) != 0)) {
				{
				{
				setState(145);
				controlStat();
				}
				}
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(151);
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

	public static class IntegrationBlockContext extends ParserRuleContext {
		public List<IntegrationStatContext> integrationStat() {
			return getRuleContexts(IntegrationStatContext.class);
		}
		public IntegrationStatContext integrationStat(int i) {
			return getRuleContext(IntegrationStatContext.class,i);
		}
		public IntegrationBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integrationBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).enterIntegrationBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).exitIntegrationBlock(this);
		}
	}

	public final IntegrationBlockContext integrationBlock() throws RecognitionException {
		IntegrationBlockContext _localctx = new IntegrationBlockContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_integrationBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			match(T__7);
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID_BIG) {
				{
				{
				setState(154);
				integrationStat();
				}
				}
				setState(159);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(160);
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
		public PrimitiveWithOrientationConstraintStatContext primitiveWithOrientationConstraintStat() {
			return getRuleContext(PrimitiveWithOrientationConstraintStatContext.class,0);
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
		enterRule(_localctx, 22, RULE_flowStat);
		try {
			setState(170);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(162);
				primitiveStat();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(163);
				primitiveWithOrientationConstraintStat();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(164);
				channelStat();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(165);
				netStat();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(166);
				valveStat();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(167);
				bankStat();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(168);
				gridStat();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(169);
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
		public PrimitiveWithOrientationConstraintStatContext primitiveWithOrientationConstraintStat() {
			return getRuleContext(PrimitiveWithOrientationConstraintStatContext.class,0);
		}
		public ChannelStatContext channelStat() {
			return getRuleContext(ChannelStatContext.class,0);
		}
		public NetStatContext netStat() {
			return getRuleContext(NetStatContext.class,0);
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
		enterRule(_localctx, 24, RULE_controlStat);
		try {
			setState(177);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(172);
				valveStat();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(173);
				primitiveWithOrientationConstraintStat();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(174);
				channelStat();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(175);
				netStat();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(176);
				primitiveStat();
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

	public static class IntegrationStatContext extends ParserRuleContext {
		public PrimitiveStatContext primitiveStat() {
			return getRuleContext(PrimitiveStatContext.class,0);
		}
		public IntegrationStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integrationStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).enterIntegrationStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).exitIntegrationStat(this);
		}
	}

	public final IntegrationStatContext integrationStat() throws RecognitionException {
		IntegrationStatContext _localctx = new IntegrationStatContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_integrationStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			primitiveStat();
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
		enterRule(_localctx, 28, RULE_primitiveStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			entity();
			setState(182);
			ufnames();
			setState(183);
			paramsStat();
			setState(184);
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
		enterRule(_localctx, 30, RULE_bankStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			match(T__8);
			setState(187);
			ufname();
			setState(188);
			match(T__9);
			setState(189);
			((BankStatContext)_localctx).dim = match(INT);
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
		enterRule(_localctx, 32, RULE_gridStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			match(T__10);
			setState(195);
			ufname();
			setState(196);
			match(T__9);
			setState(197);
			((GridStatContext)_localctx).xdim = match(INT);
			setState(198);
			match(T__11);
			setState(199);
			((GridStatContext)_localctx).ydim = match(INT);
			setState(200);
			entity();
			setState(201);
			paramsStat();
			setState(202);
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
		public Token in;
		public Token out;
		public EntityContext entity() {
			return getRuleContext(EntityContext.class,0);
		}
		public UfnamesContext ufnames() {
			return getRuleContext(UfnamesContext.class,0);
		}
		public ParamsStatContext paramsStat() {
			return getRuleContext(ParamsStatContext.class,0);
		}
		public List<TerminalNode> INT() { return getTokens(mintgrammarParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(mintgrammarParser.INT, i);
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
		enterRule(_localctx, 34, RULE_spanStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			entity();
			setState(205);
			ufnames();
			setState(206);
			((SpanStatContext)_localctx).in = match(INT);
			setState(207);
			match(T__12);
			setState(208);
			((SpanStatContext)_localctx).out = match(INT);
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

	public static class PrimitiveWithOrientationConstraintStatContext extends ParserRuleContext {
		public OrientationContext orientation() {
			return getRuleContext(OrientationContext.class,0);
		}
		public BankStatContext bankStat() {
			return getRuleContext(BankStatContext.class,0);
		}
		public SpanStatContext spanStat() {
			return getRuleContext(SpanStatContext.class,0);
		}
		public PrimitiveStatContext primitiveStat() {
			return getRuleContext(PrimitiveStatContext.class,0);
		}
		public PrimitiveWithOrientationConstraintStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveWithOrientationConstraintStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).enterPrimitiveWithOrientationConstraintStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).exitPrimitiveWithOrientationConstraintStat(this);
		}
	}

	public final PrimitiveWithOrientationConstraintStatContext primitiveWithOrientationConstraintStat() throws RecognitionException {
		PrimitiveWithOrientationConstraintStatContext _localctx = new PrimitiveWithOrientationConstraintStatContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_primitiveWithOrientationConstraintStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			orientation();
			setState(216);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(213);
				bankStat();
				}
				break;
			case 2:
				{
				setState(214);
				spanStat();
				}
				break;
			case 3:
				{
				setState(215);
				primitiveStat();
				}
				break;
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

	public static class ValveStatContext extends ParserRuleContext {
		public EntityContext entity() {
			return getRuleContext(EntityContext.class,0);
		}
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
		enterRule(_localctx, 38, RULE_valveStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			entity();
			setState(219);
			ufname();
			setState(220);
			match(T__13);
			setState(221);
			ufname();
			setState(222);
			paramsStat();
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

	public static class ChannelStatContext extends ParserRuleContext {
		public UftargetContext source;
		public UftargetContext sink;
		public UfnameContext ufname() {
			return getRuleContext(UfnameContext.class,0);
		}
		public ParamsStatContext paramsStat() {
			return getRuleContext(ParamsStatContext.class,0);
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
		enterRule(_localctx, 40, RULE_channelStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			match(T__14);
			setState(226);
			ufname();
			setState(227);
			match(T__15);
			setState(228);
			((ChannelStatContext)_localctx).source = uftarget();
			setState(229);
			match(T__12);
			setState(230);
			((ChannelStatContext)_localctx).sink = uftarget();
			setState(231);
			paramsStat();
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

	public static class NetStatContext extends ParserRuleContext {
		public UftargetContext source;
		public UftargetsContext sinks;
		public UfnameContext ufname() {
			return getRuleContext(UfnameContext.class,0);
		}
		public ParamsStatContext paramsStat() {
			return getRuleContext(ParamsStatContext.class,0);
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
		enterRule(_localctx, 42, RULE_netStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			match(T__16);
			setState(235);
			ufname();
			setState(236);
			match(T__15);
			setState(237);
			((NetStatContext)_localctx).source = uftarget();
			setState(238);
			match(T__12);
			setState(239);
			((NetStatContext)_localctx).sinks = uftargets();
			setState(240);
			paramsStat();
			setState(241);
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
		enterRule(_localctx, 44, RULE_entity);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(243);
				entity_element();
				}
				}
				setState(246); 
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
		enterRule(_localctx, 46, RULE_entity_element);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
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
		enterRule(_localctx, 48, RULE_paramsStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << ID))) != 0)) {
				{
				{
				setState(250);
				paramStat();
				}
				}
				setState(255);
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
		public DirectionConstraintParamContext directionConstraintParam() {
			return getRuleContext(DirectionConstraintParamContext.class,0);
		}
		public GridParamContext gridParam() {
			return getRuleContext(GridParamContext.class,0);
		}
		public BankParamContext bankParam() {
			return getRuleContext(BankParamContext.class,0);
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
		enterRule(_localctx, 50, RULE_paramStat);
		try {
			setState(262);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(256);
				intParam();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(257);
				boolParam();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(258);
				directionConstraintParam();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(259);
				gridParam();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(260);
				bankParam();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(261);
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
		enterRule(_localctx, 52, RULE_param_element);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
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
		enterRule(_localctx, 54, RULE_intParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			param_element();
			setState(267);
			match(T__17);
			setState(268);
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
		enterRule(_localctx, 56, RULE_boolParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			param_element();
			setState(271);
			match(T__17);
			setState(272);
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
		enterRule(_localctx, 58, RULE_widthParam);
		try {
			setState(283);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__18:
				enterOuterAlt(_localctx, 1);
				{
				setState(274);
				match(T__18);
				setState(275);
				match(T__17);
				setState(276);
				value();
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 2);
				{
				setState(277);
				match(T__19);
				setState(278);
				match(T__17);
				setState(279);
				value();
				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 3);
				{
				setState(280);
				match(T__20);
				setState(281);
				match(T__17);
				setState(282);
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

	public static class DirectionConstraintParamContext extends ParserRuleContext {
		public Token dir;
		public DirectionConstraintParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_directionConstraintParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).enterDirectionConstraintParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).exitDirectionConstraintParam(this);
		}
	}

	public final DirectionConstraintParamContext directionConstraintParam() throws RecognitionException {
		DirectionConstraintParamContext _localctx = new DirectionConstraintParamContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_directionConstraintParam);
		int _la;
		try {
			setState(291);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__21:
				enterOuterAlt(_localctx, 1);
				{
				setState(285);
				match(T__21);
				setState(286);
				match(T__17);
				setState(287);
				((DirectionConstraintParamContext)_localctx).dir = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25))) != 0)) ) {
					((DirectionConstraintParamContext)_localctx).dir = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case T__26:
				enterOuterAlt(_localctx, 2);
				{
				setState(288);
				match(T__26);
				setState(289);
				match(T__17);
				setState(290);
				((DirectionConstraintParamContext)_localctx).dir = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25))) != 0)) ) {
					((DirectionConstraintParamContext)_localctx).dir = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
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

	public static class BankParamContext extends ParserRuleContext {
		public BankParamKeyContext bankParamKey() {
			return getRuleContext(BankParamKeyContext.class,0);
		}
		public BoolvalueContext boolvalue() {
			return getRuleContext(BoolvalueContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public BankParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bankParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).enterBankParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).exitBankParam(this);
		}
	}

	public final BankParamContext bankParam() throws RecognitionException {
		BankParamContext _localctx = new BankParamContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_bankParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			bankParamKey();
			setState(294);
			match(T__17);
			setState(297);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__34:
			case T__35:
				{
				setState(295);
				boolvalue();
				}
				break;
			case INT:
				{
				setState(296);
				value();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class BankParamKeyContext extends ParserRuleContext {
		public BankParamKeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bankParamKey; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).enterBankParamKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).exitBankParamKey(this);
		}
	}

	public final BankParamKeyContext bankParamKey() throws RecognitionException {
		BankParamKeyContext _localctx = new BankParamKeyContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_bankParamKey);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
			match(T__27);
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

	public static class GridParamContext extends ParserRuleContext {
		public GridParamKeyContext gridParamKey() {
			return getRuleContext(GridParamKeyContext.class,0);
		}
		public GridParamValueContext gridParamValue() {
			return getRuleContext(GridParamValueContext.class,0);
		}
		public GridParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gridParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).enterGridParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).exitGridParam(this);
		}
	}

	public final GridParamContext gridParam() throws RecognitionException {
		GridParamContext _localctx = new GridParamContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_gridParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			gridParamKey();
			setState(302);
			match(T__17);
			setState(303);
			gridParamValue();
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

	public static class GridParamValueContext extends ParserRuleContext {
		public BoolvalueContext boolvalue() {
			return getRuleContext(BoolvalueContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public GridParamValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gridParamValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).enterGridParamValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).exitGridParamValue(this);
		}
	}

	public final GridParamValueContext gridParamValue() throws RecognitionException {
		GridParamValueContext _localctx = new GridParamValueContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_gridParamValue);
		try {
			setState(307);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__34:
			case T__35:
				enterOuterAlt(_localctx, 1);
				{
				setState(305);
				boolvalue();
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(306);
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

	public static class GridParamKeyContext extends ParserRuleContext {
		public GridParamKeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gridParamKey; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).enterGridParamKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mintgrammarListener ) ((mintgrammarListener)listener).exitGridParamKey(this);
		}
	}

	public final GridParamKeyContext gridParamKey() throws RecognitionException {
		GridParamKeyContext _localctx = new GridParamKeyContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_gridParamKey);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(309);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33))) != 0)) ) {
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
		enterRule(_localctx, 72, RULE_ufmodulename);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(311);
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
		enterRule(_localctx, 74, RULE_ufterminal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(313);
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
		enterRule(_localctx, 76, RULE_uftargets);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(315);
			uftarget();
			setState(318); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(316);
				match(T__11);
				setState(317);
				uftarget();
				}
				}
				setState(320); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__11 );
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
		enterRule(_localctx, 78, RULE_uftarget);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(322);
			((UftargetContext)_localctx).target_name = match(ID);
			setState(324);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INT) {
				{
				setState(323);
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
		enterRule(_localctx, 80, RULE_ufname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
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
		enterRule(_localctx, 82, RULE_ufnames);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			ufname();
			setState(333);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(329);
				match(T__11);
				setState(330);
				ufname();
				}
				}
				setState(335);
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
		enterRule(_localctx, 84, RULE_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(336);
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
		enterRule(_localctx, 86, RULE_boolvalue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(338);
			_la = _input.LA(1);
			if ( !(_la==T__34 || _la==T__35) ) {
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
		enterRule(_localctx, 88, RULE_orientation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
			_la = _input.LA(1);
			if ( !(_la==T__36 || _la==T__37) ) {
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3-\u0159\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\3\2\5\2^\n\2\3\2\3\2\5\2b\n\2\3\2\3\2\3\2\3\3\6\3h\n"+
		"\3\r\3\16\3i\3\4\3\4\3\4\3\5\5\5p\n\5\3\5\3\5\3\5\3\6\6\6v\n\6\r\6\16"+
		"\6w\3\7\3\7\3\7\3\7\3\b\6\b\177\n\b\r\b\16\b\u0080\3\t\3\t\5\t\u0085\n"+
		"\t\3\t\5\t\u0088\n\t\3\n\3\n\7\n\u008c\n\n\f\n\16\n\u008f\13\n\3\n\3\n"+
		"\3\13\3\13\7\13\u0095\n\13\f\13\16\13\u0098\13\13\3\13\3\13\3\f\3\f\7"+
		"\f\u009e\n\f\f\f\16\f\u00a1\13\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\5\r\u00ad\n\r\3\16\3\16\3\16\3\16\3\16\5\16\u00b4\n\16\3\17\3\17\3"+
		"\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\24\3\24\3\24\3\24\5\24\u00db\n\24\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\6\30\u00f7\n\30\r\30\16\30\u00f8"+
		"\3\31\3\31\3\32\7\32\u00fe\n\32\f\32\16\32\u0101\13\32\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\5\33\u0109\n\33\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36"+
		"\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u011e\n\37"+
		"\3 \3 \3 \3 \3 \3 \5 \u0126\n \3!\3!\3!\3!\5!\u012c\n!\3\"\3\"\3#\3#\3"+
		"#\3#\3$\3$\5$\u0136\n$\3%\3%\3&\3&\3\'\3\'\3(\3(\3(\6(\u0141\n(\r(\16"+
		"(\u0142\3)\3)\5)\u0147\n)\3*\3*\3+\3+\3+\7+\u014e\n+\f+\16+\u0151\13+"+
		"\3,\3,\3-\3-\3.\3.\3.\2\2/\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$"+
		"&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\2\6\3\2\31\34\3\2\37$\3\2%&\3\2\'"+
		"(\2\u0152\2]\3\2\2\2\4g\3\2\2\2\6k\3\2\2\2\bo\3\2\2\2\nu\3\2\2\2\fy\3"+
		"\2\2\2\16~\3\2\2\2\20\u0082\3\2\2\2\22\u0089\3\2\2\2\24\u0092\3\2\2\2"+
		"\26\u009b\3\2\2\2\30\u00ac\3\2\2\2\32\u00b3\3\2\2\2\34\u00b5\3\2\2\2\36"+
		"\u00b7\3\2\2\2 \u00bc\3\2\2\2\"\u00c4\3\2\2\2$\u00ce\3\2\2\2&\u00d6\3"+
		"\2\2\2(\u00dc\3\2\2\2*\u00e3\3\2\2\2,\u00ec\3\2\2\2.\u00f6\3\2\2\2\60"+
		"\u00fa\3\2\2\2\62\u00ff\3\2\2\2\64\u0108\3\2\2\2\66\u010a\3\2\2\28\u010c"+
		"\3\2\2\2:\u0110\3\2\2\2<\u011d\3\2\2\2>\u0125\3\2\2\2@\u0127\3\2\2\2B"+
		"\u012d\3\2\2\2D\u012f\3\2\2\2F\u0135\3\2\2\2H\u0137\3\2\2\2J\u0139\3\2"+
		"\2\2L\u013b\3\2\2\2N\u013d\3\2\2\2P\u0144\3\2\2\2R\u0148\3\2\2\2T\u014a"+
		"\3\2\2\2V\u0152\3\2\2\2X\u0154\3\2\2\2Z\u0156\3\2\2\2\\^\5\4\3\2]\\\3"+
		"\2\2\2]^\3\2\2\2^_\3\2\2\2_a\5\b\5\2`b\5\n\6\2a`\3\2\2\2ab\3\2\2\2bc\3"+
		"\2\2\2cd\5\16\b\2de\7\2\2\3e\3\3\2\2\2fh\5\6\4\2gf\3\2\2\2hi\3\2\2\2i"+
		"g\3\2\2\2ij\3\2\2\2j\5\3\2\2\2kl\7\3\2\2lm\5J&\2m\7\3\2\2\2np\7\4\2\2"+
		"on\3\2\2\2op\3\2\2\2pq\3\2\2\2qr\7\5\2\2rs\7)\2\2s\t\3\2\2\2tv\5\f\7\2"+
		"ut\3\2\2\2vw\3\2\2\2wu\3\2\2\2wx\3\2\2\2x\13\3\2\2\2yz\5J&\2z{\5T+\2{"+
		"|\7\6\2\2|\r\3\2\2\2}\177\5\20\t\2~}\3\2\2\2\177\u0080\3\2\2\2\u0080~"+
		"\3\2\2\2\u0080\u0081\3\2\2\2\u0081\17\3\2\2\2\u0082\u0084\5\22\n\2\u0083"+
		"\u0085\5\24\13\2\u0084\u0083\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0087\3"+
		"\2\2\2\u0086\u0088\5\26\f\2\u0087\u0086\3\2\2\2\u0087\u0088\3\2\2\2\u0088"+
		"\21\3\2\2\2\u0089\u008d\7\7\2\2\u008a\u008c\5\30\r\2\u008b\u008a\3\2\2"+
		"\2\u008c\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u0090"+
		"\3\2\2\2\u008f\u008d\3\2\2\2\u0090\u0091\7\b\2\2\u0091\23\3\2\2\2\u0092"+
		"\u0096\7\t\2\2\u0093\u0095\5\32\16\2\u0094\u0093\3\2\2\2\u0095\u0098\3"+
		"\2\2\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0099\3\2\2\2\u0098"+
		"\u0096\3\2\2\2\u0099\u009a\7\b\2\2\u009a\25\3\2\2\2\u009b\u009f\7\n\2"+
		"\2\u009c\u009e\5\34\17\2\u009d\u009c\3\2\2\2\u009e\u00a1\3\2\2\2\u009f"+
		"\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a2\3\2\2\2\u00a1\u009f\3\2"+
		"\2\2\u00a2\u00a3\7\b\2\2\u00a3\27\3\2\2\2\u00a4\u00ad\5\36\20\2\u00a5"+
		"\u00ad\5&\24\2\u00a6\u00ad\5*\26\2\u00a7\u00ad\5,\27\2\u00a8\u00ad\5("+
		"\25\2\u00a9\u00ad\5 \21\2\u00aa\u00ad\5\"\22\2\u00ab\u00ad\5$\23\2\u00ac"+
		"\u00a4\3\2\2\2\u00ac\u00a5\3\2\2\2\u00ac\u00a6\3\2\2\2\u00ac\u00a7\3\2"+
		"\2\2\u00ac\u00a8\3\2\2\2\u00ac\u00a9\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac"+
		"\u00ab\3\2\2\2\u00ad\31\3\2\2\2\u00ae\u00b4\5(\25\2\u00af\u00b4\5&\24"+
		"\2\u00b0\u00b4\5*\26\2\u00b1\u00b4\5,\27\2\u00b2\u00b4\5\36\20\2\u00b3"+
		"\u00ae\3\2\2\2\u00b3\u00af\3\2\2\2\u00b3\u00b0\3\2\2\2\u00b3\u00b1\3\2"+
		"\2\2\u00b3\u00b2\3\2\2\2\u00b4\33\3\2\2\2\u00b5\u00b6\5\36\20\2\u00b6"+
		"\35\3\2\2\2\u00b7\u00b8\5.\30\2\u00b8\u00b9\5T+\2\u00b9\u00ba\5\62\32"+
		"\2\u00ba\u00bb\7\6\2\2\u00bb\37\3\2\2\2\u00bc\u00bd\7\13\2\2\u00bd\u00be"+
		"\5R*\2\u00be\u00bf\7\f\2\2\u00bf\u00c0\7+\2\2\u00c0\u00c1\5.\30\2\u00c1"+
		"\u00c2\5\62\32\2\u00c2\u00c3\7\6\2\2\u00c3!\3\2\2\2\u00c4\u00c5\7\r\2"+
		"\2\u00c5\u00c6\5R*\2\u00c6\u00c7\7\f\2\2\u00c7\u00c8\7+\2\2\u00c8\u00c9"+
		"\7\16\2\2\u00c9\u00ca\7+\2\2\u00ca\u00cb\5.\30\2\u00cb\u00cc\5\62\32\2"+
		"\u00cc\u00cd\7\6\2\2\u00cd#\3\2\2\2\u00ce\u00cf\5.\30\2\u00cf\u00d0\5"+
		"T+\2\u00d0\u00d1\7+\2\2\u00d1\u00d2\7\17\2\2\u00d2\u00d3\7+\2\2\u00d3"+
		"\u00d4\5\62\32\2\u00d4\u00d5\7\6\2\2\u00d5%\3\2\2\2\u00d6\u00da\5Z.\2"+
		"\u00d7\u00db\5 \21\2\u00d8\u00db\5$\23\2\u00d9\u00db\5\36\20\2\u00da\u00d7"+
		"\3\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00d9\3\2\2\2\u00db\'\3\2\2\2\u00dc"+
		"\u00dd\5.\30\2\u00dd\u00de\5R*\2\u00de\u00df\7\20\2\2\u00df\u00e0\5R*"+
		"\2\u00e0\u00e1\5\62\32\2\u00e1\u00e2\7\6\2\2\u00e2)\3\2\2\2\u00e3\u00e4"+
		"\7\21\2\2\u00e4\u00e5\5R*\2\u00e5\u00e6\7\22\2\2\u00e6\u00e7\5P)\2\u00e7"+
		"\u00e8\7\17\2\2\u00e8\u00e9\5P)\2\u00e9\u00ea\5\62\32\2\u00ea\u00eb\7"+
		"\6\2\2\u00eb+\3\2\2\2\u00ec\u00ed\7\23\2\2\u00ed\u00ee\5R*\2\u00ee\u00ef"+
		"\7\22\2\2\u00ef\u00f0\5P)\2\u00f0\u00f1\7\17\2\2\u00f1\u00f2\5N(\2\u00f2"+
		"\u00f3\5\62\32\2\u00f3\u00f4\7\6\2\2\u00f4-\3\2\2\2\u00f5\u00f7\5\60\31"+
		"\2\u00f6\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f8\u00f9"+
		"\3\2\2\2\u00f9/\3\2\2\2\u00fa\u00fb\7*\2\2\u00fb\61\3\2\2\2\u00fc\u00fe"+
		"\5\64\33\2\u00fd\u00fc\3\2\2\2\u00fe\u0101\3\2\2\2\u00ff\u00fd\3\2\2\2"+
		"\u00ff\u0100\3\2\2\2\u0100\63\3\2\2\2\u0101\u00ff\3\2\2\2\u0102\u0109"+
		"\58\35\2\u0103\u0109\5:\36\2\u0104\u0109\5> \2\u0105\u0109\5D#\2\u0106"+
		"\u0109\5@!\2\u0107\u0109\5<\37\2\u0108\u0102\3\2\2\2\u0108\u0103\3\2\2"+
		"\2\u0108\u0104\3\2\2\2\u0108\u0105\3\2\2\2\u0108\u0106\3\2\2\2\u0108\u0107"+
		"\3\2\2\2\u0109\65\3\2\2\2\u010a\u010b\7)\2\2\u010b\67\3\2\2\2\u010c\u010d"+
		"\5\66\34\2\u010d\u010e\7\24\2\2\u010e\u010f\5V,\2\u010f9\3\2\2\2\u0110"+
		"\u0111\5\66\34\2\u0111\u0112\7\24\2\2\u0112\u0113\5X-\2\u0113;\3\2\2\2"+
		"\u0114\u0115\7\25\2\2\u0115\u0116\7\24\2\2\u0116\u011e\5V,\2\u0117\u0118"+
		"\7\26\2\2\u0118\u0119\7\24\2\2\u0119\u011e\5V,\2\u011a\u011b\7\27\2\2"+
		"\u011b\u011c\7\24\2\2\u011c\u011e\5V,\2\u011d\u0114\3\2\2\2\u011d\u0117"+
		"\3\2\2\2\u011d\u011a\3\2\2\2\u011e=\3\2\2\2\u011f\u0120\7\30\2\2\u0120"+
		"\u0121\7\24\2\2\u0121\u0126\t\2\2\2\u0122\u0123\7\35\2\2\u0123\u0124\7"+
		"\24\2\2\u0124\u0126\t\2\2\2\u0125\u011f\3\2\2\2\u0125\u0122\3\2\2\2\u0126"+
		"?\3\2\2\2\u0127\u0128\5B\"\2\u0128\u012b\7\24\2\2\u0129\u012c\5X-\2\u012a"+
		"\u012c\5V,\2\u012b\u0129\3\2\2\2\u012b\u012a\3\2\2\2\u012cA\3\2\2\2\u012d"+
		"\u012e\7\36\2\2\u012eC\3\2\2\2\u012f\u0130\5H%\2\u0130\u0131\7\24\2\2"+
		"\u0131\u0132\5F$\2\u0132E\3\2\2\2\u0133\u0136\5X-\2\u0134\u0136\5V,\2"+
		"\u0135\u0133\3\2\2\2\u0135\u0134\3\2\2\2\u0136G\3\2\2\2\u0137\u0138\t"+
		"\3\2\2\u0138I\3\2\2\2\u0139\u013a\7*\2\2\u013aK\3\2\2\2\u013b\u013c\7"+
		"+\2\2\u013cM\3\2\2\2\u013d\u0140\5P)\2\u013e\u013f\7\16\2\2\u013f\u0141"+
		"\5P)\2\u0140\u013e\3\2\2\2\u0141\u0142\3\2\2\2\u0142\u0140\3\2\2\2\u0142"+
		"\u0143\3\2\2\2\u0143O\3\2\2\2\u0144\u0146\7)\2\2\u0145\u0147\7+\2\2\u0146"+
		"\u0145\3\2\2\2\u0146\u0147\3\2\2\2\u0147Q\3\2\2\2\u0148\u0149\7)\2\2\u0149"+
		"S\3\2\2\2\u014a\u014f\5R*\2\u014b\u014c\7\16\2\2\u014c\u014e\5R*\2\u014d"+
		"\u014b\3\2\2\2\u014e\u0151\3\2\2\2\u014f\u014d\3\2\2\2\u014f\u0150\3\2"+
		"\2\2\u0150U\3\2\2\2\u0151\u014f\3\2\2\2\u0152\u0153\7+\2\2\u0153W\3\2"+
		"\2\2\u0154\u0155\t\4\2\2\u0155Y\3\2\2\2\u0156\u0157\t\5\2\2\u0157[\3\2"+
		"\2\2\32]aiow\u0080\u0084\u0087\u008d\u0096\u009f\u00ac\u00b3\u00da\u00f8"+
		"\u00ff\u0108\u011d\u0125\u012b\u0135\u0142\u0146\u014f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}