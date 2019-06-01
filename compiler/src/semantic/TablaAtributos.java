package semantic;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import ast.Atributo;

public class TablaAtributos {

	private Stack<Map<String, Atributo>> pilaAmbitos = new Stack<Map<String, Atributo>>();

	public TablaAtributos() {
		set();
	}

	public void inserta(String nombre, Atributo def) {
		pilaAmbitos.peek().put(nombre, def);
	}

	public Atributo busca(String nombre) {
		for (int i = (pilaAmbitos.size() - 1); i >= 0; i--) {
			Map<String, Atributo> ambito = pilaAmbitos.get(i);
			Atributo def = ambito.get(nombre);
			if (def != null)
				return def;
		}
		return null;
	}

	public Atributo buscaLocal(String nombre) {
		int tam = 0;
		if (pilaAmbitos.size() > 1)
			tam = 1;
		for (int i = (pilaAmbitos.size() - 1); i >= tam; i--) {
			Map<String, Atributo> ambito = pilaAmbitos.get(i);
			Atributo def = ambito.get(nombre);
			if (def != null)
				return def;
		}
		return null;
	}

	public void set() {
		pilaAmbitos.push(new HashMap<String, Atributo>());
	}

	public void reset() {
		pilaAmbitos.pop();
	}

}
