package strings;

public class WdhStringPool {

	public static void main(String[] args) {
		
		/*
		 *  Wie viele String-Objekt stehen dem Garbage Collector
		 *  in der Zeile A zur Verfügung?
		 *  
		 *  
		 *  ###  Antwort:  1 ( und natürlich sein byte Array)
		 */
		
		String s =  m(); //  2 neue String-Objekte auf dem Heap 
						 // die Referebz von einem wird in s gespeichert
		
		// Zeile A
		
		/* ### Explain
		 * In Zeile A stehen dem Garbage Collector 1 String-Objekt zur Verfügung, 
		 * da "modi" nicht mehr von einer Referenz im main oder an anderer Stelle gehalten wird. 
		 * Das Objekt "MODI" bleibt über die Variable s erreichbar und wird daher nicht vom Garbage Collector beansprucht.
		 */
	}

	
	static String m() {
		String s1 = "mo";				// 1. String-Objekt im String-Pool ( kein neuse Objekt im Heap)
		String s2 = "di";				// 2. String-Objekt im String-Pool ( kein neuse Objekt im Heap)
		
		String s3 = s1 + s2;			// +1. String-Objekt auf dem Heap (Konkatenation von s1 und s2)
		String s4 = s3.toUpperCase();   // +1. String-Objekt auf dem Heap (Kleinbuchstaben in Großbuchstaben umgewandelt)
		
		return s4.toString();			// s4 ist bereits ein String-Objekt, keine neue Instanz wird erstellt
	}
}
