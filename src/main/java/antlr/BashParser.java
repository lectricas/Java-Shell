// Generated from /Users/sigmadt/Desktop/mse/SD/fork-bash/Java-Shell/src/main/java/antlr/Bash.g4 by ANTLR 4.10.1
package antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BashParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, SQSTR=5, DQSTR=6, WORD=7;
	public static final int
		RULE_start = 0, RULE_pipeline = 1, RULE_command = 2, RULE_part = 3, RULE_assignment = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "pipeline", "command", "part", "assignment"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "' '", "'|'", "'$'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "SQSTR", "DQSTR", "WORD"
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
	public String getGrammarFileName() { return "Bash.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public BashParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
	 
		public StartContext() { }
		public void copyFrom(StartContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PipeContext extends StartContext {
		public PipelineContext pipeline() {
			return getRuleContext(PipelineContext.class,0);
		}
		public TerminalNode EOF() { return getToken(BashParser.EOF, 0); }
		public PipeContext(StartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BashListener ) ((BashListener)listener).enterPipe(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BashListener ) ((BashListener)listener).exitPipe(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BashVisitor ) return ((BashVisitor<? extends T>)visitor).visitPipe(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignContext extends StartContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public TerminalNode EOF() { return getToken(BashParser.EOF, 0); }
		public AssignContext(StartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BashListener ) ((BashListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BashListener ) ((BashListener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BashVisitor ) return ((BashVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			setState(16);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new PipeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(10);
				pipeline(0);
				setState(11);
				match(EOF);
				}
				break;
			case 2:
				_localctx = new AssignContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(13);
				assignment();
				setState(14);
				match(EOF);
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

	public static class PipelineContext extends ParserRuleContext {
		public PipelineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pipeline; }
	 
		public PipelineContext() { }
		public void copyFrom(PipelineContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MultipleCommandsContext extends PipelineContext {
		public PipelineContext left;
		public CommandContext right;
		public PipelineContext pipeline() {
			return getRuleContext(PipelineContext.class,0);
		}
		public CommandContext command() {
			return getRuleContext(CommandContext.class,0);
		}
		public MultipleCommandsContext(PipelineContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BashListener ) ((BashListener)listener).enterMultipleCommands(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BashListener ) ((BashListener)listener).exitMultipleCommands(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BashVisitor ) return ((BashVisitor<? extends T>)visitor).visitMultipleCommands(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SingleCommandContext extends PipelineContext {
		public CommandContext command() {
			return getRuleContext(CommandContext.class,0);
		}
		public SingleCommandContext(PipelineContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BashListener ) ((BashListener)listener).enterSingleCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BashListener ) ((BashListener)listener).exitSingleCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BashVisitor ) return ((BashVisitor<? extends T>)visitor).visitSingleCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PipelineContext pipeline() throws RecognitionException {
		return pipeline(0);
	}

	private PipelineContext pipeline(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PipelineContext _localctx = new PipelineContext(_ctx, _parentState);
		PipelineContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_pipeline, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new SingleCommandContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(19);
			command();
			}
			_ctx.stop = _input.LT(-1);
			setState(38);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MultipleCommandsContext(new PipelineContext(_parentctx, _parentState));
					((MultipleCommandsContext)_localctx).left = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_pipeline);
					setState(21);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					{
					setState(25);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(22);
						match(T__0);
						}
						}
						setState(27);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					setState(28);
					match(T__1);
					{
					setState(32);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(29);
						match(T__0);
						}
						}
						setState(34);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					setState(35);
					((MultipleCommandsContext)_localctx).right = command();
					}
					} 
				}
				setState(40);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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

	public static class CommandContext extends ParserRuleContext {
		public List<PartContext> part() {
			return getRuleContexts(PartContext.class);
		}
		public PartContext part(int i) {
			return getRuleContext(PartContext.class,i);
		}
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BashListener ) ((BashListener)listener).enterCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BashListener ) ((BashListener)listener).exitCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BashVisitor ) return ((BashVisitor<? extends T>)visitor).visitCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_command);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(48); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(41);
					part();
					{
					setState(45);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(42);
							match(T__0);
							}
							} 
						}
						setState(47);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
					}
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(50); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class PartContext extends ParserRuleContext {
		public PartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_part; }
	 
		public PartContext() { }
		public void copyFrom(PartContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DqstrContext extends PartContext {
		public TerminalNode DQSTR() { return getToken(BashParser.DQSTR, 0); }
		public DqstrContext(PartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BashListener ) ((BashListener)listener).enterDqstr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BashListener ) ((BashListener)listener).exitDqstr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BashVisitor ) return ((BashVisitor<? extends T>)visitor).visitDqstr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PartWordContext extends PartContext {
		public TerminalNode WORD() { return getToken(BashParser.WORD, 0); }
		public PartWordContext(PartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BashListener ) ((BashListener)listener).enterPartWord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BashListener ) ((BashListener)listener).exitPartWord(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BashVisitor ) return ((BashVisitor<? extends T>)visitor).visitPartWord(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SqstrContext extends PartContext {
		public TerminalNode SQSTR() { return getToken(BashParser.SQSTR, 0); }
		public SqstrContext(PartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BashListener ) ((BashListener)listener).enterSqstr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BashListener ) ((BashListener)listener).exitSqstr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BashVisitor ) return ((BashVisitor<? extends T>)visitor).visitSqstr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PartVariableContext extends PartContext {
		public TerminalNode WORD() { return getToken(BashParser.WORD, 0); }
		public PartVariableContext(PartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BashListener ) ((BashListener)listener).enterPartVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BashListener ) ((BashListener)listener).exitPartVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BashVisitor ) return ((BashVisitor<? extends T>)visitor).visitPartVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PartContext part() throws RecognitionException {
		PartContext _localctx = new PartContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_part);
		try {
			setState(57);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WORD:
				_localctx = new PartWordContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(52);
				match(WORD);
				}
				break;
			case SQSTR:
				_localctx = new SqstrContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(53);
				match(SQSTR);
				}
				break;
			case DQSTR:
				_localctx = new DqstrContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(54);
				match(DQSTR);
				}
				break;
			case T__2:
				_localctx = new PartVariableContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(55);
				match(T__2);
				setState(56);
				match(WORD);
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

	public static class AssignmentContext extends ParserRuleContext {
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
	 
		public AssignmentContext() { }
		public void copyFrom(AssignmentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class WordAssignmentContext extends AssignmentContext {
		public Token name;
		public Token value;
		public List<TerminalNode> WORD() { return getTokens(BashParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(BashParser.WORD, i);
		}
		public WordAssignmentContext(AssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BashListener ) ((BashListener)listener).enterWordAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BashListener ) ((BashListener)listener).exitWordAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BashVisitor ) return ((BashVisitor<? extends T>)visitor).visitWordAssignment(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VariableAssignmentContext extends AssignmentContext {
		public Token name;
		public Token value;
		public List<TerminalNode> WORD() { return getTokens(BashParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(BashParser.WORD, i);
		}
		public VariableAssignmentContext(AssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BashListener ) ((BashListener)listener).enterVariableAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BashListener ) ((BashListener)listener).exitVariableAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BashVisitor ) return ((BashVisitor<? extends T>)visitor).visitVariableAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_assignment);
		try {
			setState(66);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new WordAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(59);
				((WordAssignmentContext)_localctx).name = match(WORD);
				setState(60);
				match(T__3);
				setState(61);
				((WordAssignmentContext)_localctx).value = match(WORD);
				}
				break;
			case 2:
				_localctx = new VariableAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(62);
				((VariableAssignmentContext)_localctx).name = match(WORD);
				setState(63);
				match(T__3);
				setState(64);
				match(T__2);
				setState(65);
				((VariableAssignmentContext)_localctx).value = match(WORD);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return pipeline_sempred((PipelineContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean pipeline_sempred(PipelineContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0007E\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0003"+
		"\u0000\u0011\b\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0005\u0001\u0018\b\u0001\n\u0001\f\u0001\u001b\t\u0001\u0001\u0001"+
		"\u0001\u0001\u0005\u0001\u001f\b\u0001\n\u0001\f\u0001\"\t\u0001\u0001"+
		"\u0001\u0005\u0001%\b\u0001\n\u0001\f\u0001(\t\u0001\u0001\u0002\u0001"+
		"\u0002\u0005\u0002,\b\u0002\n\u0002\f\u0002/\t\u0002\u0004\u00021\b\u0002"+
		"\u000b\u0002\f\u00022\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0003\u0003:\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004C\b\u0004"+
		"\u0001\u0004\u0000\u0001\u0002\u0005\u0000\u0002\u0004\u0006\b\u0000\u0000"+
		"I\u0000\u0010\u0001\u0000\u0000\u0000\u0002\u0012\u0001\u0000\u0000\u0000"+
		"\u00040\u0001\u0000\u0000\u0000\u00069\u0001\u0000\u0000\u0000\bB\u0001"+
		"\u0000\u0000\u0000\n\u000b\u0003\u0002\u0001\u0000\u000b\f\u0005\u0000"+
		"\u0000\u0001\f\u0011\u0001\u0000\u0000\u0000\r\u000e\u0003\b\u0004\u0000"+
		"\u000e\u000f\u0005\u0000\u0000\u0001\u000f\u0011\u0001\u0000\u0000\u0000"+
		"\u0010\n\u0001\u0000\u0000\u0000\u0010\r\u0001\u0000\u0000\u0000\u0011"+
		"\u0001\u0001\u0000\u0000\u0000\u0012\u0013\u0006\u0001\uffff\uffff\u0000"+
		"\u0013\u0014\u0003\u0004\u0002\u0000\u0014&\u0001\u0000\u0000\u0000\u0015"+
		"\u0019\n\u0001\u0000\u0000\u0016\u0018\u0005\u0001\u0000\u0000\u0017\u0016"+
		"\u0001\u0000\u0000\u0000\u0018\u001b\u0001\u0000\u0000\u0000\u0019\u0017"+
		"\u0001\u0000\u0000\u0000\u0019\u001a\u0001\u0000\u0000\u0000\u001a\u001c"+
		"\u0001\u0000\u0000\u0000\u001b\u0019\u0001\u0000\u0000\u0000\u001c \u0005"+
		"\u0002\u0000\u0000\u001d\u001f\u0005\u0001\u0000\u0000\u001e\u001d\u0001"+
		"\u0000\u0000\u0000\u001f\"\u0001\u0000\u0000\u0000 \u001e\u0001\u0000"+
		"\u0000\u0000 !\u0001\u0000\u0000\u0000!#\u0001\u0000\u0000\u0000\" \u0001"+
		"\u0000\u0000\u0000#%\u0003\u0004\u0002\u0000$\u0015\u0001\u0000\u0000"+
		"\u0000%(\u0001\u0000\u0000\u0000&$\u0001\u0000\u0000\u0000&\'\u0001\u0000"+
		"\u0000\u0000\'\u0003\u0001\u0000\u0000\u0000(&\u0001\u0000\u0000\u0000"+
		")-\u0003\u0006\u0003\u0000*,\u0005\u0001\u0000\u0000+*\u0001\u0000\u0000"+
		"\u0000,/\u0001\u0000\u0000\u0000-+\u0001\u0000\u0000\u0000-.\u0001\u0000"+
		"\u0000\u0000.1\u0001\u0000\u0000\u0000/-\u0001\u0000\u0000\u00000)\u0001"+
		"\u0000\u0000\u000012\u0001\u0000\u0000\u000020\u0001\u0000\u0000\u0000"+
		"23\u0001\u0000\u0000\u00003\u0005\u0001\u0000\u0000\u00004:\u0005\u0007"+
		"\u0000\u00005:\u0005\u0005\u0000\u00006:\u0005\u0006\u0000\u000078\u0005"+
		"\u0003\u0000\u00008:\u0005\u0007\u0000\u000094\u0001\u0000\u0000\u0000"+
		"95\u0001\u0000\u0000\u000096\u0001\u0000\u0000\u000097\u0001\u0000\u0000"+
		"\u0000:\u0007\u0001\u0000\u0000\u0000;<\u0005\u0007\u0000\u0000<=\u0005"+
		"\u0004\u0000\u0000=C\u0005\u0007\u0000\u0000>?\u0005\u0007\u0000\u0000"+
		"?@\u0005\u0004\u0000\u0000@A\u0005\u0003\u0000\u0000AC\u0005\u0007\u0000"+
		"\u0000B;\u0001\u0000\u0000\u0000B>\u0001\u0000\u0000\u0000C\t\u0001\u0000"+
		"\u0000\u0000\b\u0010\u0019 &-29B";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}