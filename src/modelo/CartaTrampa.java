package modelo;

public class CartaTrampa extends Carta {
	
	protected Jugador duenio;

	public CartaTrampa(String nombre) {
		super(nombre);
	}
	
	public String obtenerNombre(){
		return this.nombre;
	}
	
	public void asignarDuenio(Jugador nuevoDuenio){
		this.duenio = nuevoDuenio;
	}

	public void activar(CartaMonstruo cartaAtacada, CartaMonstruo cartaParaAtacar) {};
}
