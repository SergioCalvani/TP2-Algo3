package modelo.cartas;

import modelo.CartaMagica;
import modelo.Tablero;

public class AgujeroOscuro extends CartaMagica{
	
	
	public AgujeroOscuro() {
		super("Agujero Oscuro");
	}

	@Override
	public void activar() {
		Tablero tablero = lado.obtenerTablero();
		tablero.destruirTodosLosMonstruos();
	}
}
