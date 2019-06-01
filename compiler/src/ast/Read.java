/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import visitor.*;

import org.antlr.v4.runtime.*;

//	read:sentencia -> value:expresion

public class Read extends AbstractSentencia {

	public Read(Expresion value) {
		this.value = value;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(value);
	}

	public Read(Object value) {
		this.value = (Expresion) ((value instanceof ParserRuleContext) ? getAST(value) : value);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(value);
	}

	public Expresion getValue() {
		return value;
	}
	public void setValue(Expresion value) {
		this.value = value;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expresion value;

	public String toString() {
       return "{value:" + getValue() + "}";
   }
}
