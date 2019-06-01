package semantic;

import java.util.*;

import ast.*;
import main.*;
import visitor.*;

public class Identification extends DefaultVisitor {

	public Identification(ErrorManager errorManager) {
		this.errorManager = errorManager;
	}
	
	//	class Compuesto { Expresion left;  Expresion right; }
	public Object visit(AccesoStruct node, Object param) {
		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		return null;
	}
	
	//	class Identificador { Expresion var;  List<Array> dimensiones; }
	public Object visit(AccesoArray node, Object param) {
		if (node.getVar() != null)
			node.getVar().accept(this, param);
		node.getDimensiones().accept(this, param);
		return null;
	}

	// class EstructuraDef { String nombre; List<Atributo> atributos; }
	public Object visit(EstructuraDef node, Object param) {
		EstructuraDef definicion = estructuras.get(node.getNombre());
		predicado(definicion == null, "Estructura ya definida: " + node.getNombre(), node);
		estructuras.put(node.getNombre(), node);
		for (Atributo a : node.getAtributos())
			a.setEstructura(node);
		tablaSimbolos.set();
		visitChildren(node.getAtributos(), param);
		tablaSimbolos.reset();
		return null;
	}

	// class Atributo { String name; Type type; }
	public Object visit(Atributo node, Object param) {
		VarDef at = tablaSimbolos.buscaLocal(node.getName());
		predicado(at == null, "Atributo repetido: " + node.getName(), node);
		VarDef cons = new VarDef(node.getName(), node.getType());
		node.setDefinition(cons);
		tablaSimbolos.inserta(node.getName(), cons);
		if (node.getType() != null)
			node.getType().accept(this, param);
		return null;
	}

	// class CustomType { String nombre; }
	public Object visit(CustomType node, Object param) {
		EstructuraDef definicion = estructuras.get(node.getNombre());
		predicado(definicion != null, "Estructura no definida: " + node.getNombre(), node);
		node.setDefinicion(definicion); // Enlaza uso de estructura con definicion
		return null;
	}

	// class FuncionDef { String name, parametros, variables, sentencias }
	public Object visit(FuncionDef node, Object param) {
		FuncionDef definicion = funciones.get(node.getName());
		predicado(definicion == null, "Funcion ya definida: " + node.getName(), node);
		funciones.put(node.getName(), node);

		tablaSimbolos.set();
		visitChildren(node.getParametros(), param);
		if (node.getType() != null)
			node.getType().accept(this, param);

		visitChildren(node.getVariables(), param);
		visitChildren(node.getSentencias(), param);
		tablaSimbolos.reset();
		return null;
	}

	// class Parametro { String nombre; Type type; }
	public Object visit(Parametro node, Object param) {
		VarDef definicion = tablaSimbolos.buscaLocal(node.getNombre());
		predicado(definicion == null, "Parametro ya definido: " + node.getNombre(), node);
		VarDef defp = new VarDef(node.getNombre(), node.getType());
		defp.setIsParameter(true);
		defp.setParameter(node);
		tablaSimbolos.inserta(node.getNombre(), defp);
		if (node.getType() != null)
			node.getType().accept(this, param);
		return null;
	}

	// class Llamada {String name, parametros}
	public Object visit(Llamada node, Object param) {
		visitChildren(node.getParametros(), param);
		FuncionDef definicion = funciones.get(node.getNombre());
		predicado(definicion != null, "Funcion no definida: " + node.getNombre(), node);
		node.setDefinicion(definicion); // Enlaza llamada con definicion
		return null;
	}

	// class VarDef { Type type; String name; }
	public Object visit(VarDef node, Object param) {
		node.getType().accept(this, param); // No es necesario realmente

		VarDef definicion = tablaSimbolos.buscaLocal(node.getName());
		predicado(definicion == null, "Variable ya definida: " + node.getName(), node);
		tablaSimbolos.inserta(node.getName(), node);
		return null;
	}

	// class Variable { String name; }
	public Object visit(Variable node, Object param) {
		VarDef definicion = tablaSimbolos.busca(node.getName());
		//Buscar tambien en atributos de estructuras
		if (definicion == null) {
			for (EstructuraDef e : estructuras.values()) {
				for (Atributo a : e.getAtributos()) {
					if (a.getName().equals(node.getName())) {
						definicion = a.getDefinition();
					}
				}
			}
		}
		predicado(definicion != null, "Variable no definida: " + node.getName(), node);
		node.setDefinicion(definicion); // Enlazar referencia con definición
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
	 * fuente donde estaba el nodo (y así poder dar información más detallada de
	 * la posición del error). Si se usa VGen, dicho método habrá sido generado
	 * en todos los nodos del AST. No es obligatorio llamar a getStart() (ejemplo
	 * 2), ya que si se pasa el nodo, se usará por defecto dicha posición. Si no
	 * se quiere imprimir la posición del fichero, se puede omitir el tercer
	 * argumento (ejemplo 3).
	 *
	 * @param condicion     Debe cumplirse para que no se produzca un error
	 * @param mensajeError  Se imprime si no se cumple la condición
	 * @param posicionError Fila y columna del fichero donde se ha producido el
	 *                      error.
	 */
	private void predicado(boolean condicion, String mensajeError, Position posicionError) {
		if (!condicion)
			errorManager.notify("Identification", mensajeError, posicionError);
	}

	private void predicado(boolean condicion, String mensajeError, AST node) {
		predicado(condicion, mensajeError, node.getStart());
	}

	private void predicado(boolean condicion, String mensajeError) {
		predicado(condicion, mensajeError, (Position) null);
	}

	private ErrorManager errorManager;
	// private Map<String, VarDef> variables = new HashMap<String, VarDef>();
	private TablaSimbolos tablaSimbolos = new TablaSimbolos();
	private Map<String, FuncionDef> funciones = new HashMap<String, FuncionDef>();
	private Map<String, EstructuraDef> estructuras = new HashMap<String, EstructuraDef>();

}
