package methoden;

public class B09_RichtigeUeberladeneMethodeFinden {

	/*
	 * Das Beispiel wird später erweitert.
	 * 
	 * - Die Auswahl der aufgerufenen Methode ist 
	 *   davon NICHT abhängig, in welcher Reihenfolge 
	 *   die Methoden definiert wurden.
	 */
	
	/* 
	 * Schritte bei der Suche nach der aufgerufenen 
	 * Methode mit dem primitiven numerischen Argument:
	 * 
	 * 	1. Methode, bei der der Parametertyp gleich dem Argumenttyp ist
	 *  
	 *  2. Widening
	 * 		byte -> short -> int -> long -> float -> double
	 * 
	 *  3. Autoboxing , 
	 *  		die Methode mit dem Wrapper-Klassen-parameter suchen.
	 *  		Wenn es keine solche gibt , die Methode mit 
	 *  		dem Basistyp-parameter suchen. 
	 *  
	 *  	Achtung! In diesem Schrit gibt es kein Widening
	 *  	für das primitive Argument! 
	 *  	Und int-Argument kann nicht zu Long autogeboxt werden!
	 *  
	 *  4. Alle Schritte aber mit Varargs-Methoden durchlaufen
	 *  
	 ******  ส่วนแรก: การค้นหาเมธอดที่เรียกใช้ (primitive numeric argument)
		1. จับคู่ชนิดของพารามิเตอร์กับอาร์กิวเมนต์โดยตร		
			หากมีเมธอดที่พารามิเตอร์ตรงกับชนิดข้อมูลของอาร์กิวเมนต์ จะเรียกใช้เมธอดนั้นทันที
			
		2. Widening (การขยายชนิดข้อมูล)
			หากไม่มีชนิดตรงกัน จะลองขยายชนิดข้อมูลจากชนิดเล็กไปใหญ่ เช่น
				byte -> short -> int -> long -> float -> double
				
		3.Autoboxing
			หากไม่มีการจับคู่แบบ widening จะตรวจสอบเมธอดที่มีพารามิเตอร์ชนิด wrapper class (เช่น Integer, Double)
			ข้อจำกัด: ไม่มีการขยายข้อมูล (widening) สำหรับ autoboxing เช่น int ไม่สามารถแปลงเป็น Long โดยอัตโนมัติได้
			
		4. Varargs		
			หากยังไม่มีเมธอดที่เหมาะสม จะพิจารณาเมธอดที่ใช้พารามิเตอร์แบบ varargs (int...)

		***** ส่วนที่สอง: การค้นหาเมธอดที่เรียกใช้ (reference argument)
		
		1. จับคู่ชนิดพารามิเตอร์กับอาร์กิวเมนต์โดยตรง
				หากมีชนิดตรงกัน เช่น String หรือ Integer จะเรียกใช้เมธอดนั้น
				
		2. ใช้พารามิเตอร์ชนิดฐาน (Base Type)
			หากชนิดตรงกันไม่มี จะมองหาพารามิเตอร์ที่เป็นชนิดฐาน เช่น Number สำหรับ Integer
			
		3. Autounboxing
			หากอาร์กิวเมนต์เป็น wrapper class และไม่มีการจับคู่โดยตรง จะถอดกล่อง (unbox) เป็นชนิดดั้งเดิม เช่น Integer -> int
			
		4.	Varargs
			หากไม่มีตัวเลือกอื่น จะใช้ varargs
	 */
	
	/*
	 * Shritte bei der Suche nach der aufgerufenen
	 * Methode mit einer Referenz als Argument.
	 * 
	 * 1. methode , bei der der Parametertyp gleich dem Argumenttyp ist
	 * 
	 * 2. Methode mit dem Basistyp-Parameter
	 * 
	 * 3. Autounboxing (bei Wrapper-Klassen-Argument)
	 * 		wenn nötig Widening
	 * 
	 *  4. Alle Schritte aber mit Varargs-Methoden durchlaufen
	 * 
	 */
	public static void main(String[] args) {
		int x = 12;
		m(x); 
		m((long)x); 
//		m(Comparable<Integer>x);  // cf 
		
		String x1 = "";
		m(x1);
		
		Integer x2 = 12;
		m(x2);					// Integer < Number <  Object < int < int...
		
//		doStuff(12,12); //  cf 
	
	}

	static void m(int... x) { System.out.println("int..."); }
	static void m() { System.out.println("no-args"); }
	static void m(double x) { System.out.println("double"); }
	static void m(float x) { System.out.println("float"); }
	static void m(long x) { System.out.println("long"); }
	static void m(int x) { System.out.println("int"); }
	static void m(short x) { System.out.println("short"); }
	static void m(Integer x) { System.out.println("Integer"); }
	static void m(Number x) { System.out.println("Number"); }  // Interger < - IS A <- Number
	static void m(Comparable<Integer> x) { System.out.println("Comparable Number"); }
	static void m(Object x) { System.out.println("Object"); }
	static void m(Long x) { System.out.println("Long"); } // int-Argument kann nicht zu Long autogeboxt werden!
	static void m(String x) { System.out.println("String"); }
	
//	static void doStuff(int x , Integer y) {}
//	static void doStuff(Integer x , Integer y) {}
	
	
	
}
