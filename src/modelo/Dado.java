package modelo;

import java.util.Random;

public class Dado {
	
	private int numcaras;
	private int valordado;
	
	public Dado() {
		this.numcaras=6;
	}
	
	public int getNumcaras() {
		return numcaras;
	}
	
	public int getValordado() {
		return this.valordado;
	}
	
	public String toString() {
		return Integer.toString(this.valordado);
	}
	
	public int tirardado() {
		Random r = new Random();
		int valorDado = r.nextInt(6)+1;
		this.valordado = valorDado;
		return valorDado;
	}

}
