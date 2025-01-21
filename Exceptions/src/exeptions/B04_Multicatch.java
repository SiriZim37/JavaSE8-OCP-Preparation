package exeptions;

import java.util.Random;

public class B04_Multicatch {

	public static void main(String[] args) {

		/*
		 *  Wenn z.B ArtithmeticException und NumberFormatException
		 *  gleich behandelt werden sollen, ist es möglich 
		 *  einen Multicatcg-Block zu erstellen , der NUR die
		 *  BeidenExceptions-Typen abfängt
		 *  
		 */
		
		try {
			methodeMitExc();
		} catch (ArithmeticException |  NumberFormatException e) { // Multicathc	
			System.out.println("Multicatch ( ArithmeticException oder NumberFormatException) hat abgefangen : " + e);
		} catch (IllegalArgumentException e) {	// normaler catch-Block
			System.out.println("spezill die IllegalArgumentException behandeln " + e);
		}

	}
	
	static void methodeMitExc() {
		switch(new Random().nextInt(3)) {
			case 0 : throw new ArithmeticException();
			case 1 : throw new NumberFormatException();
			default : throw new IllegalArgumentException();
		}
	}

}
