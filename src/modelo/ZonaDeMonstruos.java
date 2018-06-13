package modelo;

import java.util.HashMap;

public class ZonaDeMonstruos extends Zona {
	
	private HashMap<Integer,CartaMonstruo> cartas;
	
	public ZonaDeMonstruos() {
		this.cartas = new HashMap<Integer,CartaMonstruo> ();
	}
	
	public void agregar(CartaMonstruo carta,int pos) {
		if(this.estaOcupado(pos)){
			throw new PosicionOcupadaException();
		}
		this.cartas.put(pos, carta);
	}
	
	
}
