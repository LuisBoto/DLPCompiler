/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import visitor.*;

import org.antlr.v4.runtime.*;

//	compuesto:expresion -> left:expresion  right:expresion

public class Compuesto extends AbstractExpresion {

	public Compuesto(Expresion left, Expresion right) {
		this.left = left;
		this.right = right;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(left, right);
	}

	public Compuesto(Object left, Object right) {
		this.left = (Expresion) ((left instanceof ParserRuleContext) ? getAST(left) : left);
		this.right = (Expresion) ((right instanceof ParserRuleContext) ? getAST(right) : right);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(left, right);
	}

	public Expresion getLeft() {
		return left;
	}
	public void setLeft(Expresion left) {
		this.left = left;
	}

	public Expresion getRight() {
		return right;
	}
	public void setRight(Expresion right) {
		this.right = right;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expresion left;
	private Expresion right;

	public String toString() {
       return "{left:" + getLeft() + ", right:" + getRight() + "}";
   }
}
