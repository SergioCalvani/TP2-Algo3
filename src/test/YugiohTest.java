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
		// yo soy el jugador uno
		Jugador jugadorUno = yugioh.obtenerJugadorUno();
		Jugador jugadorDos = yugioh.obtenerJugadorDos();
		Lado ladoUno = tablero.obtenerLadoDe(jugadorUno);
		Lado ladoDos = tablero.obtenerLadoDe(jugadorDos);

		CartaMonstruo amazon = new CartaMonstruo("Amazon of the Seas", 1300, 1400, 4);
		ladoUno.colocar(amazon, 0);

		CartaMonstruo beautiful = new CartaMonstruo("Beautiful Headhuntress", 1600, 800, 4);
		ladoDos.colocar(beautiful, 0);

		amazon.atacarA(beautiful);
		
		// Verifico que se destruyo amazon
		assertTrue(ladoUno.cementerioContiene(amazon));
		
		// diferencia de ataque = 300
		// Se restan de jugadorUno y queda 6700.
		assertEquals(6700, jugadorUno.obtenerVida());
	}
	
	@Test
	void testAmbosMonstruosEnAtaquePeroMiMonstruoTieneMayorAtaqueQueElOponente() {
		Yugioh yugioh = new Yugioh();
		Tablero tablero = yugioh.obtenerTablero();
		Jugador jugadorUno = yugioh.obtenerJugadorUno();
		Jugador jugadorDos = yugioh.obtenerJugadorDos();
		Lado ladoUno = tablero.obtenerLadoDe(jugadorUno);
		Lado ladoDos = tablero.obtenerLadoDe(jugadorDos);

		CartaMonstruo beautiful = new CartaMonstruo("Beautiful Headhuntress", 1600, 800, 4);
		ladoUno.colocar(beautiful, 0);
		
		CartaMonstruo amazon = new CartaMonstruo("Amazon of the Seas", 1300, 1400, 4);
		ladoDos.colocar(amazon, 0);

		beautiful.atacarA(amazon);
		
		// Verifico que se destruyo amazon
		assertTrue(ladoDos.cementerioContiene(amazon));
		
		// diferencia de ataque = 300
		// Se restan de jugadorDos y queda 6700.
		assertEquals(6700, jugadorDos.obtenerVida());
	}
	
	@Test
	void testAmbosMonstruosEnAtaqueYConMismoAtaque() {
		Yugioh yugioh = new Yugioh();
		Tablero tablero = yugioh.obtenerTablero();
		Jugador jugadorUno = yugioh.obtenerJugadorUno();
		Jugador jugadorDos = yugioh.obtenerJugadorDos();
		Lado ladoUno = tablero.obtenerLadoDe(jugadorUno);
		Lado ladoDos = tablero.obtenerLadoDe(jugadorDos);

		CartaMonstruo beautiful1 = new CartaMonstruo("Beautiful Headhuntress", 1600, 800, 4);
		ladoUno.colocar(beautiful1, 0);
		
		CartaMonstruo beautiful2 = new CartaMonstruo("Beautiful Headhuntress", 1600, 800, 4);
		ladoDos.colocar(beautiful2, 0);
		

		beautiful1.atacarA(beautiful2);
		
		// Verifico que se destruyeron ambas
		assertTrue(ladoUno.cementerioContiene(beautiful1));
		assertTrue(ladoDos.cementerioContiene(beautiful2));
		
		// diferencia de ataque = 0
		// Ninguno de los jugadores recibio danio
		assertEquals(7000, jugadorUno.obtenerVida());
		assertEquals(7000, jugadorDos.obtenerVida());
	}
	
	@Test
	void testMiMonstruoEnAtaqueYElOtroEnDefensaPeroMiAtaqueEsMayorQueSuDefensa() {
		Yugioh yugioh = new Yugioh();
		Tablero tablero = yugioh.obtenerTablero();
		// yo soy el jugador uno
		Jugador jugadorUno = yugioh.obtenerJugadorUno();
		Jugador jugadorDos = yugioh.obtenerJugadorDos();
		Lado ladoUno = tablero.obtenerLadoDe(jugadorUno);
		Lado ladoDos = tablero.obtenerLadoDe(jugadorDos);

		CartaMonstruo amazon = new CartaMonstruo("Amazon of the Seas", 1300, 1400, 4);
		ladoUno.colocar(amazon, 0);

		CartaMonstruo beautiful = new CartaMonstruo("Beautiful Headhuntress", 1600, 800, 4);
		ladoDos.colocar(beautiful, 0);
		ladoDos.cambiarAPosicionDeDefensaMonstruo(0);

		amazon.atacarA(beautiful);
		
		// Verifico que se destruyo beautiful
		assertTrue(ladoDos.cementerioContiene(beautiful));
		
		// diferencia de puntos = 1300 - 800 = 500.
		// Pero jugadorDos no recibe danio
		assertEquals(7000, jugadorDos.obtenerVida());
	}
	
	@Test
	void testMiMonstruoEnAtaqueYElOtroEnDefensaPeroMiAtaqueEsMenorQueSuDefensa() {
		Yugioh yugioh = new Yugioh();
		Tablero tablero = yugioh.obtenerTablero();
		// yo soy el jugador uno
		Jugador jugadorUno = yugioh.obtenerJugadorUno();
		Jugador jugadorDos = yugioh.obtenerJugadorDos();
		Lado ladoUno = tablero.obtenerLadoDe(jugadorUno);
		Lado ladoDos = tablero.obtenerLadoDe(jugadorDos);

		CartaMonstruo huevo = new CartaMonstruo("Huevo Monstruoso", 1600, 800, 4);
		ladoUno.colocar(huevo, 0);
		
		CartaMonstruo amazon = new CartaMonstruo("Amazon of the Seas", 1300, 1400, 4);
		ladoDos.colocar(amazon, 0);
		ladoDos.cambiarAPosicionDeDefensaMonstruo(0);

		huevo.atacarA(amazon);
		
		// Verifico que no se destruyo huevo
		assertFalse(ladoUno.cementerioContiene(huevo));
		
		// Pero jugadorUno no recibe danio
		assertEquals(7000, jugadorUno.obtenerVida());
	}
}
