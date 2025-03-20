package aufgaben;

import java.util.Random; 

public class AufgabeMethoden {

	public static void main(String[] args) {
		
		/*
		 * A1
		 */
		System.out.println("*** A1");
		printFromTo(5, 11); // 5 .. 10
		printFromTo(-3, 4); // -3 .. 3
		
		/*
		 * A2
		 */
		System.out.println("\n*** A2");
		int x = 2, y = 3;
		int res = sum(x, y);
		System.out.println("sum(" + x + ", " + y + ") = " + res);
		
		x = 2;
		y = Integer.MAX_VALUE;
		res = sum(x, y); // int-Overflow!
		System.out.println("sum(" + x + ", " + y + ") = " + res);
		
		/*
		 * A3
		 */
		System.out.println("\n*** A3");
		int sum = sumFromTo(1, 5); // 15
		System.out.println("sum = " + sum);
		
		/*
		 * A4
		 */
		System.out.println("\n*** A4");
		
		System.out.println("5 X 4: ");
		zeichneRechteck(5, 4);
		
		System.out.println("7 X 3: ");
		zeichneRechteck(7, 3);
		
		/*
		 * A5
		 */
		System.out.println("\n*** A5");
		
		System.out.println("5 X 4, leer: ");
		zeichneRechteck(5, 4, false);
		
		System.out.println("5 X 4, gefüllt: ");
		zeichneRechteck(5, 4, true);
		
		/*
		 * A6
		 */
		System.out.println("\n*** A6");
		
		printRandom(5, -2, 2); // gibt 5 int-Zufallswerte aus dem Bereich [-2 ... 2] aus
		printRandom(5, 10, 20); // gibt 5 int-Zufallswerte aus dem Bereich [10 ... 20] aus
		
	} // end of main
	
	static void printRandom(int numberOfValues, int min, int maxInclusive) {
		
		for(int i=0; i<numberOfValues; i++) {
			Random rnd = new Random();
			
			// seit Java 17 gibt es eine bequemere nextInt als diese.
			/*
			 * rnd.nextInt(5) 		= 0 | 1 | 2 | 3 | 4
			 * rnd.nextInt(5) + -2  = 0-2=-2 | 1-2=-1 | 2-2=0 | 3-2=1 | 4-2=2 
			 */
			int value = rnd.nextInt(maxInclusive - min + 1) + min;
			
			System.out.print(value + " ");
		}
		System.out.println();
	}

	static void zeichneRechteck(int breite, int hoehe, boolean fuellen) {
		for (int z=0; z<hoehe; z++) {
			for (int s=0; s<breite; s++) {
				if(fuellen) {
					System.out.print('*');
				} else if (z==0 || z==hoehe-1 || s==0 || s == breite-1) {
					System.out.print('*');
				} else {
					System.out.print(' ');
				}
			}
			System.out.println();
		}
	}
	
	static void zeichneRechteck(int spalten, int zeilen) {
		zeichneRechteck(spalten, zeilen, true);
	}
	
//	static void zeichneRechteck(int breite, int hoehe, boolean fuellen) {
//		if(fuellen) {
//			zeichneRechteck(breite, hoehe);
//			return;
//		}
//		
//		for (int z=0; z<hoehe; z++) {
//			for (int s=0; s<breite; s++) {
//				if (z==0 || z==hoehe-1 || s==0 || s == breite-1) {
//					System.out.print('*');
//				} else {
//					System.out.print(' ');
//				}
//			}
//			System.out.println();
//		}
//	}
//	
//	static void zeichneRechteck(int spalten, int zeilen) {
//		for(int z=0; z<zeilen; z++) {
//			for(int s=0; s<spalten; s++) {
//				System.out.print('*');
//			}
//			System.out.println();
//		}
//	}
	
	
	/**
	 * Summe aller Werte von from (inklusive) bis to (INKLUSIVE)
	 * 
	 * @param from inklusive
	 * @param to INKLUSIVE
	 * @return Summe
	 */
	static int sumFromTo(int from, int to) {
		int result = 0;
		for(int i=from; i<=to; i++) {
			result += i;
		}
		return result;
	}

	static int sum(int a, int b) {
		return a + b;
	}
	
	/**
	 * Die Methode gibt alle int-Werte von "from" bis "to" 
	 * auf der Konsole in einer Zeile aus.
	 * 
	 * @param from inklusive
	 * @param to exklusive
	 */
	static void printFromTo(int from, int to) {
		for(int i=from; i<to; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
}
