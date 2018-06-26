package aplicacion.App;


import javafx.scene.layout.RowConstraints;

import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import modelo.Carta;
import modelo.Lado;
import modelo.Mano;


public class LadoArribaVista {
	private GridPane ladoArriba;
	private Lado lado;
	
	public LadoArribaVista(Lado lado) {
		this.lado = lado;
		this.ladoArriba = new GridPane();
		this.ladoArriba = new GridPane();
		this.ladoArriba.setHgap(20); 
		this.ladoArriba.setVgap(20);
		for(int i= 0;i<7;i++ ) {
		      this.ladoArriba.getColumnConstraints().add(new ColumnConstraints(80));
		    }
		for(int i = 0;i<3;i++) {
		    	this.ladoArriba.getRowConstraints().add(new RowConstraints(100));
		    }
		//MANO
		Button[] cartasMano = new Button[5];
        for(int i = 0; i < cartasMano.length; i++) {
        	cartasMano[i] = new Button();
        	cartasMano[i].setId("cartaMonstruo");
        	this.ladoArriba.add(cartasMano[i],i+1,0);
        }
        
        //trampasMagia
        Button[] cartasTrampa = new Button[5];
        for(int i = 0; i < cartasTrampa.length; i++) {
        	cartasTrampa[i] = new Button();
        	cartasTrampa[i].setId("cartaMagicaTrampaVacia");
        	this.ladoArriba.add(cartasTrampa[i],i+1,1);
        }
        
        //monstruos
        Button[] cartasmonstruo = new Button[5];
        for(int i = 0; i < cartasmonstruo.length; i++) {
        	cartasmonstruo[i] = new Button();
        	cartasmonstruo[i].setId("cartaMonstruoVacia");
        	this.ladoArriba.add(cartasmonstruo[i],i+1,2);
        }
               
        //campo
        Button campo = new Button();
        campo.setId("cartaCampoVacia");
        this.ladoArriba.add(campo,6,2);
        
        //CEMENTERIO
        Button cementerio = new Button();
        cementerio.setId("cartaCementerioVacia");
        this.ladoArriba.add(cementerio,0,2);
        
        //mazo
        Button mazo = new Button();
        mazo.setId("cartaMazo");
        this.ladoArriba.add(mazo, 0,1);
	}
	
	public GridPane getGrid() {
		return this.ladoArriba;
	}
	
	public void dibujarMano() {
		Mano mano = this.lado.obtenerJugador().obtenerMano();
		ArrayList<Carta> coleccionDeCartas = mano.obtenerCartas();
		int size = mano.obtenerTamanio();
		for (int i = 0; i <size; i++) {
			Carta carta = coleccionDeCartas.get(i);
			CartaVista cv = new CartaVista(carta);
			Button button =cv.obtenerFigura();
			button.setMinSize(80,100);
			button.setMaxSize(80,100);
			this.ladoArriba.add(button,i+1,0);
		}
	}
}
