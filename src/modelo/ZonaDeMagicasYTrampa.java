package modelo;

import java.util.HashMap;

public class ZonaDeMagicasYTrampa extends Zona{
	
	private HashMap<Integer,Carta> cartas;
	
	public ZonaDeMagicasYTrampa() {
		this.cartas = new HashMap<Integer,Carta> ();
	}
	
	public void agregar(CartaMagica carta,int pos) {
		if(this.estaOcupado(pos)){
			throw new PosicionOcupadaException();
		}
		this.cartas.put(pos, carta);
	}
	
	public void agregar(CartaTrampa carta,int pos) {
		if(this.estaOcupado(pos)){
			throw new PosicionOcupadaException();
		}
		this.cartas.put(pos, carta);
	}
	
}
