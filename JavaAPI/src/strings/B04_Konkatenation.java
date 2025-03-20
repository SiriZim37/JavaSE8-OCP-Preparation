package strings;

public class B04_Konkatenation {

	public static void main(String[] args) {
	//	System.out.println(args.length > 0  || args == null);
		/*
		 * 	- Konkatenation erzeugt normalerweise ein neues
		 * 	  String-Objekt auf dem Heap.
		 * 	  Ausnahme (nicht in der Prüfung) : beide Operanden
		 * 	  sind Compilerzeit-String-Konstanten.
		 */
		
		bsp1();
		bsp2();
		
		/*
		 * 	Konkatenationen in einem komplexen Ausdruck in der Prüfung : 
		 *  von links nach rechts auswerten. !!!! 
		 */
		System.out.println(1 + "2" + 3 ); // 123
//		System.out.println(1 + "2" - 3 ); // cf : "12" - 3 ERROR!
		System.out.println(1 + 2 + "3" ); // 33
		System.out.println(1 + 2 + "3" ); // 33
		System.out.println(1 - 2 + "3" ); // -1 3
		System.out.println("1" + 2 + 3 ); // 123 ( links nach rechts auswerten!! : 1 String + 2 = "12" + 3 = "123") 
		
	}

	static void bsp1() {

		final String s1 = "m";	// Compilerzeit-Konstanzte
		String s2 = s1 + "o"; 	// kein neues String-Objekt auf dem Heap
								// String s2 = "mo"
		
		String s3 = "m" + "o"; 	// kein neues String-Objekt auf dem Heap
							    // String s3 = "mo"
		
	}
	

	static void bsp2() {

		String s1 = "m";
		String s2 = s1 + "o"; 	// +1 String-Objekt
		
	}

}
