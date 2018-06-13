package modelo;

public abstract class Carta {
	
	protected String nombre;
	private Efecto efecto;
	private Posicion posicion;
	
	public Carta() {
	
		this.nombre = "";
	}
	
	public String obtenerNombre() {
		return this.nombre;
	}
	
	public void asignarPosicion(Posicion unaPosicion) {
		this.posicion = unaPosicion;
	}
	
	public boolean estaBocaAbajo() {
		return posicion.estaBocaAbajo();
	}
}
