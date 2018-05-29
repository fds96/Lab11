package it.polito.tdp.model;

import java.util.*;

public class Simulazione {
	
	private int timeMax;
	private int numeroPersoneMax;
	private int tempoConsumazioneMin;
	private int durataConsumazioneMax;
	private int tolleranzaMax;
	private List<Tavolo> tavoli;
	private PriorityQueue<Event> queue;
	
	public Simulazione() {
		this.timeMax = 10;
		this.numeroPersoneMax = 10;
		this.tempoConsumazioneMin = 60;
		this.durataConsumazioneMax = 60;
		this.tolleranzaMax = 90;
		this.queue = new PriorityQueue<>();
		this.inizializzaTavoli();
	}

	private void inizializzaTavoli() {
		tavoli.add(new Tavolo(10));
		tavoli.add(new Tavolo(10));
		tavoli.add(new Tavolo(8));
		tavoli.add(new Tavolo(8));
		tavoli.add(new Tavolo(8));
		tavoli.add(new Tavolo(8));
		tavoli.add(new Tavolo(6));
		tavoli.add(new Tavolo(6));
		tavoli.add(new Tavolo(6));
		tavoli.add(new Tavolo(6));
		tavoli.add(new Tavolo(4));
		tavoli.add(new Tavolo(4));
		tavoli.add(new Tavolo(4));
		tavoli.add(new Tavolo(4));
		tavoli.add(new Tavolo(4));
	}

	public Simulazione(int timeMax, int numeroPersoneMax, int tempoConsumazioneMin, int durataConsumazioneMax,
			int tolleranzaMax, List<Tavolo> tavoli) {
		super();
		this.timeMax = timeMax;
		this.numeroPersoneMax = numeroPersoneMax;
		this.tempoConsumazioneMin = tempoConsumazioneMin;
		this.durataConsumazioneMax = durataConsumazioneMax;
		this.tolleranzaMax = tolleranzaMax;
		this.tavoli = tavoli;
		this.queue = new PriorityQueue<>();
	}

	public void run() {
		//TODO: Completare il metodo
	}

	
}
