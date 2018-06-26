package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import vista.VistaMagica;
import vista.VistaTablero;

public class CambiarEventMagica implements EventHandler<ActionEvent>{
	
	private VistaMagica figura;
	private VistaTablero tablero;
	private Stage escenario;
	private int posicion;
	
	public CambiarEventMagica(VistaMagica unaFigura,Stage otroEscenario,VistaTablero unTablero,int pos){
		this.figura = unaFigura;
		this.tablero = unTablero;
		this.posicion = pos;
		this.escenario = otroEscenario;
	}

	@Override
	public void handle(ActionEvent event) {
		this.escenario.close();
		this.tablero.cambiarCarta(this.figura,this.posicion);
	}

}
