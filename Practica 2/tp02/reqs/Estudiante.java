package tp02.reqs;

public class Estudiante {
	String nombre;
	String apellido;
	String comision;
	String email;
	String direccion;
	
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
	public String getComision() {
		return comision;
	}
	public void setComision(String comision) {
		this.comision = comision;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String tusDatos() {
		String datos = "";
		
		datos += "Nombre: " + getNombre() + "\n";
		datos += "Apellido: " + getApellido() + "\n";
		datos += "Email: " + getEmail() + "\n";
		datos += "Comision: " + getComision() + "\n";
		datos += "Direccion: " + getDireccion() + "\n";
		
		return datos;
	}
}
