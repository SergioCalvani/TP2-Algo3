package aplicacion.App;

import java.util.ArrayList;

import aplicacion.Eventos.RobarCartaEventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.RowConstraints;
import modelo.Carta;
import modelo.Lado;
import modelo.Mano;

public class LadoAbajoVista extends LadoVista {
	private GridPane ladoAbajo;
	private HBox mano;
	private Lado lado;
	
	public LadoAbajoVista(Lado lado) {
		//dibuja el tablero inicial
		this.lado = lado;
		this.mano = new HBox();
		this.mano.setSpacing(10);
		this.ladoAbajo = new GridPane();
		this.ladoAbajo.setHgap(20); 
		this.ladoAbajo.setVgap(20);
		
		//roba 5 cartas del mazo al iniciar el juego
		for(int i = 0; i < 5; i++ ) {
			this.lado.robarCartaDelMazo();
		}
		
		for(int i= 0;i<7;i++ ) {
		      this.ladoAbajo.getColumnConstraints().add(new ColumnConstraints(80));
		    }
		for(int i = 0;i<2;i++) {
	    	this.ladoAbajo.getRowConstraints().add(new RowConstraints(100));
	    }
        
        //trampasMagia
        Button[] cartasTrampa = new Button[5];
        for(int i = 0; i < cartasTrampa.length; i++) {
        	cartasTrampa[i] = new Button();
        	cartasTrampa[i].setId("cartaMagicaTrampaVacia");
        	this.ladoAbajo.add(cartasTrampa[i],i+1,1);
        }
        
        //monstruos
        Button[] cartasmonstruo = new Button[5];
        for(int i = 0; i < cartasmonstruo.length; i++) {
        	cartasmonstruo[i] = new Button();
        	cartasmonstruo[i].setId("cartaMonstruoVacia");
        	this.ladoAbajo.add(cartasmonstruo[i],i+1,0);
        }
        
        //campo
        Button campo = new Button();
        campo.setId("cartaCampoVacia");
        this.ladoAbajo.add(campo,0,0);
        
        //cementerio
        Button cementerio = new Button();
        cementerio.setId("cartaCementerioVacia");
        this.ladoAbajo.add(cementerio,6,0);
        
        //mazo
        Button mazo = new Button();
        mazo.setId("cartaMazo");
        this.ladoAbajo.add(mazo, 6,1);
	}
	
	public VBox getGrid() {
		VBox vb = new VBox(this.ladoAbajo,this.mano);
		this.ladoAbajo.setAlignment(Pos.TOP_CENTER );
	    this.mano.setAlignment( Pos.TOP_CENTER );
	    vb.setSpacing(10);
		return vb;
	}
	
	public void dibujarConTurno() {
	    //mazo
        Button mazo = new Button("ROBAR");
        mazo.setId("cartaMazo");
        this.ladoAbajo.add(mazo, 6,1);
        RobarCartaEventHandler robarCartaEH = new RobarCartaEventHandler(this.lado,this);
        mazo.setOnAction(robarCartaEH);
		dibujarMano();
	}
	
	public void dibujarSinTurno() {
		dibujarManoOculta();
	}
	
	public void dibujarManoOculta() {
		//dibuja dorso de cartas
		this.mano.getChildren().clear();
		Button[] cartasMano = new Button[5];
        for(int i = 0; i < cartasMano.length; i++) {
        	cartasMano[i] = new Button();
        	cartasMano[i].setId("cartaMonstruo");
        	this.mano.getChildren().add(cartasMano[i]);
        }
	}
	
	
	public void dibujarMano() {
		Mano mano = this.lado.obtenerMano();
		ArrayList<Carta> coleccionDeCartas = mano.obtenerCartas();
		int size = mano.obtenerTamanio();
		this.mano.getChildren().clear();
		for (int i = 0; i <size; i++) {
			Carta carta = coleccionDeCartas.get(i);
			CartaVista cv = new CartaVista(carta);
			Button button =cv.obtenerFigura();
			button.setMinSize(80,100);
			button.setMaxSize(80,100);
			this.mano.getChildren().add(button);
			
		}
	}
}
