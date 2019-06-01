/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import visitor.*;

import org.antlr.v4.runtime.*;

//	comparativa:expresion -> left:expresion  operando:String  right:expresion

public class Comparativa extends AbstractExpresion {

	public Comparativa(Expresion left, String operando, Expresion right) {
		this.left = left;
		this.operando = operando;
		this.right = right;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(left, right);
	}

	public Comparativa(Object left, Object operando, Object right) {
		this.left = (Expresion) ((left instanceof ParserRuleContext) ? getAST(left) : left);
		this.operando = (operando instanceof Token) ? ((Token)operando).getText() : (String) operando;
		this.right = (Expresion) ((right instanceof ParserRuleContext) ? getAST(right) : right);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(left, operando, right);
	}

	public Expresion getLeft() {
		return left;
	}
	public void setLeft(Expresion left) {
		this.left = left;
	}

	public String getOperando() {
		return operando;
	}
	public void setOperando(String operando) {
		this.operando = operando;
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
	private String operando;
	private Expresion right;

	public String toString() {
       return "{left:" + getLeft() + ", operando:" + getOperando() + ", right:" + getRight() + "}";
   }
}
