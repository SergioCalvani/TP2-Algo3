package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class YugiohTest {

	@Test
	void testColocarUnaCartaMonstruoEnPosicionDeAtaque() {
		fail("Not yet implemented");
	}
	
	@Test
	void testColocarUnaCartaMonstruoEnPosicionDeDefensa() {
		Tablero tablero = new Tablero();
		CartaMonstruo monstruo = new CartaMonstruo("bicho", 600, 900);//600 atk, 900 def
		tablero.agregarMonstruoEnPosicionDeDefensa(monstruo);
		
		assertTrue(!monstruo.EstaEnPosicionOfensiva());	
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
