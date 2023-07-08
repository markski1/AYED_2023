/*
 * Se cuenta con un mapa de pueblos emblematicos de Francia y se quiere conocer todos
 * los caminos desde un pueblo origen hasta uno destino, evitando los pasados por parametro.
 * 
 * Tener en cuenta que:
 * 
 *  - Debe devolver todos los caminos posibles.
 *  - Debe completar en la firma del metodo todos los tipos de datos indicados con signo de interrogación
 *  - Debe verificar la existencia de pueblo origen y destino.
 *  - No se puede pasar 2 veces por el mismo lugar.
 *  - En caso de no existir, se devolvera una lista vacia.
 *  - Se debe usar un recorrido visto en clase: DFS o BFS.
 *  
 *  Implementar la clase parcial, y el metodo
 *  
 *  ??? resolver(Grafo<???> ciudades, String origen, String destino, ListaGenerica<???> evitarPasandoPor
 * 
 */

package Parciales;

import tp02.ejercicio2.*;
import tp06.ejercicio3.*;

public class Parcial_MOD2_TEM2_jun2023 {
	Grafo<String> grafo;
	
	ListaGenerica<ListaGenerica<String>> resolver(Grafo<String> ciudades, String origen, String destino, ListaGenerica<String> evitarPasandoPor) {
		this.grafo = ciudades;
		
		ListaGenerica<Vertice<String>> lugares = grafo.listaDeVertices();
		boolean[] check = new boolean[lugares.tamanio() + 1];
		
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<>();
		ListaGenerica<ListaGenerica<String>> listaCaminos = new ListaEnlazadaGenerica<>();
		
		int posOrigen = -1; int posDestino = -1;
		
		lugares.comenzar();
		
		while (!lugares.fin()) {
			Vertice<String> v = lugares.proximo();
			
			// quitar los restringidos, "marcarlos"
			if (evitarPasandoPor.incluye(v.dato())) {
				check[v.getPosicion()] = true;
				continue;
			}
			
			if (v.dato().equals(origen)) {
				posOrigen = v.getPosicion();
				camino.agregarFinal(v.dato());
			} else if (v.dato().equals(destino)) {
				posDestino = v.getPosicion();
			}
		}
		
		if (posOrigen == -1 || posDestino == -1)
			return listaCaminos;
		
		recorrer(check, camino, listaCaminos, posOrigen, posDestino);
		
		return listaCaminos;
	}

	private void recorrer(boolean[] check, ListaGenerica<String> camino, ListaGenerica<ListaGenerica<String>> listaCaminos, int i, int posDestino) {
		check[i] = true;
		Vertice<String> v = grafo.vetice(i);
		
		if (i == posDestino) {
			ListaGenerica<String> newCamino = new ListaEnlazadaGenerica<>();
			
			camino.comenzar();
			
			while (!camino.fin()) {
				newCamino.agregarFinal(camino.proximo());
			}
			
			listaCaminos.agregarFinal(newCamino);
			
			return;
		}
		
		ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
		
		ady.comenzar();
		
		while (!ady.fin()) {
			Arista<String> a = ady.proximo();
			Vertice<String> sig = a.verticeDestino();
			
			// skippear marcados
			if (check[sig.getPosicion()])
				continue;
			
			camino.agregarFinal(sig.dato());
			recorrer(check, camino, listaCaminos, i, posDestino);
			check[sig.getPosicion()] = false;
			camino.eliminarEn(camino.tamanio());
		}
	}
}
