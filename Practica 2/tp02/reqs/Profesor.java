package tp02.reqs;

public class Profesor {
	String nombre;
	String apellido;
	String email;
	String catedra;
	String facultad;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCatedra() {
		return catedra;
	}
	public void setCatedra(String catedra) {
		this.catedra = catedra;
	}
	public String getFacultad() {
		return facultad;
	}
	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}
	
	public String tusDatos() {
		String datos = "";
		
		datos += "Nombre: " + getNombre() + "\n";
		datos += "Apellido: " + getApellido() + "\n";
		datos += "Email: " + getEmail() + "\n";
		datos += "Catedra: " + getCatedra() + "\n";
		datos += "Facultad: " + getFacultad() + "\n";
		
		return datos;
	}
}
