// Generated from /Users/krishna/CIDAR/MiniFluigi/src/main/ANTLR/mintgrammar.g4 by ANTLR 4.7
package org.cidarlab.minifluigi.mintgrammar;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class mintgrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, ID=34, ID_BIG=35, INT=36, WS=37, COMMENT=38;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
		"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
		"ID", "ID_BIG", "INT", "WS", "COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'IMPORT'", "'3D'", "'DEVICE'", "';'", "'LAYER FLOW'", "'END LAYER'", 
		"'LAYER CONTROL'", "'BANK'", "'of'", "'GRID'", "','", "'to'", "'VALVE'", 
		"'3DVALVE'", "'on'", "'CHANNEL'", "'from'", "'NET'", "'='", "'width'", 
		"'w'", "'channelWidth'", "'dir'", "'RIGHT'", "'LEFT'", "'UP'", "'DOWN'", 
		"'horizontalConnect'", "'verticalConnect'", "'YES'", "'NO'", "'V'", "'H'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, "ID", "ID_BIG", 
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


	public mintgrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "mintgrammar.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2(\u0137\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t"+
		"\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3"+
		"\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3"+
		"\23\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3"+
		"\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3"+
		"\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3"+
		"\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3"+
		"\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3"+
		"\37\3\37\3\37\3\37\3 \3 \3 \3!\3!\3\"\3\"\3#\3#\7#\u0117\n#\f#\16#\u011a"+
		"\13#\3$\3$\7$\u011e\n$\f$\16$\u0121\13$\3%\6%\u0124\n%\r%\16%\u0125\3"+
		"&\6&\u0129\n&\r&\16&\u012a\3&\3&\3\'\3\'\7\'\u0131\n\'\f\'\16\'\u0134"+
		"\13\'\3\'\3\'\2\2(\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r"+
		"\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33"+
		"\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(\3\2\t\4\2aac|\6\2\62;C\\aac|"+
		"\4\2C\\aa\5\2\62;C\\aa\3\2\62;\5\2\13\f\17\17\"\"\4\2\f\f\17\17\2\u013b"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\3O\3\2\2\2\5V\3\2\2\2\7Y\3\2\2\2\t"+
		"`\3\2\2\2\13b\3\2\2\2\rm\3\2\2\2\17w\3\2\2\2\21\u0085\3\2\2\2\23\u008a"+
		"\3\2\2\2\25\u008d\3\2\2\2\27\u0092\3\2\2\2\31\u0094\3\2\2\2\33\u0097\3"+
		"\2\2\2\35\u009d\3\2\2\2\37\u00a5\3\2\2\2!\u00a8\3\2\2\2#\u00b0\3\2\2\2"+
		"%\u00b5\3\2\2\2\'\u00b9\3\2\2\2)\u00bb\3\2\2\2+\u00c1\3\2\2\2-\u00c3\3"+
		"\2\2\2/\u00d0\3\2\2\2\61\u00d4\3\2\2\2\63\u00da\3\2\2\2\65\u00df\3\2\2"+
		"\2\67\u00e2\3\2\2\29\u00e7\3\2\2\2;\u00f9\3\2\2\2=\u0109\3\2\2\2?\u010d"+
		"\3\2\2\2A\u0110\3\2\2\2C\u0112\3\2\2\2E\u0114\3\2\2\2G\u011b\3\2\2\2I"+
		"\u0123\3\2\2\2K\u0128\3\2\2\2M\u012e\3\2\2\2OP\7K\2\2PQ\7O\2\2QR\7R\2"+
		"\2RS\7Q\2\2ST\7T\2\2TU\7V\2\2U\4\3\2\2\2VW\7\65\2\2WX\7F\2\2X\6\3\2\2"+
		"\2YZ\7F\2\2Z[\7G\2\2[\\\7X\2\2\\]\7K\2\2]^\7E\2\2^_\7G\2\2_\b\3\2\2\2"+
		"`a\7=\2\2a\n\3\2\2\2bc\7N\2\2cd\7C\2\2de\7[\2\2ef\7G\2\2fg\7T\2\2gh\7"+
		"\"\2\2hi\7H\2\2ij\7N\2\2jk\7Q\2\2kl\7Y\2\2l\f\3\2\2\2mn\7G\2\2no\7P\2"+
		"\2op\7F\2\2pq\7\"\2\2qr\7N\2\2rs\7C\2\2st\7[\2\2tu\7G\2\2uv\7T\2\2v\16"+
		"\3\2\2\2wx\7N\2\2xy\7C\2\2yz\7[\2\2z{\7G\2\2{|\7T\2\2|}\7\"\2\2}~\7E\2"+
		"\2~\177\7Q\2\2\177\u0080\7P\2\2\u0080\u0081\7V\2\2\u0081\u0082\7T\2\2"+
		"\u0082\u0083\7Q\2\2\u0083\u0084\7N\2\2\u0084\20\3\2\2\2\u0085\u0086\7"+
		"D\2\2\u0086\u0087\7C\2\2\u0087\u0088\7P\2\2\u0088\u0089\7M\2\2\u0089\22"+
		"\3\2\2\2\u008a\u008b\7q\2\2\u008b\u008c\7h\2\2\u008c\24\3\2\2\2\u008d"+
		"\u008e\7I\2\2\u008e\u008f\7T\2\2\u008f\u0090\7K\2\2\u0090\u0091\7F\2\2"+
		"\u0091\26\3\2\2\2\u0092\u0093\7.\2\2\u0093\30\3\2\2\2\u0094\u0095\7v\2"+
		"\2\u0095\u0096\7q\2\2\u0096\32\3\2\2\2\u0097\u0098\7X\2\2\u0098\u0099"+
		"\7C\2\2\u0099\u009a\7N\2\2\u009a\u009b\7X\2\2\u009b\u009c\7G\2\2\u009c"+
		"\34\3\2\2\2\u009d\u009e\7\65\2\2\u009e\u009f\7F\2\2\u009f\u00a0\7X\2\2"+
		"\u00a0\u00a1\7C\2\2\u00a1\u00a2\7N\2\2\u00a2\u00a3\7X\2\2\u00a3\u00a4"+
		"\7G\2\2\u00a4\36\3\2\2\2\u00a5\u00a6\7q\2\2\u00a6\u00a7\7p\2\2\u00a7 "+
		"\3\2\2\2\u00a8\u00a9\7E\2\2\u00a9\u00aa\7J\2\2\u00aa\u00ab\7C\2\2\u00ab"+
		"\u00ac\7P\2\2\u00ac\u00ad\7P\2\2\u00ad\u00ae\7G\2\2\u00ae\u00af\7N\2\2"+
		"\u00af\"\3\2\2\2\u00b0\u00b1\7h\2\2\u00b1\u00b2\7t\2\2\u00b2\u00b3\7q"+
		"\2\2\u00b3\u00b4\7o\2\2\u00b4$\3\2\2\2\u00b5\u00b6\7P\2\2\u00b6\u00b7"+
		"\7G\2\2\u00b7\u00b8\7V\2\2\u00b8&\3\2\2\2\u00b9\u00ba\7?\2\2\u00ba(\3"+
		"\2\2\2\u00bb\u00bc\7y\2\2\u00bc\u00bd\7k\2\2\u00bd\u00be\7f\2\2\u00be"+
		"\u00bf\7v\2\2\u00bf\u00c0\7j\2\2\u00c0*\3\2\2\2\u00c1\u00c2\7y\2\2\u00c2"+
		",\3\2\2\2\u00c3\u00c4\7e\2\2\u00c4\u00c5\7j\2\2\u00c5\u00c6\7c\2\2\u00c6"+
		"\u00c7\7p\2\2\u00c7\u00c8\7p\2\2\u00c8\u00c9\7g\2\2\u00c9\u00ca\7n\2\2"+
		"\u00ca\u00cb\7Y\2\2\u00cb\u00cc\7k\2\2\u00cc\u00cd\7f\2\2\u00cd\u00ce"+
		"\7v\2\2\u00ce\u00cf\7j\2\2\u00cf.\3\2\2\2\u00d0\u00d1\7f\2\2\u00d1\u00d2"+
		"\7k\2\2\u00d2\u00d3\7t\2\2\u00d3\60\3\2\2\2\u00d4\u00d5\7T\2\2\u00d5\u00d6"+
		"\7K\2\2\u00d6\u00d7\7I\2\2\u00d7\u00d8\7J\2\2\u00d8\u00d9\7V\2\2\u00d9"+
		"\62\3\2\2\2\u00da\u00db\7N\2\2\u00db\u00dc\7G\2\2\u00dc\u00dd\7H\2\2\u00dd"+
		"\u00de\7V\2\2\u00de\64\3\2\2\2\u00df\u00e0\7W\2\2\u00e0\u00e1\7R\2\2\u00e1"+
		"\66\3\2\2\2\u00e2\u00e3\7F\2\2\u00e3\u00e4\7Q\2\2\u00e4\u00e5\7Y\2\2\u00e5"+
		"\u00e6\7P\2\2\u00e68\3\2\2\2\u00e7\u00e8\7j\2\2\u00e8\u00e9\7q\2\2\u00e9"+
		"\u00ea\7t\2\2\u00ea\u00eb\7k\2\2\u00eb\u00ec\7|\2\2\u00ec\u00ed\7q\2\2"+
		"\u00ed\u00ee\7p\2\2\u00ee\u00ef\7v\2\2\u00ef\u00f0\7c\2\2\u00f0\u00f1"+
		"\7n\2\2\u00f1\u00f2\7E\2\2\u00f2\u00f3\7q\2\2\u00f3\u00f4\7p\2\2\u00f4"+
		"\u00f5\7p\2\2\u00f5\u00f6\7g\2\2\u00f6\u00f7\7e\2\2\u00f7\u00f8\7v\2\2"+
		"\u00f8:\3\2\2\2\u00f9\u00fa\7x\2\2\u00fa\u00fb\7g\2\2\u00fb\u00fc\7t\2"+
		"\2\u00fc\u00fd\7v\2\2\u00fd\u00fe\7k\2\2\u00fe\u00ff\7e\2\2\u00ff\u0100"+
		"\7c\2\2\u0100\u0101\7n\2\2\u0101\u0102\7E\2\2\u0102\u0103\7q\2\2\u0103"+
		"\u0104\7p\2\2\u0104\u0105\7p\2\2\u0105\u0106\7g\2\2\u0106\u0107\7e\2\2"+
		"\u0107\u0108\7v\2\2\u0108<\3\2\2\2\u0109\u010a\7[\2\2\u010a\u010b\7G\2"+
		"\2\u010b\u010c\7U\2\2\u010c>\3\2\2\2\u010d\u010e\7P\2\2\u010e\u010f\7"+
		"Q\2\2\u010f@\3\2\2\2\u0110\u0111\7X\2\2\u0111B\3\2\2\2\u0112\u0113\7J"+
		"\2\2\u0113D\3\2\2\2\u0114\u0118\t\2\2\2\u0115\u0117\t\3\2\2\u0116\u0115"+
		"\3\2\2\2\u0117\u011a\3\2\2\2\u0118\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119"+
		"F\3\2\2\2\u011a\u0118\3\2\2\2\u011b\u011f\t\4\2\2\u011c\u011e\t\5\2\2"+
		"\u011d\u011c\3\2\2\2\u011e\u0121\3\2\2\2\u011f\u011d\3\2\2\2\u011f\u0120"+
		"\3\2\2\2\u0120H\3\2\2\2\u0121\u011f\3\2\2\2\u0122\u0124\t\6\2\2\u0123"+
		"\u0122\3\2\2\2\u0124\u0125\3\2\2\2\u0125\u0123\3\2\2\2\u0125\u0126\3\2"+
		"\2\2\u0126J\3\2\2\2\u0127\u0129\t\7\2\2\u0128\u0127\3\2\2\2\u0129\u012a"+
		"\3\2\2\2\u012a\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u012c\3\2\2\2\u012c"+
		"\u012d\b&\2\2\u012dL\3\2\2\2\u012e\u0132\7%\2\2\u012f\u0131\n\b\2\2\u0130"+
		"\u012f\3\2\2\2\u0131\u0134\3\2\2\2\u0132\u0130\3\2\2\2\u0132\u0133\3\2"+
		"\2\2\u0133\u0135\3\2\2\2\u0134\u0132\3\2\2\2\u0135\u0136\b\'\2\2\u0136"+
		"N\3\2\2\2\b\2\u0118\u011f\u0125\u012a\u0132\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}