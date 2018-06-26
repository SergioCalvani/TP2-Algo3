package vista.eventos;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import vista.VistaMagica;

public class PrimerEventoMagica implements EventHandler<MouseEvent>{
	
	private VistaMagica figura;
	private Button voltear;
	
	public PrimerEventoMagica(VistaMagica unaFigura){
		this.figura = unaFigura;
	}

	@Override
	public void handle(MouseEvent eventHandler) {
		Stage menu = new Stage();
		HBox hBox = new HBox();
		VBox vBox = new VBox();
		Label nombre = new Label();
		voltear = new Button("Voltear");
		
		VoltearEventHandler accionVoltear = new VoltearEventHandler(menu,this.figura);
		voltear.setOnAction(accionVoltear);
		
		hBox.setAlignment(Pos.CENTER);
		hBox.getChildren().add(voltear);
		hBox.setSpacing(10);
		vBox.setAlignment(Pos.CENTER);
		vBox.getChildren().addAll(nombre,hBox);
		vBox.setSpacing(20);
		
		Scene escena = new Scene(vBox,300,300);
		menu.setScene(escena);
		menu.show();
	}
}
