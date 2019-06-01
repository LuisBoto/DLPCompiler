/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import java.util.*;
import visitor.*;

import org.antlr.v4.runtime.*;

//	funcionDef:bloque -> name:String  parametros:parametro*  type:type  variables:varDef*  sentencias:sentencia*

public class FuncionDef extends AbstractBloque {

	public FuncionDef(String name, List<Parametro> parametros, Type type, List<VarDef> variables, List<Sentencia> sentencias) {
		this.name = name;
		this.parametros = parametros;
		this.type = type;
		this.variables = variables;
		this.sentencias = sentencias;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(parametros, type, variables, sentencias);
	}

	@SuppressWarnings("unchecked")
	public FuncionDef(Object name, Object parametros, Object type, Object variables, Object sentencias) {
		this.name = (name instanceof Token) ? ((Token)name).getText() : (String) name;
		this.parametros = (List<Parametro>) parametros;
		this.type = (Type) ((type instanceof ParserRuleContext) ? getAST(type) : type);
		this.variables = (List<VarDef>) variables;
		this.sentencias = (List<Sentencia>) sentencias;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(name, parametros, type, variables, sentencias);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<Parametro> getParametros() {
		return parametros;
	}
	public void setParametros(List<Parametro> parametros) {
		this.parametros = parametros;
	}

	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}

	public List<VarDef> getVariables() {
		return variables;
	}
	public void setVariables(List<VarDef> variables) {
		this.variables = variables;
	}

	public List<Sentencia> getSentencias() {
		return sentencias;
	}
	public void setSentencias(List<Sentencia> sentencias) {
		this.sentencias = sentencias;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String name;
	private List<Parametro> parametros;
	private Type type;
	private List<VarDef> variables;
	private List<Sentencia> sentencias;

	public String toString() {
       return "{name:" + getName() + ", parametros:" + getParametros() + ", type:" + getType() + ", variables:" + getVariables() + ", sentencias:" + getSentencias() + "}";
   }
}
