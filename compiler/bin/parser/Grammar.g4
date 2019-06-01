grammar Grammar
	;
import Lexicon
	;
	
@parser::header {
    import ast.*;
}

start returns[Program ast]
	: bloques EOF { $ast = new Program($bloques.list); }
	;

bloques returns[List<Bloque> list = new ArrayList<Bloque>()]
	: (variableDefinicion{ $list.add($variableDefinicion.ast); }|estructura{ $list.add($estructura.ast); }|funcion{ $list.add($funcion.ast); })*
	;
	
estructura returns [EstructuraDef ast]
	: 'struct' IDENT '{' atributos '}' ';' { $ast= new EstructuraDef($IDENT, $atributos.list); }
	;

variableDefinicion returns [VarDef ast]
	: 'var' IDENT ':' tipo ';' { $ast = new VarDef($IDENT, $tipo.ast); }
	;
	
funcion returns [FuncionDef ast]
	: IDENT '(' parametros ')' (':' tipo)? '{' variables sentencias '}' 
		{ 
			if ($tipo.ctx==null) $ast = new FuncionDef($IDENT, $parametros.list, null, $variables.list, $sentencias.list);
			else $ast = new FuncionDef($IDENT, $parametros.list, $tipo.ast, $variables.list, $sentencias.list);
		}
	;
	
variables returns[List<VarDef> list = new ArrayList<VarDef>()]
	: (variableDefinicion { $list.add($variableDefinicion.ast); })*
	;

sentencia returns [Sentencia ast]
	: 'read' expr ';' { $ast = new Read($expr.ast); }
	| o=('printsp'|'print'|'println') expr ';' { $ast = new Print($o.text, $expr.ast); }
	| left=expr '=' right=expr ';' { $ast = new Assign($left.ast, $right.ast); }
	| llamada ';' { $ast =  new LlamadaS($llamada.ast); }
	| whileloop { $ast = $whileloop.ast; }
	| ifblock { $ast =  $ifblock.ast; }
	| r='return' expr? ';' 
		{ 
			if ($expr.ctx == null) $ast = new ReturnSent(null); 
			else $ast = new ReturnSent($expr.ast); 
			$ast.setPositions($r);
		}
	;

sentencias returns[List<Sentencia> list = new ArrayList<Sentencia>()]
	: (sentencia { $list.add($sentencia.ast); })*
	;
	
expr returns [Expresion ast]
	: INT_CONSTANT { $ast = new Integral($INT_CONSTANT); }
	| REAL_CONSTANT { $ast = new Real($REAL_CONSTANT); }
	| CHAR_CONSTANT { $ast = new Caracter($CHAR_CONSTANT); }
	| IDENT { $ast = new Variable($IDENT); }
	| v=expr arrays { $ast = new Identificador($v.ast, $arrays.ast); }
	| left=expr '.' IDENT { $ast = new Compuesto($left.ast, $IDENT); }
	| '(' expr ')' { $ast = new Parentesis($expr.ast); }
	| 'cast' '<' tipo '>' '(' expr ')' { $ast = new Casting($tipo.ast, $expr.ast); }
	| left=expr op=('*'|'/') right=expr { $ast= new Aritmetica($left.ast, $op, $right.ast); }
	| left=expr op=('+'|'-') right=expr { $ast= new Aritmetica($left.ast, $op, $right.ast); }
	| left=expr op=('>'|'<'|'=='|'!='|'>='|'<=') right=expr { $ast= new Comparativa($left.ast, $op, $right.ast); }	
	| op='!' right=expr { $ast= new Logica($right.ast, $op, $right.ast); }
	| left=expr op='&&' right=expr { $ast= new Logica($left.ast, $op, $right.ast); }
	| left=expr op='||' right=expr { $ast= new Logica($left.ast, $op, $right.ast); }
	| llamada { $ast = new LlamadaE($llamada.ast); }
	;
	
arrays returns [Array ast]
	: '[' expr ']' { $ast = new Array($expr.ast); }
	;
	
whileloop returns [Whileloop ast]
	: 'while' '(' expr ')' '{' sentencias '}' { $ast = new Whileloop($expr.ast, $sentencias.list); }
	;

ifblock returns [IfDef ast]
	: 'if' '(' expr ')' '{' casetrue=sentencias '}' ('else' '{' casefalse=sentencias '}')? 
		{ 
			if ($casefalse.ctx==null) $ast = new IfDef($expr.ast, $casetrue.list, null); 
			else $ast = new IfDef($expr.ast, $casetrue.list, $casefalse.list); 
		}
	;
	
llamada returns [Llamada ast]
	: IDENT '(' expresionesSeparadas ')' { $ast = new Llamada($IDENT, $expresionesSeparadas.list); }
	;

expresionesSeparadas returns [List<Expresion> list = new ArrayList<Expresion>()]
	: (e1=expr { $list.add($e1.ast); } (',' e2=expr { $list.add($e2.ast); })*)?
	;

parametros returns[List<Parametro> list = new ArrayList<Parametro>()]
	: (p1=parametro { $list.add($p1.ast); } (',' p2=parametro { $list.add($p2.ast); })*)?
	; 
	
parametro returns [Parametro ast]
	: IDENT ':' tipo { $ast = new Parametro($IDENT, $tipo.ast); }
	;


atributos returns [List<Atributo> list = new ArrayList<Atributo>()]
	: (atributo { $list.add($atributo.ast); })*
	; 

atributo returns [Atributo ast]
	: IDENT ':' tipo ';' { $ast = new Atributo($IDENT, $tipo.ast); }
	;

tipo returns [Type ast]
	: 'int' { $ast = new IntType(); }
	| 'float' { $ast = new RealType(); }
	| 'char' { $ast = new CharType(); }
	| '[' expr ']' tipo { $ast = new ArrayType($expr.ast, $tipo.ast); }
	| IDENT { $ast = new CustomType($IDENT); }
	;