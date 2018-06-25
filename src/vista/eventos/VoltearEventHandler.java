package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import vista.VistaCarta;
import modelo.Carta;

public class VoltearEventHandler implements EventHandler<ActionEvent>{

	private Stage escena;
	private Carta carta;
	private VistaCarta figura;
	
	public VoltearEventHandler(Carta unaCarta,Stage unaEscena,VistaCarta vista){
		this.escena = unaEscena;
		this.carta = unaCarta;
		this.figura = vista;
	}
	
	@Override
	public void handle(ActionEvent actionEvent) {
		Image nuevaImagen = new Image("file:///home/sergio/Escritorio/Java/Yuhioh/TP2-Algo3/src/vista/imagenCarta/Sin_carta.jpg");
		if(this.carta.estaBocaAbajo()){
			this.carta.voltear();
			this.figura.voltearImagen(nuevaImagen);
		}
		this.escena.close();
	}

}
