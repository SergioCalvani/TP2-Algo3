package vista;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import modelo.Carta;
import modelo.CartaMonstruo;
import vista.eventos.InsertarEventMonstruo;
import vista.eventos.PrimerEventoMonstruo;

public class VistaMonstruo extends VistaCarta{

	public VistaMonstruo(Carta unaCarta, VistaTablero unTablero) {
		super(unaCarta, unTablero);
	}
	
	public void inicializarEvento(){
		InsertarEventMonstruo insertar = new InsertarEventMonstruo(this,this.tablero);
		this.figura.setOnMouseClicked(insertar);
	}


	public void cambiarEstado(){
		if(!((CartaMonstruo) this.carta).estaEnPosicionDeDefensa()){
			((CartaMonstruo) this.carta).cambiarAPosicionDeDefensa();
			this.figura.setRotate(270);
		}
		else{
			((CartaMonstruo) this.carta).cambiarAPosicionDeAtaque();
			this.figura.setRotate(this.figura.getRotate() + 90);
		}
	}
	
	public void seInserto(){
		Image nuevaImagen = new Image("vista/imagenCarta/Sin_carta.jpg");
		this.figura.setFill(new ImagePattern(nuevaImagen));
		PrimerEventoMonstruo recta = new PrimerEventoMonstruo(this);
		this.figura.setOnMouseClicked(recta);
	}
	
	public CartaMonstruo obtenerCarta(){
		return ((CartaMonstruo) this.carta);
	}
}