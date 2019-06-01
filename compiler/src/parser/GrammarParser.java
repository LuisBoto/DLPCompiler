// Generated from src\parser\Grammar.g4 by ANTLR 4.7.1
package parser;

    import ast.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		INT_CONSTANT=39, REAL_CONSTANT=40, CHAR_CONSTANT=41, IDENT=42, LINE_COMMENT=43, 
		MULTILINE_COMMENT=44, WHITESPACE=45;
	public static final int
		RULE_start = 0, RULE_bloques = 1, RULE_estructura = 2, RULE_variableDefinicion = 3, 
		RULE_funcion = 4, RULE_variables = 5, RULE_sentencia = 6, RULE_sentencias = 7, 
		RULE_expr = 8, RULE_arrays = 9, RULE_whileloop = 10, RULE_ifblock = 11, 
		RULE_llamada = 12, RULE_expresionesSeparadas = 13, RULE_parametros = 14, 
		RULE_parametro = 15, RULE_atributos = 16, RULE_atributo = 17, RULE_tipo = 18;
	public static final String[] ruleNames = {
		"start", "bloques", "estructura", "variableDefinicion", "funcion", "variables", 
		"sentencia", "sentencias", "expr", "arrays", "whileloop", "ifblock", "llamada", 
		"expresionesSeparadas", "parametros", "parametro", "atributos", "atributo", 
		"tipo"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'struct'", "'{'", "'}'", "';'", "'var'", "':'", "'('", "')'", "'read'", 
		"'printsp'", "'print'", "'println'", "'='", "'return'", "'.'", "'cast'", 
		"'<'", "'>'", "'*'", "'/'", "'+'", "'-'", "'=='", "'!='", "'>='", "'<='", 
		"'!'", "'&&'", "'||'", "'['", "']'", "'while'", "'if'", "'else'", "','", 
		"'int'", "'float'", "'char'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, "INT_CONSTANT", "REAL_CONSTANT", "CHAR_CONSTANT", "IDENT", 
		"LINE_COMMENT", "MULTILINE_COMMENT", "WHITESPACE"
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
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public Program ast;
		public BloquesContext bloques;
		public BloquesContext bloques() {
			return getRuleContext(BloquesContext.class,0);
		}
		public TerminalNode EOF() { return getToken(GrammarParser.EOF, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			((StartContext)_localctx).bloques = bloques();
			setState(39);
			match(EOF);
			 ((StartContext)_localctx).ast =  new Program(((StartContext)_localctx).bloques.list); 
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

	public static class BloquesContext extends ParserRuleContext {
		public List<Bloque> list = new ArrayList<Bloque>();
		public VariableDefinicionContext variableDefinicion;
		public EstructuraContext estructura;
		public FuncionContext funcion;
		public List<VariableDefinicionContext> variableDefinicion() {
			return getRuleContexts(VariableDefinicionContext.class);
		}
		public VariableDefinicionContext variableDefinicion(int i) {
			return getRuleContext(VariableDefinicionContext.class,i);
		}
		public List<EstructuraContext> estructura() {
			return getRuleContexts(EstructuraContext.class);
		}
		public EstructuraContext estructura(int i) {
			return getRuleContext(EstructuraContext.class,i);
		}
		public List<FuncionContext> funcion() {
			return getRuleContexts(FuncionContext.class);
		}
		public FuncionContext funcion(int i) {
			return getRuleContext(FuncionContext.class,i);
		}
		public BloquesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloques; }
	}

	public final BloquesContext bloques() throws RecognitionException {
		BloquesContext _localctx = new BloquesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_bloques);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__4) | (1L << IDENT))) != 0)) {
				{
				setState(51);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__4:
					{
					setState(42);
					((BloquesContext)_localctx).variableDefinicion = variableDefinicion();
					 _localctx.list.add(((BloquesContext)_localctx).variableDefinicion.ast); 
					}
					break;
				case T__0:
					{
					setState(45);
					((BloquesContext)_localctx).estructura = estructura();
					 _localctx.list.add(((BloquesContext)_localctx).estructura.ast); 
					}
					break;
				case IDENT:
					{
					setState(48);
					((BloquesContext)_localctx).funcion = funcion();
					 _localctx.list.add(((BloquesContext)_localctx).funcion.ast); 
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(55);
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

	public static class EstructuraContext extends ParserRuleContext {
		public EstructuraDef ast;
		public Token IDENT;
		public AtributosContext atributos;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public AtributosContext atributos() {
			return getRuleContext(AtributosContext.class,0);
		}
		public EstructuraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_estructura; }
	}

	public final EstructuraContext estructura() throws RecognitionException {
		EstructuraContext _localctx = new EstructuraContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_estructura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(T__0);
			setState(57);
			((EstructuraContext)_localctx).IDENT = match(IDENT);
			setState(58);
			match(T__1);
			setState(59);
			((EstructuraContext)_localctx).atributos = atributos();
			setState(60);
			match(T__2);
			setState(61);
			match(T__3);
			 ((EstructuraContext)_localctx).ast =  new EstructuraDef(((EstructuraContext)_localctx).IDENT, ((EstructuraContext)_localctx).atributos.list); 
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

	public static class VariableDefinicionContext extends ParserRuleContext {
		public VarDef ast;
		public Token IDENT;
		public TipoContext tipo;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public VariableDefinicionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDefinicion; }
	}

	public final VariableDefinicionContext variableDefinicion() throws RecognitionException {
		VariableDefinicionContext _localctx = new VariableDefinicionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_variableDefinicion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(T__4);
			setState(65);
			((VariableDefinicionContext)_localctx).IDENT = match(IDENT);
			setState(66);
			match(T__5);
			setState(67);
			((VariableDefinicionContext)_localctx).tipo = tipo();
			setState(68);
			match(T__3);
			 ((VariableDefinicionContext)_localctx).ast =  new VarDef(((VariableDefinicionContext)_localctx).IDENT, ((VariableDefinicionContext)_localctx).tipo.ast); 
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

	public static class FuncionContext extends ParserRuleContext {
		public FuncionDef ast;
		public Token IDENT;
		public ParametrosContext parametros;
		public TipoContext tipo;
		public VariablesContext variables;
		public SentenciasContext sentencias;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public ParametrosContext parametros() {
			return getRuleContext(ParametrosContext.class,0);
		}
		public VariablesContext variables() {
			return getRuleContext(VariablesContext.class,0);
		}
		public SentenciasContext sentencias() {
			return getRuleContext(SentenciasContext.class,0);
		}
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public FuncionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcion; }
	}

	public final FuncionContext funcion() throws RecognitionException {
		FuncionContext _localctx = new FuncionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_funcion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			((FuncionContext)_localctx).IDENT = match(IDENT);
			setState(72);
			match(T__6);
			setState(73);
			((FuncionContext)_localctx).parametros = parametros();
			setState(74);
			match(T__7);
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(75);
				match(T__5);
				setState(76);
				((FuncionContext)_localctx).tipo = tipo();
				}
			}

			setState(79);
			match(T__1);
			setState(80);
			((FuncionContext)_localctx).variables = variables();
			setState(81);
			((FuncionContext)_localctx).sentencias = sentencias();
			setState(82);
			match(T__2);
			 
						if (((FuncionContext)_localctx).tipo==null) ((FuncionContext)_localctx).ast =  new FuncionDef(((FuncionContext)_localctx).IDENT, ((FuncionContext)_localctx).parametros.list, null, ((FuncionContext)_localctx).variables.list, ((FuncionContext)_localctx).sentencias.list);
						else ((FuncionContext)_localctx).ast =  new FuncionDef(((FuncionContext)_localctx).IDENT, ((FuncionContext)_localctx).parametros.list, ((FuncionContext)_localctx).tipo.ast, ((FuncionContext)_localctx).variables.list, ((FuncionContext)_localctx).sentencias.list);
					
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

	public static class VariablesContext extends ParserRuleContext {
		public List<VarDef> list = new ArrayList<VarDef>();
		public VariableDefinicionContext variableDefinicion;
		public List<VariableDefinicionContext> variableDefinicion() {
			return getRuleContexts(VariableDefinicionContext.class);
		}
		public VariableDefinicionContext variableDefinicion(int i) {
			return getRuleContext(VariableDefinicionContext.class,i);
		}
		public VariablesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variables; }
	}

	public final VariablesContext variables() throws RecognitionException {
		VariablesContext _localctx = new VariablesContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_variables);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(85);
				((VariablesContext)_localctx).variableDefinicion = variableDefinicion();
				 _localctx.list.add(((VariablesContext)_localctx).variableDefinicion.ast); 
				}
				}
				setState(92);
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

	public static class SentenciaContext extends ParserRuleContext {
		public Sentencia ast;
		public ExprContext expr;
		public Token o;
		public ExprContext left;
		public ExprContext right;
		public LlamadaContext llamada;
		public WhileloopContext whileloop;
		public IfblockContext ifblock;
		public Token r;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public LlamadaContext llamada() {
			return getRuleContext(LlamadaContext.class,0);
		}
		public WhileloopContext whileloop() {
			return getRuleContext(WhileloopContext.class,0);
		}
		public IfblockContext ifblock() {
			return getRuleContext(IfblockContext.class,0);
		}
		public SentenciaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencia; }
	}

	public final SentenciaContext sentencia() throws RecognitionException {
		SentenciaContext _localctx = new SentenciaContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_sentencia);
		int _la;
		try {
			setState(125);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(93);
				match(T__8);
				setState(94);
				((SentenciaContext)_localctx).expr = expr(0);
				setState(95);
				match(T__3);
				 ((SentenciaContext)_localctx).ast =  new Read(((SentenciaContext)_localctx).expr.ast); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(98);
				((SentenciaContext)_localctx).o = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__10) | (1L << T__11))) != 0)) ) {
					((SentenciaContext)_localctx).o = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(99);
				((SentenciaContext)_localctx).expr = expr(0);
				setState(100);
				match(T__3);
				 ((SentenciaContext)_localctx).ast =  new Print((((SentenciaContext)_localctx).o!=null?((SentenciaContext)_localctx).o.getText():null), ((SentenciaContext)_localctx).expr.ast); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(103);
				((SentenciaContext)_localctx).left = expr(0);
				setState(104);
				match(T__12);
				setState(105);
				((SentenciaContext)_localctx).right = expr(0);
				setState(106);
				match(T__3);
				 ((SentenciaContext)_localctx).ast =  new Assign(((SentenciaContext)_localctx).left.ast, ((SentenciaContext)_localctx).right.ast); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(109);
				((SentenciaContext)_localctx).llamada = llamada();
				setState(110);
				match(T__3);
				 ((SentenciaContext)_localctx).ast =   new LlamadaS(((SentenciaContext)_localctx).llamada.ast); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(113);
				((SentenciaContext)_localctx).whileloop = whileloop();
				 ((SentenciaContext)_localctx).ast =  ((SentenciaContext)_localctx).whileloop.ast; 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(116);
				((SentenciaContext)_localctx).ifblock = ifblock();
				 ((SentenciaContext)_localctx).ast =   ((SentenciaContext)_localctx).ifblock.ast; 
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(119);
				((SentenciaContext)_localctx).r = match(T__13);
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__15) | (1L << T__26) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << IDENT))) != 0)) {
					{
					setState(120);
					((SentenciaContext)_localctx).expr = expr(0);
					}
				}

				setState(123);
				match(T__3);
				 
							if (((SentenciaContext)_localctx).expr == null) ((SentenciaContext)_localctx).ast =  new ReturnSent(null); 
							else ((SentenciaContext)_localctx).ast =  new ReturnSent(((SentenciaContext)_localctx).expr.ast); 
							_localctx.ast.setPositions(((SentenciaContext)_localctx).r);
						
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

	public static class SentenciasContext extends ParserRuleContext {
		public List<Sentencia> list = new ArrayList<Sentencia>();
		public SentenciaContext sentencia;
		public List<SentenciaContext> sentencia() {
			return getRuleContexts(SentenciaContext.class);
		}
		public SentenciaContext sentencia(int i) {
			return getRuleContext(SentenciaContext.class,i);
		}
		public SentenciasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencias; }
	}

	public final SentenciasContext sentencias() throws RecognitionException {
		SentenciasContext _localctx = new SentenciasContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_sentencias);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__13) | (1L << T__15) | (1L << T__26) | (1L << T__31) | (1L << T__32) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << IDENT))) != 0)) {
				{
				{
				setState(127);
				((SentenciasContext)_localctx).sentencia = sentencia();
				 _localctx.list.add(((SentenciasContext)_localctx).sentencia.ast); 
				}
				}
				setState(134);
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

	public static class ExprContext extends ParserRuleContext {
		public Expresion ast;
		public ExprContext v;
		public ExprContext left;
		public Token INT_CONSTANT;
		public Token REAL_CONSTANT;
		public Token CHAR_CONSTANT;
		public Token IDENT;
		public ExprContext expr;
		public TipoContext tipo;
		public Token op;
		public ExprContext right;
		public LlamadaContext llamada;
		public ArraysContext arrays;
		public TerminalNode INT_CONSTANT() { return getToken(GrammarParser.INT_CONSTANT, 0); }
		public TerminalNode REAL_CONSTANT() { return getToken(GrammarParser.REAL_CONSTANT, 0); }
		public TerminalNode CHAR_CONSTANT() { return getToken(GrammarParser.CHAR_CONSTANT, 0); }
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public LlamadaContext llamada() {
			return getRuleContext(LlamadaContext.class,0);
		}
		public ArraysContext arrays() {
			return getRuleContext(ArraysContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(136);
				((ExprContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				 ((ExprContext)_localctx).ast =  new Integral(((ExprContext)_localctx).INT_CONSTANT); 
				}
				break;
			case 2:
				{
				setState(138);
				((ExprContext)_localctx).REAL_CONSTANT = match(REAL_CONSTANT);
				 ((ExprContext)_localctx).ast =  new Real(((ExprContext)_localctx).REAL_CONSTANT); 
				}
				break;
			case 3:
				{
				setState(140);
				((ExprContext)_localctx).CHAR_CONSTANT = match(CHAR_CONSTANT);
				 ((ExprContext)_localctx).ast =  new Caracter(((ExprContext)_localctx).CHAR_CONSTANT); 
				}
				break;
			case 4:
				{
				setState(142);
				((ExprContext)_localctx).IDENT = match(IDENT);
				 ((ExprContext)_localctx).ast =  new Variable(((ExprContext)_localctx).IDENT); 
				}
				break;
			case 5:
				{
				setState(144);
				match(T__6);
				setState(145);
				((ExprContext)_localctx).expr = expr(0);
				setState(146);
				match(T__7);
				 ((ExprContext)_localctx).ast =  new Parentesis(((ExprContext)_localctx).expr.ast); 
				}
				break;
			case 6:
				{
				setState(149);
				match(T__15);
				setState(150);
				match(T__16);
				setState(151);
				((ExprContext)_localctx).tipo = tipo();
				setState(152);
				match(T__17);
				setState(153);
				match(T__6);
				setState(154);
				((ExprContext)_localctx).expr = expr(0);
				setState(155);
				match(T__7);
				 ((ExprContext)_localctx).ast =  new Casting(((ExprContext)_localctx).tipo.ast, ((ExprContext)_localctx).expr.ast); 
				}
				break;
			case 7:
				{
				setState(158);
				((ExprContext)_localctx).op = match(T__26);
				setState(159);
				((ExprContext)_localctx).right = ((ExprContext)_localctx).expr = expr(4);
				 ((ExprContext)_localctx).ast =  new Logica(((ExprContext)_localctx).right.ast, ((ExprContext)_localctx).op, ((ExprContext)_localctx).right.ast); 
				}
				break;
			case 8:
				{
				setState(162);
				((ExprContext)_localctx).llamada = llamada();
				 ((ExprContext)_localctx).ast =  new LlamadaE(((ExprContext)_localctx).llamada.ast); 
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(202);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(200);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(167);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(168);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__18 || _la==T__19) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(169);
						((ExprContext)_localctx).right = ((ExprContext)_localctx).expr = expr(8);
						 ((ExprContext)_localctx).ast =  new Aritmetica(((ExprContext)_localctx).left.ast, ((ExprContext)_localctx).op, ((ExprContext)_localctx).right.ast); 
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(172);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(173);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__20 || _la==T__21) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(174);
						((ExprContext)_localctx).right = ((ExprContext)_localctx).expr = expr(7);
						 ((ExprContext)_localctx).ast =  new Aritmetica(((ExprContext)_localctx).left.ast, ((ExprContext)_localctx).op, ((ExprContext)_localctx).right.ast); 
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(177);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(178);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__16) | (1L << T__17) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25))) != 0)) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(179);
						((ExprContext)_localctx).right = ((ExprContext)_localctx).expr = expr(6);
						 ((ExprContext)_localctx).ast =  new Comparativa(((ExprContext)_localctx).left.ast, ((ExprContext)_localctx).op, ((ExprContext)_localctx).right.ast); 
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(182);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(183);
						((ExprContext)_localctx).op = match(T__27);
						setState(184);
						((ExprContext)_localctx).right = ((ExprContext)_localctx).expr = expr(4);
						 ((ExprContext)_localctx).ast =  new Logica(((ExprContext)_localctx).left.ast, ((ExprContext)_localctx).op, ((ExprContext)_localctx).right.ast); 
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(187);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(188);
						((ExprContext)_localctx).op = match(T__28);
						setState(189);
						((ExprContext)_localctx).right = ((ExprContext)_localctx).expr = expr(3);
						 ((ExprContext)_localctx).ast =  new Logica(((ExprContext)_localctx).left.ast, ((ExprContext)_localctx).op, ((ExprContext)_localctx).right.ast); 
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.v = _prevctx;
						_localctx.v = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(192);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(193);
						((ExprContext)_localctx).arrays = arrays();
						 ((ExprContext)_localctx).ast =  new AccesoArray(((ExprContext)_localctx).v.ast, ((ExprContext)_localctx).arrays.ast); 
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(196);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(197);
						match(T__14);
						setState(198);
						((ExprContext)_localctx).IDENT = match(IDENT);
						 ((ExprContext)_localctx).ast =  new AccesoStruct(((ExprContext)_localctx).left.ast, ((ExprContext)_localctx).IDENT); 
						}
						break;
					}
					} 
				}
				setState(204);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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

	public static class ArraysContext extends ParserRuleContext {
		public Array ast;
		public ExprContext expr;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ArraysContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrays; }
	}

	public final ArraysContext arrays() throws RecognitionException {
		ArraysContext _localctx = new ArraysContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_arrays);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			match(T__29);
			setState(206);
			((ArraysContext)_localctx).expr = expr(0);
			setState(207);
			match(T__30);
			 ((ArraysContext)_localctx).ast =  new Array(((ArraysContext)_localctx).expr.ast); 
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

	public static class WhileloopContext extends ParserRuleContext {
		public Whileloop ast;
		public ExprContext expr;
		public SentenciasContext sentencias;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public SentenciasContext sentencias() {
			return getRuleContext(SentenciasContext.class,0);
		}
		public WhileloopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileloop; }
	}

	public final WhileloopContext whileloop() throws RecognitionException {
		WhileloopContext _localctx = new WhileloopContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_whileloop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			match(T__31);
			setState(211);
			match(T__6);
			setState(212);
			((WhileloopContext)_localctx).expr = expr(0);
			setState(213);
			match(T__7);
			setState(214);
			match(T__1);
			setState(215);
			((WhileloopContext)_localctx).sentencias = sentencias();
			setState(216);
			match(T__2);
			 ((WhileloopContext)_localctx).ast =  new Whileloop(((WhileloopContext)_localctx).expr.ast, ((WhileloopContext)_localctx).sentencias.list); 
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

	public static class IfblockContext extends ParserRuleContext {
		public IfDef ast;
		public ExprContext expr;
		public SentenciasContext casetrue;
		public SentenciasContext casefalse;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<SentenciasContext> sentencias() {
			return getRuleContexts(SentenciasContext.class);
		}
		public SentenciasContext sentencias(int i) {
			return getRuleContext(SentenciasContext.class,i);
		}
		public IfblockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifblock; }
	}

	public final IfblockContext ifblock() throws RecognitionException {
		IfblockContext _localctx = new IfblockContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_ifblock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			match(T__32);
			setState(220);
			match(T__6);
			setState(221);
			((IfblockContext)_localctx).expr = expr(0);
			setState(222);
			match(T__7);
			setState(223);
			match(T__1);
			setState(224);
			((IfblockContext)_localctx).casetrue = sentencias();
			setState(225);
			match(T__2);
			setState(231);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__33) {
				{
				setState(226);
				match(T__33);
				setState(227);
				match(T__1);
				setState(228);
				((IfblockContext)_localctx).casefalse = sentencias();
				setState(229);
				match(T__2);
				}
			}

			 
						if (((IfblockContext)_localctx).casefalse==null) ((IfblockContext)_localctx).ast =  new IfDef(((IfblockContext)_localctx).expr.ast, ((IfblockContext)_localctx).casetrue.list, null); 
						else ((IfblockContext)_localctx).ast =  new IfDef(((IfblockContext)_localctx).expr.ast, ((IfblockContext)_localctx).casetrue.list, ((IfblockContext)_localctx).casefalse.list); 
					
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

	public static class LlamadaContext extends ParserRuleContext {
		public Llamada ast;
		public Token IDENT;
		public ExpresionesSeparadasContext expresionesSeparadas;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public ExpresionesSeparadasContext expresionesSeparadas() {
			return getRuleContext(ExpresionesSeparadasContext.class,0);
		}
		public LlamadaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_llamada; }
	}

	public final LlamadaContext llamada() throws RecognitionException {
		LlamadaContext _localctx = new LlamadaContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_llamada);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			((LlamadaContext)_localctx).IDENT = match(IDENT);
			setState(236);
			match(T__6);
			setState(237);
			((LlamadaContext)_localctx).expresionesSeparadas = expresionesSeparadas();
			setState(238);
			match(T__7);
			 ((LlamadaContext)_localctx).ast =  new Llamada(((LlamadaContext)_localctx).IDENT, ((LlamadaContext)_localctx).expresionesSeparadas.list); 
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

	public static class ExpresionesSeparadasContext extends ParserRuleContext {
		public List<Expresion> list = new ArrayList<Expresion>();
		public ExprContext e1;
		public ExprContext e2;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExpresionesSeparadasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expresionesSeparadas; }
	}

	public final ExpresionesSeparadasContext expresionesSeparadas() throws RecognitionException {
		ExpresionesSeparadasContext _localctx = new ExpresionesSeparadasContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_expresionesSeparadas);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__15) | (1L << T__26) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << IDENT))) != 0)) {
				{
				setState(241);
				((ExpresionesSeparadasContext)_localctx).e1 = expr(0);
				 _localctx.list.add(((ExpresionesSeparadasContext)_localctx).e1.ast); 
				setState(249);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__34) {
					{
					{
					setState(243);
					match(T__34);
					setState(244);
					((ExpresionesSeparadasContext)_localctx).e2 = expr(0);
					 _localctx.list.add(((ExpresionesSeparadasContext)_localctx).e2.ast); 
					}
					}
					setState(251);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class ParametrosContext extends ParserRuleContext {
		public List<Parametro> list = new ArrayList<Parametro>();
		public ParametroContext p1;
		public ParametroContext p2;
		public List<ParametroContext> parametro() {
			return getRuleContexts(ParametroContext.class);
		}
		public ParametroContext parametro(int i) {
			return getRuleContext(ParametroContext.class,i);
		}
		public ParametrosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametros; }
	}

	public final ParametrosContext parametros() throws RecognitionException {
		ParametrosContext _localctx = new ParametrosContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_parametros);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT) {
				{
				setState(254);
				((ParametrosContext)_localctx).p1 = parametro();
				 _localctx.list.add(((ParametrosContext)_localctx).p1.ast); 
				setState(262);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__34) {
					{
					{
					setState(256);
					match(T__34);
					setState(257);
					((ParametrosContext)_localctx).p2 = parametro();
					 _localctx.list.add(((ParametrosContext)_localctx).p2.ast); 
					}
					}
					setState(264);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class ParametroContext extends ParserRuleContext {
		public Parametro ast;
		public Token IDENT;
		public TipoContext tipo;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public ParametroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametro; }
	}

	public final ParametroContext parametro() throws RecognitionException {
		ParametroContext _localctx = new ParametroContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_parametro);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			((ParametroContext)_localctx).IDENT = match(IDENT);
			setState(268);
			match(T__5);
			setState(269);
			((ParametroContext)_localctx).tipo = tipo();
			 ((ParametroContext)_localctx).ast =  new Parametro(((ParametroContext)_localctx).IDENT, ((ParametroContext)_localctx).tipo.ast); 
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

	public static class AtributosContext extends ParserRuleContext {
		public List<Atributo> list = new ArrayList<Atributo>();
		public AtributoContext atributo;
		public List<AtributoContext> atributo() {
			return getRuleContexts(AtributoContext.class);
		}
		public AtributoContext atributo(int i) {
			return getRuleContext(AtributoContext.class,i);
		}
		public AtributosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atributos; }
	}

	public final AtributosContext atributos() throws RecognitionException {
		AtributosContext _localctx = new AtributosContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_atributos);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENT) {
				{
				{
				setState(272);
				((AtributosContext)_localctx).atributo = atributo();
				 _localctx.list.add(((AtributosContext)_localctx).atributo.ast); 
				}
				}
				setState(279);
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

	public static class AtributoContext extends ParserRuleContext {
		public Atributo ast;
		public Token IDENT;
		public TipoContext tipo;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public AtributoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atributo; }
	}

	public final AtributoContext atributo() throws RecognitionException {
		AtributoContext _localctx = new AtributoContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_atributo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			((AtributoContext)_localctx).IDENT = match(IDENT);
			setState(281);
			match(T__5);
			setState(282);
			((AtributoContext)_localctx).tipo = tipo();
			setState(283);
			match(T__3);
			 ((AtributoContext)_localctx).ast =  new Atributo(((AtributoContext)_localctx).IDENT, ((AtributoContext)_localctx).tipo.ast); 
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

	public static class TipoContext extends ParserRuleContext {
		public Type ast;
		public ExprContext expr;
		public TipoContext tipo;
		public Token IDENT;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_tipo);
		try {
			setState(300);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__35:
				enterOuterAlt(_localctx, 1);
				{
				setState(286);
				match(T__35);
				 ((TipoContext)_localctx).ast =  new IntType(); 
				}
				break;
			case T__36:
				enterOuterAlt(_localctx, 2);
				{
				setState(288);
				match(T__36);
				 ((TipoContext)_localctx).ast =  new RealType(); 
				}
				break;
			case T__37:
				enterOuterAlt(_localctx, 3);
				{
				setState(290);
				match(T__37);
				 ((TipoContext)_localctx).ast =  new CharType(); 
				}
				break;
			case T__29:
				enterOuterAlt(_localctx, 4);
				{
				setState(292);
				match(T__29);
				setState(293);
				((TipoContext)_localctx).expr = expr(0);
				setState(294);
				match(T__30);
				setState(295);
				((TipoContext)_localctx).tipo = tipo();
				 ((TipoContext)_localctx).ast =  new ArrayType(((TipoContext)_localctx).expr.ast, ((TipoContext)_localctx).tipo.ast); 
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 5);
				{
				setState(298);
				((TipoContext)_localctx).IDENT = match(IDENT);
				 ((TipoContext)_localctx).ast =  new CustomType(((TipoContext)_localctx).IDENT); 
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 8:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
		case 2:
			return precpred(_ctx, 5);
		case 3:
			return precpred(_ctx, 3);
		case 4:
			return precpred(_ctx, 2);
		case 5:
			return precpred(_ctx, 11);
		case 6:
			return precpred(_ctx, 10);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3/\u0131\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\7\3\66\n\3\f\3\16\39\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\5\6P\n\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\7\3\7\3\7\7\7[\n\7\f\7\16\7^\13\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\5\b|\n\b\3\b\3\b\5\b\u0080\n\b\3\t\3\t\3\t\7\t\u0085\n"+
		"\t\f\t\16\t\u0088\13\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\5\n\u00a8\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\7\n\u00cb\n\n\f\n\16\n\u00ce\13\n\3\13\3\13\3\13\3\13\3\13\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\5\r\u00ea\n\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\7\17\u00fa\n\17\f\17\16\17\u00fd\13\17\5\17"+
		"\u00ff\n\17\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u0107\n\20\f\20\16\20\u010a"+
		"\13\20\5\20\u010c\n\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\7\22\u0116"+
		"\n\22\f\22\16\22\u0119\13\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u012f"+
		"\n\24\3\24\2\3\22\25\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&\2\6\3"+
		"\2\f\16\3\2\25\26\3\2\27\30\4\2\23\24\31\34\2\u0142\2(\3\2\2\2\4\67\3"+
		"\2\2\2\6:\3\2\2\2\bB\3\2\2\2\nI\3\2\2\2\f\\\3\2\2\2\16\177\3\2\2\2\20"+
		"\u0086\3\2\2\2\22\u00a7\3\2\2\2\24\u00cf\3\2\2\2\26\u00d4\3\2\2\2\30\u00dd"+
		"\3\2\2\2\32\u00ed\3\2\2\2\34\u00fe\3\2\2\2\36\u010b\3\2\2\2 \u010d\3\2"+
		"\2\2\"\u0117\3\2\2\2$\u011a\3\2\2\2&\u012e\3\2\2\2()\5\4\3\2)*\7\2\2\3"+
		"*+\b\2\1\2+\3\3\2\2\2,-\5\b\5\2-.\b\3\1\2.\66\3\2\2\2/\60\5\6\4\2\60\61"+
		"\b\3\1\2\61\66\3\2\2\2\62\63\5\n\6\2\63\64\b\3\1\2\64\66\3\2\2\2\65,\3"+
		"\2\2\2\65/\3\2\2\2\65\62\3\2\2\2\669\3\2\2\2\67\65\3\2\2\2\678\3\2\2\2"+
		"8\5\3\2\2\29\67\3\2\2\2:;\7\3\2\2;<\7,\2\2<=\7\4\2\2=>\5\"\22\2>?\7\5"+
		"\2\2?@\7\6\2\2@A\b\4\1\2A\7\3\2\2\2BC\7\7\2\2CD\7,\2\2DE\7\b\2\2EF\5&"+
		"\24\2FG\7\6\2\2GH\b\5\1\2H\t\3\2\2\2IJ\7,\2\2JK\7\t\2\2KL\5\36\20\2LO"+
		"\7\n\2\2MN\7\b\2\2NP\5&\24\2OM\3\2\2\2OP\3\2\2\2PQ\3\2\2\2QR\7\4\2\2R"+
		"S\5\f\7\2ST\5\20\t\2TU\7\5\2\2UV\b\6\1\2V\13\3\2\2\2WX\5\b\5\2XY\b\7\1"+
		"\2Y[\3\2\2\2ZW\3\2\2\2[^\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]\r\3\2\2\2^\\\3"+
		"\2\2\2_`\7\13\2\2`a\5\22\n\2ab\7\6\2\2bc\b\b\1\2c\u0080\3\2\2\2de\t\2"+
		"\2\2ef\5\22\n\2fg\7\6\2\2gh\b\b\1\2h\u0080\3\2\2\2ij\5\22\n\2jk\7\17\2"+
		"\2kl\5\22\n\2lm\7\6\2\2mn\b\b\1\2n\u0080\3\2\2\2op\5\32\16\2pq\7\6\2\2"+
		"qr\b\b\1\2r\u0080\3\2\2\2st\5\26\f\2tu\b\b\1\2u\u0080\3\2\2\2vw\5\30\r"+
		"\2wx\b\b\1\2x\u0080\3\2\2\2y{\7\20\2\2z|\5\22\n\2{z\3\2\2\2{|\3\2\2\2"+
		"|}\3\2\2\2}~\7\6\2\2~\u0080\b\b\1\2\177_\3\2\2\2\177d\3\2\2\2\177i\3\2"+
		"\2\2\177o\3\2\2\2\177s\3\2\2\2\177v\3\2\2\2\177y\3\2\2\2\u0080\17\3\2"+
		"\2\2\u0081\u0082\5\16\b\2\u0082\u0083\b\t\1\2\u0083\u0085\3\2\2\2\u0084"+
		"\u0081\3\2\2\2\u0085\u0088\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2"+
		"\2\2\u0087\21\3\2\2\2\u0088\u0086\3\2\2\2\u0089\u008a\b\n\1\2\u008a\u008b"+
		"\7)\2\2\u008b\u00a8\b\n\1\2\u008c\u008d\7*\2\2\u008d\u00a8\b\n\1\2\u008e"+
		"\u008f\7+\2\2\u008f\u00a8\b\n\1\2\u0090\u0091\7,\2\2\u0091\u00a8\b\n\1"+
		"\2\u0092\u0093\7\t\2\2\u0093\u0094\5\22\n\2\u0094\u0095\7\n\2\2\u0095"+
		"\u0096\b\n\1\2\u0096\u00a8\3\2\2\2\u0097\u0098\7\22\2\2\u0098\u0099\7"+
		"\23\2\2\u0099\u009a\5&\24\2\u009a\u009b\7\24\2\2\u009b\u009c\7\t\2\2\u009c"+
		"\u009d\5\22\n\2\u009d\u009e\7\n\2\2\u009e\u009f\b\n\1\2\u009f\u00a8\3"+
		"\2\2\2\u00a0\u00a1\7\35\2\2\u00a1\u00a2\5\22\n\6\u00a2\u00a3\b\n\1\2\u00a3"+
		"\u00a8\3\2\2\2\u00a4\u00a5\5\32\16\2\u00a5\u00a6\b\n\1\2\u00a6\u00a8\3"+
		"\2\2\2\u00a7\u0089\3\2\2\2\u00a7\u008c\3\2\2\2\u00a7\u008e\3\2\2\2\u00a7"+
		"\u0090\3\2\2\2\u00a7\u0092\3\2\2\2\u00a7\u0097\3\2\2\2\u00a7\u00a0\3\2"+
		"\2\2\u00a7\u00a4\3\2\2\2\u00a8\u00cc\3\2\2\2\u00a9\u00aa\f\t\2\2\u00aa"+
		"\u00ab\t\3\2\2\u00ab\u00ac\5\22\n\n\u00ac\u00ad\b\n\1\2\u00ad\u00cb\3"+
		"\2\2\2\u00ae\u00af\f\b\2\2\u00af\u00b0\t\4\2\2\u00b0\u00b1\5\22\n\t\u00b1"+
		"\u00b2\b\n\1\2\u00b2\u00cb\3\2\2\2\u00b3\u00b4\f\7\2\2\u00b4\u00b5\t\5"+
		"\2\2\u00b5\u00b6\5\22\n\b\u00b6\u00b7\b\n\1\2\u00b7\u00cb\3\2\2\2\u00b8"+
		"\u00b9\f\5\2\2\u00b9\u00ba\7\36\2\2\u00ba\u00bb\5\22\n\6\u00bb\u00bc\b"+
		"\n\1\2\u00bc\u00cb\3\2\2\2\u00bd\u00be\f\4\2\2\u00be\u00bf\7\37\2\2\u00bf"+
		"\u00c0\5\22\n\5\u00c0\u00c1\b\n\1\2\u00c1\u00cb\3\2\2\2\u00c2\u00c3\f"+
		"\r\2\2\u00c3\u00c4\5\24\13\2\u00c4\u00c5\b\n\1\2\u00c5\u00cb\3\2\2\2\u00c6"+
		"\u00c7\f\f\2\2\u00c7\u00c8\7\21\2\2\u00c8\u00c9\7,\2\2\u00c9\u00cb\b\n"+
		"\1\2\u00ca\u00a9\3\2\2\2\u00ca\u00ae\3\2\2\2\u00ca\u00b3\3\2\2\2\u00ca"+
		"\u00b8\3\2\2\2\u00ca\u00bd\3\2\2\2\u00ca\u00c2\3\2\2\2\u00ca\u00c6\3\2"+
		"\2\2\u00cb\u00ce\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd"+
		"\23\3\2\2\2\u00ce\u00cc\3\2\2\2\u00cf\u00d0\7 \2\2\u00d0\u00d1\5\22\n"+
		"\2\u00d1\u00d2\7!\2\2\u00d2\u00d3\b\13\1\2\u00d3\25\3\2\2\2\u00d4\u00d5"+
		"\7\"\2\2\u00d5\u00d6\7\t\2\2\u00d6\u00d7\5\22\n\2\u00d7\u00d8\7\n\2\2"+
		"\u00d8\u00d9\7\4\2\2\u00d9\u00da\5\20\t\2\u00da\u00db\7\5\2\2\u00db\u00dc"+
		"\b\f\1\2\u00dc\27\3\2\2\2\u00dd\u00de\7#\2\2\u00de\u00df\7\t\2\2\u00df"+
		"\u00e0\5\22\n\2\u00e0\u00e1\7\n\2\2\u00e1\u00e2\7\4\2\2\u00e2\u00e3\5"+
		"\20\t\2\u00e3\u00e9\7\5\2\2\u00e4\u00e5\7$\2\2\u00e5\u00e6\7\4\2\2\u00e6"+
		"\u00e7\5\20\t\2\u00e7\u00e8\7\5\2\2\u00e8\u00ea\3\2\2\2\u00e9\u00e4\3"+
		"\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00ec\b\r\1\2\u00ec"+
		"\31\3\2\2\2\u00ed\u00ee\7,\2\2\u00ee\u00ef\7\t\2\2\u00ef\u00f0\5\34\17"+
		"\2\u00f0\u00f1\7\n\2\2\u00f1\u00f2\b\16\1\2\u00f2\33\3\2\2\2\u00f3\u00f4"+
		"\5\22\n\2\u00f4\u00fb\b\17\1\2\u00f5\u00f6\7%\2\2\u00f6\u00f7\5\22\n\2"+
		"\u00f7\u00f8\b\17\1\2\u00f8\u00fa\3\2\2\2\u00f9\u00f5\3\2\2\2\u00fa\u00fd"+
		"\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00ff\3\2\2\2\u00fd"+
		"\u00fb\3\2\2\2\u00fe\u00f3\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\35\3\2\2"+
		"\2\u0100\u0101\5 \21\2\u0101\u0108\b\20\1\2\u0102\u0103\7%\2\2\u0103\u0104"+
		"\5 \21\2\u0104\u0105\b\20\1\2\u0105\u0107\3\2\2\2\u0106\u0102\3\2\2\2"+
		"\u0107\u010a\3\2\2\2\u0108\u0106\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u010c"+
		"\3\2\2\2\u010a\u0108\3\2\2\2\u010b\u0100\3\2\2\2\u010b\u010c\3\2\2\2\u010c"+
		"\37\3\2\2\2\u010d\u010e\7,\2\2\u010e\u010f\7\b\2\2\u010f\u0110\5&\24\2"+
		"\u0110\u0111\b\21\1\2\u0111!\3\2\2\2\u0112\u0113\5$\23\2\u0113\u0114\b"+
		"\22\1\2\u0114\u0116\3\2\2\2\u0115\u0112\3\2\2\2\u0116\u0119\3\2\2\2\u0117"+
		"\u0115\3\2\2\2\u0117\u0118\3\2\2\2\u0118#\3\2\2\2\u0119\u0117\3\2\2\2"+
		"\u011a\u011b\7,\2\2\u011b\u011c\7\b\2\2\u011c\u011d\5&\24\2\u011d\u011e"+
		"\7\6\2\2\u011e\u011f\b\23\1\2\u011f%\3\2\2\2\u0120\u0121\7&\2\2\u0121"+
		"\u012f\b\24\1\2\u0122\u0123\7\'\2\2\u0123\u012f\b\24\1\2\u0124\u0125\7"+
		"(\2\2\u0125\u012f\b\24\1\2\u0126\u0127\7 \2\2\u0127\u0128\5\22\n\2\u0128"+
		"\u0129\7!\2\2\u0129\u012a\5&\24\2\u012a\u012b\b\24\1\2\u012b\u012f\3\2"+
		"\2\2\u012c\u012d\7,\2\2\u012d\u012f\b\24\1\2\u012e\u0120\3\2\2\2\u012e"+
		"\u0122\3\2\2\2\u012e\u0124\3\2\2\2\u012e\u0126\3\2\2\2\u012e\u012c\3\2"+
		"\2\2\u012f\'\3\2\2\2\23\65\67O\\{\177\u0086\u00a7\u00ca\u00cc\u00e9\u00fb"+
		"\u00fe\u0108\u010b\u0117\u012e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}