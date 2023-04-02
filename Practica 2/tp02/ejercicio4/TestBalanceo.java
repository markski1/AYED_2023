package tp02.ejercicio4;

import tp02.ejercicio3.*;

public class TestBalanceo {
	public static char getOpuesto(char apertura) {
		switch (apertura) {
			case '(': return ')';
			case '[': return ']';
			case '{': return '}';
		}
		return '?';
	}
	
	public static boolean esApertura(char caracter) {
		switch (caracter) {
			case '(', '[', '{': return true;
		}
		return false;
	}
	
	public static boolean esBalanceado(String str) {
		PilaGenerica<Character> pila = new PilaGenerica<Character>();

		// convertir el string en arreglo de caracteres, y recorrer caracter por caracter
		for (char ch : str.toCharArray()) { 
			if (ch == ' ') continue;
			
			if (esApertura(ch)) {
				pila.apilar(ch);
			}
			else { // si no es un espacio ni caracter de apertura, entonces es un caracter opuesto.
				Character ultimaApertura = pila.desapilar(); // obtener la ultima apertura
				if (ch != getOpuesto(ultimaApertura)) { // si no es el opuesto correcto para la ultima apertura, el string no esta balanceado.
					return false;
				}
			}
		}
		
		// si el for termina sin retornar false, entonces esta balanceado.
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
