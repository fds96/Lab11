package it.polito.tdp.model;

public class Tavolo {
	
	private int posti;
	private boolean occupato;
	
	public Tavolo(int posti) {
		super();
		this.posti = posti;
		this.occupato = false;
	}

	public int getPosti() {
		return posti;
	}

	public void setPosti(int posti) {
		this.posti = posti;
	}

	public boolean isOccupato() {
		return occupato;
	}

	public void setOccupato(boolean occupato) {
		this.occupato = occupato;
	}
	
	public String toString() {
		return "Posti: " + this.posti + " Occupato: " + this.occupato;
	}

}
