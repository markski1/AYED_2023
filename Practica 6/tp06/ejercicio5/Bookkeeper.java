// credito a @Whiskydog en Github
// mi implementación original de book keeping era peor, asi que tome prestada la suya.
package tp06.ejercicio5;

import tp02.ejercicio2.*;
import tp06.ejercicio3.*;

public class Bookkeeper<T> {
	private boolean[] marcas;
	private int[] prev;
	private int[] dist;
	private ListaGenerica<Vertice<T>> vertices;
	
	public Bookkeeper(Grafo<T> grafo) {
		vertices = grafo.listaDeVertices();
		marcas = new boolean[vertices.tamanio() + 1];
		prev = new int[vertices.tamanio() + 1];
		dist = new int[vertices.tamanio() + 1];
		
		for (int i = 1; i < dist.length; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
	}
	
	public ListaGenerica<T> getCamino(int destPos) {
		ListaGenerica<T> camino = new ListaEnlazadaGenerica<>();
		
		if (prev[destPos] != 0)
			getCamino(camino, destPos);
		
		return camino;
	}
	
	private void getCamino(ListaGenerica<T> camino, int pre) {
		camino.agregarInicio(vertices.elemento(pre).dato());
		
		if (pre != prev[pre])
			getCamino(camino, prev[pre]);
	}
	
	public int indexMinNoVisitado() {
		int min = Integer.MAX_VALUE;
		int minIndex = -1;

		for (int i = 1; i < dist.length; i++) {
			if (!marcas[i] && dist[i] < min) {
				min = dist[i];
				minIndex = i;
			}
		}
		
		return minIndex;
	}
	
	public void setDist(int index, int dist) {
		this.dist[index] = dist;
	}
	
	public int getDist(int index) {
		return dist[index];
	}
	
	public void setPrev(int index, int prev) {
		this.prev[index] = prev;
	}
	
	public void marcarVisitado(int index) {
		this.marcas[index] = true;
	}
	
	public boolean estaMarcado(int index) {
		return marcas[index];
	}
}
