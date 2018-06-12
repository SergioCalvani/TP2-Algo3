package modelo;

public class EstadoDefensivo extends Estado {
	public boolean estaEnEstadoOfensivo() {
		return false;
	}
	public boolean estaEnEstadoDefensivo() {
		return true;
	}
}
