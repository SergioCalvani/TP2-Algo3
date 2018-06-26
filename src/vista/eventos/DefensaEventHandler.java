package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import vista.VistaMonstruo;

public class DefensaEventHandler implements EventHandler<ActionEvent>{
	
	private Stage escena;
	private VistaMonstruo figura;
	
	public DefensaEventHandler(Stage unaEscena,VistaMonstruo vista){
		this.escena = unaEscena;
		this.figura = vista;
	}
	
	@Override
	public void handle(ActionEvent actionEvent) {
		this.figura.cambiarEstado();
		this.escena.close();
	}
}
