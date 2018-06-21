package modelo;

import java.util.ArrayList;
import java.util.Collection;

public class CartaMonstruo extends Carta {

	protected int ataque;
	protected int defensa;
	protected Jugador duenio;
	protected Estado estado;
	protected Nivel nivel;
	protected Collection<CartaMonstruo> sacrificios;
	
	public CartaMonstruo(String nombre, int ataque, int defensa, int nivel) {
		super(nombre);
		this.ataque = ataque;
		this.defensa = defensa;
		this.nivel = Nivel.crearNivel(nivel);
		this.estado = new EstadoAtaque();
		this.sacrificios = new ArrayList<CartaMonstruo>();
	}

	public void asignarEstado(Estado estado) {
		this.estado = estado;
	}
	
	public void cambiarAPosicionDeAtaque() {
		this.estado = new EstadoAtaque();
	}

	public boolean estaEnPosicionDeAtaque() {
		return this.estado.enPosicionDeAtaque();
	}

	public void cambiarAPosicionDeDefensa() {
		this.estado = new EstadoDefensa();
	}

	public boolean estaEnPosicionDeDefensa() {
		return !this.estado.enPosicionDeAtaque();
	}

	public void asignarDuenio(Jugador duenio) {
		this.duenio = duenio;
	}

	public void atacarA(CartaMonstruo monstruoAtacado) {
		this.estado.atacarA(monstruoAtacado, this);
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

	public void enfrentarA(CartaMonstruo monstruoAtacante) {
		this.estado.enfrentarA(monstruoAtacante, this);
	}

	public void recibirDanioAPuntosDeAtaque(int ataqueRecibido) {
		int puntosResistidos = this.ataque - ataqueRecibido;
		if (puntosResistidos <= 0) {
			this.duenio.disminuirVidaEn(-puntosResistidos);
			this.destruir();
		}
	}

	public void recibirDanioAPuntosDeDefensa(int ataqueRecibido) {
		int puntosResistidos = this.defensa - ataqueRecibido;
		if (puntosResistidos <= 0) {
			this.destruir();
		}
	}

}
