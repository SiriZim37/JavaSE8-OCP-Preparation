package aufgaben;

public class AufgabeKontrollstrukturenIfAbfrage {
	
	public static final int ROT = 1;  
	public static final int GELB = 2;  
	public static final int GRUEN = 3;  
	
	
	public static void main(String[] args) {
		
		/*
		 * 1 ist rot 
		 * 2 ist gelb 
		 * 3 ist grün 
		 */
		int farbe = GELB;

		if(farbe==ROT) {
			 System.out.println("Rot. Bitte warten");
		} else if(farbe==GELB) {
		    System.out.println("Gelb. Gleich geht es los");
		} else if(farbe==GRUEN) {
		   System.out.println("Grün. Weg frei");
		} else {
			System.out.println("Fehler! Diese Farbe gibt es nicht.");
		}

	} // end of main

}
