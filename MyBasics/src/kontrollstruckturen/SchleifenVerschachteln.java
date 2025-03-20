package kontrollstruckturen;

public class SchleifenVerschachteln {

	public static void main(String[] args) {
		
		/*
		 * i = 0
		 * 0 < 2 
		 * Ausgabe: 0
		 * 
		 * 		INNERE SCHLEIFE
		 * 		j = 5
		 * 		5 > 3
		 * 		Ausgabe: 5
		 * 
		 * 		j-- (j=4)
		 * 		4 > 3
		 * 		Ausgabe: 4
		 * 
		 * 		j-- (j=3)
		 * 		3 > 3	- false: innere Schleife beenden,
		 * 						 j wird entfernt
		 * 
		 * i++ (i=1)
		 * 1 < 2
		 * Ausgabe: 1
		 * 
		 * 		INNERE SCHLEIFE
		 * 		j = 5
		 * 		5 > 3
		 * 		Ausgabe: 5
		 * 
		 * 		j-- (j=4)
		 * 		4 > 3
		 * 		Ausgabe: 4
		 * 
		 * 		j-- (j=3)
		 * 		3 > 3	- false: innere Schleife beenden,
		 * 						 j wird entfernt
		 * 
		 * i++ (i=2)
		 * 2 < 2	- false: äußere Schleife beenden,
		 * 					 i wird entfernt
		 */
		for (int i=0; i<2; i++) {
			System.out.print(i + " ");
			
			for(int j=5; j>3; j--) {
				System.out.print(j + " ");
			}
			System.out.println();
		}

	}

}
