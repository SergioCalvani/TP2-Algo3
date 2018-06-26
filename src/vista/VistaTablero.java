package vista;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.Jugador;
import modelo.Tablero;

public class VistaTablero {
	
	private VistaMano mano;
	private Tablero elTablero;
	private VistaLado ladoUno;
	private VistaLado ladoDos;
	private Jugador jugadorUno;
	private Jugador jugadorDos;
	private BorderPane figura;
	
	public VistaTablero(Tablero unTablero,Jugador unJugador,Jugador otroJugador,VistaMano unaMano){
		this.elTablero = unTablero;
		this.crearEstructura();
		this.jugadorUno = unJugador;
		this.jugadorDos = otroJugador;
		this.mano = unaMano;
	}
	
	public void crearEstructura(){
		figura = new BorderPane();
		this.ladoUno = new VistaLado(this.elTablero.obtenerLadoDe(this.jugadorUno));
		this.ladoDos = new VistaLado(this.elTablero.obtenerLadoDe(this.jugadorDos));
		this.figura.setCenter(this.ladoUno.obtenerFigura());
		//this.figura.setTop(this.ladoDos.obtenerFigura());
	}
	
	public void cargarMano(){
		this.figura.setRight(this.mano.obtenerFigura());
	}
	
	public void cambiarCarta(VistaMonstruo unaFigura,int posicion){
		this.ladoUno.insertarFigura(unaFigura,posicion);
		this.mano.extraerCarta();
	}
	
	public void cambiarCarta(VistaMagica unaFigura,int posicion){
		this.ladoUno.insertarFigura(unaFigura,posicion);
		this.mano.extraerCarta();
	}
	
	public BorderPane obtenerFigura(){
		return this.figura;
	}
}
