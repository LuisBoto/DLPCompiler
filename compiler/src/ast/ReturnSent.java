/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import visitor.*;

import org.antlr.v4.runtime.*;

//	returnSent:sentencia -> retorno:expresion

public class ReturnSent extends AbstractSentencia {

	public ReturnSent(Expresion retorno) {
		this.retorno = retorno;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(retorno);
	}

	public ReturnSent(Object retorno) {
		this.retorno = (Expresion) ((retorno instanceof ParserRuleContext) ? getAST(retorno) : retorno);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(retorno);
	}

	public Expresion getRetorno() {
		return retorno;
	}
	public void setRetorno(Expresion retorno) {
		this.retorno = retorno;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expresion retorno;

	public String toString() {
       return "{retorno:" + getRetorno() + "}";
   }
}
