package visitor;

import ast.Aritmetica;
import ast.Array;
import ast.ArrayType;
import ast.Assign;
import ast.Atributo;
import ast.Bloque;
import ast.Caracter;
import ast.Casting;
import ast.CharType;
import ast.Comparativa;
import ast.AccesoStruct;
import ast.CustomType;
import ast.EstructuraDef;
import ast.Expresion;
import ast.FuncionDef;
import ast.AccesoArray;
import ast.IfDef;
import ast.IntType;
import ast.Integral;
import ast.Llamada;
import ast.LlamadaE;
import ast.LlamadaS;
import ast.Logica;
import ast.Parametro;
import ast.Parentesis;
import ast.Print;
import ast.Program;
import ast.Read;
import ast.Real;
import ast.RealType;
import ast.ReturnSent;
import ast.Sentencia;
import ast.VarDef;
import ast.Whileloop;

public class PrintVisitor extends DefaultVisitor {

	// ---------------------------------------------------------
	// Tareas a realizar en cada método visit:
	//
	// Si en algún método visit NO SE QUIERE HACER NADA más que recorrer los hijos entonces se puede
	// borrar (dicho método se heredaría de DefaultVisitor con el código de recorrido).
	//
	// Lo siguiente es para cuando se quiera AÑADIR alguna funcionalidad adicional a un visit:
	//
	// - El código que aparece en cada método visit es aquel que recorre los hijos. Es el mismo código
	//		que está implementado en el padre (DefaultVisitor). Por tanto la llamada a 'super.visit' y el
	//		resto del código del método hacen lo mismo (por ello 'super.visit' está comentado).
	//
	// - Lo HABITUAL será borrar todo el código de recorrido dejando solo la llamada a 'super.visit'. De esta
	//		manera, cada método visit se puede centrar en la tarea que tiene que realizar sobre su nodo del AST
    //      (dejando que el padre se encargue del recorrido de los hijos).
	//
	// - La razón de que aparezca el código de recorrido de los hijos es por si se necesita realizar alguna
	//		tarea DURANTE el mismo (por ejemplo ir comprobando su tipo). En este caso, ya se tiene implementado
	//		dicho recorrido y solo habría que incrustar las acciones adicionales en el mismo. En este caso,
	//		es la llamada a 'super.visit' la que debería ser borrada.
	// ---------------------------------------------------------

	//	class Program { List<Bloque> bloque; }
	public Object visit(Program node, Object param) {

		// super.visit(node, param);

		if (node.getBloque() != null)
			for (Bloque child : node.getBloque())
				child.accept(this, param);

		return null;
	}

	//	class VarDef { String name;  Type type; }
	public Object visit(VarDef node, Object param) {

		// super.visit(node, param);

		System.out.print("var "+node.getName()+":");
		node.getType().accept(this, param);
		System.out.print(";\n");
		return null;
	}

	//	class EstructuraDef { String nombre;  List<Atributo> atributos; }
	public Object visit(EstructuraDef node, Object param) {

		// super.visit(node, param);

		System.out.println("struct "+node.getNombre()+" { ");
		if (node.getAtributos() != null)
			for (Atributo child : node.getAtributos()) {
				System.out.print("\t");
				child.accept(this, param);
			}
		System.out.println("};");
		return null;
	}

	//	class FuncionDef { String name;  List<Parametro> parametros;  Type type;  List<VarDef> variables;  List<Sentencia> sentencias; }
	public Object visit(FuncionDef node, Object param) {

		// super.visit(node, param);
		System.out.print(node.getName()+"(");
		if (node.getParametros() != null)
			for (int i=0; i<node.getParametros().size(); i++) {
				node.getParametros().get(i).accept(this, param);
				if (i<node.getParametros().size()-1)
					System.out.print(", ");
			}
		System.out.print(")");
		if (node.getType() != null) {
			System.out.print(":");
			node.getType().accept(this, param); 
		}
		System.out.print(" {\n");
		if (node.getVariables() != null)
			for (VarDef child : node.getVariables()) {
				//System.out.print("\t");
				child.accept(this, param);
			}

		if (node.getSentencias() != null)
			for (Sentencia child : node.getSentencias()) {
				//System.out.print("\t");
				child.accept(this, param);
			}
		System.out.print("}\n");
		return null;
	}

