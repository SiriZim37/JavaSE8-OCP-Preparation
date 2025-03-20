package enums.wdh;

import java.util.Arrays;

enum Hersteller{
	
	VW(2000) , 	 // static final Hersteller VM = new Hersteller(2000)
	OPEL() ,	 // static final Hersteller OPEL = new Hersteller()
	AUDI , 	 // static final Hersteller AUDI = new Hersteller()
	MERCEDES(10000)  	 // static final Hersteller AUDI = new Hersteller(10000)
	
	; // eigener Code ist nach dem Semikolon möglich
	
	private static Hersteller[] reversedValues = { AUDI , OPEL , VW} ;
	
	public static Hersteller[] reversed() {
		return Arrays.copyOf(reversedValues, reversedValues.length);
	}
	
	private int maxPreis = 5000;
	
	public int getMaxPreis() {
		return maxPreis;
	}
	/*
	 * Alle Konstruktoren müssen private sein (implizit oder explizit)
	 */
	
	private Hersteller(int MaxPreis) {
		this.maxPreis = maxPreis;
	}
	private Hersteller() { } // der Konstrukto ist implizit private
}

public class B05_eigenerCodeInEnum {

	public static void main(String[] args) {
		
		for (Hersteller modell : Hersteller.reversed()) {
			System.out.println( modell + " , maxPreis : " + modell.getMaxPreis());
		}

	}

}
