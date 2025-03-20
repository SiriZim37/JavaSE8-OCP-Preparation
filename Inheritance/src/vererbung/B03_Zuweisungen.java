package vererbung;

class Himmelskoerper{}

class Komet extends Himmelskoerper{ }
class Asteroid extends Himmelskoerper{}


public class B03_Zuweisungen {

	/*
	 * Zuweisung von Referenzen kompiliert NUR , 
	 * wenn zwischen , ihren Typen ( von rechts nach links gelesen) 
	 * die IS-A-Beziehung existiert. // มีความสัมพันธ์ IS-A อยู่แล้ว
	 */
	
	public static void main(String[] args) {
		
		Himmelskoerper h1 = null ; 
		Komet k1 = null ;
		Asteroid a1 = null;
		
		h1 = k1 ; // Himmerlskorper <- IS-A <- Komet
//		k1 = h1 ; // cf: Komet  <- IST-KEIN <- Himmerlskorper
//		a1 = k1 ; // cf: Asteroid  <- IST-KEIN <- Komet
		
		h1 = new Komet(); // Himmerlskorper <- IS-A <- Komet
//		k1 = h1; // cf: Komet  <- IST-KEIN <- Himmerlskorper
		
		Object obj = k1; // Object <- IS-A <- Komet
		obj = h1; // Object <- IS-A <- Himmelskörper
		obj = a1; // Object <- IS-A <- Asteroid

	}

}
