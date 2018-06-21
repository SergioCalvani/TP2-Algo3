package modelo;


public class Yugioh {
	
	private Tablero tablero;
	private Jugador jugadorDeTurno;
	private Jugador jugadorOponente;
	
	public Yugioh() {
		this.jugadorDeTurno = new Jugador();
		this.jugadorOponente = new Jugador();
		this.tablero = new Tablero(jugadorDeTurno, jugadorOponente);
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
