package modelo;

import java.util.ArrayList;
import java.util.Collection;

public class Mano {
	
	private Collection<Carta> coleccionDeCartas;
	
	public Mano() {
		this.coleccionDeCartas = new ArrayList();
	}
	
	public void agregar(Carta unaCarta) {
		this.coleccionDeCartas.add(unaCarta);
	}

	public Object obtenerTamanio() {
		return this.coleccionDeCartas.size();
	}

	public boolean contieneExodia() {
		InvocadorDeExodia invocador = new InvocadorDeExodia();
		return invocador.exodiaEstaInvocado(this.coleccionDeCartas);
			  
	}

}
