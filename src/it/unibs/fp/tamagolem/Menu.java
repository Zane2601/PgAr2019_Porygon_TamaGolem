package it.unibs.fp.tamagolem;
import java.lang.*;
import java.util.ArrayList;
import java.util.Collections;

import it.unibs.fp.mylib.*;



public class Menu {
	
	private static final String SELEZIONA_DIFFICOLTA = "Seleziona il livello di difficoltà:\n\t[1] facile\n\t[2] medio\n\t[3] difficile\n";
	private static final String SPIEGAZIONE_COMBATTIMENTO = "\nPrima di iniziare il combattimento dovrete assegnare le pietre del potere ai vostri TamaGolem,\ndovrete farlo ogni qualvolta un vostro TamaGolem morirà.\n Completa la vostra avventura potrete iniziarne un'altra totalmente nuova selezionando di nuovo questa opzione\n ";
	Equilibrio e = new Equilibrio();
	Combattente c = new Combattente();
	Combattimento C = new Combattimento();
	TamaGolem t = new TamaGolem();
	Combattimento combat = new Combattimento();
	private static final String TITOLO_MENU = "Scegli un'azione";
	private static final String [] VOCI_MENU_INIZIALE = {
            "Inizia Partita",
            
          };
	
	
	private static final String TITOLO_MENU_COMBATTIMENTO = "Qui inizia la vostra avventura";
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
            	int livello = InputDati.leggiIntero(SELEZIONA_DIFFICOLTA);
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
 				System.out.printf("\nOgni giocatore avrà %1.0f TamaGolem\n",e.getG());
			    Combattente c1 = c.creaCombattente(e.getG(), t.getVita());
			    Combattente c2 = c.creaCombattente(e.getG(), t.getVita());
				
				System.out.printf("\nGiocherai con %d elementi e %1.0f pietre assegnabili ai tuoi TamaGolem\n",e.getN(),e.getP());
				
				scortaComune = e.creaScortaComune(e.getS(), e.getN());
				

				System.out.println("La scorta comune contiene "+scortaComune.size()+" elementi");
				
				e.stampaScorta(scortaComune);
				matriceEquilibrio = e.creaEquilibrio(e.getN());
				
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            	mostraMenuCombattimento(c1, c2, scortaComune, matriceEquilibrio);
                break;
            }
           
        } while (scelta != 0);
    }
	
	
	
	
	public void mostraMenuCombattimento(Combattente c1, Combattente c2, ArrayList<String> scorta, int[][] matEquilibrio) {
		int scelta3;
		MyMenu menu3 = new MyMenu(TITOLO_MENU_COMBATTIMENTO, VOCI_MENU_COMBATTIMENTO);
		do {
			scelta3=menu3.scegli();
			switch(scelta3) {
			case 1:
				
				System.out.println(SPIEGAZIONE_COMBATTIMENTO);
				
				
				C.aggiungiPietre(c1, scorta, e.getP(), 0, e.getG());
				C.aggiungiPietre(c2, scorta, e.getP(), 0, e.getG());
				
				C.controllaListaPietre(c1, c2, 0, 0);
				
				if (combat.lancioPietre(c1, c2, matEquilibrio, scorta,e.getP(),e.getN(), e.getG()) == 1) System.out.println(c1.getNome()+" ha vinto!"); 
				else System.out.println(c2.getNome() +" ha vinto!");
				e.stampaEquilibrioMondo(matEquilibrio, e.getN());
				break;
			
			}
			System.out.println("L'equilibrio ormai è stato svelato, dovrete scegliere di nuovo la difficoltà e ripartire da zero");				 
			break;
		} while (scelta3!=0);
		
	}
}
