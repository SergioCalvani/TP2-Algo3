package vista.eventos;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import modelo.Carta;
import modelo.CartaMonstruo;
import vista.VistaMonstruo;

public class PrimerEventoMonstruo implements EventHandler<MouseEvent>{
	
	private VistaMonstruo figura;
	private Button voltear;
	private Button defensa;
	
	public PrimerEventoMonstruo(VistaMonstruo unaFigura){
		this.figura = unaFigura;
	}

	@Override
	public void handle(MouseEvent eventHandler) {
		Stage menu = new Stage();
		menu.setTitle("Elija Opcion");
		HBox hBox = new HBox();
		VBox vBox = new VBox();
		Label mensaje = new Label("Seleccione una opcion");
		voltear = new Button("Voltear");
		defensa = new Button("Defensa");
		mensaje.setFont(new Font("Arial",12));
		
		VoltearEventHandler accionVoltear = new VoltearEventHandler(menu,this.figura);
		voltear.setOnAction(accionVoltear);
		
		DefensaEventHandler accionDefensa = new DefensaEventHandler(menu,this.figura);
		defensa.setOnAction(accionDefensa);
		
		hBox.setAlignment(Pos.CENTER);
		hBox.getChildren().addAll(voltear,defensa);
		hBox.setSpacing(10);
		vBox.setAlignment(Pos.CENTER);
		vBox.getChildren().addAll(mensaje,hBox);
		vBox.setSpacing(20);
		
		Scene escena = new Scene(vBox,300,300);
		menu.setScene(escena);
		menu.show();
	}
}
