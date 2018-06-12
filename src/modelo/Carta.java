package modelo;

public abstract class Carta {
	
	private String nombre;
	private Efecto efecto;
	private Posicion posicion;
	
	public Carta() {
	
		this.nombre = "";
	}
	
	public String getNombre() {
		return this.nombre;
	}
}
