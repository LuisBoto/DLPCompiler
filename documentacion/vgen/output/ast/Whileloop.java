/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import java.util.*;
import visitor.*;

import org.antlr.v4.runtime.*;

//	whileloop:sentencia -> condicion:expresion  sentencias:sentencia*

public class Whileloop extends AbstractSentencia {

	public Whileloop(Expresion condicion, List<Sentencia> sentencias) {
		this.condicion = condicion;
		this.sentencias = sentencias;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(condicion, sentencias);
	}

	@SuppressWarnings("unchecked")
	public Whileloop(Object condicion, Object sentencias) {
		this.condicion = (Expresion) ((condicion instanceof ParserRuleContext) ? getAST(condicion) : condicion);
		this.sentencias = (List<Sentencia>) sentencias;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(condicion, sentencias);
	}

	public Expresion getCondicion() {
		return condicion;
	}
	public void setCondicion(Expresion condicion) {
		this.condicion = condicion;
	}

	public List<Sentencia> getSentencias() {
		return sentencias;
	}
	public void setSentencias(List<Sentencia> sentencias) {
		this.sentencias = sentencias;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expresion condicion;
	private List<Sentencia> sentencias;

	public String toString() {
       return "{condicion:" + getCondicion() + ", sentencias:" + getSentencias() + "}";
   }
}
