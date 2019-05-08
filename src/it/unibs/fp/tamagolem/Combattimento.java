package it.unibs.fp.tamagolem;

import java.util.ArrayList;
import java.util.Collections;

import it.unibs.fp.mylib.InputDati;

public class Combattimento {
	
	private static final String MESSAGGIO_DI_ERRORE = "Le pietre da voi scelte creerebbero una distorsione nell'equilibrio, per questo l'ordine verrà randomizzato da forze superiori";
	
	Equilibrio e = new Equilibrio();
	
	
	public void aggiungiPietre(Combattente c, ArrayList<String> scorta, double numPietre) {
		for (int i = 0; i <numPietre; i++) {
			String pietra;
			e.stampaScorta(scorta);
			System.out.println("Turno di "+c.getNome());
		do{
			pietra=InputDati.leggiStringa("Inserisci pietra:");
			if(!scorta.contains(pietra)) System.out.println("Non esiste questo elemento");
		}while(!scorta.contains(pietra)) ;
		c.getSquadra().get(0).getListaPietre().add(pietra);
		scorta.remove(pietra);
		
		//e.stampaScorta(scorta);
		
		}
	}
	
	public void controllaListaPietre(Combattente c1, Combattente c2) {
		while(c1.getSquadra().get(0).getListaPietre().equals(c2.getSquadra().get(0).getListaPietre())) {
			System.out.println(MESSAGGIO_DI_ERRORE);
			Collections.shuffle(c2.getSquadra().get(0).getListaPietre());
			System.out.println(""+c2.getSquadra().get(0).getListaPietre());
		}
	}
	
	
	
	// vengono passati i tipi delle pietre e trova nella matrice il danno da applicare
	public int calcoloDanni (String tipo1, String tipo2, int difficolta, int [][]matrice) {
		int danno;
		
		if(trovaPosMatrice (tipo1,tipo2,difficolta, matrice) < 0) {
			danno = trovaPosMatrice (tipo1,tipo2,difficolta,matrice)*(-1);
		}else if (trovaPosMatrice (tipo1,tipo2,difficolta, matrice) > 0) {
			danno = trovaPosMatrice (tipo1,tipo2,difficolta,  matrice);
		}else {
			danno = 0;
		}
		
		return danno;
	}
	
	// trova la posizione del valore nella matrice
	public int trovaPosMatrice (String tipo1, String tipo2, int difficolta, int [][]matrice) {
		int posTipo1 = -1;
		int posTipo2 = -1;
		
		
		
		for (int i = 0; i < difficolta; i++) {
			if (Equilibrio.tipo[i].equals(tipo1)) {
				posTipo1 = i;
			}
			if (Equilibrio.tipo[i].equals(tipo2)) {
				posTipo2 = i;
			}
		}
		
		return matrice[posTipo1][posTipo2];
	}
	
	// serve per decidere quale TamaGolem attaccherà o subirà un attacco
	public boolean chiAttacca (String tipo1, String tipo2, int difficolta,int [][]matrice) {
		
		if (trovaPosMatrice(tipo1, tipo2, difficolta,matrice)<0) {
			return true;
		}else{
			return false;
		}
		
		
	}
	
	//lancio pietre
	
