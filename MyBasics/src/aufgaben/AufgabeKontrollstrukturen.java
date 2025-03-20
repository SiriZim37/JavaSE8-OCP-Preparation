package aufgaben;

public class AufgabeKontrollstrukturen {

	public static void main(String[] args) {

		/*
		 * Berechnen Sie die Summe aller folgenden Werte: 1, 2, 3 ... 10. 
		 * Geben Sie die Summe aus.
		 */
		System.out.println("*** A1");

		int sum = 0;
		for (int i=1; i<=10; i++) {
			sum += i;
		}
		System.out.println("Summe: " + sum); // 55
		
		/*
		 * Gegeben ist: x = 3, y = 4. 
		 * Berechnen Sie bitte x hoch y und geben Sie das Ergebnis aus. 
		 * Benutzen Sie für die Lösung die for-Schleife.
		 */
		System.out.println("\n*** A2");
		
		int x = 3, y = 4;
		int result = 1;
		
		for(int i=0; i<y; i++) {
			result *= x;
		}
		System.out.println(x + " hoch " + y + " = " + result);
		
		/*
		 * Gegeben ist: x = 3, y = 4. 
		 * Berechnen Sie bitte x hoch y und geben Sie das Ergebnis aus. 
		 * Benutzen Sie für die Lösung die while-Schleife.
		 */
		System.out.println("\n*** A3");
		
		x = 3;
		y = 4;
		result = 1;
		int count = y;
		
		while(count-- > 0) {
			result *= x;
		}
		System.out.println(x + " hoch " + y + " = " + result);
		
		/*
		 * Gegeben ist: x = 3, y = 4. 
		 * Berechnen Sie bitte x hoch y und geben Sie das Ergebnis aus. 
		 * Benutzen Sie für die Lösung die Methode java.lang.Math.pow.
		 */
		System.out.println("\n*** A4");
		x = 3;
		y = 4;
		
		result = (int)Math.pow(x, y);
		System.out.println(x + " hoch " + y + " = " + result);

		/*
		 * Zeichnen Sie ein gefülltes Rechteck auf der Konsole:

		 	*****
		 	*****
		 	*****
		 	*****
		 */
		System.out.println("\n*** A5");
		
		int zeilen = 4;
		int spalten = 5;
		char fillChar = '#';
		
		for (int z=0; z<zeilen; z++) {
			for(int s=0; s<spalten; s++) {
				System.out.print(fillChar);
			}
			System.out.println();
		}

		/*
		 * Zeichnen Sie ein leeres Rechteck auf der Konsole:
    
	        *****
	        *   *
	        *   *
	        *****

		 */
		System.out.println("\n*** A6");
		zeilen = 10;
		spalten = 15;
		char drawChar = 'x';
		
		for (int z=0; z<zeilen; z++) {
			for(int s=0; s<spalten; s++) {
				if(z==0 || z==zeilen-1 || s==0 || s==spalten-1) {
					System.out.print(drawChar);
				} else {
					System.out.print(' ');
				}
			}
			System.out.println();
		}
		
		/*
		 * Zeichnen Sie folgendes Spielfeld auf der Konsole:

	         12345
	        A.....
	        B.....
	        C.....
	        D.....
	        E.....

		 */
		System.out.println("\n*** A7");
		
		zeilen = 26;
		spalten = 9;
		
		// header 
		System.out.print(' ');
		for (int nr = 1; nr <= spalten; nr++) {
			System.out.print(nr);
		}
		System.out.println();
		
		// zeilen
		for (char rowNr='A'; rowNr < 'A'+zeilen; rowNr++) {
			System.out.print(rowNr);
			for(int colNr=0; colNr<spalten; colNr++) {
				System.out.print('.');
			}
			System.out.println();
		}
		
		
		/*
		    Monat 1. Tage: 31
		    Monat 2. Tage: 28 oder 29
		    Monat 3. Tage: 31
		    Monat 4. Tage: 30
		    Monat 5. Tage: 31
		    Monat 6. Tage: 30
		    Monat 7. Tage: 31
		    Monat 8. Tage: 31
		    Monat 9. Tage: 30
		    Monat 10. Tage: 31
		    Monat 11. Tage: 30
		    Monat 12. Tage: 31
		 */
		System.out.println("\n*** A8");
		for(int monat = 1; monat<=12; monat++) {
		    System.out.print("Monat " + monat + ". Tage: ");
		    
		    switch(monat) {
		    	case 2:
		    		System.out.println("28 oder 29");
		    		break;
		    	case 4:
		    	case 6:
		    	case 9:
		    	case 11:
		    		System.out.println("30");
		    		break;
		    	default:
		    		System.out.println("31");
		    }
		}
		
		
	} // end of main

}
