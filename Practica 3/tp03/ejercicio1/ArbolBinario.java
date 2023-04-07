package tp03.ejercicio1;

import tp03.reqs.*;

public class ArbolBinario<T> {
	private T dato;
	private ArbolBinario<T> hijoIzquierdo;   
	private ArbolBinario<T> hijoDerecho; 

	
	public ArbolBinario() {
		super();
	}

	public ArbolBinario(T dato) {
		this.dato = dato;
	}

	/*
	 * getters y setters
	 * 
	 */
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}
	
	/**
	 * Preguntar antes de invocar si tieneHijoIzquierdo()
	 * @return
	 */
	public ArbolBinario<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinario<T> getHijoDerecho() {
		return this.hijoDerecho;

	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo;
	}

	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = null;
	}

	public void eliminarHijoDerecho() {
		this.hijoDerecho = null;
	}

	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

	}

	@Override
	public String toString() {
		return this.getDato().toString();
	}

	 
	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo!=null;
	}

	 
	public boolean tieneHijoDerecho() {
		return this.hijoDerecho!=null;
	}

	public int contarHojas() {
		if (this.esHoja()) return 1;
		
		int cuenta = 0;
		if (this.tieneHijoIzquierdo())
			cuenta += hijoIzquierdo.contarHojas();
		if (this.tieneHijoDerecho())
			cuenta += hijoDerecho.contarHojas();
		
		return cuenta;
	}
	
    public ArbolBinario<T> espejo() {
    	ArbolBinario<T> arbolEspejo = new ArbolBinario<T>(dato);
    	
		if (this.tieneHijoIzquierdo())
			arbolEspejo.agregarHijoDerecho(hijoIzquierdo.espejo());
		if (this.tieneHijoDerecho())
			arbolEspejo.agregarHijoIzquierdo(hijoDerecho.espejo());
		
		return arbolEspejo;
	}

	public void entreNiveles(int n, int m) {
		ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<>();
		cola.encolar(this);
		cola.encolar(null);
		
		int nivel = 0;
		while (!cola.esVacia()) {
			ArbolBinario<T> actual = cola.desencolar();
			
			while (!cola.esVacia() && actual != null) {
				if (nivel >= n)
					System.out.println(actual.getDato());
				if (actual.tieneHijoDerecho())
					cola.encolar(actual.getHijoDerecho());
				if (actual.tieneHijoIzquierdo())
					cola.encolar(actual.getHijoIzquierdo());
			}
			
			if (!cola.esVacia()) {
				if (++nivel > m)
					break;
				
				cola.encolar(null);
			}
		}
	}
}
