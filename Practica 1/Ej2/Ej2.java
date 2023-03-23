package Ej2;
import java.util.Scanner;

public class Ej2 {
	public static int[] MultiplosDe(int n) {
		int[] arreglo = new int[n];
		
		for (int i = 0; i < n; i++) {
			arreglo[i] = (i + 1) * n;
		}
		
		return arreglo;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("Ingrese N: ");
		int n = s.nextInt();
		
		int[] arreglo = new int[n];
		
		arreglo = MultiplosDe(n);
		
		for (int i = 0; i < n; i++) {
			System.out.print(arreglo[i] + ", ");
		}
		
		System.out.println("\n\n Finalizado");
		
		s.close();
	}
}