	public int lancioPietre (Combattente comb1, Combattente comb2, int[][] matriceEquilibrio, ArrayList<String> scorta, double numPietre, int numEl,double numTama) {
		
		int g1 = 0;
		int g2 = 0;
		
		int vitaTama1 = comb1.getSquadra().get(g1).getVita();
		int vitaTama2 = comb2.getSquadra().get(g2).getVita();
		
		do {
			do {
				int danno;
				int i;
				
				for (i = 0; i < numPietre; i++) {
					
					danno = calcoloDanni(comb1.getSquadra().get(g1).getListaPietre().get(i), comb2.getSquadra().get(g2).getListaPietre().get(i),numEl, matriceEquilibrio);
					if (chiAttacca(comb1.getSquadra().get(g1).getListaPietre().get(i), comb2.getSquadra().get(g2).getListaPietre().get(i), numEl, matriceEquilibrio) == true) {
						vitaTama1 -= danno;
						System.out.println("Vengono scagliate la pietra "+comb1.getSquadra().get(g1).getListaPietre().get(i)+" e la pietra "+comb2.getSquadra().get(g2).getListaPietre().get(i));
						System.out.println("Il tamagolem di " +comb1.getNome()+ " subisce un danno di "+danno);
						if (vitaTama1 <= 0) {
							
							System.out.println("Il tamagolem di " +comb1.getNome()+ "è morto");
							g1++;
							if(g1 == numTama) break;
							else {
							vitaTama1 = comb1.getSquadra().get(g1).getVita();
							
							for (int j = 0; j < numPietre; j++) {
								String pietra;
								e.stampaScorta(scorta);
								System.out.println("Turno di "+comb1.getNome());
									do{
										pietra=InputDati.leggiStringa("Inserisci pietra:");
										if(!scorta.contains(pietra)) System.out.println("Non esiste questo elemento");
									}while(!scorta.contains(pietra)) ;
									comb1.getSquadra().get(g1).getListaPietre().add(pietra);
									scorta.remove(pietra);
							}
							}
						
					} 
					}else {
						vitaTama2 -= danno;
						System.out.println("Vengono scagliate la pietra "+comb1.getSquadra().get(g1).getListaPietre().get(i)+" e la pietra "+comb2.getSquadra().get(g2).getListaPietre().get(i));

						System.out.println("Il tamagolem di " +comb2.getNome()+ " subisce un danno di "+danno);
						if(vitaTama2<=0) {
							System.out.println("Il tamagolem di " +comb2.getNome()+ "è morto");
							g2++;
							if(g2==numTama) break;
							else {
							vitaTama2=comb2.getSquadra().get(g2).getVita();
							for (int j = 0; j < numPietre; j++) {
								String pietra;
								System.out.println("Turno di "+comb2.getNome());
								e.stampaScorta(scorta);
								do {
									pietra=InputDati.leggiStringa("Inserisci pietra:");
									if(!scorta.contains(pietra)) System.out.println("Non esiste questo elemento");
								}while(!scorta.contains(pietra)) ;
								comb2.getSquadra().get(g2).getListaPietre().add(pietra);
								scorta.remove(pietra);
								if (j==numPietre) {
									j=0;
								}
							}
							}	
					}
					}
					if (i==numPietre) {
						i=0;
					}
					
				}
				
			} while (vitaTama1>0 && vitaTama2>0);
			
			} while (g1 == numTama || g2 == numTama);
		
		if (g1 == e.getG())	return 2;
		else return 1;
		}
	
	
	public int lancioPietre2 (Combattente comb1, Combattente comb2, int[][] matriceEquilibrio, ArrayList<String> scorta, double numPietre, int numEl,double numTama) {
		e.stampaEquilibrioMondo(matriceEquilibrio, numEl);
		int g1 = 0;
		int g2 = 0;
		
		int vitaTama1 = comb1.getSquadra().get(g1).getVita();
		int vitaTama2 = comb2.getSquadra().get(g2).getVita();

		int avanzamento = 0;
		
		do {
			if (vitaTama1 > 0) {
				if (vitaTama2 > 0) {
					do {
						avanzamento = InputDati.leggiIntero("1 per combattere: ");
						if (avanzamento == 1) {
							int danno;
							int i;
							
							for (i = 0; i < numPietre; i++) {
								
								danno = calcoloDanni(comb1.getSquadra().get(g1).getListaPietre().get(i), comb2.getSquadra().get(g2).getListaPietre().get(i),numEl, matriceEquilibrio);
								if (chiAttacca(comb1.getSquadra().get(g1).getListaPietre().get(i), comb2.getSquadra().get(g2).getListaPietre().get(i), numEl, matriceEquilibrio) == true) {
									vitaTama1 -= danno;
									System.out.println("Il tamagolem di " +comb1.getNome()+ " subisce un danno di "+danno);
								}else {
									vitaTama2 -= danno;
									System.out.println("Il tamagolem di " +comb2.getNome()+ " subisce un danno di "+danno);
								}
								if (vitaTama1<=0 || vitaTama2<=0) break;
								
								if (i==numPietre-1) {
									i=-1;
								}
								avanzamento = InputDati.leggiIntero("1 se vuoi combattere, 0 altrimenti: ");	
							}
						}
						avanzamento = 0;
					} while (avanzamento != 0);
				} else {
					g2++;
					vitaTama2 = comb2.getSquadra().get(g2).getVita();
					aggiungiPietre(comb2, scorta, numPietre);
				}
			}
			else {
				g1++;
				vitaTama1 = comb1.getSquadra().get(g1).getVita();
				aggiungiPietre(comb1, scorta, numPietre);
			}
		} while (g1 < numTama || g2 < numTama); //ultimo while
		
		
		
		if (g1 == e.getG())	return 2;
		else return 1;
		}
	
	
	
	}
