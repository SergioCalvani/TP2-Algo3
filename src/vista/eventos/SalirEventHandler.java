package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class SalirEventHandler implements EventHandler<ActionEvent>{
	
	private Stage ventana;
	
	public SalirEventHandler(Stage unaVentana){
		this.ventana = unaVentana;
	}

	@Override
	public void handle(ActionEvent event) {
		this.ventana.close();
	}
}
