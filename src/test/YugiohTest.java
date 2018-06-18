package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import modelo.AgujeroOscuro;
import modelo.CartaDeCampo;
import modelo.CartaMagica;
import modelo.CartaMonstruo;
import modelo.CartaTrampa;
import modelo.CilindroMagico;
import modelo.Wasteland;
import modelo.Jugador;
import modelo.Lado;
import modelo.Mano;
import modelo.Mazo;
import modelo.OllaDeLaCodicia;
import modelo.Tablero;
import modelo.Yugioh;
import modelo.Sogen;
import modelo.Jinzo;
import modelo.Fisura;
import modelo.InsectoComeHombres;

class YugiohTest {

	@Test
	void testColorCartaMonstruoEnPosicionDeAtaque() {
		Yugioh yugioh = new Yugioh();
		Tablero tablero = yugioh.obtenerTablero();
		Jugador jugador = yugioh.obtenerJugadorUno();
		Lado lado = tablero.obtenerLadoDe(jugador);
		
		CartaMonstruo monstruo = new CartaMonstruo("Huevo Monstruoso", 600, 900, 3);
		lado.colocar(monstruo, 0);
		
		// Por defecto coloca una carta monstruo en posicion de ataque
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
	
	@Test
	void testTodosSeDestruyenTrasActivarseAgujeroOscuro() {
		Yugioh yugioh = new Yugioh();
		Tablero tablero = yugioh.obtenerTablero();
		// yo soy el jugador uno
		Jugador jugadorUno = yugioh.obtenerJugadorUno();
		Jugador jugadorDos = yugioh.obtenerJugadorDos();
		Lado ladoUno = tablero.obtenerLadoDe(jugadorUno);
		Lado ladoDos = tablero.obtenerLadoDe(jugadorDos);
		
		CartaMonstruo beautiful = new CartaMonstruo("Beautiful Headhuntress", 1600, 800, 4);
		ladoUno.colocar(beautiful, 0);
		
		CartaMonstruo amazon = new CartaMonstruo("Amazon of the Seas", 1300, 1400, 4);
		ladoDos.colocar(amazon, 0);
		
		CartaMagica agujeroOscuro = new AgujeroOscuro();
		ladoUno.colocar(agujeroOscuro, 0);
		
		// No estoy seguro, en este modelo  primero se coloca una carta en 
		// la zona y luego se da las opciones de dar vuelta o no. Tambien podria ser posible
		// activar la carta desde la misma mano. Esta bien asi o es necesario un metodo 
		// colocarCartaYDarVuelta(carta) ? 
		ladoUno.voltearCartaMagicaEnPosicion(0);
		
		// Verifico que los monstruos esten en el cementerio.
		assertTrue(ladoUno.cementerioContiene(beautiful));
		assertTrue(ladoDos.cementerioContiene(amazon));
		
		// Verifico que nadie recibio danio
		assertEquals(7000, jugadorUno.obtenerVida());
		assertEquals(7000, jugadorDos.obtenerVida());
	}

	@Test
	void testMonstruoRequiereUnSacreificio() {
		Yugioh yugioh = new Yugioh();
		Tablero tablero = yugioh.obtenerTablero();
		
		Jugador jugadorUno = yugioh.obtenerJugadorUno();
		Lado ladoUno = tablero.obtenerLadoDe(jugadorUno);
		
		CartaMonstruo beautiful = new CartaMonstruo("Beautiful Headhuntress", 1600, 800, 4);
		ladoUno.colocar(beautiful, 0);
		
		ladoUno.sacrificar(0);

		CartaMonstruo magician = new CartaMonstruo("Dark Magician Girl", 2000, 1700, 6);
		ladoUno.colocar(magician, 0);
		
		
		assertTrue(ladoUno.cementerioContiene(beautiful));
		assertTrue(ladoUno.estaEnCampoMonstruo(magician));
	}
	

	@Test
	void testMonstruoRequiereDosSacreificio() {
		Yugioh yugioh = new Yugioh();
		Tablero tablero = yugioh.obtenerTablero();
		
		Jugador jugadorUno = yugioh.obtenerJugadorUno();
		Lado ladoUno = tablero.obtenerLadoDe(jugadorUno);
		
		CartaMonstruo beautiful = new CartaMonstruo("Beautiful Headhuntress", 1600, 800, 4);
		ladoUno.colocar(beautiful, 0);
		CartaMonstruo time = new CartaMonstruo("Time Wizard", 500, 400, 2);
		ladoUno.colocar(time, 1);
		
		ladoUno.sacrificar(0);
		ladoUno.sacrificar(1);
		
		CartaMonstruo magician= new CartaMonstruo("Dark Magician", 2500, 2100, 7);
		ladoUno.colocar(magician, 0);
		
		assertTrue(ladoUno.cementerioContiene(beautiful));
		assertTrue(ladoUno.cementerioContiene(time));
		assertTrue(ladoUno.estaEnCampoMonstruo(magician));
	}
	
	@Test
	void testAgregoyActivoCartaDeCampoWasteland(){
		Yugioh yugioh = new Yugioh();
		Tablero tablero = yugioh.obtenerTablero();
		Jugador jugadorUno = yugioh.obtenerJugadorUno();
		Jugador jugadorDos = yugioh.obtenerJugadorDos();
		Lado ladoUno = tablero.obtenerLadoDe(jugadorUno);
		Lado ladoDos = tablero.obtenerLadoDe(jugadorDos);
		
		CartaMonstruo beautiful = new CartaMonstruo("Beautiful Headhuntress", 1600, 800, 4);
		ladoUno.colocar(beautiful, 0);
		CartaMonstruo time = new CartaMonstruo("Time Wizard", 500, 400, 2);
		ladoDos.colocar(time, 0);
		
		CartaDeCampo wasteland = new Wasteland();
		ladoUno.colocarCartaDeCampo(wasteland);
		
		assertEquals(1800,beautiful.extraerPuntosAtaque());
		assertEquals(700,time.extraerPuntosDefensa());
	}
	
	@Test
	void testAgregoyActivoCartaDeCampoSogen(){
		Yugioh yugioh = new Yugioh();
		Tablero tablero = yugioh.obtenerTablero();
		Jugador jugadorUno = yugioh.obtenerJugadorUno();
		Jugador jugadorDos = yugioh.obtenerJugadorDos();
		Lado ladoUno = tablero.obtenerLadoDe(jugadorUno);
		Lado ladoDos = tablero.obtenerLadoDe(jugadorDos);
		
		CartaMonstruo beautiful = new CartaMonstruo("Beautiful Headhuntress", 1600, 800, 4);
		ladoUno.colocar(beautiful, 0);
		CartaMonstruo time = new CartaMonstruo("Time Wizard", 500, 400, 2);
		ladoDos.colocar(time, 0);
		
		CartaDeCampo sogen = new Sogen();
		ladoUno.colocarCartaDeCampo(sogen);
		
		assertEquals(1300,beautiful.extraerPuntosDefensa());
		assertEquals(700,time.extraerPuntosAtaque());
	}
	
	@Test
	void testAgregoJinzoYAtacoDirectamenteAlJugador(){
		Yugioh yugioh = new Yugioh();
		Tablero tablero = yugioh.obtenerTablero();
		Jugador jugadorUno = yugioh.obtenerJugadorUno();
		Jugador jugadorDos = yugioh.obtenerJugadorDos();
		Lado ladoUno = tablero.obtenerLadoDe(jugadorUno);
		Lado ladoDos = tablero.obtenerLadoDe(jugadorDos);

		CartaMonstruo amazon = new CartaMonstruo("Amazon of the Seas", 1300, 1400, 4);
		ladoDos.colocar(amazon, 0);
		CartaMonstruo jinzo = new Jinzo();
		ladoUno.colocar(jinzo,0);
		
		ladoUno.voltearCartaMostruoEnPosicion(0);
		
		//Jinzo #7 ataca directamente al jugador enemigo
		assertEquals(6500,jugadorDos.obtenerVida());
	}
	
	@Test
	void testAgregoYActivoCartaMagicaFisura(){
		Yugioh yugioh = new Yugioh();
		Tablero tablero = yugioh.obtenerTablero();
		Jugador jugadorUno = yugioh.obtenerJugadorUno();
		Jugador jugadorDos = yugioh.obtenerJugadorDos();
		Lado ladoUno = tablero.obtenerLadoDe(jugadorUno);
		Lado ladoDos = tablero.obtenerLadoDe(jugadorDos);

		CartaMonstruo amazon = new CartaMonstruo("Amazon of the Seas", 1300, 1400, 4);
		ladoDos.colocar(amazon, 0);
		CartaMonstruo beautiful = new CartaMonstruo("Beautiful Headhuntress", 1600, 800, 4);
		ladoDos.colocar(beautiful, 1);
		CartaMagica fisura = new Fisura();
		ladoUno.colocar(fisura,0);
		
		ladoUno.voltearCartaMagicaEnPosicion(0);
		
		//Destruye la carta enemiga de menor ataque
		assertTrue(ladoDos.cementerioContiene(amazon));
	}
	
	@Test
	void testActivarOllaDeLaCodiciaRobaDosCartasDelMazo() {
		
		Yugioh yugioh = new Yugioh();
		Jugador jugador = yugioh.obtenerJugadorUno();
		Lado lado = jugador.obtenerLado();
		Mano mano = jugador.obtenerMano();
		Mazo mazo = lado.obtenerMazo();
		
		CartaMagica ollaDeLaCodicia = new OllaDeLaCodicia();
		lado.colocar(ollaDeLaCodicia, 0);
		lado.voltearCartaMagicaEnPosicion(0);
		
		// Se roban 2 cartas de un mazo de 40
		assertEquals(38, mazo.obtenerTamanio());
		// Se agregan 2 cartas a una mano vacia.
		assertEquals(2, mano.obtenerTamanio());
	}
	
	@Test
	void testAtacoInsectoComeHombresYMeDestruyo(){
		Yugioh yugioh = new Yugioh();
		Tablero tablero = yugioh.obtenerTablero();
		Jugador jugadorUno = yugioh.obtenerJugadorUno();
		Jugador jugadorDos = yugioh.obtenerJugadorDos();
		Lado ladoUno = tablero.obtenerLadoDe(jugadorUno);
		Lado ladoDos = tablero.obtenerLadoDe(jugadorDos);
		
		CartaMonstruo insecto = new InsectoComeHombres();
		ladoUno.colocar(insecto,0);
		ladoUno.cambiarAPosicionDeDefensaMonstruo(0);
		CartaMonstruo amazon = new CartaMonstruo("Amazon of the Seas", 1300, 1400, 4);
		ladoDos.colocar(amazon,0);
		
		amazon.atacarA(insecto);
		
		assertTrue(ladoDos.cementerioContiene(amazon));
	}
}
