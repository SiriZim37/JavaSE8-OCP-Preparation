package aufgaben.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/* Aufgabe (Optional : 
 *  Jedes Rechteck hat Breite und Höhe.
 *  Sortieren Sie ein Array mit Rechteck-Elementen aufsteigend nach Fläche. 
 *  Sortieren Sie das Array mit Rechteck-Elementen absteigend nach Fläche. 
 */
class RechteckDozent {
	private int breite;
	private int hoehe;
	
	public RechteckDozent( int breite , int hoehe ) {
		this.breite = breite;
		this.hoehe = hoehe;
	}

	public int getBreite() {
		return breite;
	}

	public int getHoehe() {
		return hoehe;
	}
	
	
	@Override
	public String toString() {
		return "Rechteck [" + breite + " X " + hoehe  + "] ";
	}

}

//Von Dozent
class RechteckCmp implements Comparator<RechteckDozent>{
	
	public int compare(RechteckDozent r1 , RechteckDozent r2) {
		int f1 = r1.getBreite()*r1.getHoehe();
		int f2 = r2.getBreite()*r2.getHoehe();
		
		return Integer.compare(f1, f2);
		
//		if(f1<f2) {
//			return -1;
//		}else if(f1>f2)
//			return 1;
//		else {
//			return 0;
//		}
	}
}


public class RechteckSortTestDozent {
	
	/*
	 * 	In diser Lösung wird Rechteck-Klasse des Interfaces Comparable
	 * 	nicht realisieren. In der Praxis ist es ok
	 *  Comparable zu implementieren.
	 */
	
	
	public static void main(String[] args) {
		Random rnd = new Random();
		
		RechteckDozent[] arr = {
				new RechteckDozent(rnd.nextInt(10)+1, rnd.nextInt(10)+1),
				new RechteckDozent(rnd.nextInt(10)+1, rnd.nextInt(10)+1),
				new RechteckDozent(rnd.nextInt(10)+1, rnd.nextInt(10)+1),
				new RechteckDozent(rnd.nextInt(10)+1, rnd.nextInt(10)+1),
				new RechteckDozent(rnd.nextInt(10)+1, rnd.nextInt(10)+1)
		};
		// Print original array
		print(arr);
		
		
		// Von Dozent
		 /*	 Alternativ 1 
		 * 
		 * 	Comparator mit einer normaler Klasse
		 */
		  System.out.println("\n*** sortiert aufsteigend nach Fläche:");
		  Comparator<RechteckDozent> cmp = new RechteckCmp();
		  Arrays.sort(arr,  cmp); 
		  print(arr);
		/*	 Alternativ 12
		* 
		* 	Comparator mit einerr Lambda
		*/		  
		  System.out.println("\n*** sortiert absteigend nach Fläche:");
//		 cmp = ( r1,r2) -> {		
//			 return cmp.compare(r2, r1);  // cf : andere Methode
//		 };
		  // 1#
		  Comparator<RechteckDozent> cmp2 = ( r2,r1) -> {		
				 return cmp.compare(r2, r1);
		  };
		  // 2#
		  Arrays.sort(arr,  ( r2,r1) -> cmp.compare(r2, r1) ); 
		  Arrays.sort(arr,  cmp2); 
		  print(arr);
		  
		  
		  
		  
		
	}
	
	static void print(RechteckDozent[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + 1 + ". " + arr[i] );
        }
    }
}
