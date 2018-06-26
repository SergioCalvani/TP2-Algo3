package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import vista.VistaMonstruo;
import vista.VistaTablero;

public class CambiarEventMonstruo implements EventHandler<ActionEvent>{
	
	private VistaMonstruo figura;
	private VistaTablero tablero;
	private Stage escenario;
	private int posicion;
	
	public CambiarEventMonstruo(VistaMonstruo unaFigura,Stage otroEscenario,VistaTablero unTablero,int pos){
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
