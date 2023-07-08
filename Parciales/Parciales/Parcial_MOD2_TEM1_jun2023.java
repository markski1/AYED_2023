/*
 * Se cuenta con un mapa de pueblos emblematicos de Francia y se quiere conocer todos
 * los caminos desde un pueblo origen hasta uno destino. Habra una cantidad de KM maximos,
 * recibida por parametro.
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
 *  ??? resolver(Grafo<???> ciudades, String origen, String destino, int maxKilometros
 * 
 */

package Parciales;

import tp02.ejercicio2.*;
import tp06.ejercicio3.*;

public class Parcial_MOD2_TEM1_jun2023 {
	Grafo<String> grafo;
	
	public ListaGenerica<ListaGenerica<String>> resolver(Grafo<String> ciudades, String origen, String destino, int maxKilometros) {
		this.grafo = ciudades;
		
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<>();
		ListaGenerica<ListaGenerica<String>> listaCaminos = new ListaEnlazadaGenerica<>();
		
		// primero verificamos que ambos existan.
		int posOrigen = -1; int posDestino = -1;
		
		ListaGenerica<Vertice<String>> lugares = grafo.listaDeVertices();
		boolean[] check = new boolean[lugares.tamanio() + 1];
		
		lugares.comenzar();
		while (!lugares.fin()) {
			Vertice<String> v = lugares.proximo();
			
			if (v.dato().equals(origen)) {
				posOrigen = v.getPosicion();
				camino.agregarInicio(v.dato());
			} else if (v.dato().equals(destino)) {
				posDestino = v.getPosicion();
			}
			
			// si encontramos ambos dejar de recorrer.
			if (posOrigen >= 0 && posDestino >= 0) break;
		}
		
		if (posOrigen == -1 || posOrigen == -1) {
			return listaCaminos;
		}
		
		int distancia = 0;
		
		recorrer(camino, listaCaminos, check, posOrigen, posDestino, maxKilometros, distancia);
		
		return listaCaminos;
	}

	private void recorrer(ListaGenerica<String> camino, ListaGenerica<ListaGenerica<String>> listaCaminos, boolean[] check, int i, int posDestino, int maxKilometros, int distancia) {
		check[i] = true;
		Vertice<String> v = grafo.vetice(i);
		
		if (v.getPosicion() == posDestino) {
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
			
			// no seguir un camino que excede el peso o cuyo vertice ya fue explorado.
			if (check[sig.getPosicion()] || distancia + a.peso() > maxKilometros)
				continue;
			
			camino.agregarFinal(sig.dato());
			distancia += a.peso();
			recorrer(camino, listaCaminos, check, i, posDestino, maxKilometros, distancia);
			check[sig.getPosicion()] = false;
			camino.eliminarEn(camino.tamanio());
			distancia -= a.peso();
		}
	}
	
	
}
