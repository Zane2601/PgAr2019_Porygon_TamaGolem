package it.unibs.fp.tamagolem;
import java.util.ArrayList;
import java.util.Random;
public class Equilibrio {
	public static String [] tipo = {"aria", "acqua", "terra", "fuoco", "erba", "etere", "buio", "luce", "roccia", "elettro"};
	
	private int n;   	//numero di elementi
	private double g;	//numero di tamagolem
	private double p;	//numero di pietre per ciascun tamagolem
	private double s;	//numero di pietre nella scorta comune

	
	
	
	public Equilibrio(int _n, int _p, int _g, int _s) {
		this.n = _n;
		this.p = _p;
		this.g = _g;
		this.s = _s;
	}
	
	public Equilibrio() {
		
	}
	
	
	public int getN() {
		return n;
	}

	public double getG() {
		return g;
	}


	public double getP() {
		return p;
	}


	public double getS() {
		return s;
	}


	public void setG(double g) {
		this.g = g;
	}


	public void setP(double p) {
		this.p = p;
	}


	public void setS(double s) {
		this.s = s;
	}

	
	public void setN(int n) {
		this.n = n;
	}

	
	
	//viene definito il metodo per la creazione della matrice dell'equilibrio 
	public int[][] creaEquilibrio(int n) {
	
	
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
						if (i<j) {
							mat[i][j] = random.nextInt(100)-49;
							do {
								mat[i][j] = random.nextInt(100)-49;
							}
							while (mat[i][j]==0);                      // evito di avere 0 fuori dalla diagonale principale
							
						}
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
	public void stampaEquilibrioMondo (int[][] mat, int n) {
	    

		
		for (int i = 0; i < n; i++) {
			System.out.print("\t " + tipo[i]);
		}
		
		System.out.println("\n");
		
		
		for(int i=0; i<n; i++) {
			System.out.print(tipo[i] + "\t ");
			for(int j=0; j<n; j++) {
				System.out.print(mat[i][j]+"\t");
			}
			
			System.out.print("\n");
			
		}
	}
	
	
	/**
	 * @param listaElementiConCuiGiocare, lista scelta dai giocatori
	 * @return scorta generata
	 */
	public ArrayList<String> creaScortaComune (double s, int n) {
		ArrayList<String> scorta = new ArrayList<String>();
		double SdivisoN = (Math.ceil(s/n));
		//vengono generati i valori di gioco, secondo le dinamiche (vengono mantenuti double, perché sennò alcuni sono = 0
		

		//scorro l'arraylist degli elementi
		for (int i = 0; i < n; i++) {
			//aggiungo un elemento alla scorta, tante quante sono le volte che un elemento deve stare nella scorta
			for (int j = 0; j < SdivisoN; j++) {
				scorta.add(tipo[i]);
				
			}
		}
		
		return scorta;
	}
	
	//stampa la scorta in modo che i giocatori siano sempre aggiornati sul numero delle pietre utilizzabili
	public void stampaScorta(ArrayList<String> scorta) {
		int contatore = 1;
		int contatoreElementi = 1;
		for (int i = 0; i < scorta.size()-1; i++) {
			if (scorta.get(i).equals(scorta.get(i+1))) {
				contatore++;
			} else {
				System.out.println("["+contatoreElementi +"] " + scorta.get(i) + "\tNe restano " +contatore +"x");
				contatoreElementi++;
				contatore = 1;
			}
		}
		System.out.println("["+contatoreElementi +"] " + scorta.get(scorta.size()-1) + "\tNe restano " +contatore +"x");

	}
	
}