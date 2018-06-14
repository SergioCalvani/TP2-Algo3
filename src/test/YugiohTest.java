package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import modelo.AgujeroOscuro;
import modelo.CartaMagica;
import modelo.CartaMonstruo;
import modelo.CartaTrampa;
import modelo.CilindroMagico;
import modelo.Jugador;
import modelo.Lado;
import modelo.Tablero;
import modelo.Yugioh;

class YugiohTest {

	@Test
	void testColorCartaMonstruoEnPosicionDeAtaque() {
		Yugioh yugioh = new Yugioh();
		Tablero tablero = yugioh.obtenerTablero();
		Jugador jugador = yugioh.obtenerJugadorUno();
		Lado lado = tablero.obtenerLadoDe(jugador);
		
		CartaMonstruo monstruo = new CartaMonstruo("Huevo Monstruoso", 600, 900, 3);
		lado.colocar(monstruo, 0);
		
		// Por defecto coloca una carta en posicion de ataque
		assertTrue(monstruo.estaEnPosicionDeAtaque());
	}
	
	@Test
	void testColorCartaMonstruoEnPosicionDeDefensa() {
		Yugioh yugioh = new Yugioh();
		Tablero tablero = yugioh.obtenerTablero();
		Jugador jugador = yugioh.obtenerJugadorUno();
		Lado lado = tablero.obtenerLadoDe(jugador);
		
		CartaMonstruo monstruo = new CartaMonstruo("Huevo Monstruoso", 600, 900, 3);
		lado.colocar(monstruo, 0);
		lado.cambiarAPosicionDeDefensaMonstruo(0);
		
		assertTrue(monstruo.estaEnPosicionDeDefensa());
	}	
	
	@Test
	void testColocarUnaCartaMagicaEnElCampoBocaAbajo() {
		Yugioh yugioh = new Yugioh();
		Tablero tablero = yugioh.obtenerTablero();
		Jugador jugador = yugioh.obtenerJugadorUno();
		Lado lado = tablero.obtenerLadoDe(jugador);

		CartaMagica magica = new AgujeroOscuro();
		lado.colocar(magica, 0);

		// Por defecto se agregan las cartas magicas boca abajo
		assertTrue(magica.estaBocaAbajo());
	}
	
	@Test
	void testColocarUnaCartaTrampaEnElCampoBocaAbajo() {
		Yugioh yugioh = new Yugioh();
		Tablero tablero = yugioh.obtenerTablero();
		Jugador jugador = yugioh.obtenerJugadorUno();
		Lado lado = tablero.obtenerLadoDe(jugador);

		CartaTrampa trampa = new CilindroMagico();
		lado.colocar(trampa, 0);

		// Por defecto se agregan las cartas trampa boca abajo 
		assertTrue(trampa.estaBocaAbajo());
	}
	
	@Test
	void testMandarUnaCartaAlCementerioYVerificarQueEsteAhi() {
		Yugioh yugioh = new Yugioh();
		Tablero tablero = yugioh.obtenerTablero();
		Jugador jugador = yugioh.obtenerJugadorUno();
		Lado lado = tablero.obtenerLadoDe(jugador);

		CartaMonstruo monstruo = new CartaMonstruo("Huevo Monstruoso", 600, 900, 3);
		lado.colocar(monstruo, 0);
		lado.destruirCartaMonstruo(0);
		
		assertTrue(lado.cementerioContiene(monstruo));	
	}
	
	@Test
	void testAmbosMonstruosEnAtaquePeroMiMonstruoTieneMenosAtaqueQueElOponente() {
		Yugioh yugioh = new Yugioh();
		Tablero tablero = yugioh.obtenerTablero();
		Jugador jugadorUno = yugioh.obtenerJugadorUno();
		Jugador jugadorDos = yugioh.obtenerJugadorDos();
		Lado ladoUno = tablero.obtenerLadoDe(jugadorUno);
		Lado ladoDos = tablero.obtenerLadoDe(jugadorDos);

		CartaMonstruo amazon = new CartaMonstruo("Amazon of the Seas", 1300, 1400, 4);
		ladoUno.colocar(amazon, 0);

		CartaMonstruo beautiful = new CartaMonstruo("Beautiful Headhuntress", 1600, 800, 4);
		ladoDos.colocar(beautiful, 0);

		amazon.atacarA(beautiful);
		
		// diferencia de ataque = 300
		// Se restan de jugadorUno y queda 6700.
		assertEquals(6700, jugadorUno.obtenerVida());
	}
}
