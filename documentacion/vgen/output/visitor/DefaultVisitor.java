/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package visitor;

import ast.*;
import java.util.*;

/*
DefaultVisitor. Implementación base del visitor para ser derivada por nuevos visitor.
	No modificar esta clase. Para crear nuevos visitor usar el fichero "_PlantillaParaVisitors.txt".
	DefaultVisitor ofrece una implementación por defecto de cada nodo que se limita a visitar los nodos hijos.
*/
public class DefaultVisitor implements Visitor {

	//	class Program { List<Bloque> bloque; }
	public Object visit(Program node, Object param) {
		visitChildren(node.getBloque(), param);
		return null;
	}

	//	class VarDef { String name;  Type type; }
	public Object visit(VarDef node, Object param) {
		if (node.getType() != null)
			node.getType().accept(this, param);
		return null;
	}

	//	class EstructuraDef { String nombre;  List<Atributo> atributos; }
	public Object visit(EstructuraDef node, Object param) {
		visitChildren(node.getAtributos(), param);
		return null;
	}

	//	class FuncionDef { String name;  List<Parametro> parametros;  Type type;  List<VarDef> variables;  List<Sentencia> sentencias; }
	public Object visit(FuncionDef node, Object param) {
		visitChildren(node.getParametros(), param);
		if (node.getType() != null)
			node.getType().accept(this, param);
		visitChildren(node.getVariables(), param);
		visitChildren(node.getSentencias(), param);
		return null;
	}

	//	class Atributo { String name;  Type type; }
	public Object visit(Atributo node, Object param) {
		if (node.getType() != null)
			node.getType().accept(this, param);
		return null;
	}

	//	class Parametro { String nombre;  Type type; }
	public Object visit(Parametro node, Object param) {
		if (node.getType() != null)
			node.getType().accept(this, param);
		return null;
	}

	//	class IntType {  }
	public Object visit(IntType node, Object param) {
		return null;
	}

	//	class RealType {  }
	public Object visit(RealType node, Object param) {
		return null;
	}

	//	class CharType {  }
	public Object visit(CharType node, Object param) {
		return null;
	}

	//	class ArrayType { Expresion size;  Type type; }
	public Object visit(ArrayType node, Object param) {
		if (node.getSize() != null)
			node.getSize().accept(this, param);
		if (node.getType() != null)
			node.getType().accept(this, param);
		return null;
	}

	//	class CustomType { String nombre; }
	public Object visit(CustomType node, Object param) {
		return null;
	}

	//	class Read { Expresion value; }
	public Object visit(Read node, Object param) {
		if (node.getValue() != null)
			node.getValue().accept(this, param);
		return null;
	}

	//	class Print { Expresion value; }
	public Object visit(Print node, Object param) {
		if (node.getValue() != null)
			node.getValue().accept(this, param);
		return null;
	}

	//	class Assign { Expresion left;  Expresion right; }
	public Object visit(Assign node, Object param) {
		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		if (node.getRight() != null)
			node.getRight().accept(this, param);
		return null;
	}

	//	class Whileloop { Expresion condicion;  List<Sentencia> sentencias; }
	public Object visit(Whileloop node, Object param) {
		if (node.getCondicion() != null)
			node.getCondicion().accept(this, param);
		visitChildren(node.getSentencias(), param);
		return null;
	}

	//	class IfDef { Expresion condicion;  List<Sentencia> iftrue;  List<Sentencia> iffalse; }
	public Object visit(IfDef node, Object param) {
		if (node.getCondicion() != null)
			node.getCondicion().accept(this, param);
		visitChildren(node.getIftrue(), param);
		visitChildren(node.getIffalse(), param);
		return null;
	}

	//	class ReturnSent { Expresion retorno; }
	public Object visit(ReturnSent node, Object param) {
		if (node.getRetorno() != null)
			node.getRetorno().accept(this, param);
		return null;
	}

	//	class LlamadaS { Llamada invocacion; }
	public Object visit(LlamadaS node, Object param) {
		if (node.getInvocacion() != null)
			node.getInvocacion().accept(this, param);
		return null;
	}

	//	class Variable { String name; }
	public Object visit(Variable node, Object param) {
		return null;
	}

	//	class Compuesto { Expresion left;  Expresion right; }
	public Object visit(Compuesto node, Object param) {
		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		if (node.getRight() != null)
			node.getRight().accept(this, param);
		return null;
	}

	//	class Integral { String valor; }
	public Object visit(Integral node, Object param) {
		return null;
	}

	//	class Real { String valor; }
	public Object visit(Real node, Object param) {
		return null;
	}

	//	class Caracter { String valor; }
	public Object visit(Caracter node, Object param) {
		return null;
	}

	//	class Identificador { Expresion var;  List<Array> dimensiones; }
	public Object visit(Identificador node, Object param) {
		if (node.getVar() != null)
			node.getVar().accept(this, param);
		visitChildren(node.getDimensiones(), param);
		return null;
	}

	//	class Parentesis { Expresion contenido; }
	public Object visit(Parentesis node, Object param) {
		if (node.getContenido() != null)
			node.getContenido().accept(this, param);
		return null;
	}

	//	class Casting { Type tipo;  Expresion contenido; }
	public Object visit(Casting node, Object param) {
		if (node.getTipo() != null)
			node.getTipo().accept(this, param);
		if (node.getContenido() != null)
			node.getContenido().accept(this, param);
		return null;
	}

	//	class Aritmetica { Expresion left;  String operando;  Expresion right; }
	public Object visit(Aritmetica node, Object param) {
		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		if (node.getRight() != null)
			node.getRight().accept(this, param);
		return null;
	}

	//	class Comparativa { Expresion left;  String operando;  Expresion right; }
	public Object visit(Comparativa node, Object param) {
		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		if (node.getRight() != null)
			node.getRight().accept(this, param);
		return null;
	}

	//	class Logica { Expresion left;  String operando;  Expresion right; }
	public Object visit(Logica node, Object param) {
		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		if (node.getRight() != null)
			node.getRight().accept(this, param);
		return null;
	}

	//	class LlamadaE { Llamada invocacion; }
	public Object visit(LlamadaE node, Object param) {
		if (node.getInvocacion() != null)
			node.getInvocacion().accept(this, param);
		return null;
	}

	//	class Array { Expresion pos; }
	public Object visit(Array node, Object param) {
		if (node.getPos() != null)
			node.getPos().accept(this, param);
		return null;
	}

	//	class Llamada { String nombre;  List<Expresion> parametros; }
	public Object visit(Llamada node, Object param) {
		visitChildren(node.getParametros(), param);
		return null;
	}

    // Método auxiliar -----------------------------
    protected void visitChildren(List<? extends AST> children, Object param) {
        if (children != null)
            for (AST child : children)
                child.accept(this, param);
    }
}
