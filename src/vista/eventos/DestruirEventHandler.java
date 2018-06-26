package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import modelo.Carta;

public class DestruirEventHandler implements EventHandler<ActionEvent> {
	
	private Stage escena;
	private Carta carta;
	private VBox caja;
	
	public DestruirEventHandler(Carta unaCarta,VBox unaCaja,Stage unaEscena){
		this.carta = unaCarta;
		this.caja = unaCaja;
		this.escena = unaEscena;

	}

	@Override
	public void handle(ActionEvent eventHandler) {
		this.escena.close();
	}
}
