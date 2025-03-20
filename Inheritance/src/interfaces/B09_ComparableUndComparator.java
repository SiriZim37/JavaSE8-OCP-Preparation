package interfaces;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

class Dozent implements Comparable<Dozent>{
	private String name ;
	private int alter;
	
	public Dozent( String name, int alter) {
		this.name = name ;
		this.alter = alter;
	}
	public String getName() {
		return this.name;
	}
	
	public int getAlter() {
		return this.alter;
	}
	
	@Override
	public String toString() {
		return name + " (" + alter +")";
	}
	

	@Override
	public int compareTo(Dozent d2) {
		int result = name.compareTo(d2.name);
		
		if(result == 0 ) { // falls name gleich sind
			result = alter - d2.alter;
		}
		
		return result;

	}
}

/*
 * 	Comparator für Dozent
 */

class DozentReverseComparator implements Comparator<Dozent>{
	@Override
	public int compare(Dozent d1, Dozent d2) {
		//   MAX -> MIN
//		return - d1.compareTo(d2) ; 
	   //   MIN -> MAX
		return  d2.compareTo(d1) ;  // Reihenfolge der Referenz vertauscht!
	}
}

/*
 * Noch ein Comparator für Dozenten
 */
class DozentRandomComparator implements Comparator<Dozent> {
	public int compare(Dozent d1, Dozent d2) {
		return new Random().nextInt(3)-1; // 0-1 | 1-1 | 2-1
	}
}

/*
 * Noch ein Comparator
 */
class DozentAlterComparator implements Comparator<Dozent> {
	public int compare(Dozent d1, Dozent d2) {
		return d1.getAlter() - d2.getAlter();
	}
}

public class B09_ComparableUndComparator {

	/*
	 *  Comparator ist nicht in der OCA-Prüfung
	 */
	
	
	public static void main(String[] args) {
	
		Dozent[] arr = {
			new Dozent("Paul" , 67)	,
			new Dozent("Mary" , 35)	,
			new Dozent("Paul" , 45)	,
			new Dozent("Anna" , 41),
		};
		
		System.out.println("*** nicht sortiert : ");
		print(arr);
		
		/*	Methode sort der Klasse Array , Version 1 :
		 * 
		 * 			sort(Object[])
		 * 
		 * Diese Methode sortiert Elemtne aufsteigend in 
		 * der natürlichen Reihenfolge.
		 * 
		 * Dafür müssen die Elemente des Arrays von der Klasse sein,
		 * die das Interface Comparable implementiert.
		 */
		
		
		System.out.println("\n**** aufsteigen in der natürlichen Reihenfolge");
		Arrays.sort(arr);
		print(arr);
		
		
		/*
		 * Methode sort der Klasse Array, Version 2:
		 * 
		 * 		sort(array, Comparator)
		 * 
		 * Diese Methode vergleicht die Elemente aus dem Array paarweise
		 * mithilfe des übergebenen Comparators.
		 */
		System.out.println("\n*** absteigend:");
		Comparator<Dozent> cmp = new DozentReverseComparator();
		Arrays.sort(arr, cmp);
		print(arr);
		
		System.out.println("\n*** wieder mischen:");
		Arrays.sort(arr, new DozentRandomComparator());
		print(arr);
		
		System.out.println("\n*** nach Alter sortiert:");
		Arrays.sort(arr, new DozentAlterComparator());
		print(arr);

	}
	

	static void print(Dozent[] arr) {
		for(int i = 0 ; i < arr.length ; i++) {
			System.out.println( i + ". "+  arr[i]);
		}
	}
}
