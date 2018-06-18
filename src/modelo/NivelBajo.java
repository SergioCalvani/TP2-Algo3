package modelo;

import java.util.Collection;

public class NivelBajo extends Nivel {

	@Override
	public void sacrificar(Collection<CartaMonstruo> sacrificios) {
		this.destruir(sacrificios);
	}
}
