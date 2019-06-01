package semantic;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import ast.VarDef;

public class TablaSimbolos {

	private Stack<Map<String, VarDef>> pilaAmbitos = new Stack<Map<String, VarDef>>();

	public TablaSimbolos() {
		set();
	}

	public void inserta(String nombre, VarDef def) {
		pilaAmbitos.peek().put(nombre, def);
	}

	public VarDef busca(String nombre) {
		for (int i = (pilaAmbitos.size() - 1); i >= 0; i--) {
			Map<String, VarDef> ambito = pilaAmbitos.get(i);
			VarDef def = ambito.get(nombre);
			if (def != null)
				return def;
		}
		return null;
	}
	
	public VarDef buscaLocal(String nombre) {
		int tam = 0;
		if (pilaAmbitos.size()>1)
			tam=1;
		for (int i = (pilaAmbitos.size() - 1); i >= tam; i--) {
			Map<String, VarDef> ambito = pilaAmbitos.get(i);
			VarDef def = ambito.get(nombre);
			if (def != null)
				return def;
		}
		return null;
	}

	public void set() {
		pilaAmbitos.push(new HashMap<String, VarDef>());
	}

	public void reset() {
		pilaAmbitos.pop();
	}

}
