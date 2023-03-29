package Ej1;

import tp02.ejercicio1.*;

public class Sucesion {
	ListaDeEnterosEnlazada lista = new ListaDeEnterosEnlazada();
	public ListaDeEnterosEnlazada calcularSucesion (int n) {
		lista.agregarFinal(n);
		
		if (n == 1) return lista;
		
		if (n % 2 == 0) {
			return calcularSucesion(n / 2);
		} else {
			return calcularSucesion(3 * n + 1);
		}
	}
}