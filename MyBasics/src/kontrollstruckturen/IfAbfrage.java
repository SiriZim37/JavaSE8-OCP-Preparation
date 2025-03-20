package kontrollstruckturen;

public class IfAbfrage {

	public static void main(String[] args) {

		int day = 1; // gültige Werte: 1 .. 7
		
		/*
		 * Block ausführen oder überspringen
		 */
		if (day==1) {
			System.out.println("1. Montag");
		}
		
		if (day==2) {
			System.out.println("2. Dienstag");
		}

		/*
		 * Entweder Block 1 oder Block 2 ausführen
		 */
		if (day>=1 && day<=5) {
			System.out.println("3. Arbeitstag");
		} else {
			System.out.println("3. Kein Arbeitstag. Wochenede oder ungültiger Wert in der Variable day");
		}
		
		/*
		 * Entweder Block 1
		 * oder Block 2
		 * oder Block 3 ausführen
		 * ...
		 * oder gar nichts machen
		 */
//		day = 555;
		if (day==1) {
			System.out.println("4. Mo");
		} else if (day==2) {
			System.out.println("4. Di");
		} else if (day==3) {
			System.out.println("4. Mi");
		}
		
		
		/*
		 * Entweder Block 1
		 * oder Block 2
		 * ...
		 * oder else-Block ausführen
		 */
		day = 6;
		
		if(day>=1 && day<=5) {
			System.out.println("5. Arbeitstag");
		} else if(day==6 || day==7) {
			System.out.println("5. Wochenende!");
		} else {
			System.out.println("5. day hat einen ungültigen Wert");
		}
		
	}

}
