package it.polito.tdp.model;

public class Event implements Comparable<Event>{

	private EventType tipo;
	private int tempoArrivo;
	private int numeroPersone;
	private int durata;
	private float tolleranza;
	private Tavolo tavolo;
	
	public Event(EventType tipo, int tempoArrivo, int numeroPersone, int durata, float tolleranza) {
		super();
		this.tipo = tipo;
		this.tempoArrivo = tempoArrivo;
		this.numeroPersone = numeroPersone;
		this.durata = durata;
		this.tolleranza = tolleranza;
		this.tavolo = null;
	}

	public EventType getTipo() {
		return tipo;
	}

	public int getTempoArrivo() {
		return tempoArrivo;
	}

	public int getNumeroPersone() {
		return numeroPersone;
	}

	public int getDurata() {
		return durata;
	}

	public float getTolleranza() {
		return tolleranza;
	}

	public Tavolo getTavolo() {
		return tavolo;
	}

	public void setTavolo(Tavolo tavolo) {
		this.tavolo = tavolo;
	}

	@Override
	public int compareTo(Event other) {
		return this.tempoArrivo-other.getTempoArrivo();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + durata;
		result = prime * result + numeroPersone;
		result = prime * result + ((tavolo == null) ? 0 : tavolo.hashCode());
		result = prime * result + tempoArrivo;
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + Float.floatToIntBits(tolleranza);
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
		Event other = (Event) obj;
		if (durata != other.durata)
			return false;
		if (numeroPersone != other.numeroPersone)
			return false;
		if (tavolo == null) {
			if (other.tavolo != null)
				return false;
		} else if (!tavolo.equals(other.tavolo))
			return false;
		if (tempoArrivo != other.tempoArrivo)
			return false;
		if (tipo != other.tipo)
			return false;
		if (Float.floatToIntBits(tolleranza) != Float.floatToIntBits(other.tolleranza))
			return false;
		return true;
	}

	
	
	
	
}
