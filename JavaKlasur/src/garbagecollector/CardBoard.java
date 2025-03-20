package garbagecollector;


public class CardBoard {

	Short value = 200;
	
	CardBoard go(CardBoard cb) {
		cb = null;
		return cb;
	}
	
	public static void main(String[] args) {

		CardBoard c1 = new CardBoard();	  // 1 object  + 1 object from Short Object
		CardBoard c2 = new CardBoard();	  // 1 object  + 1 object from Short Object

		// Now have 4 Object 
		
		CardBoard c3 = c1.go(c2);	// objekt von ref c1 will removed after 
									// c2 ist nur parameter point to object (does not affect the object that c2 references).
		c1 = null;
		
		// The first CardBoard object and its associated Short value object are eligible
		// for garbage collection. Hence, 2 objects are eligible for garbage collection.
		
		
	
		
	}


}
