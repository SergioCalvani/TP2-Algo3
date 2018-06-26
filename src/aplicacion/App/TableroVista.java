package aplicacion.App;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
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
		GridPane pane1 = this.ladoArriba.getGrid();
		GridPane pane2 = this.ladoAbajo.getGrid();
		VBox contenedor = new VBox(pane1,pane2);
		
	    contenedor.setSpacing(20);

	    pane1.setAlignment(Pos.CENTER );
	    pane2.setAlignment( Pos.CENTER );
	    
		this.escena = new Scene(contenedor);
		
		return this.escena;
	}	
}
