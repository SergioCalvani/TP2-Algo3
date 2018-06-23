package aplicacion.Eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class BotonTutorialEventHandler implements EventHandler<ActionEvent>{

	
	
	@Override
	public void handle(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Tutorial");
		alert.setHeaderText("A continacion se describiran las maneras que hay de perder el juego");
		alert.setContentText("El juego de cartas entre dos jugadores en el cual hay dos maneras de perder:\n" + "\t- Si se acaban las cartas del mazo\n" + "\t- Si se te acaban los 8000 puntos de vida");
		alert.showAndWait();
	}

}
