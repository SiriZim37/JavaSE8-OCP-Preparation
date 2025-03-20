package wdh;

class Himmerlskoerper{
	int x , y ;
	
	String getDisplayKoordinaten() {
		return "[" + x + ", " + y + "]";
	}
}


class Planet extends Himmerlskoerper{
	// Spezielle Planet-Elemte hier
	
	public String toString() {
		return "Planet";
	}

}

class Komet extends Himmerlskoerper{
	// Spezielle Planet-Elemte hier

	public String toString() {
		return "Komet";
	}
}


public class UniverselleKomponenteElemente {

	public static void main(String[] args) {


		
		System.out.println("1.");
		
		Himmerlskoerper p1 = new Planet();
		Planet p2 = new Planet();
		Komet k1 = new Komet();
				// --- Wehlche Argumente für parameter ---
		print(p1); // Himmelskörper <- IS-A - Planet
		print(p2);
		print(k1); //  Himmelskörper <- IS-A - Komet 
		
	}
	
	/*
	 *  Universelle Komponente (für bei. Himmerlskörper)
	 *  mit polymorphischen Aufrufen
	 */
	static void print(Himmerlskoerper param) { // Planet , Komet IS-A Himmerlskorper
		System.out.println(param.toString()   // das Objekt refeenziert , param sucht nacht Objekt >  
				+ ". Position" + param.getDisplayKoordinaten() );
	}

}
