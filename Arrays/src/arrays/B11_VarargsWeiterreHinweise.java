package arrays;

import java.util.Arrays;

public class B11_VarargsWeiterreHinweise {


	/*
	 * Varargs-Parameter muss der letzte Parameter sein!
	 */
	
	static void m1(String... p) {}
	static void m2(int x, String... y) {}
	static void m3(int x, int... y) {}
	
	static void m4(int[] x, int... y) {}
//	static void m5(int... x, int... y) {} // cf
//	static void m6(int... x, String y) {} // cf
	
	public static void main(String[] args) {
		
//		m3(); // cf: 1. Parameter ist nicht Varargs und braucht ein Argument
		m3(1); 
		m3(1, 12); 
		m3(1, 12, 13); 
		m3(1, 12, 13, 14); 
		
		
		int[][] arr2D = {
			{ 4, 5, 6 },
			{ 12, 13 },
		};
		print(arr2D);
		
		print(); // leeres 2D-Array übergeben
		
		int[] a1 = { 3, 2, 1 };
		print(a1); // 2D-Array mit einem Unterarray übergeben
		print(a1, a1); // 2D-Array mit 2 Unterarrays übergeben
		print(a1, a1, a1); // 2D-Array mit 3 Unterarrays übergeben
		
		/*
		 * Es gibt in der Standardbibliothek in vielen Klassen
		 * eine Varargs-Methode:
		 * 
		 *       format(String format, Object... args)
		 * 
		 */
		String text = String.format("Tag %d, Monat %d", 10, 7);
		System.out.println(text);
		
		System.out.format("Tag %d, Monat %d%n", 10, 7);
	}

	static void print(int[]... data) {
		System.out.println("-----------------");
		for(int[] arr : data) {
			System.out.println(Arrays.toString(arr));
		}
	}
	
	
}

