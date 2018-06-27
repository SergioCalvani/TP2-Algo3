package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.FabricaDeCartas;
import modelo.Mano;

class ManoTest {

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
