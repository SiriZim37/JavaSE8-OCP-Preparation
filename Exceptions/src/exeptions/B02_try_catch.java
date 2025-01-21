package exeptions;

import java.io.IOException;

public class B02_try_catch {

	public static void main(String[] args) {

		/*
		 * 	Nach dem try-Block muss catch oder finally stehen
		 */
//		try {
//	
//		}		// cf
		
		
		try {
			
		} finally {
			
		}
		
		try {
			
		} catch (ArithmeticException e) {
			e.printStackTrace();
		}
		
		/*
		 *  Beachten Sie auch das Beispiel mit try-Block-Analyse
		 */
//		try {
//			
//		} catch (IOException e) {	// cf : diese checked-Exeption ist unmöglich
//			e.printStackTrace();
//		}
		
		try {
		
		} catch (Exception e) {	// ok : das Exception auch unchecked
								// Exceptions referenziereb kann
			e.printStackTrace();
		}
		
	}

}
