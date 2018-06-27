package aplicacion.Eventos;

import aplicacion.App.CartaVista;
import aplicacion.App.LadoVista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import modelo.Carta;
import modelo.Lado;

public class AtacarContrarioEventHandler implements EventHandler<ActionEvent>{
	
	private Lado lado;
	private Carta carta;
	private CartaVista cartaVista;
	private Stage ventana;
	private LadoVista ladoVista;
	private int miPosicion;
	private int posicionContrario;

	public AtacarContrarioEventHandler(Lado unLado,Carta unaCarta,Stage ventana,LadoVista unLadoVista,int unaPosicion,int otraPosicion){
		this.lado = unLado;
		this.cartaVista = new CartaVista(unaCarta);
		this.carta = unaCarta;
		this.ventana = ventana;
		this.ladoVista = unLadoVista;
		this.miPosicion = unaPosicion;
		this.posicionContrario = otraPosicion;
	}

	@Override
	public void handle(ActionEvent event) {
		this.lado.atacarConMonstruoEnPosicionAMonstruoEnPosicion(this.miPosicion,this.posicionContrario);
		this.ladoVista.refresh();
		this.ventana.close();
	}
	
}
