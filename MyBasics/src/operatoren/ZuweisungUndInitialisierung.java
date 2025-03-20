package operatoren;

public class ZuweisungUndInitialisierung {

	public static void main(String[] args) {
		
		/*
		 * Initialisierung:
		 * 
		 * Kopieren in eine neue Variable (Konstante), 
		 * die in derselben Anweisung entsteht (deklariert wird)
		 */
		int x1 = 12;
		
		/*
		 * Zuweisung:
		 * 
		 * Kopieren in eine bereits existierende Variable
		 */
		x1 = 12;
		
		/*
		 * Deaklaration einer lokalen Variable ohne Initialisierung:
		 */
		int x2;
		
		x2 = 12; // Zuweisung
		
		/*
		 * Meistens ist der Unterschied zw. Initialisierung und Zuweisung egal.
		 * 
		 * Unterschied: 
		 * 		Initalisierung ist eine Anweisung (Statement)
		 * 		Zuweisung ist ein Ausdruck (Expression)
		 */
		//System.out.println( int x3 = 12 ); // cf: int x3 = 12 ist keine Expression
		System.out.println( x2 = 777 ); // x2 = 777 liefert x2 zurück
		

		/*
		 * Exam:
		 * 
		 * s. Bsp. ZuweisungUndCasting
		 */
		
	}

}
