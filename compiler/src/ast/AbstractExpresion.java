/**
 * @generated VGen (for ANTLR) 1.5.0
 */

package ast;

public abstract class AbstractExpresion extends AbstractAST implements Expresion {
    public void setType(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setModificable(boolean modificable) {
        this.modificable = modificable;
    }

    public boolean isModificable() {
        return modificable;
    }

    private Type type;
    private boolean modificable;
}
