package it.unibs.fp.tamagolem;
import java.lang.*;
import java.util.ArrayList;
import java.util.Collections;

import it.unibs.fp.mylib.*;



public class Menu {
	
	private static final String SPIEGAZIONE_COMBATTIMENTO = "Prima di iniziare il combattimento dovrete assegnare le pietre del potere ai vostri TamaGolem,\ndovrete farlo ogni qualvolta un vostro TamaGolem morirà";
	Equilibrio e = new Equilibrio();
	Combattente c = new Combattente();
	Combattimento C = new Combattimento();
	TamaGolem t = new TamaGolem();
	Combattimento combat = new Combattimento();
	private static final String TITOLO_MENU = "Scegli un'azione";
	private static final String [] VOCI_MENU_INIZIALE = {
            "Inizia Partita",
            
          };
	private static final String TITOLO_MENU_SECONDARIO = "Scegli la difficoltà";
	private static final String [] VOCI_MENU_SECONDARIO = {
			"Facile",
			"Normale",
			"Difficile"
	};
	
	private static final String TITOLO_MENU_COMBATTIMENTO = "Assegna le pietre elementari al tuo tamagolem";
	private static final String [] VOCI_MENU_COMBATTIMENTO = {
		
		"Inizia il combattimento"
	};
	
	//viene mostrato il menu per iniziare una partita
	public void mostraMenuIniziale() {                      
        int scelta;
        
        
        MyMenu menu = new MyMenu(TITOLO_MENU, VOCI_MENU_INIZIALE);
       
        do {
        	int[][] matriceEquilibrio;
    		ArrayList<String> scortaComune;
    		
            scelta = menu.scegli();
            switch (scelta) {
            case 1:
            	System.out.println("\n\n");
            	int livello = InputDati.leggiIntero("Seleziona il livello di difficoltà:\n\t[1] facile\n\t[2] medio\n\t[3] difficile\n");
            	switch (livello) {
				case 1:
					e.setN(5);
					t.setVita(100);
					break;

				case 2:
					e.setN(8);
					t.setVita(200);
					break;
					
				case 3:
					e.setN(10);
					t.setVita(400);
					break;
				default:
					System.out.println("Il valore inserito non è accettato");
					break;
				}
            	
            	e.setP((int) Math.ceil((e.getN()+1)/3)+1);
 				
 				e.setG((int) Math.ceil((e.getN()-1)*(e.getN()-2)/(2*e.getP())));
 				e.setS((int) Math.ceil((2*e.getG()*e.getP())/e.getN())*e.getN());
 				System.out.println("g="+e.getG());
			    Combattente c1 = c.creaCombattente(e.getG(), t.getVita());
			    Combattente c2 = c.creaCombattente(e.getG(), t.getVita());
				
				System.out.println("Giocherai con "+e.getN() +" elementi e "+e.getP()+" pietre assegnabili ai tuoi TamaGolem");
				
				scortaComune = e.creaScortaComune(e.getS(), e.getN());
				//System.out.println("n="+e.getN());
				//System.out.println("p="+e.getP());
				//System.out.println("g="+e.getG());
				//System.out.println("s="+e.getS());

				System.out.println(scortaComune.size());
				
				e.stampaScorta(scortaComune);
				matriceEquilibrio = e.creaEquilibrio(e.getN());
				//e.stampaEquilibrioMondo(matriceEquilibrio, e.getN());
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            	mostraMenuCombattimento(c1, c2, scortaComune, matriceEquilibrio);
                break;
            }
           
        } while (scelta != 0);
    }
	
	
	
