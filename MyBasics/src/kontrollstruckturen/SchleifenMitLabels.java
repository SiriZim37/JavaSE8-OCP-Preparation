package kontrollstruckturen;

public class SchleifenMitLabels {

	public static void main(String[] args) {
		
		System.out.println("*** Bsp. 1");
		for( int i=0; i<3; i++ ) {
			System.out.println("i = " + i);
			
			for( int j=0; j<3; j++ ) {
				System.out.println(" j = " + j);
				break; 	// beendet die direkt umschließende Schleife
			}
		}
		
		System.out.println("*** Bsp. 2");
		tom:
		for( int i=0; i<3; i++ ) {
			System.out.println("i = " + i);
			
			jerry:
			for( int j=0; j<3; j++ ) {
				System.out.println(" j = " + j);
				break tom; 	// beendet die Schleife tom,
							// dafür wird natürlich auch jerry beendet
			}
		}
		
		System.out.println("*** Bsp. 3");
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				if(j>1)
					continue; // beendet den Durchlauf der umschließenden Schleifen
				System.out.println(" j = " + j);
			}
			System.out.println("i = " + i);
		}
		
		System.out.println("*** Bsp. 4");
		tom:
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				if(j>1)
					continue tom; // beendet den Durchlauf der Schleife tom,
								  // dafür wird natürlich auch die innere 
								  // Schleife sofort beendet
				System.out.println(" j = " + j);
			}
			System.out.println("i = " + i);
		}
		
	}

}
