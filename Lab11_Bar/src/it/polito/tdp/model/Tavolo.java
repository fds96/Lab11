package it.polito.tdp.model;

public class Tavolo implements Comparable<Tavolo>{
	
	private int posti;
	private boolean occupato;
	private int id;
	
	public Tavolo(int posti, int id) {
		super();
		this.posti = posti;
		this.occupato = false;
		this.id=id;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tavolo other = (Tavolo) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public String toString() {
		return "Posti: " + this.posti + " Occupato: " + this.occupato;
	}

	@Override
	public int compareTo(Tavolo other) {
		return this.posti-other.getPosti();
	}

}
