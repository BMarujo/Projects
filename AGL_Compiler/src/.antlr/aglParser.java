// Generated from /home/marujo/agl-gg11/src/agl.g4 by ANTLR 4.13.1
import type.*;
         import symbol.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class aglParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, T__53=54, T__54=55, T__55=56, T__56=57, T__57=58, T__58=59, 
		T__59=60, T__60=61, T__61=62, T__62=63, T__63=64, T__64=65, T__65=66, 
		T__66=67, T__67=68, T__68=69, T__69=70, T__70=71, T__71=72, INT=73, NUMBER=74, 
		STRING=75, WS=76, BOOL=77, ID=78, LINE_COMMENT=79, BLOCK_COMMENT=80;
	public static final int
		RULE_program = 0, RULE_importSmt = 1, RULE_stat = 2, RULE_for = 3, RULE_wait_command = 4, 
		RULE_expr = 5, RULE_print = 6, RULE_variable_declaration = 7, RULE_variable_parameters = 8, 
		RULE_state = 9, RULE_type = 10, RULE_figures = 11, RULE_figure = 12, RULE_figures_params = 13, 
		RULE_figure_angles = 14, RULE_figure_colors = 15, RULE_length = 16, RULE_text = 17, 
		RULE_view_actions = 18, RULE_close = 19, RULE_move = 20, RULE_refresh = 21, 
		RULE_view = 22, RULE_with = 23, RULE_with_operator = 24, RULE_view_params = 25, 
		RULE_view_measures = 26, RULE_view_axis = 27, RULE_title = 28, RULE_background = 29, 
		RULE_color = 30, RULE_time = 31, RULE_point = 32, RULE_vector = 33;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "importSmt", "stat", "for", "wait_command", "expr", "print", 
			"variable_declaration", "variable_parameters", "state", "type", "figures", 
			"figure", "figures_params", "figure_angles", "figure_colors", "length", 
			"text", "view_actions", "close", "move", "refresh", "view", "with", "with_operator", 
			"view_params", "view_measures", "view_axis", "title", "background", "color", 
			"time", "point", "vector"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'import'", "';'", "'for'", "'in'", "'..'", "'do'", "'{'", "'}'", 
			"'wait'", "'mouse'", "'click'", "'-'", "'+'", "'('", "')'", "'*'", "'/'", 
			"'//'", "'%'", "'=='", "'>'", "'<'", "'>='", "'<='", "'!='", "'not'", 
			"'and'", "'or'", "'print'", "'='", "':'", "'.'", "'state'", "'Number'", 
			"'Point'", "'Vector'", "'Time'", "'Color'", "'Int'", "'String'", "'Boolean'", 
			"'at'", "'Dot'", "'Line'", "'Rectangle'", "'Ellipse'", "'Text'", "'Arc'", 
			"'ArcChord'", "'PieSlice'", "'start'", "'extent'", "'fill'", "'outline'", 
			"'length'", "'text'", "'close'", "'move'", "'by'", "'refresh'", "'after'", 
			"'View'", "'with'", "'width'", "'height'", "'Ox'", "'Oy'", "'title'", 
			"'background'", "'ms'", "'s'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "INT", "NUMBER", "STRING", "WS", "BOOL", "ID", "LINE_COMMENT", 
			"BLOCK_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "agl.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public aglParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(aglParser.EOF, 0); }
		public List<ImportSmtContext> importSmt() {
			return getRuleContexts(ImportSmtContext.class);
		}
		public ImportSmtContext importSmt(int i) {
			return getRuleContext(ImportSmtContext.class,i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(68);
				importSmt();
				}
				}
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -7635861963695689720L) != 0) || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & 55L) != 0)) {
				{
				{
				setState(74);
				stat();
				}
				}
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(80);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ImportSmtContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(aglParser.STRING, 0); }
		public ImportSmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importSmt; }
	}

	public final ImportSmtContext importSmt() throws RecognitionException {
		ImportSmtContext _localctx = new ImportSmtContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_importSmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(T__0);
			setState(83);
			match(STRING);
			setState(84);
			match(T__1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatContext extends ParserRuleContext {
		public View_actionsContext view_actions() {
			return getRuleContext(View_actionsContext.class,0);
		}
		public MoveContext move() {
			return getRuleContext(MoveContext.class,0);
		}
		public ViewContext view() {
			return getRuleContext(ViewContext.class,0);
		}
		public FiguresContext figures() {
			return getRuleContext(FiguresContext.class,0);
		}
		public Variable_declarationContext variable_declaration() {
			return getRuleContext(Variable_declarationContext.class,0);
		}
		public Variable_parametersContext variable_parameters() {
			return getRuleContext(Variable_parametersContext.class,0);
		}
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public WithContext with() {
			return getRuleContext(WithContext.class,0);
		}
		public ForContext for_() {
			return getRuleContext(ForContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_stat);
		try {
			setState(96);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(86);
				view_actions();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(87);
				move();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(88);
				view();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(89);
				figures();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(90);
				variable_declaration();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(91);
				variable_parameters();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(92);
				print();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(93);
				with();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(94);
				for_();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(95);
				expr(0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ForContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(aglParser.ID, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public ForContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for; }
	}

	public final ForContext for_() throws RecognitionException {
		ForContext _localctx = new ForContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_for);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(T__2);
			setState(99);
			match(ID);
			setState(100);
			match(T__3);
			setState(101);
			expr(0);
			setState(102);
			match(T__4);
			setState(103);
			expr(0);
			setState(104);
			match(T__5);
			setState(105);
			match(T__6);
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -7635861963695689720L) != 0) || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & 55L) != 0)) {
				{
				{
				setState(106);
				stat();
				}
				}
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(112);
			match(T__7);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Wait_commandContext extends ParserRuleContext {
		public Wait_commandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wait_command; }
	}

	public final Wait_commandContext wait_command() throws RecognitionException {
		Wait_commandContext _localctx = new Wait_commandContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_wait_command);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(T__8);
			setState(115);
			match(T__9);
			setState(116);
			match(T__10);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public Type t = null;
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
			this.t = ctx.t;
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprComparisonContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprComparisonContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprpointContext extends ExprContext {
		public PointContext point() {
			return getRuleContext(PointContext.class,0);
		}
		public ExprpointContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprStringContext extends ExprContext {
		public TerminalNode STRING() { return getToken(aglParser.STRING, 0); }
		public ExprStringContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprParentContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprParentContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprIntContext extends ExprContext {
		public TerminalNode INT() { return getToken(aglParser.INT, 0); }
		public ExprIntContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprNotContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprNotContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprMultDivModContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprMultDivModContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprAddSubContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprAddSubContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprLogicalContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprLogicalContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprUnaryContext extends ExprContext {
		public Token uop;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprUnaryContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprtimeContext extends ExprContext {
		public TimeContext time() {
			return getRuleContext(TimeContext.class,0);
		}
		public ExprtimeContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprvectorContext extends ExprContext {
		public VectorContext vector() {
			return getRuleContext(VectorContext.class,0);
		}
		public ExprvectorContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprnumberContext extends ExprContext {
		public TerminalNode NUMBER() { return getToken(aglParser.NUMBER, 0); }
		public ExprnumberContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprBoolContext extends ExprContext {
		public TerminalNode BOOL() { return getToken(aglParser.BOOL, 0); }
		public ExprBoolContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprIDContext extends ExprContext {
		public TerminalNode ID() { return getToken(aglParser.ID, 0); }
		public ExprIDContext(ExprContext ctx) { copyFrom(ctx); }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				_localctx = new ExprUnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(119);
				((ExprUnaryContext)_localctx).uop = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__11 || _la==T__12) ) {
					((ExprUnaryContext)_localctx).uop = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(120);
				expr(15);
				}
				break;
			case 2:
				{
				_localctx = new ExprParentContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(121);
				match(T__13);
				setState(122);
				expr(0);
				setState(123);
				match(T__14);
				}
				break;
			case 3:
				{
				_localctx = new ExprNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(125);
				match(T__25);
				setState(126);
				expr(10);
				}
				break;
			case 4:
				{
				_localctx = new ExprtimeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(127);
				time();
				}
				break;
			case 5:
				{
				_localctx = new ExprBoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(128);
				match(BOOL);
				}
				break;
			case 6:
				{
				_localctx = new ExprIDContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(129);
				match(ID);
				}
				break;
			case 7:
				{
				_localctx = new ExprStringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(130);
				match(STRING);
				}
				break;
			case 8:
				{
				_localctx = new ExprpointContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(131);
				point();
				}
				break;
			case 9:
				{
				_localctx = new ExprvectorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(132);
				vector();
				}
				break;
			case 10:
				{
				_localctx = new ExprnumberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(133);
				match(NUMBER);
				}
				break;
			case 11:
				{
				_localctx = new ExprIntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(134);
				match(INT);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(151);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(149);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new ExprMultDivModContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(137);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(138);
						((ExprMultDivModContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 983040L) != 0)) ) {
							((ExprMultDivModContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(139);
						expr(14);
						}
						break;
					case 2:
						{
						_localctx = new ExprAddSubContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(140);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(141);
						((ExprAddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__11 || _la==T__12) ) {
							((ExprAddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(142);
						expr(13);
						}
						break;
					case 3:
						{
						_localctx = new ExprComparisonContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(143);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(144);
						((ExprComparisonContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 66060288L) != 0)) ) {
							((ExprComparisonContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(145);
						expr(12);
						}
						break;
					case 4:
						{
						_localctx = new ExprLogicalContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(146);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(147);
						((ExprLogicalContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__26 || _la==T__27) ) {
							((ExprLogicalContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(148);
						expr(10);
						}
						break;
					}
					} 
				}
				setState(153);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PrintContext extends ParserRuleContext {
		public Token txt;
		public TerminalNode ID() { return getToken(aglParser.ID, 0); }
		public TerminalNode STRING() { return getToken(aglParser.STRING, 0); }
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_print);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(T__28);
			setState(155);
			((PrintContext)_localctx).txt = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==STRING || _la==ID) ) {
				((PrintContext)_localctx).txt = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(156);
			match(T__1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Variable_declarationContext extends ParserRuleContext {
		public Variable_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_declaration; }
	 
		public Variable_declarationContext() { }
		public void copyFrom(Variable_declarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VarfigureContext extends Variable_declarationContext {
		public TerminalNode ID() { return getToken(aglParser.ID, 0); }
		public FiguresContext figures() {
			return getRuleContext(FiguresContext.class,0);
		}
		public VarfigureContext(Variable_declarationContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VartypeContext extends Variable_declarationContext {
		public TerminalNode ID() { return getToken(aglParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Wait_commandContext wait_command() {
			return getRuleContext(Wait_commandContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public VartypeContext(Variable_declarationContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VardefaultContext extends Variable_declarationContext {
		public TerminalNode ID() { return getToken(aglParser.ID, 0); }
		public Wait_commandContext wait_command() {
			return getRuleContext(Wait_commandContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public VardefaultContext(Variable_declarationContext ctx) { copyFrom(ctx); }
	}

	public final Variable_declarationContext variable_declaration() throws RecognitionException {
		Variable_declarationContext _localctx = new Variable_declarationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_variable_declaration);
		try {
			setState(179);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				_localctx = new VardefaultContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(158);
				match(ID);
				setState(159);
				match(T__29);
				setState(162);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__8:
					{
					setState(160);
					wait_command();
					}
					break;
				case T__11:
				case T__12:
				case T__13:
				case T__25:
				case INT:
				case NUMBER:
				case STRING:
				case BOOL:
				case ID:
					{
					setState(161);
					expr(0);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(164);
				match(T__1);
				}
				break;
			case 2:
				_localctx = new VartypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(166);
				match(ID);
				setState(167);
				match(T__30);
				setState(168);
				type();
				setState(169);
				match(T__29);
				setState(172);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__8:
					{
					setState(170);
					wait_command();
					}
					break;
				case T__11:
				case T__12:
				case T__13:
				case T__25:
				case INT:
				case NUMBER:
				case STRING:
				case BOOL:
				case ID:
					{
					setState(171);
					expr(0);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(174);
				match(T__1);
				}
				break;
			case 3:
				_localctx = new VarfigureContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(176);
				match(ID);
				setState(177);
				match(T__30);
				setState(178);
				figures();
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

	@SuppressWarnings("CheckReturnValue")
	public static class Variable_parametersContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(aglParser.ID, 0); }
		public StateContext state() {
			return getRuleContext(StateContext.class,0);
		}
		public Variable_parametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_parameters; }
	}

	public final Variable_parametersContext variable_parameters() throws RecognitionException {
		Variable_parametersContext _localctx = new Variable_parametersContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_variable_parameters);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			match(ID);
			setState(182);
			match(T__31);
			setState(183);
			state();
			setState(184);
			match(T__1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StateContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(aglParser.STRING, 0); }
		public StateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_state; }
	}

	public final StateContext state() throws RecognitionException {
		StateContext _localctx = new StateContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_state);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			match(T__32);
			setState(187);
			match(T__29);
			setState(188);
			match(STRING);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4380866641920L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class FiguresContext extends ParserRuleContext {
		public FiguresContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_figures; }
	 
		public FiguresContext() { }
		public void copyFrom(FiguresContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Figures_expr_withContext extends FiguresContext {
		public FigureContext figure() {
			return getRuleContext(FigureContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public With_operatorContext with_operator() {
			return getRuleContext(With_operatorContext.class,0);
		}
		public Figures_expr_withContext(FiguresContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Figures_exprContext extends FiguresContext {
		public FigureContext figure() {
			return getRuleContext(FigureContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Figures_exprContext(FiguresContext ctx) { copyFrom(ctx); }
	}

	public final FiguresContext figures() throws RecognitionException {
		FiguresContext _localctx = new FiguresContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_figures);
		try {
			setState(202);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				_localctx = new Figures_exprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(192);
				figure();
				setState(193);
				match(T__41);
				setState(194);
				expr(0);
				setState(195);
				match(T__1);
				}
				break;
			case 2:
				_localctx = new Figures_expr_withContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(197);
				figure();
				setState(198);
				match(T__41);
				setState(199);
				expr(0);
				setState(200);
				with_operator();
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

	@SuppressWarnings("CheckReturnValue")
	public static class FigureContext extends ParserRuleContext {
		public FigureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_figure; }
	}

	public final FigureContext figure() throws RecognitionException {
		FigureContext _localctx = new FigureContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_figure);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 2243003720663040L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class Figures_paramsContext extends ParserRuleContext {
		public Figures_paramsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_figures_params; }
	 
		public Figures_paramsContext() { }
		public void copyFrom(Figures_paramsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Figures_params_anglesContext extends Figures_paramsContext {
		public Figure_anglesContext figure_angles() {
			return getRuleContext(Figure_anglesContext.class,0);
		}
		public Figures_params_anglesContext(Figures_paramsContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Figures_params_colorsContext extends Figures_paramsContext {
		public Figure_colorsContext figure_colors() {
			return getRuleContext(Figure_colorsContext.class,0);
		}
		public Figures_params_colorsContext(Figures_paramsContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Figures_params_textContext extends Figures_paramsContext {
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public Figures_params_textContext(Figures_paramsContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Figures_params_lengthContext extends Figures_paramsContext {
		public LengthContext length() {
			return getRuleContext(LengthContext.class,0);
		}
		public Figures_params_lengthContext(Figures_paramsContext ctx) { copyFrom(ctx); }
	}

	public final Figures_paramsContext figures_params() throws RecognitionException {
		Figures_paramsContext _localctx = new Figures_paramsContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_figures_params);
		try {
			setState(218);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__54:
				_localctx = new Figures_params_lengthContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(206);
				length();
				setState(207);
				match(T__1);
				}
				break;
			case T__50:
			case T__51:
				_localctx = new Figures_params_anglesContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(209);
				figure_angles();
				setState(210);
				match(T__1);
				}
				break;
			case T__52:
			case T__53:
				_localctx = new Figures_params_colorsContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(212);
				figure_colors();
				setState(213);
				match(T__1);
				}
				break;
			case T__55:
				_localctx = new Figures_params_textContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(215);
				text();
				setState(216);
				match(T__1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Figure_anglesContext extends ParserRuleContext {
		public Token angle_param;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Figure_anglesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_figure_angles; }
	}

	public final Figure_anglesContext figure_angles() throws RecognitionException {
		Figure_anglesContext _localctx = new Figure_anglesContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_figure_angles);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			((Figure_anglesContext)_localctx).angle_param = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==T__50 || _la==T__51) ) {
				((Figure_anglesContext)_localctx).angle_param = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(221);
			match(T__29);
			setState(222);
			expr(0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Figure_colorsContext extends ParserRuleContext {
		public Token color_param;
		public ColorContext color() {
			return getRuleContext(ColorContext.class,0);
		}
		public Figure_colorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_figure_colors; }
	}

	public final Figure_colorsContext figure_colors() throws RecognitionException {
		Figure_colorsContext _localctx = new Figure_colorsContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_figure_colors);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			((Figure_colorsContext)_localctx).color_param = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==T__52 || _la==T__53) ) {
				((Figure_colorsContext)_localctx).color_param = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(225);
			match(T__29);
			setState(226);
			color();
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

	@SuppressWarnings("CheckReturnValue")
	public static class LengthContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LengthContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_length; }
	}

	public final LengthContext length() throws RecognitionException {
		LengthContext _localctx = new LengthContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_length);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			match(T__54);
			setState(229);
			match(T__29);
			setState(230);
			expr(0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TextContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_text; }
	}

	public final TextContext text() throws RecognitionException {
		TextContext _localctx = new TextContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_text);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			match(T__55);
			setState(233);
			match(T__29);
			setState(234);
			expr(0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class View_actionsContext extends ParserRuleContext {
		public View_actionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_view_actions; }
	 
		public View_actionsContext() { }
		public void copyFrom(View_actionsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class View_action_closeContext extends View_actionsContext {
		public CloseContext close() {
			return getRuleContext(CloseContext.class,0);
		}
		public View_action_closeContext(View_actionsContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class View_action_refreshContext extends View_actionsContext {
		public RefreshContext refresh() {
			return getRuleContext(RefreshContext.class,0);
		}
		public View_action_refreshContext(View_actionsContext ctx) { copyFrom(ctx); }
	}

	public final View_actionsContext view_actions() throws RecognitionException {
		View_actionsContext _localctx = new View_actionsContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_view_actions);
		try {
			setState(238);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__59:
				_localctx = new View_action_refreshContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(236);
				refresh();
				}
				break;
			case T__56:
				_localctx = new View_action_closeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(237);
				close();
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

	@SuppressWarnings("CheckReturnValue")
	public static class CloseContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(aglParser.ID, 0); }
		public ViewContext view() {
			return getRuleContext(ViewContext.class,0);
		}
		public CloseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_close; }
	}

	public final CloseContext close() throws RecognitionException {
		CloseContext _localctx = new CloseContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_close);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			match(T__56);
			setState(243);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(241);
				match(ID);
				}
				break;
			case 2:
				{
				setState(242);
				view();
				}
				break;
			}
			setState(245);
			match(T__1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class MoveContext extends ParserRuleContext {
		public MoveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_move; }
	 
		public MoveContext() { }
		public void copyFrom(MoveContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MoveviewContext extends MoveContext {
		public ViewContext view() {
			return getRuleContext(ViewContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public MoveviewContext(MoveContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MovefigureContext extends MoveContext {
		public FigureContext figure() {
			return getRuleContext(FigureContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public MovefigureContext(MoveContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MovevarContext extends MoveContext {
		public TerminalNode ID() { return getToken(aglParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public MovevarContext(MoveContext ctx) { copyFrom(ctx); }
	}

	public final MoveContext move() throws RecognitionException {
		MoveContext _localctx = new MoveContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_move);
		try {
			setState(265);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				_localctx = new MovevarContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(247);
				match(T__57);
				setState(248);
				match(ID);
				setState(249);
				match(T__58);
				setState(250);
				expr(0);
				setState(251);
				match(T__1);
				}
				break;
			case 2:
				_localctx = new MoveviewContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(253);
				match(T__57);
				setState(254);
				view();
				setState(255);
				match(T__58);
				setState(256);
				expr(0);
				setState(257);
				match(T__1);
				}
				break;
			case 3:
				_localctx = new MovefigureContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(259);
				match(T__57);
				setState(260);
				figure();
				setState(261);
				match(T__58);
				setState(262);
				expr(0);
				setState(263);
				match(T__1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class RefreshContext extends ParserRuleContext {
		public RefreshContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_refresh; }
	 
		public RefreshContext() { }
		public void copyFrom(RefreshContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Refresh_defaultContext extends RefreshContext {
		public TerminalNode ID() { return getToken(aglParser.ID, 0); }
		public ViewContext view() {
			return getRuleContext(ViewContext.class,0);
		}
		public Refresh_defaultContext(RefreshContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Refresh_aftertimeContext extends RefreshContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ID() { return getToken(aglParser.ID, 0); }
		public ViewContext view() {
			return getRuleContext(ViewContext.class,0);
		}
		public Refresh_aftertimeContext(RefreshContext ctx) { copyFrom(ctx); }
	}

	public final RefreshContext refresh() throws RecognitionException {
		RefreshContext _localctx = new RefreshContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_refresh);
		try {
			setState(282);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				_localctx = new Refresh_aftertimeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(267);
				match(T__59);
				setState(270);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(268);
					match(ID);
					}
					break;
				case 2:
					{
					setState(269);
					view();
					}
					break;
				}
				setState(272);
				match(T__60);
				setState(273);
				expr(0);
				setState(274);
				match(T__1);
				}
				break;
			case 2:
				_localctx = new Refresh_defaultContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(276);
				match(T__59);
				setState(279);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(277);
					match(ID);
					}
					break;
				case 2:
					{
					setState(278);
					view();
					}
					break;
				}
				setState(281);
				match(T__1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ViewContext extends ParserRuleContext {
		public ViewContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_view; }
	 
		public ViewContext() { }
		public void copyFrom(ViewContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ViewdefaultContext extends ViewContext {
		public TerminalNode ID() { return getToken(aglParser.ID, 0); }
		public ViewdefaultContext(ViewContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class View_with_operatorContext extends ViewContext {
		public TerminalNode ID() { return getToken(aglParser.ID, 0); }
		public With_operatorContext with_operator() {
			return getRuleContext(With_operatorContext.class,0);
		}
		public View_with_operatorContext(ViewContext ctx) { copyFrom(ctx); }
	}

	public final ViewContext view() throws RecognitionException {
		ViewContext _localctx = new ViewContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_view);
		try {
			setState(292);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				_localctx = new View_with_operatorContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(284);
				match(ID);
				setState(285);
				match(T__30);
				setState(286);
				match(T__61);
				setState(287);
				with_operator();
				}
				break;
			case 2:
				_localctx = new ViewdefaultContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(288);
				match(ID);
				setState(289);
				match(T__30);
				setState(290);
				match(T__61);
				setState(291);
				match(T__1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class WithContext extends ParserRuleContext {
		public Type t = null;
		public WithContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_with; }
	 
		public WithContext() { }
		public void copyFrom(WithContext ctx) {
			super.copyFrom(ctx);
			this.t = ctx.t;
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class With_viewparamsContext extends WithContext {
		public TerminalNode ID() { return getToken(aglParser.ID, 0); }
		public List<View_paramsContext> view_params() {
			return getRuleContexts(View_paramsContext.class);
		}
		public View_paramsContext view_params(int i) {
			return getRuleContext(View_paramsContext.class,i);
		}
		public With_viewparamsContext(WithContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class With_figureparamsContext extends WithContext {
		public TerminalNode ID() { return getToken(aglParser.ID, 0); }
		public List<Figures_paramsContext> figures_params() {
			return getRuleContexts(Figures_paramsContext.class);
		}
		public Figures_paramsContext figures_params(int i) {
			return getRuleContext(Figures_paramsContext.class,i);
		}
		public With_figureparamsContext(WithContext ctx) { copyFrom(ctx); }
	}

	public final WithContext with() throws RecognitionException {
		WithContext _localctx = new WithContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_with);
		int _la;
		try {
			setState(316);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				_localctx = new With_figureparamsContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(294);
				match(T__62);
				setState(295);
				match(ID);
				setState(296);
				match(T__5);
				setState(297);
				match(T__6);
				setState(301);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 141863388262170624L) != 0)) {
					{
					{
					setState(298);
					figures_params();
					}
					}
					setState(303);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(304);
				match(T__7);
				}
				break;
			case 2:
				_localctx = new With_viewparamsContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(305);
				match(T__62);
				setState(306);
				match(ID);
				setState(307);
				match(T__5);
				setState(308);
				match(T__6);
				setState(312);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 63L) != 0)) {
					{
					{
					setState(309);
					view_params();
					}
					}
					setState(314);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(315);
				match(T__7);
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

	@SuppressWarnings("CheckReturnValue")
	public static class With_operatorContext extends ParserRuleContext {
		public Type t = null;
		public With_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_with_operator; }
	 
		public With_operatorContext() { }
		public void copyFrom(With_operatorContext ctx) {
			super.copyFrom(ctx);
			this.t = ctx.t;
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class With_operator_viewContext extends With_operatorContext {
		public List<View_paramsContext> view_params() {
			return getRuleContexts(View_paramsContext.class);
		}
		public View_paramsContext view_params(int i) {
			return getRuleContext(View_paramsContext.class,i);
		}
		public With_operator_viewContext(With_operatorContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class With_operator_figureContext extends With_operatorContext {
		public List<Figures_paramsContext> figures_params() {
			return getRuleContexts(Figures_paramsContext.class);
		}
		public Figures_paramsContext figures_params(int i) {
			return getRuleContext(Figures_paramsContext.class,i);
		}
		public With_operator_figureContext(With_operatorContext ctx) { copyFrom(ctx); }
	}

	public final With_operatorContext with_operator() throws RecognitionException {
		With_operatorContext _localctx = new With_operatorContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_with_operator);
		int _la;
		try {
			setState(336);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				_localctx = new With_operator_figureContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(318);
				match(T__62);
				setState(319);
				match(T__6);
				setState(323);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 141863388262170624L) != 0)) {
					{
					{
					setState(320);
					figures_params();
					}
					}
					setState(325);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(326);
				match(T__7);
				}
				break;
			case 2:
				_localctx = new With_operator_viewContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(327);
				match(T__62);
				setState(328);
				match(T__6);
				setState(332);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 63L) != 0)) {
					{
					{
					setState(329);
					view_params();
					}
					}
					setState(334);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(335);
				match(T__7);
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

	@SuppressWarnings("CheckReturnValue")
	public static class View_paramsContext extends ParserRuleContext {
		public View_paramsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_view_params; }
	 
		public View_paramsContext() { }
		public void copyFrom(View_paramsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class View_params_titleContext extends View_paramsContext {
		public TitleContext title() {
			return getRuleContext(TitleContext.class,0);
		}
		public View_params_titleContext(View_paramsContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class View_params_axisContext extends View_paramsContext {
		public View_axisContext view_axis() {
			return getRuleContext(View_axisContext.class,0);
		}
		public View_params_axisContext(View_paramsContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class View_params_backgroundContext extends View_paramsContext {
		public BackgroundContext background() {
			return getRuleContext(BackgroundContext.class,0);
		}
		public View_params_backgroundContext(View_paramsContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class View_params_measuresContext extends View_paramsContext {
		public View_measuresContext view_measures() {
			return getRuleContext(View_measuresContext.class,0);
		}
		public View_params_measuresContext(View_paramsContext ctx) { copyFrom(ctx); }
	}

	public final View_paramsContext view_params() throws RecognitionException {
		View_paramsContext _localctx = new View_paramsContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_view_params);
		try {
			setState(350);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__65:
			case T__66:
				_localctx = new View_params_axisContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(338);
				view_axis();
				setState(339);
				match(T__1);
				}
				break;
			case T__63:
			case T__64:
				_localctx = new View_params_measuresContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(341);
				view_measures();
				setState(342);
				match(T__1);
				}
				break;
			case T__67:
				_localctx = new View_params_titleContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(344);
				title();
				setState(345);
				match(T__1);
				}
				break;
			case T__68:
				_localctx = new View_params_backgroundContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(347);
				background();
				setState(348);
				match(T__1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class View_measuresContext extends ParserRuleContext {
		public View_measuresContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_view_measures; }
	 
		public View_measuresContext() { }
		public void copyFrom(View_measuresContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class View_measures_widthContext extends View_measuresContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public View_measures_widthContext(View_measuresContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class View_measures_heightContext extends View_measuresContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public View_measures_heightContext(View_measuresContext ctx) { copyFrom(ctx); }
	}

	public final View_measuresContext view_measures() throws RecognitionException {
		View_measuresContext _localctx = new View_measuresContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_view_measures);
		try {
			setState(358);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__63:
				_localctx = new View_measures_widthContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(352);
				match(T__63);
				setState(353);
				match(T__29);
				setState(354);
				expr(0);
				}
				break;
			case T__64:
				_localctx = new View_measures_heightContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(355);
				match(T__64);
				setState(356);
				match(T__29);
				setState(357);
				expr(0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class View_axisContext extends ParserRuleContext {
		public View_axisContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_view_axis; }
	 
		public View_axisContext() { }
		public void copyFrom(View_axisContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class View_axis_yContext extends View_axisContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public View_axis_yContext(View_axisContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class View_axis_xContext extends View_axisContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public View_axis_xContext(View_axisContext ctx) { copyFrom(ctx); }
	}

	public final View_axisContext view_axis() throws RecognitionException {
		View_axisContext _localctx = new View_axisContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_view_axis);
		try {
			setState(366);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__65:
				_localctx = new View_axis_xContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(360);
				match(T__65);
				setState(361);
				match(T__29);
				setState(362);
				expr(0);
				}
				break;
			case T__66:
				_localctx = new View_axis_yContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(363);
				match(T__66);
				setState(364);
				match(T__29);
				setState(365);
				expr(0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TitleContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TitleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_title; }
	}

	public final TitleContext title() throws RecognitionException {
		TitleContext _localctx = new TitleContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_title);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(368);
			match(T__67);
			setState(369);
			match(T__29);
			setState(370);
			expr(0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BackgroundContext extends ParserRuleContext {
		public ColorContext color() {
			return getRuleContext(ColorContext.class,0);
		}
		public BackgroundContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_background; }
	}

	public final BackgroundContext background() throws RecognitionException {
		BackgroundContext _localctx = new BackgroundContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_background);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(372);
			match(T__68);
			setState(373);
			match(T__29);
			setState(374);
			color();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ColorContext extends ParserRuleContext {
		public Type t = null;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ColorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_color; }
	}

	public final ColorContext color() throws RecognitionException {
		ColorContext _localctx = new ColorContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_color);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(376);
			expr(0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TimeContext extends ParserRuleContext {
		public Type t = null;
		public Token unit;
		public TerminalNode INT() { return getToken(aglParser.INT, 0); }
		public TimeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_time; }
	}

	public final TimeContext time() throws RecognitionException {
		TimeContext _localctx = new TimeContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_time);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(378);
			match(INT);
			setState(379);
			((TimeContext)_localctx).unit = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==T__69 || _la==T__70) ) {
				((TimeContext)_localctx).unit = (Token)_errHandler.recoverInline(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PointContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public PointContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_point; }
	}

	public final PointContext point() throws RecognitionException {
		PointContext _localctx = new PointContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_point);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(381);
			match(T__13);
			setState(382);
			expr(0);
			setState(383);
			match(T__71);
			setState(384);
			expr(0);
			setState(385);
			match(T__14);
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

	@SuppressWarnings("CheckReturnValue")
	public static class VectorContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public VectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vector; }
	}

	public final VectorContext vector() throws RecognitionException {
		VectorContext _localctx = new VectorContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_vector);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(387);
			match(T__13);
			setState(388);
			expr(0);
			setState(389);
			match(T__30);
			setState(390);
			expr(0);
			setState(391);
			match(T__14);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 5:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 13);
		case 1:
			return precpred(_ctx, 12);
		case 2:
			return precpred(_ctx, 11);
		case 3:
			return precpred(_ctx, 9);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001P\u018a\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0001\u0000\u0005"+
		"\u0000F\b\u0000\n\u0000\f\u0000I\t\u0000\u0001\u0000\u0005\u0000L\b\u0000"+
		"\n\u0000\f\u0000O\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u0002a\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003"+
		"l\b\u0003\n\u0003\f\u0003o\t\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0003\u0005\u0088\b\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u0096\b\u0005"+
		"\n\u0005\f\u0005\u0099\t\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00a3"+
		"\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00ad\b\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00b4\b\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b"+
		"\u00cb\b\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u00db"+
		"\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001"+
		"\u0012\u0003\u0012\u00ef\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0003"+
		"\u0013\u00f4\b\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u010a\b\u0014\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u010f\b\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003"+
		"\u0015\u0118\b\u0015\u0001\u0015\u0003\u0015\u011b\b\u0015\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0003\u0016\u0125\b\u0016\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0005\u0017\u012c\b\u0017\n\u0017\f\u0017\u012f"+
		"\t\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0005\u0017\u0137\b\u0017\n\u0017\f\u0017\u013a\t\u0017\u0001\u0017"+
		"\u0003\u0017\u013d\b\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0005\u0018"+
		"\u0142\b\u0018\n\u0018\f\u0018\u0145\t\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0005\u0018\u014b\b\u0018\n\u0018\f\u0018\u014e\t\u0018"+
		"\u0001\u0018\u0003\u0018\u0151\b\u0018\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u015f\b\u0019\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0003\u001a"+
		"\u0167\b\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0003\u001b\u016f\b\u001b\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001e"+
		"\u0001\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001 "+
		"\u0001 \u0001 \u0001 \u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001"+
		"!\u0000\u0001\n\"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@B\u0000\n\u0001\u0000"+
		"\f\r\u0001\u0000\u0010\u0013\u0001\u0000\u0014\u0019\u0001\u0000\u001b"+
		"\u001c\u0002\u0000KKNN\u0001\u0000\")\u0001\u0000+2\u0001\u000034\u0001"+
		"\u000056\u0001\u0000FG\u019c\u0000G\u0001\u0000\u0000\u0000\u0002R\u0001"+
		"\u0000\u0000\u0000\u0004`\u0001\u0000\u0000\u0000\u0006b\u0001\u0000\u0000"+
		"\u0000\br\u0001\u0000\u0000\u0000\n\u0087\u0001\u0000\u0000\u0000\f\u009a"+
		"\u0001\u0000\u0000\u0000\u000e\u00b3\u0001\u0000\u0000\u0000\u0010\u00b5"+
		"\u0001\u0000\u0000\u0000\u0012\u00ba\u0001\u0000\u0000\u0000\u0014\u00be"+
		"\u0001\u0000\u0000\u0000\u0016\u00ca\u0001\u0000\u0000\u0000\u0018\u00cc"+
		"\u0001\u0000\u0000\u0000\u001a\u00da\u0001\u0000\u0000\u0000\u001c\u00dc"+
		"\u0001\u0000\u0000\u0000\u001e\u00e0\u0001\u0000\u0000\u0000 \u00e4\u0001"+
		"\u0000\u0000\u0000\"\u00e8\u0001\u0000\u0000\u0000$\u00ee\u0001\u0000"+
		"\u0000\u0000&\u00f0\u0001\u0000\u0000\u0000(\u0109\u0001\u0000\u0000\u0000"+
		"*\u011a\u0001\u0000\u0000\u0000,\u0124\u0001\u0000\u0000\u0000.\u013c"+
		"\u0001\u0000\u0000\u00000\u0150\u0001\u0000\u0000\u00002\u015e\u0001\u0000"+
		"\u0000\u00004\u0166\u0001\u0000\u0000\u00006\u016e\u0001\u0000\u0000\u0000"+
		"8\u0170\u0001\u0000\u0000\u0000:\u0174\u0001\u0000\u0000\u0000<\u0178"+
		"\u0001\u0000\u0000\u0000>\u017a\u0001\u0000\u0000\u0000@\u017d\u0001\u0000"+
		"\u0000\u0000B\u0183\u0001\u0000\u0000\u0000DF\u0003\u0002\u0001\u0000"+
		"ED\u0001\u0000\u0000\u0000FI\u0001\u0000\u0000\u0000GE\u0001\u0000\u0000"+
		"\u0000GH\u0001\u0000\u0000\u0000HM\u0001\u0000\u0000\u0000IG\u0001\u0000"+
		"\u0000\u0000JL\u0003\u0004\u0002\u0000KJ\u0001\u0000\u0000\u0000LO\u0001"+
		"\u0000\u0000\u0000MK\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000"+
		"NP\u0001\u0000\u0000\u0000OM\u0001\u0000\u0000\u0000PQ\u0005\u0000\u0000"+
		"\u0001Q\u0001\u0001\u0000\u0000\u0000RS\u0005\u0001\u0000\u0000ST\u0005"+
		"K\u0000\u0000TU\u0005\u0002\u0000\u0000U\u0003\u0001\u0000\u0000\u0000"+
		"Va\u0003$\u0012\u0000Wa\u0003(\u0014\u0000Xa\u0003,\u0016\u0000Ya\u0003"+
		"\u0016\u000b\u0000Za\u0003\u000e\u0007\u0000[a\u0003\u0010\b\u0000\\a"+
		"\u0003\f\u0006\u0000]a\u0003.\u0017\u0000^a\u0003\u0006\u0003\u0000_a"+
		"\u0003\n\u0005\u0000`V\u0001\u0000\u0000\u0000`W\u0001\u0000\u0000\u0000"+
		"`X\u0001\u0000\u0000\u0000`Y\u0001\u0000\u0000\u0000`Z\u0001\u0000\u0000"+
		"\u0000`[\u0001\u0000\u0000\u0000`\\\u0001\u0000\u0000\u0000`]\u0001\u0000"+
		"\u0000\u0000`^\u0001\u0000\u0000\u0000`_\u0001\u0000\u0000\u0000a\u0005"+
		"\u0001\u0000\u0000\u0000bc\u0005\u0003\u0000\u0000cd\u0005N\u0000\u0000"+
		"de\u0005\u0004\u0000\u0000ef\u0003\n\u0005\u0000fg\u0005\u0005\u0000\u0000"+
		"gh\u0003\n\u0005\u0000hi\u0005\u0006\u0000\u0000im\u0005\u0007\u0000\u0000"+
		"jl\u0003\u0004\u0002\u0000kj\u0001\u0000\u0000\u0000lo\u0001\u0000\u0000"+
		"\u0000mk\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000np\u0001\u0000"+
		"\u0000\u0000om\u0001\u0000\u0000\u0000pq\u0005\b\u0000\u0000q\u0007\u0001"+
		"\u0000\u0000\u0000rs\u0005\t\u0000\u0000st\u0005\n\u0000\u0000tu\u0005"+
		"\u000b\u0000\u0000u\t\u0001\u0000\u0000\u0000vw\u0006\u0005\uffff\uffff"+
		"\u0000wx\u0007\u0000\u0000\u0000x\u0088\u0003\n\u0005\u000fyz\u0005\u000e"+
		"\u0000\u0000z{\u0003\n\u0005\u0000{|\u0005\u000f\u0000\u0000|\u0088\u0001"+
		"\u0000\u0000\u0000}~\u0005\u001a\u0000\u0000~\u0088\u0003\n\u0005\n\u007f"+
		"\u0088\u0003>\u001f\u0000\u0080\u0088\u0005M\u0000\u0000\u0081\u0088\u0005"+
		"N\u0000\u0000\u0082\u0088\u0005K\u0000\u0000\u0083\u0088\u0003@ \u0000"+
		"\u0084\u0088\u0003B!\u0000\u0085\u0088\u0005J\u0000\u0000\u0086\u0088"+
		"\u0005I\u0000\u0000\u0087v\u0001\u0000\u0000\u0000\u0087y\u0001\u0000"+
		"\u0000\u0000\u0087}\u0001\u0000\u0000\u0000\u0087\u007f\u0001\u0000\u0000"+
		"\u0000\u0087\u0080\u0001\u0000\u0000\u0000\u0087\u0081\u0001\u0000\u0000"+
		"\u0000\u0087\u0082\u0001\u0000\u0000\u0000\u0087\u0083\u0001\u0000\u0000"+
		"\u0000\u0087\u0084\u0001\u0000\u0000\u0000\u0087\u0085\u0001\u0000\u0000"+
		"\u0000\u0087\u0086\u0001\u0000\u0000\u0000\u0088\u0097\u0001\u0000\u0000"+
		"\u0000\u0089\u008a\n\r\u0000\u0000\u008a\u008b\u0007\u0001\u0000\u0000"+
		"\u008b\u0096\u0003\n\u0005\u000e\u008c\u008d\n\f\u0000\u0000\u008d\u008e"+
		"\u0007\u0000\u0000\u0000\u008e\u0096\u0003\n\u0005\r\u008f\u0090\n\u000b"+
		"\u0000\u0000\u0090\u0091\u0007\u0002\u0000\u0000\u0091\u0096\u0003\n\u0005"+
		"\f\u0092\u0093\n\t\u0000\u0000\u0093\u0094\u0007\u0003\u0000\u0000\u0094"+
		"\u0096\u0003\n\u0005\n\u0095\u0089\u0001\u0000\u0000\u0000\u0095\u008c"+
		"\u0001\u0000\u0000\u0000\u0095\u008f\u0001\u0000\u0000\u0000\u0095\u0092"+
		"\u0001\u0000\u0000\u0000\u0096\u0099\u0001\u0000\u0000\u0000\u0097\u0095"+
		"\u0001\u0000\u0000\u0000\u0097\u0098\u0001\u0000\u0000\u0000\u0098\u000b"+
		"\u0001\u0000\u0000\u0000\u0099\u0097\u0001\u0000\u0000\u0000\u009a\u009b"+
		"\u0005\u001d\u0000\u0000\u009b\u009c\u0007\u0004\u0000\u0000\u009c\u009d"+
		"\u0005\u0002\u0000\u0000\u009d\r\u0001\u0000\u0000\u0000\u009e\u009f\u0005"+
		"N\u0000\u0000\u009f\u00a2\u0005\u001e\u0000\u0000\u00a0\u00a3\u0003\b"+
		"\u0004\u0000\u00a1\u00a3\u0003\n\u0005\u0000\u00a2\u00a0\u0001\u0000\u0000"+
		"\u0000\u00a2\u00a1\u0001\u0000\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000"+
		"\u0000\u00a4\u00a5\u0005\u0002\u0000\u0000\u00a5\u00b4\u0001\u0000\u0000"+
		"\u0000\u00a6\u00a7\u0005N\u0000\u0000\u00a7\u00a8\u0005\u001f\u0000\u0000"+
		"\u00a8\u00a9\u0003\u0014\n\u0000\u00a9\u00ac\u0005\u001e\u0000\u0000\u00aa"+
		"\u00ad\u0003\b\u0004\u0000\u00ab\u00ad\u0003\n\u0005\u0000\u00ac\u00aa"+
		"\u0001\u0000\u0000\u0000\u00ac\u00ab\u0001\u0000\u0000\u0000\u00ad\u00ae"+
		"\u0001\u0000\u0000\u0000\u00ae\u00af\u0005\u0002\u0000\u0000\u00af\u00b4"+
		"\u0001\u0000\u0000\u0000\u00b0\u00b1\u0005N\u0000\u0000\u00b1\u00b2\u0005"+
		"\u001f\u0000\u0000\u00b2\u00b4\u0003\u0016\u000b\u0000\u00b3\u009e\u0001"+
		"\u0000\u0000\u0000\u00b3\u00a6\u0001\u0000\u0000\u0000\u00b3\u00b0\u0001"+
		"\u0000\u0000\u0000\u00b4\u000f\u0001\u0000\u0000\u0000\u00b5\u00b6\u0005"+
		"N\u0000\u0000\u00b6\u00b7\u0005 \u0000\u0000\u00b7\u00b8\u0003\u0012\t"+
		"\u0000\u00b8\u00b9\u0005\u0002\u0000\u0000\u00b9\u0011\u0001\u0000\u0000"+
		"\u0000\u00ba\u00bb\u0005!\u0000\u0000\u00bb\u00bc\u0005\u001e\u0000\u0000"+
		"\u00bc\u00bd\u0005K\u0000\u0000\u00bd\u0013\u0001\u0000\u0000\u0000\u00be"+
		"\u00bf\u0007\u0005\u0000\u0000\u00bf\u0015\u0001\u0000\u0000\u0000\u00c0"+
		"\u00c1\u0003\u0018\f\u0000\u00c1\u00c2\u0005*\u0000\u0000\u00c2\u00c3"+
		"\u0003\n\u0005\u0000\u00c3\u00c4\u0005\u0002\u0000\u0000\u00c4\u00cb\u0001"+
		"\u0000\u0000\u0000\u00c5\u00c6\u0003\u0018\f\u0000\u00c6\u00c7\u0005*"+
		"\u0000\u0000\u00c7\u00c8\u0003\n\u0005\u0000\u00c8\u00c9\u00030\u0018"+
		"\u0000\u00c9\u00cb\u0001\u0000\u0000\u0000\u00ca\u00c0\u0001\u0000\u0000"+
		"\u0000\u00ca\u00c5\u0001\u0000\u0000\u0000\u00cb\u0017\u0001\u0000\u0000"+
		"\u0000\u00cc\u00cd\u0007\u0006\u0000\u0000\u00cd\u0019\u0001\u0000\u0000"+
		"\u0000\u00ce\u00cf\u0003 \u0010\u0000\u00cf\u00d0\u0005\u0002\u0000\u0000"+
		"\u00d0\u00db\u0001\u0000\u0000\u0000\u00d1\u00d2\u0003\u001c\u000e\u0000"+
		"\u00d2\u00d3\u0005\u0002\u0000\u0000\u00d3\u00db\u0001\u0000\u0000\u0000"+
		"\u00d4\u00d5\u0003\u001e\u000f\u0000\u00d5\u00d6\u0005\u0002\u0000\u0000"+
		"\u00d6\u00db\u0001\u0000\u0000\u0000\u00d7\u00d8\u0003\"\u0011\u0000\u00d8"+
		"\u00d9\u0005\u0002\u0000\u0000\u00d9\u00db\u0001\u0000\u0000\u0000\u00da"+
		"\u00ce\u0001\u0000\u0000\u0000\u00da\u00d1\u0001\u0000\u0000\u0000\u00da"+
		"\u00d4\u0001\u0000\u0000\u0000\u00da\u00d7\u0001\u0000\u0000\u0000\u00db"+
		"\u001b\u0001\u0000\u0000\u0000\u00dc\u00dd\u0007\u0007\u0000\u0000\u00dd"+
		"\u00de\u0005\u001e\u0000\u0000\u00de\u00df\u0003\n\u0005\u0000\u00df\u001d"+
		"\u0001\u0000\u0000\u0000\u00e0\u00e1\u0007\b\u0000\u0000\u00e1\u00e2\u0005"+
		"\u001e\u0000\u0000\u00e2\u00e3\u0003<\u001e\u0000\u00e3\u001f\u0001\u0000"+
		"\u0000\u0000\u00e4\u00e5\u00057\u0000\u0000\u00e5\u00e6\u0005\u001e\u0000"+
		"\u0000\u00e6\u00e7\u0003\n\u0005\u0000\u00e7!\u0001\u0000\u0000\u0000"+
		"\u00e8\u00e9\u00058\u0000\u0000\u00e9\u00ea\u0005\u001e\u0000\u0000\u00ea"+
		"\u00eb\u0003\n\u0005\u0000\u00eb#\u0001\u0000\u0000\u0000\u00ec\u00ef"+
		"\u0003*\u0015\u0000\u00ed\u00ef\u0003&\u0013\u0000\u00ee\u00ec\u0001\u0000"+
		"\u0000\u0000\u00ee\u00ed\u0001\u0000\u0000\u0000\u00ef%\u0001\u0000\u0000"+
		"\u0000\u00f0\u00f3\u00059\u0000\u0000\u00f1\u00f4\u0005N\u0000\u0000\u00f2"+
		"\u00f4\u0003,\u0016\u0000\u00f3\u00f1\u0001\u0000\u0000\u0000\u00f3\u00f2"+
		"\u0001\u0000\u0000\u0000\u00f4\u00f5\u0001\u0000\u0000\u0000\u00f5\u00f6"+
		"\u0005\u0002\u0000\u0000\u00f6\'\u0001\u0000\u0000\u0000\u00f7\u00f8\u0005"+
		":\u0000\u0000\u00f8\u00f9\u0005N\u0000\u0000\u00f9\u00fa\u0005;\u0000"+
		"\u0000\u00fa\u00fb\u0003\n\u0005\u0000\u00fb\u00fc\u0005\u0002\u0000\u0000"+
		"\u00fc\u010a\u0001\u0000\u0000\u0000\u00fd\u00fe\u0005:\u0000\u0000\u00fe"+
		"\u00ff\u0003,\u0016\u0000\u00ff\u0100\u0005;\u0000\u0000\u0100\u0101\u0003"+
		"\n\u0005\u0000\u0101\u0102\u0005\u0002\u0000\u0000\u0102\u010a\u0001\u0000"+
		"\u0000\u0000\u0103\u0104\u0005:\u0000\u0000\u0104\u0105\u0003\u0018\f"+
		"\u0000\u0105\u0106\u0005;\u0000\u0000\u0106\u0107\u0003\n\u0005\u0000"+
		"\u0107\u0108\u0005\u0002\u0000\u0000\u0108\u010a\u0001\u0000\u0000\u0000"+
		"\u0109\u00f7\u0001\u0000\u0000\u0000\u0109\u00fd\u0001\u0000\u0000\u0000"+
		"\u0109\u0103\u0001\u0000\u0000\u0000\u010a)\u0001\u0000\u0000\u0000\u010b"+
		"\u010e\u0005<\u0000\u0000\u010c\u010f\u0005N\u0000\u0000\u010d\u010f\u0003"+
		",\u0016\u0000\u010e\u010c\u0001\u0000\u0000\u0000\u010e\u010d\u0001\u0000"+
		"\u0000\u0000\u010f\u0110\u0001\u0000\u0000\u0000\u0110\u0111\u0005=\u0000"+
		"\u0000\u0111\u0112\u0003\n\u0005\u0000\u0112\u0113\u0005\u0002\u0000\u0000"+
		"\u0113\u011b\u0001\u0000\u0000\u0000\u0114\u0117\u0005<\u0000\u0000\u0115"+
		"\u0118\u0005N\u0000\u0000\u0116\u0118\u0003,\u0016\u0000\u0117\u0115\u0001"+
		"\u0000\u0000\u0000\u0117\u0116\u0001\u0000\u0000\u0000\u0118\u0119\u0001"+
		"\u0000\u0000\u0000\u0119\u011b\u0005\u0002\u0000\u0000\u011a\u010b\u0001"+
		"\u0000\u0000\u0000\u011a\u0114\u0001\u0000\u0000\u0000\u011b+\u0001\u0000"+
		"\u0000\u0000\u011c\u011d\u0005N\u0000\u0000\u011d\u011e\u0005\u001f\u0000"+
		"\u0000\u011e\u011f\u0005>\u0000\u0000\u011f\u0125\u00030\u0018\u0000\u0120"+
		"\u0121\u0005N\u0000\u0000\u0121\u0122\u0005\u001f\u0000\u0000\u0122\u0123"+
		"\u0005>\u0000\u0000\u0123\u0125\u0005\u0002\u0000\u0000\u0124\u011c\u0001"+
		"\u0000\u0000\u0000\u0124\u0120\u0001\u0000\u0000\u0000\u0125-\u0001\u0000"+
		"\u0000\u0000\u0126\u0127\u0005?\u0000\u0000\u0127\u0128\u0005N\u0000\u0000"+
		"\u0128\u0129\u0005\u0006\u0000\u0000\u0129\u012d\u0005\u0007\u0000\u0000"+
		"\u012a\u012c\u0003\u001a\r\u0000\u012b\u012a\u0001\u0000\u0000\u0000\u012c"+
		"\u012f\u0001\u0000\u0000\u0000\u012d\u012b\u0001\u0000\u0000\u0000\u012d"+
		"\u012e\u0001\u0000\u0000\u0000\u012e\u0130\u0001\u0000\u0000\u0000\u012f"+
		"\u012d\u0001\u0000\u0000\u0000\u0130\u013d\u0005\b\u0000\u0000\u0131\u0132"+
		"\u0005?\u0000\u0000\u0132\u0133\u0005N\u0000\u0000\u0133\u0134\u0005\u0006"+
		"\u0000\u0000\u0134\u0138\u0005\u0007\u0000\u0000\u0135\u0137\u00032\u0019"+
		"\u0000\u0136\u0135\u0001\u0000\u0000\u0000\u0137\u013a\u0001\u0000\u0000"+
		"\u0000\u0138\u0136\u0001\u0000\u0000\u0000\u0138\u0139\u0001\u0000\u0000"+
		"\u0000\u0139\u013b\u0001\u0000\u0000\u0000\u013a\u0138\u0001\u0000\u0000"+
		"\u0000\u013b\u013d\u0005\b\u0000\u0000\u013c\u0126\u0001\u0000\u0000\u0000"+
		"\u013c\u0131\u0001\u0000\u0000\u0000\u013d/\u0001\u0000\u0000\u0000\u013e"+
		"\u013f\u0005?\u0000\u0000\u013f\u0143\u0005\u0007\u0000\u0000\u0140\u0142"+
		"\u0003\u001a\r\u0000\u0141\u0140\u0001\u0000\u0000\u0000\u0142\u0145\u0001"+
		"\u0000\u0000\u0000\u0143\u0141\u0001\u0000\u0000\u0000\u0143\u0144\u0001"+
		"\u0000\u0000\u0000\u0144\u0146\u0001\u0000\u0000\u0000\u0145\u0143\u0001"+
		"\u0000\u0000\u0000\u0146\u0151\u0005\b\u0000\u0000\u0147\u0148\u0005?"+
		"\u0000\u0000\u0148\u014c\u0005\u0007\u0000\u0000\u0149\u014b\u00032\u0019"+
		"\u0000\u014a\u0149\u0001\u0000\u0000\u0000\u014b\u014e\u0001\u0000\u0000"+
		"\u0000\u014c\u014a\u0001\u0000\u0000\u0000\u014c\u014d\u0001\u0000\u0000"+
		"\u0000\u014d\u014f\u0001\u0000\u0000\u0000\u014e\u014c\u0001\u0000\u0000"+
		"\u0000\u014f\u0151\u0005\b\u0000\u0000\u0150\u013e\u0001\u0000\u0000\u0000"+
		"\u0150\u0147\u0001\u0000\u0000\u0000\u01511\u0001\u0000\u0000\u0000\u0152"+
		"\u0153\u00036\u001b\u0000\u0153\u0154\u0005\u0002\u0000\u0000\u0154\u015f"+
		"\u0001\u0000\u0000\u0000\u0155\u0156\u00034\u001a\u0000\u0156\u0157\u0005"+
		"\u0002\u0000\u0000\u0157\u015f\u0001\u0000\u0000\u0000\u0158\u0159\u0003"+
		"8\u001c\u0000\u0159\u015a\u0005\u0002\u0000\u0000\u015a\u015f\u0001\u0000"+
		"\u0000\u0000\u015b\u015c\u0003:\u001d\u0000\u015c\u015d\u0005\u0002\u0000"+
		"\u0000\u015d\u015f\u0001\u0000\u0000\u0000\u015e\u0152\u0001\u0000\u0000"+
		"\u0000\u015e\u0155\u0001\u0000\u0000\u0000\u015e\u0158\u0001\u0000\u0000"+
		"\u0000\u015e\u015b\u0001\u0000\u0000\u0000\u015f3\u0001\u0000\u0000\u0000"+
		"\u0160\u0161\u0005@\u0000\u0000\u0161\u0162\u0005\u001e\u0000\u0000\u0162"+
		"\u0167\u0003\n\u0005\u0000\u0163\u0164\u0005A\u0000\u0000\u0164\u0165"+
		"\u0005\u001e\u0000\u0000\u0165\u0167\u0003\n\u0005\u0000\u0166\u0160\u0001"+
		"\u0000\u0000\u0000\u0166\u0163\u0001\u0000\u0000\u0000\u01675\u0001\u0000"+
		"\u0000\u0000\u0168\u0169\u0005B\u0000\u0000\u0169\u016a\u0005\u001e\u0000"+
		"\u0000\u016a\u016f\u0003\n\u0005\u0000\u016b\u016c\u0005C\u0000\u0000"+
		"\u016c\u016d\u0005\u001e\u0000\u0000\u016d\u016f\u0003\n\u0005\u0000\u016e"+
		"\u0168\u0001\u0000\u0000\u0000\u016e\u016b\u0001\u0000\u0000\u0000\u016f"+
		"7\u0001\u0000\u0000\u0000\u0170\u0171\u0005D\u0000\u0000\u0171\u0172\u0005"+
		"\u001e\u0000\u0000\u0172\u0173\u0003\n\u0005\u0000\u01739\u0001\u0000"+
		"\u0000\u0000\u0174\u0175\u0005E\u0000\u0000\u0175\u0176\u0005\u001e\u0000"+
		"\u0000\u0176\u0177\u0003<\u001e\u0000\u0177;\u0001\u0000\u0000\u0000\u0178"+
		"\u0179\u0003\n\u0005\u0000\u0179=\u0001\u0000\u0000\u0000\u017a\u017b"+
		"\u0005I\u0000\u0000\u017b\u017c\u0007\t\u0000\u0000\u017c?\u0001\u0000"+
		"\u0000\u0000\u017d\u017e\u0005\u000e\u0000\u0000\u017e\u017f\u0003\n\u0005"+
		"\u0000\u017f\u0180\u0005H\u0000\u0000\u0180\u0181\u0003\n\u0005\u0000"+
		"\u0181\u0182\u0005\u000f\u0000\u0000\u0182A\u0001\u0000\u0000\u0000\u0183"+
		"\u0184\u0005\u000e\u0000\u0000\u0184\u0185\u0003\n\u0005\u0000\u0185\u0186"+
		"\u0005\u001f\u0000\u0000\u0186\u0187\u0003\n\u0005\u0000\u0187\u0188\u0005"+
		"\u000f\u0000\u0000\u0188C\u0001\u0000\u0000\u0000\u001cGM`m\u0087\u0095"+
		"\u0097\u00a2\u00ac\u00b3\u00ca\u00da\u00ee\u00f3\u0109\u010e\u0117\u011a"+
		"\u0124\u012d\u0138\u013c\u0143\u014c\u0150\u015e\u0166\u016e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}