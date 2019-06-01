/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import visitor.*;

import org.antlr.v4.runtime.*;

//	array -> pos:expresion

public class Array extends AbstractAST  {

	public Array(Expresion pos) {
		this.pos = pos;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(pos);
	}

	public Array(Object pos) {
		this.pos = (Expresion) ((pos instanceof ParserRuleContext) ? getAST(pos) : pos);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(pos);
	}

	public Expresion getPos() {
		return pos;
	}
	public void setPos(Expresion pos) {
		this.pos = pos;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expresion pos;

	public String toString() {
       return "{pos:" + getPos() + "}";
   }
}
