package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vista.VistaCarta;
import vista.VistaTablero;

public class CambiarEvent implements EventHandler<ActionEvent>{
	
	private VistaCarta figura;
	private VistaTablero tablero;
	
	public CambiarEvent(VistaCarta unaFigura,VistaTablero unTablero){
		this.figura = unaFigura;
		this.tablero = unTablero;
	}

	@Override
	public void handle(ActionEvent event) {
		this.tablero.cambiarCarta(this.figura);
	}

}
