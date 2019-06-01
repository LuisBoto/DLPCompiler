/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import visitor.*;

import org.antlr.v4.runtime.*;

//	compuesto:expresion -> left:expresion  right:expresion

public class AccesoStruct extends AbstractExpresion {

	public AccesoStruct(Expresion left, String right) {
		this.left = left;
		this.right = right;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(left, right);
	}

	public AccesoStruct(Object left, Object right) {
		this.left = (Expresion) ((left instanceof ParserRuleContext) ? getAST(left) : left);
		this.right = (right instanceof Token) ? ((Token)right).getText() : (String) right;

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

	public String getRight() {
		return right;
	}
	public void setRight(String right) {
		this.right = right;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expresion left;
	private String right;

	public String toString() {
       return "{left:" + getLeft() + ", right:" + getRight() + "}";
   }
}
