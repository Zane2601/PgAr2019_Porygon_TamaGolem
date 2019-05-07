package it.unibs.fp.tamagolem;

import java.util.ArrayList;

public class Combattimento {
	
	Equilibrio e = new Equilibrio();
	
	/*public void aggiungiPietre() {
		TamaGolem g = new TamaGolem(0, null);
		g.getListaPietre().add(p);
	}*/
	
	
	
	
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
	
	public int lancioPietre (Combattente comb1, Combattente comb2, int[][] matriceEquilibrio, ArrayList<String> scorta) {
		double numPietre = e.getP();
		int g1 = 0;
		int g2 = 0;
		
		int vitaTama1 = comb1.getSquadra().get(g1).getVita();
		int vitaTama2 = comb2.getSquadra().get(g2).getVita();
		
		do {
			int danno;
			int i;
			
			for (i = 0; i < numPietre; i++) {
				
				danno = calcoloDanni(comb1.getSquadra().get(g1).getListaPietre().get(i), comb2.getSquadra().get(g2).getListaPietre().get(i), e.getN());
				if (chiAttacca(comb1.getSquadra().get(g1).getListaPietre().get(i), comb2.getSquadra().get(g2).getListaPietre().get(i), e.getN(), matriceEquilibrio)) {
					vitaTama1 -= danno;
				}else {
					vitaTama2 -= danno;
				}
				if (i==e.getN()) {
					i=0;
				}
				if (vitaTama1<0 || vitaTama2<0) break;
			}
		
		} while (vitaTama1>0 && vitaTama2>0);
		if (vitaTama1 <= 0) {
			do {
				g1++;
				for (int i = 0; i < e.getP(); i++) {
					comb1.getSquadra().get(g1).assegnaPietre(scorta);
				}
				
			} while (g1<e.getG());
			
			
		} else {
			do {
				g2++;
				for (int i = 0; i < e.getP(); i++) {
					comb2.getSquadra().get(g2).assegnaPietre(scorta);
				}
			} while (g2<e.getG());
		}
		
		return 0;
	}
	
	
	

}
