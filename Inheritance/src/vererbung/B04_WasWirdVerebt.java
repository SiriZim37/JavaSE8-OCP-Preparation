package vererbung;

class WerkZeug{  // diese Superclass wurd vererbt! , wenn sie nicht PRIVATE!! sind 
	
	public static int MAX_PREIS = 1000; // public constance must Upper Case

	/*
	 * Statische (Klassen-Attribute)
	 */
	static int maxPreis = 1000; 
	
	/*
	 * Instanzvariable (Objekt-Attribute) , wenn sie nicht PRIVATE!! sind 
	 */
	int preis = 42;  // Es gehört nicht zu jeder klammer weil nicht Konstance Variable ist.

	/*
	 * statische Methoden
	 */
	static WerkZeug createWerkzeug() { return new Hammer(); } // instance methode
	
	/*
	 * Instanz-Methoden (Object-Methoden) , wenn sie nicht PRIVATE!! sind 
	 */
	public int getPreis() {
		return preis;
	}
	/*
	 * private Methoden werden nicht vererbt.
	 */

	private static void doStuff() {}
	
	/*
	 * private Methoden werden nicht vererbt.
	 */
	 private void doMoreStuff() {}
	 
	 /*
	  * private Attribute wird es in Objekten von abgeleiteten Typen
	  * geben , aber das Programmieren damit wird in der abgeleiteten.
	  * Klasse nicht möglich sein.
	  */
	 private int id = 12 ;  
	
	 /* 
	  * Konstrukture  : constructor werden nicht vererbt.
	  */
	 
	 WerkZeug() {}
	 WerkZeug(int preis ) { this.preis = preis ; }
}


class Hammer extends WerkZeug{  
	
	/*
	 * wenn die Klasse keine Konstruktur hat , dannn gibt es Default
	 */
	

	public String toString() {
		int x1 = this.preis;
		int x11 = preis;  // this.preis
		
		int x111 = this.getPreis();
		int x1111 = getPreis() ; // this.getPreis
		
		int x2 = Hammer.MAX_PREIS;
		int x22 = maxPreis;  // Hammar.preis
		
		WerkZeug w1 = Hammer.createWerkzeug();
		WerkZeug w11 = createWerkzeug(); // Hammer.createWerkzeug();
		
//		int x3 = this.id	// cf : id ist private!!!! 
//		this.doMoreStuff();  // cf  : wurde nicht vererbt!!.
//		doMoreStuff();	// cf : 
		
		
		return "Hammer. preis = " + preis;
		
	}
	
}

public class B04_WasWirdVerebt {

	public static void main(String[] args) {
	
		System.out.println(WerkZeug.MAX_PREIS);
		WerkZeug w1 =  Hammer.createWerkzeug(); // Beweisung : // WerkZeug <- IS-A <- Hammer
		
//		Hammer.doStuff() :: cf wurde nicht geerbt (ist private in der Klasse WerkZeug )
		
		
		Hammer h1 = new Hammer();
		System.out.println(h1.preis); // abrufen
		System.out.println(h1.getPreis()); // aufufen
//		h1.doMoreStuff() :: cf weil es private Methode
		
		
		
		// Klass Hammarr hat nur den defalut-Konstruktor
		new Hammer();
//		new Hammer(333); // cf : es gibt keinen Konstruktor Hammer(int)
		
	}

}
