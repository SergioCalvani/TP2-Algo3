package aplicacion.App;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import modelo.CartaMagica;
import modelo.CartaMonstruo;
import modelo.Jugador;
import modelo.Mano;
import modelo.Tablero;
import modelo.cartas.AgujeroOscuro;
import modelo.cartas.Fisura;
import modelo.cartas.Jinzo;
import vista.VistaAgujeroOscuro;
import vista.VistaFisura;
import vista.VistaJinzo;
import vista.VistaMagica;
import vista.VistaMano;
import vista.VistaMonstruo;
import vista.VistaTablero;

public class Jugando extends Application{
	
	public static void main(String []args){
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Jugador jugadorUno = new Jugador("JugadorUno");
		Jugador jugadorDos = new Jugador("JugadorDos");
		Tablero tab = new Tablero(jugadorUno,jugadorDos);
		Mano unaMano = new Mano();
		VistaMano mano = new VistaMano(unaMano);
		VistaTablero tablero = new VistaTablero(tab,jugadorUno,jugadorDos,mano);
		CartaMagica carta = new AgujeroOscuro();
		VistaMagica figuraCarta = new VistaAgujeroOscuro (carta,tablero);
		CartaMonstruo carta2 = new CartaMonstruo("Ejemplo2",200,300,4);
		VistaMonstruo  figuraCarta2 = new VistaMonstruo (carta2,tablero);
		CartaMonstruo carta3 = new Jinzo();
		VistaMonstruo figuraCarta3 = new VistaJinzo(carta3,tablero);
		CartaMagica carta4 = new Fisura();
		VistaMagica figuraCarta4 = new VistaFisura(carta4,tablero);
		CartaMonstruo carta5 = new CartaMonstruo("Ejemplo5",200,300,4);
		VistaMonstruo  figuraCarta5 = new VistaMonstruo (carta5,tablero);
		mano.agregarCarta(figuraCarta);
		mano.agregarCarta(figuraCarta2);
		mano.agregarCarta(figuraCarta3);
		mano.agregarCarta(figuraCarta4);
		mano.agregarCarta(figuraCarta5);
		tablero.cargarMano();
		Scene escena = new Scene(tablero.obtenerFigura(),1280,700);
		primaryStage.setScene(escena);
		primaryStage.show();
	}
}
