package modelo;

public class Jugador {

	private int puntosDeVida;
	private Lado lado;
	private Mano mano;
	
	public Jugador() {
		this.puntosDeVida = 7000; 
		this.mano = new Mano();
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

	public Mano obtenerMano() {
		return this.mano;
	}



}
