package basic;


public class Switch {

	public static void main(String[] args) {


		String s = "a"+"b";
		
		StringBuilder sb = new StringBuilder("ab");
		
		final String k2 = "ab";	// Compilerzeit-Konstante
	
		final String k3;	  // Laufzeit-Konstante
		k3 = "b";
		
		final String k4 = get(); // Laufzeit-Konstante
		
		String v = "d"; // Variable
		
		
//		switch (s) {	// ok 
//		switch (sb) {	// cf
//		switch (sb.toString()) {	// ok : String		
		switch ("ab") {	// ok
			case "":	// ok : Literal
//			case k1:
			case k2:	// ok : with final	
//			case k3:
//			case sb:
//			case v:
//			case k4:    // only final or constant
			break;

		default:
			break;
		}

	}
	static String get() {
		return "c";
	}

}
