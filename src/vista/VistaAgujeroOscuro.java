package vista;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import modelo.CartaMagica;

public class VistaAgujeroOscuro extends VistaMagica {

	public VistaAgujeroOscuro(CartaMagica unaCarta, VistaTablero unTablero) {
		super(unaCarta, unTablero);
		this.imagenCarta = new Image("vista/imagenCarta/agujero_oscuro.jpg");
		this.figura.setFill(new ImagePattern(this.imagenCarta));
	}
	
}
