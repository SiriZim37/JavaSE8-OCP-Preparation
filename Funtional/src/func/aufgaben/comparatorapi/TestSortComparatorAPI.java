package func.aufgaben.comparatorapi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;

/*•Optionale Aufgabe: 
 * 		Klasse Auto hat Attribute hersteller, 
 * 		modell und baujahr. Erzeugen Sie ein Array mit Autos 
 * 		und sortieren Sie das Array unterschiedlich. 
 * 		Verwenden Sie für die Vergleiche beim Sortieren 
 * 		unterschiedliche Comparatoren.
 */

class Auto {
	private String hersteller;
	private String modell;
	private int baujahr;
	
	public Auto( String hersteller,String modell, int baujahr) {
		this.hersteller = hersteller;
		this.modell = modell;
		this.baujahr = baujahr;
	}
	public String getHersteller() {
		return hersteller;
	}
	public String getModell() {
		return modell;
	}
	public int getBaujahr() {
		return baujahr;
	}
	
}

public class TestSortComparatorAPI {

	public static void main(String[] args) {
		
		Auto[] array =  {   new Auto("Honda", "Jazz", 2019),
							new Auto("VW", "Golf", 2021),
				            new Auto("BMW", "X3", 2020),
				            new Auto("Mercedes", "C-Klasse", 2018),
				            new Auto("Toyota", "CHR", 2017)
						};
		
		
		// #A1 comparing
		
		// Alternativ 1 : static Comparator comparing(Function keyExtractor)
		Function<Auto, String>  keyHersteller = h -> h.getHersteller();
		Function<Auto, String>  keyModell 	  = m -> m.getModell();
		Function<Auto, Integer> keyBaujahr	  = b -> b.getBaujahr();
		
		Comparator<Auto> c1 = Comparator.comparing(keyHersteller);
		Comparator<Auto> c2 = Comparator.comparing(keyModell);
		Comparator<Auto> c3 = Comparator.comparing(keyBaujahr);
		
		// Alternativ 2 
		Comparator<Auto> cmpHersteller = Comparator.comparing(Auto::getHersteller);
		Comparator<Auto> cmpModell = Comparator.comparing(Auto::getModell);
		Comparator<Auto> cmpBaujahr = Comparator.comparing(Auto::getBaujahr);
		
		Arrays.sort(array , c1);
		System.out.println("1. Sortiert nach Hersteller:");
		printArray(array);
	    
	    Arrays.sort(array , c2);
		System.out.println("\n2. Sortiert nach Modell :");
		printArray(array);
		
		Arrays.sort(array , c3);
		System.out.println("\n3. Sortiert nach Baujahr :");
		printArray(array);
		
	
		// #A2 reversed
		Comparator<Auto> reversed_C1  = cmpHersteller.reversed();
		Arrays.sort(array , reversed_C1);
		System.out.println("\n4. Umgekehrt sortiert nach Hersteller:");
		printArray(array); 
		
		Comparator<Auto> reversed_C2  = cmpModell.reversed();
		Arrays.sort(array , reversed_C2);
		System.out.println("\n5. Umgekehrt sortiert nach Modell:");
		printArray(array);
		
		Comparator<Auto> reversed_C3  = cmpBaujahr.reversed();
		Arrays.sort(array , reversed_C3);
		System.out.println("\n6. Umgekehrt sortiert nach Baujahr:");
		printArray(array);

		
		// #A3 thenComparing		
		Comparator<Auto> cmpCombined = cmpHersteller.thenComparing(cmpModell);
		cmpCombined = cmpCombined.thenComparing(cmpBaujahr);
		
		System.out.println("\n7. Combined : Sortiert nach Hersteller, Modell und Baujahr:");
		Arrays.sort(array ,cmpCombined);
		printArray(array);
		
		// #A3 reversed thenComparing
		Comparator<Auto> reversed_combined  = cmpCombined.reversed();
		System.out.println("\n8. Combined : Umgekehrt nach Hersteller, Modell und Baujahr:");
		Arrays.sort(array ,reversed_combined);
		printArray(array);
		
	}
	
	private static void printArray(Auto[] array) {
		String strFormat = "|%2d | %-8s | %-8s | %5d |";
		for (int i = 0; i < array.length; i++) {
			String s = 	String.format(strFormat , i+1  
										, array[i].getHersteller() 
										, array[i].getModell()
										, array[i].getBaujahr() );
			System.out.println(s);
		}
	}

}
