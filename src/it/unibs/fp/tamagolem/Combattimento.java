package it.unibs.fp.tamagolem;

public class Combattimento {
	
	
	public void aggiungiPietre() {
		TamaGolem g = new TamaGolem(0, null);
		g.getListaPietre().add(p);
	}
	
	public void faseLancio() {
		do {
			
		}while("vita golem"!=0)
	}
	
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
	
	
	
	
	
	
	
	
	

}
