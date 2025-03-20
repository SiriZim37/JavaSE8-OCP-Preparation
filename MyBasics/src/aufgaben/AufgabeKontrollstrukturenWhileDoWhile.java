package aufgaben;

public class AufgabeKontrollstrukturenWhileDoWhile {

	public static void main(String[] args) {

		/*
		 * 0 1 2 3 4 5 6 7 8 9
		 */
		int zahl = 0;
		while(zahl < 10) {
			System.out.print(zahl + " ");
			zahl++;
		}
		System.out.println();
	
		/*
		 * 0 2 3 4 5 6 7 8 9
		 */
		zahl = 0;
		do {
			if(zahl!=1) {
				System.out.print(zahl + " ");
			}
			zahl++;
		} while(zahl < 10);
		System.out.println();
		
		/*
		 * -4 -2 0 2 4 ... 50
		 */
		zahl = -4;
		while(zahl<=50) {
			System.out.print(zahl + " ");
			zahl+=2;
		}
		System.out.println();
		
		System.out.println("nochmal");
		
		zahl = -6;
		while( (zahl+=2) <= 50 ) {
			System.out.print(zahl + " ");
		}
		System.out.println();
		
		System.out.println("nochmal");
		
		zahl = -4;
		do {
			System.out.print(zahl + " ");
		} while( (zahl+=2) <= 50 );
		
		System.out.println();
		
		/*
		 * a b c ... z
		 * 
		 */
		char ch = 'a';
		while (ch <= 'z') {
			System.out.print(ch++ + " ");
		}
		System.out.println();
		
		/*
		 * Z Y X ... A
		 */
		ch = 'Z';
		do {
			System.out.print(ch-- + " ");
		} while(ch >= 'A');
		System.out.println();
		
		System.out.println("nochmal");
		
		ch = 'Z';
		do {
			System.out.print(ch + " ");
		} while (--ch >= 'A');
		System.out.println();
		
		System.out.println("nochmal");
		
		ch = 'Z';
		do {
			System.out.print(ch + " ");
		} while (ch-- > 'A');
		System.out.println();
		
		/*
		 * Zahlen aus dem Bereich [1 ... 100] ausgeben, die durch 5 ohne Rest dividierbar sind 
		 */
		zahl = 1;
		while (zahl <= 100) {
			if (zahl % 5 == 0) {
				System.out.print(zahl + " ");
			}
			zahl++;
		}
		System.out.println();
		
		/*
		 * 3 1 2 3 2 1 2 1 1
		 * _       _     _
		 */
		int i = 3;
		while(i>=1) {
			System.out.print("<" + i + "> ");
			
			int j=1;
			do {
				System.out.print(j + " ");
				j++;
			} while(j<=i);
			
			i--;
		}
		System.out.println();
		System.out.println();

		/*
		 * Gegeben ist x = 100. Dekrementieren Sie x um einen Zufälligen 
		 * Wert aus dem Bereich [1 .. 5] solange x größer 0 ist. 
		 * Geben Sie bei jeder Dekrementierung den neuen Wert der x aus.
		 */
		System.out.println("*** Optionale Aufgabe");
		int x = 100;
		int count = 1;
		
		java.util.Random rnd = new java.util.Random();
		
		while(x > 0) {
			x -= rnd.nextInt(5) + 1; // [0 .. 5) + 1 = [1 .. 6)
			System.out.println(count++ + ". " + x);
		}
		
	} // end of main

}
