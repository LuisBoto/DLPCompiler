package semantic;

import ast.AST;
import ast.Aritmetica;
import ast.Array;
import ast.ArrayType;
import ast.Assign;
import ast.Atributo;
import ast.Caracter;
import ast.Casting;
import ast.CharType;
import ast.Comparativa;
import ast.AccesoStruct;
import ast.CustomType;
import ast.EstructuraDef;
import ast.FuncionDef;
import ast.AccesoArray;
import ast.IfDef;
import ast.IntType;
import ast.Integral;
import ast.Llamada;
import ast.LlamadaE;
import ast.Logica;
import ast.Parametro;
import ast.Parentesis;
import ast.Position;
import ast.Print;
import ast.Read;
import ast.Real;
import ast.RealType;
import ast.ReturnSent;
import ast.Sentencia;
import ast.Type;
import ast.Variable;
import ast.Whileloop;
import main.ErrorManager;
import visitor.DefaultVisitor;

public class TypeChecking extends DefaultVisitor {

	public TypeChecking(ErrorManager errorManager) {
		this.errorManager = errorManager;
	}

	// class FuncionDef { String name; List<Parametro> parametros; Type type;
	// List<VarDef> variables; List<Sentencia> sentencias; }
	public Object visit(FuncionDef node, Object param) {
		visitChildren(node.getParametros(), param);
		if (node.getType() != null)
			node.getType().accept(this, param);
		for (Sentencia s : node.getSentencias())
			s.setInFunc(node);
		visitChildren(node.getVariables(), param);
		visitChildren(node.getSentencias(), param);
		isTipoSimple(node.getType(), "El tipo de la funcion no es simple", node);
		return null;
	}

	// class Parametro { String nombre; Type type; }
	public Object visit(Parametro node, Object param) {
		if (node.getType() != null)
			node.getType().accept(this, param);
		isTipoSimple(node.getType(), "El parametro no es de tipo simple: " + node.getNombre(), node);
		return null;
	}

	// class Read { Expresion value; }
	public Object visit(Read node, Object param) {
		if (node.getValue() != null)
			node.getValue().accept(this, param);
		isTipoSimple(node.getValue().getType(), "Tipo del read debe ser simple: " + node.getValue().getType(), node);
		predicado(node.getValue().isModificable(), "Variable de read debe ser modificable", node);
		return null;
	}

	// class Print { Expresion value; }
	public Object visit(Print node, Object param) {
		if (node.getValue() != null)
			node.getValue().accept(this, param);
		predicado(node.getValue().getType() != null, "Tipo del print no puede ser void", node);

		if (node.getValue().getType() instanceof ArrayType) {
			predicado(((ArrayType) node.getValue().getType()).getType() instanceof CharType,
					"Array a imprimir no es de char", node);
		} else {
			isTipoSimple(node.getValue().getType(), "Tipo del print debe ser simple: " + node.getValue().getType(),
					node);
		}
		return null;
	}

	// class Assign { Expresion left; Expresion right; }
	public Object visit(Assign node, Object param) {
		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		if (node.getRight() != null)
			node.getRight().accept(this, param);
		predicado(mismoTipo(node.getLeft().getType(), node.getRight().getType()),
				"Los operandos deben ser del mismo tipo: " + node.getLeft().getType() + node.getRight().getType(),
				node);
		if (node.getLeft().getType() instanceof ArrayType) {
			boolean left = ((ArrayType) node.getLeft().getType()).getType() instanceof CharType;
			boolean right = ((ArrayType) node.getRight().getType()).getType() instanceof CharType;
			predicado(left, "Array de destino no es de char", node);
			predicado(right, "Array origen no es de char", node);
			// Comprobamos que array origen tiene ncaracteres mayor o igual al destino
			if (left && right) {
				boolean caracteres = ((ArrayType) node.getLeft().getType())
						.getTamaño() <= ((ArrayType) node.getRight().getType()).getTamaño();
				predicado(caracteres, "Array origen debe tener ncaracteres superior o igual a destino", node);
			}
		} else {
			isTipoSimple(node.getLeft().getType(), "Los operandos deben ser tipos simples: " + node.getLeft().getType(),
					node);
		}
		predicado(node.getLeft().isModificable(), "El operando izquierdo de asignacion debe ser modificable", node);
		return null;
	}

	// class Whileloop { Expresion condicion; List<Sentencia> sentencias; }
	public Object visit(Whileloop node, Object param) {
		if (node.getCondicion() != null)
			node.getCondicion().accept(this, param);
		visitChildren(node.getSentencias(), param);
		predicado(node.getCondicion().getType() instanceof IntType, "La condicion de bucle debe ser de tipo entero",
				node);
		for (Sentencia s : node.getSentencias())
			s.setInFunc(node.getInFunc());
		return null;
	}

