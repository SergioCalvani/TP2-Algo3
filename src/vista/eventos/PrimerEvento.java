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
import vista.VistaCarta;
import modelo.Carta;
import modelo.CartaMonstruo;

public class PrimerEvento implements EventHandler<MouseEvent>{
	
	private VistaCarta figura;
	private CartaMonstruo carta;
	private Button voltear;
	private Button defensa;
	private Button destruir;
	private Button atacar;
	
	public PrimerEvento(CartaMonstruo unaCarta,VistaCarta unaFigura){
		this.carta = unaCarta;
		this.figura = unaFigura;
	}

	@Override
	public void handle(MouseEvent eventHandler) {
		Stage menu = new Stage();
		HBox hBox = new HBox();
		VBox vBox = new VBox();
		Label nombre = new Label();
		voltear = new Button("Voltear");
		defensa = new Button("Defensa");
		
		nombre.setText("Nombre: " + this.carta.extraerNombre() + "\n" + "ATK: " + ((CartaMonstruo) this.carta).extraerPuntosAtaque() + "\n"+ "DEF: " + ((CartaMonstruo) this.carta).extraerPuntosDefensa() );
		VoltearEventHandler accionVoltear = new VoltearEventHandler(this.carta,menu,this.figura);
		voltear.setOnAction(accionVoltear);
		
		DefensaEventHandler accionDefensa = new DefensaEventHandler(this.carta,menu,this.figura);
		defensa.setOnAction(accionDefensa);
		
		hBox.setAlignment(Pos.CENTER);
		hBox.getChildren().addAll(voltear,defensa);
		hBox.setSpacing(10);
		vBox.setAlignment(Pos.CENTER);
		vBox.getChildren().addAll(nombre,hBox);
		vBox.setSpacing(20);
		
		Scene escena = new Scene(vBox,300,300);
		menu.setScene(escena);
		menu.show();
	}

}
