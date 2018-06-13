package modelo;

public class CartaMonstruo extends Carta{
	
	private Estado estado;
	private int puntosDeAtaque;
	private int puntosDeDefensa;
	
	
	public CartaMonstruo(String unNombre,int atk,int def){
		nombre = unNombre;
		this.puntosDeAtaque = atk;
		this.puntosDeDefensa = def;		
	}
	
	public void ponerEnEstadoOfensivo() {
		estado = new EstadoOfensivo();
	}
	
	public void ponerEnEstadoDefensivo() {
		estado = new EstadoDefensivo();
	}
	
	public boolean estaEnEstadoOfensivo() {
		return estado.estaEnEstadoOfensivo();
	}
	
	public boolean estaEnEstadoDefensivo() {
		return estado.estaEnEstadoDefensivo();
	}

}