	//	class Atributo { String name;  Type type; }
	public Object visit(Atributo node, Object param) {

		// super.visit(node, param);
		System.out.print(node.getName());
		System.out.print(":");
		if (node.getType() != null) 
			node.getType().accept(this, param);
		System.out.print(";\n");
		return null;
	}

	//	class Parametro { String nombre;  Type type; }
	public Object visit(Parametro node, Object param) {

		// super.visit(node, param);
		System.out.print(node.getNombre()+":");
		if (node.getType() != null)
			node.getType().accept(this, param);
		return null;
	}

	//	class IntType {  }
	public Object visit(IntType node, Object param) {
		System.out.print("int");
		return null;
	}

	//	class RealType {  }
	public Object visit(RealType node, Object param) {
		System.out.print("float");
		return null;
	}

	//	class CharType {  }
	public Object visit(CharType node, Object param) {
		System.out.print("char");
		return null;
	}

	//	class ArrayType { Expresion size;  Type type; }
	public Object visit(ArrayType node, Object param) {

		// super.visit(node, param);
		System.out.print("[");
		if (node.getSize() != null)
			node.getSize().accept(this, param);
		System.out.print("]");

		if (node.getType() != null)
			node.getType().accept(this, param);

		return null;
	}

	//	class CustomType { String nombre; }
	public Object visit(CustomType node, Object param) {
		System.out.print(node.getNombre());
		return null;
	}

	//	class Read { Expresion value; }
	public Object visit(Read node, Object param) {

		// super.visit(node, param);
		System.out.print("read ");
		if (node.getValue() != null)
			node.getValue().accept(this, param);
		System.out.print(";\n");
		return null;
	}

	//	class Print { Expresion value; }
	public Object visit(Print node, Object param) {

		// super.visit(node, param);
		System.out.print("printsp ");
		if (node.getValue() != null)
			node.getValue().accept(this, param);
		System.out.print(";\n");
		return null;
	}

	//	class Assign { Expresion left;  Expresion right; }
	public Object visit(Assign node, Object param) {

		// super.visit(node, param);

		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		System.out.print("=");
		if (node.getRight() != null)
			node.getRight().accept(this, param);
		System.out.print(";\n");
		return null;
	}

	//	class Whileloop { Expresion condicion;  List<Sentencia> sentencias; }
	public Object visit(Whileloop node, Object param) {

		// super.visit(node, param);
		System.out.print("while (");
		if (node.getCondicion() != null)
			node.getCondicion().accept(this, param);
		System.out.print(") {\n");
		if (node.getSentencias() != null)
			for (Sentencia child : node.getSentencias()) {
				System.out.print("\t");
				child.accept(this, param);
			}
		System.out.print("}\n");
		return null;
	}

	//	class IfDef { Expresion condicion;  List<Sentencia> iftrue;  List<Sentencia> iffalse; }
	public Object visit(IfDef node, Object param) {

		// super.visit(node, param);
		System.out.print("if (");
		if (node.getCondicion() != null)
			node.getCondicion().accept(this, param);
		System.out.print(") {\n");
		if (node.getIftrue() != null)
			for (Sentencia child : node.getIftrue()) {
				System.out.print("\t");
				child.accept(this, param);
			}
		
		if (node.getIffalse() != null) {
			System.out.print("\n} else {\n");
			for (Sentencia child : node.getIffalse()) {
				System.out.print("\t");
				child.accept(this, param);				
			}
		}
		System.out.print("}\n");
		return null;
	}

