package Ej3;

public class Test {
	public static void main(String[] args) {
		Estudiante[] estudiantes = new Estudiante[2];
		Profesor[] profesores = new Profesor[3];
		
		// crear instancias de...
		for (int i = 0; i < estudiantes.length; i++) {
			estudiantes[i] = new Estudiante();
			estudiantes[i].setNombre("juan");
			estudiantes[i].setApellido("perez");
			estudiantes[i].setDireccion("calle falsa 123");
			estudiantes[i].setEmail("asd@yandex.ru");
			estudiantes[i].setComision("1A");
		}
		
		for (int i = 0; i < profesores.length; i++) {
			profesores[i] = new Profesor();
			profesores[i].setNombre("carlos");
			profesores[i].setApellido("hernandez");
			profesores[i].setEmail("dsa@unlp.edu.ar");
			profesores[i].setCatedra("1A");
			profesores[i].setFacultad("informatica");
		}
		
		
		
		for (Estudiante estudiante: estudiantes) {
			System.out.println(estudiante.tusDatos());
		}
		
		for (Profesor profesor : profesores) {
			System.out.println(profesor.tusDatos());
		}
	}
}
