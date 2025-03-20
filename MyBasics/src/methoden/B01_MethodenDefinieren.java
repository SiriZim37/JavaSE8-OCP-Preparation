package methoden;


public class B01_MethodenDefinieren {

	/*
	 * Methode = Algorithmus mit einem Namen
	 * 
	 * Elemente einer Methode:
	 * 
	 * 		hello	:		Name
	 * 		()   	:		Liste der Parameter
	 * 		void	:		Rückgabetyp
	 * 
	 * 		{}		:		Rumpf (Körper) der Methode
	 * 		static	:		Bedeutet, dass es keine Objekt-Methode ist
	 */
	
	/*
	 * Definition einer Methode:
	 */
	static void hello() {
		System.out.println("-------------------");
		System.out.println("----- hello -------");
		System.out.println("-------------------");
	}
	
	public static void main(String[] args) {
		System.out.println("main aus B01");
	}

}
