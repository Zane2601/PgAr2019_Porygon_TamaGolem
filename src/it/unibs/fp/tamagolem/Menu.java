package it.unibs.fp.tamagolem;
import java.lang.*;
import java.util.ArrayList;

import it.unibs.fp.mylib.*;


public class Menu {
	
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
	
	//viene mostrato il menu per iniziare una partita
	public void mostraMenuIniziale() {                      
        int scelta;
        MyMenu menu = new MyMenu(TITOLO_MENU, VOCI_MENU_INIZIALE);
       
        do {
   
            scelta = menu.scegli();
            switch (scelta) {
            case 1:
            	Combattente combattente1 = creaCombattente();
                Combattente combattente2 = creaCombattente();
                mostraMenuSecondario();
                break;
            
            
            default:
                break;
            }
           
        } while (scelta != 0);
    }
	private Combattente creaCombattente() {
        String nome = InputDati.leggiStringa("Inserisci il nome del combattente: ");
        ArrayList<TamaGolem> squadra = new ArrayList<TamaGolem>();
        Combattente combattente = new Combattente(nome, squadra);
        return combattente;
	}
	
	public void mostraMenuSecondario() {
		int scelta;
		MyMenu menu = new MyMenu(TITOLO_MENU_SECONDARIO, VOCI_MENU_SECONDARIO);
		
		do {
			scelta = menu.scegli();
			switch(scelta) {
			case 1:
				System.out.println("Giocherai con 5 elementi e 3 pietre assegnabili ai tuoi TamaGolem");
				break;
			case 2:
				System.out.println("Giocherai con 8 elementi e 4 pietre assegnabili ai tuoi TamaGolem");
				break;
			case 3:
				System.out.println("Giocherai con 10 elementi e 5 pietre assegnabili ai tuoi TamaGolem");
				break;
			}
		} while (scelta !=0);
		
	}
}
