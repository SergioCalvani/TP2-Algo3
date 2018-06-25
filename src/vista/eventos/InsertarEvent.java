package vista.eventos;

import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import vista.VistaCarta;
import vista.VistaLado;
import vista.VistaTablero;
import vista.VistaMano;

public class InsertarEvent implements EventHandler<MouseEvent>{
	
	private VistaCarta figura;
	private VistaTablero tablero;
	
	public InsertarEvent(VistaCarta unaFigura,VistaTablero unTablero){
		this.figura = unaFigura;
		this.tablero = unTablero;
	}
	
	@Override
	public void handle(MouseEvent event) {
		Stage otroEscenario = new Stage();
		Button cuarto = new Button("Cuarto");
		HBox prueba = new HBox();
		prueba.setAlignment(Pos.CENTER);
		prueba.setSpacing(10);
		prueba.getChildren().add(cuarto);
		
		CambiarEvent cambio = new CambiarEvent(this.figura,this.tablero);
		cuarto.setOnAction(cambio);
		
		Scene escena = new Scene(prueba,800,600);
		otroEscenario.setScene(escena);
		otroEscenario.show();
	}
}
