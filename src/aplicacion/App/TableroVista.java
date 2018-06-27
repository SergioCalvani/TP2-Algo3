package aplicacion.App;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import aplicacion.App.Turno;
import aplicacion.App.Fase;

import modelo.Yugioh;

public class TableroVista {
	private LadoArribaVista ladoArriba;
	private LadoAbajoVista ladoAbajo;
	private Scene escena;
	private Label info;
	private Button botonAvanzar;
	private Turno turno;
	private Fase fase;
	
	public TableroVista(Yugioh yugioh) {
		this.turno = Turno.TURNOABAJO;
		this.fase = Fase.INICIAL;
		this.ladoArriba = new LadoArribaVista (yugioh.obtenerLadoDos());
		this.ladoAbajo = new LadoAbajoVista (yugioh.obtenerLadoUno());
		this.info = new Label("                                  ");
		this.info.setMaxWidth(150);
		this.botonAvanzar = new Button("Fase De Preparación");
		this.botonAvanzar.setMaxWidth(150);
		this.botonAvanzar.setId("BOTON");
	}

	
	public Scene juego(){
		switch (this.turno) {
			case TURNOARRIBA: 
				switch(this.fase) {
				case INICIAL:
					faseInicialArriba();
				case PREPARACION:

				case ATAQUE:

				case TRAMPAS:

				case FINAL:

				default:
					break;
				}				
			case TURNOABAJO:
				switch(this.fase) {
				case INICIAL:
					faseInicialAbajo();
				case PREPARACION:

				case ATAQUE:

				case TRAMPAS:

				case FINAL:

				default:
					break;					
				}	
			default:
				break;
		}
		return this.escena;
	}
	
	public void faseInicialAbajo() {
		this.ladoArriba.dibujarSinTurno();
		this.ladoAbajo.faseInicial() ;
		
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
	}
	
	public void faseInicialArriba() {
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
	}
	
	
	
	
}
