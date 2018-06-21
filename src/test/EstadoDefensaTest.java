package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import excepciones.ImposibleAtacarEnEstadoDeDefensaException;
import modelo.CartaMonstruo;
import modelo.EstadoDefensa;

class EstadoDefensaTest {

	@Test
	void testSeIntentaAtacar() {
		CartaMonstruo amazon = new CartaMonstruo("Amazon of the Seas", 1300, 1400, 4);
		CartaMonstruo beautiful = new CartaMonstruo("Beautiful Headhuntress", 1600, 800, 4);
		
		EstadoDefensa estadoDeDefensa = new EstadoDefensa(amazon.extraerPuntosDefensa());
		
		// Se ataca a beautiful con amazon estando amazon en estado de defensa.
		boolean atrapada = false;
		try {
			estadoDeDefensa.atacarA(beautiful, amazon);
		} catch (ImposibleAtacarEnEstadoDeDefensaException e) {
			atrapada = true;
		}
		assertTrue(atrapada);
	}
}
