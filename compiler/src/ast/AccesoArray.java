/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import java.util.*;
import visitor.*;

import org.antlr.v4.runtime.*;

//	identificador:expresion -> var:expresion  dimensiones:array*

public class AccesoArray extends AbstractExpresion {

	public AccesoArray(Expresion var, Array dimensiones) {
		this.var = var;
		this.dimensiones = dimensiones;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(var, dimensiones);
	}

	@SuppressWarnings("unchecked")
	public AccesoArray(Object var, Object dimensiones) {
		this.var = (Expresion) ((var instanceof ParserRuleContext) ? getAST(var) : var);
		this.dimensiones = (Array) dimensiones;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(var, dimensiones);
	}

	public Expresion getVar() {
		return var;
	}
	public void setVar(Expresion var) {
		this.var = var;
	}

	public Array getDimensiones() {
		return dimensiones;
	}
	public void setDimensiones(Array dimensiones) {
		this.dimensiones = dimensiones;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expresion var;
	private Array dimensiones;

	public String toString() {
       return "{var:" + getVar() + ", dimensiones:" + getDimensiones() + "}";
   }
}
