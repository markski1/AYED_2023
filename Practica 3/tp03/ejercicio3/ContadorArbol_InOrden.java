package tp03.ejercicio3;
import tp03.ejercicio1.*;
import tp03.reqs.*;

public class ContadorArbol_InOrden extends ContadorArbol {
	private ListaGenerica<Integer> lista;
	
	public ContadorArbol_InOrden(ArbolBinario<Integer> arbol) {
		super(arbol);
		lista = new ListaEnlazadaGenerica<>();
	}
	
	@Override
	protected ListaGenerica<Integer> agarrarPares(ArbolBinario<Integer> arbol) {
		// se va recorriendo full izquierda hasta estar en el hizo mas a la izquierda
		if (arbol.tieneHijoIzquierdo())
			agarrarPares(arbol.getHijoIzquierdo());
		// una vez ahi se empieza a evaluar el contenido de cada hoja
		if (arbol.getDato() % 2 == 0)
			lista.agregarFinal(arbol.getDato());
		// y si aplica se va buscando para la derecha y se repite la logica
		if (arbol.tieneHijoDerecho())
			agarrarPares(arbol.getHijoDerecho());
		
		return lista;
	}
}