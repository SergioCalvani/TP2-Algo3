package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import vista.VistaCarta;

public class VoltearEventHandler implements EventHandler<ActionEvent>{

	private Stage escena;
	private VistaCarta figura;
	
	public VoltearEventHandler(Stage unaEscena,VistaCarta vista){
		this.escena = unaEscena;
		this.figura = vista;
	}
	
	@Override
	public void handle(ActionEvent actionEvent) {
		this.figura.efectoVoltear();
		this.escena.close();
	}

}
