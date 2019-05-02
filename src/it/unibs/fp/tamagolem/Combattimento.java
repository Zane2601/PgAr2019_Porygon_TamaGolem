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
		int posTipo1 = -1;
		int posTipo2 = -1;
		int danno;
		Equilibrio matrice = new Equilibrio(difficolta);
		
		
		for (int i = 0; i < difficolta; i++) {
			if (Equilibrio.tipo[i].equals(tipo1)) {
				posTipo1 = i;
			}
			if (Equilibrio.tipo[i].equals(tipo2)) {
				posTipo2 = i;
			}
		}
		
		
		if(matrice.creaEquilibrio()[posTipo1][posTipo2] < 0) {
			danno = matrice.creaEquilibrio()[posTipo1][posTipo2]*(-1);
		}else {
			danno = matrice.creaEquilibrio()[posTipo1][posTipo2];
		}
		if (matrice.creaEquilibrio()[posTipo1][posTipo2]==0) {
			danno = 0;
		}
		
		return danno;
	}
	
	

}
