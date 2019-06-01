/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package ast;

import java.util.*;

import org.antlr.v4.runtime.*;

public abstract class AbstractAST implements AST {

    @Override
    public Position getStart() {
        return start;
    }

    @Override
    public Position getEnd() {
        return end;
    }

    // setPositions. Establece:
    // 1. La posición inicial (start) a partir
    // del PRIMER hijo que tenga posición inicial.
    // 2. La posición final (end) a partir del ULTIMO
    // hijo que tenga posición final.

    @Override
    public void setPositions(Object... children) {
        List<Object> childrenList = Arrays.asList(children);
        this.start = findStart(childrenList);
        this.end = findEnd(childrenList);
        invariant();
    }

    // -----------------------------------------------
    // Métodos protected para ser llamado desde los
    // constructores de las clases AST

    // Dado un Contexto de una regla de ANTLR, extrae su campo "ast"
    protected AST getAST(ParserRuleContext node) {
        try {
            return (AST) node.getClass().getField("ast").get(node);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    "El contexto pasado no tiene un atributo llamado 'ast' o no es de tipo AST");
        }
    }

    protected AST getAST(Object node) {
        return getAST((ParserRuleContext) node);
    }

    // -----------------------------------------------
    // Mótodos privados para ser llamados SÓLO desde los métodos anteriores

    @SuppressWarnings("unchecked")
    private Position findStart(Object node) {
        if (node instanceof AST)
            return ((AST) node).getStart();
        if (node instanceof ParserRuleContext)
            return findStart(getAST((ParserRuleContext) node));
        if (node instanceof List)
            return findStart((List<Object>) node);
        if (node instanceof Token) {
            Token token = (Token) node;
            return new Position(token.getLine(), token.getCharPositionInLine() + 1);
        }
        return null;
    }

    private Position findStart(List<Object> nodes) {
        Position start = null;
        for (Object node : nodes) {
            Position nodeStart = findStart(node);
            if (start == null)
                start = nodeStart;
            else // No suponer que los hijos se han pasado ordenados de izquierda a derecha
                start = (nodeStart != null && nodeStart.lessThan(start)) ? nodeStart : start;
        }
        return start;
    }

    @SuppressWarnings("unchecked")
    private Position findEnd(Object node) {
        if (node instanceof AST)
            return ((AST) node).getEnd();
        if (node instanceof ParserRuleContext)
            return findEnd(getAST((ParserRuleContext) node));
        if (node instanceof List)
            return findEnd((List<Object>) node);
        if (node instanceof Token) {
            Token token = (Token) node;
            return new Position(token.getLine(), token.getCharPositionInLine() + token.getText().length());
        }
        return null;
    }

    private Position findEnd(List<Object> nodes) {
        Position end = null;
        for (Object node : nodes) {
            Position nodeEnd = findEnd(node);
            if (end == null)
                end = nodeEnd;
            else // No suponer que los hijos se han pasado ordenados de izquierda a derecha
                end = (nodeEnd != null && nodeEnd.greaterThan(end)) ? nodeEnd : end;
        }
        return end;
    }

    // Para depuración
    private void invariant() {
        if ((getStart() != null || getEnd() != null) && getStart().greaterThan(getEnd()))
            throw new IllegalStateException(
                    "Las posiciones del nodo (start y end) son inválidas: o son ambas null o (start <= end)");
    }

    private Position start, end;
}
