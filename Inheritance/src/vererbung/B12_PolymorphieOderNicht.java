package vererbung;

class AuotA{
	static int mainBaujahr = 1880;
	static int getMiniBaujahr() { return mainBaujahr; }
	
	int baujahr = 2000;
	
	public int getBaujahr() {
		return baujahr;
		
	}
}

class OpelA extends AuotA {
	static int mainBaujahr = 1920;
	static int getMiniBaujahr() { return mainBaujahr; }
	
	int baujahr = 2011; // für die Praxis nicht empfohlen
						// wenn die Basisklasse gleichnamiges sichtbares Attribut hat.

	public int getBaujahr() {
		return this.baujahr;
		
	}
}

public class B12_PolymorphieOderNicht {

	public static void main(String[] args) {
		/*
		 * Zugriff auf statische Attribute : early binding ( Complierzeit-Eintscheiden)
		 */
		System.out.println("1.");
		System.out.println(AuotA.mainBaujahr);  //1880
		System.out.println(OpelA.mainBaujahr);  //1920
		
		/*
		 * Aufruf statischer Methode : early binding
		 */
		System.out.println("2.");
		System.out.println(AuotA.getMiniBaujahr());  //1880
		System.out.println(OpelA.getMiniBaujahr()); //1920
		
		
		/*
		 * Zugriff auf statische Attribute : early binding
		 */
		System.out.println("3.");
		AuotA a1 = new AuotA(); 
		System.out.println(a1.baujahr);  //2000
		
		a1 = new OpelA(); 
		System.out.println(a1.baujahr);  //2000
		/*
		 * a1 ถูกเปลี่ยนให้ชี้ไปที่ออบเจกต์ของ OpelA, แต่ a1 ถูกประกาศด้วยชนิดข้อมูล AuotA.
		 * ตัวแปร baujahr ในคลาส AuotA ยังคงถูกใช้งานเพราะตัวแปรนี้ ไม่ได้ใช้ polymorphism.
		 * การเข้าถึงตัวแปรอินสแตนซ์แบบตรง (a1.baujahr) ยังคงมองตัวแปร baujahr จากคลาส AuotA.
		 */
		
		OpelA a5 = new OpelA(); 
		System.out.println(a5.baujahr);  //2011
		
		System.out.println("4.");
		OpelA o1 = (OpelA) a1 ; // DownCasting
		System.out.println(o1.baujahr);  // 2011
		
		System.out.println( ((OpelA)a1).baujahr); //2011
		
		/*
		 * Aufruf der Instanz-methoden : early binding (Entscheidung zur Laufzeit)
		 * 
		 * 	1. Suche des referenzierte Objekt
		 *  2. Ermittle die Klasse des Objektes
		 *  3. Starte getBaujahr() aus der so ermittelten Klasse
		 */
		System.out.println("5.");
		AuotA a2 = new AuotA(); 
		System.out.println( a2.getBaujahr()); //2000 : Suche des referenzierte Objekt : aus der Klasse AuotA
		
		a2 = new OpelA();
		System.out.println(a2.getBaujahr()); // 2011 : Suche des referenzierte Objekt : aus der Klasse OpelA
		System.out.println(((AuotA)a2).getBaujahr()); // 2011  // Casting andern nicht! des Objekt
													  // Suche des referenzierte Objekt aus der OpelA
		
	}

}
