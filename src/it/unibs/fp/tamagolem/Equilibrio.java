package it.unibs.fp.tamagolem;
import java.util.Random;
public class Equilibrio {
	
	private static final int NUMERO = 5;

	public void creaMatrice() {
	int [][] mat=new int[NUMERO][NUMERO];
	
	Random random= new Random();
	for(int i=0; i<NUMERO; i++) {
		int somma=0;
		for(int j=0; j<NUMERO; j++) {
<<<<<<< HEAD
			if (i<(j-1)) {
			
				mat[i][j]= random.nextInt(99)-50+1;
				if (j==(NUMERO-1)) mat[i][j]=-somma;
			    		}
			else if(i==j) mat[i][j]=0;
			else mat[i][j]=-mat[j][i];
=======
			if (i==j) mat[i][j] = 0;
			else {
				if (j==(NUMERO-1)) mat[i][j]=-somma;
				else {
				if (i<j) mat[i][j] = random.nextInt(100)-49;
				else {
					if (i>j) mat[i][j] = -mat[j][i];
					}
				}
			}
>>>>>>> c9e49902cd6e92c31effba56c59e95ff3da80c56
			somma=somma+mat[i][j];
		}
	}
	
	
	for(int i=0; i<NUMERO; i++) {
		for(int j=0; j<NUMERO; j++) {
			System.out.print(mat[i][j] + "\t");
		}
		System.out.println("");
	}

}
}