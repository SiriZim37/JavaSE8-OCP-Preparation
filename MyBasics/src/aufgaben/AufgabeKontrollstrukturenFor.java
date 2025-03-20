package aufgaben;

public class AufgabeKontrollstrukturenFor {

	public static void main(String[] args) {

		/*
		 * 0 1 2 3 4 5 6 7 8 9
		 */
		System.out.println("*** A1");
		for (int i=0; i<10; i++) {
			System.out.print(i + " ");
		}
		System.out.println();

		/*
		 * 0 2 3 4 5 6 7 8 9
		 */
		System.out.println("\n*** A2");
		for (int i = 0; i < 10; i++) {
			if (i!=1) {
				System.out.print(i + " ");
			}
		}
		
		/*
		 * -4 -2 0 2 4 ... 50
		 */
		System.out.println("\n*** A3");
		for (int i=-4; i<=50; i+=2) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		/*
		 * a b c ... z
		 */
		System.out.println("\n*** A4.1");
		for (int i=97; i<=122; i++) {
			System.out.print((char)i + " ");
		}
		System.out.println();
		
		System.out.println("\n*** A4.2");
		for (int i='a'; i<='z'; i++) {
			System.out.print((char)i + " ");
		}
		System.out.println();
		
		System.out.println("\n*** A4.3");
		for (char i='a'; i<='z'; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		/*
		 * Z Y X ... A
		 */
		System.out.println("\n*** A5");
		for (char ch='Z'; ch>='A'; ch--) {
			System.out.print(ch + " ");
		}
		System.out.println();
	
		/*
		 * Zahlen aus [1 ... 100] ausgeben, die durch 5 
		 * ohne Rest dividierbar sind
		 */
		System.out.println("\n*** A6");
		
		for (int i=1; i<=100; i++) {
			if(i%5==0) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
		
		/*
		 * 3 1 2 3 2 1 2 1 1
		 * _       _     _
		 */
		System.out.println("\n*** A7");
		for (int i=3; i>=1; i--) {
			System.out.print("<" + i + "> ");
			for (int k=1; k<=i; k++) {
				System.out.print(k + " ");
			}
		}
		
	}

}
