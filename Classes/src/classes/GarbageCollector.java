package classes;

class Autos {
	
}

public class GarbageCollector {


	public static void main(String[] args) {
			
		
		Autos a1; 
		// Zeile A   : Keine-Auto-Objekte stehen GC zur Verfügung! 
		
		new Autos();
		// Zeile B   : Ein Autos-Objekt im Heap steht dem GC zur Verfügung , aber nicht in STACK referenziert 
		
		a1 = new Autos();
		// Zeile C   : Ein Autos-Objekt im Heap steht dem GC zur Verfügung ( Zeile B wird löschen)
		
		a1 = new Autos();
		// Zeile D   : Zwei Autos-Objekte im Heap stehen dem GC zur Verfügung   ( Zeile B , C wird löschen)
		
		a1 = null;
		// Zeile E	 : Drei Autos-Objekte im Heap stehen dem GC zur Verfügung  ( Zeile B , C , D wird löschen)
		
		

		
		
	}

}
