package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import vista.VistaCarta;
import modelo.Carta;
import modelo.CartaMonstruo;

public class DefensaEventHandler implements EventHandler<ActionEvent>{
	
	private Stage escena;
	private Carta carta;
	private VistaCarta figura;
	
	public DefensaEventHandler(Carta unaCarta,Stage unaEscena,VistaCarta vista){
		this.carta = unaCarta;
		this.escena = unaEscena;
		this.figura = vista;

	}
	
	@Override
	public void handle(ActionEvent actionEvent) {
		if(!((CartaMonstruo) this.carta).estaEnPosicionDeDefensa()){
			((CartaMonstruo) this.carta).cambiarAPosicionDeDefensa();
			this.figura.modoDefensivo();
		}
		else{
			((CartaMonstruo) this.carta).cambiarAPosicionDeAtaque();
			this.figura.modoOfensivo();
		}
		this.escena.close();
	}
}
