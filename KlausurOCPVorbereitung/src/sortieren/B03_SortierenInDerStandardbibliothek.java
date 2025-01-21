package sortieren;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/*
 *   implement Comparable<?>
 * 	 public int compareTo(T o);
 * 
 * 	 implement Comparator<?>
 *   int compare(T o1, T o2);
 */


class Blume implements Comparable<Blume>{
	String name;
	int preis;
	public Blume(String name , int preis) {
		this.name = name;
		this.preis = preis;
	}
	@Override
	public String toString() {
		return name + "(" + preis+ ")";
	}
	public int compareTo(Blume o ) {
		Blume b2 = (Blume)o;
		return name.compareTo(b2.name)==0 ? preis - b2.preis : name.compareTo(b2.name); 
	}

}
public class B03_SortierenInDerStandardbibliothek {

	public static void main(String[] args) {

		/*
		 * Sortieren von Arrays (s. Bsp B01)
		 */
		
		/*
		 * Sorieren von Listen
		 */
		
		List<Blume> listBlumen = Arrays.asList(
			new Blume("Rose",200),
			new Blume("Astra",130),
			new Blume("Tulpin" , 130),
			new Blume("Aupupu" , 90)
		);
		
		/*
		 * Lösung A
		 * sort für Comparable (Blumen implement Comparable > compareTo)
		 */
		System.out.println("\n*** sort(List)");
		Collections.sort(listBlumen);  // es wid cf wenn kein Comparable implementiert! 
		System.out.println("Blumen:" + listBlumen);
		
		System.out.println("\n*** sort(null)");
		listBlumen.sort(null);  	 //  ok
		System.out.println("Blumen:" + listBlumen);
//		Collections.sort(null);  //	Exception: java.lang.NullPointerException: Cannot invoke "java.util.List.sort(java.util.Comparator)
		
		/*
		 * Lösung B
		 * Comparator ohne Comparable implement 
		 */

		Comparator<Blume> cmpBlumen = (b1,b2) -> { return b1.name.compareTo(b2.name)==0?b1.preis - b2.preis : b1.name.compareTo(b2.name); };
		listBlumen.sort(cmpBlumen);
		System.out.println("\n*** sort(cmpBlumen) aus Comparator");
		System.out.println("Blumen:" + listBlumen);

		/*
		 * Lösung C
		 *  sorter mit Comparator (Reverse)
		 *  compare preis first and then name
		 */
		class ReverseTest implements Comparator<Blume>{
			public int compare(Blume b1 , Blume b2) {
				return (b2.preis - b1.preis) == 0 ? b2.name.compareTo(b1.name) : b2.preis-b1.preis;
			}	
		};		
		ReverseTest reverseCmp = new ReverseTest();
		listBlumen.sort(reverseCmp);
		System.out.println("\n*** sort(reverse) aus Comparator");
		System.out.println("Blumen:" + listBlumen);
		
		
		
		//--------------------------------------------------------------------------//
		
		/*
		 * TreeSet sort
		 * 
		 * Lösung A 
		 * mit Comparable (Blumen implement Comparable > compareTo)
		 */
		Set<Blume> setBlumen = new TreeSet<>();
		setBlumen.addAll(listBlumen);	
		System.out.println("\nTreeSet mit Comparable");
		System.out.println(setBlumen);     // aufsteigen Name nach Preis
		
		/*
		 * Lösung B mit Comparator 
		 */
		
		setBlumen = new TreeSet<>(reverseCmp);
		setBlumen.addAll(listBlumen);	
		System.out.println("\nTreeSet mit Revers-Comparator");
		System.out.println(setBlumen);     //absteigen Preis nach name
		
		
		//--------------------------------------------------------------------------//
		
		/*
		 * funktionale Streams können aus Sortieren/vergleichen
		 * 
		 * Lösung A  mit Comparable
		 */
		System.out.println("\n*** Stream sortiert Comparable");
		listBlumen.stream().sorted().forEach(System.out::println);  // aufsteigen Name nach Preis
		
		/*
		 * Lösung B mit Comparator
		 */	
		System.out.println("\n*** Stream sortiert Comparator");
		listBlumen.stream().sorted(reverseCmp).forEach(System.out::println); //absteigen Preis nach name
		
		
		/*
		 * Terminal max :
		 * 
		 * Lösung A mit Comparable gibt es nicht
		 * Ersatz: natural-order-Comparator nehmen
		 * 
		 */
		/*
		 * aufsteigen Name nach Preis 			absteigen Preis nach name
		 * Astra(130)							Rose(200)
		 * Aupupu(90)							Tulpin(130)
		 * Rose(200)							Astra(130)
		 * Tulpin(130)							Aupupu(90)
		 */
		System.out.println("\n***Such nach Max preis max,min mit Comparator.naturalOrder()");
		listBlumen.stream()
			.max(Comparator.naturalOrder())
			.ifPresent( b -> System.out.println("max: " + b));
		listBlumen.stream()
			.min(Comparator.naturalOrder())
			.ifPresent( b -> System.out.println("min: "+ b));
		
		System.out.println("\n***Such nach Max preis max,min mit Comparator revers");
		listBlumen.stream()
			.max(reverseCmp)
			.ifPresent( b -> System.out.println("max: " + b));
		listBlumen.stream()
			.min(reverseCmp)
			.ifPresent( b -> System.out.println("min: "+ b));
		

		
		
	}
}
