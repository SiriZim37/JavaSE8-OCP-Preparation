package aufgaben.sort.a2;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class TextStatistics {

	private static String text; 
	
	
	public TextStatistics(String text) {
		this.text = text;
	}

	public static void main(String[] args) {

		
		TextStatistics stat = TextStatistics.of("Heute ist Montag!");

		Collection<Character> chars = stat.getUniqueChars();
		
		System.out.println(chars);
	}
	
	static TextStatistics of(String str){
		return new TextStatistics(str);
	}
	
	static Collection<Character> getUniqueChars(){

//		Collection<Character> set = new HashSet<>(); 	// ok 
		Set<Character> set = new HashSet<>();			// ok 
		
		for (int i = 0; i < text.length(); i++) {
	        char c = text.charAt(i);
	        set.add(c);
	    }        
		
	    return set;
	    
	    
	}


}
