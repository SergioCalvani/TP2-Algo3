package aplicacion.App;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import modelo.Yugioh;

public class TableroVista {
	private HBox zonaMonstruoCementerioYCampo;
	private HBox zonaMagicaYMazo;
	private Scene escena;
	
	public TableroVista() {	
	}
	
	public Scene dibujar(Yugioh yugioh) {
		GridPane layout = new GridPane();
		layout.setHgap(20); 
		layout.setVgap(20);
		
	    for(int i= 0;i<7;i++ ) {
	       layout.getColumnConstraints().add(new ColumnConstraints(80));	    
	    }
		for(int i = 0;i<6;i++) {
	    	layout.getRowConstraints().add(new RowConstraints(100));
	    }
		
		Label[] cartasEnemigas = new Label[10];
        for(int i = 0; i < cartasEnemigas.length; i++) {
        	cartasEnemigas[i] = new Label();
        	cartasEnemigas[i].setId("cartaMonstruo");
        }
        
        layout.add(cartasEnemigas[1],1,0);
	    layout.add(cartasEnemigas[2],2,0);
	    layout.add(cartasEnemigas[3],3,0);
	    layout.add(cartasEnemigas[4],4,0);
	    layout.add(cartasEnemigas[5],5,0);

	    
	    

	    
	    layout.setId("layout");
		this.escena = new Scene(layout);
		return this.escena;
	}
	
	
	
}
