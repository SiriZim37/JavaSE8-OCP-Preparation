package steckdosen.ohnegenerics;


interface TV {	}


class TVUK implements TV {}
class TVDE implements TV {}

class SteckdoseUK{
	TVUK tv;
	
	void anschliessen(TVUK tvuk) {
		if(this.tv != null) {
			throw new IllegalStateException("Steckdosen ist belegt");
		}
		this.tv = tvuk;
	}
	public TVUK getTV() {
		return this.tv;

	}
}

class SteckdoseDE{
	TVDE tv;
	
	void anschliessen(TVDE tvde) {
		if(this.tv != null) {
			throw new IllegalStateException("Steckdosen ist belegt");
		}
		this.tv = tvde;
	}
	public TVDE getTV() {
		return this.tv;

	}
}



public class ProblemBeschreiben {

	/*
	 * Es gibt englische TV-Geräte
	 * Es gibt deutsche TV-Geräte
	 * Deutsche und einlische TV-Geräte sind nicht kompatibel (wichtig!)
	 * 
	 * 
	 * Es gibt englische Steckdosen
	 * Es gibt deutsche Steckdosen 
	 * Deuscth und englische Steckdosen sind nicht kompatibel (wichtig!)
	 * 
	 * 
	 * An einer deutsche Steckdosen kann nur ein deutsches TV-Gerät angeschlossen werden (wichtig!)
	 * An einer englische Steckdosen kann nur ein englisches TV-Gerät angeschlossen werden (wichtig!)
	 * 
	 * 
	 * nachdem die Aufgaben gelöscht wurde , zeigt die Lösung
	 * das Design-Problem : 
	 * 		1. Fast identische Stekdosen-Klassen(doppelter Code)
	 * 		2. Wird ein weiteres Steckdosen-Typ benötigt , muss eine weitere 
	 * 			fast identische Steckdosen-Klassen erzeugt werden
	 */
	public static void main(String[] args) {
		
		/*
		 * โค้ดนี้อธิบายถึงความไม่เข้ากันของทีวีและเต้ารับไฟฟ้าระหว่างประเทศเยอรมนีและอังกฤษ 
		 * ซึ่งเป็นการจำลองปัญหาที่เกิดจากชนิดข้อมูลที่ต่างกันในโปรแกรม 
		 * โดยหากไม่มี Generics จะต้องกำหนดชนิดข้อมูลอย่างชัดเจน 
		 * และจะเกิดข้อผิดพลาดถ้าเราพยายามนำทีวีชนิดหนึ่งไปต่อกับเต้ารับอีกชนิด
		 */
		
		TVUK tvUK = new TVUK();
		TVDE tvDE = new TVDE();

//		tvUK = tvDE; // darf nicht kompilieren
//		tvDE = tvUK; // darf nicht kompilieren 
		
		SteckdoseDE sdDE = new SteckdoseDE();
		sdDE.anschliessen(tvDE); // muss funktionieren
//		sdDE.anschliessen(tvUK); // darf nicht kompilieren
		
		SteckdoseUK sdUK = new SteckdoseUK();
		sdUK.anschliessen(tvUK); // muss funktionieren
//		sdUK.anschliessen(tvDE); // darf nicht kompilieren
		
//		sdDE = sdUK; // darf nicht kompilieren
//		sdUK = sdDE; // darf nicht kompilieren
		
		TVDE a = sdDE.getTV(); // sollte bequem ohne Casting gehen
//		TVUK b = sdDE.getTV(); // darf nicht kompilieren
		
		TVUK c = sdUK.getTV(); // sollte bequem ohne Casting gehen
//		TVDE d = sdUK.getTV(); // darf nicht kompilieren
	
	
	}
	

	
}
