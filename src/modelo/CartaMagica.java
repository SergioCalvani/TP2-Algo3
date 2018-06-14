package modelo;

public abstract class CartaMagica extends Carta {

	protected Lado lado;
	
	public CartaMagica(String nombre) {
		super(nombre);
	}

	public void asignarLado(Lado lado) {
		this.lado = lado;
	}
	
	@Override
	public abstract void activar();
}
