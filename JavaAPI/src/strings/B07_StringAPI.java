package strings;

import java.time.LocalDate;
import java.util.Arrays;

public class B07_StringAPI {

	public static void main(String[] args) {
		
		test_valueOf();
		test_Constructors();
		test_charAt();
		test_length_isEmpty();
		test_toUppercase_toLowerCase();
		test_EndsWith_StartsWith();
		test_equals_equalsIgnoreCase();
		test_indexOf_lastIndexOf();
		test_replace();
		test_subString();
		test_weitere();
		
	}
	
	static void test_weitere() {
		System.out.println("\n*** weitere Methoden");
		System.out.println("Java contains av: " + "Java".contains("av"));
		
		String s = "Ja";
		s.concat("va");
		System.out.println("s: " +s); // Ja
		s = s.concat("va");
		System.out.println("s: " +s); // Java
		String result = String.format("%s = (%.2f)", "Preis", 22.578);
		System.out.println("result: " + result); // Preis = (22,58)
		
		String s2 = "\nJava\n \t";
		System.out.println("" + s2.trim());
		System.out.println("" + s2.length());
		
	}
	
	/*
	 *  String substring(int from)
	 *  String substring(int from , int toExclusive)
	 */
	static void test_subString() {
		System.out.println("\n*** subString ");
		
		String s = "Die Java ist toll!";
		String s2 = s.substring(4);
		System.out.println("s2: " + s2); // Java ist toll!
		
		String s3 = s.substring(4,8);
		System.out.println("s3: |" + s3 + "|");  // |Java|
		
	}
	
	
	/*
	 * replace(char , char)
	 * replace(CharSequnce , CharSequnce)
	 */
	static void test_replace() {
		System.out.println("\n*** replace ");
		
		String s =  "Die  Sprache C# Ist toll!";
		
		s= s.replace('I', 'i');
		System.out.println( s );// Die  Sprache C# ist toll!
		
		s= s.replace("C#", "Java");  // Die  Sprache Java ist toll! 
		System.out.println( s ); 
		
	}
	
	
	/*
	 * 	int indexOf
	 * 	int lastIndexOf
	 * 
	 * Liefern die Position (oder -1 , wenn nichts gefunden wird)
	 */
	static void test_indexOf_lastIndexOf() {
		System.out.println("\n*** indexOf ");
		
		String s = "Java ist eine Insel und eine Java Sprache";
		
		System.out.println("indexOf a " + s.indexOf('a'));	// 1
		System.out.println("indexOf x " + s.indexOf('x'));	// -1
		
		System.out.println("indexOf a ab dem Index 2 " + s.indexOf('a' , 2));	// 3
		System.out.println("indexOf a ab dem Index 1 " + s.indexOf('a' , 1));	// 1
		
		System.out.println("indexOf C++: " +  s.indexOf("C++")); //-1
		System.out.println("indexOf ein: " +  s.indexOf("ein")); // 9
		System.out.println("indexOf ein ab dem Index 10  : " +  s.indexOf("ein" , 10 )); // 24
		
		
		System.out.println("\n*** lastIndexOf ");
		
		System.out.println("lastIndexOf C++: " +  s.lastIndexOf("C++")); // -1
		System.out.println("lastIndexOf ein: " +  s.lastIndexOf("ein")); // 24
		System.out.println("lastIndexOf ein fromIndex = 24 : " +  s.lastIndexOf("ein" , 24));  //24
		System.out.println("lastIndexOf ein fromIndex = 23 : " +  s.lastIndexOf("ein" , 23));  // 9
		System.out.println("lastIndexOf ein fromIndex = 8 : " +  s.lastIndexOf("ein" , 8));  // -1
	}
	
	
	static void test_equals_equalsIgnoreCase() {
		System.out.println("\n*** equalsIgnoreCase ");
		/*
		 * Bitte den Vergleichsoperator für Refenzen nicht benutzen, 
		 * wenn Sie Objekte nach Inhalten vergleichen möchten!!
		 */
		String s1 = "mo";	// im String-Pool
		String s2 = "mo";	// im String-Pool
		System.out.println("s1==s2 : " + (s1==s2));	// true
		// s1 specichert in Addresse gleiche s2 ( Im String Pool)
		
		String s3 = "MO".toLowerCase();	// String-Objekt
		System.out.println("s1==s3 : " + (s1==s3));	 // false : Referenze vergleichen :
													 // Unterschideliche Addresse aber Inhalt sind gleich
		
		System.out.println("s1.equals(s3) : " + (s1.equals(s3))); // true
		
		String s4 = "di=2";
		String s5 = "DI=2";
		System.out.println("s4.equalsIgnoreCase(s5) : " + s4.equalsIgnoreCase(s5)); // true
		
	}
	
