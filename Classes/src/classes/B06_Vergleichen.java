package classes;

class Blume {   //  Objekt hat Attribut
	int preis;
	
	Blume(int preis){
		this.preis = preis;
	}
	
	public String toString() {
		return "Blume. Preis = " + preis;
	}
	/*
	 * Wenn Blumen-Objekte nach Inhalten (Attributen)
	 * vergleichen werden müseen, soll die Klasse Blume
	 * die Methode überscreiben :
	 * 
	 * 		public boolean equals(Objekt)
	 */
	
	public boolean equals(Object obj) {  
	  if( !(obj instanceof Blume)) {  // if obj ist nicht die address von Blume hat wird return false
		  return false;
	  }
//	  int preis1 = this.preis;
//	  int preis2 = ((Blume)obj).preis;    //  Casting von Referenz für objekt
//	  return preis1 == preis2;
	  
	  return preis == ((Blume)obj).preis;
	}
	
}



public class B06_Vergleichen {

	public static void main(String[] args) {
	
		/*
		 * 	Die Operatoren == und != vergleichen die Referenzen!
		 * 
		 */
		Blume b1 = new Blume(90);
		Blume b2 = new Blume(90);
		
		System.out.println("b1:" + b1);
		System.out.println("b2:" + b2);
		
		System.out.println("b1==b2 : " + ( b1==b2? true : false));  // false  : Es vergleichen die Referenze , aber nich die Objekte
		
		boolean result = b1.equals(b2)? true : false;   // obj  the reference object with which to compare.
		System.out.println("b1.equals(b2): " + result ); // false 
		
		boolean result2 = b1.equals(b2)? true : false;   // bequeme Objekt in klass zu vergleichen 2 variable
		/*
		 *  b1 new Blume(90) wird in  int preis1 = this.preis; kopieren 
		 *  b2 wird public boolean equals(Object obj) aufrufen und vergleichen 
		 * 
		 */
		System.out.println("b1.equals(b2): " + result2 ); // false 

		/*
		 *   die Klasse !String! auch ihre equals Methode überschrieben.!!!!! 
		 *   string.equals(string) 
		 */
		
	}

}
