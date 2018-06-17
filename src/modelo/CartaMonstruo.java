package modelo;


public class CartaMonstruo extends Carta {

	protected int ataque;
	protected int defensa;
	protected int nivel;
	protected Jugador duenio;
	protected EstadoAtaque estadoAtaque;
	protected EstadoDefensa estadoDefensa;
	protected Estado estadoActual;
	
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
	
	public int sacrificiosRequeridos() {
		//ESTA FUNCION HAY QUE CAMBIARLA!!
		//HAY QUE PONER UNA INTERFAZ PARA LOS NIVELES
		if(this.nivel<5) {
			return 0;
		}
		else if(this.nivel >= 5 && this.nivel < 7) {
			return 1;
		}
		else if(this.nivel >= 7) {
			return 2;
		}
		return -1;
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
