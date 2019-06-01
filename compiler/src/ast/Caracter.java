/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import visitor.*;

import org.antlr.v4.runtime.*;

//	caracter:expresion -> valor:String

public class Caracter extends AbstractExpresion {

	public Caracter(String valor) {
		this.valor = valor;
	}

	public Caracter(Object valor) {
		this.valor = (valor instanceof Token) ? ((Token)valor).getText() : (String) valor;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(valor);
	}

	public String getValor() {
		return valor;
	}
	
	public char getCaracter() {
		//Retiramos las comillas
		String val = this.valor;
		val = val.substring(1);
		val = val.substring(0, val.length()-1);
		//Devolvemos el caracter
		if (val.length()>1) {
			return (char)10;	
		}
		return val.toCharArray()[0];	
	}
	
	public void setValor(String valor) {
		this.valor = valor;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String valor;

	public String toString() {
       return "{valor:" + getValor() + "}";
   }
}
