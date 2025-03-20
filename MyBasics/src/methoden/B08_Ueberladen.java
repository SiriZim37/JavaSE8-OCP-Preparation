package methoden;

public class B08_Ueberladen {

	/*
	 * Überladen:	mehrere Methoden mit demselben Namen
	 * 				in derselben Klasse definieren (deklarieren).
	 * 
	 * Methoden in einer Klasse müssen sich nach Signaturen unterscheiden.
	 * 
	 * Signatur:	Methoden-Name + Liste der Parametertypen 
	 */
	public static void main(String[] args) {
		System.out.println();
		System.out.println("moin");

		System.out.println();
		m3(null);
		
	}
	
	static void m1() {}
//	static void m1() {} // cf: es gibt bereits m1()

	static void m2(int x) {}
//	static void m2(int param) {} // cf: es gibt bereits m2(int)
	
	static void m3(int x) {  System.out.println("int"); }
	static void m3(byte x) { System.out.println("byte");}
	static void m3(String x) { System.out.println("String");}
	static void m3(int x, String y) {System.out.println("int");}
	static void m3(float x) {System.out.println("float");}
	static int m4() { return 1; }
	static void m3(Object o) { System.out.println("Object"); }
//	static void m4() {}			 // cf: es gibt bereits m4()
}
