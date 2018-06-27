package aplicacion.Eventos;

import aplicacion.App.CartaVista;
import aplicacion.App.LadoArribaVista;
import aplicacion.App.LadoVista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class CambiarEventMons implements EventHandler<ActionEvent>{
	
	private CartaVista figura;
	private LadoVista lado;
	private Stage escenario;
	private int posicion;
	
	public CambiarEventMons(CartaVista unaFigura,Stage otroEscenario,LadoVista unLado,int pos){
		this.figura = unaFigura;
		this.lado = unLado;
		this.posicion = pos;
		this.escenario = otroEscenario;
	}

	@Override
	public void handle(ActionEvent event) {
		this.escenario.close();
		this.lado.insertarMonstruo(this.figura,this.posicion);
	}
}
