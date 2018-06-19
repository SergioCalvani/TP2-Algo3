package modelo.cartas;

import modelo.CartaMonstruo;
import modelo.CartaTrampa;

public class Reinforcements extends CartaTrampa{

	public Reinforcements() {
		super("Reinforcements");
	}
	
	public void activar(CartaMonstruo cartaAtacada,CartaMonstruo cartaParaAtacar){
		cartaAtacada.aumentarAtaque(500);
		cartaAtacada.atacarA(cartaParaAtacar);
	}
}
