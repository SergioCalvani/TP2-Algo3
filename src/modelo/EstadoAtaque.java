package modelo;

public class EstadoAtaque extends Estado {

	private int puntosDeAtaque;
	
	public EstadoAtaque(int puntosDeAtaque) {
		this.puntosDeAtaque = puntosDeAtaque;
	}

	@Override
	public boolean enPosicionDeAtaque() {
		return true;
	}

	@Override
	public void calcularAtaque(CartaMonstruo monstruo1, Jugador duenio1, 
							  int puntosDeAtaque2, CartaMonstruo monstruo2, Jugador duenio2) {
		
		int d = this.puntosDeAtaque - puntosDeAtaque2;
		if (d > 0) {
			monstruo2.destruir();
			duenio2.disminuirVidaEn(d);
		} else if (d == 0) {
			monstruo1.destruir();
			monstruo2.destruir();
		} else	{
			duenio1.disminuirVidaEn(-d);
			monstruo1.destruir();
		}
	}

	@Override
	public void atacarA(CartaMonstruo monstruoAtacado, CartaMonstruo monstruoAtacante) {
		monstruoAtacado.enfrentarA(monstruoAtacante);
	}

	@Override
	public void enfrentarA(CartaMonstruo monstruoAtacante, CartaMonstruo monstruoAtacado) {
		monstruoAtacado.recibirDanioAPuntosDeAtaque(monstruoAtacante.extraerPuntosAtaque());
		monstruoAtacante.recibirDanioAPuntosDeAtaque(monstruoAtacado.extraerPuntosAtaque());
	}
}
