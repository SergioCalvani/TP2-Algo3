package aplicacion.Eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class BotonSalirEventHandler implements EventHandler<ActionEvent> {
	
	
	public BotonSalirEventHandler() {}

	@Override
	public void handle(ActionEvent actionEvent) {
		Stage ventanaSalida = new Stage();
		Label mensaje = new Label();
		Button aceptar = new Button("Aceptar");
		Button cancelar = new Button("Cancelar");
		HBox botonera = new HBox(aceptar,cancelar);
		VBox contenedor = new VBox();
		
		
		mensaje.setText("�Esta seguro que desea salir?");
		mensaje.setFont(new Font("Arial",14));
		aceptar.setFont(new Font("Arial",14));
		cancelar.setFont(new Font("Arial",14));
		botonera.setSpacing(10);
		contenedor.getChildren().addAll(mensaje,botonera);
		botonera.setAlignment(Pos.CENTER);
		contenedor.setAlignment(Pos.CENTER);
		
		BotonAceptarEventHandler botonAceptarEventHandler = new BotonAceptarEventHandler();
		aceptar.setOnAction(botonAceptarEventHandler);
		
		BotonCancelarEventHandler botonCancelarEventHandler = new BotonCancelarEventHandler(ventanaSalida);
		cancelar.setOnAction(botonCancelarEventHandler);
		
		Scene salir = new Scene(contenedor,250,150);
		
		ventanaSalida.setTitle("�Esta Seguro?");
		ventanaSalida.setScene(salir);
		ventanaSalida.show();
	}
}
