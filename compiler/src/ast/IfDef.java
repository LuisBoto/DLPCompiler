/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import java.util.*;
import visitor.*;

import org.antlr.v4.runtime.*;

//	ifDef:sentencia -> condicion:expresion  iftrue:sentencia*  iffalse:sentencia*

public class IfDef extends AbstractSentencia {

	public IfDef(Expresion condicion, List<Sentencia> iftrue, List<Sentencia> iffalse) {
		this.condicion = condicion;
		this.iftrue = iftrue;
		this.iffalse = iffalse;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(condicion, iftrue, iffalse);
	}

	@SuppressWarnings("unchecked")
	public IfDef(Object condicion, Object iftrue, Object iffalse) {
		this.condicion = (Expresion) ((condicion instanceof ParserRuleContext) ? getAST(condicion) : condicion);
		this.iftrue = (List<Sentencia>) iftrue;
		this.iffalse = (List<Sentencia>) iffalse;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(condicion, iftrue, iffalse);
	}

	public Expresion getCondicion() {
		return condicion;
	}
	public void setCondicion(Expresion condicion) {
		this.condicion = condicion;
	}

	public List<Sentencia> getIftrue() {
		return iftrue;
	}
	public void setIftrue(List<Sentencia> iftrue) {
		this.iftrue = iftrue;
	}

	public List<Sentencia> getIffalse() {
		return iffalse;
	}
	public void setIffalse(List<Sentencia> iffalse) {
		this.iffalse = iffalse;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expresion condicion;
	private List<Sentencia> iftrue;
	private List<Sentencia> iffalse;

	public String toString() {
       return "{condicion:" + getCondicion() + ", iftrue:" + getIftrue() + ", iffalse:" + getIffalse() + "}";
   }
}
