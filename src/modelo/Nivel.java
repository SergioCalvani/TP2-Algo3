package modelo;

import java.util.Collection;

import excepciones.NivelInvalidoException;

public abstract class Nivel {

	public static Nivel crearNivel(int unNivel) {
		
		if (unNivel >= 1 && unNivel <= 4) {
			return new NivelBajo();
		} else if (unNivel >= 5 && unNivel <= 6) {
			return new NivelMedio();
		} else if (unNivel > 6){
			return new NivelSuperior();
		} else {
			throw new NivelInvalidoException();
		}
		
	}
	
	public abstract void sacrificar(Collection<CartaMonstruo> sacrificios);

	protected void destruir(Collection<CartaMonstruo> sacrificios) {
		for (CartaMonstruo monstruo: sacrificios) {
			monstruo.destruir();
		}
	}

	public abstract void sacrificar(int sacrificios);
}