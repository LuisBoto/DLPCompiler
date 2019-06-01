package semantic;

import main.*;
import ast.*;

/**
 * Esta clase coordina las dos fases del Análisis Semántico:
 *  1. Fase de Identificación.
 *  2. Fase de Comprobación de Tipos (Type Checking).
 *
 * No es necesario modificar esta clase. En su lugar hay que modificar las clases
 * que son llamadas desde aquí: "Identification.java" y "TypeChecking.java"
 *
 * @author Raúl Izquierdo
 *
 */
public class SemanticAnalisys {

    public SemanticAnalisys(ErrorManager errorManager) {
        this.errorManager = errorManager;
    }

    public void analize(AST ast) {
        Identification identification = new Identification(errorManager);
        ast.accept(identification, null);

        if (errorManager.errorsCount() > 0)
            return;

        TypeChecking checking = new TypeChecking(errorManager);
        ast.accept(checking, null);
    }

    private ErrorManager errorManager;
}
