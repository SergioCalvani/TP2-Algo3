package vista;

import excepciones.PosicionOcupadaException;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import modelo.Lado;
import vista.eventos.SalirEventHandler;

public class VistaLado {
	
	private Lado lado;
	private HBox figura;
	private HBox zonaMonstruo;
	private HBox zonaMagica;
	private VBox zonaEspecial;
	
	public VistaLado(Lado unLado){
		this.lado = unLado;
		this.crearEstructura();
	}
	
	public void prepararSombras(Rectangle unRectangulo,HBox zona,Color color){
		unRectangulo.setFill(Color.TRANSPARENT);
		unRectangulo.setStroke(color);
		unRectangulo.setStrokeWidth(2.0);
		zona.getChildren().add(unRectangulo);
	}
	
	public void prepararSombras(Rectangle unRectangulo,VBox zona,Color color){
		unRectangulo.setFill(Color.TRANSPARENT);
		unRectangulo.setStroke(color);
		unRectangulo.setStrokeWidth(2.0);
		zona.getChildren().add(unRectangulo);
	}
	
	public void crearEstructura(){
		
		HBox lado = new HBox();
		VBox ladoPrincipal = new VBox();
		zonaMonstruo = new HBox();
		zonaMagica = new HBox();
		zonaEspecial = new VBox();
		
		Rectangle sombraCarta1 = new Rectangle(80,110);
		Rectangle sombraCarta2 = new Rectangle(80,110);
		Rectangle sombraCarta3 = new Rectangle(80,110);
		Rectangle sombraCarta4 = new Rectangle(80,110);
		Rectangle sombraCarta5 = new Rectangle(80,110);
		Rectangle sombraCarta6 = new Rectangle(80,110);
		Rectangle sombraCarta7 = new Rectangle(80,110);
		Rectangle sombraCarta8 = new Rectangle(80,110);
		Rectangle sombraCarta9 = new Rectangle(80,110);
		Rectangle sombraCarta10 = new Rectangle(80,110);
		Rectangle sombraCarta11 = new Rectangle(80,110);
		Rectangle sombraCarta12 = new Rectangle(80,110);
		Rectangle sombraCarta13 = new Rectangle(80,110);
		
		this.prepararSombras(sombraCarta1, zonaMonstruo,Color.BLACK);
		this.prepararSombras(sombraCarta2, zonaMonstruo,Color.BLACK);
		this.prepararSombras(sombraCarta3, zonaMonstruo,Color.BLACK);
		this.prepararSombras(sombraCarta4, zonaMonstruo,Color.BLACK);
		this.prepararSombras(sombraCarta5, zonaMonstruo,Color.BLACK);
		this.prepararSombras(sombraCarta6, zonaMagica,Color.BLUE);
		this.prepararSombras(sombraCarta7, zonaMagica,Color.BLUE);
		this.prepararSombras(sombraCarta8, zonaMagica,Color.BLUE);
		this.prepararSombras(sombraCarta9, zonaMagica,Color.BLUE);
		this.prepararSombras(sombraCarta10, zonaMagica,Color.BLUE);
		this.prepararSombras(sombraCarta11, zonaEspecial,Color.GREEN);
		this.prepararSombras(sombraCarta12, zonaEspecial,Color.BROWN);
		this.prepararSombras(sombraCarta13, zonaEspecial,Color.GREY);
		
		ladoPrincipal.setAlignment(Pos.BOTTOM_CENTER);
		lado.setSpacing(50);
		zonaMonstruo.setSpacing(50);
		zonaMagica.setSpacing(50);
		zonaEspecial.setSpacing(50);
		zonaMonstruo.setAlignment(Pos.BOTTOM_CENTER);
		zonaMagica.setAlignment(Pos.BOTTOM_CENTER);
		zonaEspecial.setAlignment(Pos.BOTTOM_CENTER);
		ladoPrincipal.setSpacing(50);
		ladoPrincipal.getChildren().addAll(zonaMonstruo,zonaMagica);
		lado.getChildren().addAll(ladoPrincipal,zonaEspecial);
		
		this.figura = lado;
	}
	
	public void mensajeOcupado(){
		Stage nuevaVentana = new Stage();
		Label mensaje = new Label("Casillero Ocupado");
		Button aceptar = new Button("Aceptar");
		mensaje.setFont(new Font("Arial",12));
		
		SalirEventHandler salir = new SalirEventHandler(nuevaVentana);
		aceptar.setOnAction(salir);
		
		VBox layout = new VBox(mensaje,aceptar);
		layout.setAlignment(Pos.CENTER);
		layout.setSpacing(10);
		Scene escena = new Scene(layout,150,150);
		nuevaVentana.setScene(escena);
		nuevaVentana.show();
		
	}
	
	public void insertarFigura(VistaMonstruo figura,int posicion){
		try{
			this.lado.colocar(figura.obtenerCarta(),posicion);
			this.zonaMonstruo.getChildren().remove(posicion);
			this.zonaMonstruo.getChildren().add(posicion,figura.obtenerFigura());
			figura.seInserto();
		}catch(PosicionOcupadaException e){
			this.mensajeOcupado();
		}
	}
	
	public void insertarFigura(VistaMagica figura,int posicion){
		try{
			this.lado.colocar(figura.obtenerCarta(),posicion);
			this.zonaMagica.getChildren().remove(posicion);
			this.zonaMagica.getChildren().add(posicion,figura.obtenerFigura());
			figura.seInserto();
		}catch(PosicionOcupadaException e){
			this.mensajeOcupado();
		}
	}

	public HBox obtenerFigura(){
		return this.figura;
	}
}
