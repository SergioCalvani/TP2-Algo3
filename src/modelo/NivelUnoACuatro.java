package modelo;

import java.util.Collection;

public class NivelUnoACuatro extends Nivel {

	@Override
	public void sacrificar(Collection<CartaMonstruo> sacrificios) {
		this.destruir(sacrificios);
	}

}
