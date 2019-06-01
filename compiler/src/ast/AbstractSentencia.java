/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

public abstract class AbstractSentencia extends AbstractAST implements Sentencia {
	
	private FuncionDef inFunc;
	
	public FuncionDef getInFunc() {
		return this.inFunc;
	}
	
	public void setInFunc(FuncionDef f) {
		this.inFunc = f;
	}

}
