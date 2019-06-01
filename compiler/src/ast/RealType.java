/**
 * @generated VGen (for ANTLR) 1.5.0
 */

package ast;

import visitor.*;

import org.antlr.v4.runtime.*;

//	realType:type ->

public class RealType extends AbstractType {

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    public String toString() {
        return "{RealType}";
    }

    public int getTamaño() {
        return 4;
    }
    
    @Override
    public String getSuffix() {
    	return "F";
    }

	@Override
	public String getMAPLName() {
		return "float";
	}

}
