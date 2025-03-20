package exceptions.wdh;

public class B11_finaly_Block {
	
	/*
	 * nach dem try-Bloock muss entweder catch-Block
	 * oder finally-Block stehen
	 */
	public static void main(String[] args) {
		
//		try {
//				// cf : catch oder finally fehlt
//		}
		
		try {
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			
		}finally {
			
		}
		
		/*
		 * finally Block muss nach catch-Blöcken stehen
		 */
		try {
			
		}catch (Exception e) {
			
		}finally {
			
		}
		
		/*
		 * finally-Block läuft immer ,wenn sein der try-Block beendet wird
		 * 
		 * Ausnahmen : 
		 * 			- Stromausfall 
		 * 			- System.exit
		 * 
		 * wenn ein catch-Block aktiviert wird , läuft der finally-Block danach
		 * 

		 */
		try {
			System.out.println("1. try ");
		}finally {
			System.out.println("1. finally");
		}
		
		/*
		 * Wenn ein catch-Block aktiviert wird, läuft der finally-Block danach
		 */
		try {
			System.out.println("2. try ");
			System.out.println(5/0); // ArithmeticException
		}catch (ArithmeticException e) {
			System.out.println("2. catch");
		}finally {
			System.out.println("2. finally");
		}
		/*		 
		 * *Bein einer Exception im try-Block , für die es keinen
		 * catch-Block gibt , läuft der finally-Block, bevor die Exception
		 * weiter propagiert wird.
		 * 
		 */
		try {
			System.out.println("3. try ");
			System.out.println(5/0); // ArithmeticException
		}catch (NullPointerException e) {
			System.out.println("3. läuft nicht");
		}finally {
			System.out.println("3. finally");
		}
		// Ausgabe : compile und Danach wird die ArithmeticException nicht abgefangen,
		// was zum Programmabsturz führt und den Stacktrace mit der Fehlermeldung ausgibt.
		
		
		
	}// end of main

}