	// class IfDef { Expresion condicion; List<Sentencia> iftrue; List<Sentencia>
	// iffalse; }
	public Object visit(IfDef node, Object param) {
		if (node.getCondicion() != null)
			node.getCondicion().accept(this, param);
		predicado(node.getCondicion().getType() instanceof IntType, "La condicion de bucle debe ser de tipo entero",
				node);
		for (Sentencia s : node.getIftrue())
			s.setInFunc(node.getInFunc());
		if (node.getIffalse() != null)
			for (Sentencia s : node.getIffalse())
				s.setInFunc(node.getInFunc());
		visitChildren(node.getIftrue(), param);
		visitChildren(node.getIffalse(), param);
		return null;
	}

	// class ReturnSent { Expresion retorno; }
	public Object visit(ReturnSent node, Object param) {
		if (node.getRetorno() != null)
			node.getRetorno().accept(this, param);
		if (node.getInFunc().getType() == null)
			predicado(node.getRetorno() == null, "No puede retornarse un valor en una funcion sin retorno", node);
		else {
			predicado(node.getRetorno() != null, "Debe haber un valor de retorno", node);
			if (node.getRetorno() != null)
				predicado(mismoTipo(node.getInFunc().getType(), node.getRetorno().getType()),
						"El tipo de retorno y de la funcion no coinciden", node);
		}
		return null;
	}

	// class Array { Expresion pos; }
	public Object visit(Array node, Object param) {
		if (node.getPos() != null)
			node.getPos().accept(this, param);
		predicado(node.getPos().getType() instanceof IntType, "La posicion no es un entero: " + node.getPos().getType(),
				node);
		return null;
	}

	// class Integral { String valor; }
	public Object visit(Integral node, Object param) {
		node.setType(new IntType());
		node.setModificable(false);
		return null;
	}

	// class Real { String valor; }
	public Object visit(Real node, Object param) {
		node.setType(new RealType());
		node.setModificable(false);
		return null;
	}

	// class Caracter { String valor; }
	public Object visit(Caracter node, Object param) {
		node.setType(new CharType());
		node.setModificable(false);
		return null;
	}

	// class ArrayType { Expresion size; Type type; }
	public Object visit(ArrayType node, Object param) {
		if (node.getSize() != null)
			node.getSize().accept(this, param);
		if (node.getType() != null)
			node.getType().accept(this, param);
		predicado(node.getSize().getType() instanceof IntType,
				"La posicion no es un entero: " + node.getSize().getType(), node);
		return null;
	}

	// class Identificador { Expresion var; List<Array> dimensiones; }
	public Object visit(AccesoArray node, Object param) {
		if (node.getVar() != null)
			node.getVar().accept(this, param);
		node.getDimensiones().accept(this, param);
		predicado(node.getVar().getType() instanceof ArrayType,
				"La variable no es de tipo array: " + node.getVar().getType(), node);

		if (node.getVar().getType() instanceof ArrayType) {
			ArrayType v = (ArrayType) node.getVar().getType();
			node.setType(v.getType());
			node.setModificable(true);
		} else {
			node.setType(node.getVar().getType());
			node.setModificable(node.getVar().isModificable());
		}
		return null;
	}

	// class Parentesis { Expresion contenido; }
	public Object visit(Parentesis node, Object param) {
		if (node.getContenido() != null)
			node.getContenido().accept(this, param);
		node.setType(node.getContenido().getType());
		node.setModificable(node.getContenido().isModificable());
		return null;
	}

	// class Variable { String name; }
	public Object visit(Variable node, Object param) {
		node.setType(node.getDefinicion().getType());
		node.setModificable(true);
		return null;
	}

	// class Compuesto { Expresion left; Expresion right; }
	public Object visit(AccesoStruct node, Object param) {
		super.visit(node, param);
		predicado(node.getLeft().getType() instanceof CustomType, "El valor izquierdo debe ser una estructura", node);

		if (node.getLeft().getType() instanceof CustomType) {
			boolean existe = false;
			EstructuraDef defStruct = ((CustomType) node.getLeft().getType()).getDefinicion();
			for (Atributo a : defStruct.getAtributos()) {
				if (a.getName().equals(node.getRight())) {
					node.setType(a.getType());
					existe = true;
					break;
				}
			}

			predicado(existe, "Campo no existe en estructura: " + node.getRight(), node);
		} else {
			node.setType(node.getLeft().getType());
		}
		node.setModificable(true);
		return null;
	}

	// class Llamada { String nombre; List<Expresion> parametros; }
	public Object visit(Llamada node, Object param) {
		visitChildren(node.getParametros(), param);
		predicado(node.getParametros().size() == node.getDefinicion().getParametros().size(),
				"El numero de parametros no coincide: " + node.getNombre(), node);
		if (node.getParametros().size() == node.getDefinicion().getParametros().size())
			for (int i = 0; i < node.getParametros().size(); i++) {
				Type paramt = node.getParametros().get(i).getType();
				Type deft = node.getDefinicion().getParametros().get(i).getType();
				predicado(mismoTipo(paramt, deft), "El tipo del parametro es incorrecto: " + paramt, node);
			}
		return null;
	}

