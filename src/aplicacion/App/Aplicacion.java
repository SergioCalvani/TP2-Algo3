package aplicacion.App;

import aplicacion.Eventos.BotonSalirEventHandler;
import aplicacion.Eventos.BotonTutorialEventHandler;
import aplicacion.Eventos.PantallaCompletaButtonHandler;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import modelo.Yugioh;

public class Aplicacion extends Application{

	private int resolucionAlto = 720;
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
		StackPane layout2 = new StackPane();
		Label titulo = new Label();
		Label integrantes = new Label();
		ImageView visualizador = new ImageView();
		
		Button comenzar = new Button("Comenzar");
		comenzar.setId("button-grey");
		//Button tutorial = new Button("Tutorial");
		//Button pantallaCompleta = new Button("Pantalla Completa");
		Button salir = new Button("Salir");
		salir.setId("button-grey");
		VBox contenedorVertical = new VBox();
		
		comenzar.setFont(new Font("Arial",20));
		//tutorial.setFont(new Font("Arial",20));
		//pantallaCompleta.setFont(new Font("Arial",20));
		salir.setFont(new Font("Arial",20));
		titulo.setText("Al-Go-Oh!\n" + "Trabajo Practico Nro. 2 \n" +  "Algoritmos y Programacion III - FIUBA");
		integrantes.setText("Integrantes: \n" + "\t- Bravo Arroyo, Victor Manuel\n" + "\t- Botter Brun, Juan Bautista\n" + "\t- Calvani, Sergio Alejandro\n" + "\t- Rack, Lucas Alexis");
		titulo.setFont(new Font("Arial",34));
		titulo.setTextFill(Color.web("#E0F8E6"));
		integrantes.setFont(new Font("Arial",34));
		integrantes.setTextFill(Color.web("#E0F8E6"));
		
		StackPane.setAlignment(titulo,Pos.TOP_LEFT);
		StackPane.setAlignment(integrantes,Pos.BOTTOM_LEFT);
		
		//PantallaCompletaButtonHandler pantallaCompletaButtonHandler = new PantallaCompletaButtonHandler(stage);
		//pantallaCompleta.setOnAction(pantallaCompletaButtonHandler);
		
		//BotonTutorialEventHandler botonTutorialEventHandler = new BotonTutorialEventHandler();
		//tutorial.setOnAction(botonTutorialEventHandler);
		
		BotonSalirEventHandler botonSalirEventHandler = new BotonSalirEventHandler();
		salir.setOnAction(botonSalirEventHandler);
		
		BotonComenzarEventHandler botonComenzarEventHandler = new BotonComenzarEventHandler(this);
		comenzar.setOnAction(botonComenzarEventHandler);
		
		contenedorVertical.getChildren().addAll(comenzar,salir);//tutorial,pantallaCompleta,salir);
		contenedorVertical.setSpacing(20);
		contenedorVertical.setPadding(new Insets(240,0,0,50));
		visualizador.setImage(this.fondo);
		visualizador.setFitWidth(this.resolucionAncho);
		visualizador.setFitHeight(this.resolucionAlto);		
		layout.getChildren().addAll(titulo,integrantes,contenedorVertical);
		layout.setPadding(new Insets(10));
		layout2.getChildren().addAll(visualizador,layout);
		
		Scene escena = new Scene(layout2);
		this.stage.setFullScreen(false);
		escena.getStylesheets().add("aplicacion/css/name-screen.css");
		this.stage.setScene(escena);
		this.stage.show();
	}
	
	public void ingresarNombre() {
		ImageView visualizador = new ImageView();
		Image blanco = new Image("aplicacion/Imagenes/frame.jpg");
		StackPane layout = new StackPane();
		StackPane layout2 = new StackPane();
		ImageView visualizador2 = new ImageView();
		
        //LABEL INGRESE NOMBRES
        Label etiquetaIngreseNombres = new Label();
        etiquetaIngreseNombres.setText("Ingrese Nombres de los Jugadores");
        etiquetaIngreseNombres.setId("ingrese-label");

        //jugador 1
        Label etiquetaJugador1 = new Label();
        etiquetaJugador1.setText("Jugador 1:");
        etiquetaJugador1.setId("nombre-label");      
        
        TextField textoJugador1 = new TextField();
        textoJugador1.setPromptText("Jugador 1");      
        
        
        //jugador 2
        Label etiquetaJugador2 = new Label();
        etiquetaJugador2.setText("Jugador 2:");
        etiquetaJugador2.setId("nombre-label");
        
        TextField textoJugador2 = new TextField();
        textoJugador2.setPromptText("Jugador 2");
        
        //label error
        Label etiquetaError= new Label();
        etiquetaError.setText("");
        etiquetaError.setId("error-label");  
        
        //boton
        Button botonAceptar = new Button();
        botonAceptar.setText("Aceptar");
        botonAceptar.setId("lion");
        
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
        contenedorPrincipal.setMaxHeight(200);
        contenedorPrincipal.setMaxWidth(300);
        contenedorPrincipal.setId("hbox");
  
        layout2.getChildren().addAll(contenedorPrincipal);
        
        //evento
        BotonAceptarNombresEventHandler botonAceptarEventHandler = new BotonAceptarNombresEventHandler(textoJugador1,textoJugador2,etiquetaError,this);
        botonAceptar.setOnAction(botonAceptarEventHandler);       

		StackPane.setAlignment(layout2, Pos.CENTER );
	
	    layout2.setPrefWidth(this.resolucionAncho);
		layout2.setPrefHeight(this.resolucionAlto);	
		
		Scene escena = new Scene(layout2);
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
		
		Scene escena = new Scene(layout);
		this.stage.setScene(escena);
	}
	
	
}
