package tp02.ejercicio4;

import tp02.ejercicio3.*;

public class TestBalanceo {
	public static char getOpuesto(char apertura) {
		switch (apertura) {
			case '(': return ')';
			case '[': return ']';
			case '{': return '}';
		}
		return '?'; // no deberia pasar
	}
	
	public static boolean esApertura(char caracter) {
		switch (caracter) {
			case '(', '[', '{': return true;
		}
		return false;
	}
	
	public static boolean esBalanceado(String str) {
		PilaGenerica<Character> pila = new PilaGenerica<Character>();

		// recorremos el string, caracter por caracter.
		for (char ch : str.toCharArray()) { 
			if (ch == ' ') continue;
			
			if (esApertura(ch)) {
				pila.apilar(ch);
				continue;
			}
			else // si no es un espacio ni caracter de apertura, entonces es un caracter opuesto.
			{ 
				if (pila.esVacia()) return false; // si la pila esta vacia, entonces este opuesto esta de mas y no hay balance.
				
				Character ultimaApertura = pila.desapilar(); // obtener la ultima apertura
				if (ch != getOpuesto(ultimaApertura)) { // si no es el opuesto correcto para la ultima apertura, el string no esta balanceado.
					return false;
				}
			}
		}
		
		// si quedaron cosas en la pila sin resolver, no esta balanceado.
		if (!pila.esVacia()) return false;
		
		// si nada de lo de arriba falló, esta balanceado.
		return true;
	}
	
	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("Proveer al menos un string por argumentos.");
			return;
		}
		
		boolean balanceado;
		
		for (String str : args) {
			System.out.println("Entrada: " + str);
			balanceado = esBalanceado(str);
			System.out.println("Balanceado? " + balanceado + "\n");
		}
	}
}
