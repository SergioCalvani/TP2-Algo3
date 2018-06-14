package modelo;

public class Tablero {

	Lado ladoUno;
	Lado ladoDos;
	
	public Tablero(Jugador jugadorUno, Jugador jugadorDos) {
		this.ladoUno = new Lado(jugadorUno, this);
		this.ladoDos = new Lado(jugadorDos, this);
	}

	public Lado obtenerLadoDe(Jugador jugador) {
		if (ladoUno.esDuenio(jugador)) {
			return ladoUno;
		} else {
			return ladoDos;
		}
	}

	public void destruirTodosLosMonstruos() {
		ladoUno.destruirTodosLosMonstruos();
		ladoDos.destruirTodosLosMonstruos();
	}

}
