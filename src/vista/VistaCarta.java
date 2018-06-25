package vista;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import vista.eventos.*;
import modelo.CartaMonstruo;

public class VistaCarta {

	private VistaTablero tablero;
	private CartaMonstruo carta;
	private Rectangle figura;
	
	public VistaCarta(CartaMonstruo unaCarta,VistaTablero unTablero){
		this.carta = unaCarta;
		this.tablero = unTablero;
		this.crearFigura();
	}
	
	public void crearFigura(){
		this.figura = new Rectangle(80,110);
		Image imagen = new Image("file:///home/sergio/Escritorio/Java/Yuhioh/TP2-Algo3/src/vista/imagenCarta/carta.jpg");
		this.figura.setFill(new ImagePattern(imagen));
		
		InsertarEvent insertar = new InsertarEvent(this,this.tablero);
		this.figura.setOnMouseClicked(insertar);
	}
	
	public void seInserto(){
		PrimerEvento menuAccion = new PrimerEvento(this.carta,this);
		this.figura.setOnMouseClicked(menuAccion);
	}
	
	public void voltearImagen(Image unaImagen){
		this.figura.setFill(new ImagePattern(unaImagen));
	}
	
	public void modoOfensivo(){
		this.figura.setRotate(this.figura.getRotate() + 90);
	}
	
	public void modoDefensivo(){
		this.figura.setRotate(270);
	}
	
	public Rectangle obtenerFigura(){
		return this.figura;
	}

}
