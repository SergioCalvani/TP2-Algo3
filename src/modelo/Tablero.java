package modelo;

public class Tablero {

	public void agregarBocaAbajo(Carta carta) {
		
		carta.asignarPosicion(new BocaAbajo());
	}
}
