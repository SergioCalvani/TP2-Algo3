package aplicacion.App;

import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import modelo.Lado;

public class LadoAbajoVista {
	private GridPane ladoAbajo;
	private Lado lado;
	
	public LadoAbajoVista(Lado lado) {
		this.lado = lado;
		this.ladoAbajo = new GridPane();
		this.ladoAbajo = new GridPane();
		this.ladoAbajo.setHgap(20); 
		this.ladoAbajo.setVgap(20);
		
		for(int i= 0;i<7;i++ ) {
		      this.ladoAbajo.getColumnConstraints().add(new ColumnConstraints(80));
		    }
		for(int i = 0;i<3;i++) {
		    	this.ladoAbajo.getRowConstraints().add(new RowConstraints(100));
		    }
		
		
		//mano
		Button[] cartasMano = new Button[5];
        for(int i = 0; i < cartasMano.length; i++) {
        	cartasMano[i] = new Button();
        	cartasMano[i].setId("cartaMonstruo");
        	this.ladoAbajo.add(cartasMano[i],i+1,2);
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
	
	public GridPane getGrid() {
		return this.ladoAbajo;
	}
}
