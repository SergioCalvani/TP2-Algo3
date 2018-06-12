package modelo;

public class EstadoDefensivo implements Estado {
	public boolean estaEnEstadoOfensivo() {
		return false;
	}
	public boolean estaEnEstadoDefensivo() {
		return true;
	}
}
