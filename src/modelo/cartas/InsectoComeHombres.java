package modelo.cartas;

import modelo.CartaMonstruo;
import modelo.Jugador;
import modelo.Lado;

public class InsectoComeHombres extends CartaMonstruo{

	public InsectoComeHombres() {
		super("InsectoComeHombres",450,600,2);
	}
	
	public void atacarCon(int puntosDeAtaque, CartaMonstruo otroMonstruo, Jugador otroDuenio) {
		this.bocaArriba = true;
		this.activar(otroMonstruo,otroDuenio);
	}

	public void activar(CartaMonstruo otroMonstruo,Jugador otroDuenio){
		Lado ladoEnemigo;
		ladoEnemigo = otroDuenio.obtenerLado();
		ladoEnemigo.destruir(otroMonstruo);
	}
}
