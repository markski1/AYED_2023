package tp02.ejercicio1;

public class TestListaDeEnterosEnlazada {
	private static ListaDeEnterosEnlazada lista = new ListaDeEnterosEnlazada();
	
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
