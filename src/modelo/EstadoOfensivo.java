package modelo;

public class EstadoOfensivo implements Estado {
	
	public EstadoOfensivo() {
	}
	
	@Override
	public boolean estaEnEstadoOfensivo() {
		return true;
	}
	
	@Override
	public boolean estaEnEstadoDefensivo() {
		return false;
	}
}
