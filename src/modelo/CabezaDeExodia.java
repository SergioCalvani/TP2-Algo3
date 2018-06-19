package modelo;

public class CabezaDeExodia extends CartaMonstruo {

	public CabezaDeExodia() {
		super("Cabeza de Exodia", 1000, 1000, 3);	
	}
	
	@Override
	public void permitirInvocador(InvocadorDeExodia invocadorDeExodia) {
		invocadorDeExodia.invocarCabezaDeExodia();
	};

}
