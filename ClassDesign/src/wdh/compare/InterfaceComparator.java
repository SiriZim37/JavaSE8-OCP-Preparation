package wdh.compare;

import java.util.Comparator;


class MyStringComparator implements Comparator<String>{

	public int compare(String s1, String s2) {
		return s2.compareTo(s1);
	}
	
	
}
public class InterfaceComparator {

	public static void main(String[] args) {

		String s1 = "mo";
		String s2 = "di";
		
		/*
		 * Wenn  eine Klasse das Interface Comparator implementiert , 
		 * ensteht ein alternativer Vergleich (Comparator) , 
		 * mit dem Elemente einer anderen Klasse vergleichen werden können.
		 * 
		 * (alternativ = nicht 'natürlich')
		 */
		Comparator<String> cmp = new MyStringComparator();
		
		int result = cmp.compare(s1, s2);
		
		
		if(result < 0) {
			System.out.println("mo ist kleiner als di"); // Ausgabe : mo ist kleiner als di
		}else if(result > 0 ) {
			System.out.println("mo ist größer als di"); 
		}else {
			System.out.println("mo und di sind gleich");
		}
		
		

	}

}
