package modelo;

public class Tablero {

	private Lado ladoUno;
	private Lado ladoDos;
	
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
	
	public Lado obtenerLadoEnemigo(Lado lado){
		if(ladoUno == lado){
			return ladoDos;
		}
		else{
			return ladoUno;
		}
	}
	
	public Jugador obtenerJugadorEnemigo(Jugador duenio){
		if(ladoUno == this.obtenerLadoDe(duenio)){
			return ladoDos.obtenerJugador();
		}
		else{
			return ladoUno.obtenerJugador();
		}
	}
	
	public void aplicarEfectoDeCampo(Jugador duenio,CartaDeCampo cartaCampo){
		if(ladoUno == this.obtenerLadoDe(duenio)){
			cartaCampo.efectoDuenio(ladoUno);
			cartaCampo.efectoEnemigo(ladoDos);
		}
		else{
			cartaCampo.efectoDuenio(ladoDos);
			cartaCampo.efectoEnemigo(ladoUno);
		}
	}

	public void destruirTodosLosMonstruos() {
		ladoUno.destruirTodosLosMonstruos();
		ladoDos.destruirTodosLosMonstruos();
	}

}
