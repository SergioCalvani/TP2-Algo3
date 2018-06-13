package modelo;

public class CartaMonstruo extends Carta{
	
	private Estado estado;
	private String nombre;
	private int nivel;
	private int puntosDeAtaque;
	private int puntosDeDefensa;
	
	
	public CartaMonstruo(String unNombre,int atk,int def){
		this.nombre = unNombre;
		this.puntosDeAtaque = atk;
		this.puntosDeDefensa = def;		
	}
	
	public void ponerEnEstadoOfensivo() {
		this.estado = new EstadoOfensivo();
	}
	
	public void ponerEnEstadoDefensivo() {
		this.estado = new EstadoDefensivo();
	}
	
	public boolean estaEnEstadoOfensivo() {
		return estado.estaEnEstadoOfensivo();
	}
	
	public boolean estaEnEstadoDefensivo() {
		return estado.estaEnEstadoDefensivo();
	}

}
