package aplicacion.App;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;


import modelo.Yugioh;

public class TableroVista {
	private LadoArribaVista ladoArriba;
	private LadoAbajoVista ladoAbajo;
	private Scene escena;
	
	public TableroVista(Yugioh yugioh) {
		this.ladoArriba = new LadoArribaVista (yugioh.obtenerLadoDos());
		this.ladoAbajo = new LadoAbajoVista (yugioh.obtenerLadoUno());
	}
	
	
	
	public Scene dibujarTurnoAbajo() {
		this.ladoArriba.dibujarSinTurno();
		this.ladoAbajo.dibujarConTurno() ;
		
		VBox pane1 = this.ladoArriba.getGrid();
		VBox pane2 = this.ladoAbajo.getGrid();
		VBox contenedor = new VBox(pane1,pane2);

		
		Label info = new Label("HOLAAA");
		Button avanzar = new Button("AVANZAR");
		BorderPane border = new BorderPane();
	    
		contenedor.setSpacing(20);
		border.setCenter(contenedor);
	    border.setLeft(info);
	    border.setRight(avanzar);

	    border.setStyle("-fx-padding: 0 30 0 30;");
	    BorderPane.setAlignment(info, Pos.CENTER);
	    BorderPane.setAlignment(avanzar, Pos.CENTER);

		
		this.escena = new Scene(border);
		return this.escena;
	}
	
	public Scene dibujarTurnoArriba() {
		this.ladoArriba.dibujarConTurno();
		this.ladoAbajo.dibujarSinTurno() ;
		
		VBox pane1 = this.ladoArriba.getGrid();
		VBox pane2 = this.ladoAbajo.getGrid();
		VBox contenedor = new VBox(pane1,pane2);

		
		Label info = new Label("HOLAAA");
		Button avanzar = new Button("AVANZAR");
		BorderPane border = new BorderPane();
	    
		contenedor.setSpacing(20);
		border.setCenter(contenedor);
	    border.setLeft(info);
	    border.setRight(avanzar);

	    border.setStyle("-fx-padding: 0 30 0 30;");
	    BorderPane.setAlignment(info, Pos.CENTER);
	    BorderPane.setAlignment(avanzar, Pos.CENTER);

		
		this.escena = new Scene(border);
		return this.escena;
	}
	
	
	
	
}
