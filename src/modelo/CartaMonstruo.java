package modelo;

import java.util.ArrayList;
import java.util.Collection;

public class CartaMonstruo extends Carta {

	protected int ataque;
	protected int defensa;
	protected Jugador duenio;
	protected EstadoAtaque estadoAtaque;
	protected EstadoDefensa estadoDefensa;
	protected Estado estadoActual;
	protected Nivel nivel;
	protected Collection<CartaMonstruo> sacrificios;
	
	public CartaMonstruo(String nombre, int ataque, int defensa, int nivel) {
		super(nombre);
		this.ataque = ataque;
		this.defensa = defensa;
		this.nivel = Nivel.crearNivel(nivel);
		this.estadoAtaque = new EstadoAtaque(ataque);
		this.estadoDefensa = new EstadoDefensa(defensa);
		this.estadoActual = this.estadoDefensa;
		this.sacrificios = new ArrayList<CartaMonstruo>();
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
	
	public void agregarSacrificio(CartaMonstruo monstruo) {
		this.sacrificios.add(monstruo);
	}

	public void sacrificarSacricios() {
		this.nivel.sacrificar(this.sacrificios);
		this.sacrificios = new ArrayList<CartaMonstruo>();
	}
	
	public void aumentarAtaque(int aumento){
		this.ataque = this.ataque + aumento;
	}
	
	public void aumentarDefensa(int aumento){
		this.defensa = this.defensa + aumento;
	}
	
	public int extraerPuntosAtaque(){
		return this.ataque;
	}
	
	public int extraerPuntosDefensa(){
		return this.defensa;
	}

}
