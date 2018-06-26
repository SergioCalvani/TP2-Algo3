package aplicacion.App;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import modelo.Yugioh;

public class TableroVista {
	private LadoArribaVista ladoArriba;
	private LadoAbajoVista ladoAbajo;
	private Scene escena;
	
	public TableroVista(Yugioh yugioh) {
		this.ladoArriba = new LadoArribaVista (yugioh.obtenerLadoDos());
		this.ladoAbajo = new LadoAbajoVista (yugioh.obtenerLadoUno());
	}
	
	
	
	public Scene dibujarTurnoAbajo() {
		this.ladoArriba.dibujarManoOculta();
		this.ladoAbajo.dibujarConTurno() ;
		
		VBox pane1 = this.ladoArriba.getGrid();
		VBox pane2 = this.ladoAbajo.getGrid();
		VBox contenedor = new VBox(pane1,pane2);
		
	    contenedor.setSpacing(20);
	    contenedor.setPadding(new Insets(10));

	    pane1.setAlignment(Pos.CENTER );
	    pane2.setAlignment( Pos.CENTER );
	    
		this.escena = new Scene(contenedor);
		
		return this.escena;
	}
	
	public Scene dibujarTurnoArriba() {
		this.ladoArriba.dibujarManoOculta();
		this.ladoAbajo.dibujarConTurno() ;
		
		VBox pane1 = this.ladoArriba.getGrid();
		VBox pane2 = this.ladoAbajo.getGrid();
		VBox contenedor = new VBox(pane1,pane2);
		
	    contenedor.setSpacing(20);
	    contenedor.setPadding(new Insets(10));
	    
	    pane1.setAlignment(Pos.CENTER );
	    pane2.setAlignment( Pos.CENTER );
	    
		this.escena = new Scene(contenedor);
		
		return this.escena;
	}
	
	
	
	
}
