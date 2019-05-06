package it.unibs.fp.tamagolem;
import java.lang.*;
import java.util.ArrayList;

import it.unibs.fp.mylib.*;


public class Menu {
	Equilibrio e = new Equilibrio(0);
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
	public void mostraMenuIniziale(Combattente comb1, Combattente comb2) {                      
        int scelta;
        MyMenu menu = new MyMenu(TITOLO_MENU, VOCI_MENU_INIZIALE);
       
        do {
   
            scelta = menu.scegli();
            switch (scelta) {
            case 1:
            	mostraMenuSecondario(comb1, comb2);
                break;
            }
           
        } while (scelta != 0);
    }
	
	
	public void mostraMenuSecondario(Combattente comb1, Combattente comb2) {
		int scelta2;
		MyMenu menu2 = new MyMenu(TITOLO_MENU_SECONDARIO, VOCI_MENU_SECONDARIO);
		int[][] matriceEquilibrio;
		do {
			scelta2 = menu2.scegli();
			switch(scelta2) {
			case 1:
				System.out.println("Giocherai con 5 elementi e 3 pietre assegnabili ai tuoi TamaGolem");
				e.setN(5);
				e.creaScortaComune();
				matriceEquilibrio = e.creaEquilibrio();
				//e.stampaMatrice(matriceEquilibrio);
				//e.stampaEquilibrioMondo(matriceEquilibrio, 5);
				mostraMenuCombattimento(comb1, comb2);
				
				break;
			case 2:
				System.out.println("Giocherai con 8 elementi e 4 pietre assegnabili ai tuoi TamaGolem");
				e.setN(8);
				e.creaScortaComune();
				matriceEquilibrio = e.creaEquilibrio();
				//e.stampaMatrice(matriceEquilibrio);
				mostraMenuCombattimento(comb1, comb2);
				
				break;
			case 3:
				System.out.println("Giocherai con 10 elementi e 5 pietre assegnabili ai tuoi TamaGolem");
				e.setN(10);
				e.creaScortaComune();
				matriceEquilibrio = e.creaEquilibrio();
				//e.stampaMatrice(matriceEquilibrio);
				mostraMenuCombattimento(comb1, comb2);
				
				break;
			}
		} while (scelta2 !=0);
		
	}
	
	public void mostraMenuCombattimento(Combattente comb1, Combattente comb2) {
		int scelta3;
		MyMenu menu3 = new MyMenu(TITOLO_MENU_COMBATTIMENTO, VOCI_MENU_COMBATTIMENTO);
		do {
			scelta3=menu3.scegli();
			switch(scelta3) {
			case 1:
				
				break;
			
			}
			
				
			
		} while (scelta3!=0);
		mostraMenuIniziale(comb1, comb2);
	}
}
