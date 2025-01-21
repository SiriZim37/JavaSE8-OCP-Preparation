package klausur;

import java.util.HashMap;
import java.util.Map;

public class TestHashMap {

	
	public static void main(String[] args) {
	/*
		Gegeben ist der Code:
		
		  Map<Integer, String> map = new HashMap<>();
		  for( Integer key : map ) {
		    System.out.println( map.get(key) );
		  }
		
		Was ist das Ergebnis, wenn alle Typen richtig importiert wurden?
		
		[ X  ] Der Code kompiliert nicht.
		[   ] Der Code kompiliert, wirft aber zur Laufzeit eine Exception.
		[   ] Der Code kompiliert und läuft ohne Ausgabe.
		[   ] Der Code kompiliert und läuft. Die Ausgabe ist 'null'.
		  
	 */
		  
		
		 Map<Integer, String> map = new HashMap<>();
	        map.put(1, "Value1");
	        map.put(2, "Value2");


	        for (Integer key : map.keySet()) {
	            System.out.println(map.get(key));
	        }

	}
}
