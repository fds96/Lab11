package it.polito.tdp.model;

import java.util.*;

public class Simulazione {
	
	private int timeMax;
	private int numeroPersoneMax;
	private int tempoConsumazioneMin;
	private int durataConsumazioneMax;
	private float tolleranzaMax;
	private List<Tavolo> tavoli;
	private PriorityQueue<Event> queue;
	private int numeroTotaleClienti;
	private int numeroClientiSoddisfatti;
	private int numeroClientiInsoddisfatti;

	public int getNumeroTotaleClienti() {
		return numeroTotaleClienti;
	}

	public int getNumeroClientiSoddisfatti() {
		return numeroClientiSoddisfatti;
	}

	public int getNumeroClientiInsoddisfatti() {
		return numeroClientiInsoddisfatti;
	}

	public Simulazione() {
		this.timeMax = 10;
		this.numeroPersoneMax = 10;
		this.tempoConsumazioneMin = 60;
		this.durataConsumazioneMax = 60;
		this.tolleranzaMax =  (float) 0.9;
		this.queue = new PriorityQueue<>();
		this.inizializzaTavoli();
		this.numeroTotaleClienti = 0;
		this.numeroClientiSoddisfatti = 0;
		this. numeroClientiInsoddisfatti = 0;
	}

	private void inizializzaTavoli() {
		tavoli= new LinkedList<>();
		tavoli.add(new Tavolo(10,1));
		tavoli.add(new Tavolo(10,2));
		tavoli.add(new Tavolo(8,3));
		tavoli.add(new Tavolo(8,4));
		tavoli.add(new Tavolo(8,5));
		tavoli.add(new Tavolo(8,6));
		tavoli.add(new Tavolo(6,7));
		tavoli.add(new Tavolo(6,8));
		tavoli.add(new Tavolo(6,9));
		tavoli.add(new Tavolo(6,10));
		tavoli.add(new Tavolo(4,11));
		tavoli.add(new Tavolo(4,12));
		tavoli.add(new Tavolo(4,13));
		tavoli.add(new Tavolo(4,14));
		tavoli.add(new Tavolo(4,15));
	}

	public Simulazione(int timeMax, int numeroPersoneMax, int tempoConsumazioneMin, int durataConsumazioneMax,
			float tolleranzaMax) {
		super();
		this.timeMax = timeMax;
		this.numeroPersoneMax = numeroPersoneMax;
		this.tempoConsumazioneMin = tempoConsumazioneMin;
		this.durataConsumazioneMax = durataConsumazioneMax;
		this.tolleranzaMax = tolleranzaMax;
		this.queue = new PriorityQueue<>();
		this.numeroTotaleClienti = 0;
		this.numeroClientiSoddisfatti = 0;
		this. numeroClientiInsoddisfatti = 0;
		this.inizializzaTavoli();
	}

	public void init() {
		int tempoInizio=0;
		for(int i=0; i<2000;i++) {
			int tempoArrivo = 1 + (int)(Math.floor(Math.random()*this.timeMax));
			int numeroPersone = 1 + (int)(Math.floor(Math.random()*this.numeroPersoneMax));
			int durata = this.tempoConsumazioneMin + (int)(Math.floor(Math.random()*(this.durataConsumazioneMax+1)));
			float tolleranza = (float)(Math.random()*this.tolleranzaMax);
			tempoInizio+=tempoArrivo;
			this.numeroTotaleClienti+=numeroPersone;
			queue.add(new Event(EventType.ARRIVO_GRUPPO_CLIENTI, tempoInizio, numeroPersone, durata, tolleranza));
		}
	}
	
	public void run() {
		Event e;
		while((e = queue.poll())!=null) {
			this.processEvent(e);
		}
//		
//		System.out.format("Numero totale clienti: %d \nNumero clienti soddisfatti: %d \nNumero clienti insoddisfatti %d \n",
//				this.numeroTotaleClienti, this.numeroClientiSoddisfatti, this.numeroClientiInsoddisfatti);
	}

	private void processEvent(Event e) {
		switch(e.getTipo()) {
		case ARRIVO_GRUPPO_CLIENTI:
			boolean fine = false; //Flag per affermare se le persone si sono accomodate o bisogna cercare un'altra soluzione
			if(!fine) { //Ciclo tra i tavoli per vedere se c'è un tavolo libero per fali accomodare. Ordini i tavoli per numero di posti in modo da farli accomodare nel tavolo più piccolo possibile;
				Collections.sort(this.tavoli);
				for(Tavolo tavolo : this.tavoli) {
					if((!tavolo.isOccupato()) && e.getNumeroPersone()>=(0.5*tavolo.getPosti())) {
						tavolo.setOccupato(true);
						this.numeroClientiSoddisfatti+=e.getNumeroPersone();
						int tempoUscita = e.getTempoArrivo()+e.getDurata();
						e.setTavolo(tavolo);
						Event e2 = new Event(EventType.USCITA_GRUPPO_CLIENTI, tempoUscita, e.getNumeroPersone(), e.getDurata(), e.getTolleranza());
						queue.add(e2);
						e2.setTavolo(tavolo);
						fine=true;
						break;
					}
				}
			}
			
			if(!fine) { //Se non si sono accomodati ai tavoli, cerco di farli accomodare al bancone
				float tolleranzaRandom = (float)(Math.random()); //Se questo numero casuale è maggiore o uguale della tolleranza si accomodano.
				
				if(tolleranzaRandom<=e.getTolleranza()) { // si accomodano
					this.numeroClientiSoddisfatti+=e.getNumeroPersone();
					int tempoUscita = e.getTempoArrivo()+e.getDurata();
					queue.add(new Event(EventType.USCITA_GRUPPO_CLIENTI, tempoUscita, e.getNumeroPersone(), e.getDurata(), e.getTolleranza()));
					fine = true;
				}
				
				else { //non si accomodano
					this.numeroClientiInsoddisfatti+=e.getNumeroPersone();
					queue.add(new Event(EventType.USCITA_GRUPPO_CLIENTI, e.getTempoArrivo(), e.getNumeroPersone(), e.getDurata(), e.getTolleranza()));
					fine = true;
				}
			}
			
			if(!fine)
				System.err.println("Qualcosa è andato storto nell' arrivo gruppo clienti!");
			
			break;
			
			
			
		case USCITA_GRUPPO_CLIENTI: //Se i clienti erano al tavolo lo libero.
			
			if(e.getTavolo()!=null) {
				for(Tavolo tavolo : this.tavoli) {
					if(e.getTavolo().equals(tavolo))
						tavolo.setOccupato(false);
					break;
				}
			}
			break;
		}
			
	}

	
}
