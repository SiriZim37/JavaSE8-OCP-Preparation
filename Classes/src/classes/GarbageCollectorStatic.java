package classes;

class Autos1 {
	
}



public class GarbageCollectorStatic {

	static Autos1 a;
	/*
	 *  -   Sie existieren unabhängig von Instanzen der Klasse 
	 * 	-	Eine statische Variable lebt so lange wie die Klasse selbst aktiv ist. 
	 * 		Sie wird nicht von der Garbage Collection freigegeben, 
	 * 		solange die Klasse im Speicher geladen ist und Referenzen auf die Klasse bestehen.
	 */
	
	public static void main(String[] args) {

		
		// Zeile A  : Static (classname).a = null in HEAP witd unterbereich entshteht
	
		
		a = new Autos1();
		// Zeile B	:  Ein Objekt von Autos wird 'a' zugewiesen 
		//			:  MyApp.a hat ein Objekt und es erreichbar Das Objekt witd von a statische Variable referenzirt
		//			:  keine Autos-Objekt im Heap steht dem GC zur Verfügung 
		
		
		Autos1 a = new Autos1();
		// Zeile C	: Das Objekt witd von a lokale Variable referenzirt
		//	    	:  keine Autos-Objekt im Heap steht dem GC zur Verfügung 
		
		a = null;  // Lokale Variable a = null 
		// Zeile D : ein Autos-Objekt im Heap steht dem GC zur Verfügung  ( Zeile B  wird löschen)
		
		GarbageCollectorStatic.a = null;
		// Zeile E : 2 Autos-Objekte im Heap stehen dem GC zur Verfügung ( Zeile B , C wird löschen)
		
		
		// Zeile E	: 
		/*	Garbage Collection: Wenn Sie a auf null setzen, z.B. a = null;, 
			wird das Objekt, auf das a vorher verwiesen hat, für die Garbage Collection freigegeben, 
			vorausgesetzt, dass keine anderen Referenzen darauf existieren. 
		*/
		

	}

}
