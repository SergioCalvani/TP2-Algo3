package modelo;

import java.util.function.BooleanSupplier;

public class CartaMonstruo extends Carta {

	private int ataque;
	private int defensa;
	private int nivel;
	private Jugador duenio;
	private EstadoAtaque estadoAtaque;
	private EstadoDefensa estadoDefensa;
	private Estado estadoActual;
	
	public CartaMonstruo(String nombre, int ataque, int defensa, int nivel) {
		super(nombre);
		this.ataque = ataque;
		this.defensa = defensa;
		this.nivel = nivel;
		this.estadoAtaque = new EstadoAtaque(ataque);
		this.estadoDefensa = new EstadoDefensa(defensa);
		this.estadoActual = this.estadoDefensa;
	}

	public void cambiarAPosicionDeAtaque() {
		this.estadoActual = this.estadoAtaque;
	}

	public boolean estaEnPosicionDeAtaque() {
		return this.estadoActual.enPosicionDeAtaque();
	}

	public void cambiarAPosicionDeDefensa() {
		this.estadoActual = this.estadoDefensa;
	}

	public boolean estaEnPosicionDeDefensa() {
		return !this.estadoActual.enPosicionDeAtaque();
	}

	public void asignarDuenio(Jugador duenio) {
		this.duenio = duenio;
	}

	public void atacarA(CartaMonstruo otroMonstruo) {
		otroMonstruo.atacarCon(this.ataque, this, this.duenio);
	}

	public void atacarCon(int puntosDeAtaque, CartaMonstruo otroMonstruo, Jugador otroDuenio) {
		this.estadoActual.calcularAtaque(this, this.duenio,
										 puntosDeAtaque, otroMonstruo, otroDuenio);
	}

	public void destruir() {
		Lado lado = this.duenio.obtenerLado();
		lado.destruir(this);
	}

}
