/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package visitor;

import ast.*;

public interface Visitor {
	public Object visit(Program node, Object param);
	public Object visit(VarDef node, Object param);
	public Object visit(EstructuraDef node, Object param);
	public Object visit(FuncionDef node, Object param);
	public Object visit(Atributo node, Object param);
	public Object visit(Parametro node, Object param);
	public Object visit(IntType node, Object param);
	public Object visit(RealType node, Object param);
	public Object visit(CharType node, Object param);
	public Object visit(ArrayType node, Object param);
	public Object visit(CustomType node, Object param);
	public Object visit(Read node, Object param);
	public Object visit(Print node, Object param);
	public Object visit(Assign node, Object param);
	public Object visit(Whileloop node, Object param);
	public Object visit(IfDef node, Object param);
	public Object visit(ReturnSent node, Object param);
	public Object visit(LlamadaS node, Object param);
	public Object visit(Variable node, Object param);
	public Object visit(Compuesto node, Object param);
	public Object visit(Integral node, Object param);
	public Object visit(Real node, Object param);
	public Object visit(Caracter node, Object param);
	public Object visit(Identificador node, Object param);
	public Object visit(Parentesis node, Object param);
	public Object visit(Casting node, Object param);
	public Object visit(Aritmetica node, Object param);
	public Object visit(Comparativa node, Object param);
	public Object visit(Logica node, Object param);
	public Object visit(LlamadaE node, Object param);
	public Object visit(Array node, Object param);
	public Object visit(Llamada node, Object param);
}
