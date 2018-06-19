package modelo.cartas;

import modelo.CartaMonstruo;

public class DragonDefinitivoDeOjosAzules extends CartaMonstruo {

	public DragonDefinitivoDeOjosAzules() {
		super("Dragon definitivo de ojos azules", 4500, 3800, 12);
	}

	@Override
	public void agregarSacrificio(CartaMonstruo monstruo) {}
	
	public void agregarSacrificio(DragonBlancoDeOjosAzules dragon) {
		super.agregarSacrificio(dragon);
	}
}
