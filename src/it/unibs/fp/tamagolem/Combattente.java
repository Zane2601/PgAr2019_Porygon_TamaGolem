package it.unibs.fp.tamagolem;

import java.util.ArrayList;

import it.unibs.fp.mylib.InputDati;

public class Combattente {
	private String nome;
	private ArrayList<TamaGolem> squadra = new ArrayList<TamaGolem>();
	
	
	public Combattente(String _nome, ArrayList<TamaGolem> _squadra) {
		this.nome = _nome;
		this.squadra = _squadra;
	}
	
	public String getNome() {
		return nome;
	}
	
	public ArrayList<TamaGolem> getSquadra(){
		return squadra;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public  Combattente creaCombattente() {
        String nome = InputDati.leggiStringa("Inserisci il nome del combattente: ");
        ArrayList<TamaGolem> squadra = new ArrayList<TamaGolem>();
        Combattente combattente = new Combattente(nome, squadra);
        return combattente;
	}

}
