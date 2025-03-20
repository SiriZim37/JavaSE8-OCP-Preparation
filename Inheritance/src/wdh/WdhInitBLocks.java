package wdh;


class MyTier {
	static { System.out.print("a "); } 
	
	MyTier() {
		// super();
		// {
		//    System.out.print("f ");
		// }
		System.out.print("d "); 
	};
	
	{ 
		System.out.print("f "); 
	}
}

class MyHund extends MyTier {
	static { System.out.print("c "); }
	
	{ 
		System.out.print("e "); 
	}
	
	MyHund() { 
		this(12); 
	}
	MyHund(int x) {
		// super();
		// {
		//    System.out.print("e ");
		// }
		System.out.print("g "); 
	}
}


public class WdhInitBLocks {
	/*
	 * Klasse WdhInitBlocks wird geladen
	 * 
	 * 	Ausgabe: b
	 * 
	 * main startet
	 * 
	 * 	Ausgabe: m
	 * 
	 * Klasse MyHund (aber dafür zuerst MyTier) wird geladen
	 * 
	 * 	Ausgabe: a
	 * 	Ausgabe: c
	 * 
	 * Das neue MyHund-Objekt wird mit dem Konstruktor initialisiert:
	 * 
	 *  MyHund() {
	 *  	MyHund(int x=12) {
	 *  		MyTier(){
	 *  			{
	 *  				Ausgabe f
	 *  			}
	 *  			Ausgabe d
	 *  		}
	 *  		{
	 *  			Ausgabe e
	 *          }
	 *          Ausgabe g
	 *      }
	 *  }
	 */
	public static void main(String[] args) {
		
			System.out.print("m "); 
			new MyHund();  // Super aufrufen 
		}
		
	// beginn bevor Main Methode bearbeitet.
	static { System.out.print("b "); }  
}
