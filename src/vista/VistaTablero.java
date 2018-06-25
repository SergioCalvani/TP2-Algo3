package vista;

import javafx.scene.layout.BorderPane;
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
		//this.figura.setTop(this.ladoDos.obtenerFigura());
		this.figura.setCenter(this.ladoUno.obtenerFigura());
	}
	
	public void cargarMano(){
		this.figura.setRight(this.mano.obtenerFigura());
	}
	
	public void cambiarCarta(VistaCarta unaFigura){
		this.ladoUno.insertarFigura(unaFigura);
		this.mano.extraerCarta();
	}
	
	public BorderPane obtenerFigura(){
		return this.figura;
	}
}
