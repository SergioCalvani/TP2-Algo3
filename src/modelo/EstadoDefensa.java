package modelo;

import excepciones.ImposibleAtacarEnEstadoDeDefensaException;

public class EstadoDefensa extends Estado {

	private int puntosDeDefensa;
	
	public EstadoDefensa(int puntosDeDefensa) {
		this.puntosDeDefensa = puntosDeDefensa;
	}
	
	@Override
	public boolean enPosicionDeAtaque() {
		return false;
	}

	@Override
	public void calcularAtaque(CartaMonstruo monstruo1, Jugador duenio1, int puntosDeAtaque2, CartaMonstruo monstruo2,
			Jugador duenio2) {
		int d = this.puntosDeDefensa - puntosDeAtaque2;
		if (d <= 0) {
			monstruo1.destruir();
		}
	}

	@Override
	public void atacarA(CartaMonstruo monstruoAtacado, CartaMonstruo monstruoAtacante) {
		throw new ImposibleAtacarEnEstadoDeDefensaException();
	}

	@Override
	public void enfrentarA(CartaMonstruo monstruoAtacante, CartaMonstruo monstruoAtacado) {
		monstruoAtacado.recibirDanioAPuntosDeDefensa(monstruoAtacante.extraerPuntosAtaque());
	}
}
