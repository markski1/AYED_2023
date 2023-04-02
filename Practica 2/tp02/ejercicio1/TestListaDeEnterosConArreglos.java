package tp02.ejercicio1;

public class TestListaDeEnterosConArreglos {
	private static ListaDeEnterosConArreglos lista = new ListaDeEnterosConArreglos();
	
	public static void main(String[] args) {
		for (String arg : args) {
			lista.agregarFinal(Integer.parseInt(arg));
		}

		lista.comenzar();
		
		while (!lista.fin()) {
			System.out.println(lista.proximo());
		}
	}
}
