package aplicacion.App;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;

import modelo.Carta;

public class CartaVista {


	protected Carta carta;
	protected Button figura;
	protected Image imagenCarta;
	
	public CartaVista(Carta unaCarta){
		this.carta = unaCarta;
		this.figura = new Button();
		this.crearFigura();
	}
	
	public void crearFigura(){
		
		String imagePath ="aplicacion/Imagenes/cartas/"+String.valueOf(this.carta.obtenerId())+".png";
		this.imagenCarta = new Image(imagePath,80, 100, false, false);
		this.figura.setGraphic(new ImageView(imagenCarta));
		this.inicializarEvento();
	}
	
	public void inicializarEvento() {}
	
	public void seInserto() {}
	
	/*public void efectoVoltear(){
		if(this.carta.estaBocaAbajo()){
			this.carta.voltear();
			this.figura.setFill(new ImagePattern(this.imagenCarta));
		}
	}*/
	
	public Button obtenerFigura(){
		return this.figura;
	}
}
