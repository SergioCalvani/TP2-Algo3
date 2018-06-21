package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import excepciones.ImposibleAtacarEnEstadoDeDefensaException;
import modelo.CartaMonstruo;

class CartaMonstruoTest {

	@Test
	void testUnMonstruoAtacaEnEstadoDeDefensaYLanzaError() {
		CartaMonstruo amazon = new CartaMonstruo("Amazon of the Seas", 1300, 1400, 4);
		CartaMonstruo beautiful = new CartaMonstruo("Beautiful Headhuntress", 1600, 800, 4);
		
		amazon.cambiarAPosicionDeDefensa();
		
		boolean atrapada = false;
		try {
			amazon.atacarA(beautiful);
		} catch(ImposibleAtacarEnEstadoDeDefensaException e) {
			atrapada = true;
		}
		assertTrue(atrapada);
	}
	
}
