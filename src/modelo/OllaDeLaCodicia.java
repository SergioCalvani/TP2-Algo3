package modelo;

public class OllaDeLaCodicia extends CartaMagica {

	public OllaDeLaCodicia() {
		super("Olla de la codicia");
	}

	@Override
	public void activar() {
		Mazo mazo = this.lado.obtenerMazo();
		Mano mano = this.lado.obtenerJugador().obtenerMano();
		
		mano.agregar(mazo.robar());
		mano.agregar(mazo.robar());
	}
}
