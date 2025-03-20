package strings;

public class StringBuilderTest {

	public static void main(String[] args) {

		/*
		 * StringBuilder-Objekte sind mutable , können also nach der Erzeugung weiter verändert werden
		 * Die KLasse StringBuilder (seit Java 5) hat dieselben Methoden wie die Klasse StringBuffer
		 * Die Methoden des StringBuffer sind synchronisiert, d.h Thred-sicher. 
		 * Die Methoden des StringBuilder sind das nicht. Daher ist der StringBuilder als der StringBuffer
		 */
		
		StringBuilder sb = new StringBuilder("Java");
		sb.append(" rules");
		System.out.println("sb = " + sb.toString()); // sb = Java rules
		sb.append(" the").append(" World!");
		System.out.println("sb = " + sb) ; // sb = Java rules the World!
		sb.reverse();
		System.out.println("sb = " + sb) ; // sb = !dlroW eht selur avaJ
		sb.reverse();
		System.out.println("sb = " + sb) ; // sb = Java rules the World!
		sb.delete(5, 11);	// Startindex inklusive, Endeindex exklusive
		System.out.println("sb = " + sb) ;  // Java the World!
		sb.insert( 0 , "C++ and ");
		System.out.println("sb = " + sb) ; // sb = C++ and Java the World! 
		sb.insert( 13 , "rule ");
		System.out.println("sb = " + sb) ; // sb = C++ and Java rule the World!
		
		String s = sb.toString();
		System.out.println("s = " + s); // s = C++ and Java rule the World!
		
		sb = new StringBuilder();
		s = sb.append("Java ").append("the world       ").insert(5, "rules ").delete(11, 15).toString().trim();
		System.out.println("sb = " + s + ", Servus."); // sb = Java rules world, Servus.
	}

}
