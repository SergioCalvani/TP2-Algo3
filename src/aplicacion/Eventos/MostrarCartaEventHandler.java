package aplicacion.Eventos;


import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import aplicacion.App.CartaVista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.StageStyle;
import modelo.Carta;

public class MostrarCartaEventHandler implements EventHandler<ActionEvent>{
	private static final Labeled HBox = null;
	private CartaVista cartaVista;
	private Carta carta;
	
	public MostrarCartaEventHandler(Carta carta) {
		this.cartaVista = new CartaVista(carta);
		this.carta = carta;
	}

	@Override
	public void handle(ActionEvent arg0) {
		Image img = this.cartaVista.obtenerImagen(220,250);
		Stage ventanaCarta = new Stage();
		Button salir = new Button("Salir");
		VBox contenedor = new VBox();
		Label lbl = new Label();
		lbl.setGraphic(new ImageView(img));
	
		
		contenedor.getChildren().addAll(lbl,salir);
		contenedor.setAlignment(Pos.CENTER);
		contenedor.setSpacing(10);
		contenedor.setPadding(new Insets(0,0,10,0));
		Scene escena = new Scene(contenedor);
		
		BotonCancelarEventHandler botonCancelarEventHandler = new BotonCancelarEventHandler(ventanaCarta);
		salir.setOnAction(botonCancelarEventHandler);
		
		
		ventanaCarta.setTitle(this.carta.obtenerNombre());
		ventanaCarta.setScene(escena);
		ventanaCarta.initStyle(StageStyle.UNDECORATED);
		ventanaCarta.show();
		
		
		
	}

}
