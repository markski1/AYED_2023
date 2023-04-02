package tp02.ejercicio3;

import tp02.ejercicio2.*;

public class PilaGenerica<T> {
	private NodoGenerico<T> tope = null;
	
	public void apilar(T elem) {
		NodoGenerico<T> nuevo = new NodoGenerico<T>();
		nuevo.setDato(elem);
		if (tope == null) {
			tope = nuevo;
		}
		else {
			nuevo.setSiguiente(tope);
			tope = nuevo;
		}
	}
	
	public T desapilar() {
		NodoGenerico<T> devolver = tope;
		tope = tope.getSiguiente();
		return devolver.getDato();
	}
	
	public T tope() {
		return tope.getDato();
	}
	
	public boolean esVacia() {
		return tope == null;
	}
}