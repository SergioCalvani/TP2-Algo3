package aplicacion.Eventos;

import javafx.scene.input.MouseEvent;
import aplicacion.App.CartaVista;
import aplicacion.App.LadoArribaVista;
import aplicacion.App.LadoVista;
import aplicacion.App.TableroVista;
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
import modelo.Carta;

public class InsertarEvent implements EventHandler<ActionEvent>{
	
	private CartaVista figura;
	private LadoVista lado;
	
	public InsertarEvent(CartaVista carta,LadoVista unLado){
		this.figura = carta;
		this.lado = unLado;
	}

	@Override
	public void handle(ActionEvent event) {
		
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
		otroEscenario.show();
	}
}