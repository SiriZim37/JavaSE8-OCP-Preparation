package strings;

public class B06_Immutable {

	public static void main(String[] args) {
	
		String s = "Java";
		s.toUpperCase();	// erzeugt das nene String-Objekt
							// liefert seine Referenz zurück. 
							// Es wird nicht kopiert und kein Referenz zurückzuliefert.
		System.out.println(s);	// java
		
		s = s.toUpperCase();	// erzeugt das nene String-Objekt und kopiert in Referenz
		System.out.println(s);	// JAVA
		

	}

}
