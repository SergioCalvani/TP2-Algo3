package modelo;

import java.util.Collection;

import excepciones.CantidadDeSacrificiosInvalidaException;

public class NivelMedio extends Nivel {

	@Override
	public void sacrificar(Collection<CartaMonstruo> sacrificios) {
		if (sacrificios.size() < 1) {
			throw new CantidadDeSacrificiosInvalidaException();
		}
		this.destruir(sacrificios);
	}

	@Override
	public void sacrificar(int sacrificios) {
		if (sacrificios < 1) {
			throw new CantidadDeSacrificiosInvalidaException();
		}
	}

}
