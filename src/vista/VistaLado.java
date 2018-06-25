package vista;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import modelo.Lado;

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
		lado.setSpacing(30);
		zonaMonstruo.setSpacing(30);
		zonaMagica.setSpacing(30);
		zonaEspecial.setSpacing(30);
		zonaMonstruo.setAlignment(Pos.BOTTOM_CENTER);
		zonaMagica.setAlignment(Pos.BOTTOM_CENTER);
		zonaEspecial.setAlignment(Pos.BOTTOM_CENTER);
		ladoPrincipal.setSpacing(30);
		ladoPrincipal.getChildren().addAll(zonaMonstruo,zonaMagica);
		lado.getChildren().addAll(ladoPrincipal,zonaEspecial);
		
		this.figura = lado;
	}
	
	public void insertarFigura(VistaCarta figura){
		this.zonaMonstruo.getChildren().remove(2);
		this.zonaMonstruo.getChildren().add(2,figura.obtenerFigura());
		figura.seInserto();
	}

	public HBox obtenerFigura(){
		return this.figura;
	}
}
