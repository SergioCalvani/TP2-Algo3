package modelo;

import java.util.ArrayList;
import java.util.Collection;

public class Tablero {

	private Collection<CartaMonstruo> zonaDeMonstruos;
	private Collection<Carta> zonaMagica;
	private Collection<Carta> cementerio;
	private CartaDeCampo cartaDeCampo;
	
	public Tablero() {
		this.zonaDeMonstruos = new ArrayList<CartaMonstruo>();
		this.zonaMagica = new ArrayList<Carta>();
		this.cementerio = new ArrayList<Carta>();
	}
	
	/*public void agregar(CartaMonstruo unaCartaMonstruo) {
		this.zonaDeMonstruos.add(unaCartaMonstruo);	
	}*/
	
	public void agregarMonstruoEnEstadoOfensivo(CartaMonstruo unaCartaMonstruo){
		unaCartaMonstruo.ponerEnEstadoOfensivo();
		this.zonaDeMonstruos.add(unaCartaMonstruo);
	}
	
	public void agregarMonstruoEnEstadoDefensivo(CartaMonstruo unaCartaMonstruo){
		unaCartaMonstruo.ponerEnEstadoDefensivo();
		this.zonaDeMonstruos.add(unaCartaMonstruo);
	}
	
	public void agregar(CartaMagica unaCartaMagica) {
		this.zonaMagica.add(unaCartaMagica);
	}
	
	public void agregar(CartaTrampa unaCartaDeTrampa) {
		this.zonaMagica.add(unaCartaDeTrampa);
	}
	
	public void agregarBocaAbajo(Carta carta) {
		carta.asignarPosicion(new BocaAbajo());
	}
}
