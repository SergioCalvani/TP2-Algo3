package vista.eventos;

import javafx.scene.input.MouseEvent;


import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import vista.VistaMagica;
import vista.VistaTablero;

public class InsertarEventMagica implements EventHandler<MouseEvent>{
	
	private VistaMagica figura;
	private VistaTablero tablero;
	
	public InsertarEventMagica(VistaMagica unaFigura,VistaTablero unTablero){
		this.figura = unaFigura;
		this.tablero = unTablero;
	}
	
	@Override
	public void handle(MouseEvent event) {
		Stage otroEscenario = new Stage();
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
		
		CambiarEventMagica cambio1 = new CambiarEventMagica(this.figura,otroEscenario,this.tablero,0);
		primero.setOnAction(cambio1);
		CambiarEventMagica cambio2 = new CambiarEventMagica(this.figura,otroEscenario,this.tablero,1);
		segundo.setOnAction(cambio2);
		CambiarEventMagica cambio3 = new CambiarEventMagica(this.figura,otroEscenario,this.tablero,2);
		tercero.setOnAction(cambio3);
		CambiarEventMagica cambio4 = new CambiarEventMagica(this.figura,otroEscenario,this.tablero,3);
		cuarto.setOnAction(cambio4);
		CambiarEventMagica cambio5 = new CambiarEventMagica(this.figura,otroEscenario,this.tablero,4);
		quinto.setOnAction(cambio5);
		
		Scene escena = new Scene(insertar,350,250);
		otroEscenario.setScene(escena);
		otroEscenario.show();
	}
}
