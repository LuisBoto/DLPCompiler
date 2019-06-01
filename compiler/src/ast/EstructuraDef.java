/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import java.util.*;
import visitor.*;

import org.antlr.v4.runtime.*;

//	estructuraDef:bloque -> nombre:String  atributos:atributo*

public class EstructuraDef extends AbstractBloque {

	public EstructuraDef(String nombre, List<Atributo> atributos) {
		this.nombre = nombre;
		this.atributos = atributos;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(atributos);
	}

	@SuppressWarnings("unchecked")
	public EstructuraDef(Object nombre, Object atributos) {
		this.nombre = (nombre instanceof Token) ? ((Token)nombre).getText() : (String) nombre;
		this.atributos = (List<Atributo>) atributos;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(nombre, atributos);
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Atributo> getAtributos() {
		return atributos;
	}
	public void setAtributos(List<Atributo> atributos) {
		this.atributos = atributos;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String nombre;
	private List<Atributo> atributos;

	public String toString() {
       return "{nombre:" + getNombre() + ", atributos:" + getAtributos() + "}";
   }

	public Atributo encuentraAtributo(String right) {
		for (Atributo a : this.atributos)
			if (a.getName().equals(right))
				return a;
		return null;
	}
}
