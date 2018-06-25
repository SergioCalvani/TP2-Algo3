package aplicacion.App;

import aplicacion.Eventos.BotonSalirEventHandler;
import aplicacion.Eventos.BotonAceptarNombresEventHandler;
import aplicacion.Eventos.BotonComenzarEventHandler;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
import javafx.stage.Stage;
import modelo.Yugioh;

public class Aplicacion extends Application{

	private int resolucionAlto = 700;
	private int resolucionAncho = 1280;
	private Stage stage;
	private Yugioh yugioh;
	private Image fondo; 
	
	public static void main(String []args){
		launch(args);
	}
	
	@Override
	public void start(Stage stage){
		this.fondo = new Image("aplicacion/Imagenes/principal.png");
		this.stage = stage;
		
		stage.setTitle("Al-Go-Oh!- FIUBA");
		StackPane layout = new StackPane();
		Label titulo = new Label();
		Label integrantes = new Label();
		ImageView visualizador = new ImageView();		
		Button comenzar = new Button("Comenzar");
		Button salir = new Button("Salir");
		VBox contenedorVertical = new VBox();
		
		comenzar.defaultButtonProperty().bind(comenzar.focusedProperty());
		salir.defaultButtonProperty().bind(salir.focusedProperty());
		

		titulo.setText("Al-Go-Oh!\n" + "Trabajo Practico Nro. 2 \n" +  "Algoritmos y Programacion III - FIUBA");
		integrantes.setText("Integrantes: \n" + "\t- Bravo Arroyo, Victor Manuel\n" + "\t- Botter Brun, Juan Bautista\n" + "\t- Calvani, Sergio Alejandro\n" + "\t- Rack, Lucas Alexis");
		
		StackPane.setAlignment(titulo,Pos.TOP_LEFT);
		StackPane.setAlignment(integrantes,Pos.BOTTOM_LEFT);
		

		BotonSalirEventHandler botonSalirEventHandler = new BotonSalirEventHandler();
		salir.setOnAction(botonSalirEventHandler);
		
		BotonComenzarEventHandler botonComenzarEventHandler = new BotonComenzarEventHandler(this);
		comenzar.setOnAction(botonComenzarEventHandler);
		
		contenedorVertical.getChildren().addAll(comenzar,salir);
		contenedorVertical.setSpacing(20);
		contenedorVertical.setPadding(new Insets(240,0,0,50));
		visualizador.setImage(this.fondo);
		layout.setPrefWidth(this.resolucionAncho);
		layout.setPrefHeight(this.resolucionAlto);		
		layout.getChildren().addAll(titulo,integrantes,contenedorVertical);
		layout.setPadding(new Insets(10));
		
		
		Scene escena = new Scene(layout);
		this.stage.setFullScreen(false);
		escena.getStylesheets().add("aplicacion/css/start-screen.css");
		this.stage.setScene(escena);
		this.stage.show();
		comenzar.requestFocus();
	}
	
	public void ingresarNombre() {
		StackPane layout = new StackPane();
		Button botonAceptar = new Button();
		Label etiquetaIngreseNombres = new Label();
		Label etiquetaJugador1 = new Label();
		TextField textoJugador1 = new TextField();
		Label etiquetaJugador2 = new Label();
		TextField textoJugador2 = new TextField();
		Label etiquetaError= new Label();
		
		//LABEL INGRESE NOMBRES
        etiquetaIngreseNombres.setText("Ingrese Nombres de los Jugadores");
        etiquetaIngreseNombres.setId("ingrese-label");

        //jugador 1        
        etiquetaJugador1.setText("Jugador 1:");
        etiquetaJugador1.setId("nombre-label");      
                
        textoJugador1.setPromptText("Jugador 1");      
        
        
        //jugador 2       
        etiquetaJugador2.setText("Jugador 2:");
        etiquetaJugador2.setId("nombre-label");
                
        textoJugador2.setPromptText("Jugador 2");
        
        //label error
        etiquetaError.setText("");
        etiquetaError.setId("error-label");  
        
        //boton
        botonAceptar.setText("Aceptar");
        
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
        VBox contenedorPrincipal = new VBox(etiquetaIngreseNombres,contenedorJugador1, contenedorJugador2,contenedorBoton);
        contenedorPrincipal.setSpacing(15);
        contenedorPrincipal.setPadding(new Insets(20));
        contenedorPrincipal.setMaxHeight(200);
        contenedorPrincipal.setMaxWidth(350);
        contenedorPrincipal.setId("hbox");
  
        layout.getChildren().addAll(contenedorPrincipal);
        
        //evento
        BotonAceptarNombresEventHandler botonAceptarEventHandler = new BotonAceptarNombresEventHandler(textoJugador1,textoJugador2,etiquetaError,this);
        botonAceptar.setOnAction(botonAceptarEventHandler);       
        botonAceptar.defaultButtonProperty().bind(botonAceptar.focusedProperty());
        
		StackPane.setAlignment(layout, Pos.CENTER );
	
	    layout.setPrefWidth(this.resolucionAncho);
		layout.setPrefHeight(this.resolucionAlto);	
		
		Scene escena = new Scene(layout);
		escena.getStylesheets().add("aplicacion/css/name-screen.css");
		this.stage.setScene(escena);
	}



	public void iniciarJuego(String nombre1,String nombre2) {
		this.yugioh = new Yugioh(nombre1,nombre2);
		
		ImageView visualizador = new ImageView();
		Image imagen = new Image("aplicacion/Imagenes/fondo_tablero.png");
		StackPane layout = new StackPane();
		
		visualizador.setImage(imagen);
		visualizador.setFitWidth(this.resolucionAncho);
		visualizador.setFitHeight(this.resolucionAlto);
		layout.getChildren().addAll(visualizador);
		
		if(this.yugioh.estaTerminado()) {
			System.out.println("FIN");
		}
		
		Scene escena = new Scene(layout);
		this.stage.setScene(escena);
	}
	
	
}
