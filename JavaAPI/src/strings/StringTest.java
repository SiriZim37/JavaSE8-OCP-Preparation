package strings;

public class StringTest {

	public static void main(String[] args) {
		// String-Objekte, die mit einem Konstruktor erzeugt werden, leben im Heap
		String s1 = new String("Java");
		String s2 = new String("Java");
		System.out.println("s1 == s2: " + (s1 == s2)); // false
		System.out.println("s1.equals(s2): " + s1.equals(s2)); // true
	
		// String-Objekte, die über ein Literal erzeugt werden, 
		//leben im sogenannten String-Pool, 
		//einem eigenen Speicherbereich in Java für Strings
		
		String s3 = "Java";
		String s4 = "Java";
		String s5 = "java";
		System.out.println("s3 == s4: " + (s3 == s4)); // true
		System.out.println("s3.equals(s4): " + s3.equals(s4)); // true
		System.out.println("s3.equals(s5): " + s3.equals(s5)); // true
		System.out.println("s3.equalsIgnoreCase(s5): " + s3.equalsIgnoreCase(s5)); // true
		
		// String-Objekte sind immutable (unveränderlich) 
		//=> einaml erzeugt kann der Inhalt eines String-Objekts nicht mehr verändert werden.
		s1.concat(" rules"); // verkettet den übergebenen String mit dem Aufrufer
		System.out.println("s1 = " + s1); // s1 = Java
		s1 = s1.concat(" rules"); // verkettet den übergebenen String mit dem Aufrufer
		System.out.println("s1 = " + s1); // s1 = Java rules
		s1 += " the World!";
		System.out.println("s1 = " + s1); // Java rules the World!
		// Wichtige Methoden
		int length = s1.length();
		System.out.println("Länge von s1: " + length); // Länge von s1: 21
		int index = s1.indexOf("u");
		System.out.println("Position von u von s1: " + index); // 6
		index = s1.indexOf("w");
		System.out.println("Position von w von s1: " + index); // -1
		index = s1.toLowerCase().indexOf("w");
		System.out.println("Position von w von s1: " + index); // 15
		index = s1.toUpperCase().indexOf("W");
		System.out.println("Position von w von s1: " + index); // 15
		char c = s1.charAt(3);
		System.out.println("Zeichen an Indexstelle 3 (Position 4) von s1: " + c); // a
		s2 = " Java rules the World! 	";
		System.out.println("s2 mit Leerzeichzen: " + s2 + ", Servus");
		s2 = s2.trim();
		System.out.println("s2 ohne Leerzeichzen: " + s2+ ", Servus");
		s1 = s1.replace("Java", "C++");
		System.out.println("s1 = " + s1);  // s1 = C++ rules the World!
		 s1 = s1.substring(0, 9);
		// bei substring ist der Startindex inklusive und der Endeindex exklusive
		System.out.println("s1.substring(0, 9): " + s1);  // C++ rules
		s1 = "C++ rules the World!";
		s1 = s1.substring(3);
		System.out.println("s1.substring(3): " + s1);   // rules the World!
		System.out.println("s1.toString(): " + s1.toString()); //  rules the World! : implizit, toString wird immer ausgeführt, wenn eine Refenerenzvariable ausgegeben wird
		s1 = "Maßeinheit";
		System.out.println("s1.toUpperCase: " + s1.toUpperCase()); // MASSEINHEIT
		
		
	}

}
