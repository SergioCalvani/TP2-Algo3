package modelo;

public class BrazoDerechoDeExodia extends CartaMonstruo {

	public BrazoDerechoDeExodia() {
		super("Brazo derecho de Exodia", 1000, 1000, 3);
	}

	@Override
	public void permitirInvocador(InvocadorDeExodia invocadorDeExodia) {
		invocadorDeExodia.invocarBrazoDerechoDeExodia();
	};	
	
}
