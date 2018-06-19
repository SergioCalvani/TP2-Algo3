package modelo;

import java.util.function.BooleanSupplier;

public class Yugioh {
	
	private Tablero tablero;
	private Jugador jugadorUno;
	private Jugador jugadorDos;
	private boolean terminado;
	
	public Yugioh() {
		this.jugadorUno = new Jugador();
		this.jugadorDos = new Jugador();
		this.tablero = new Tablero(jugadorUno, jugadorDos);
		this.terminado = false;
	}

	public Tablero obtenerTablero() {
		return this.tablero;
	}

	public Jugador obtenerJugadorUno() {
		return this.jugadorUno;
	}

	public Jugador obtenerJugadorDos() {
		return this.jugadorDos;
	}
	
	public boolean estaTerminado() {
		return this.jugadorUno.esPerdedor() || this.jugadorDos.esPerdedor() 
			   || this.jugadorUno.esGanador() || this.jugadorDos.esGanador();
	}
}
