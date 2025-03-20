package kontrollstruckturen;

public class SwitchAnweisung {

	public static void main(String[] args) {
		
		/*
		 * Typen, die die switch analysieren kann:
		 * 
		 *	- byte, short, int und ihre Wrapper-Klassen
		 *
		 *	- char und Character
		 *
		 *  - String	
		 *  
		 *  - enum-Klassen	
		 */
		String v = "moin";
		
		switch(v) {
			
		}

		/*
		 * Die Logik der switch:
		 * 
		 * 	1. Den passenden Zweig suchen.
		 * 		Zuerst bei case-Zweigen. 
		 * 		Wenn kein case-Zweig gefunden wurde, wird der default-Zweig gesucht.
		 * 
		 *  2. Wenn der passende Zweig gefunden wurde:
		 *  	In den gefundenen Zweig einsteigen und
		 *  	alle Anweisungen bis zum break ausführen
		 */
		final int day = 3;
		System.out.println("1");
		switch(day) {
			case 1: 
				System.out.println("b1. mo");
			case 2: 
				System.out.println("b1. di");
		}
		System.out.println("2");
		switch(day) {
			case 1: 
				System.out.println("b2. mo");
			case 3: 
				System.out.println("b2. mi");
		}
		System.out.println("3");
		switch(day) {
			case 1: 
				System.out.println("b3. mo");
			default: 
				System.out.println("b3. im default");
		}
		System.out.println("4");
		switch(day) {
			case 5: 
				System.out.println("b4. fr");
			default: // passender Zweig. 
				System.out.println("b4. im default");	// 1. Ausgabe
			case 1: 
				System.out.println("b4. mo");			// 2. Ausgabe
		}
		
		System.out.println("5");
		switch(day) {
			case 6:
				System.out.println("5. sa");
				break;
			case 7:
				System.out.println("5. so");
				break;
			default:
				System.out.println("5. Arbeitstag");
				break;
		}
		
		System.out.println("6");
		switch(day) {
			case 1:
				System.out.println("b6. mo");
				break;
			case 2:
				System.out.println("b6. di");
				break;
			case 3:
				System.out.println("b6. mi");
				break;
			//...
		}
		System.out.println("7");
		switch(day) {
			case 1: 
			case 2: 
			case 3: 
			case 4: 
			case 5:
				System.out.println("b7. Arbeitstag");
				break;
			default:
				System.out.println("b7. Wochenende oder day hat ungültigen Wert");
		}
		
		/*
		 * Test mit String
		 */
		String s = "mo";
		
		switch(s) {
			case "mo": 
			case "MO":
				System.out.println("b8. Montag");
		}
		
	}

}