	// class Casting { Type tipo; Expresion contenido; }
	public Object visit(Casting node, Object param) {
		if (node.getTipo() != null)
			node.getTipo().accept(this, param);
		if (node.getContenido() != null)
			node.getContenido().accept(this, param);
		isTipoSimple(node.getTipo(), "El tipo del cast debe ser simple: " + node.getTipo(), node);
		isTipoSimple(node.getContenido().getType(),
				"El tipo del contenido de un cast debe ser simple: " + node.getContenido().getType(), node);
		predicado(!mismoTipo(node.getContenido().getType(), node.getTipo()),
				"El tipo del cast y del contenido deben ser distintos", node);
		node.setType(node.getTipo());
		node.setModificable(node.getContenido().isModificable());
		return null;
	}

	// class Aritmetica { Expresion left; String operando; Expresion right; }
	public Object visit(Aritmetica node, Object param) {
		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		if (node.getRight() != null)
			node.getRight().accept(this, param);
		isTipoSimple(node.getLeft().getType(), "Operandos de operacion deben ser simples", node);
		predicado(mismoTipo(node.getRight().getType(), node.getLeft().getType()), "Tipo de operandos debe ser igual",
				node);
		node.setType(node.getLeft().getType());
		node.setModificable(false);
		return null;
	}

	// class Comparativa { Expresion left; String operando; Expresion right; }
	public Object visit(Comparativa node, Object param) {
		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		if (node.getRight() != null)
			node.getRight().accept(this, param);
		predicado(mismoTipo(node.getLeft().getType(), node.getRight().getType()),
				"Los operandos deben ser del mismo tipo: " + node.getLeft().getType() + node.getRight().getType(),
				node);
		isTipoSimple(node.getLeft().getType(), "Los operandos deben ser tipos simples: " + node.getLeft().getType(),
				node);
		node.setType(new IntType());
		node.setModificable(false);
		return null;
	}

	// class Logica { Expresion left; String operando; Expresion right; }
	public Object visit(Logica node, Object param) {
		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		if (node.getRight() != null)
			node.getRight().accept(this, param);
		predicado(mismoTipo(node.getLeft().getType(), node.getRight().getType()),
				"Los operandos deben ser del mismo tipo: " + node.getLeft().getType() + node.getRight().getType(),
				node);
		predicado(node.getLeft().getType() instanceof IntType,
				"Los operandos deben ser de tipo entero: " + node.getLeft().getType(), node);
		node.setType(new IntType());
		node.setModificable(false);
		return null;
	}

	// class LlamadaE { Llamada invocacion; }
	public Object visit(LlamadaE node, Object param) {
		if (node.getInvocacion() != null)
			node.getInvocacion().accept(this, param);
		predicado(node.getInvocacion().getDefinicion().getType() != null, "La funcion debe tener un tipo de retorno",
				node);
		node.setType(node.getInvocacion().getDefinicion().getType());
		node.setModificable(false);
		return null;
	}

	/**
	 * predicado. Método auxiliar para implementar los predicados. Borrar si no se
	 * quiere usar.
	 *
	 * Ejemplos de uso (suponiendo que existe un método "esPrimitivo"):
	 *
	 * 1. predicado(esPrimitivo(expr.tipo), "La expresión debe ser de un tipo
	 * pimitivo", expr.getStart()); 2. predicado(esPrimitivo(expr.tipo), "La
	 * expresión debe ser de un tipo pimitivo", expr); 3.
	 * predicado(esPrimitivo(expr.tipo), "La expresión debe ser de un tipo
	 * primitivo");
	 *
	 * NOTA: El método getStart() (ejemplo 1) indica la linea/columna del fichero
	 * fuente donde estaba el nodo (y así poder dar información más detallada de la
	 * posición del error). Si se usa VGen, dicho método habrá sido generado en
	 * todos los nodos del AST. No es obligatorio llamar a getStart() (ejemplo 2),
	 * ya que si se pasa el nodo, se usará por defecto dicha posición. Si no se
	 * quiere imprimir la posición del fichero, se puede omitir el tercer argumento
	 * (ejemplo 3).
	 *
	 * @param condicion
	 *            Debe cumplirse para que no se produzca un error
	 * @param mensajeError
	 *            Se imprime si no se cumple la condición
	 * @param posicionError
	 *            Fila y columna del fichero donde se ha producido el error.
	 */
	private void predicado(boolean condicion, String mensajeError, Position posicionError) {
		if (!condicion)
			errorManager.notify("Comprobacion de tipos", mensajeError, posicionError);
	}

	private void predicado(boolean condicion, String mensajeError, AST node) {
		predicado(condicion, mensajeError, node.getStart());
	}

	private void predicado(boolean condicion, String mensajeError) {
		predicado(condicion, mensajeError, (Position) null);
	}

	private void isTipoSimple(Type tipo, String mensaje, AST node) {
		boolean simple = tipo instanceof IntType || tipo instanceof RealType || tipo instanceof CharType
				|| tipo == null;
		predicado(simple, mensaje, node);
	}

	private boolean isSimple(Type tipo) {
		return tipo instanceof IntType || tipo instanceof RealType || tipo instanceof CharType || tipo == null;
	}

	private boolean mismoTipo(Type tipo1, Type tipo2) {
		return tipo1.getClass().equals(tipo2.getClass());
	}

	private ErrorManager errorManager;
}
