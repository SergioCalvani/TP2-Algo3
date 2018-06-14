package modelo;

import java.util.ArrayList;
import java.util.function.BooleanSupplier;

public class Lado {

	private int tamanio;
	private CartaMonstruo[] zonaDeMonstruos;
	private Carta[] zonaMagica;
	private ArrayList<Carta> cementerio;
	private Jugador duenio;
	private Tablero tablero;
	
	public Lado(Jugador jugador, Tablero tablero) {
		
		this.tamanio = 5;
		this.zonaDeMonstruos = new CartaMonstruo[tamanio];
		this.zonaMagica = new Carta[tamanio];
		this.cementerio = new ArrayList<Carta>();
		this.duenio = jugador;
		this.duenio.asignarLado(this);
		this.tablero = tablero;
	}

	public boolean esDuenio(Jugador jugador) {
		return this.duenio == jugador;
	}

	public void colocar(CartaMonstruo monstruo, int i) {
		monstruo.sacrificarSacricios();
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
		magica.asignarLado(this);
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

	public void voltearCartaMagicaEnPosicion(int i) {

		CartaMagica magica = (CartaMagica) this.zonaMagica[i];
		magica.voltear();
	}

	public Tablero obtenerTablero() {
		return this.tablero;
	}

	public void destruirTodosLosMonstruos() {
		for (CartaMonstruo monstruo: this.zonaDeMonstruos) {
			if (monstruo != null) {
				monstruo.destruir();
			}
		}
	}

	public boolean estaMonstruo(CartaMonstruo monstruoBuscado, int i) {
		CartaMonstruo monstruo = this.zonaDeMonstruos[i];
		return monstruoBuscado == monstruo;
	}
}
