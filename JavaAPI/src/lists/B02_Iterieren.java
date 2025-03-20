package lists;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class B02_Iterieren {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		
		list.add(12);	// Integer param = Integer.valueOf(12)
		list.add(13);	
		list.add(14);
		
		System.out.println("*** mit for schleife");
		for (int i = 0; i < list.size(); i++) {
			Integer e = list.get(i);
			System.out.println(e);
		}
		
		System.out.println("*** mit forEach-Schleife");
		
		for (Integer e : list) {
			System.out.println(e);
		}
		
		/*	Iterable und Iterator sind nicht in der Prüfung
		 * 
		 * Die forEach-Schleife arbeitet in Wirklihkeit mit dem 
		 * 'Iteratior' aus dem Iterable! 
		 * 	
		 */
		System.out.println("\n*** mit while-Schleife für Iterable");
		Iterable<Integer> iterable = list;
		
		Iterator<Integer> it = iterable.iterator();
		while (it.hasNext()) {
			Integer e = it.next();
			System.out.println(e);
			
		}
	}

}
