package aufgaben.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/* Aufgabe (Optional : 
 *  Jedes Rechteck hat Breite und Höhe.
 *  Sortieren Sie ein Array mit Rechteck-Elementen aufsteigend nach Fläche. 
 *  Sortieren Sie das Array mit Rechteck-Elementen absteigend nach Fläche. 
 */
class Rechteck implements Comparable<Rechteck>{
	private int breite;
	private int hoehe;
	
	public Rechteck( int breite , int hoehe ) {
		this.breite = breite;
		this.hoehe = hoehe;
	}

	public int getBreite() {
		return breite;
	}

	public int getHoehe() {
		return hoehe;
	}
	
	public int getFlaeche() {
		return breite * hoehe;
	}
	
	@Override
	public String toString() {
		return "Rechteck [" + breite + " X " + hoehe  + "] ";
	}
	
	@Override
	public int compareTo(Rechteck r2) {
	    // Vergleich nach Fläche (aufsteigend)
		return Integer.compare(this.getFlaeche(), r2.getFlaeche());
	}
}

class RechteckReverseComparator implements Comparator<Rechteck> {	
	@Override
	public int compare(Rechteck r1, Rechteck r2) {
		 // Vergleich nach Fläche (absteigend)
        return Integer.compare(r2.getFlaeche(), r1.getFlaeche());
	}
}


public class RechteckSortTest {
	
	public static void main(String[] args) {
		Random rnd = new Random();
		
		Rechteck[] arr = {
				new Rechteck(rnd.nextInt(10)+1, rnd.nextInt(10)+1),
				new Rechteck(rnd.nextInt(10)+1, rnd.nextInt(10)+1),
				new Rechteck(rnd.nextInt(10)+1, rnd.nextInt(10)+1),
				new Rechteck(rnd.nextInt(10)+1, rnd.nextInt(10)+1),
				new Rechteck(rnd.nextInt(10)+1, rnd.nextInt(10)+1)
		};
		// Print original array
		print(arr);
		
		 // Aufsteigend sortieren
        System.out.println("\nArray aufsteigend nach Fläche:");
		Arrays.sort(arr);
		print(arr);
		
		// Absteigend sortieren
		System.out.println("\nArray absteigend nach Fläche:");
		Arrays.sort(arr, new RechteckReverseComparator());
		print(arr);
		
		
	}
	
	static void print(Rechteck[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + 1 + ". " + arr[i] + " Fläche = " + arr[i].getFlaeche());
        }
    }
}
