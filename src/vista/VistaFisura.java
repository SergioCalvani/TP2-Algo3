package vista;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import modelo.CartaMagica;

public class VistaFisura extends VistaMagica {

	public VistaFisura(CartaMagica unaCarta, VistaTablero unTablero) {
		super(unaCarta, unTablero);
		this.imagenCarta = new Image("vista/imagenCarta/fisura.jpg");
		this.figura.setFill(new ImagePattern(this.imagenCarta));
	}

}
