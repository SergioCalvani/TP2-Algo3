package vista;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import modelo.CartaMonstruo;

public class VistaJinzo extends VistaMonstruo{

	public VistaJinzo(CartaMonstruo unaCarta, VistaTablero unTablero) {
		super(unaCarta, unTablero);
		this.imagenCarta = new Image("vista/imagenCarta/jinzo.jpg");
		this.figura.setFill(new ImagePattern(this.imagenCarta));
	}

}
