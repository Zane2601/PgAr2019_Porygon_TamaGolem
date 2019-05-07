package it.unibs.fp.tamagolem;

import java.util.ArrayList;

import it.unibs.fp.mylib.InputDati;

public class TamaGolem {
	
	private int vita;  //la vita non può essere fissa, a seconda del livello di difficolta deve cambiare
	private ArrayList<String> listaPietre;
	
	public TamaGolem(int _vita) {
		this.vita = _vita;
		listaPietre = new ArrayList<String>();
	}
	
	public int getVita() {
		return vita;
	}

	public void setVita(int vita) {
		this.vita = vita;
	}
	
	
	public void aggiungiPietra (String pietra) {
		listaPietre.add(pietra);
	}
	
	public ArrayList<String> getListaPietre () {
		return listaPietre;
	}
	
	
	
	
	public ArrayList<String> assegnaPietre(ArrayList<String> scortaInIngresso) {
		
		ArrayList<String> scortaRestante = scortaInIngresso;
		Equilibrio e = new Equilibrio();
		
		int pietra = InputDati.leggiIntero("Scrivi il numero dell'elemento della pietra che vuoi assegnare al tuo TamaGolem: ");
		listaPietre.add(scortaRestante.get(pietra-1));
		scortaRestante.remove(pietra-1);
		
		return scortaRestante;
	}

}
