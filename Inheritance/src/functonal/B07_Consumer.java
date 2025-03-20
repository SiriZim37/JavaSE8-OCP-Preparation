package functonal;

import java.util.ArrayList;
import java.util.function.Consumer;

public class B07_Consumer {

	/*
	 * 	interface Consumer <T>{
	 * 		void accept(T t);
	 * 	}
	 */

	public static void main(String[] args) {
		
		ArrayList<String> listStr = new ArrayList<String>();
		listStr.add("mo"); // String param = "mo"
		listStr.add("di");
		listStr.add("mi");
		listStr.add("do");
		
//		listStr.add(true);	 // cf : String parame = true <<< invalid
		
		/*
		 * 	for-Each-Methode braucht den passenden Consumer! 
		 *  In der OCA-Prüfung kann es (selten) zu dem Code mit 
		 *  dem Aufruf der forEach-Methode kommen.
		 *  Überprüfen Sie ob der Consumer genauso wie 
		 *  die Liste parameterisiert wurde.
		 * 
		 */
		
		Consumer<Integer> c1 = x -> {};
//		listStr.forEach(c1) ; // cf : Consumer<Integer> passt nicht für ArrayList<String>
		
		Consumer<String> c2 = x -> {};
		listStr.forEach(c2);	// ok : Consumer<String> passt für ArrayList<String>
		
		listStr.forEach(s -> System.out.println(s));	// Alle Elemente ausgeben.
		
		
	}
}
