package vererbung;

// Bassis Klasse
class Sportart{
	String name = "my name";
	int id = 12 ;
	
	@Override
	public String toString(){
		return "SportArt";
	}
}

//abgeleite klaass
class Laufen extends Sportart{
	/*
	 * 	this und super sind nur in Instanzmethoden (und Konstruktoren) gültig
	 */
	void instanceMethode() {
		this.toString();
		super.toString();
	}
	static void staticMethode() {
//		this.toString();  // cf : keine this im statische Kontext
//		super.toString(); // cf : keine super im statische Kontext
	}
	
	/*
	 * this und super können für KOnstruktorenaufrufe verwendet werden
	 * (als 1. Anweißung in einem Konstruktor)
	 */
	Laufen(){
		super(); // Aufruf vom Konstruktor Sportart() !!! 
	}
	Laufen(int x){
		this(); // Aufruf vom Konstruktor Laufen() !!!
	}

	
	/*
	 * this und super bedeuten desselbe bein Zugriff auf ein geerbtes Attribut
	 * (änlich)
	 */
	void testZugriffAufName() {
		System.out.print(this.name); // my name
		System.out.print(super.name); // my name
	}
	
	/*
	 * Nicht empfohlen : 
	 * Abgeleitete Klasse darf ein eigenes Objekte-Attribut haben , 
	 * der genauso wie ein geerbtes Objekte-Attribut.
	 * 
	 * In diesem Fall kann man mit this und super die Attribute unterscheiden.
	 */
	String id ="L101";
	
	void testZugriffAufID() {
		System.out.println(id); 		// "L101" desselbe wie this.id 
		System.out.println(this.id);     // "L101" 
		System.out.println(super.id);    // 12 <<-- abgedekte Attribut finden. 
	}
	
	
	/*
	 * Wenn die abgeleitete Klasse eine Instanz-Methode überschreibt,
	 * kann die abgeleitete Klasse zwischen der überschriebenen Methode (mit super)
	 * und der überscheibenden Methode (mit this) unterscheiden.
	 */	
	@Override
	public String toString() {	
		return "Laufen"; 
	}
	
	void testToStringAufruf() {
		System.out.println(toString()); 	    // Laufen , desselbe wie this.roString() 
		System.out.println(this.toString());	// Laufen ,
		System.out.println(super.toString());	// SportArt ,
	}
	
	
	
} // end of class laufen

public class B07_this_und_super {

	public static void main(String[] args) {
		
		new Laufen().testToStringAufruf();

	}

}
