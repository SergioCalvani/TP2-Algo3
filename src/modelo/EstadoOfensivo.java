package modelo;

public class EstadoOfensivo implements Estado {
	public boolean estaEnEstadoOfensivo() {
		return true;
	}
	public boolean estaEnEstadoDefensivo() {
		return false;
	}
}
