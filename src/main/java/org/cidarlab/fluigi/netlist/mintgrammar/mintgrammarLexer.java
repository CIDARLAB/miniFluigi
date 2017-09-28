// Generated from /Users/krishna/CIDAR/MiniFluigi/src/main/ANTLR/mintgrammar.g4 by ANTLR 4.7
package org.cidarlab.fluigi.netlist.mintgrammar;
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
		T__31=32, T__32=33, T__33=34, T__34=35, ID=36, ID_BIG=37, INT=38, WS=39, 
		COMMENT=40;
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
		"T__33", "T__34", "ID", "ID_BIG", "INT", "WS", "COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'IMPORT'", "'3D'", "'DEVICE'", "';'", "'LAYER FLOW'", "'END LAYER'", 
		"'LAYER CONTROL'", "'LAYER INTEGRATION'", "'BANK'", "'of'", "'GRID'", 
		"','", "'to'", "'VALVE'", "'3DVALVE'", "'on'", "'NODE'", "'CHANNEL'", 
		"'from'", "'NET'", "'='", "'width'", "'w'", "'channelWidth'", "'dir'", 
		"'RIGHT'", "'LEFT'", "'UP'", "'DOWN'", "'horizontalConnect'", "'verticalConnect'", 
		"'YES'", "'NO'", "'V'", "'H'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"ID", "ID_BIG", "INT", "WS", "COMMENT"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2*\u0152\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3"+
		"\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3"+
		"\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3"+
		"\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\36\3"+
		"\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3"+
		"\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3"+
		" \3 \3 \3!\3!\3!\3!\3\"\3\"\3\"\3#\3#\3$\3$\3%\3%\7%\u0132\n%\f%\16%\u0135"+
		"\13%\3&\3&\7&\u0139\n&\f&\16&\u013c\13&\3\'\6\'\u013f\n\'\r\'\16\'\u0140"+
		"\3(\6(\u0144\n(\r(\16(\u0145\3(\3(\3)\3)\7)\u014c\n)\f)\16)\u014f\13)"+
		"\3)\3)\2\2*\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67"+
		"\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*\3\2\t\4\2aac|\6\2\62;C\\aac|\4\2C"+
		"\\aa\5\2\62;C\\aa\3\2\62;\5\2\13\f\17\17\"\"\4\2\f\f\17\17\2\u0156\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31"+
		"\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2"+
		"\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2"+
		"\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2"+
		"\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2"+
		"I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\3S\3\2\2\2\5Z\3"+
		"\2\2\2\7]\3\2\2\2\td\3\2\2\2\13f\3\2\2\2\rq\3\2\2\2\17{\3\2\2\2\21\u0089"+
		"\3\2\2\2\23\u009b\3\2\2\2\25\u00a0\3\2\2\2\27\u00a3\3\2\2\2\31\u00a8\3"+
		"\2\2\2\33\u00aa\3\2\2\2\35\u00ad\3\2\2\2\37\u00b3\3\2\2\2!\u00bb\3\2\2"+
		"\2#\u00be\3\2\2\2%\u00c3\3\2\2\2\'\u00cb\3\2\2\2)\u00d0\3\2\2\2+\u00d4"+
		"\3\2\2\2-\u00d6\3\2\2\2/\u00dc\3\2\2\2\61\u00de\3\2\2\2\63\u00eb\3\2\2"+
		"\2\65\u00ef\3\2\2\2\67\u00f5\3\2\2\29\u00fa\3\2\2\2;\u00fd\3\2\2\2=\u0102"+
		"\3\2\2\2?\u0114\3\2\2\2A\u0124\3\2\2\2C\u0128\3\2\2\2E\u012b\3\2\2\2G"+
		"\u012d\3\2\2\2I\u012f\3\2\2\2K\u0136\3\2\2\2M\u013e\3\2\2\2O\u0143\3\2"+
		"\2\2Q\u0149\3\2\2\2ST\7K\2\2TU\7O\2\2UV\7R\2\2VW\7Q\2\2WX\7T\2\2XY\7V"+
		"\2\2Y\4\3\2\2\2Z[\7\65\2\2[\\\7F\2\2\\\6\3\2\2\2]^\7F\2\2^_\7G\2\2_`\7"+
		"X\2\2`a\7K\2\2ab\7E\2\2bc\7G\2\2c\b\3\2\2\2de\7=\2\2e\n\3\2\2\2fg\7N\2"+
		"\2gh\7C\2\2hi\7[\2\2ij\7G\2\2jk\7T\2\2kl\7\"\2\2lm\7H\2\2mn\7N\2\2no\7"+
		"Q\2\2op\7Y\2\2p\f\3\2\2\2qr\7G\2\2rs\7P\2\2st\7F\2\2tu\7\"\2\2uv\7N\2"+
		"\2vw\7C\2\2wx\7[\2\2xy\7G\2\2yz\7T\2\2z\16\3\2\2\2{|\7N\2\2|}\7C\2\2}"+
		"~\7[\2\2~\177\7G\2\2\177\u0080\7T\2\2\u0080\u0081\7\"\2\2\u0081\u0082"+
		"\7E\2\2\u0082\u0083\7Q\2\2\u0083\u0084\7P\2\2\u0084\u0085\7V\2\2\u0085"+
		"\u0086\7T\2\2\u0086\u0087\7Q\2\2\u0087\u0088\7N\2\2\u0088\20\3\2\2\2\u0089"+
		"\u008a\7N\2\2\u008a\u008b\7C\2\2\u008b\u008c\7[\2\2\u008c\u008d\7G\2\2"+
		"\u008d\u008e\7T\2\2\u008e\u008f\7\"\2\2\u008f\u0090\7K\2\2\u0090\u0091"+
		"\7P\2\2\u0091\u0092\7V\2\2\u0092\u0093\7G\2\2\u0093\u0094\7I\2\2\u0094"+
		"\u0095\7T\2\2\u0095\u0096\7C\2\2\u0096\u0097\7V\2\2\u0097\u0098\7K\2\2"+
		"\u0098\u0099\7Q\2\2\u0099\u009a\7P\2\2\u009a\22\3\2\2\2\u009b\u009c\7"+
		"D\2\2\u009c\u009d\7C\2\2\u009d\u009e\7P\2\2\u009e\u009f\7M\2\2\u009f\24"+
		"\3\2\2\2\u00a0\u00a1\7q\2\2\u00a1\u00a2\7h\2\2\u00a2\26\3\2\2\2\u00a3"+
		"\u00a4\7I\2\2\u00a4\u00a5\7T\2\2\u00a5\u00a6\7K\2\2\u00a6\u00a7\7F\2\2"+
		"\u00a7\30\3\2\2\2\u00a8\u00a9\7.\2\2\u00a9\32\3\2\2\2\u00aa\u00ab\7v\2"+
		"\2\u00ab\u00ac\7q\2\2\u00ac\34\3\2\2\2\u00ad\u00ae\7X\2\2\u00ae\u00af"+
		"\7C\2\2\u00af\u00b0\7N\2\2\u00b0\u00b1\7X\2\2\u00b1\u00b2\7G\2\2\u00b2"+
		"\36\3\2\2\2\u00b3\u00b4\7\65\2\2\u00b4\u00b5\7F\2\2\u00b5\u00b6\7X\2\2"+
		"\u00b6\u00b7\7C\2\2\u00b7\u00b8\7N\2\2\u00b8\u00b9\7X\2\2\u00b9\u00ba"+
		"\7G\2\2\u00ba \3\2\2\2\u00bb\u00bc\7q\2\2\u00bc\u00bd\7p\2\2\u00bd\"\3"+
		"\2\2\2\u00be\u00bf\7P\2\2\u00bf\u00c0\7Q\2\2\u00c0\u00c1\7F\2\2\u00c1"+
		"\u00c2\7G\2\2\u00c2$\3\2\2\2\u00c3\u00c4\7E\2\2\u00c4\u00c5\7J\2\2\u00c5"+
		"\u00c6\7C\2\2\u00c6\u00c7\7P\2\2\u00c7\u00c8\7P\2\2\u00c8\u00c9\7G\2\2"+
		"\u00c9\u00ca\7N\2\2\u00ca&\3\2\2\2\u00cb\u00cc\7h\2\2\u00cc\u00cd\7t\2"+
		"\2\u00cd\u00ce\7q\2\2\u00ce\u00cf\7o\2\2\u00cf(\3\2\2\2\u00d0\u00d1\7"+
		"P\2\2\u00d1\u00d2\7G\2\2\u00d2\u00d3\7V\2\2\u00d3*\3\2\2\2\u00d4\u00d5"+
		"\7?\2\2\u00d5,\3\2\2\2\u00d6\u00d7\7y\2\2\u00d7\u00d8\7k\2\2\u00d8\u00d9"+
		"\7f\2\2\u00d9\u00da\7v\2\2\u00da\u00db\7j\2\2\u00db.\3\2\2\2\u00dc\u00dd"+
		"\7y\2\2\u00dd\60\3\2\2\2\u00de\u00df\7e\2\2\u00df\u00e0\7j\2\2\u00e0\u00e1"+
		"\7c\2\2\u00e1\u00e2\7p\2\2\u00e2\u00e3\7p\2\2\u00e3\u00e4\7g\2\2\u00e4"+
		"\u00e5\7n\2\2\u00e5\u00e6\7Y\2\2\u00e6\u00e7\7k\2\2\u00e7\u00e8\7f\2\2"+
		"\u00e8\u00e9\7v\2\2\u00e9\u00ea\7j\2\2\u00ea\62\3\2\2\2\u00eb\u00ec\7"+
		"f\2\2\u00ec\u00ed\7k\2\2\u00ed\u00ee\7t\2\2\u00ee\64\3\2\2\2\u00ef\u00f0"+
		"\7T\2\2\u00f0\u00f1\7K\2\2\u00f1\u00f2\7I\2\2\u00f2\u00f3\7J\2\2\u00f3"+
		"\u00f4\7V\2\2\u00f4\66\3\2\2\2\u00f5\u00f6\7N\2\2\u00f6\u00f7\7G\2\2\u00f7"+
		"\u00f8\7H\2\2\u00f8\u00f9\7V\2\2\u00f98\3\2\2\2\u00fa\u00fb\7W\2\2\u00fb"+
		"\u00fc\7R\2\2\u00fc:\3\2\2\2\u00fd\u00fe\7F\2\2\u00fe\u00ff\7Q\2\2\u00ff"+
		"\u0100\7Y\2\2\u0100\u0101\7P\2\2\u0101<\3\2\2\2\u0102\u0103\7j\2\2\u0103"+
		"\u0104\7q\2\2\u0104\u0105\7t\2\2\u0105\u0106\7k\2\2\u0106\u0107\7|\2\2"+
		"\u0107\u0108\7q\2\2\u0108\u0109\7p\2\2\u0109\u010a\7v\2\2\u010a\u010b"+
		"\7c\2\2\u010b\u010c\7n\2\2\u010c\u010d\7E\2\2\u010d\u010e\7q\2\2\u010e"+
		"\u010f\7p\2\2\u010f\u0110\7p\2\2\u0110\u0111\7g\2\2\u0111\u0112\7e\2\2"+
		"\u0112\u0113\7v\2\2\u0113>\3\2\2\2\u0114\u0115\7x\2\2\u0115\u0116\7g\2"+
		"\2\u0116\u0117\7t\2\2\u0117\u0118\7v\2\2\u0118\u0119\7k\2\2\u0119\u011a"+
		"\7e\2\2\u011a\u011b\7c\2\2\u011b\u011c\7n\2\2\u011c\u011d\7E\2\2\u011d"+
		"\u011e\7q\2\2\u011e\u011f\7p\2\2\u011f\u0120\7p\2\2\u0120\u0121\7g\2\2"+
		"\u0121\u0122\7e\2\2\u0122\u0123\7v\2\2\u0123@\3\2\2\2\u0124\u0125\7[\2"+
		"\2\u0125\u0126\7G\2\2\u0126\u0127\7U\2\2\u0127B\3\2\2\2\u0128\u0129\7"+
		"P\2\2\u0129\u012a\7Q\2\2\u012aD\3\2\2\2\u012b\u012c\7X\2\2\u012cF\3\2"+
		"\2\2\u012d\u012e\7J\2\2\u012eH\3\2\2\2\u012f\u0133\t\2\2\2\u0130\u0132"+
		"\t\3\2\2\u0131\u0130\3\2\2\2\u0132\u0135\3\2\2\2\u0133\u0131\3\2\2\2\u0133"+
		"\u0134\3\2\2\2\u0134J\3\2\2\2\u0135\u0133\3\2\2\2\u0136\u013a\t\4\2\2"+
		"\u0137\u0139\t\5\2\2\u0138\u0137\3\2\2\2\u0139\u013c\3\2\2\2\u013a\u0138"+
		"\3\2\2\2\u013a\u013b\3\2\2\2\u013bL\3\2\2\2\u013c\u013a\3\2\2\2\u013d"+
		"\u013f\t\6\2\2\u013e\u013d\3\2\2\2\u013f\u0140\3\2\2\2\u0140\u013e\3\2"+
		"\2\2\u0140\u0141\3\2\2\2\u0141N\3\2\2\2\u0142\u0144\t\7\2\2\u0143\u0142"+
		"\3\2\2\2\u0144\u0145\3\2\2\2\u0145\u0143\3\2\2\2\u0145\u0146\3\2\2\2\u0146"+
		"\u0147\3\2\2\2\u0147\u0148\b(\2\2\u0148P\3\2\2\2\u0149\u014d\7%\2\2\u014a"+
		"\u014c\n\b\2\2\u014b\u014a\3\2\2\2\u014c\u014f\3\2\2\2\u014d\u014b\3\2"+
		"\2\2\u014d\u014e\3\2\2\2\u014e\u0150\3\2\2\2\u014f\u014d\3\2\2\2\u0150"+
		"\u0151\b)\2\2\u0151R\3\2\2\2\b\2\u0133\u013a\u0140\u0145\u014d\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}