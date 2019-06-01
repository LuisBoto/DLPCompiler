/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import visitor.*;

import org.antlr.v4.runtime.*;

//	arrayType:type -> size:expresion  type:type

public class ArrayType extends AbstractType {

	public ArrayType(Expresion size, Type type) {
		this.size = size;
		this.type = type;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(size, type);
	}

	public ArrayType(Object size, Object type) {
		this.size = (Expresion) ((size instanceof ParserRuleContext) ? getAST(size) : size);
		this.type = (Type) ((type instanceof ParserRuleContext) ? getAST(type) : type);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(size, type);
	}

	public Expresion getSize() {
		return size;
	}
	public void setSize(Expresion size) {
		this.size = size;
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

	private Expresion size;
	private Type type;

	public String toString() {
       return "{size:" + getSize() + ", type:" + getType() + "}";
   }
}
