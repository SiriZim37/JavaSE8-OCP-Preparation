package list;

import java.util.ArrayList;
import java.util.List;


public class B02_subList {

	public static void main(String[] args) {
		
		/*
		 * Achtung"
		 * 
		 * subList liefert eine 'View' der Basisliste zurück.
		 * Die View speichert die Elemente nicht selbst.
		 * Die View speichert nur die Addresse der Basisliste
		 * und die eigenen Grenzen.
		 * 
		 * 	SubList =  fromIndex  TO   toIndex-1
		 * 
		 * Doku : 
		 * "Returns a view of the portion of this list between the specified 
		 * fromIndex, inclusive, and toIndex, exclusive. 
		 * (If fromIndex and toIndex are equal, the returned list isempty.) 
		 * The returned list is backed by this list, so non-structuralchanges 
		 * in the returned list are reflected in this list, 
		 * and vice-versa.
		 * The returned list supports all of the optional list 
		 * operations supportedby this list.
		 */
		List<Integer> basisList = new ArrayList<Integer>();
		
		basisList.add(2);
		basisList.add(7);
		basisList.add(11);
		basisList.add(13);
		basisList.add(17);
		
		/*
		 * index  0  1  2   3   4
		 * 	     [2, 7, 11, 13, 17]
		 */
		
		System.out.println("1. basisList : " + basisList);
		
		int fromIndex = 1 ;  // inklusiv 
		int toIndex = 4 ;	 // exklusiv
		
		/*
		 * index  		  0  1  2   3   4
		 * basisList	 [2, 7, 11, 13, 17]
		 * 
		 * index  		     0   1   2      
		 * subList	        [7, 11, 13]	
		 * 
		 * index  		         0  1  2      
		 * subList2	           [11,13, 17]    
		 */
		
		
		List<Integer> subList = basisList.subList(fromIndex, toIndex);
		System.out.println("1.1 subList (index 1-4): " + subList );
		
//		subList = new ArrayList<>(subList); // so kann die Kopplung zu 
											// Basisliste entfernt werden
		
		List<Integer> subList2 = basisList.subList(2, 5);
		System.out.println("1.2 subList (index 1-5): " + subList2 );
		
		Integer x = subList.get(1);
		System.out.println("x : " + x ); // 11
		
		/*
		 * Basisliste ändern (aber keine Größe ändern)
		 */
		
		/*
		 * index  	   0  1  2     3   4
		 * basisList  [2, 7, 11, -555, 17]
		 * subList    [7, 11, -555]
		 */
		basisList.set(3, -555);
		System.out.println("2. basisList : " + basisList);
		System.out.println("2. subList (index 1-4): " + subList );
		
		
		/*
		 * subList ändern (aber keine Größe ändern)
		 */
		
		/*
		 * index  	   0     1       2     3   4
		 * basisList  [2,   -712,   11,  -555, 17]
		 * subList    [-712, 11,   -555]
		 */
		subList.set(0, -712);
		System.out.println("3. basisList : " + basisList);
		System.out.println("3. subList (index 1-4): " + subList );
		
		/*
		 * index  	   0     1       2     3   		4   5
		 * basisList  [2,   -712,   11,  -555, , -777, 17]
		 * subList    [-712, 11,   -555, -777]
		 */
		subList.add(3, -777);
		System.out.println("4. basisList : " + basisList);
		System.out.println("4. subList (index 1-4): " + subList );
		
		
		/*
		 * Nicht in der Prüfung:
		 * 
		 * 'Struktur-Änderung' führt dazu, dass subList ungültig wird
		 */
		basisList.add(1000);

		try {
			subList.add(1000);		// exception 
			
			
			System.out.println(subList);	//auch  exception 
		} catch (Exception e) {
			System.out.println("Fehler! subList ist ungültig: " + e);
		}
		

	}

}
