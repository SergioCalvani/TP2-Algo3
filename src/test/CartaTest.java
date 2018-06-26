package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import modelo.CartaMonstruo;


public class CartaTest {
	@Test
	void testCodigoDeCartas() {
		CartaMonstruo beautiful = new CartaMonstruo("Beautiful Headhuntress", 1600, 800, 4);
		assertTrue(beautiful.obtenerId() == 1);
	}
}
