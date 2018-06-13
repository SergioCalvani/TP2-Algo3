package modelo;

import java.util.ArrayList;
import java.util.Collection;

public class Tablero {

	private ZonaDeMonstruos zonaDeMonstruos;
	private ZonaDeMagicasYTrampa zonaMagica;
	private Collection<Carta> cementerio;
	private CartaDeCampo cartaDeCampo;
	
	public Tablero() {
		this.zonaDeMonstruos = new ZonaDeMonstruos();
		this.zonaMagica = new ZonaDeMagicasYTrampa();
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
		if(pos < 0 || pos > 4) {
			throw new PosicionInvalidaException(); 
		}
		if(this.zonaDeMonstruos.estaOcupado(pos)){
			throw new PosicionOcupadaException();
		}
		unaCartaMonstruo.ponerEnEstadoDefensivo();
		this.zonaDeMonstruos.agregar(unaCartaMonstruo,pos);
	}
	
	public void agregar(CartaMagica unaCartaMagica,int pos) {
		if(pos < 0 || pos > 4) {
			throw new PosicionInvalidaException(); 
		}
		if(this.zonaDeMonstruos.estaOcupado(pos)){
			throw new PosicionOcupadaException();
		}
		this.zonaMagica.agregar(unaCartaMagica,pos);
	}
	
	public void agregar(CartaTrampa unaCartaDeTrampa,int pos) {
		if(pos < 0 || pos > 4) {
			throw new PosicionInvalidaException(); 
		}
		if(this.zonaDeMonstruos.estaOcupado(pos)){
			throw new PosicionOcupadaException();
		}
		this.zonaMagica.agregar(unaCartaDeTrampa,pos);
	}
	
	public void agregarBocaAbajo(Carta carta) {
		carta.asignarPosicion(new BocaAbajo());
	}
	
}
