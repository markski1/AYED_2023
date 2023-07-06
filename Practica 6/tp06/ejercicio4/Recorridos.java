package tp06.ejercicio4;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp06.ejercicio3.*;

public class Recorridos<T> {
	
	Grafo<T> grafo;
	
	public Recorridos(Grafo<T> grafo) {
		this.grafo = grafo;
	}
	
	public ListaGenerica<Vertice<T>> dfs() {
		ListaGenerica<Vertice<T>> visitados = new ListaEnlazadaGenerica<>();
		
		ListaGenerica<Vertice<T>> vertices = grafo.listaDeVertices();
		
		boolean[] marcas = new boolean[vertices.tamanio() + 1];
				
		vertices.comenzar();
		
		while (!vertices.fin()) {
			Vertice<T> vert = vertices.proximo();
			
			if (!marcas[vert.getPosicion()])
				dfs(vert, visitados, marcas);
		}
		
		return visitados;
	}
	
	public void dfs(Vertice<T> vert, ListaGenerica<Vertice<T>> visitados, boolean[] marcas) {
		visitados.agregarFinal(vert);
		marcas[vert.getPosicion()] = true;
		ListaGenerica<Arista<T>> aristas = grafo.listaDeAdyacentes(vert);
		
		aristas.comenzar();
		while (!aristas.fin()) {
			Vertice<T> ady = aristas.proximo().verticeDestino();
			
			if (!marcas[ady.getPosicion()])
				dfs(ady, visitados, marcas);
		}
	}
	
	public ListaGenerica<Vertice<T>> bfs() {
		ListaGenerica<Vertice<T>> visitados = new ListaEnlazadaGenerica<>();
		
		ListaGenerica<Vertice<T>> vertices = grafo.listaDeVertices();
		
		boolean[] marcas = new boolean[vertices.tamanio() + 1];
		
		ColaGenerica<Vertice<T>> cola = new ColaGenerica<>();
		
		vertices.comenzar();
		while (!vertices.fin()) {
			Vertice<T> vert = vertices.proximo();
			
			if (!marcas[vert.getPosicion()])
				bfs(vert, visitados, marcas, cola);
		}
		
		return visitados;
	}

	private void bfs(Vertice<T> vert, ListaGenerica<Vertice<T>> visitados, boolean[] marcas, ColaGenerica<Vertice<T>> cola) {
		marcas[vert.getPosicion()] = true;
		
		cola.encolar(vert);
		
		while (!cola.esVacia()) {
			Vertice<T> visitar = cola.desencolar();
			visitados.agregarFinal(visitar);
			ListaGenerica<Arista<T>> aristas = grafo.listaDeAdyacentes(visitar);
			
			aristas.comenzar();
			
			while(!aristas.fin()) {
				Vertice<T> siguiente = aristas.proximo().verticeDestino();
				if (!marcas[siguiente.getPosicion()]) {
					marcas[siguiente.getPosicion()] = true;
					cola.encolar(siguiente);
				}
			}
		}
	}
}
