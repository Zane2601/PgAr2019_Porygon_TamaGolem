package it.unibs.fp.tamagolem;
import java.util.Random;
public class Equilibrio {
	
	
	private int n;    //numero di elementi
	private int p;    //numero di pietre per golem 
	private int g;    //numero di golem
	private int s;    //numero pietre nella sacca comune
	
	
	public Equilibrio(int _n/*, int _p, int _g, int _s*/) {
		this.n = _n;
		//this.p = _p;
		//this.g = _g;
		//this.s = _s;
	}
	
	public int getN() {
		return n;
	}

	public int getP() {
		return p;
	}

	public int getG() {
		return g;
	}

	public int getS() {
		return s;
	}
	
	public void setN(int n) {
		this.n = n;
	}

	public void setP(int p) {
		this.p = p;
	}

	public void setG(int g) {
		this.g = g;
	}

	public void setS(int s) {
		this.s = s;
	}
	
	//viene definito il metodo per la creazione della matrice dell'equilibrio 
	public int[][] creaEquilibrio() {
	//setP=[(n+1)/3]+1;
	//setG=[(n-1)*(n-2)/(2*p)];
	//setS=[(2*g*p)/n]*n;
	
	int [][] mat=new int[n][n];
	Random random= new Random();
	for(int i=0; i<n; i++) {
		//la variabile somma memorizza la somma dei valori generati sulla stessa linea
			int somma=0;
			for(int j=0; j<n; j++) {
				//se il numero della riga è uguale al numero della colonna (elemento uguale), l'interazione è nulla
				if (i==j) mat[i][j] = 0;
				else {
					//l'ultimo numero della riga serve a bilanciare, in modo che la somma totale sia 0
					if (j==(n-1)) mat[i][j]=-somma;
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
	return mat;
   }
	
	public void stampaMatrice(int[][] matrice) {
		//stampa della matrice
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(matrice[i][j] + "\t");
			}
			System.out.println("");
		}
	}


	
	
	//stampa equilibri del mondo
	public static void stampaEquilibrioMondo (int mat[][], int NUMERO) {
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