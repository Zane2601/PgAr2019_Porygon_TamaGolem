package it.unibs.fp.tamagolem;

import java.util.ArrayList;

public class Combattimento {
	
	Equilibrio e = new Equilibrio(0);
	
	public void aggiungiPietre() {
		TamaGolem g = new TamaGolem(0, null);
		g.getListaPietre().add(p);
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
	
	public int lancioPietre (ArrayList<String> listaPietre1, ArrayList<String> listaPietre2, int numElementi, int [][] matrice, int vitaTama1, int vitaTama2) {
		double numPietre = e.getP();
		
		do {
			int danno;
			int i;
			
			
			for (i = 0; i < numPietre; i++) {
				danno = calcoloDanni(listaPietre1.get(i), listaPietre2.get(i), numElementi, matrice);
				if (chiAttacca(listaPietre1.get(i), listaPietre2.get(i), numElementi, matrice)) {
					vitaTama1 -= danno;
				}else {
					vitaTama2 -= danno;
				}
				if (i==numElementi) {
					i=0;
				}
				if (vitaTama1<0 || vitaTama2<0) break;
			}
		
		} while (vitaTama1>0 && vitaTama2>0);
		
		
		return
	}
	
	
	

}
