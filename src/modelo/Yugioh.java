package modelo;

public class Yugioh {
	
	private Tablero tablero;
	private Jugador jugadorUno;
	private Jugador jugadorDos;
	
	public Yugioh() {
		this.jugadorUno = new Jugador();
		this.jugadorDos = new Jugador();
		this.tablero = new Tablero(jugadorUno, jugadorDos);
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
}
