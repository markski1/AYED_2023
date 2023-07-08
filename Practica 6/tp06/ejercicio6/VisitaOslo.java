package tp06.ejercicio6;

import tp02.ejercicio2.*;
import tp06.ejercicio3.*;

public class VisitaOslo {
	Grafo<String> grafo;
	
	public ListaGenerica<String> paseoEnBici(Grafo<String> lugares, String destino, int maxTiempo, ListaGenerica<String> lugaresRestringidos) {
		this.grafo = lugares;
		
		// camino se va a usar para llevar cuenta de lo que se va recorriendo.
		// resultado se devolvera con el camino encontrado.
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<>();
		ListaGenerica<String> resultado = new ListaEnlazadaGenerica<>();
		
		// tomamos una lista de lugares, utilizamos su tamaño para crear
		// un array que permitira ir viendo si recorrimos o no un vertice en cada pos.
		ListaGenerica<Vertice<String>> listaLugares = grafo.listaDeVertices();		
		boolean[] check = new boolean[listaLugares.tamanio() + 1];
		
		listaLugares.comenzar();
		
		int i = -1;
		
		// encontraremos la posición del Ayuntamiento, se colocara en i.
		// tambien sera el primer elemento del camino.
		while (!listaLugares.fin()) {
			Vertice<String> v = listaLugares.proximo();
			if (v.dato().equals("Ayuntamiento")) {
				camino.agregarFinal(v.dato());
				i = v.getPosicion();
				break;
			}
		}
		
		// si no se encuentra el ayuntamiento, vuelve lista vacia.		
		if (i == -1)
			return new ListaEnlazadaGenerica<>();
		
		// obtendremos el resultado por dfs.
		int distancia = 0;
		dfs(check, i, camino, destino, lugaresRestringidos, resultado, maxTiempo, distancia);
		
		return resultado;
	}
	
	private void dfs(boolean[] check, int i, ListaGenerica<String> camino, String destino, ListaGenerica<String> restringidos, ListaGenerica<String> resultado, int maxTiempo, int distancia) {
		// visitando el vertice i
		// se marca como visitado, se coloca en 'v' y seguimos.
		check[i] = true;
		Vertice<String> v = grafo.vetice(i);
		
		// si es lo que buscabamos. ya esta.
		if (v.dato().equals(destino)) {
			ListaGenerica<String> aux = new ListaEnlazadaGenerica<String>();
			
			camino.comenzar();
			while (!camino.fin()) {
				aux.agregarFinal(camino.proximo());
			}
			
			resultado = aux;
			
			// return termina la ejecución de la funcion, por eso no hace falta un else.
			return;
		}
		
		// si estamos aca, no llegamos a destino.
		
		// tomamos los adyacentes y recorremos.
		ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
		
		ady.comenzar();
		while (!ady.fin()) {
			Arista<String> a = ady.proximo();
			Vertice<String> v2 = a.verticeDestino();
			
			int pos = v2.getPosicion(); int peso = a.peso();
			
			// si la distancia que ya llevamos, mas el peso de esta arista, es mayor al maximo
			// no tiene sentido recorrerla, asi que skippeamos.
			if (distancia + a.peso() > maxTiempo)
				continue;
			
			if (!check[pos] && !restringidos.incluye(v2.dato())) {
				// agregamos este vertice y su peso a las mediciones y lo exploramos.
				camino.agregarFinal(v2.dato());
				distancia += peso;
				dfs (check, i, camino, destino, restringidos, resultado, maxTiempo, distancia);
				
				// si el resultado tiene elementos, terminamos.
				if (resultado.tamanio() > 0)
					return;
				
				// si no, entonces recorrer por aca no logro nada.
				// sacamos este vertice y continuamos.
				camino.eliminarEn(camino.tamanio());
				distancia -= peso;
				check[pos] = false;
			}
		}
	}
}
