package modelo;

public abstract class Carta {

	protected String nombre;
	protected Jugador duenio;
	protected boolean bocaArriba;
	
	public Carta(String nombre) {
		this.nombre = nombre;
		this.bocaArriba = false;
	}
	
	public String extraerNombre(){
		return this.nombre;
	}	
	
	public boolean estaBocaAbajo() {
		return !this.bocaArriba;
	}
	
	public void voltear() {
		if (!bocaArriba) {
			bocaArriba = true;
		}
		this.activar();
	}
	
	public void asignarDuenio(Jugador duenio) {
		this.duenio = duenio;
	}
	
	public void activar() {}

	public void permitirInvocador(InvocadorDeExodia invocadorDeExodia) {		
	};
}
