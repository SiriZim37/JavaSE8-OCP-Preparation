package kontrollstruckturen;

public class SchleifenMitBreak {

	/*
	 * break beendet die direkt umschließende Schleife
	 */
	public static void main(String[] args) {

		int zahl = 0;
		while(true) {
			System.out.println(zahl + " vor if");
			
			if(zahl++ > 1) {
				break;			// Schleife beenden
			}
			
			System.out.println(zahl + " nach if");
		}

	}

}
