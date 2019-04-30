package it.unibs.fp.tamagolem;
import java.lang.*;
import it.unibs.fp.mylib.MyMenu;;


public class Menu {
	
	private static final String TITOLO_MENU = "Scegli un'azione";
	private static final String [] VOCI_MENU_INIZIALE = {
            "Inizia Partita",
            "Termina"
    };
	public void mostraMenu() {
        int scelta;
        MyMenu menu = new MyMenu(TITOLO_MENU, VOCI_MENU_INIZIALE);
       
        do {
   
            scelta = menu.scegli();
            switch (scelta) {
            case 1:
                
                
                break;
            
            case 2:
            	
                
                break;
            
            default:
                break;
            }
           
        } while (scelta != 0);
    }
}
