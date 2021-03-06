package it.unibs.fp.tamagolem;

import java.util.ArrayList;
import java.util.Collections;

import it.unibs.fp.mylib.InputDati;

public class Combattimento {
	
	private static final String INEFFICACE = "\nL'attacco non ha molto effetto";

	private static final String MORTALE = "\nL'attacco è mortale";

	private static final String SUPEREFFICACE = "\nL'attacco è Superefficace";

	private static final String AVANZAMENTO_COMBATTIMENTO = "\n\nPremi 1 per avanzare nel combattimento: ";

	private static final String MESSAGGIO_DI_ERRORE = "Le pietre da voi scelte creerebbero una distorsione nell'equilibrio, per questo l'ordine verrà randomizzato da forze superiori";
	
	Equilibrio e = new Equilibrio();
	
	//metodo per aggiungere le pietre alla lista dei TamaGolem
	public void aggiungiPietre(Combattente c, ArrayList<String> scorta, double numPietre, int indiceTama, double totaleTama) {
		
		int tamaRimasti=(int)totaleTama-indiceTama;
		
		for (int j = 0; j < numPietre; j++) {
			String pietra;
			System.out.println("\nTurno di "+c.getNome());
			System.out.println("Ti rimangono "+tamaRimasti+" TamaGolem\n");
			e.stampaScorta(scorta);
			
				do{
					pietra=InputDati.leggiStringa("\nInserisci pietra del potere: ");
					System.out.println("\n");
					if(!scorta.contains(pietra)) System.out.println("\nNon esiste questo elemento");
				}while(!scorta.contains(pietra)) ;
				c.getSquadra().get(indiceTama).getListaPietre().add(pietra);
				scorta.remove(pietra);
			}
		}
	
	//controlla che i due giocatori non inseriscano una sequenza di pietre identica creando così un ciclo infinito
	public void controllaListaPietre(Combattente c1, Combattente c2, int indice1, int indice2) {
		while(c1.getSquadra().get(indice1).getListaPietre().equals(c2.getSquadra().get(indice2).getListaPietre())) {
			System.out.println(MESSAGGIO_DI_ERRORE);
			Collections.shuffle(c2.getSquadra().get(indice2).getListaPietre());
			System.out.println(""+c2.getSquadra().get(indice2).getListaPietre());
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
	
	//lancio pietre e calcolo del danno, richiamo ai primi due metodi della classe per riassegnare le pietre in caso di morte di un tamagolem 
	
	public int lancioPietre (Combattente comb1, Combattente comb2, int[][] matriceEquilibrio, ArrayList<String> scorta, double numPietre, int numEl,double numTama) {
		
		int g1 = 0;
		int g2 = 0;
		
		int vitaTama1 = comb1.getSquadra().get(g1).getVita();
		int vitaTama2 = comb2.getSquadra().get(g2).getVita();
		
		int avanzamento;
		do {
			avanzamento = InputDati.leggiIntero(AVANZAMENTO_COMBATTIMENTO);
			
			do {
				if (avanzamento == 1) {
				int danno;
				int i;
				
				for (i = 0; i < numPietre; i++) {
					
					danno = calcoloDanni(comb1.getSquadra().get(g1).getListaPietre().get(i), comb2.getSquadra().get(g2).getListaPietre().get(i),numEl, matriceEquilibrio);
					if (chiAttacca(comb1.getSquadra().get(g1).getListaPietre().get(i), comb2.getSquadra().get(g2).getListaPietre().get(i), numEl, matriceEquilibrio) == true) {
						if(danno>80) System.out.println(SUPEREFFICACE);
						else if(danno>vitaTama1) System.out.println(MORTALE);
						else if(danno<20) System.out.println(INEFFICACE);
						vitaTama1 -= danno;
						
						System.out.println("Vengono scagliate la pietra "+comb1.getSquadra().get(g1).getListaPietre().get(i)+" e la pietra "+comb2.getSquadra().get(g2).getListaPietre().get(i));
						System.out.println("\nIl tamagolem di " +comb1.getNome()+ " subisce un danno di "+danno);
						 
						
					if (vitaTama1 <= 0) {
							
							System.out.println("\n====================> Il tamagolem di " +comb1.getNome()+ " è morto");
							g1++;
							if(g1 == numTama) return 2;
							else {
								vitaTama1 = comb1.getSquadra().get(g1).getVita();
							    aggiungiPietre(comb1, scorta, numPietre, g1,numTama);
							    controllaListaPietre(comb2, comb1, g2, g1);
									
							}
						
					} else System.out.println("\nL'energia vitale del TamaGolem di "+comb1.getNome()+ " è "+vitaTama1);
					}else {
						if(danno>80) System.out.println(SUPEREFFICACE);
						else if(danno>vitaTama2) System.out.println(MORTALE);
						else if(danno<20) System.out.println(INEFFICACE);
						vitaTama2 -= danno;
						
						System.out.println("Vengono scagliate la pietra "+comb1.getSquadra().get(g1).getListaPietre().get(i)+" e la pietra "+comb2.getSquadra().get(g2).getListaPietre().get(i));

						System.out.println("\nIl tamagolem di " +comb2.getNome()+ " subisce un danno di "+danno);
						
						if(vitaTama2<=0) {
							System.out.println("\n====================> Il tamagolem di " +comb2.getNome()+ " è morto");
							g2++;
							if(g2==numTama) return 1;
							else {
							vitaTama2=comb2.getSquadra().get(g2).getVita();
							aggiungiPietre(comb2, scorta, numPietre, g2,numTama);
							controllaListaPietre(comb1, comb2, g1, g2);

							
							}	
						}else System.out.println("\nL'energia vitale del TamaGolem di "+comb2.getNome()+ " è "+vitaTama2);
					}
					if (i==numPietre) {
						i=0;
					}
					avanzamento = InputDati.leggiIntero(AVANZAMENTO_COMBATTIMENTO);	

					}
				}
			} while (vitaTama1>0 && vitaTama2>0);
			
			} while (g1 == numTama || g2 == numTama);
		
			return 0;
		}
	
	
	
	
	
	}
