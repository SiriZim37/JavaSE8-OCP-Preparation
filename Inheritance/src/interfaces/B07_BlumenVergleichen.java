package interfaces;

import java.util.Arrays;

interface Vergleichbar{

	int vergleicheMit(Vergleichbar obj2);
}



class Blume implements Comparable<Blume>{
	private String name; 
	private int preis;
	
	public Blume( String name , int  preis ) {
		this.name = name;
		this.preis = preis;
	}
	
	@Override
	public String toString() {		
		return  name + "( " + preis +  ")";
	}

	
//	@Override
//	public int vergleicheMit(Vergleichbar obj2) {
//		Blume bA = this;
//		Blume bB = (Blume) obj2 ;
//		return 0;
//	}

	/* 	Comparable-kontrakt
	 * 
	 *  Ergebnis ist negativ , falls this-Element keiner als Argument ist
	 *	
	 *  Ergebnis ist positiv , falls this-Element größer als Argument ist
	 *
	 *	Ergebnis ist 0 , falls this-Element gleich dem Argument ist
	 *
	 *	z.B. b1 = Astra , 90 
	 * 		 b2 = Astra , 120 
	 */
	
	@Override
	public int compareTo(Blume b2) {
		Blume b1 = this;
		
		int result = 0 ;
		// Namen untersuchen :
		result = b1.name.compareTo(b2.name); // Name sortiert ( Größere Name am Ende)
		
		// Falss Namen gleich sind , 
		// Blumen nach Preisen untersuchen.
		if(result == 0 ) {
			 if (b1.preis > b2.preis) {
				 result = 1;
			 } else if (b1.preis < b2.preis) {
				 result =  -1; // Hier sollte -1 zurückgegeben werden, wenn b1.preis kleiner ist als b2.preis
		     } else {
		    	 result =  0;
		     }
		}
		
		return result; 
	}
}

public class B07_BlumenVergleichen {

	public static void main(String[] args) {
	
		Blume b1 = new Blume( "Rose" , 90 );
		Blume b2 = new Blume("Astra" , 120  );
		Blume b3 = new Blume( "Astra" , 90 );
		
		/*
		 *  Aufgabe : größere Blume finden.
		 *  Falls die Blumen gleich sind , eine davon nehmen (egal welche)
		 */
		Blume bMax ;
		int result = b1.compareTo(b2);
		if( result > 0 ) {
			System.out.println("b1 ist gßößer als b2");
			bMax = b1;
		}else if( result < 0 ) {
			System.out.println("b1 ist gßößer als b2");
			bMax = b1;
		}else {
			System.out.println("b1 ist gleic b2");
			bMax = b2;
		}
		
		System.out.println("max :" + bMax);
		
		System.out.println("*** Sortieren ");
		/*
		 * Diese Aufgabe (größere Blume aus zwei zu finden)
		 * löst immer wieder die sort-Methhode :
		 */
		Blume[] arr = {
				b1 ,
				b2 ,  
				b3 ,  
				new Blume(  "Astra"  , 65)
				
		};
		
		System.out.println("Vorher : " + Arrays.toString(arr));
		Arrays.sort(arr);
		System.out.println("Nacher : " + Arrays.toString(arr));
		
		

	}

}
