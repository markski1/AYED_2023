package tp03.ejercicio3;
import tp03.ejercicio1.*;
import tp03.reqs.*;

public class ContadorArbol_PostOrden extends ContadorArbol {
	private ListaGenerica<Integer> lista;
	
	public ContadorArbol_PostOrden(ArbolBinario<Integer> arbol) {
		super(arbol);
		lista = new ListaEnlazadaGenerica<>();
	}
	
	@Override
	protected ListaGenerica<Integer> agarrarPares(ArbolBinario<Integer> arbol) {
		// se va recorriendo full izquierda o en su defecto derecha hasta llegar al menor hijo por este lado
		if (arbol.tieneHijoIzquierdo())
			agarrarPares(arbol.getHijoIzquierdo());
		if (arbol.tieneHijoDerecho())
			agarrarPares(arbol.getHijoDerecho());
		// solo se toma el dato tras llegar lo mas bajo posible y luego se va moviendo
		if (arbol.getDato() % 2 == 0)
			lista.agregarFinal(arbol.getDato());
		
		return lista;
	}
}