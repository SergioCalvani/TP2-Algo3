package modelo;


public class Yugioh {
	
	private Tablero tablero;
	private Jugador jugadorDeTurno;
	private Jugador jugadorOponente;
	private Fase fase;
	
	public Yugioh(String nombre1, String nombre2) {
		this.jugadorDeTurno = new Jugador(nombre1);
		this.jugadorOponente = new Jugador(nombre2);
		this.tablero = new Tablero(jugadorDeTurno, jugadorOponente);
		this.fase = new FaseInicial(this);
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
		this.fase.siguiente();
		this.fase.siguiente();
		this.fase.siguiente();
		this.fase.siguiente();
	}
	
	public void intercambiarJugadores() {
		Jugador temporal = this.jugadorDeTurno;
		this.jugadorDeTurno = this.jugadorOponente;
		this.jugadorOponente = temporal;
	}
	
	public boolean estaTerminado() {
		return this.jugadorDeTurno.esPerdedor() || this.jugadorOponente.esPerdedor() 
			   || this.jugadorDeTurno.esGanador() || this.jugadorOponente.esGanador();
	}

	public void siguienteFase() {
		this.fase.siguiente();
	}

	public void asignarFase(Fase unaFase) {
		this.fase = unaFase;
	}
}
