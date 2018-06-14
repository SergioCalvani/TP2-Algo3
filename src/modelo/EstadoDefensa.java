package modelo;

public class EstadoDefensa extends Estado {

	private int puntosDeDefensa;
	
	public EstadoDefensa(int puntosDeDefensa) {
		this.puntosDeDefensa = puntosDeDefensa;
	}
	
	@Override
	public boolean enPosicionDeAtaque() {
		return false;
	}
	
	@Override
	public int calcularAtaque(int otrosPuntosDeAtaque) {
		return this.puntosDeDefensa - otrosPuntosDeAtaque;
	}

}