	/*
	public void mostraMenuSecondario() {
		int scelta2;
		

		
		//MyMenu menu2 = new MyMenu(TITOLO_MENU_SECONDARIO, VOCI_MENU_SECONDARIO);
		int[][] matriceEquilibrio;
		ArrayList<String> scortaComune;

		do {
			scelta2 = menu2.scegli();
			switch(scelta2) {
			case 1:
				e.setN(5);
                e.setP((int) Math.ceil((e.getN()+1)/3)+1);
				
				e.setG((int) Math.ceil((e.getN()-1)*(e.getN()-2)/(2*e.getP())));
				
				t.setVita(100);
			    
				System.out.println("g="+e.getG());
			    Combattente c1 = c.creaCombattente(e.getG(), t.getVita());
			    Combattente c2 = c.creaCombattente(e.getG(), t.getVita());
				
				System.out.println("Giocherai con "+e.getN() +" elementi e "+e.getP()+" pietre assegnabili ai tuoi TamaGolem");
								
				for (int i = 0; i < g; i++) {
					ArrayList<String> listaPietre = new ArrayList<String>();
					TamaGolem tama = new TamaGolem(100, listaPietre);
					comb1.getSquadra().add(tama);
				}
				
				scortaComune = e.creaScortaComune((int) s, n);
				e.stampaScorta(scortaComune);
				matriceEquilibrio = e.creaEquilibrio(n);
				e.stampaEquilibrioMondo(matriceEquilibrio, n);
				for (int i = 1; i < p; i++) {
					for (int j = 0; j < scortaComune.size(); j++) {
						System.out.println("["+(j+1) +"] "+scortaComune.get(j));
					}
					System.out.println("Vai "+comb1.getNome()+", tocca a te!");
					String pietra = InputDati.leggiStringa("Inserisci il numero dell'elemento che vuoi dare in pasto al TamaGolem: ");
					comb1.getSquadra().get(0).getListaPietre().add(scortaComune.get(i-1));
					System.out.println("L'elemento " +comb1.getSquadra().get(0).getListaPietre().get(i)+ " è stato assegnato al primo golem di " +comb1.getNome());
					scortaComune.remove(pietra);
					for (int j = 0; j < scortaComune.size(); j++) {
						System.out.println("["+(j+1) +"] "+scortaComune.get(j));
					}
					System.out.println("\nVai "+comb2.getNome()+", è il tuo turno!");
					pietra = InputDati.leggiStringa("Inserisci il numero dell'elemento che vuoi dare in pasto al TamaGolem: ");
					comb2.getSquadra().get(0).getListaPietre().add(scortaComune.get(i-1));
					System.out.println("L'elemento " +comb2.getSquadra().get(0).getListaPietre().get(i)+ " è stato assegnato al primo golem di " +comb2.getNome());
					scortaComune.remove(pietra);
				}
				
				
				mostraMenuCombattimento();
				
				break;
			case 2:
				System.out.println("Giocherai con 8 elementi e 4 pietre assegnabili ai tuoi TamaGolem");
				e.setN(8);
                e.setP((int) Math.ceil((e.getN()+1)/3)+1);
				
				e.setG((int) Math.ceil((e.getN()-1)*(e.getN()-2)/(2*e.getP())));
				
				t.setVita(200);
				 c = new Combattente();
				System.out.println("g="+e.getG());
				 c1 = c.creaCombattente(e.getG(), t.getVita());
				 c2 = c.creaCombattente(e.getG(), t.getVita());
				
				break;
			case 3:
				System.out.println("Giocherai con 10 elementi e 5 pietre assegnabili ai tuoi TamaGolem");
				e.setN(10);
                e.setP((int) Math.ceil((e.getN()+1)/3)+1);
				
				e.setG((int) Math.ceil((e.getN()-1)*(e.getN()-2)/(2*e.getP())));
				
				t.setVita(400);
			    c = new Combattente();
				System.out.println("g="+e.getG());
			    c1 = c.creaCombattente(e.getG(), t.getVita());
			    c2 = c.creaCombattente(e.getG(), t.getVita());
				
				break;
			}
		} while (scelta2 !=0);
		
		
	}fine menu secondario*/
	
	public void mostraMenuCombattimento(Combattente c1, Combattente c2, ArrayList<String> scorta, int[][] matEquilibrio) {
		int scelta3;
		MyMenu menu3 = new MyMenu(TITOLO_MENU_COMBATTIMENTO, VOCI_MENU_COMBATTIMENTO);
		do {
			scelta3=menu3.scegli();
			switch(scelta3) {
			case 1:
				
				System.out.println(SPIEGAZIONE_COMBATTIMENTO);
				
				C.aggiungiPietre(c1, scorta, e.getP());
				C.aggiungiPietre(c2, scorta, e.getP());
				
				C.controllaListaPietre(c1, c2);
				
				if (combat.lancioPietre(c1, c2, matEquilibrio, scorta,e.getP(),e.getN(), e.getG()) == 1) System.out.println(c1.getNome()+" ha vinto!"); 
				else System.out.println(c2.getNome() +" ha vinto!");
				e.stampaEquilibrioMondo(matEquilibrio, e.getN());
				break;
			
			}
							 
			
		} while (scelta3!=0);
		mostraMenuIniziale();
	}
}
