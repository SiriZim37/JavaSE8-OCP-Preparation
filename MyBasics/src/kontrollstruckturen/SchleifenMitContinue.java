package kontrollstruckturen;

public class SchleifenMitContinue {


	/*
	 * continue beendet den aktuellen Durchlauf
	 * der direkt umschließenden Schleife
	 */
	public static void main(String[] args) {
		
		int zahl = 0;
		
		while(zahl<5) {
			System.out.println(zahl + " vor if");
			
			if(zahl++ > 1) {
				continue; // aktuellen Schleifendurchlauf beenden
			}
			
			System.out.println(zahl + " nach if");
		}

	}

}
