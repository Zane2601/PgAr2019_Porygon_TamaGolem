package it.unibs.fp.tamagolem;

public class TamaGolemMain {

	private static final String SALUTO_INIZIALE = "Benvenuto nel mondo dei Tamagolem, dove l'equilibrio degli elementi è sempre mutevole,\n solo i più grandi guerrieri riescono ad adattarsi e a sopravvivere combattendo con i loro fedeli TamaGolem al proprio fianco ";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Equilibrio e = new Equilibrio();
		Menu m = new Menu();
		System.out.println(SALUTO_INIZIALE);
		e.creaMatrice();
		m.mostraMenu();
		

  
	}

}
