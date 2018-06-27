package aplicacion.App;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;


import modelo.Yugioh;

public class TableroVista {
	private LadoArribaVista ladoArriba;
	private LadoAbajoVista ladoAbajo;
	private Scene escena;
	private Label info;
	private Button botonAvanzar;
	
	public TableroVista(Yugioh yugioh) {
		this.ladoArriba = new LadoArribaVista (yugioh.obtenerLadoDos());
		this.ladoAbajo = new LadoAbajoVista (yugioh.obtenerLadoUno());
		this.info = new Label("                                  ");
		this.info.setMaxWidth(150);
		this.botonAvanzar = new Button("Fase De Preparación");
		this.botonAvanzar.setMaxWidth(150);
		this.botonAvanzar.setId("BOTON");
	}
	
	public Scene iniciarJuego() {
		return turnoArriba();
	}
	
	public Scene turnoAbajo() {
		this.ladoArriba.dibujarSinTurno();
		this.ladoAbajo.dibujarConTurno() ;
		
		VBox pane1 = this.ladoArriba.getGrid();
		VBox pane2 = this.ladoAbajo.getGrid();
		VBox contenedor = new VBox(pane1,pane2);
	    
		HBox hb = new HBox(this.info, contenedor, this.botonAvanzar);
		hb.setAlignment(Pos.CENTER);
		contenedor.setSpacing(20);
		

		hb.setSpacing(20);
	    hb.setStyle("-fx-padding: 0 10 0 10;");
	    contenedor.setAlignment( Pos.CENTER);
	    this.info.setAlignment( Pos.CENTER_LEFT);
	    this.botonAvanzar.setAlignment( Pos.CENTER_RIGHT);
	    HBox.setHgrow(contenedor, Priority.ALWAYS);
		this.escena = new Scene(hb);
		return this.escena;
	}
	
	public Scene turnoArriba() {
		this.ladoArriba.faseInicial();
		this.ladoAbajo.dibujarSinTurno() ;
		
		VBox pane1 = this.ladoArriba.getGrid();
		VBox pane2 = this.ladoAbajo.getGrid();
		VBox contenedor = new VBox(pane1,pane2);
	    
		HBox hb = new HBox(this.info, contenedor, this.botonAvanzar);
		hb.setAlignment(Pos.CENTER);
		contenedor.setSpacing(20);
		

		hb.setSpacing(20);
	    hb.setStyle("-fx-padding: 0 10 0 10;");
	    contenedor.setAlignment( Pos.CENTER);
	    this.info.setAlignment( Pos.CENTER_LEFT);
	    this.botonAvanzar.setAlignment( Pos.CENTER_RIGHT);
	    HBox.setHgrow(contenedor, Priority.ALWAYS);
		this.escena = new Scene(hb);
		return this.escena;
	}
	
	
	
	
}
