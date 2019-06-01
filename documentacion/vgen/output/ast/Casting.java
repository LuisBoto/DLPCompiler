/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import visitor.*;

import org.antlr.v4.runtime.*;

//	casting:expresion -> tipo:type  contenido:expresion

public class Casting extends AbstractExpresion {

	public Casting(Type tipo, Expresion contenido) {
		this.tipo = tipo;
		this.contenido = contenido;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(tipo, contenido);
	}

	public Casting(Object tipo, Object contenido) {
		this.tipo = (Type) ((tipo instanceof ParserRuleContext) ? getAST(tipo) : tipo);
		this.contenido = (Expresion) ((contenido instanceof ParserRuleContext) ? getAST(contenido) : contenido);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(tipo, contenido);
	}

	public Type getTipo() {
		return tipo;
	}
	public void setTipo(Type tipo) {
		this.tipo = tipo;
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

	private Type tipo;
	private Expresion contenido;

	public String toString() {
       return "{tipo:" + getTipo() + ", contenido:" + getContenido() + "}";
   }
}
