/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import visitor.*;

import org.antlr.v4.runtime.*;

//	llamadaS:sentencia -> invocacion:llamada

public class LlamadaS extends AbstractSentencia {

	public LlamadaS(Llamada invocacion) {
		this.invocacion = invocacion;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(invocacion);
	}

	public LlamadaS(Object invocacion) {
		this.invocacion = (Llamada) ((invocacion instanceof ParserRuleContext) ? getAST(invocacion) : invocacion);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(invocacion);
	}

	public Llamada getInvocacion() {
		return invocacion;
	}
	public void setInvocacion(Llamada invocacion) {
		this.invocacion = invocacion;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Llamada invocacion;

	public String toString() {
       return "{invocacion:" + getInvocacion() + "}";
   }
}
