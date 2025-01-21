package steckdosen.mitgenerics;

import java.util.ArrayList;


//ใช้ Generics เพื่อสร้างเต้ารับที่ทำงานได้กับทีวีทุกชนิด
class Steckdose<T  extends TV> {
	 private T tv;
	
	 void anschliessen(T tv) {
		 if(this.tv != null) {
				throw new IllegalStateException("Steckdosen ist belegt");
			}
	     this.tv = tv;
	 }
	
	 public T getTV() {
	     return this.tv;
	 }
}

//อินเทอร์เฟซ TV
interface TV {}

//คลาส TV แต่ละประเภท
class TVUK implements TV {}
class TVDE implements TV {}



public class ProblemLoesen {

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
		
		TVUK tvUKs = new TVUK();
		TVDE tvDEs = new TVDE();
		
//		tvUKs = tvDEs; 	// Es nicht kompiliert
//		tvDEs = tvUKs;	// Es nicht kompiliert
		
		
		// สร้างเต้ารับสำหรับทีวีเยอรมนี
		Steckdose<TVDE> sdDE = new Steckdose<TVDE>();
	    TVDE tvDE = new TVDE();
	    sdDE.anschliessen(tvDE);
	    
	    // สร้างเต้ารับสำหรับทีวีอังกฤษ
	    Steckdose<TVUK> sdUK = new Steckdose<TVUK>();
	    TVUK tvUK = new TVUK();
	    sdUK.anschliessen(tvUK);
	  
	    // ข้อผิดพลาดจะเกิดขึ้นหากเราพยายามต่อทีวีอังกฤษเข้ากับเต้ารับเยอรมนี (ไม่สามารถคอมไพล์ได้)
	    // deutscheSteckdose.anschliessen(englischesTV); // Error: ชนิดไม่ตรงกัน
		      
//		sdDE = sdUK; 	// darf nicht kompiliert
//		sdUK = sdDE;	// darf nicht kompiliert
	    
		TVDE t1 = sdDE.getTV(); // sollte bequem ohne Casting gehen
//		TVUK t2 = sdDE.getTV(); // darf nicht kompiliert
		
		
//		TVDE t11 = sdUK.getTV(); // sollte bequem ohne Casting gehen
		TVUK t22 = sdUK.getTV(); // darf nicht kompiliert
		
		// sinnlose Parametrisierung kompiliert nicht,
		// da es den Type Bound gibt (T extends TV):
		
//		Steckdose<String> sdSinnlos = new Steckdose<String>(); // cf 
//		sdSinnlos.anschliessen("ich bin kein Fernseher");
		
		Steckdose<? extends TV> sdUniversell;
		
		sdUniversell = sdDE;
		sdUniversell = sdUK;
		
//		sdUniversell.anschliessen(tvDE);
//		sdUniversell.anschliessen(tvUK);
		}
	
}
