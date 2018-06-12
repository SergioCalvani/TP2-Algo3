package modelo;

public class CartaMonstruo extends Carta{
	
	private Estado estado;
	private int puntosDeAtaque;
	private int puntosDeDefensa;
	
	public CartaMonstruo() {
		
	}
	
	public estaEnEstadoOfensivo() {
		return estado.estaEnEstadoOfensivo();
	}
	
	public estaEnEstadoDefensivo() {
		return estado.estaEnEstadoDefensivo();
	}

}
