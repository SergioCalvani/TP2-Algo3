package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Carta;

class CartaTest {

	@Test
	void test() {
		Carta carta = new Carta();
		assertEquals(carta.getNombre(), "");
	}
}
