/**
 * @generated VGen (for ANTLR) 1.4.0
 */

package visitor;

import java.io.*;

import ast.*;
import java.util.*;

/**
 * ASTPrinter. Utilidad que ayuda a validar un arbol AST:
 * - Muestra la estructura del árbol en HTML.
 * - Destaca los hijos/propiedades a null.
 * - Muestra a qué texto apuntan las posiciones de cada nodo (linea/columna)
 *      ayudando a decidir cual de ellas usar en los errores y generación de código.
 *
 * Esta clase se genera con VGen. El uso de esta clase es opcional (puede eliminarse del proyecto).
 *
 */
public class ASTPrinter extends DefaultVisitor {

    /**
     * toHtml. Muestra la estructura del AST indicando qué hay en las posiciones
     * (línea y columna) de cada nodo.
     *
     * @param sourceFile El fichero del cual se ha obtenido el AST
     * @param raiz       El AST creado a partir de sourceFile
     * @param filename   Nombre del fichero HMTL a crear con la traza del AST
     */

    public static void toHtml(String sourceFile, AST raiz, String filename) {
        toHtml(sourceFile, raiz, filename, 4);
    }

    public static void toHtml(AST raiz, String filename) {
        toHtml(null, raiz, filename);
    }

    // tabWidth deberían ser los espacios correspondientes a un tabulador en eclipse.
    // Normalmente no sería necesario especificarlo. Usar mejor los dos métodos anteriores.

    public static void toHtml(String sourceFile, AST raiz, String filename, int tabWidth) {
        try {
            PrintWriter writer = new PrintWriter(
                    new FileWriter(filename.endsWith(".html") ? filename : filename + ".html"));
            generateHeader(writer);
            writer.println("[ASTPrinter] -------------------------------- line:col  line:col");
            if (raiz != null) {
                ASTPrinter tracer = new ASTPrinter(writer, loadLines(sourceFile, tabWidth));
                raiz.accept(tracer, new Integer(0));
            } else
                writer.println("raiz == null");
            writer.println(ls + ls + "[ASTPrinter] --------------------------------");
            generateFooter(writer);
            writer.close();
            System.out.println(ls + "ASTPrinter: Fichero '" + filename
                    + ".html' generado. Abra dicho fichero para validar el AST generado.");
        } catch (IOException e) {
            System.out.println(ls + "ASTPrinter: No se ha podido crear el fichero " + filename);
            e.printStackTrace();
        }
    }

    private static void generateHeader(PrintWriter writer) {
        writer.println("<html>\r\n"
            + "<head>\r\n"
            + "<meta charset=\"utf-8\" />\r\n"
            + "<style type=\"text/css\">\r\n"
            + ".value { font-weight: bold; }\r\n"
            + ".dots { color: #bebdbd; }\r\n"
            + ".type { color: #BBBBBB; }\r\n"
            + ".pos { color: #CCCCCC; }\r\n"
            + ".sourceText { color: #BBBBBB; }\r\n"
            + ".posText {\r\n" + "	color: #BBBBBB;\r\n"
            + "	text-decoration: underline; font-weight: bold;\r\n"
            + "}\r\n"
            + ".null {\r\n"
            + "	color: #FF0000;\r\n"
            + "	font-weight: bold;\r\n"
            + "	font-style: italic;\r\n" + "}\r\n"
            + "</style>\r\n" + "</head>\r\n" + "\r\n"
            + "<body><pre>");
    }

    private static void generateFooter(PrintWriter writer) {
        writer.println("</pre>\r\n" + "</body>\r\n" + "</html>");
    }

    private ASTPrinter(PrintWriter writer, List<String> sourceLines) {
        this.writer = writer;
        this.sourceLines = sourceLines;
    }

    // ----------------------------------------------
	//	class Program { List<Bloque> bloque; }
	public Object visit(Program node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Program", node, false);

		visit(indent + 1, "bloque", "List<Bloque>",node.getBloque());
		return null;
	}

	//	class VarDef { String name;  Type type; }
	public Object visit(VarDef node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "VarDef", node, false);

