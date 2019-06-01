package codegeneration;

import java.io.*;
import java.util.*;

import ast.*;
import visitor.*;

enum CodeFunction {
	DIR, VALOR
}

public class CodeSelection extends DefaultVisitor {

	private Map<String, String> instruccion = new HashMap<String, String>();

	public CodeSelection(Writer writer, String sourceFile) {
		this.writer = new PrintWriter(writer);
		this.sourceFile = sourceFile;

		instruccion.put("+", "add");
		instruccion.put("-", "sub");
		instruccion.put("*", "mul");
		instruccion.put("/", "div");
		instruccion.put(">", "gt");
		instruccion.put("<", "lt");
		instruccion.put(">=", "ge");
		instruccion.put("<=", "le");
		instruccion.put("==", "eq");
		instruccion.put("!=", "ne");
		instruccion.put("&&", "and");
		instruccion.put("||", "or");
		instruccion.put("!", "not");
	}
	
	//	class Program { List<Bloque> bloque; }
	public Object visit(Program node, Object param) {
        out("#source \"" + sourceFile + "\"");
        out("call main");
        out("halt");
        visitChildren(node.getBloque(), param);
        return null;
    }
	
	//	class VarDef { String name;  Type type; }
	public Object visit(VarDef node, Object param) {
		if (node.getType() instanceof IntType || node.getType() instanceof RealType)
			out("#GLOBAL " + node.getName() + ":" + node.getType().getMAPLName());
		return null;
	}
	
	//	class EstructuraDef { String nombre;  List<Atributo> atributos; }
	public Object visit(EstructuraDef node, Object param) {
		return null;
	}
	
	//	class FuncionDef { String name;  List<Parametro> parametros;  Type type;  List<VarDef> variables;  List<Sentencia> sentencias; }
	public Object visit(FuncionDef node, Object param) {
		//out("#func "+node.getName());
		out(node.getName()+":");
		int tamañoVariables = 0;
		for (VarDef v : node.getVariables()) {
			v.setLocalInFunc(true);
			tamañoVariables += v.getType().getTamaño(); 
		}
		if (tamañoVariables>0)
			out("enter "+tamañoVariables);
		visitChildren(node.getSentencias(), param);
		
		int retTam = 0;
		int varTam = 0;
		int paramTam = 0;
		if(node.getType()!=null)
			retTam = node.getType().getTamaño();
		for (VarDef v : node.getVariables())
			varTam += v.getType().getTamaño();
		for (Parametro p : node.getParametros()) {
			paramTam += p.getType().getTamaño();
		}
		out("ret "+retTam+", "+varTam+", "+paramTam);
		return null;
	}

	// class Print { Expression expression; }
	public Object visit(Print node, Object param) {
		out("#line " + node.getEnd().getLine());
		
		if(node.getValue().getType() instanceof ArrayType) {
			//Imprimir chars del array
			ArrayType ar = (ArrayType)(((Variable)node.getValue()).getType());
			for(int i=0; i<ar.getTamaño(); i++) {
				new AccesoArray(node.getValue(), new Array(new Integral(""+i))).accept(this, CodeFunction.VALOR);
				out("out", ar.getType());
			}
		} else {		
			node.getValue().accept(this, CodeFunction.VALOR);
			out("out", node.getValue().getType());
		}
		//Si es println o printsp añadimos caracter concreto al final
		if (node.getOperation().equals("println")) {
			new Caracter("'\\n'").accept(this, CodeFunction.VALOR);
			out("outb");
		}
		if (node.getOperation().equals("printsp")) {
			new Caracter("' '").accept(this, CodeFunction.VALOR);
			out("outb");
		}
		return null;
	}
	
	// class Read { Expression expression; }
	public Object visit(Read node, Object param) {
		out("#line " + node.getEnd().getLine());
		node.getValue().accept(this, CodeFunction.DIR);
		out("in", node.getValue().getType());
		out("store", node.getValue().getType());
		return null;
	}

	// class Assignment { Expression left; Expression right; }
	public Object visit(Assign node, Object param) {
		out("#line " + node.getEnd().getLine());
		
		if(node.getLeft().getType() instanceof ArrayType) {
			ArrayType ar = (ArrayType)node.getLeft().getType();
			for(int i=0; i<ar.getTamaño(); i++) {
				new AccesoArray(node.getLeft(), new Array(new Integral(""+i))).accept(this, CodeFunction.DIR);
				new AccesoArray(node.getRight(), new Array(new Integral(""+i))).accept(this, CodeFunction.VALOR);
				out("store", ar.getType());
			}
		} else {		
			node.getLeft().accept(this, CodeFunction.DIR);
			node.getRight().accept(this, CodeFunction.VALOR);
			out("store", node.getLeft().getType());
		}
		return null;
	}
	
	//	class ReturnSent { Expresion retorno; }
	public Object visit(ReturnSent node, Object param) {
		if (node.getRetorno()!=null)
			node.getRetorno().accept(this, CodeFunction.VALOR);
		return null;
	}
	
	//	class Whileloop { Expresion condicion;  List<Sentencia> sentencias; }
	public Object visit(Whileloop node, Object param) {
		int counter = contadorBucles++;
		out("while"+counter+":");
		node.getCondicion().accept(this, CodeFunction.VALOR);
		out("JZ fin"+counter);
		visitChildren(node.getSentencias(), param);
		out("JMP while"+counter);
		out("fin"+counter+":");
		return null;
	}
	
