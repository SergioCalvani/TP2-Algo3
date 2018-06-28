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
import modelo.CartaMonstruo;
import modelo.Lado;

public class FaseAtaqueMonstruoEventHandler implements EventHandler<ActionEvent>{
	
	private CartaMonstruo carta;
	private Lado lado;
	private LadoVista ladoVista;
	private CartaVista cartaVista;
	private int miPosicion;

	public FaseAtaqueMonstruoEventHandler(CartaMonstruo unaCarta,Lado unLado,LadoVista ladoVista,int unaPosicion){
		this.carta = unaCarta;
		this.cartaVista = new CartaVista(unaCarta);
		this.lado = unLado;
		this.ladoVista = ladoVista;
		this.miPosicion = unaPosicion;
	}


	@Override
	public void handle(ActionEvent actionEvent) {
		Image img = this.cartaVista.obtenerImagen(270,300);
		Stage ventanaCarta = new Stage();
		Button btn = new Button();
		VBox contenedor = new VBox();
		
		btn.setGraphic(new ImageView(img));
		contenedor.setAlignment(Pos.CENTER);
		contenedor.setSpacing(10);
		contenedor.setPadding(new Insets(0,0,10,0));
		
		BotonCancelarEventHandler botonCancelarEventHandler = new BotonCancelarEventHandler(ventanaCarta);
		btn.setOnAction(botonCancelarEventHandler);
		
		
		if((!this.carta.obtenerFlag()) & (!this.carta.obtenerSiAtaco())) {
			
			Button atacar = new Button("ATACAR");
			Button estado = new Button("DEFENSA");
			atacar.setId("UnBoton");
			estado.setId("UnBoton");
			
			contenedor.getChildren().addAll(btn,atacar,estado);

			AtacarEventHandler eh = new AtacarEventHandler(this.lado,this.carta,ventanaCarta,this.ladoVista,this.miPosicion);
			atacar.setOnAction(eh);
			
			if(((CartaMonstruo) this.carta).estaEnPosicionDeAtaque()){
				EstadoDefensaEventHandler ehd = new EstadoDefensaEventHandler(this.carta,this.ladoVista,ventanaCarta);
				estado.setOnAction(ehd);
			}
			else{
				EstadoAtaqueEventHandler eha = new EstadoAtaqueEventHandler(this.carta,this.ladoVista,ventanaCarta);
				estado.setOnAction(eha);
				estado.setText("ATAQUE");
			}
		}
		else {
			contenedor.getChildren().addAll(btn);
		}
		Scene escena = new Scene(contenedor);

		escena.getStylesheets().add("aplicacion/css/card-window.css");
		ventanaCarta.setScene(escena);		
		ventanaCarta.initStyle(StageStyle.UNDECORATED);
		ventanaCarta.show();	
	}
}