	//	class ReturnSent { Expresion retorno; }
	public Object visit(ReturnSent node, Object param) {

		// super.visit(node, param);
		System.out.print("return ");
		if (node.getRetorno() != null)
			node.getRetorno().accept(this, param);
		System.out.print(";\n");
		return null;
	}

	//	class LlamadaS { Llamada invocacion; }
	public Object visit(LlamadaS node, Object param) {

		// super.visit(node, param);

		if (node.getInvocacion() != null)
			node.getInvocacion().accept(this, param);
		System.out.print("\n");
		return null;
	}

	//	class AccesoStruct { Expresion left;  String right; }
	public Object visit(AccesoStruct node, Object param) {

		// super.visit(node, param);

		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		if (node.getRight() != null) {
			System.out.print("."+node.getRight());
		}			

		return null;
	}

	//	class Integral { String valor; }
	public Object visit(Integral node, Object param) {
		System.out.print(node.getValor());
		return null;
	}

	//	class Real { String valor; }
	public Object visit(Real node, Object param) {
		System.out.print(node.getValor());
		return null;
	}

	//	class Caracter { String valor; }
	public Object visit(Caracter node, Object param) {
		System.out.print(node.getValor());
		return null;
	}

	//	class AccesoArray { String var;  Array dimensiones; }
	public Object visit(AccesoArray node, Object param) {

		// super.visit(node, param);
		System.out.print(node.getVar());
		if (node.getDimensiones() != null)
			node.getDimensiones().accept(this, param);

		return null;
	}

	//	class Parentesis { Expresion contenido; }
	public Object visit(Parentesis node, Object param) {

		// super.visit(node, param);
		System.out.print("(");
		if (node.getContenido() != null)
			node.getContenido().accept(this, param);
		System.out.print(")");
		return null;
	}

	//	class Casting { Type tipo;  Expresion contenido; }
	public Object visit(Casting node, Object param) {

		// super.visit(node, param);
		System.out.print("cast<");
		if (node.getTipo() != null)
			node.getTipo().accept(this, param);
		System.out.print(">(");
		if (node.getContenido() != null)
			node.getContenido().accept(this, param);
		System.out.print(")");
		return null;
	}

	//	class Aritmetica { Expresion left;  String operando;  Expresion right; }
	public Object visit(Aritmetica node, Object param) {

		// super.visit(node, param);

		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		System.out.print(" "+node.getOperando()+" ");
		if (node.getRight() != null)
			node.getRight().accept(this, param);

		return null;
	}

	//	class Comparativa { Expresion left;  String operando;  Expresion right; }
	public Object visit(Comparativa node, Object param) {

		// super.visit(node, param);

		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		System.out.print(" "+node.getOperando()+" ");
		if (node.getRight() != null)
			node.getRight().accept(this, param);

		return null;
	}

	//	class Logica { Expresion left;  String operando;  Expresion right; }
	public Object visit(Logica node, Object param) {

		// super.visit(node, param);

		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		System.out.print(" "+node.getOperando()+" ");
		if (node.getRight() != null)
			node.getRight().accept(this, param);

		return null;
	}

	//	class LlamadaE { Llamada invocacion; }
	public Object visit(LlamadaE node, Object param) {

		// super.visit(node, param);

		if (node.getInvocacion() != null)
			node.getInvocacion().accept(this, param);

		return null;
	}

	//	class Array { Expresion pos; }
	public Object visit(Array node, Object param) {

		// super.visit(node, param);
		System.out.print("[");
		if (node.getPos() != null)
			node.getPos().accept(this, param);
		System.out.print("]");

		return null;
	}

	//	class Llamada { String nombre;  List<Expresion> parametros; }
	public Object visit(Llamada node, Object param) {

		// super.visit(node, param);
		System.out.print(node.getNombre()+"(");
		if (node.getParametros() != null)
			for (Expresion child : node.getParametros())
				child.accept(this, param);
		System.out.print(")");
		return null;
	}
}