		print(indent + 1, "name", "String", node.getName());
		visit(indent + 1, "type", "Type",node.getType());
		return null;
	}

	//	class EstructuraDef { String nombre;  List<Atributo> atributos; }
	public Object visit(EstructuraDef node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "EstructuraDef", node, false);

		print(indent + 1, "nombre", "String", node.getNombre());
		visit(indent + 1, "atributos", "List<Atributo>",node.getAtributos());
		return null;
	}

	//	class FuncionDef { String name;  List<Parametro> parametros;  Type type;  List<VarDef> variables;  List<Sentencia> sentencias; }
	public Object visit(FuncionDef node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "FuncionDef", node, false);

		print(indent + 1, "name", "String", node.getName());
		visit(indent + 1, "parametros", "List<Parametro>",node.getParametros());
		visit(indent + 1, "type", "Type",node.getType());
		visit(indent + 1, "variables", "List<VarDef>",node.getVariables());
		visit(indent + 1, "sentencias", "List<Sentencia>",node.getSentencias());
		return null;
	}

	//	class Atributo { String name;  Type type; }
	public Object visit(Atributo node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Atributo", node, false);

		print(indent + 1, "name", "String", node.getName());
		visit(indent + 1, "type", "Type",node.getType());
		return null;
	}

	//	class Parametro { String nombre;  Type type; }
	public Object visit(Parametro node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Parametro", node, false);

		print(indent + 1, "nombre", "String", node.getNombre());
		visit(indent + 1, "type", "Type",node.getType());
		return null;
	}

	//	class IntType {  }
	public Object visit(IntType node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "IntType", node, true);

		return null;
	}

	//	class RealType {  }
	public Object visit(RealType node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "RealType", node, true);

		return null;
	}

	//	class CharType {  }
	public Object visit(CharType node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "CharType", node, true);

		return null;
	}

	//	class ArrayType { Expresion size;  Type type; }
	public Object visit(ArrayType node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "ArrayType", node, false);

		visit(indent + 1, "size", "Expresion",node.getSize());
		visit(indent + 1, "type", "Type",node.getType());
		return null;
	}

	//	class CustomType { String nombre; }
	public Object visit(CustomType node, Object param) {
		int indent = ((Integer)param).intValue();

		printCompact(indent, "CustomType", node, "nombre", node.getNombre());
		return null;
	}

	//	class Read { Expresion value; }
	public Object visit(Read node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Read", node, false);

		visit(indent + 1, "value", "Expresion",node.getValue());
		return null;
	}

	//	class Print { Expresion value; }
	public Object visit(Print node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Print", node, false);

		visit(indent + 1, "value", "Expresion",node.getValue());
		return null;
	}

	//	class Assign { Expresion left;  Expresion right; }
	public Object visit(Assign node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Assign", node, false);

		visit(indent + 1, "left", "Expresion",node.getLeft());
		visit(indent + 1, "right", "Expresion",node.getRight());
		return null;
	}

	//	class Whileloop { Expresion condicion;  List<Sentencia> sentencias; }
	public Object visit(Whileloop node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Whileloop", node, false);

		visit(indent + 1, "condicion", "Expresion",node.getCondicion());
		visit(indent + 1, "sentencias", "List<Sentencia>",node.getSentencias());
		return null;
	}

	//	class IfDef { Expresion condicion;  List<Sentencia> iftrue;  List<Sentencia> iffalse; }
	public Object visit(IfDef node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "IfDef", node, false);

		visit(indent + 1, "condicion", "Expresion",node.getCondicion());
		visit(indent + 1, "iftrue", "List<Sentencia>",node.getIftrue());
		visit(indent + 1, "iffalse", "List<Sentencia>",node.getIffalse());
		return null;
	}

	//	class ReturnSent { Expresion retorno; }
	public Object visit(ReturnSent node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "ReturnSent", node, false);

		visit(indent + 1, "retorno", "Expresion",node.getRetorno());
		return null;
	}

	//	class LlamadaS { Llamada invocacion; }
	public Object visit(LlamadaS node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "LlamadaS", node, false);

		visit(indent + 1, "invocacion", "Llamada",node.getInvocacion());
		return null;
	}

	//	class Variable { String name; }
	public Object visit(Variable node, Object param) {
		int indent = ((Integer)param).intValue();

		printCompact(indent, "Variable", node, "name", node.getName());
		return null;
	}

	//	class Compuesto { Expresion left;  Expresion right; }
	public Object visit(Compuesto node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Compuesto", node, false);

		visit(indent + 1, "left", "Expresion",node.getLeft());
		visit(indent + 1, "right", "Expresion",node.getRight());
		return null;
	}

	//	class Integral { String valor; }
	public Object visit(Integral node, Object param) {
		int indent = ((Integer)param).intValue();

		printCompact(indent, "Integral", node, "valor", node.getValor());
		return null;
	}

	//	class Real { String valor; }
	public Object visit(Real node, Object param) {
		int indent = ((Integer)param).intValue();

		printCompact(indent, "Real", node, "valor", node.getValor());
		return null;
	}

	//	class Caracter { String valor; }
	public Object visit(Caracter node, Object param) {
		int indent = ((Integer)param).intValue();

		printCompact(indent, "Caracter", node, "valor", node.getValor());
		return null;
	}

	//	class Identificador { Expresion var;  List<Array> dimensiones; }
	public Object visit(Identificador node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Identificador", node, false);

		visit(indent + 1, "var", "Expresion",node.getVar());
		visit(indent + 1, "dimensiones", "List<Array>",node.getDimensiones());
		return null;
	}

	//	class Parentesis { Expresion contenido; }
	public Object visit(Parentesis node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Parentesis", node, false);

		visit(indent + 1, "contenido", "Expresion",node.getContenido());
		return null;
	}

	//	class Casting { Type tipo;  Expresion contenido; }
	public Object visit(Casting node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Casting", node, false);

		visit(indent + 1, "tipo", "Type",node.getTipo());
		visit(indent + 1, "contenido", "Expresion",node.getContenido());
		return null;
	}

	//	class Aritmetica { Expresion left;  String operando;  Expresion right; }
	public Object visit(Aritmetica node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Aritmetica", node, false);

		visit(indent + 1, "left", "Expresion",node.getLeft());
		print(indent + 1, "operando", "String", node.getOperando());
		visit(indent + 1, "right", "Expresion",node.getRight());
		return null;
	}

	//	class Comparativa { Expresion left;  String operando;  Expresion right; }
	public Object visit(Comparativa node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Comparativa", node, false);

		visit(indent + 1, "left", "Expresion",node.getLeft());
		print(indent + 1, "operando", "String", node.getOperando());
		visit(indent + 1, "right", "Expresion",node.getRight());
		return null;
	}

	//	class Logica { Expresion left;  String operando;  Expresion right; }
	public Object visit(Logica node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Logica", node, false);

		visit(indent + 1, "left", "Expresion",node.getLeft());
		print(indent + 1, "operando", "String", node.getOperando());
		visit(indent + 1, "right", "Expresion",node.getRight());
		return null;
	}

	//	class LlamadaE { Llamada invocacion; }
	public Object visit(LlamadaE node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "LlamadaE", node, false);

		visit(indent + 1, "invocacion", "Llamada",node.getInvocacion());
		return null;
	}

	//	class Array { Expresion pos; }
	public Object visit(Array node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Array", node, false);

		visit(indent + 1, "pos", "Expresion",node.getPos());
		return null;
	}

	//	class Llamada { String nombre;  List<Expresion> parametros; }
	public Object visit(Llamada node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Llamada", node, false);

		print(indent + 1, "nombre", "String", node.getNombre());
		visit(indent + 1, "parametros", "List<Expresion>",node.getParametros());
		return null;
	}


	// -----------------------------------------------------------------
	// Métodos invocados desde los métodos visit -----------------------

	private void printName(int indent, String name, AST node, boolean empty) {
		String text = ls + tabula(indent) + name + " &rarr;  ";
		text = String.format("%1$-" + 93 + "s", text);
		if (empty)
			text = text.replace(name, valueTag(name));
		writer.print(text + getPosition(node));
	}

	private void print(int indent, String name, String type, Object value) {
		write(indent, formatValue(value) + "  " + typeTag(type));
	}

	private void print(int indent, String attName, String type, List<? extends Object> children) {
		write(indent, attName + "  " + typeTag(type) + " = ");
		if (children != null)
			for (Object child : children)
				write(indent + 1, formatValue(child));
		else
			writer.print(" " + valueTag(null));
	}

	// Versión compacta de una linea para nodos que solo tienen un atributo String
	private void printCompact(int indent, String nodeName, AST node, String attName, Object value) {
		String fullName = nodeName + '.' + attName;
		String text = ls + tabula(indent) + '\"' + value + "\"  " + fullName;
		text = String.format("%1$-" + 88 + "s", text);
		// text = text.replace(value.toString(), valueTag(value));
		text = text.replace(fullName, typeTag(fullName));
		writer.print(text + getPosition(node));
	}

	private void visit(int indent, String attName, String type, List<? extends AST> children) {
		write(indent, attName + "  " + typeTag(type) + " = ");
		if (children != null)
			for (AST child : children)
				child.accept(this, indent + 1);
		else
			writer.print(" " + valueTag(null));
	}

	private void visit(int indent, String attName, String type, AST child) {
		if (child != null)
			child.accept(this, new Integer(indent));
		else
			write(indent, valueTag(null) + "  " + attName + ':' + typeTag(type));
	}

	// -----------------------------------------------------------------
	// Métodos auxiliares privados -------------------------------------

	private void write(int indent, String text) {
		writer.print(ls + tabula(indent) + text);
	}

	private static String tabula(int count) {
		StringBuffer cadena = new StringBuffer("<span class=\"dots\">");
		for (int i = 0; i < count; i++)
			cadena.append(i % 2 == 0 && i > 0 ? "|  " : ".  ");
		return cadena.toString() + "</span>";
	}

	private String typeTag(String type) {
		if (type.equals("String"))
			return "";
		return "<span class=\"type\">" + type.replace("<", "&lt;").replace(">", "&gt;") + "</span>";
	}

	private String valueTag(Object value) {
		if (value == null)
			return "<span class=\"null\">null</span>";
		return "<span class=\"value\">" + value + "</span>";
	}

	private String formatValue(Object value) {
		String text = valueTag(value);
		if (value instanceof String)
			text = "\"" + text + '"';
		return text;
	}


	// -----------------------------------------------------------------
	// Métodos para mostrar las Posiciones -----------------------------

	private String getPosition(AST node) {
		String text = node.getStart() + "  " + node.getEnd();
		text = "<span class=\"pos\">" + String.format("%1$-" + 13 + "s", text) + "</span>";
		text = text.replace("null", "<span class=\"null\">null</span>");
		String sourceText = findSourceText(node);
		if (sourceText != null)
			text += sourceText;
		return text;
	}

	private String findSourceText(AST node) {
		if (sourceLines == null)
			return null;

		Position start = node.getStart();
		Position end = node.getEnd();
		if (start == null || end == null)
			return null;

		String afterText, text, beforeText;
		if (start.getLine() == end.getLine()) {
			String line = sourceLines.get(start.getLine() - 1);
			afterText = line.substring(0, start.getColumn() - 1);
			text = line.substring(start.getColumn() - 1, end.getColumn());
			beforeText = line.substring(end.getColumn());
		} else {
			String firstLine = sourceLines.get(start.getLine() - 1);
			String lastLine = sourceLines.get(end.getLine() - 1);

			afterText = firstLine.substring(0, start.getColumn() - 1);

			text = firstLine.substring(start.getColumn() - 1);
			text += "</span><span class=\"sourceText\">" + " ... " + "</span><span class=\"posText\">";
			text += lastLine.substring(0, end.getColumn()).replaceAll("^\\s+", "");

			beforeText = lastLine.substring(end.getColumn());
		}
		return "<span class=\"sourceText\">" + afterText.replaceAll("^\\s+", "")
				+ "</span><span class=\"posText\">" + text
				+ "</span><span class=\"sourceText\">" + beforeText + "</span>";
	}

	private static List<String> loadLines(String sourceFile, int tabWidth) {
		if (sourceFile == null)
			return null;
		try {
			String spaces = new String(new char[tabWidth]).replace("\0", " ");

			List<String> lines = new ArrayList<String>();
			BufferedReader br = new BufferedReader(new FileReader(sourceFile));
			String line;
			while ((line = br.readLine()) != null) {
			//	lines.add(line.replace("\t", spaces)); // Si tab = 4 espaces (Eclipse)
				lines.add(line);
            }
			br.close();
			return lines;
		} catch (FileNotFoundException e) {
			System.out.println("Warning. No se pudo encontrar el fichero fuente '" + sourceFile + "'. No se mostrará informaicón de posición.");
			return null;
		} catch (IOException e) {
			System.out.println("Warning. Error al leer del fichero fuente '" + sourceFile + "'. No se mostrará informaicón de posición.");
			return null;
		}
	}


	private List<String> sourceLines;
	private static String ls = System.getProperty("line.separator");
	private PrintWriter writer;
}
