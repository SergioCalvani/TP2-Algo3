package aplicacion.App;

import aplicacion.Eventos.BotonSalirEventHandler;
import aplicacion.Eventos.BotonTutorialEventHandler;
import aplicacion.Eventos.PantallaCompletaButtonHandler;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Aplicacion extends Application{

	public static void main(String []args){
		launch(args);
	}
	
	@Override
	public void start(Stage stage){
		stage.setTitle("Al-Go-Oh!- FIUBA");
		StackPane layout = new StackPane();
		Label titulo = new Label();
		Label integrantes = new Label();
		ImageView visualizador = new ImageView();
		Image imagen = new Image("file:aplicacion/Imagenes/principal.png");
		Button comenzar = new Button("Comenzar");
		Button tutorial = new Button("Tutorial");
		Button pantallaCompleta = new Button("Pantalla Completa");
		Button salir = new Button("Salir");
		VBox contenedorVertical = new VBox();
		
		comenzar.setFont(new Font("Arial",20));
		tutorial.setFont(new Font("Arial",20));
		pantallaCompleta.setFont(new Font("Arial",20));
		salir.setFont(new Font("Arial",20));
		titulo.setText("Al-Go-Oh!\n" + "Trabajo Practico Nro. 2 \n" +  "Algoritmos y Programacion III - FIUBA");
		integrantes.setText("Integrantes: \n" + "\t- Bravo Arroyo, Victor Manuel\n" + "\t- Botter Brun, Juan Bautista\n" + "\t- Calvani, Sergio Alejandro\n" + "\t- Rack, Lucas Alexis");
		titulo.setFont(new Font("Arial",34));
		titulo.setTextFill(Color.web("#E0F8E6"));
		integrantes.setFont(new Font("Arial",34));
		integrantes.setTextFill(Color.web("#E0F8E6"));
		
		StackPane.setAlignment(titulo,Pos.TOP_LEFT);
		StackPane.setAlignment(integrantes,Pos.BOTTOM_LEFT);
		
		PantallaCompletaButtonHandler pantallaCompletaButtonHandler = new PantallaCompletaButtonHandler(stage);
		pantallaCompleta.setOnAction(pantallaCompletaButtonHandler);
		
		BotonTutorialEventHandler botonTutorialEventHandler = new BotonTutorialEventHandler();
		tutorial.setOnAction(botonTutorialEventHandler);
		
		BotonSalirEventHandler botonSalirEventHandler = new BotonSalirEventHandler();
		salir.setOnAction(botonSalirEventHandler);
		
		contenedorVertical.getChildren().addAll(comenzar,tutorial,pantallaCompleta,salir);
		contenedorVertical.setSpacing(20);
		contenedorVertical.setPadding(new Insets(240,0,0,50));
		visualizador.setImage(imagen);
		visualizador.setFitHeight(1020);
		visualizador.setFitWidth(1980);
		layout.getChildren().addAll(visualizador,titulo,integrantes,contenedorVertical);
		
		Scene escena = new Scene(layout);
		stage.setFullScreen(false);
		stage.setScene(escena);
		stage.show();
	}

}
