package vista;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import vista.eventos.*;
import modelo.Carta;

public class VistaCarta {

	protected VistaTablero tablero;
	protected Carta carta;
	protected Rectangle figura;
	protected Image imagenCarta;
	
	public VistaCarta(Carta unaCarta,VistaTablero unTablero){
		this.carta = unaCarta;
		this.tablero = unTablero;
		this.crearFigura();
	}
	
	public void crearFigura(){
		this.figura = new Rectangle(80,110);
		this.imagenCarta = new Image("vista/imagenCarta/carta.jpg");
		this.figura.setFill(new ImagePattern(imagenCarta));
		this.inicializarEvento();
	}
	
	public void inicializarEvento() {}
	
	public void seInserto() {}
	
	public void efectoVoltear(){
		if(this.carta.estaBocaAbajo()){
			this.carta.voltear();
			this.figura.setFill(new ImagePattern(this.imagenCarta));
		}
	}
	
	public Rectangle obtenerFigura(){
		return this.figura;
	}
}
