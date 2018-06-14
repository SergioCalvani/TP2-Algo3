package modelo;

import java.util.Collection;

import excepciones.CantidadDeSacrificiosInvalidaException;

public class NivelSeisYMas extends Nivel {

	public void sacrificar(Collection<CartaMonstruo> sacrificios) {
		if (sacrificios.size() < 2) {
			throw new CantidadDeSacrificiosInvalidaException();
		}
		this.destruir(sacrificios);
	}

}
