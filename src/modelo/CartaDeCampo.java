package modelo;

public abstract class CartaDeCampo extends Carta{
	
	protected Tablero tablero;
	protected Jugador duenio;
	
	public CartaDeCampo(String unNombre){
		super(unNombre);
	}
	
	public void asignarTableroYDuenio(Tablero unTablero,Jugador unDuenio) {
		this.tablero = unTablero;
		this.duenio = unDuenio;
	}
	
	@Override
	public abstract void activar();
	
	public abstract void efectoDuenio(Lado unLado);
	
	public abstract void efectoEnemigo(Lado unLado);
}
