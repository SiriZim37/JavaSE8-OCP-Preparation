package vererbung;


class MyClass {
	static int v0;
	
	/*
	 * statische Konstanten müssen manuell spätestens im
	 * statischen Init-Block initialisiert werden
	 */
//	static final int K0; // cf: muss manuell initialisiert werden
	
	static final int K1 = 1;
	
	static final int K2;
	static final int K3 = 3;
	
	static {
		K2 = 2;
		// K3 = 33; // bereits initialisiert
	}
	
//	static final int K4; // cf: nicht initialisiert
//	static void init() {
//		K4 = 4;			 // cf: Zuweisung in eine Konstante
//	}

	
	/*
	 * Instanz-Konstanten müssen spätestens im Konstruktor
	 * manuell initialisiert werden
	 */
	int var0; // Variable
	
//	final int c1; // cf: muss manuell initialisiert werden
	
	final int c2 = 2;
	
	final int c3;
	
	//init-Block (wird in Konstruktoren integriert)
	{
		c3 = 3; 
	}
	
	final int c4;
	
	// Konstruktor
	MyClass() {
		// c3 = 33; // cf: bereits im init-Block initialisiert
		c4 = 4;
	}
	
	MyClass(int x) {
		this(); // <- initialisiert alle Attribute
	}
	
	MyClass(String s) {
		c4 = 44;
	}
}

public class B19_KonstantenInitialisieren {
	/*
	 * Wo darf man statische Konstanten initialisieren?????
	 * 
	 * 	1. Statische Konstanten können direkt bei der Deklaration in der Klasse 
	 * 	   oder in einem statischen Initialisierungsblock initialisiert werden.
	 * 	
	 * 	   public class MeineKlasse {
			    public static final int MEINE_STATISCHE_KONSTANTE;
			
			    static {
			        MEINE_STATISCHE_KONSTANTE = 10; // oder komplexere Berechnungen
			    }
			}
	 * 
	 *  Wo darf man Objekt-Konstanten initialisieren????
	 *  
	 *  2. Objekt-Konstanten können direkt bei der Deklaration in der Klasse 
	 *    oder im Konstruktor initialisiert werden.
	 *    
	 *    public class MeineKlasse {
			    public final int MEINE_OBJEKT_KONSTANTE;
			
			    public MeineKlasse(int wert) {
			        MEINE_OBJEKT_KONSTANTE = wert;
			    }
			}
	 */
	public static void main(String[] args) {

	}

}

