package Ej5;

public class Ej5 {
	public static int[] CalcArray_arreglo (int[] numeros) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int promedio = 0;
		
		for (int numero : numeros) {
			if (numero > max) max = numero;
			if (numero < min) min = numero;
			promedio += numero;
		}
		promedio = promedio / numeros.length;
		
		return new int[] {max, min, promedio};
	}
	
	public static int max = Integer.MIN_VALUE;
	public static int min = Integer.MAX_VALUE;
	public static int promedio = 0;
	
	public static int[] CalcArray_varclases (int[] numeros) {
		
		for (int numero : numeros) {
			if (numero > max) max = numero;
			if (numero < min) min = numero;
			promedio += numero;
		}
		promedio = promedio / numeros.length;
		
		return new int[] {max, min, promedio};
	}
		
	public static void main(String[] args) {
		int[] numeros = new int[] {2, 5, 7, 9, 12, 16, 18, 20};
				
		// a. retornando un arreglo con 3 integers
		int[] resultado = CalcArray_arreglo(numeros);
		System.out.println("[RETURN ARREGLO] Max: " + resultado[0] + "; Min: " + resultado[1] + ", Promedio:" + resultado[2]);
		
		// b.
		// no se me ocurrio como hacerlo, creo que sea posible ya que java no maneja variables por referencia.
		
		// c. usando variables de clase, no es ni return, ni parametros.
		CalcArray_varclases(numeros);
		System.out.println("[VAR CLASES] Max: " + max + "; Min: " + min + ", Promedio:" + promedio);
	}
}
