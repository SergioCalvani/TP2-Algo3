package modelo;

import java.util.function.BooleanSupplier;

public class Yugioh {
	
	private Tablero tablero;
	private Jugador jugadorDeTurno;
	private Jugador jugadorOponente;
	private boolean terminado;
	
	public Yugioh() {
		this.jugadorDeTurno = new Jugador();
		this.jugadorOponente = new Jugador();
		this.tablero = new Tablero(jugadorDeTurno, jugadorOponente);
		this.terminado = false;
	}

	public Tablero obtenerTablero() {
		return this.tablero;
	}

	public Jugador obtenerJugadorDeTurno() {
		return this.jugadorDeTurno;
	}

	public Jugador obtenerJugadorOponente() {
		return this.jugadorOponente;
	}
	
	public void siguienteTurno() {
		Jugador temporal = this.jugadorDeTurno;
		this.jugadorDeTurno = this.jugadorOponente;
		this.jugadorOponente = temporal;
	}
	
	public boolean estaTerminado() {
		return this.jugadorDeTurno.esPerdedor() || this.jugadorOponente.esPerdedor() 
			   || this.jugadorDeTurno.esGanador() || this.jugadorOponente.esGanador();
	}
}
