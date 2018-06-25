package aplicacion.App;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vista.VistaCarta;
import vista.VistaMano;
import vista.VistaTablero;
import modelo.CartaMonstruo;
import modelo.Jugador;
import modelo.Mano;
import modelo.Tablero;

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
		CartaMonstruo carta = new CartaMonstruo("Ejemplo",200,300,4);
		VistaCarta figuraCarta = new VistaCarta(carta,tablero);
		mano.agregarCarta(figuraCarta);
		tablero.cargarMano();
		Scene escena = new Scene(tablero.obtenerFigura(),1280,700);
		primaryStage.setScene(escena);
		primaryStage.show();
	}
}
