package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Carta;
import modelo.Jugador;
import modelo.Lado;
import modelo.Mano;
import modelo.Mazo;
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
	
	@Test
	void testModoDeJuego() {
		
		// Se crea yugioh,con dos jugadores, cada uno con 5 cartas
		// en su mano.
		Yugioh yugioh = new Yugioh("Jugador 1", "Jugador 2");
		// Solo nos importa el jugador de turno en su turno.
		// Obtenemos sus elementos de juego.
		Jugador jugador = yugioh.obtenerJugadorDeTurno();
		Lado lado = jugador.obtenerLado();
		Mano mano = jugador.obtenerMano();
		Mazo mazo = lado.obtenerMazo();
		
		// Fase Inicial: Robamos una carta y terminamos la fase
		mano.agregar(mazo.robar());
		yugioh.siguienteFase();
		
		// Fase de preparacion: Se puede bajar solo 1 carta monstruo.
		// pero no hay limite de magicas o trampa.
		Carta carta = mano.obtenerCarta(0);
		lado.colocar(carta);
		// termino la fase "presionando el boton siguiente fase"
		yugioh.siguienteFase();
		
		// Fase de ataque: Puedo elegir un monstruo y atacar
		// No se que monstruos tengo asi que paso.
		yugioh.siguienteFase();
		
		// Fase final: se puede activar cartas magicas de la zonaMagica.
		yugioh.siguienteFase();
		
		// Despues de la final se cambian los jugadores, ahora jugadorDeTurno es el otro.
		Jugador otroJugador = yugioh.obtenerJugadorDeTurno();
		
		//Verifico que son distintos.
		assertNotEquals(jugador, otroJugador);
		
		// Verifico que no se termino el juego.
		assertFalse(yugioh.estaTerminado());
	}
}
