package vista;

import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import modelo.Mano;

public class VistaMano {

	private Mano mano;
	private VBox figura;
	
	public VistaMano(Mano unaMano){
		this.mano = unaMano;
		this.figura = new VBox();
		this.figura.setSpacing(10);
	}
	
	public void prepararSombras(Rectangle unRectangulo,VBox zona,Color color){
		unRectangulo.setFill(Color.TRANSPARENT);
		unRectangulo.setStroke(color);
		unRectangulo.setStrokeWidth(2.0);
		zona.getChildren().add(unRectangulo);
	}
	
	public void agregarCarta(VistaCarta unaCarta){
		this.figura.getChildren().add(unaCarta.obtenerFigura());
	}
	
	public VBox obtenerFigura(){
		return this.figura;
	}
	
	public void extraerCarta(){
		Rectangle sombraCarta1 = new Rectangle(80,110);
		this.prepararSombras(sombraCarta1, this.figura,Color.BLACK);
	}
}
