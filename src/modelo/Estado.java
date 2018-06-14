package modelo;

public abstract class Estado {
	
	public abstract boolean enPosicionDeAtaque(); 
	
	public abstract void calcularAtaque(
		CartaMonstruo monstruo1, Jugador duenio1,
		int puntosDeAtaque2, CartaMonstruo monstruo2, Jugador duenio2
	);
}