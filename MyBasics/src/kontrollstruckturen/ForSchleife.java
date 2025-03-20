package kontrollstruckturen;

public class ForSchleife {

	public static void main(String[] args) {
		
		int k = 0;
		System.out.println("k = " + k);
		
		k++;
		System.out.println("k = " + k);
		
		k++;
		System.out.println("k = " + k);

		/*
		 * Logik der for-Schleife
		 * 
		 * Bei dem Start der for-Schleife:
		 * 
		 * 1. Initialisierungsbereich auswerten
		 * 
		 * 2. Ausführungskriterium auswerten:
		 * 		bei false: Schleife sofort beenden
		 * 		bei true: Schleifen-Block ausführen
		 * 
		 * Bei jedem weiteren Schleifendurchlauf:
		 * 
		 * a. Inkrementierungsbereich auswerten
		 * 
		 * b. Ausführungskriterium auswerten:
		 * 		bei false: Schleife sofort beenden
		 * 		bei true: Schleifen-Block ausführen
		 */
		for(int i=0; i<3; i++) {
			System.out.println("i = " + i);
		}
		
	}

}
