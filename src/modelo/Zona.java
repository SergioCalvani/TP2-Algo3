package modelo;


public class Zona {
	private Carta[] cartas;
	
	public Zona() {
		this.cartas = new Carta[5];
	}
	
	public void agregar(CartaMonstruo carta,int pos) {
		try {
			if(this.cartas[pos] != null){
				throw new PosicionOcupadaException();
			}
		}catch(ArrayIndexOutOfBoundsException excepcion) {
			throw(new PosicionInvalidaException());
		}
		this.cartas[pos] = carta;
	}
}
