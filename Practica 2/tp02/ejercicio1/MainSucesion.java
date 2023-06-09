package tp02.ejercicio1;

import java.util.Scanner;

public class MainSucesion {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		Sucesion sc = new Sucesion();
		ListaDeEnterosEnlazada resultado = sc.calcularSucesion(s.nextInt());
		s.close();
		
		resultado.comenzar();
		
		while (!resultado.fin()) System.out.println(resultado.proximo());
	}
}