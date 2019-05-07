package it.unibs.fp.tamagolem;

import java.util.ArrayList;

import it.unibs.fp.mylib.InputDati;

public class Combattente {
	private String nome;
	private ArrayList<TamaGolem> squadra;
	
	
	public Combattente(String _nome) {
		this.nome = _nome;
		squadra = new ArrayList<TamaGolem>();
		
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
	
	
	
	/*
	public  Combattente creaCombattente() {
        String nome = InputDati.leggiStringa("Inserisci il nome del combattente: ");
        ArrayList<TamaGolem> squadra = new ArrayList<TamaGolem>();
        Combattente combattente = new Combattente(nome, squadra);
        return combattente;
	}
	*/

}