	//	class IfDef { Expresion condicion;  List<Sentencia> iftrue;  List<Sentencia> iffalse; }
	public Object visit(IfDef node, Object param) {
		int counter = contadorBucles++;
		node.getCondicion().accept(this, CodeFunction.VALOR);
		out("JZ iffalse"+counter);
		visitChildren(node.getIftrue(), param);
		out("JMP fin"+counter);
		out("iffalse"+counter+":");
		visitChildren(node.getIffalse(), param);
		out("fin"+counter+":");
		return null;
	}
	
	//	class LlamadaS { Llamada invocacion; }
	public Object visit(LlamadaS node, Object param) {
		for (Expresion p: node.getInvocacion().getParametros()) {
			p.accept(this, CodeFunction.VALOR);
		}
		out("call "+node.getInvocacion().getNombre());
		if(node.getInvocacion().getDefinicion().getType()!=null)
			out("POP"+node.getInvocacion().getDefinicion().getType().getSuffix());
		return null;
	}
	
	//	class LlamadaE { Llamada invocacion; }
	public Object visit(LlamadaE node, Object param) {
		for (Expresion p: node.getInvocacion().getParametros())
			p.accept(this, CodeFunction.VALOR);
		out("call "+node.getInvocacion().getNombre());
		return null;
	}

	// class Variable { String name; }
	public Object visit(Variable node, Object param) {
		if (((CodeFunction) param) == CodeFunction.VALOR) {
			visit(node, CodeFunction.DIR);
			out("load", node.getType());
		} else {
			assert (param == CodeFunction.DIR);
			if (!node.getDefinicion().isLocalInFunc() && !node.getDefinicion().isParameter())
				out("pusha " + node.getDefinicion().getAddress());
			else {
				out("pusha BP");
				if(node.getDefinicion().isParameter()) 
					out("push " + node.getDefinicion().getParameter().getAddress());
				else
					out("push " + node.getDefinicion().getAddress());
				out("add");
			}
		}
		return null;
	}

	public Object visit(AccesoStruct node, Object param) {
		super.visit(node, CodeFunction.DIR);
		if (node.getLeft().getType() instanceof CustomType) {
			EstructuraDef defS = ((CustomType) node.getLeft().getType()).getDefinicion();
			for (Atributo dC : defS.getAtributos()) {
				if (dC.getName().equals(node.getRight())) {
					out("push " + dC.getAddress());
					out("add");
					break;
				}
			}
			if (param == CodeFunction.VALOR) {
				out("load", node.getType());
			}
		}
		return null;
	}

	// class Integral { String valor; }
	public Object visit(Integral node, Object param) {
		assert (param == CodeFunction.VALOR);
		out("push " + node.getValor());
		return null;
	}

	// class Real { String valor; }
	public Object visit(Real node, Object param) {
		assert (param == CodeFunction.VALOR);
		out("pushf " + node.getValor());
		return null;
	}

	// class Caracter { String valor; }
	public Object visit(Caracter node, Object param) {
		assert (param == CodeFunction.VALOR);
		out("pushb " + (int)node.getCaracter());
		return null;
	}

	// class Identificador { Expresion var; List<Array> dimensiones; }
	public Object visit(AccesoArray node, Object param) {
		node.getVar().accept(this, CodeFunction.DIR);
		node.getDimensiones().getPos().accept(this, CodeFunction.VALOR);
		out("push " + ((ArrayType) node.getVar().getType()).getType().getTamaño());
		out("mul");
		out("add");
		if (param == CodeFunction.VALOR) {
			out("load", ((ArrayType)node.getVar().getType()).getType());
		}
		return null;
	}

	// class Parentesis { Expresion contenido; }
	public Object visit(Parentesis node, Object param) {
		assert (param == CodeFunction.VALOR);
		node.getContenido().accept(this, param);
		return null;
	}

	// class Casting { Type tipo; Expresion contenido; }
	public Object visit(Casting node, Object param) {
		assert (param == CodeFunction.VALOR);
		node.getContenido().accept(this, param);
		out(node.getContenido().getType().getSuffix() + "2" + node.getTipo().getSuffix());
		return null;
	}

	// class Aritmetica { Expresion left; String operando; Expresion right; }
	public Object visit(Aritmetica node, Object param) {
		assert (param == CodeFunction.VALOR);
		node.getLeft().accept(this, CodeFunction.VALOR);
		node.getRight().accept(this, CodeFunction.VALOR);
		out(instruccion.get(node.getOperando()), node.getType());
		return null;
	}

	// class Comparativa { Expresion left; String operando; Expresion right; }
	public Object visit(Comparativa node, Object param) {
		assert (param == CodeFunction.VALOR);
		node.getLeft().accept(this, CodeFunction.VALOR);
		node.getRight().accept(this, CodeFunction.VALOR);
		out(instruccion.get(node.getOperando()), node.getRight().getType());
		return null;
	}
	
	//	class Logica { Expresion left;  String operando;  Expresion right; }
	public Object visit(Logica node, Object param) {
		assert (param == CodeFunction.VALOR);
		if (!node.getOperando().equals("!")) {
			node.getLeft().accept(this, CodeFunction.VALOR);
			node.getRight().accept(this, CodeFunction.VALOR);
			out(instruccion.get(node.getOperando()));
		} else {
			node.getRight().accept(this, CodeFunction.VALOR);
			out(instruccion.get(node.getOperando()));
		}
		return null;
	}

	////////////////////////////////////////////////////////////////////////

	// Método auxiliar
	private void out(String instruccion, Type tipo) {
		out(instruccion + tipo.getSuffix());
	}

	// Métodos auxiliares recomendados (opcionales) -------------
	private void out(String instruction) {
		writer.println(instruction);
	}

	private void line(Position pos) {
		out("\n#line " + pos.getLine());
	}

	private void line(AST node) {
		line(node.getEnd());
	}

	private PrintWriter writer;
	private String sourceFile;
	private int contadorBucles = 0;
}
