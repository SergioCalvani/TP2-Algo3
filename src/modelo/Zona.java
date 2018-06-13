package modelo;

public abstract class Zona {
	public boolean estaOcupado(int pos) {
		if(pos < 0 || pos > 4) {
			throw new PosicionInvalidaException(); 
		}
		return this.cartas.containsKey(pos);
	}
}
