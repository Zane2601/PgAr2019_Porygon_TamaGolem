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
	public int calcoloDanni (String tipo1, String tipo2, int difficolta) {
		int danno;
		
		if(trovaPosMatrice (tipo1,tipo2,difficolta) < 0) {
			danno = trovaPosMatrice (tipo1,tipo2,difficolta)*(-1);
		}else if (trovaPosMatrice (tipo1,tipo2,difficolta) > 0) {
			danno = trovaPosMatrice (tipo1,tipo2,difficolta);
		}else {
			danno = 0;
		}
		
		return danno;
	}
	
	// trova la posizione del valore nella matrice
	public int trovaPosMatrice (String tipo1, String tipo2, int difficolta) {
		int posTipo1 = -1;
		int posTipo2 = -1;
		Equilibrio matrice = new Equilibrio(difficolta);
		
		
		for (int i = 0; i < difficolta; i++) {
			if (Equilibrio.tipo[i].equals(tipo1)) {
				posTipo1 = i;
			}
			if (Equilibrio.tipo[i].equals(tipo2)) {
				posTipo2 = i;
			}
		}
		
		return matrice.creaEquilibrio()[posTipo1][posTipo2];
	}
	
	// serve per decidere quale TamaGolem attaccherà o subirà un attacco
	public boolean chiAttacca (String tipo1, String tipo2, int difficolta) {
		
		if (trovaPosMatrice(tipo1, tipo2, difficolta)<0) {
			return true;
		}else{
			return false;
		}
		
		
	}
	
	
	
	
	
	
	
	
	

}
