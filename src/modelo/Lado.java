package modelo;

import java.util.ArrayList;

import excepciones.PosicionOcupadaException;

public class Lado {

	private int tamanio;
	private CartaDeCampo CartaCampo;
	private CartaMonstruo[] zonaDeMonstruos;
	private Carta[] zonaMagica;
	private ArrayList<Carta> cementerio;
	private Jugador duenio;
	private Tablero tablero;
	private int sacrificios;
	private Mazo mazo;
	
	public Lado(Jugador jugador, Tablero tablero) {
		
		this.tamanio = 5;
		this.zonaDeMonstruos = new CartaMonstruo[tamanio];
		this.zonaMagica = new Carta[tamanio];
		this.cementerio = new ArrayList<Carta>();
		this.CartaCampo = null;
		this.duenio = jugador;
		this.duenio.asignarLado(this);
		this.tablero = tablero;
		this.sacrificios = 0;
		this.mazo = new Mazo();
		
		/*for(int i =0;i<this.tamanio;i++) {
			this.duenio.agregarCartaAMano(this.mazo.robar());
		}*/
		
	}

	public void robarCartaDelMazo() {
		this.duenio.agregarCartaAMano(this.mazo.robar());
	}
	
	public Mano obtenerMano() {
		return this.duenio.obtenerMano();
	}
	public boolean esDuenio(Jugador jugador) {
		return this.duenio == jugador;
	}
	
	public CartaMonstruo[] obtenerZonaMonstruo(){
		return zonaDeMonstruos;
	}
	
	public void colocarCartaDeCampo(CartaDeCampo campo){
		CartaCampo = campo;
		this.tablero.seAgregoCartaDeCampo();
		campo.asignarTableroYDuenio(this.tablero,this.duenio);
		campo.activar();
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
		if(this.CartaCampo != null){
			CartaCampo.aplicarEfectoCartaIndividualDuenio(monstruo);
		}
		else{
			this.tablero.verificarCartaDeCampoLadoContrario(this,monstruo);
		}
		monstruo.sacrificarSacricios();
		if(this.zonaDeMonstruos[i] != null){
			throw new PosicionOcupadaException();
		}
		this.zonaDeMonstruos[i] = monstruo;
		monstruo.cambiarAPosicionDeAtaque();
		monstruo.asignarDuenio(this.duenio);
	}

	public void cambiarAPosicionDeDefensaMonstruo(int i) {
		CartaMonstruo carta = (CartaMonstruo) this.zonaDeMonstruos[i];
		carta.cambiarAPosicionDeDefensa();
	}

	public void colocar(CartaMagica magica, int i) {
		if(this.zonaMagica[i] != null){
			throw new PosicionOcupadaException();
		}
		this.zonaMagica[i] = magica;
		magica.asignarDuenio(this.duenio);
	}

	public void colocar(CartaTrampa trampa, int i) {
		if(this.zonaMagica[i] != null){
			throw new PosicionOcupadaException();
		}
		this.zonaMagica[i] = trampa;
		trampa.asignarDuenio(this.duenio);
	}

	public void destruirCartaMonstruo(int i) {
		Carta carta = this.zonaDeMonstruos[i];
		this.zonaDeMonstruos[i] = null;
		this.cementerio.add(carta);
	}

	public boolean cementerioContiene(Carta unaCarta) {
		return this.cementerio.contains(unaCarta);
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
	
	public void destruir(CartaMagica cartaMagica) {
		for (int i = 0; i < this.tamanio; i++) {
			if (this.zonaMagica[i] == cartaMagica) {
				this.zonaMagica[i] = null;
				this.cementerio.add(cartaMagica);
				return;
			}
		}
	}
	
	public void destruir(CartaTrampa cartaTrampa) {
		for (int i = 0; i < this.tamanio; i++) {
			if (this.zonaMagica[i] == cartaTrampa) {
				this.zonaMagica[i] = null;
				this.cementerio.add(cartaTrampa);
				return;
			}
		}
	}

	public void voltearCartaMagicaEnPosicion(int i) {
		CartaMagica magica = (CartaMagica) this.zonaMagica[i];
		magica.voltear();
	}
	
	public void voltearCartaMostruoEnPosicion(int i) {
		CartaMonstruo monstruo = (CartaMonstruo) this.zonaDeMonstruos[i];
		monstruo.voltear();
	}
	
	public void sacrificar(int i) {
		this.destruirCartaMonstruo(i);
		(this.sacrificios)++;
	}
	
	public Tablero obtenerTablero() {
		return this.tablero;
	}
	
	public Jugador obtenerJugador(){
		return this.duenio;
	}

	public void destruirTodosLosMonstruos() {
		
		for (CartaMonstruo monstruo: this.zonaDeMonstruos) {
			if (monstruo != null) {
				monstruo.destruir();
			}
		}
	}
	
	public void aumentarPuntosAtaque(int aumento){
		for (int i = 0; i < this.tamanio; i++) {
			if(zonaDeMonstruos[i] != null){
				this.zonaDeMonstruos[i].aumentarAtaque(aumento);
			}
		}
	}
	
	public void aumentarPuntosDefensa(int aumento){
		for (int i = 0; i < this.tamanio; i++) {
			if(zonaDeMonstruos[i] != null){
				this.zonaDeMonstruos[i].aumentarDefensa(aumento);
			}
		}
	}

	public Mazo obtenerMazo() {
		return this.mazo;
	}
	
	public void atacarConMonstruoEnPosicionAMonstruoEnPosicion(int posicionDeMiZona,int posicionZonaContrario){
		CartaMonstruo cartaParaAtacar;
		cartaParaAtacar = this.zonaDeMonstruos[posicionDeMiZona];
		this.tablero.atacarAEnemigoCon(this,cartaParaAtacar,posicionZonaContrario);
	}
	
	public void atacarMonstruoEnPosicionCon(int posicionMonstruoAtacado,CartaMonstruo cartaParaAtacar){
		boolean activoTrampa = false;
		CartaTrampa cartaMagica;
		CartaMonstruo cartaAtacada;
		cartaAtacada = this.zonaDeMonstruos[posicionMonstruoAtacado];
		for(int i = 0; i < this.tamanio; i++){
			if(this.zonaMagica[i] != null){
				cartaMagica = (CartaTrampa) this.zonaMagica[i];
				if(cartaMagica.verificarCarta()){
					cartaMagica.activar(cartaAtacada,cartaParaAtacar);
					activoTrampa = true;
				} 
			}
		}
		if(!activoTrampa){
			cartaParaAtacar.atacarA(cartaAtacada);
		}
	}
	
	public boolean estaMonstruo(CartaMonstruo monstruoBuscado, int i) {
		CartaMonstruo monstruo = this.zonaDeMonstruos[i];
		return monstruoBuscado == monstruo;
	}
	
	public void aplicarEfectoCampoIndividualEnemigo(CartaMonstruo monstruo){
		this.CartaCampo.aplicarEfectoCartaIndividualEnemigo(monstruo);
	}
}
