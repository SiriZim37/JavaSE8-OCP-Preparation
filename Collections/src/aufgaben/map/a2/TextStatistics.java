package aufgaben.map.a2;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class TextStatistics {

	public static TextStatistics of(String text) {
		return new TextStatistics(text);
	}
	
	private String text;
	
	public TextStatistics(String text) {
		this.text = text;
	}


	/**
	 * Liefert eine Collection von `Character` zurück, in der alle 
	 * auftretenden Zeichen von dem zu untersuchenden String 
	 * aufgelistet sind und einmalig auftauchen
	 * 
	 * @return
	 */
	public Collection<Character> getUniqueChars() {
		
		/*	  Alternativ 
		Collection<Character> chars = new HashSet<Character>();

		for (int i = 0; i < text.length(); i++) {
	        char c = text.charAt(i);
	        chars.add(c);
	    }  
		
		return chars;
		*/
		
		return getCharCounts().keySet();
	}
	
	// V getOrDefault(Object key, V defaultValue)  :  return defaultValue if the key is not found in the map.
	// boolean containsKey(Object key)
	/**
	 * Jedem in Text gefundenen Zeichen wird in der Map die Zahl 
	 * zugeordnet, die sagt, wie oft das Zeichen in dem Text vorkommt.
	 * 
	 * @return
	 */
	public Map<Character, Integer> getCharCounts(){
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		 	
		for (int i = 0; i < text.length(); i++) {
		    char key = text.charAt(i);
		    if (map.containsKey(key)) {
		        map.put(key, map.get(key) + 1);
		    } else {
		        map.put(key, 1);
		    }
		}
		
	// Alternativ
	/*		 
		for (int i = 0; i < text.length(); i++) {
			 char key = text.charAt(i);
			 Integer value = map.getOrDefault( key , 0) + 1;
			 map.put( key ,  value);
		}  
	 */

		return map;
	}
	
}
