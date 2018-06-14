package modelo;

public class Jugador {

	private int puntosDeVida;
	private Lado lado;
	
	public Jugador() {
		this.puntosDeVida = 7000; 
	}
	
	public void disminuirVidaEn(int danio) {
		this.puntosDeVida -= danio;
	}

	public void asignarLado(Lado lado) {
		this.lado = lado;
	}

	public Lado obtenerLado() {
		return this.lado;
	}
	
	public int obtenerVida() {
		return this.puntosDeVida;
	}

}
