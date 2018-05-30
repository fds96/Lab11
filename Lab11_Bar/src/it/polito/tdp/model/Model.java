package it.polito.tdp.model;



public class Model {
	
	public Model() {
		
	}
	
	public String simula() {
		Simulazione simulazione = new Simulazione(/*Inserire i parametri della simulazione*/);
		simulazione.init();
		simulazione.run();
		String result =  
					"Numero totale clienti: " + simulazione.getNumeroTotaleClienti() + "\n" +
					"Numero clienti insoddisfatti: " + simulazione.getNumeroClientiInsoddisfatti() + "\n" +
					"Numero clienti soddisfatti: " + simulazione.getNumeroClientiSoddisfatti() + "\n";
		return result;
	}
}
