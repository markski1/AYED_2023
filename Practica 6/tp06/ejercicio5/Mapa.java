package tp06.ejercicio5;

import tp02.ejercicio2.*;
import tp06.ejercicio3.*;

public class Mapa {
	private Grafo<String> mapaCiudades;
	
	public Mapa(Grafo<String> mapaCiudades) {
		this.mapaCiudades = mapaCiudades;
	}
	
	public ListaGenerica<String> devolverCamino(String ciudad1, String ciudad2) {
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<>();
		ListaGenerica<String> caminoAux = new ListaEnlazadaGenerica<>();
		
		boolean[] marcas = new boolean[mapaCiudades.listaDeVertices().tamanio() + 1];
		
		Vertice<String> comienzo = encontrarCiudad(ciudad1); 
		
		if (comienzo == null)
			return camino;
		
		buscarCamino(comienzo, ciudad2, marcas, camino, caminoAux);
		
		return camino;
	}
	
	public ListaGenerica<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, ListaGenerica<String> ciudades) {
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<>();
		ListaGenerica<String> caminoAux = new ListaEnlazadaGenerica<>();
		
		boolean[] marcas = new boolean[mapaCiudades.listaDeVertices().tamanio() + 1];
		
		Vertice<String> comienzo = encontrarCiudad(ciudad1); 
		
		if (comienzo == null)
			return camino;
		
		ciudades.comenzar();
		while (!ciudades.fin()) {
			Vertice<String> excepcion = encontrarCiudad(ciudades.proximo());
			if (excepcion != null)
				marcas[excepcion.getPosicion()] = true;
		}
		
		buscarCamino(comienzo, ciudad2, marcas, camino, caminoAux);
		
		return camino;
	}

	
	private void buscarCamino(Vertice<String> comienzo, String ciudad2, boolean[] marcas, ListaGenerica<String> camino, ListaGenerica<String> caminoAux) {
		marcas[comienzo.getPosicion()] = true;
		
		caminoAux.agregarFinal(comienzo.dato());
		
		if (comienzo.dato().equals(ciudad2))
			agregarCamino(caminoAux, camino);
		
		if (!camino.esVacia()) return;
		
		ListaGenerica<Arista<String>> aristas = mapaCiudades.listaDeAdyacentes(comienzo);
		aristas.comenzar();
		
		while (!aristas.fin()) {
			Vertice<String> vert = aristas.proximo().verticeDestino();
			if (!marcas[vert.getPosicion()])
				buscarCamino(vert, ciudad2, marcas, camino, caminoAux);
			
			if (!camino.esVacia()) break;
		}
		
		caminoAux.eliminarEn(caminoAux.tamanio());
	}

	private void agregarCamino(ListaGenerica<String> caminoAux, ListaGenerica<String> camino) {
		caminoAux.comenzar();
		
		while (!caminoAux.fin())
			camino.agregarFinal(caminoAux.proximo());
	}

	private Vertice<String> encontrarCiudad(String ciudad) {
		ListaGenerica<Vertice<String>> listaCiudades = mapaCiudades.listaDeVertices();
		
		listaCiudades.comenzar();
		
		while (!listaCiudades.fin()) {
			Vertice<String> actual = listaCiudades.proximo();
			
			if (actual.dato().equals(ciudad)) {
				return actual;
			}
		}
		
		return null;
	}
}
