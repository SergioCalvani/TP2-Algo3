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
	
<<<<<<< HEAD
}
=======
	public void asignarPosicion(Posicion unaPosicion) {
		this.posicion = unaPosicion;
	}
	
	public boolean estaBocaAbajo() {
		return posicion.estaBocaAbajo();
	}
}
>>>>>>> branch 'master' of https://github.com/SergioCalvani/TP2-Algo3
