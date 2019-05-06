package it.unibs.fp.tamagolem;

import java.util.ArrayList;

public class Combattimento {
	
	
	public void aggiungiPietre() {
		TamaGolem g = new TamaGolem(0, null);
		g.getListaPietre().add(p);
	}
	
	
	/*
	public void faseLancio() {
		do {
			
		}while("vita golem"!=0)
	}
	*/
	
	// vengono passati i tipi delle pietre e trova nella matrice il danno da applicare
	public int calcoloDanni (String tipo1, String tipo2, int difficolta, int [][]matrice) {
		int danno;
		
		if(trovaPosMatrice (tipo1,tipo2,difficolta,matrice) < 0) {
			danno = trovaPosMatrice (tipo1,tipo2,difficolta,matrice)*(-1);
		}else if (trovaPosMatrice (tipo1,tipo2,difficolta,matrice) > 0) {
			danno = trovaPosMatrice (tipo1,tipo2,difficolta,matrice);
		}else {
			danno = 0;
		}
		
		return danno;
	}
	
	// trova la posizione del valore nella matrice
	public int trovaPosMatrice (String tipo1, String tipo2, int difficolta,int [][]matrice) {
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
	
	public String lancioPietre (int numPietre, Combattente c1, Combattente c2, int numElementi, int [][] matrice, int vitaTama) {
		
		
		do {
			int danno;
			int i, numTama1, numTama2;
			
			
			for (i = 0; i < numPietre; i++) {
				danno = calcoloDanni(c1.getSquadra().get(numTama1).getListaPietre().get(i), c2.getSquadra().get(numTama2).getListaPietre().get(i), numElementi, matrice);
				
				
				if (chiAttacca(c1.getSquadra().get(numTama1).getListaPietre().get(i), c2.getSquadra().get(numTama2).getListaPietre().get(i), numElementi, matrice)) {
					c1.getSquadra().get(numTama1).getVita() = c1.getSquadra().get(numTama1).getVita() - danno;
				}
				
				if (i==numElementi) {
					i=0;
				}
				if (vitaTama<0) break;
			}
			
			
			
		} while (vitaTama>0);
		
		
		
	}
	
	
	

}
