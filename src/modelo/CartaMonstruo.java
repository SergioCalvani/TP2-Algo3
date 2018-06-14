package modelo;

import java.util.function.BooleanSupplier;

public class CartaMonstruo extends Carta {

	private int ataque;
	private int defensa;
	private int nivel;
	private boolean posicionDeAtaque;
	private Jugador duenio;
	
	public CartaMonstruo(String nombre, int ataque, int defensa, int nivel) {
		super(nombre);
		this.ataque = ataque;
		this.defensa = defensa;
		this.nivel = nivel;
		this.posicionDeAtaque = false;
	}

	public void cambiarAPosicionDeAtaque() {
		this.posicionDeAtaque = true;
	}

	public boolean estaEnPosicionDeAtaque() {
		return this.posicionDeAtaque;
	}

	public void cambiarAPosicionDeDefensa() {
		this.posicionDeAtaque = false;
	}

	public boolean estaEnPosicionDeDefensa() {
		return !this.estaEnPosicionDeAtaque();
	}

	public void asignarDuenio(Jugador duenio) {
		this.duenio = duenio;
	}

}
