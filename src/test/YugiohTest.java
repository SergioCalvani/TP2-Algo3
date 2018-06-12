package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.CartaMagica;
import modelo.Tablero;

class YugiohTest {

	@Test
	void testColocarUnaCartaMonstruoEnPosicionDeAtaque() {
		fail("Not yet implemented");
	}
	
	@Test
	void testColocarUnaCartaMonstruoEnPosicionDeDefensa() {

	}
	
	@Test
	void testColocarUnaCartaMagicaBocaAbajo() {
		CartaMagica cartaMagica = new CartaMagica();
		Tablero tablero = new Tablero();
		tablero.agregarBocaAbajo(cartaMagica);
		
		assertTrue(cartaMagica.estaBocaAbajo());
	}
	
	@Test
	void testColocarUnaCartaTrampaBocaAbajo() {
		
	}

}
