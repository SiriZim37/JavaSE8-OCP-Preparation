package lists;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class B06_Sortieren {

	public static void main(String[] args) {


		List<Integer> listInt = new ArrayList<Integer>();
		
		listInt.add(12);
		listInt.add(-3);
		listInt.add(17);
		listInt.add(5);
		listInt.add(-44);
		System.out.println("1. listInt = " + listInt);		//[12, -3, 17, 5, -44]
		/*
		 * Aufsteigend in der natürlichen Reihenfolge
		 */
		Collections.sort(listInt);	
		
		System.out.println("2. listInt = " + listInt);	//  [-44, -3, 5, 12, 17]
		
		/*
		 * Absteigend
		 */
		Comparator<Integer> cmp = (a,b) -> b.compareTo(a);

		Collections.sort(listInt,cmp);
		
		System.out.println("3. listInt = " + listInt);	//  [17, 12, 5, -3, -44]
		
		/*
		 * sort-Methode aus List Interface (nicht in der Prüfung)
		 */
		// Aufsteigend
		cmp = (a,b)-> a.compareTo(b);
		listInt.sort(cmp);
		System.out.println("4. Aufsteigend = " + listInt);	//  [-44, -3, 5, 12, 17]
		
		cmp = Collections.reverseOrder();
		listInt.sort(cmp);
		System.out.println("5. Absteigend (reverseOrder) = " + listInt); // [17, 12, 5, -3, -44]
		

	}

}
