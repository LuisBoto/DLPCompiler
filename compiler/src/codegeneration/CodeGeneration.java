package codegeneration;

import java.io.*;

import ast.*;

/**
 * Esta clase coordina las dos fases principales de la Generación de Código:
 *  1. Gestión de Memoria (asignación de direcciones).
 *  2. Selección de Código.
 *
 * No es necesario modificar esta clase. En su lugar hay que modificar las clases
 * que son llamadas desde aquí: "MemoryAllocation.java" y "CodeSelection.java".
 *
 * @author Raúl Izquierdo
 *
 */
public class CodeGeneration {

    public void generate(String sourceFile, AST ast, Writer out) {
        MemoryAllocation allocator = new MemoryAllocation();
        ast.accept(allocator, null);

        CodeSelection selector = new CodeSelection(out, sourceFile);
        ast.accept(selector, null);
    }

}
