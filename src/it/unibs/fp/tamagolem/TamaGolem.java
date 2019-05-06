package it.unibs.fp.tamagolem;

import java.util.ArrayList;

import it.unibs.fp.mylib.InputDati;

public class TamaGolem {
	
	private int vita;  //la vita non può essere fissa, a seconda del livello di difficolta deve cambiare
	private ArrayList<String> listaPietre = new ArrayList<String>();
	
	public TamaGolem(int _vita, ArrayList<String> _listaPietre) {
		this.vita = _vita;
		this.listaPietre = _listaPietre;
	}
	
	public int getVita() {
		return vita;
	}

	public ArrayList<String> getListaPietre() {
		return listaPietre;
	}

	public void setVita(int vita) {
		this.vita = vita;
	}

	public void setListaPietre(ArrayList<String> listaPietre) {
		this.listaPietre = listaPietre;
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
