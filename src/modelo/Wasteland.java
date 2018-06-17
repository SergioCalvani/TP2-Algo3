package modelo;

public class Wasteland extends CartaDeCampo{
	
	public Wasteland(){
		super("Wasteland");
	}

	@Override
	public void efectoDuenio(Lado unLado) {
		unLado.aumentarPuntosAtaque(200);
	}

	@Override
	public void efectoEnemigo(Lado unLado) {
		unLado.aumentarPuntosDefensa(300);
	}
}
