package methoden;

public class B02_MethodenAufrufen {

	/*
	 * Methode main definieren:
	 */
	public static void main(String[] args) {
		
		/*
		 * Eine statische Methode kann mit dem Klassennamen
		 * aufgerufen werden. 
		 * 
		 * 1. Ausnahme: innerhalb der Klasse, in der 
		 * die statische Methode definiert ist, kann man 
		 * den Klassennamen weglassen.
		 * 
		 * 2. Ausnahme: statische Import-Anweisung (wird später erklärt)
		 */
		
		B01_MethodenDefinieren.hello();
		B01_MethodenDefinieren.hello();
		B01_MethodenDefinieren.hello();
		
//		hello(); // cf: Compiler findet keine Methode hello 
				 //     in der umschließenden Klasse

		Math.random();
		
//		random(); // cf: Compiler findet keine Methode hello
				  //     in der umschließenden Klasse
		
		B02_MethodenAufrufen.printNumbers();
		printNumbers(); // Ausnahme (die Methode gibt es in dieser Klasse)
		
	} // end of main
	
	/*
	 * eine weitere Methode definieren
	 */
	static void printNumbers() {
		System.out.println("1, 2, 3, 4, 5");
	}

}
