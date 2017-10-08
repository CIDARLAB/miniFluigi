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
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, ID=40, ID_BIG=41, INT=42, WS=43, COMMENT=44;
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
		"T__33", "T__34", "T__35", "T__36", "T__37", "T__38", "ID", "ID_BIG", 
		"INT", "WS", "COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'IMPORT'", "'3D'", "'DEVICE'", "';'", "'LAYER FLOW'", "'END LAYER'", 
		"'LAYER CONTROL'", "'LAYER INTEGRATION'", "'BANK'", "'of'", "'GRID'", 
		"','", "'to'", "'VALVE'", "'3DVALVE'", "'on'", "'NODE'", "'CHANNEL'", 
		"'from'", "'NET'", "'='", "'width'", "'w'", "'channelWidth'", "'dir'", 
		"'RIGHT'", "'LEFT'", "'UP'", "'DOWN'", "'horizontalConnect'", "'verticalConnect'", 
		"'verticalValves'", "'horizontalValves'", "'verticalSpacing'", "'horizontalSpacing'", 
		"'YES'", "'NO'", "'V'", "'H'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, "ID", "ID_BIG", "INT", "WS", "COMMENT"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2.\u019c\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f"+
		"\3\f\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3"+
		"\25\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3"+
		"\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35\3"+
		"\35\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3"+
		"\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3"+
		" \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3"+
		"!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3"+
		"\"\3\"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$"+
		"\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3&\3&\3&\3\'\3\'\3"+
		"(\3(\3)\3)\7)\u017c\n)\f)\16)\u017f\13)\3*\3*\7*\u0183\n*\f*\16*\u0186"+
		"\13*\3+\6+\u0189\n+\r+\16+\u018a\3,\6,\u018e\n,\r,\16,\u018f\3,\3,\3-"+
		"\3-\7-\u0196\n-\f-\16-\u0199\13-\3-\3-\2\2.\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+"+
		"\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+"+
		"U,W-Y.\3\2\t\4\2aac|\6\2\62;C\\aac|\4\2C\\aa\5\2\62;C\\aa\3\2\62;\5\2"+
		"\13\f\17\17\"\"\4\2\f\f\17\17\2\u01a0\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2"+
		"\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2"+
		"\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3"+
		"\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3"+
		"\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65"+
		"\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3"+
		"\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2"+
		"\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\3"+
		"[\3\2\2\2\5b\3\2\2\2\7e\3\2\2\2\tl\3\2\2\2\13n\3\2\2\2\ry\3\2\2\2\17\u0083"+
		"\3\2\2\2\21\u0091\3\2\2\2\23\u00a3\3\2\2\2\25\u00a8\3\2\2\2\27\u00ab\3"+
		"\2\2\2\31\u00b0\3\2\2\2\33\u00b2\3\2\2\2\35\u00b5\3\2\2\2\37\u00bb\3\2"+
		"\2\2!\u00c3\3\2\2\2#\u00c6\3\2\2\2%\u00cb\3\2\2\2\'\u00d3\3\2\2\2)\u00d8"+
		"\3\2\2\2+\u00dc\3\2\2\2-\u00de\3\2\2\2/\u00e4\3\2\2\2\61\u00e6\3\2\2\2"+
		"\63\u00f3\3\2\2\2\65\u00f7\3\2\2\2\67\u00fd\3\2\2\29\u0102\3\2\2\2;\u0105"+
		"\3\2\2\2=\u010a\3\2\2\2?\u011c\3\2\2\2A\u012c\3\2\2\2C\u013b\3\2\2\2E"+
		"\u014c\3\2\2\2G\u015c\3\2\2\2I\u016e\3\2\2\2K\u0172\3\2\2\2M\u0175\3\2"+
		"\2\2O\u0177\3\2\2\2Q\u0179\3\2\2\2S\u0180\3\2\2\2U\u0188\3\2\2\2W\u018d"+
		"\3\2\2\2Y\u0193\3\2\2\2[\\\7K\2\2\\]\7O\2\2]^\7R\2\2^_\7Q\2\2_`\7T\2\2"+
		"`a\7V\2\2a\4\3\2\2\2bc\7\65\2\2cd\7F\2\2d\6\3\2\2\2ef\7F\2\2fg\7G\2\2"+
		"gh\7X\2\2hi\7K\2\2ij\7E\2\2jk\7G\2\2k\b\3\2\2\2lm\7=\2\2m\n\3\2\2\2no"+
		"\7N\2\2op\7C\2\2pq\7[\2\2qr\7G\2\2rs\7T\2\2st\7\"\2\2tu\7H\2\2uv\7N\2"+
		"\2vw\7Q\2\2wx\7Y\2\2x\f\3\2\2\2yz\7G\2\2z{\7P\2\2{|\7F\2\2|}\7\"\2\2}"+
		"~\7N\2\2~\177\7C\2\2\177\u0080\7[\2\2\u0080\u0081\7G\2\2\u0081\u0082\7"+
		"T\2\2\u0082\16\3\2\2\2\u0083\u0084\7N\2\2\u0084\u0085\7C\2\2\u0085\u0086"+
		"\7[\2\2\u0086\u0087\7G\2\2\u0087\u0088\7T\2\2\u0088\u0089\7\"\2\2\u0089"+
		"\u008a\7E\2\2\u008a\u008b\7Q\2\2\u008b\u008c\7P\2\2\u008c\u008d\7V\2\2"+
		"\u008d\u008e\7T\2\2\u008e\u008f\7Q\2\2\u008f\u0090\7N\2\2\u0090\20\3\2"+
		"\2\2\u0091\u0092\7N\2\2\u0092\u0093\7C\2\2\u0093\u0094\7[\2\2\u0094\u0095"+
		"\7G\2\2\u0095\u0096\7T\2\2\u0096\u0097\7\"\2\2\u0097\u0098\7K\2\2\u0098"+
		"\u0099\7P\2\2\u0099\u009a\7V\2\2\u009a\u009b\7G\2\2\u009b\u009c\7I\2\2"+
		"\u009c\u009d\7T\2\2\u009d\u009e\7C\2\2\u009e\u009f\7V\2\2\u009f\u00a0"+
		"\7K\2\2\u00a0\u00a1\7Q\2\2\u00a1\u00a2\7P\2\2\u00a2\22\3\2\2\2\u00a3\u00a4"+
		"\7D\2\2\u00a4\u00a5\7C\2\2\u00a5\u00a6\7P\2\2\u00a6\u00a7\7M\2\2\u00a7"+
		"\24\3\2\2\2\u00a8\u00a9\7q\2\2\u00a9\u00aa\7h\2\2\u00aa\26\3\2\2\2\u00ab"+
		"\u00ac\7I\2\2\u00ac\u00ad\7T\2\2\u00ad\u00ae\7K\2\2\u00ae\u00af\7F\2\2"+
		"\u00af\30\3\2\2\2\u00b0\u00b1\7.\2\2\u00b1\32\3\2\2\2\u00b2\u00b3\7v\2"+
		"\2\u00b3\u00b4\7q\2\2\u00b4\34\3\2\2\2\u00b5\u00b6\7X\2\2\u00b6\u00b7"+
		"\7C\2\2\u00b7\u00b8\7N\2\2\u00b8\u00b9\7X\2\2\u00b9\u00ba\7G\2\2\u00ba"+
		"\36\3\2\2\2\u00bb\u00bc\7\65\2\2\u00bc\u00bd\7F\2\2\u00bd\u00be\7X\2\2"+
		"\u00be\u00bf\7C\2\2\u00bf\u00c0\7N\2\2\u00c0\u00c1\7X\2\2\u00c1\u00c2"+
		"\7G\2\2\u00c2 \3\2\2\2\u00c3\u00c4\7q\2\2\u00c4\u00c5\7p\2\2\u00c5\"\3"+
		"\2\2\2\u00c6\u00c7\7P\2\2\u00c7\u00c8\7Q\2\2\u00c8\u00c9\7F\2\2\u00c9"+
		"\u00ca\7G\2\2\u00ca$\3\2\2\2\u00cb\u00cc\7E\2\2\u00cc\u00cd\7J\2\2\u00cd"+
		"\u00ce\7C\2\2\u00ce\u00cf\7P\2\2\u00cf\u00d0\7P\2\2\u00d0\u00d1\7G\2\2"+
		"\u00d1\u00d2\7N\2\2\u00d2&\3\2\2\2\u00d3\u00d4\7h\2\2\u00d4\u00d5\7t\2"+
		"\2\u00d5\u00d6\7q\2\2\u00d6\u00d7\7o\2\2\u00d7(\3\2\2\2\u00d8\u00d9\7"+
		"P\2\2\u00d9\u00da\7G\2\2\u00da\u00db\7V\2\2\u00db*\3\2\2\2\u00dc\u00dd"+
		"\7?\2\2\u00dd,\3\2\2\2\u00de\u00df\7y\2\2\u00df\u00e0\7k\2\2\u00e0\u00e1"+
		"\7f\2\2\u00e1\u00e2\7v\2\2\u00e2\u00e3\7j\2\2\u00e3.\3\2\2\2\u00e4\u00e5"+
		"\7y\2\2\u00e5\60\3\2\2\2\u00e6\u00e7\7e\2\2\u00e7\u00e8\7j\2\2\u00e8\u00e9"+
		"\7c\2\2\u00e9\u00ea\7p\2\2\u00ea\u00eb\7p\2\2\u00eb\u00ec\7g\2\2\u00ec"+
		"\u00ed\7n\2\2\u00ed\u00ee\7Y\2\2\u00ee\u00ef\7k\2\2\u00ef\u00f0\7f\2\2"+
		"\u00f0\u00f1\7v\2\2\u00f1\u00f2\7j\2\2\u00f2\62\3\2\2\2\u00f3\u00f4\7"+
		"f\2\2\u00f4\u00f5\7k\2\2\u00f5\u00f6\7t\2\2\u00f6\64\3\2\2\2\u00f7\u00f8"+
		"\7T\2\2\u00f8\u00f9\7K\2\2\u00f9\u00fa\7I\2\2\u00fa\u00fb\7J\2\2\u00fb"+
		"\u00fc\7V\2\2\u00fc\66\3\2\2\2\u00fd\u00fe\7N\2\2\u00fe\u00ff\7G\2\2\u00ff"+
		"\u0100\7H\2\2\u0100\u0101\7V\2\2\u01018\3\2\2\2\u0102\u0103\7W\2\2\u0103"+
		"\u0104\7R\2\2\u0104:\3\2\2\2\u0105\u0106\7F\2\2\u0106\u0107\7Q\2\2\u0107"+
		"\u0108\7Y\2\2\u0108\u0109\7P\2\2\u0109<\3\2\2\2\u010a\u010b\7j\2\2\u010b"+
		"\u010c\7q\2\2\u010c\u010d\7t\2\2\u010d\u010e\7k\2\2\u010e\u010f\7|\2\2"+
		"\u010f\u0110\7q\2\2\u0110\u0111\7p\2\2\u0111\u0112\7v\2\2\u0112\u0113"+
		"\7c\2\2\u0113\u0114\7n\2\2\u0114\u0115\7E\2\2\u0115\u0116\7q\2\2\u0116"+
		"\u0117\7p\2\2\u0117\u0118\7p\2\2\u0118\u0119\7g\2\2\u0119\u011a\7e\2\2"+
		"\u011a\u011b\7v\2\2\u011b>\3\2\2\2\u011c\u011d\7x\2\2\u011d\u011e\7g\2"+
		"\2\u011e\u011f\7t\2\2\u011f\u0120\7v\2\2\u0120\u0121\7k\2\2\u0121\u0122"+
		"\7e\2\2\u0122\u0123\7c\2\2\u0123\u0124\7n\2\2\u0124\u0125\7E\2\2\u0125"+
		"\u0126\7q\2\2\u0126\u0127\7p\2\2\u0127\u0128\7p\2\2\u0128\u0129\7g\2\2"+
		"\u0129\u012a\7e\2\2\u012a\u012b\7v\2\2\u012b@\3\2\2\2\u012c\u012d\7x\2"+
		"\2\u012d\u012e\7g\2\2\u012e\u012f\7t\2\2\u012f\u0130\7v\2\2\u0130\u0131"+
		"\7k\2\2\u0131\u0132\7e\2\2\u0132\u0133\7c\2\2\u0133\u0134\7n\2\2\u0134"+
		"\u0135\7X\2\2\u0135\u0136\7c\2\2\u0136\u0137\7n\2\2\u0137\u0138\7x\2\2"+
		"\u0138\u0139\7g\2\2\u0139\u013a\7u\2\2\u013aB\3\2\2\2\u013b\u013c\7j\2"+
		"\2\u013c\u013d\7q\2\2\u013d\u013e\7t\2\2\u013e\u013f\7k\2\2\u013f\u0140"+
		"\7|\2\2\u0140\u0141\7q\2\2\u0141\u0142\7p\2\2\u0142\u0143\7v\2\2\u0143"+
		"\u0144\7c\2\2\u0144\u0145\7n\2\2\u0145\u0146\7X\2\2\u0146\u0147\7c\2\2"+
		"\u0147\u0148\7n\2\2\u0148\u0149\7x\2\2\u0149\u014a\7g\2\2\u014a\u014b"+
		"\7u\2\2\u014bD\3\2\2\2\u014c\u014d\7x\2\2\u014d\u014e\7g\2\2\u014e\u014f"+
		"\7t\2\2\u014f\u0150\7v\2\2\u0150\u0151\7k\2\2\u0151\u0152\7e\2\2\u0152"+
		"\u0153\7c\2\2\u0153\u0154\7n\2\2\u0154\u0155\7U\2\2\u0155\u0156\7r\2\2"+
		"\u0156\u0157\7c\2\2\u0157\u0158\7e\2\2\u0158\u0159\7k\2\2\u0159\u015a"+
		"\7p\2\2\u015a\u015b\7i\2\2\u015bF\3\2\2\2\u015c\u015d\7j\2\2\u015d\u015e"+
		"\7q\2\2\u015e\u015f\7t\2\2\u015f\u0160\7k\2\2\u0160\u0161\7|\2\2\u0161"+
		"\u0162\7q\2\2\u0162\u0163\7p\2\2\u0163\u0164\7v\2\2\u0164\u0165\7c\2\2"+
		"\u0165\u0166\7n\2\2\u0166\u0167\7U\2\2\u0167\u0168\7r\2\2\u0168\u0169"+
		"\7c\2\2\u0169\u016a\7e\2\2\u016a\u016b\7k\2\2\u016b\u016c\7p\2\2\u016c"+
		"\u016d\7i\2\2\u016dH\3\2\2\2\u016e\u016f\7[\2\2\u016f\u0170\7G\2\2\u0170"+
		"\u0171\7U\2\2\u0171J\3\2\2\2\u0172\u0173\7P\2\2\u0173\u0174\7Q\2\2\u0174"+
		"L\3\2\2\2\u0175\u0176\7X\2\2\u0176N\3\2\2\2\u0177\u0178\7J\2\2\u0178P"+
		"\3\2\2\2\u0179\u017d\t\2\2\2\u017a\u017c\t\3\2\2\u017b\u017a\3\2\2\2\u017c"+
		"\u017f\3\2\2\2\u017d\u017b\3\2\2\2\u017d\u017e\3\2\2\2\u017eR\3\2\2\2"+
		"\u017f\u017d\3\2\2\2\u0180\u0184\t\4\2\2\u0181\u0183\t\5\2\2\u0182\u0181"+
		"\3\2\2\2\u0183\u0186\3\2\2\2\u0184\u0182\3\2\2\2\u0184\u0185\3\2\2\2\u0185"+
		"T\3\2\2\2\u0186\u0184\3\2\2\2\u0187\u0189\t\6\2\2\u0188\u0187\3\2\2\2"+
		"\u0189\u018a\3\2\2\2\u018a\u0188\3\2\2\2\u018a\u018b\3\2\2\2\u018bV\3"+
		"\2\2\2\u018c\u018e\t\7\2\2\u018d\u018c\3\2\2\2\u018e\u018f\3\2\2\2\u018f"+
		"\u018d\3\2\2\2\u018f\u0190\3\2\2\2\u0190\u0191\3\2\2\2\u0191\u0192\b,"+
		"\2\2\u0192X\3\2\2\2\u0193\u0197\7%\2\2\u0194\u0196\n\b\2\2\u0195\u0194"+
		"\3\2\2\2\u0196\u0199\3\2\2\2\u0197\u0195\3\2\2\2\u0197\u0198\3\2\2\2\u0198"+
		"\u019a\3\2\2\2\u0199\u0197\3\2\2\2\u019a\u019b\b-\2\2\u019bZ\3\2\2\2\b"+
		"\2\u017d\u0184\u018a\u018f\u0197\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}