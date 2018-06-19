package modelo;

public abstract class Carta {

	protected String nombre;
	protected boolean bocaArriba;
	
	public Carta(String nombre) {
		this.nombre = nombre;
		this.bocaArriba = false;
	}
	
	public boolean estaBocaAbajo() {
		return !this.bocaArriba;
	}
	
	public void voltear() {
		if (!bocaArriba) {
			bocaArriba = false;
		}
		this.activar();
	}
	
	public void activar() {}

	public void permitirInvocador(InvocadorDeExodia invocadorDeExodia) {		
	};
}
