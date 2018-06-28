package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Carta;
import modelo.FabricaDeCartas;
import modelo.Jugador;
import modelo.Lado;
import modelo.Mano;
import modelo.Yugioh;

class ManoTest {

	@Test
	void testManoInicialmenteNoContieneCartas() {
		Mano mano = new Mano();
		assertEquals(0, mano.obtenerTamanio());
	}
	
	@Test
	void testManoConCincoCartaAlBajarUnaQuedaConCuatro() {

		Mano mano = new Mano();
		for (int i = 0; i < 5; i++) {
			mano.agregar(FabricaDeCartas.crearCartaAleatoria());
		}
		
		mano.obtenerCarta(0);
		
		assertEquals(4, mano.obtenerTamanio());
	}
	
}
