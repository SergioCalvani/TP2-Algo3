package modelo;

import java.util.Collections;
import java.util.Stack;

import modelo.cartas.AgujeroOscuro;
import modelo.cartas.CilindroMagico;
import modelo.cartas.Fisura;

public class Mazo {

	private Stack<Carta> pila;
	
	public Mazo() {
		this.pila = new Stack<Carta>();
		// Este mazo contiene 40 cartas:
		//	- 25 monstruos
		//  - 10 magicas
		//	- 5 trampas
		
		// CAMBIAR
		// Monstruo
		for (int i = 0; i < 5; i++) {
			this.pila.push(new CartaMonstruo("Beautiful Headhuntress", 1600, 800, 4));
			this.pila.push(new CartaMonstruo("Amazon of the Seas", 1300, 1400, 4));
			this.pila.push(new CartaMonstruo("Crowned by the World Chalice", 0, 2100, 2));
			this.pila.push(new CartaMonstruo("Harpie Girl", 500, 500, 2));
			this.pila.push(new CartaMonstruo("Maiden of the Moonlight",1500, 1300, 4));
		}
		
		// Magicas
		for (int i = 0; i < 5; i++) {
			this.pila.push(new AgujeroOscuro());
			this.pila.push(new Fisura());
		}
		
		// Trampa
		for (int i = 0; i < 5; i++) {
			this.pila.push(new CilindroMagico());
		}
				
		Collections.shuffle(this.pila);
	}
	
	public int obtenerTamanio() {
		return this.pila.size();
	}

	public Carta robar() {
		return this.pila.pop();
	}

	public boolean estaVacio() {
		return this.pila.isEmpty();
	}
}
