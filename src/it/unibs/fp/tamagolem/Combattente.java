package it.unibs.fp.tamagolem;

import java.util.ArrayList;

import it.unibs.fp.mylib.InputDati;


public class Combattente {
	private String nome;
	private ArrayList<TamaGolem> squadra= new ArrayList<TamaGolem>();
	
	
	Equilibrio e = new Equilibrio();
	
	public Combattente(String _nome, ArrayList<TamaGolem> _squadra) {
		this.nome = _nome;
		this.squadra = _squadra;
	}
	
	public Combattente() {
		
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public void aggiungiTama (TamaGolem tama) {
		squadra.add(tama);
	}
	
	public ArrayList<TamaGolem> getSquadra () {
		return squadra;
	}
	
	public  Combattente creaCombattente(double golem, int vita) {
        String nome = InputDati.leggiStringa("Inserisci il nome del combattente: ");
        ArrayList<TamaGolem> squadra = new ArrayList<TamaGolem>();
        TamaGolem t = new TamaGolem();
        
        for(int i=0; i<golem; i++) {
        	TamaGolem tama = t.creaTamaGolem(vita);
        	squadra.add(tama);
        	
        }
        
        Combattente combattente = new Combattente(nome, squadra);
        return combattente;
	}
	
	

}
