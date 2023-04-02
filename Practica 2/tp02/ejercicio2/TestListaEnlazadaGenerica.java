package tp02.ejercicio2;

import tp02.reqs.*; // tp02.reqs tiene clases de la practica 1 requeridas aca
                    // como estoy haciendo las cosas en source folders separadas,
                    // no puedo importarlas directamente desde ahi.

public class TestListaEnlazadaGenerica {
	;
	public static void main(String[] args) {
		Estudiante estudiante;
		ListaEnlazadaGenerica<Estudiante> lista = new ListaEnlazadaGenerica<Estudiante>();
		
		for (int i = 0; i < 4; i++) {
			estudiante = new Estudiante();
			estudiante.setNombre("Jose");
			estudiante.setApellido("Hernandez " + i);
			estudiante.setComision(i + "B");
			estudiante.setDireccion("Calle falsa 12" + i);
			estudiante.setEmail("josehernandez_" + i + "@outlook.com");
			lista.agregarFinal(estudiante);
		}
		
		lista.comenzar();
		
		while (!lista.fin()) {
			System.out.println(lista.proximo().tusDatos());
		}
	}
}
