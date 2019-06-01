/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import java.util.*;
import visitor.*;

import org.antlr.v4.runtime.*;

//	program -> bloque:bloque*

public class Program extends AbstractAST  {

	public Program(List<Bloque> bloque) {
		this.bloque = bloque;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(bloque);
	}

	@SuppressWarnings("unchecked")
	public Program(Object bloque) {
		this.bloque = (List<Bloque>) bloque;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(bloque);
	}

	public List<Bloque> getBloque() {
		return bloque;
	}
	public void setBloque(List<Bloque> bloque) {
		this.bloque = bloque;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private List<Bloque> bloque;

	public String toString() {
       return "{bloque:" + getBloque() + "}";
   }
}
