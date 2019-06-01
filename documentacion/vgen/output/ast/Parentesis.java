/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import visitor.*;

import org.antlr.v4.runtime.*;

//	parentesis:expresion -> contenido:expresion

public class Parentesis extends AbstractExpresion {

	public Parentesis(Expresion contenido) {
		this.contenido = contenido;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(contenido);
	}

	public Parentesis(Object contenido) {
		this.contenido = (Expresion) ((contenido instanceof ParserRuleContext) ? getAST(contenido) : contenido);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(contenido);
	}

	public Expresion getContenido() {
		return contenido;
	}
	public void setContenido(Expresion contenido) {
		this.contenido = contenido;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expresion contenido;

	public String toString() {
       return "{contenido:" + getContenido() + "}";
   }
}
