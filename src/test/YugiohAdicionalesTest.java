package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Jugador;
import modelo.Yugioh;

class YugiohAdicionalesTest {

	@Test
	void testEnElPrimerTurnoTengoAUnJugadorYSuOponenteQueSonDistintos() {
		Yugioh yugioh = new Yugioh();
		Jugador jugadorDeTurno = yugioh.obtenerJugadorDeTurno();
		Jugador jugadorOponente = yugioh.obtenerJugadorOponente();
		assertNotEquals(jugadorDeTurno, jugadorOponente);
	}
	
	@Test
	void testEnElPrimerTurnoTengoAUnJugadorDeTurnoYEnElSiguienteEsOtro() {
		Yugioh yugioh = new Yugioh();
		Jugador jugadorDeTurno1 = yugioh.obtenerJugadorDeTurno();
		yugioh.siguienteTurno();
		Jugador jugadorDeTurno2 = yugioh.obtenerJugadorDeTurno();
		assertNotEquals(jugadorDeTurno1, jugadorDeTurno2);
	}

	@Test
	void testEnElPrimerTurnoTengoAUnJugadorYDosTurnosDespuesTengoAlMismo() {
		Yugioh yugioh = new Yugioh();
		Jugador jugadorDeTurno1 = yugioh.obtenerJugadorDeTurno();
		yugioh.siguienteTurno();
		yugioh.siguienteTurno();
		Jugador jugadorDeTurno3 = yugioh.obtenerJugadorDeTurno();
		assertEquals(jugadorDeTurno1, jugadorDeTurno3);
	}
}
