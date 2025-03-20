package exceptions.wdh;

public class B12_StackOverflowError {

	public static void main(String[] args) {
		try {
			m(1);		// StackOver
		} catch (StackOverflowError e) { // extends Error
			System.out.println(e);
		}

	}
	/*
	 * 	m(x=1){

	 * 		Ausgabe : 1 
	 * 		
	 * 		m(x' = x) { x wird nach dem Lesen inkrementiert.
	 * 			
	 * 			Ausgabe : 1 
	 * 	
	 * 				m(x' = x) { x wird nach dem Lesen inkrementiert.
	 * 				
	 * 					Ausgabe : 1 
	 * 					m(x' = x) { x wird nach dem Lesen inkrementiert.
	 * 						...
	 * 					}
	 * 				}
	 * 		}  
	 * }
	 * 
	 */
	static void m(int x) {
		if(x>3) {
			return;
		}
		System.out.println(x);
		m(x++); // bug hier !!! 
				// Post-Increment : Der Inkrementvorgang wird ausgeführt, 
				// nachdem der Wert der Variablen im Ausdruck verwendet wurde.
	}

}
