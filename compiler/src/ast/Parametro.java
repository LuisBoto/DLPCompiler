/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import visitor.*;

import org.antlr.v4.runtime.*;

//	parametro -> nombre:String  type:type

public class Parametro extends AbstractAST {

	public Parametro(String nombre, Type type) {
		this.nombre = nombre;
		this.type = type;

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(type);
	}

	public Parametro(Object nombre, Object type) {
		this.nombre = (nombre instanceof Token) ? ((Token) nombre).getText() : (String) nombre;
		this.type = (Type) ((type instanceof ParserRuleContext) ? getAST(type) : type);

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(nombre, type);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

	private String nombre;
	private Type type;

	public String toString() {
		return "{nombre:" + getNombre() + ", type:" + getType() + "}";
	}

	public int getAddress() {
		return address;
	}

	public void setAddress(int address) {
		this.address = address;
	}

	private int address;
}
