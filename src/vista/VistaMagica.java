package vista;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import modelo.Carta;
import modelo.CartaMagica;
import vista.eventos.InsertarEventMagica;
import vista.eventos.PrimerEventoMagica;

public class VistaMagica extends VistaCarta{

	public VistaMagica(Carta unaCarta, VistaTablero unTablero) {
		super(unaCarta, unTablero);
	}

	public void inicializarEvento(){
		InsertarEventMagica insertar = new InsertarEventMagica(this,this.tablero);
		this.figura.setOnMouseClicked(insertar);
	}
	
	public void seInserto(){
		Image nuevaImagen = new Image("vista/imagenCarta/Sin_carta.jpg");
		this.figura.setFill(new ImagePattern(nuevaImagen));
		PrimerEventoMagica recta = new PrimerEventoMagica(this);
		this.figura.setOnMouseClicked(recta);
	}
	
	public CartaMagica obtenerCarta(){
		return ((CartaMagica) this.carta);
	}
	
}
