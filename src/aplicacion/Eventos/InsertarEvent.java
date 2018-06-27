package aplicacion.Eventos;

import aplicacion.App.CartaVista;
import aplicacion.App.LadoVista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import modelo.Carta;
import modelo.Lado;

public class InsertarEvent implements EventHandler<ActionEvent>{
	
	private Carta carta;
	private Lado lado;
	private CartaVista cartaVista;
	private LadoVista ladoVista;
	
	public InsertarEvent(Carta carta,Lado unLado,LadoVista ladoVista){
		this.cartaVista = new CartaVista(carta);
		this.carta = carta;
		this.lado = unLado;
		this.ladoVista = ladoVista;
	}

	@Override
	public void handle(ActionEvent event) {
		Image img = this.cartaVista.obtenerImagen(270,300);
		Stage ventanaCarta = new Stage();
		Button btn = new Button();
		
		VBox contenedor = new VBox();
		Button colocar= new Button("COLOCAR");
		btn.setGraphic(new ImageView(img));
		
		//lbl.setText(this.carta.obtenerNombre());
		
		
		contenedor.getChildren().addAll(btn,colocar);
		contenedor.setAlignment(Pos.CENTER);
		contenedor.setSpacing(10);
		contenedor.setPadding(new Insets(0,0,10,0));
		Scene escena = new Scene(contenedor);
		
		BotonCancelarEventHandler botonCancelarEventHandler = new BotonCancelarEventHandler(ventanaCarta);
		btn.setOnAction(botonCancelarEventHandler);
		
		ColocarCartaEventHandler eh = new ColocarCartaEventHandler(this.lado,this.carta,ventanaCarta,this.ladoVista);
		colocar.setOnAction(eh);
		
		colocar.setId("UnBoton");
		escena.getStylesheets().add("aplicacion/css/card-window.css");
		ventanaCarta.setScene(escena);		
		ventanaCarta.initStyle(StageStyle.UNDECORATED);
		ventanaCarta.show();	
		/*Stage otroEscenario = new Stage();
		otroEscenario.setTitle("Ingrese una Carta");
		Button primero = new Button("Primero");
		Button segundo = new Button("Segundo");
		Button tercero = new Button("Tercero");
		Button cuarto = new Button("Cuarto");
		Button quinto = new Button("Quinto");
		Label layout = new Label("Seleccione la Posicion para Insertar Carta");
		VBox insertar = new VBox();
		HBox botonera = new HBox();
		layout.setFont(new Font("Arial",15));
		botonera.setAlignment(Pos.CENTER);
		botonera.setSpacing(10);
		botonera.getChildren().addAll(primero,segundo,tercero,cuarto,quinto);
		insertar.setAlignment(Pos.CENTER);
		insertar.setSpacing(10);
		insertar.getChildren().addAll(layout,botonera);
		
		CambiarEventMons cambio1 = new CambiarEventMons(this.figura,otroEscenario,this.lado,1);
		primero.setOnAction(cambio1);
		CambiarEventMons cambio2 = new CambiarEventMons(this.figura,otroEscenario,this.lado,2);
		segundo.setOnAction(cambio2);
		CambiarEventMons cambio3 = new CambiarEventMons(this.figura,otroEscenario,this.lado,3);
		tercero.setOnAction(cambio3);
		CambiarEventMons cambio4 = new CambiarEventMons(this.figura,otroEscenario,this.lado,4);
		cuarto.setOnAction(cambio4);
		CambiarEventMons cambio5 = new CambiarEventMons(this.figura,otroEscenario,this.lado,5);
		quinto.setOnAction(cambio5);
		
		Scene escena = new Scene(insertar,350,250);
		otroEscenario.setScene(escena);
		otroEscenario.show();*/
	}
}