package it.unibs.fp.tamagolem;
import java.util.Random;
public class Equilibrio {
	
	//numero di elementi
	private static final int NUMERO = 10;

	//viene definito il metodo per la creazione della matrice dell'equilibrio
	public void creaMatrice() {
	int [][] mat=new int[NUMERO][NUMERO];
	
	Random random= new Random();
	for(int i=0; i<NUMERO; i++) {
		//la variabile somma memorizza la somma dei valori generati sulla stessa linea
			int somma=0;
			for(int j=0; j<NUMERO; j++) {
				//se il numero della riga è uguale al numero della colonna (elemento uguale), l'interazione è nulla
				if (i==j) mat[i][j] = 0;
				else {
					//l'ultimo numero della riga serve a bilanciare, in modo che la somma totale sia 0
					if (j==(NUMERO-1)) mat[i][j]=-somma;
					else {
						//se il numero della riga è minore di quello della colonna (matrice triangolare sup.) si genera un numero casuale
						if (i<j) mat[i][j] = random.nextInt(100)-49;
						else {
							//la matrice triangolare inf. è uguale alla sup. cambiata di segno
							if (i>j) mat[i][j] = -mat[j][i];
							}
						}
					}
				//si aumenta il valore di somma
				somma=somma+mat[i][j];
			}
		}
	
	//stampa della matrice
	for(int i=0; i<NUMERO; i++) {
		for(int j=0; j<NUMERO; j++) {
			System.out.print(mat[i][j] + "\t");
		}
		System.out.println("");
	}

	}
	
	//stampa equilibri del mondo
	public static void stampaEquilibrioMondo (int mat[][]) {
	    String [] tipo = {"aria", "acqua", "terra", "fuoco", "erba", "etere", "buio", "luce", "ghiaccio", "roccia"};

		
		for (int i = 0; i < NUMERO; i++) {
			System.out.print(tipo[i]+ "   ");
		}
		
		System.out.println("\n");
		
		
		for(int i=0; i<NUMERO; i++) {
			//System.out.print(tipo[i]+" \t ");
			for(int j=0; j<NUMERO; j++) {
				System.out.print(mat[i][j]+"\t");
			}
			System.out.print(tipo[i]+"\t");
			System.out.print("\n");
			//System.out.print(tipo[i]+"\t");
			
		}
	}
	
	
	
	
	
	
	
	
	
}