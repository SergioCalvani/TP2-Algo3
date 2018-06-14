package modelo;

import java.util.ArrayList;

public class Lado {

	private int tamanio;
	private CartaMonstruo[] zonaDeMonstruos;
	private Carta[] zonaMagica;
	private ArrayList<Carta> cementerio;
	private Jugador duenio;
	private Tablero tablero;
	private int sacrificios;
	
	public Lado(Jugador jugador, Tablero tablero) {
		
		this.tamanio = 5;
		this.zonaDeMonstruos = new CartaMonstruo[tamanio];
		this.zonaMagica = new Carta[tamanio];
		this.cementerio = new ArrayList<Carta>();
		this.duenio = jugador;
		this.duenio.asignarLado(this);
		this.tablero = tablero;
		this.sacrificios = 0;
	}

	public boolean esDuenio(Jugador jugador) {
		return this.duenio == jugador;
	}

	public boolean estaEnCampoMonstruo(CartaMonstruo monstruo) {
		for(int i=0;i < this.tamanio; i++) {
			if (this.zonaDeMonstruos[i] == monstruo) {
				return true;
			}
		}
		return false;
	}
	
	public void colocar(CartaMonstruo monstruo, int i) {
		if(monstruo.sacrificiosRequeridos() > this.sacrificios) {
			try {
				throw new SacrificiosInsuficientesException();
			} catch (SacrificiosInsuficientesException e) {
				e.printStackTrace();
			}
			
		}
		this.sacrificios=this.sacrificios-monstruo.sacrificiosRequeridos();
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
		for (int i = 0; i < this.tamanio; i++) {
			if (this.zonaDeMonstruos[i] == cartaMonstruo) {
				this.zonaDeMonstruos[i] = null;
				this.cementerio.add(cartaMonstruo);
				return;
			}
		}
	}

	public void voltearCartaMagicaEnPosicion(int i) {

		CartaMagica magica = (CartaMagica) this.zonaMagica[i];
		magica.voltear();
	}
	
	public void sacrificar(int i) {
		this.destruirCartaMonstruo(i);
		(this.sacrificios)++;
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
}
