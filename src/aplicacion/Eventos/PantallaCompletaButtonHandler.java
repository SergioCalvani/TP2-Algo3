package aplicacion.Eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class PantallaCompletaButtonHandler implements EventHandler<ActionEvent>{

	private Stage pantalla;
	
	public PantallaCompletaButtonHandler(Stage escenario){
		this.pantalla = escenario;
	}
	
	@Override
	public void handle(ActionEvent event) {
		if(!pantalla.isFullScreen()){
			this.pantalla.setFullScreen(true);
		}
		else{
			this.pantalla.setFullScreen(false);
		}
	}

}
