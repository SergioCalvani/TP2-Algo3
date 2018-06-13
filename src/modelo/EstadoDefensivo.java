package modelo;

public class EstadoDefensivo implements Estado {
	
	public EstadoDefensivo() {
	}
	
	@Override
	public boolean estaEnEstadoOfensivo() {
		return false;
	}
	
	@Override
	public boolean estaEnEstadoDefensivo() {
		return true;
	}
}
