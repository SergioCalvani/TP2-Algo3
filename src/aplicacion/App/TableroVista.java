package aplicacion.App;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import modelo.Yugioh;

public class TableroVista {
	private LadoArribaVista ladoArriba;
	private LadoAbajoVista ladoAbajo;
	private Scene escena;
	
	public TableroVista(Yugioh yugioh) {
		this.ladoArriba = new LadoArribaVista (yugioh.obtenerLadoDos());
		this.ladoAbajo = new LadoAbajoVista (yugioh.obtenerLadoUno());
	}
	
	public Scene dibujar() {
		
		VBox contenedor = new VBox(this.ladoArriba.getGrid(),this.ladoAbajo.getGrid());
		
	    contenedor.setSpacing(20);

	    //NO LO PUEDO CENTRAR!!
	    contenedor.setAlignment( Pos.CENTER );
	    
		this.escena = new Scene(contenedor);
		
		return this.escena;
	}	
}
