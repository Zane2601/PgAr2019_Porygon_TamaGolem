package it.unibs.fp.tamagolem;

import java.util.ArrayList;

import it.unibs.fp.mylib.InputDati;

public class TamaGolemMain {

	private static final String SALUTO_INIZIALE = "Benvenuto nel mondo dei Tamagolem, dove l'equilibrio degli elementi è sempre mutevole,\n solo i più grandi guerrieri riescono ad adattarsi e a sopravvivere combattendo con i loro fedeli TamaGolem al proprio fianco ";
	private static final int NUM_PIETRE = 2;
	private static final int NUM_TAMA = 2;
	private static final int VITA = 100;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Equilibrio e = new Equilibrio(0);
		Menu m = new Menu();
		System.out.println(SALUTO_INIZIALE);
		Combattente c = new Combattente(null, null);
    	Combattente c1 = c.creaCombattente();
        Combattente c2 = c.creaCombattente();
		m.mostraMenuIniziale(c1, c2);
		*/
		
		Combattimento lotta = new Combattimento();
		
		
		System.out.println("Giocatore 1 :");
		String nome1 = InputDati.leggiStringa("Inserisci il nome del combattente1 : ");
		Combattente comb1 = new Combattente (nome1);
		
		
		System.out.println("Giocatore 2 :");
		String nome2 = InputDati.leggiStringa("Inserisci il nome del combattente1 : ");
		Combattente comb2 = new Combattente (nome2);
		
		int livello = InputDati.leggiIntero("Inserisci il livello di difficoltà:\n[1] Facile\n[2] medio\n[3] difficile\n");
		int num_elementi = 0;
		int vita = 0;
		double p = 0;
		double g = 0;
		double s = 0;
		switch (livello) {
		case 1:
			num_elementi = 5;
			vita = 100;
			break;
		case 2:
			num_elementi = 7;
			vita = 200;
			break;
		case 3:
			num_elementi = 10;
			vita = 400;
			break;
		default:
			break;
		}
		p =  Math.ceil((num_elementi+1)/3)+1;
		g =  Math.ceil((num_elementi-1)*(num_elementi-2)/(2*p));
		s =  Math.ceil((2*g*p)/num_elementi)*num_elementi;
		System.out.println("n="+num_elementi);
		System.out.println("p=" + p);
		System.out.println("g="+g);
		System.out.println("s=" + s);
		
		
		for (int i = 0; i < g; i++) {
			TamaGolem tama = new TamaGolem(vita);
			comb1.aggiungiTama(tama);
			for (int j = 0; j < p; j++) {
				System.out.println("TamaGolem n°"+(i+1));
				String pietra = InputDati.leggiStringa("Inserisci la pietra : ");
				tama.aggiungiPietra(pietra);
			}
		}
		System.out.println("SQUADRA COMBATTENTE 1 :");
		for (int i = 0; i < comb1.getSquadra().size(); i++) {
			System.out.println("Il TamaGolem n°"+(i+1)+" ha le seguenti pietre");
			for (int j = 0; j < comb1.getSquadra().get(i).getListaPietre().size(); j++) {
				System.out.println(comb1.getSquadra().get(i).getListaPietre().get(j));
			}
		}
		
		for (int i = 0; i < g; i++) {
			TamaGolem tama = new TamaGolem(vita);
			comb2.aggiungiTama(tama);
			for (int j = 0; j < p; j++) {
				System.out.println("TamaGolem n°"+(i+1));
				String pietra = InputDati.leggiStringa("Inserisci la pietra : ");
				tama.aggiungiPietra(pietra);
			}
		}
		System.out.println("SQUADRA COMBATTENTE 2 :");
		for (int i = 0; i < comb2.getSquadra().size(); i++) {
			System.out.println("Il TamaGolem n°"+(i+1)+" ha le seguenti pietre");
			for (int j = 0; j < comb2.getSquadra().get(i).getListaPietre().size(); j++) {
				System.out.println(comb2.getSquadra().get(i).getListaPietre().get(j));
			}
		}
		
		System.out.println("Così i primi due TamaGolem si stanno lanciando le prime due pietre :");
		System.out.println(comb1.getSquadra().get(0).getListaPietre().get(0) + " e "+comb2.getSquadra().get(0).getListaPietre().get(0));
				
  
	}//fine main

}
