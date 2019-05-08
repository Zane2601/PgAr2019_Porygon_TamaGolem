package it.unibs.fp.tamagolem;

import java.util.ArrayList;





public class TamaGolem {
	
	private int vita;  
	private ArrayList<String> listaPietre = new ArrayList<String>();
	Equilibrio e= new Equilibrio();
	public TamaGolem(int _vita, ArrayList<String> _listaPietre) {
		this.vita = _vita;
		this.listaPietre = _listaPietre;
	}
	
	public TamaGolem() {
		
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
	
	
	
	
    public TamaGolem creaTamaGolem(int vita) {
		
		ArrayList<String> listaPietre = new ArrayList<String>();
		
		TamaGolem tama = new TamaGolem(vita,listaPietre);
		return tama;
	}

}
