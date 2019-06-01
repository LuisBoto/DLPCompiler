package codegeneration;

import java.util.List;

import ast.*;
import visitor.*;

/**
 * Clase encargada de asignar direcciones a las variables.
 */
public class MemoryAllocation extends DefaultVisitor {

    /*
     * Poner aquí los visit necesarios. Si se ha usado VGen, solo hay que copiarlos
     * de la clase 'visitor/_PlantillaParaVisitors.txt'.
     */

	// class Programa { List<DefVariable> definiciones; List<Sentencia> sentencias; }
    public Object visit(Program node, Object param) {

        int currentAddress = 0;
    
        for (Bloque child : node.getBloque()) {
        	if (child instanceof VarDef) {
        		((VarDef)child).setAddress(currentAddress);
        		currentAddress += ((VarDef)child).getType().getTamaño(); 
            }
        	
        	if (child instanceof EstructuraDef) {
        		int resAddress = 0;
        		for (Atributo a: ((EstructuraDef)child).getAtributos()) {
        			a.setAddress(resAddress);
            		resAddress += a.getType().getTamaño(); 
        		}
            }
        	
        	if(child instanceof FuncionDef) {
        		List<Parametro> params = ((FuncionDef)child).getParametros();
        		for (int i = 0; i<params.size(); i++) {
        			int dir = 4;
        			for (int j=i+1; j<params.size(); j++)
        				dir += params.get(j).getType().getTamaño();
        			params.get(i).setAddress(dir); //BP+dir
        		}        	
        		List<VarDef> vars = ((FuncionDef)child).getVariables();
        		int funAddress = 0;
        		for (VarDef v : vars) {
        			int dir = funAddress+v.getType().getTamaño();
        			v.setAddress(-dir); //BP-dir
        			funAddress+= v.getType().getTamaño();
        		}
        	}
        }
        return null;
    }
   
}
