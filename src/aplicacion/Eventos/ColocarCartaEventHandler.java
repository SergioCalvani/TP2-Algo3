package aplicacion.Eventos;

import aplicacion.App.LadoVista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import modelo.CartaDeCampo;
import modelo.Carta;
import modelo.Lado;

public class ColocarCartaEventHandler implements EventHandler<ActionEvent>{
	private Lado lado;
	private Carta carta;
	private Stage ventana;
	private LadoVista ladoVista;
	
	public ColocarCartaEventHandler(Lado lado,Carta carta,Stage ventana,LadoVista ladoVista) {
		this.lado = lado;
		this.carta = carta;
		this.ventana = ventana;
		this.ladoVista = ladoVista;
	}

	@Override
	public void handle(ActionEvent event) {
		try{
			this.lado.colocarCartaDeCampo((CartaDeCampo) this.carta);
			this.ladoVista.refresh();
			this.ventana.close();
		}
		catch(ClassCastException excepcionDeCarta){
			this.lado.colocar(this.carta);
			this.ladoVista.refresh();
			this.ventana.close();
		}
	}
}
