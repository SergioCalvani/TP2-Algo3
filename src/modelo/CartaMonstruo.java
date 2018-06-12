package modelo;

public class CartaMonstruo extends Carta{
	
	private Estado estado;
	private int puntosDeAtaque;
	private int puntosDeDefensa;
	
	public CartaMonstruo() {
		
	}
	
	public boolean estaEnEstadoOfensivo() {
		return estado.estaEnEstadoOfensivo();
	}
	
	public boolean estaEnEstadoDefensivo() {
		return estado.estaEnEstadoDefensivo();
	}

}
