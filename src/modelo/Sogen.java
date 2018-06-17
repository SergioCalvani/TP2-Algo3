package modelo;

public class Sogen extends CartaDeCampo{
	
	public Sogen(){
		super("Sogen");
	}

	@Override
	public void efectoDuenio(Lado unLado) {
		unLado.aumentarPuntosDefensa(500);
	}

	@Override
	public void efectoEnemigo(Lado unLado) {
		unLado.aumentarPuntosAtaque(200);
	}

}
