package wdh.methoden;

public class RichtigeUeberladenenMethodeFindenRegeln {


	/*
	 * Suche nach der richtigen überladenen Methode.
	 * 
	 * Argumente ist Primitiv
	 * 
	 * 1. Argumenttyp und Parametertyp sind gleich
	 * 
	 * 2. Widening
	 * 			byte -> short -> int -> long -> float -> double
	 * 
	 * 3. Autoboxing
	 * 			Wrapper-Klasse-parameter gesucht (oder Basistyp davon)
	 * ...
	 * 
	 * 4. Vorherige Schritte für Varargs-Methoden durchgehen
	 */
	
	/*
	 * Suche nach der richtigen überladenen Methode
	 * 
	 * Argument ist eine Referenz.
	 * 
	 * 1. Argumenttyp und Parametertyp sind gleich
	 * 
	 * 2. Parameter ist Basistyp
	 * 
	 * 3. Autounboxing (und Widening wenn nötig)
	 * 	  bei Wrapper-Klassen-Argumenten
	 * 
	 * 4. Vorherige Schritte für Varargs-Methoden durchgehen
	 */
	
	public static void main(String[] args) {

		
		Float x = null; 
		m(x);
		
//		mX(x); // cf : The method m(String[]) is ambiguous 
		
		Integer x2 = null; 
		mXX(x2);	// java.lang.NullPointerException
		
	}
	
//	static void m(String x) { System.out.println("String");}
	
//	static void m(int x) { System.out.println("int");}
	static void m(float x) { System.out.println("float");}
	static void m(Integer x) { System.out.println("Integer");}
	static void m(Number x) { System.out.println("Number");}
	static void m(double x) { System.out.println("double");}
	static void m(byte x) { System.out.println("byte");}
	static void m(int... x) { System.out.println("int...");}
	static void m(String... x) { System.out.println("String...");}
	
	
	static void mX(Comparable<String> x) { System.out.println("Comparable<String>");}
	static void mX(CharSequence x) { System.out.println("CharSequence");}
	
	
	static void mXX(String x) { System.out.println("String");}	
	static void mXX(int x) { System.out.println("int");}
	static void mXX(double x) { System.out.println("double");}
	


}
