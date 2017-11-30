// Generated from /Users/krishna/CIDAR/MiniFluigi/src/main/ANTLR/expressiongrammar.g4 by ANTLR 4.7
package org.cidarlab.fluigi.netlist.expressiongrammar;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class expressiongrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, LPAREN=2, RPAREN=3, ADD=4, SUB=5, MUL=6, DIV=7, ID=8, FLOAT=9, 
		INT=10, WS=11, COMMENT=12;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "LPAREN", "RPAREN", "ADD", "SUB", "MUL", "DIV", "ID", "FLOAT", 
		"INT", "WS", "COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", "'('", "')'", "'+'", "'-'", "'*'", "'/'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "LPAREN", "RPAREN", "ADD", "SUB", "MUL", "DIV", "ID", "FLOAT", 
		"INT", "WS", "COMMENT"
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


	public expressiongrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "expressiongrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\16P\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3"+
		"\b\3\b\3\t\3\t\7\t,\n\t\f\t\16\t/\13\t\3\n\6\n\62\n\n\r\n\16\n\63\3\n"+
		"\3\n\6\n8\n\n\r\n\16\n9\3\13\6\13=\n\13\r\13\16\13>\3\f\6\fB\n\f\r\f\16"+
		"\fC\3\f\3\f\3\r\3\r\7\rJ\n\r\f\r\16\rM\13\r\3\r\3\r\2\2\16\3\3\5\4\7\5"+
		"\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\3\2\7\5\2C\\aac|\6\2\62"+
		";C\\aac|\3\2\62;\5\2\13\f\17\17\"\"\4\2\f\f\17\17\2U\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\3\33\3"+
		"\2\2\2\5\35\3\2\2\2\7\37\3\2\2\2\t!\3\2\2\2\13#\3\2\2\2\r%\3\2\2\2\17"+
		"\'\3\2\2\2\21)\3\2\2\2\23\61\3\2\2\2\25<\3\2\2\2\27A\3\2\2\2\31G\3\2\2"+
		"\2\33\34\7.\2\2\34\4\3\2\2\2\35\36\7*\2\2\36\6\3\2\2\2\37 \7+\2\2 \b\3"+
		"\2\2\2!\"\7-\2\2\"\n\3\2\2\2#$\7/\2\2$\f\3\2\2\2%&\7,\2\2&\16\3\2\2\2"+
		"\'(\7\61\2\2(\20\3\2\2\2)-\t\2\2\2*,\t\3\2\2+*\3\2\2\2,/\3\2\2\2-+\3\2"+
		"\2\2-.\3\2\2\2.\22\3\2\2\2/-\3\2\2\2\60\62\t\4\2\2\61\60\3\2\2\2\62\63"+
		"\3\2\2\2\63\61\3\2\2\2\63\64\3\2\2\2\64\65\3\2\2\2\65\67\7\60\2\2\668"+
		"\t\4\2\2\67\66\3\2\2\289\3\2\2\29\67\3\2\2\29:\3\2\2\2:\24\3\2\2\2;=\t"+
		"\4\2\2<;\3\2\2\2=>\3\2\2\2><\3\2\2\2>?\3\2\2\2?\26\3\2\2\2@B\t\5\2\2A"+
		"@\3\2\2\2BC\3\2\2\2CA\3\2\2\2CD\3\2\2\2DE\3\2\2\2EF\b\f\2\2F\30\3\2\2"+
		"\2GK\7%\2\2HJ\n\6\2\2IH\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2LN\3\2\2"+
		"\2MK\3\2\2\2NO\b\r\2\2O\32\3\2\2\2\t\2-\639>CK\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}