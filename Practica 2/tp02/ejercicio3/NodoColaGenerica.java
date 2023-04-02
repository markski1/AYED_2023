package tp02.ejercicio3;

import tp02.ejercicio2.*;

public class NodoColaGenerica<T> extends NodoGenerico<T> {
	private NodoColaGenerica<T> anterior;
	private NodoColaGenerica<T> siguiente;

	public NodoColaGenerica<T> getAnterior() {
		return anterior;
	}

	public void setAnterior(NodoColaGenerica<T> anterior) {
		this.anterior = anterior;
	}

	@ Override
	public NodoColaGenerica<T> getSiguiente() {
		return siguiente;
	}
	
	public void setSiguiente(NodoColaGenerica<T> siguiente) {
		this.siguiente = siguiente;
	}
}
