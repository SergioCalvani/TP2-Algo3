package modelo;

import java.util.ArrayList;
import java.util.function.BooleanSupplier;

public class Lado {

	private int tamanio;
	private Carta[] zonaDeMonstruos;
	private Carta[] zonaMagica;
	private ArrayList<Carta> cementerio;
	private Jugador duenio;
	
	public Lado(Jugador jugador) {
		
		this.tamanio = 5;
		this.zonaDeMonstruos = new Carta[tamanio];
		this.zonaMagica = new Carta[tamanio];
		this.cementerio = new ArrayList<Carta>();
		this.duenio = jugador;
		this.duenio.asignarLado(this);
	}

	public boolean esDuenio(Jugador jugador) {
		return this.duenio == jugador;
	}

	public void colocar(CartaMonstruo monstruo, int i) {
		this.zonaDeMonstruos[i] = monstruo;
		monstruo.cambiarAPosicionDeAtaque();
		monstruo.asignarDuenio(this.duenio);
	}

	public void cambiarAPosicionDeDefensaMonstruo(int i) {
		CartaMonstruo carta = (CartaMonstruo) this.zonaDeMonstruos[i];
		carta.cambiarAPosicionDeDefensa();
	}

	public void colocar(CartaMagica magica, int i) {
		this.zonaMagica[i] = magica;
	}

	public void colocar(CartaTrampa trampa, int i) {
		this.zonaMagica[i] = trampa;
	}

	public void destruirCartaMonstruo(int i) {
		Carta carta = this.zonaDeMonstruos[i];
		this.zonaDeMonstruos[i] = null;
		this.cementerio.add(carta);
	}

	public boolean cementerioContiene(CartaMonstruo monstruo) {
		return this.cementerio.contains(monstruo);
	}

	public void destruir(CartaMonstruo cartaMonstruo) {
		this.cementerio.add(cartaMonstruo);
		
		for (int i = 0; i < this.tamanio; i++) {
			if (this.zonaDeMonstruos[i] == cartaMonstruo) {
				this.zonaDeMonstruos[i] = null;
				return;
			}
		}
	}
}
