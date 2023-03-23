package Ej1;

public class Ej1 {
	public static void ej1_for(int a, int b) {
		for (int i = a; i <= b; i++) {
			System.out.println(i);
		}
	}
	
	public static void ej1_while(int a, int b) {
		while (a <= b) {
			System.out.println(a);
			a++;
		}
	}
	
	public static void ej1_rec(int a, int b) {
		System.out.println(a);
		if (a < b) {
			ej1_rec(++a, b);
		}
	}
	
	public static void main(String[] args) {
		ej1_for(-5, 5);
		ej1_while(-5, 5);
		ej1_rec(-5, 5);
	}
}
