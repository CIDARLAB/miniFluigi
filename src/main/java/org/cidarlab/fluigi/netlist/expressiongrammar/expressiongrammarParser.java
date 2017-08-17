// Generated from /Users/krishna/CIDAR/MiniFluigi/src/main/ANTLR/expressiongrammar.g4 by ANTLR 4.7
package org.cidarlab.fluigi.netlist.expressiongrammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class expressiongrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LPAREN=1, RPAREN=2, ADD=3, SUB=4, MUL=5, DIV=6, ID=7, FLOAT=8, INT=9, 
		WS=10, COMMENT=11;
	public static final int
		RULE_atom = 0, RULE_parameter_atom = 1, RULE_number_atom = 2, RULE_signed_atom = 3, 
		RULE_primary_expression = 4, RULE_bracket_expression = 5, RULE_multiplicative_expression = 6, 
		RULE_additive_expression = 7;
	public static final String[] ruleNames = {
		"atom", "parameter_atom", "number_atom", "signed_atom", "primary_expression", 
		"bracket_expression", "multiplicative_expression", "additive_expression"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'+'", "'-'", "'*'", "'/'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "LPAREN", "RPAREN", "ADD", "SUB", "MUL", "DIV", "ID", "FLOAT", "INT", 
		"WS", "COMMENT"
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
	public String getGrammarFileName() { return "expressiongrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public expressiongrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class AtomContext extends ParserRuleContext {
		public Number_atomContext number_atom() {
			return getRuleContext(Number_atomContext.class,0);
		}
		public Parameter_atomContext parameter_atom() {
			return getRuleContext(Parameter_atomContext.class,0);
		}
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof expressiongrammarListener ) ((expressiongrammarListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof expressiongrammarListener ) ((expressiongrammarListener)listener).exitAtom(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_atom);
		try {
			setState(18);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FLOAT:
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(16);
				number_atom();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(17);
				parameter_atom();
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

	public static class Parameter_atomContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(expressiongrammarParser.ID, 0); }
		public Parameter_atomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof expressiongrammarListener ) ((expressiongrammarListener)listener).enterParameter_atom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof expressiongrammarListener ) ((expressiongrammarListener)listener).exitParameter_atom(this);
		}
	}

	public final Parameter_atomContext parameter_atom() throws RecognitionException {
		Parameter_atomContext _localctx = new Parameter_atomContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_parameter_atom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
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

	public static class Number_atomContext extends ParserRuleContext {
		public TerminalNode FLOAT() { return getToken(expressiongrammarParser.FLOAT, 0); }
		public TerminalNode INT() { return getToken(expressiongrammarParser.INT, 0); }
		public Number_atomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof expressiongrammarListener ) ((expressiongrammarListener)listener).enterNumber_atom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof expressiongrammarListener ) ((expressiongrammarListener)listener).exitNumber_atom(this);
		}
	}

	public final Number_atomContext number_atom() throws RecognitionException {
		Number_atomContext _localctx = new Number_atomContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_number_atom);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			_la = _input.LA(1);
			if ( !(_la==FLOAT || _la==INT) ) {
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

	public static class Signed_atomContext extends ParserRuleContext {
		public Token isnegative;
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public Signed_atomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signed_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof expressiongrammarListener ) ((expressiongrammarListener)listener).enterSigned_atom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof expressiongrammarListener ) ((expressiongrammarListener)listener).exitSigned_atom(this);
		}
	}

	public final Signed_atomContext signed_atom() throws RecognitionException {
		Signed_atomContext _localctx = new Signed_atomContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_signed_atom);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(25);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SUB) {
				{
				setState(24);
				((Signed_atomContext)_localctx).isnegative = match(SUB);
				}
			}

			setState(27);
			atom();
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

	public static class Primary_expressionContext extends ParserRuleContext {
		public Bracket_expressionContext bracket_expression() {
			return getRuleContext(Bracket_expressionContext.class,0);
		}
		public Additive_expressionContext additive_expression() {
			return getRuleContext(Additive_expressionContext.class,0);
		}
		public Signed_atomContext signed_atom() {
			return getRuleContext(Signed_atomContext.class,0);
		}
		public Primary_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof expressiongrammarListener ) ((expressiongrammarListener)listener).enterPrimary_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof expressiongrammarListener ) ((expressiongrammarListener)listener).exitPrimary_expression(this);
		}
	}

	public final Primary_expressionContext primary_expression() throws RecognitionException {
		Primary_expressionContext _localctx = new Primary_expressionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_primary_expression);
		try {
			setState(32);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(29);
				bracket_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(30);
				additive_expression(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(31);
				signed_atom();
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

	public static class Bracket_expressionContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(expressiongrammarParser.LPAREN, 0); }
		public Additive_expressionContext additive_expression() {
			return getRuleContext(Additive_expressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(expressiongrammarParser.RPAREN, 0); }
		public Signed_atomContext signed_atom() {
			return getRuleContext(Signed_atomContext.class,0);
		}
		public Bracket_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bracket_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof expressiongrammarListener ) ((expressiongrammarListener)listener).enterBracket_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof expressiongrammarListener ) ((expressiongrammarListener)listener).exitBracket_expression(this);
		}
	}

	public final Bracket_expressionContext bracket_expression() throws RecognitionException {
		Bracket_expressionContext _localctx = new Bracket_expressionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_bracket_expression);
		try {
			setState(39);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(34);
				match(LPAREN);
				setState(35);
				additive_expression(0);
				setState(36);
				match(RPAREN);
				}
				break;
			case SUB:
			case ID:
			case FLOAT:
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(38);
				signed_atom();
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

	public static class Multiplicative_expressionContext extends ParserRuleContext {
		public Token operator;
		public Bracket_expressionContext bracket_expression() {
			return getRuleContext(Bracket_expressionContext.class,0);
		}
		public Multiplicative_expressionContext multiplicative_expression() {
			return getRuleContext(Multiplicative_expressionContext.class,0);
		}
		public TerminalNode MUL() { return getToken(expressiongrammarParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(expressiongrammarParser.DIV, 0); }
		public Multiplicative_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicative_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof expressiongrammarListener ) ((expressiongrammarListener)listener).enterMultiplicative_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof expressiongrammarListener ) ((expressiongrammarListener)listener).exitMultiplicative_expression(this);
		}
	}

	public final Multiplicative_expressionContext multiplicative_expression() throws RecognitionException {
		return multiplicative_expression(0);
	}

	private Multiplicative_expressionContext multiplicative_expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Multiplicative_expressionContext _localctx = new Multiplicative_expressionContext(_ctx, _parentState);
		Multiplicative_expressionContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_multiplicative_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(42);
			bracket_expression();
			}
			_ctx.stop = _input.LT(-1);
			setState(52);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(50);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						_localctx = new Multiplicative_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_multiplicative_expression);
						setState(44);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(45);
						((Multiplicative_expressionContext)_localctx).operator = match(MUL);
						setState(46);
						bracket_expression();
						}
						break;
					case 2:
						{
						_localctx = new Multiplicative_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_multiplicative_expression);
						setState(47);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(48);
						((Multiplicative_expressionContext)_localctx).operator = match(DIV);
						setState(49);
						bracket_expression();
						}
						break;
					}
					} 
				}
				setState(54);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Additive_expressionContext extends ParserRuleContext {
		public Token operator;
		public Multiplicative_expressionContext multiplicative_expression() {
			return getRuleContext(Multiplicative_expressionContext.class,0);
		}
		public Additive_expressionContext additive_expression() {
			return getRuleContext(Additive_expressionContext.class,0);
		}
		public TerminalNode ADD() { return getToken(expressiongrammarParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(expressiongrammarParser.SUB, 0); }
		public Additive_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additive_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof expressiongrammarListener ) ((expressiongrammarListener)listener).enterAdditive_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof expressiongrammarListener ) ((expressiongrammarListener)listener).exitAdditive_expression(this);
		}
	}

	public final Additive_expressionContext additive_expression() throws RecognitionException {
		return additive_expression(0);
	}

	private Additive_expressionContext additive_expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Additive_expressionContext _localctx = new Additive_expressionContext(_ctx, _parentState);
		Additive_expressionContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_additive_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(56);
			multiplicative_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(66);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(64);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new Additive_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_additive_expression);
						setState(58);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(59);
						((Additive_expressionContext)_localctx).operator = match(ADD);
						setState(60);
						multiplicative_expression(0);
						}
						break;
					case 2:
						{
						_localctx = new Additive_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_additive_expression);
						setState(61);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(62);
						((Additive_expressionContext)_localctx).operator = match(SUB);
						setState(63);
						multiplicative_expression(0);
						}
						break;
					}
					} 
				}
				setState(68);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 6:
			return multiplicative_expression_sempred((Multiplicative_expressionContext)_localctx, predIndex);
		case 7:
			return additive_expression_sempred((Additive_expressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean multiplicative_expression_sempred(Multiplicative_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean additive_expression_sempred(Additive_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\rH\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\5\2\25\n\2"+
		"\3\3\3\3\3\4\3\4\3\5\5\5\34\n\5\3\5\3\5\3\6\3\6\3\6\5\6#\n\6\3\7\3\7\3"+
		"\7\3\7\3\7\5\7*\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\65\n\b\f\b"+
		"\16\b8\13\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\tC\n\t\f\t\16\tF\13"+
		"\t\3\t\2\4\16\20\n\2\4\6\b\n\f\16\20\2\3\3\2\n\13\2H\2\24\3\2\2\2\4\26"+
		"\3\2\2\2\6\30\3\2\2\2\b\33\3\2\2\2\n\"\3\2\2\2\f)\3\2\2\2\16+\3\2\2\2"+
		"\209\3\2\2\2\22\25\5\6\4\2\23\25\5\4\3\2\24\22\3\2\2\2\24\23\3\2\2\2\25"+
		"\3\3\2\2\2\26\27\7\t\2\2\27\5\3\2\2\2\30\31\t\2\2\2\31\7\3\2\2\2\32\34"+
		"\7\6\2\2\33\32\3\2\2\2\33\34\3\2\2\2\34\35\3\2\2\2\35\36\5\2\2\2\36\t"+
		"\3\2\2\2\37#\5\f\7\2 #\5\20\t\2!#\5\b\5\2\"\37\3\2\2\2\" \3\2\2\2\"!\3"+
		"\2\2\2#\13\3\2\2\2$%\7\3\2\2%&\5\20\t\2&\'\7\4\2\2\'*\3\2\2\2(*\5\b\5"+
		"\2)$\3\2\2\2)(\3\2\2\2*\r\3\2\2\2+,\b\b\1\2,-\5\f\7\2-\66\3\2\2\2./\f"+
		"\4\2\2/\60\7\7\2\2\60\65\5\f\7\2\61\62\f\3\2\2\62\63\7\b\2\2\63\65\5\f"+
		"\7\2\64.\3\2\2\2\64\61\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2"+
		"\67\17\3\2\2\28\66\3\2\2\29:\b\t\1\2:;\5\16\b\2;D\3\2\2\2<=\f\4\2\2=>"+
		"\7\5\2\2>C\5\16\b\2?@\f\3\2\2@A\7\6\2\2AC\5\16\b\2B<\3\2\2\2B?\3\2\2\2"+
		"CF\3\2\2\2DB\3\2\2\2DE\3\2\2\2E\21\3\2\2\2FD\3\2\2\2\n\24\33\")\64\66"+
		"BD";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}