package it.unibs.fp.tamagolem;

import java.util.ArrayList;

import it.unibs.fp.mylib.InputDati;

public class Combattimento {
	
	Equilibrio e = new Equilibrio();
	
	
	
	
	
	
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
			//do {
				int danno;
				int i;
				
				for (i = 0; i < numPietre; i++) {
					
					danno = calcoloDanni(comb1.getSquadra().get(g1).getListaPietre().get(i), comb2.getSquadra().get(g2).getListaPietre().get(i),numEl, matriceEquilibrio);
					if (chiAttacca(comb1.getSquadra().get(g1).getListaPietre().get(i), comb2.getSquadra().get(g2).getListaPietre().get(i), numEl, matriceEquilibrio) == true) {
						vitaTama1 -= danno;
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
							}
							}	
					}
					}
					if (i==numPietre) {
						i=0;
					}
					
				}
				
			//} while (vitaTama1>0 && vitaTama2>0);
			
			} while (g1 == numTama || g2 == numTama);
		
		if (g1 == e.getG())	return 2;
		else return 1;
		}
	
	
	
	
	}
