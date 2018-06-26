package modelo;


public class Yugioh {
	
	private Tablero tablero;
	private Jugador jugadorDeTurno;
	private Jugador jugadorOponente;
	
	public Yugioh(String nombre1, String nombre2) {
		this.jugadorDeTurno = new Jugador(nombre1);
		this.jugadorOponente = new Jugador(nombre2);
		this.tablero = new Tablero(jugadorDeTurno, jugadorOponente);
	}
	
	public Lado obtenerLadoUno() {
		return this.tablero.obtenerLadoUno();
	}
	
	public Lado obtenerLadoDos() {
		return this.tablero.obtenerLadoDos();
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
