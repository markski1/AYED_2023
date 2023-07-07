package tp06.ejercicio5;

import tp02.ejercicio2.*;
import tp06.ejercicio3.*;

public class Dijkstra<T> {
	private Grafo<T> grafo;
	private Bookkeeper<T> bookkeeper;
	
	public Dijkstra(Grafo<T> grafo, Vertice<T> origen, int maxPeso) {
		this.grafo = grafo;
		
		// el "book keeper" lleva seguimiento de lo que se visito.
		// no hace falta tenerlo a parte pero me gusto mucho esta implementación.
		// credito a @Whiskydog en Github
		bookkeeper = new Bookkeeper<>(grafo);
		bookkeeper.setDist(origen.getPosicion(), 0);
		bookkeeper.setPrev(origen.getPosicion(), origen.getPosicion());
		
		calcular(maxPeso);
	}
	
	public void calcular(int maxPeso) {
		int indexVertCerca;
		
		while (true) {
			indexVertCerca = bookkeeper.indexMinNoVisitado();
			
			if (indexVertCerca == -1)
				break;
			
			bookkeeper.marcarVisitado(indexVertCerca);
			
			Vertice<T> vertCercano = grafo.vetice(indexVertCerca);
			ListaGenerica<Arista<T>> aristas = grafo.listaDeAdyacentes(vertCercano);
			
			aristas.comenzar();
			
			while(!aristas.fin()) {
				Arista<T> arista = aristas.proximo();
				Vertice<T> ady = arista.verticeDestino();
				
				if (bookkeeper.estaMarcado(ady.getPosicion()))
					continue;
				
				int dist = arista.peso() + bookkeeper.getDist(indexVertCerca);
				
				if (maxPeso >= arista.peso() && bookkeeper.getDist(ady.getPosicion()) > dist) {
					bookkeeper.setDist(ady.getPosicion(), dist);
					bookkeeper.setPrev(ady.getPosicion(), indexVertCerca);
				}
			}
		}
	}
	
	public int distanciaHasta(Vertice<T> destino) {
		return bookkeeper.getDist(destino.getPosicion());
	}
	
	public ListaGenerica<T> getCamino(Vertice<T> destino) {
		return bookkeeper.getCamino(destino.getPosicion());
	}
}
