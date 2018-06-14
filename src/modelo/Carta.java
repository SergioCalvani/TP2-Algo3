package modelo;

public class Carta {

	private String nombre;
	private int nivel;
	private boolean bocaArriba;
	
	public Carta(String nombre) {
		this.nombre = nombre;
		this.bocaArriba = false;
	}
	
	public boolean estaBocaAbajo() {
		return !this.bocaArriba;
	}
}
