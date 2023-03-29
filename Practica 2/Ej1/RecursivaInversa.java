package Ej1;

import tp02.ejercicio1.*;

public class RecursivaInversa {
	public static void ImprimirInversaRecursiva(ListaDeEnterosConArreglos lista, int pos) {
		System.out.println(lista.elemento(pos));
		
		if (pos > 1) ImprimirInversaRecursiva(lista, --pos);
	}
	
	public static void main(String[] args) {
		ListaDeEnterosConArreglos lista = new ListaDeEnterosConArreglos();
		for (String arg : args) {
			lista.agregarFinal(Integer.parseInt(arg));
		}
		
		ImprimirInversaRecursiva(lista, lista.tamanio());
	}
}