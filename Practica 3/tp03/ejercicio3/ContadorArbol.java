package tp03.ejercicio3;
import tp03.reqs.*;
import tp03.ejercicio1.*;

public abstract class ContadorArbol {
	private ArbolBinario<Integer> arbol;
	
	public ContadorArbol(ArbolBinario<Integer> unArbol) {
		arbol = unArbol;
	}
	
	public ListaGenerica<Integer> numerosPares() {
		return agarrarPares(arbol);
	}
	
	protected abstract ListaGenerica<Integer> agarrarPares(ArbolBinario<Integer> arbol);
}
