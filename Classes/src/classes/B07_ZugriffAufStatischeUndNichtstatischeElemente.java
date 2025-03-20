package classes;


class Auto{
	
	static int instanceCount; 
	
	static int getMinBaujahr() { return 1880; }
	
	// 2 statische 
	
	
    // Nicht statische : sein Objekt
	int baujahr; // Erst muss das Auto Objekt erzuegen und dann kann man baujahr rufen
	
	public Auto() {
		instanceCount++;
		this.baujahr = baujahr;
	}
	
	
	public String toString() {   
		return "Auto. Bj: " + baujahr; 
	}
	
	
	 
}



public class B07_ZugriffAufStatischeUndNichtstatischeElemente {

	public static void main(String[] args) {
		float rotanteil = 1.0f;

		
		
		Auto a1 ;  // Auto-Objekte? >>>Es gibt keine OBJEKT in main Methode :: es ist nur reserviert
		
		/*
		 *	Auf die statischen Elemente einer Klasse
		 *  kann man mit dem Klassenamen zugreifen. 
		 */
		
		System.out.println("Auto erzeugt :" + Auto.instanceCount);
		
		int minBaujahr = Auto.getMinBaujahr();
		System.out.println("min. Baujagr für das Autos : " + minBaujahr);
		 
		/*
		 * Auf die Objekt-Elemente kann man nur mit der 
		 * Referenz zugreifen , die ein Objekt referenziert.
		 */
//		System.out.print(Auto.baujahr);	// cf : baujahr ist ein Objekt-Attribut
		
		Auto a = null;
//		System.out.print(a2.baujahr); //  Kompliert, aber wirft die NUllpointerException
//									  //diese Referenz kein Objekt referienziert >>> dann kommt null objekt 
//		a2.toString(); 		//Kompliert, aber wirft die NUllPointer  
//							// Der Kompiler übersetzt > a1 kein Objekt referenz 
		a = new Auto();
		System.out.println(a.baujahr); 
		a.toString(); 	
		System.out.println("new Auto().baujahr : " + new Auto().baujahr);
		System.out.println("new Auto().toString : "  + new Auto().toString());

		/*
		 * 
		 * Actung !!
		 * 
		 * In Java kompilieren folgende absolut SINNLOSE Zugriffe :
		 * 
		 * Wenn auf ein statische Element nicht mit dem Klassennamen , 
		 * sondern mit einer Referenz zugriffen wird,
		 * generiert der Compiler eine Warnung,
		 * ersetzt aber dabei den Referenznamen durch den Typ der Referenz.
		 */
		
		System.out.println(a.instanceCount); 
		System.out.println(a.getMinBaujahr()); 
		
		a = null ;
		System.out.println(a.instanceCount); // keine NUllpointerException
		System.out.println(a.getMinBaujahr()); // keine NUllpointerException
		
	}

}
