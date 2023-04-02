package tp02.ejercicio4;

import tp02.ejercicio3.*;

public class TestBalanceo {
	public static char getCerradura(char apertura) {
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
	
	public static void main(String[] args) {
		PilaGenerica<Character> pila = new PilaGenerica<Character>();
		
		if (args.length < 1) {
			System.out.println("Proveer al menos un string por argumentos.");
			return;
		}
		
		for (String str : args) {
			System.out.println("Entrada: " + str);
			boolean balanceado = true;
			for (char ch : str.toCharArray()) {
				if (ch == ' ') continue; // ignorar espacios
				
				if (esApertura(ch)) {
					pila.apilar(ch); // apilar caracteres de apertura
				}
				else { // si no es ninguna de las anteriores, entonces este caracter es una cerradura
					Character ultimaApertura = pila.desapilar(); // obtener la ultima apertura
					if (ch != getCerradura(ultimaApertura)) { // si este caracter no es la cerradura correcta para la ultima apertura, el string no esta balanceado.
						balanceado = false;
						break;
					}
				}
			}
			System.out.println("Balanceado? " + balanceado + "\n");
		}
	}
}
