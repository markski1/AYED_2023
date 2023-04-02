package tp02.ejercicio3;

public class ColaGenerica<T> {
	private NodoColaGenerica<T> primero = null;
	private NodoColaGenerica<T> ultimo = null;
	
	public void encolar(T elem) {
		NodoColaGenerica<T> nuevo = new NodoColaGenerica<T>();
		nuevo.setDato(elem);
		if (primero == null) {
			primero = nuevo;
		}
		else {
			if (ultimo == null) {
				ultimo = primero;
			}
			nuevo.setSiguiente(ultimo);
			ultimo.setAnterior(nuevo);
			ultimo = nuevo;
		}
			
	}
	
	public T desencolar() {
		NodoColaGenerica<T> devolver = primero;
		primero = primero.getAnterior();
		return devolver.getDato();
	}
	
	public T tope() {
		return primero.getDato();
	}
	
	public boolean esVacia() {
		return primero == null;
	}
}