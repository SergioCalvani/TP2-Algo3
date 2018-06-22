package modelo;

public class CartaTrampa extends Carta {
	
	protected Jugador duenio;

	public CartaTrampa(String nombre) {
		super(nombre);
	}
	
	public boolean verificarCarta(){
		if((this.nombre == "Cilindro Magico") | (this.nombre == "Reinforcements")){
			return true;
		}
		return false;
	}
	
	public void asignarDuenio(Jugador nuevoDuenio){
		this.duenio = nuevoDuenio;
	}

	public void activar(CartaMonstruo cartaAtacada, CartaMonstruo cartaParaAtacar) {};
}
