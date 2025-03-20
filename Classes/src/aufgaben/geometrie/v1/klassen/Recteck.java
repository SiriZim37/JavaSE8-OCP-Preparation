package aufgaben.geometrie.v1.klassen;

public class Recteck {   // Bregriff wurde eingeführt.
	int breite;
	int hoehe;
	
	static void changeDimension(Recteck r , int breite , int hoehe) {
		r.breite = breite;
		r.hoehe = hoehe;
	}
	
	 void changeDimension(int breite , int hoehe) {
			this.breite = breite;
			this.hoehe = hoehe;
			
//			this.breite 
// 			Explicit name : Wir möchte an dem Attribut von dem Objekt kopieren
//			Oder schreiben andere Name von Attribut , aber nicht glcih wie in Lokale Variable
	 }
	
	//... bequeme Ausgaben
	public String toString() {		
		return ".Rechteck (" + breite + " X " + hoehe +")" ;
	}

	
	
	
	
}
