package aplicacion.Eventos;

//import controlador.BotonAceptarNombresEventHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class BotonComenzarEventHandler implements EventHandler<ActionEvent> {
	private Stage stage;
	
	public BotonComenzarEventHandler(Stage stage) {
		this.stage = stage;
	}
	
	
	@Override
	public void handle(ActionEvent arg0) {

		ImageView visualizador = new ImageView();
		Image imagen = new Image("aplicacion/Imagenes/principal.png");
		StackPane layout = new StackPane();
		
        //LABEL INGRESE NOMBRES
        Label etiquetaIngreseNombres = new Label();
        etiquetaIngreseNombres.setText("Ingrese Nombre de los Jugadores");
        etiquetaIngreseNombres.setStyle("-fx-font-weight: bold");
        
        
        //jugador 1
        Label etiquetaJugador1 = new Label();
        etiquetaJugador1.setText("Jugador 1:");
        
        TextField textoJugador1 = new TextField();
        textoJugador1.setPromptText("Jugador 1");      
        
        
        //jugador 2
        Label etiquetaJugador2 = new Label();
        etiquetaJugador2.setText("Jugador 2:");
        
        TextField textoJugador2 = new TextField();
        textoJugador2.setPromptText("Jugador 2");
        
        
        //boton
        Button botonAceptar = new Button();
        botonAceptar.setText("Aceptar");
        
        
        //label error
        Label etiquetaError= new Label();
        etiquetaError.setText("");
        
        
        
        //VBOX1
        VBox contenedorJugador1 = new VBox(etiquetaJugador1,textoJugador1);
        contenedorJugador1.setSpacing(5);        
        
        //VBOX 2
        VBox contenedorJugador2 = new VBox(etiquetaJugador2,textoJugador2);
        contenedorJugador2.setSpacing(5);
        
        //HBOX
    	Region region1 = new Region();
        HBox.setHgrow(region1, Priority.ALWAYS);
        
        HBox contenedorBoton = new HBox(etiquetaError, region1, botonAceptar);
        contenedorBoton.setSpacing(0);
        
        //VBOX PRINCIPAL
        VBox contenedorPrincipal = new VBox(etiquetaIngreseNombres,contenedorJugador1, contenedorJugador2,contenedorBoton);//etiquetaJugador1, texto, contenedorHorizontal, etiquetaJugador2);
        contenedorPrincipal.setSpacing(15);
        contenedorPrincipal.setPadding(new Insets(20));
        
        //evento
        BotonAceptarNombresEventHandler botonAceptarEventHandler = new BotonAceptarNombresEventHandler(textoJugador1,textoJugador2,etiquetaError,stage);
        botonAceptar.setOnAction(botonAceptarEventHandler);       

		visualizador.setImage(imagen);
		visualizador.setFitHeight(720);
		visualizador.setFitWidth(1280);
		layout.getChildren().addAll(visualizador,contenedorPrincipal);
		
		Scene escena = new Scene(layout);
		stage.setScene(escena);
		stage.show();
	}

}
