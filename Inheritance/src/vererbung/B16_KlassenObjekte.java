package vererbung;


class Display {
	
	// statischer Init-Block
	static {
		System.out.println("Klasse Display wird geladen...");
	}
}



public class B16_KlassenObjekte {

	/*
	 * Class-Objekte sind spezielle Objekte vom Typ 'Class'.
	 * 
	 * Jede Klasse bekommt ihr eigenes einzigartiges Class-Objekt.
	 * 
	 * Die JVM lädt eine Klasse beim ersten Benutzen und erzeugt 
	 * dabei das Class-Objekt der geladenen Klasse.
	 * 
	 * Beim Laden einer Klasse wird der statische Init-Block 
	 * der Klasse ausgeführt.
	 */
	public static void main(String[] args) throws ClassNotFoundException  {
		
		System.out.println("main 1 ");
		
		Display ref; 
		
		System.out.println("main 2 ");
		
		new Display();  // Ausgabe : Klasse Display wird geladen  
						// Klasse Display wird hier zum 1. mal benutzt
						// Die JVM läde die Klasse in das Class-Objekt
		
		System.out.println("main 3");
		new Display(); 
		
		/*
		 * Class-Objekt einer Klasse finden:
		 */
		Class<?> c1 = Display.class; // Möglichkeit 1
		
		ref = new Display();
		Class<?> c2 = ref.getClass(); // Möglichkeit 2
		
		System.out.println("c1 == c2: " + (c1==c2)); // true
		
		Class<?> c3 = Class.forName("vererbung.Display"); // Möglichkeit 3
		
		System.out.println("c1 == c3: " + (c1==c3)); // true
	}

}