	/*
	 * boolean endWith(String)
	 * boolean startWith(String)
	 * 
	 * boolean startWith(String , int ) <- unwahrscheinlich in der prüfung
	 * 
	 */
	static void test_EndsWith_StartsWith() {
		System.out.println("\n*** endsWith ");
				//  01345678
		String s = "Es gibt Java-Insel und Java-Sprache";
		System.out.println("s = " + s);
		System.out.println("endsWith Insel(?) " + s.endsWith("Insel")); // false
		System.out.println("endsWith Sprache(?) " + s.endsWith("Sprache")); //true
		System.out.println("endsWith sprache(?) " + s.endsWith("sprache")); //false
		
		System.out.println("\n*** startsWith ");
		System.out.println("startsWith Java(?) " + s.startsWith("Es gibt Java-Insel und Java-Sprache" )); // false
		System.out.println("startsWith Java ab Intdex 3 (?) " + s.startsWith("Java" ,3 )); // false
		System.out.println("startsWith Java ab Intdex 8 (?) " + s.startsWith("Java" ,8 )); // true
		
		
	}
	
	/*
	 * 	String toUppercase()
	 *  String toLowerCase()
	 */
	static void test_toUppercase_toLowerCase() {
		System.out.println("\n*** toUppercase , toLowerCase");
		String s = "Ball";
		System.out.println(s.toUpperCase()); // BALL
		System.out.println(s.toLowerCase()); // ball
	
	}
	
	/*
	 * 	int length()
	 *  boolean isEmpty()
	 */
	static void test_length_isEmpty() {
		System.out.println("\n*** isEmpty ");
		String s1 = "";
		System.out.println("s1.length(): " + s1.length());	// 0
		System.out.println("s1.length(): " + s1.isEmpty());	// true
		
		String s2 = "abc";
		System.out.println("s2.length(): " + s2.length());	// 3
		System.out.println("s2.length(): " + s2.isEmpty());	// false
		
		/*
		 *  Exam : 
		 *  
		 *  Array hat das Attribut length , 
		 *  String hat die Methode length()
		 */
		
		int[] arr = { 1 , 2, 3 };
		System.out.println("arr: " + arr.length);	//3
//		System.out.println("arr: " + arr.length());	// cf
		
		String s = " ";
//		System.out.println("s: " + s.length);	// cf
		System.out.println("s: " + s.length());    //1
	}
	
	
	static void test_charAt() {
		System.out.println("\n*** CharAt ");
				//  01 234
		String s = "ja\nva";
		System.out.println( "charAt(3) = " + s.charAt(3));
		try {
			System.out.println( "charAt(5) = " + s.charAt(5)); // ok : StringIndexOutOfBoundsException
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println(e.getLocalizedMessage()); // Index 5 out of bounds for length 5
		}
	}
	
	/*
	 * 	Praxis : lieber auf Konstruktoren der Klasse String verzichten
	 * (wenn es )
	 * 	Exam : folgende Konstruktoren sind evtl. zu sehen :
	 */
	static void test_Constructors() {
		System.out.println("\n*** Konstruktoren ");
		new String();
		String s2 = new String("java");
		System.out.println("s2 =" + s2);
	}
	
	
	/*
	 * 	statische ValueOf-Methoden.
	 * 
	 * 	Exam : für jedes Argument-Typ gibt es eine es eine valueOf-Methode
	 */
	
	static void test_valueOf() {
		System.out.println("*** viele statische valueOf überladen");
		
		String s1 = String.valueOf(false);	
		System.out.println("s1 = " + s1 );	// false
		
		String s2 = String.valueOf(LocalDate.of(2013, 2, 22));
		System.out.println("s2 = " + s2);	// 2013-02-22
		
		char[] arr = { 'j' , 'a' , 'v' , 'a'};
		System.out.println("arr = " + arr);	// [C@7c53a9eb		
		String s3 = String.valueOf(arr);
		System.out.println("arr = " + s3);	//java
		
		String s4 = Arrays.toString(arr);
		System.out.println("Arrays.toString(arr) " + s4);	// [j, a, v, a]
	
	}

}
