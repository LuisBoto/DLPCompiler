package main;

import java.io.*;

import ast.*;
import visitor.*;

import parser.*;
import semantic.*;
import codegeneration.*;

import org.antlr.v4.runtime.*;

/**
 * Clase que inicia el compilador e invoca a todas sus fases.
 *
 * - Para Análisis Léxico: 'Lexico.g4'.
 * - Para Análisis Sintáctico: 'Grammar.g4'.
 * - Para Análisis Semántico: 'Identification.java' y 'TypeChecking.java'.
 * - Para Generación de Código: 'MemoryAllocation.java' y 'CodeSelection.java'.
 *
 * @author Raúl Izquierdo
 *
 */
public class Main {
    public static final String program = "programas/examen2.txt"; // Prueba a compilar durante el desarrollo

    public static void main(String[] args) throws Exception {
        ErrorManager errorManager = new ErrorManager();

        AST ast = compile(program, errorManager); // Poner args[0] en vez de "programa" en la versión final
        if (errorManager.errorsCount() == 0)
            System.out.println("El programa se ha compilado correctamente.");

        ASTPrinter.toHtml(program, ast, "AST"); // Utilidad generada por VGen (opcional)
    }

    /**
     * Método que coordina todas las fases del compilador
     */
    public static AST compile(String sourceName, ErrorManager errorManager) throws Exception {

        // 1. Fases de Análisis Léxico y Sintáctico
        GrammarLexer lexer = new GrammarLexer(CharStreams.fromFileName(sourceName));
        GrammarParser parser = new GrammarParser(new CommonTokenStream(lexer));

        AST ast = null;

        ast = parser.start().ast;
        
        //PrintVisitor pv = new PrintVisitor();
        //pv.visit((Program)ast, null);

        if (ast == null) // Hay errores o el AST no se ha implementado aún
            return null;

        // 2. Fase de Análisis Semántico
        SemanticAnalisys analyzer = new SemanticAnalisys(errorManager);
        analyzer.analize(ast);
        if (errorManager.errorsCount() > 0)
            return ast;

        // 3. Fase de Generación de Código
        File sourceFile = new File(sourceName);
        Writer out = new FileWriter(new File(sourceFile.getParent(), "output.txt"));

        CodeGeneration generator = new CodeGeneration();
        generator.generate(sourceFile.getName(), ast, out);
        out.close();

        return ast;
    }
}
