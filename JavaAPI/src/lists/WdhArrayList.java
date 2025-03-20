package lists;

import java.util.ArrayList;
import java.util.List;

public class WdhArrayList {

	public static void main(String[] args) {

//		bsp1();
//		bsp2();
		bsp3();

	}
	
	/*
	 * 
	 * Wie viele String-Objekt stehen dem GC in der Zeile A zur Verfügung ? 
	 * 
	 * A. Der Code kompiliert nicht
	 * B. In der Zeile A stehen 3 String-Objekte dem GC zur Verfügung
	 * C. In der Zeile A stehen 2 String-Objekte dem GC zur Verfügung
	 * D. In der Zeile A steht ein String-Objekt dem GC zur Verfügung
	 * E. In der Zeile A stehen keine String-Objekte dem GC zur Verfügung
	 * F. Alle anderen Antworten sind falsch
	 * 
	 *  Antwort : 
	 *  		Die Schleife erzeugt 3 neue String-Objekte.
	 * 			Die Referenzen werden in der ArraList gespeichert, 
	 * 			aber die Referenz zu dem letzten String-Objekt bleibt auch in 
	 * 			der Variable s.
	 *  
	 * 
	 */
	static void bsp3() {
		String s = "";
		List<String> list = new ArrayList<>();
		
		for (int i = 0;  i < 3 ; i++) {
			list.add( s+=i );    // list.add( s = s+1 ) [0 , 01 , 012]
		}
		list = null ;

		
		// Zeile A 
		/*
		 * Zum Zeitpunkt von Zeile A sind folgende String-Objekte im Speicher:
		 * "0": Dieses Objekt existierte während der ersten Schleife, wird 
		 * 		aber durch die spätere Zuweisung auf "01" nicht mehr referenziert.
		 * 
		 * "01": Dieses Objekt existierte während der zweiten Schleife und wird 
		 * 		durch die spätere Zuweisung auf "012" nicht mehr referenziert.
		 * 
		 * "012": Dieses Objekt ist das aktuelle String-Objekt, auf das 's' zeigt. 
		 * 		Es wird nicht durch die ArrayList referenziert, 
		 * 		aber da s noch darauf verweist, wird es im Speicher behalten.
		 */
	}
	
	/*
	 * 
	 * Wie viele String-Objekt stehen dem GC in der Zeile A zur Verfügung ? 
	 * 
	 *  Antwort : keine 
	 *  
	 * 
	 */
	
	static void bsp2() {
		List<String> list = new ArrayList<>();
		
		for (int i = 0; i < 100 ; i++) {
			list.add("mo");		 // die Address ist im String-Pool
		}
		list = null ;
		
		// Zeile A 
	}
	
	
	/*
	 * 
	 * Wie viele Integer-Objekt stehen dem GC in der Zeile A zur Verfügung ? 
	 * 
	 *  Antwort : 2 
	 *  
	 *  s. Diagramme/Wdh. GC ArrayList Wrapper.pdf 
	 */
	
	static void bsp1() {
		
		List<Integer> list = new ArrayList<>();
		
		list.add(100);
		list.add(200);	// Integer-Objekt
		list.add(300);	// Integer-Objekt
		list =null;
		
		// Zeile A 
		
	}

}
