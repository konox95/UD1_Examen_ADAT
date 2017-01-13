package Liga;

public class Jugadores {
	String nombre;
	String apellido;
	String puesto;
	int altura;
	String equipo;
	
	
	public Jugadores(){}
	
	public Jugadores(String nombre , String apellido , String puesto, int altura, String equipo){
		this.nombre = nombre;
		this.apellido = apellido;
		this.puesto = puesto;
		this.altura = altura;
		this.equipo = equipo;
		
	}

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

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}
}
