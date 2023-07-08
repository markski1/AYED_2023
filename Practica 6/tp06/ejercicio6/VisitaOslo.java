package tp06.ejercicio6;

import tp02.ejercicio2.*;
import tp06.ejercicio3.*;

public class VisitaOslo {
	Grafo<String> grafo;
	
	public ListaGenerica<String> paseoEnBici(Grafo<String> lugares, String destino, int maxTiempo, ListaGenerica<String> lugaresRestringidos) {
		this.grafo = lugares;
			
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<>();
		ListaGenerica<Vertice<String>> listaLugares = grafo.listaDeVertices();
		ListaGenerica<String> resultado = new ListaEnlazadaGenerica<>();
		
		boolean[] check = new boolean[listaLugares.tamanio() + 1];
		
		listaLugares.comenzar();
		
		int i = -1;
		
		while (!listaLugares.fin()) {
			Vertice<String> v = listaLugares.proximo();
			if (v.dato().equals("Ayuntamiento")) {
				camino.agregarFinal(v.dato());
				i = v.getPosicion();
				break;
			}
		}
		
		if (i == -1)
			return new ListaEnlazadaGenerica<>();
		
		int distancia = 0;
		
		dfs(check, i, camino, destino, lugaresRestringidos, resultado, maxTiempo, distancia);
		
		return resultado;
	}
	
	private void dfs(boolean[] check, int i, ListaGenerica<String> camino, String destino, ListaGenerica<String> restringidos, ListaGenerica<String> resultado, int maxTiempo, int distancia) {
		check[i] = true;
		Vertice<String> v = grafo.vetice(i);
		if (v.dato().equals(destino)) {
			ListaGenerica<String> aux = new ListaEnlazadaGenerica<String>();
			
			camino.comenzar();
			while (!camino.fin()) {
				aux.agregarFinal(camino.proximo());
			}
			
			resultado = aux;
			check[i] = false;
		}
		else {
			ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
			
			ady.comenzar();
			while (!ady.fin()) {
				Arista<String> a = ady.proximo();
				Vertice<String> v2 = a.verticeDestino();
				
				int pos = v2.getPosicion(); int peso = a.peso();
				
				if (distancia + a.peso() > maxTiempo)
					continue;
				
				if (!check[pos] && !restringidos.incluye(v2.dato())) {
					camino.agregarFinal(v2.dato());
					distancia += peso;
					dfs (check, i, camino, destino, restringidos, resultado, maxTiempo, distancia);
					camino.eliminarEn(camino.tamanio());
					distancia -= peso;
					check[pos] = false;
				}
			}
		}
	}
}
