package modelo;

import java.util.Collection;

import excepciones.CantidadDeSacrificiosInvalidaException;

public class NivelSuperior extends Nivel {

	@Override
	public void sacrificar(Collection<CartaMonstruo> sacrificios) {
		if (sacrificios.size() < 2) {
			throw new CantidadDeSacrificiosInvalidaException();
		}
		this.destruir(sacrificios);
	}

}
