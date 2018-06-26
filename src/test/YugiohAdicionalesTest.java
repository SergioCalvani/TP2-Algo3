package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Jugador;
import modelo.Mano;
import modelo.Yugioh;

class YugiohAdicionalesTest {

	@Test
	void testEnElPrimerTurnoTengoAUnJugadorYSuOponenteQueSonDistintos() {
		Yugioh yugioh = new Yugioh("JugadorUno","JugadorDos");
		Jugador jugadorDeTurno = yugioh.obtenerJugadorDeTurno();
		Jugador jugadorOponente = yugioh.obtenerJugadorOponente();
		assertNotEquals(jugadorDeTurno, jugadorOponente);
	}
	
	@Test
	void testEnElPrimerTurnoTengoAUnJugadorDeTurnoYEnElSiguienteEsOtro() {
		Yugioh yugioh = new Yugioh("JugadorUno","JugadorDos");
		Jugador jugadorDeTurno1 = yugioh.obtenerJugadorDeTurno();
		yugioh.siguienteTurno();
		Jugador jugadorDeTurno2 = yugioh.obtenerJugadorDeTurno();
		assertNotEquals(jugadorDeTurno1, jugadorDeTurno2);
	}

	@Test
	void testEnElPrimerTurnoTengoAUnJugadorYDosTurnosDespuesTengoAlMismo() {
		Yugioh yugioh = new Yugioh("JugadorUno","JugadorDos");
		Jugador jugadorDeTurno1 = yugioh.obtenerJugadorDeTurno();
		yugioh.siguienteTurno();
		yugioh.siguienteTurno();
		Jugador jugadorDeTurno3 = yugioh.obtenerJugadorDeTurno();
		
		assertEquals(jugadorDeTurno1, jugadorDeTurno3);
	}
	
	@Test
	void testSeCreaYugiohYElJugadorDeTurnoCuentaConCincoCartasEnSuMano() {
		Yugioh yugioh = new Yugioh("JugadorUno", "JugadorDos");
		Jugador jugador = yugioh.obtenerJugadorDeTurno();
		Mano mano = jugador.obtenerMano();
		
		assertEquals(5, mano.obtenerTamanio());	
	}
	
	@Test
	void testSeCreaYugiohYElJugadorOponenteCuentaConCincoCartasEnSuMano() {
		Yugioh yugioh = new Yugioh("JugadorUno", "JugadorDos");
		Jugador jugador = yugioh.obtenerJugadorOponente();
		Mano mano = jugador.obtenerMano();
		assertEquals(5, mano.obtenerTamanio());	
	}
}
