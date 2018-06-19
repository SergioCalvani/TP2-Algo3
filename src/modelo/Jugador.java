package modelo;

import java.util.function.BooleanSupplier;

public class Jugador {

	private int puntosDeVida;
	private Lado lado;
	private Mano mano;
	boolean perdedor;
	
	public Jugador() {
		this.puntosDeVida = 7000; 
		this.mano = new Mano();
		this.perdedor = false;
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

	public boolean esPerdedor() {
		return this.puntosDeVida == 0 || this.lado.obtenerMazo().estaVacio();
	}

	public boolean esGanador() {
		return this.mano.contieneExodia();
	}



}
