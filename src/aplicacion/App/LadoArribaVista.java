package aplicacion.App;


import javafx.scene.layout.RowConstraints;

import java.util.ArrayList;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import aplicacion.Eventos.MostrarCartaEventHandler;
import aplicacion.Eventos.RobarCartaEventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import modelo.Carta;
import modelo.Lado;
import modelo.Mano;


public class LadoArribaVista extends LadoVista {
	private GridPane campo;
	private HBox mano;
	private Lado lado;
	private TableroVista tableroVista;
	
	public LadoArribaVista(Lado lado,TableroVista tableroVista) {
		//dibuja el tablero inicial
		this.tableroVista = tableroVista;
		this.lado = lado;
		this.mano = new HBox();
		this.mano.setSpacing(10);
		this.campo = new GridPane();
		this.campo.setHgap(20); 
		this.campo.setVgap(20);
		

		for(int i= 0;i<7;i++ ) {
		      this.campo.getColumnConstraints().add(new ColumnConstraints(80));
		    }
		for(int i = 0;i<2;i++) {
		    	this.campo.getRowConstraints().add(new RowConstraints(100));
		    }
        
        //trampasMagia
        Button[] cartasTrampa = new Button[5];
        for(int i = 0; i < cartasTrampa.length; i++) {
        	cartasTrampa[i] = new Button();
        	cartasTrampa[i].setId("cartaMagicaTrampaVacia");
        	this.campo.add(cartasTrampa[i],i+1,0);
        }
        
        //monstruos
        Button[] cartasmonstruo = new Button[5];
        for(int i = 0; i < cartasmonstruo.length; i++) {
        	cartasmonstruo[i] = new Button();
        	cartasmonstruo[i].setId("cartaMonstruoVacia");
        	this.campo.add(cartasmonstruo[i],i+1,1);
        }
               
        //campo
        Button campo = new Button();
        campo.setId("cartaCampoVacia");
        this.campo.add(campo,6,1);
        
        //CEMENTERIO
        Button cementerio = new Button();
        cementerio.setId("cartaCementerioVacia");
        this.campo.add(cementerio,0,1);
        
        //mazo
        Button mazo = new Button();
        mazo.setId("cartaMazo");
        this.campo.add(mazo, 0,0);
	}
	

	public VBox getGrid() {
		VBox vb = new VBox(this.mano,this.campo);
		this.campo.setAlignment(Pos.TOP_CENTER );
	    this.mano.setAlignment( Pos.TOP_CENTER );
	    vb.setSpacing(10);
		return vb;
	}
	
	
	public void faseInicial() {
	    //mazo
        Button mazo = new Button("ROBAR");
        mazo.setId("cartaMazo");
        this.campo.add(mazo, 0,0);
        RobarCartaEventHandler robarCartaEH = new RobarCartaEventHandler(this.lado,this);
        mazo.setOnAction(robarCartaEH);
		dibujarMano();
		this.mano.getChildren().clear();
		
		//dibuja mano
		Mano mano = this.lado.obtenerJugador().obtenerMano();
		ArrayList<Carta> coleccionDeCartas = mano.obtenerCartas();
		int size = mano.obtenerTamanio();
		for (int i = 0; i <size; i++) {
			Carta carta = coleccionDeCartas.get(i);
			CartaVista cv = new CartaVista(carta);
			Button button =cv.obtenerBoton(80,100);
			button.setMinSize(80,100);
			button.setMaxSize(80,100);
			
			MostrarCartaEventHandler eh = new MostrarCartaEventHandler(carta);
			button.setOnAction(eh);
			
			this.mano.getChildren().add(button);
		}
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
		this.mano.getChildren().clear();
		Mano mano = this.lado.obtenerJugador().obtenerMano();
		ArrayList<Carta> coleccionDeCartas = mano.obtenerCartas();
		int size = mano.obtenerTamanio();
		for (int i = 0; i <size; i++) {
			Carta carta = coleccionDeCartas.get(i);
			CartaVista cv = new CartaVista(carta);
			Button button =cv.obtenerBoton(80,100);
			button.setMinSize(80,100);
			button.setMaxSize(80,100);
			this.mano.getChildren().add(button);
		}
	}
}
