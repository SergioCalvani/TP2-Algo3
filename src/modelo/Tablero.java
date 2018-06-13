package modelo;

import java.util.ArrayList;
import java.util.Collection;

public class Tablero {

	private Zona zonaDeMonstruos;
	private Zona zonaMagica;
	private Collection<Carta> cementerio;
	private CartaDeCampo cartaDeCampo;
	
	public Tablero() {
		this.zonaDeMonstruos = new Zona();
		this.zonaMagica = new Zona();
		this.cementerio = new ArrayList<Carta>();
	}
	
	/*public void agregar(CartaMonstruo unaCartaMonstruo) {
		this.zonaDeMonstruos.add(unaCartaMonstruo);	
	}*/
	
	public void agregarMonstruoEnEstadoOfensivo(CartaMonstruo unaCartaMonstruo,int pos){
		unaCartaMonstruo.ponerEnEstadoOfensivo();
		this.zonaDeMonstruos.agregar(unaCartaMonstruo,pos);
	}
	
	public void agregarMonstruoEnEstadoDefensivo(CartaMonstruo unaCartaMonstruo,int pos){
		unaCartaMonstruo.ponerEnEstadoDefensivo();
		this.zonaDeMonstruos.agregar(unaCartaMonstruo,pos);
	}
	
	public void agregar(CartaMagica unaCartaMagica,int pos) {
		this.zonaMagica.agregar(unaCartaMagica,pos);
	}
	
	public void agregar(CartaTrampa unaCartaDeTrampa,int pos) {
		this.zonaMagica.agregar(unaCartaDeTrampa,pos);
	}
	
	public void agregarBocaAbajo(Carta carta) {
		carta.asignarPosicion(new BocaAbajo());
	}
	
}
