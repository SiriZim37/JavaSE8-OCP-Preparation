package aufgaben.iterablelist;


public class TestMyList {

	public static void main(String[] args) {
	
		MyList list = new MyList();
		System.out.println("0. size : " + list.size()); 	// 0 
		
		list.add("E1");
		list.add("E2");
		list.add("E3");
		list.add("E4");
		list.add("E5");
		
		try {
			list.add(null); 								// Fehler:  Element darf nicht null sein.
		} catch (IllegalArgumentException e) {
			System.out.println("1.a.  Fehler : " + e.getMessage()); 			 
		}
		
		System.out.println("2.  size : " + list.size());		// 5
		
		System.out.println("3.  get index at 3 =  " + list.get(3));		// E4		
		
		try {
			System.out.println("4.a. get index at 8 : " + list.get(8)); // Fehler:  Die Position 8 ist noch nicht belegt  
		} catch (IllegalStateException e) {
			System.out.println("4.b. Fehler : " + e.getMessage()); 			 
		}
		  
		list.add("E6");
		list.add("E7");
		list.add("E8");
		list.add("E9");
		list.add("E10");
		
		System.out.println("5. size : " + list.size());		// 10
		
		try {
			list.add("E11"); 							    // Fehler: Kein Platz mehr
		} catch (IllegalStateException e) {
			System.out.println("6.b Fehler : " + e.getMessage()); 			 
		}
		
		
		try {
			System.out.println("7.a get Index -1: " + list.get(-1)); // Fehler:  Ungültiger Index: -1
		} catch (IndexOutOfBoundsException e) {
			System.out.println("7.b Fehler : " + e.getMessage()); 			 
		}

		System.out.print("\n***ForEach \n");
		for (String element : list) {
	         System.out.print(element + " ");  // E1 E2 E3 E4 E5 E6 E7 E8 E9 E10
	    }

	}

}
