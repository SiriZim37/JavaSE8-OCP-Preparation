package operatoren;

public class Vergleichsoperatoren {

	public static void main(String[] args) {
		
		/*
		 * 		>
		 * 		>=
		 * 		<
		 * 		<=
		 * 
		 * Diese Operatoren können Zahlen vergleichen.
		 * Diese Operatoren liefern boolean-Ergebnis zurück.
		 */
		
		int v1 = 12;
		double v2 = 12;
		char v3 = 'a'; // a hat Position 97
		
		boolean b0 = v1 < v2;    // 
		boolean b00 = 12 < 12;    // 
		boolean b000 = 12 < 12.0;    //   (12 ถูกแปลงเป็น double อัตโนมัติเพื่อเปรียบเทียบ)
		
		System.out.println("v1 < v2: " + (v1 < v2)); // false
		System.out.println("v1 == v2: " + (v1 == v2)); // true	 // Java จะแปลง v1 เป็น double อัตโนมัติเพื่อเปรียบเทียบ
		System.out.println("v1 >= v2: " + (v1 >= v2)); // true   // Java จะแปลง v1 เป็น double อัตโนมัติเพื่อเปรียบเทียบ
		System.out.println("v3 <= v2: " + (v3 <= v2)); // false  // v3 ('a' = 97) น้อยกว่าหรือเท่ากับ v2 (12.0)  หรือไม่
		System.out.println("v3 <= 97: " + (v3 <= 97)); // true // v3 ('a' = 97) น้อยกว่าหรือเท่ากับตัวเลข 97 หรือไม่
		
//		System.out.println( v1 < true ); // cf: bitte nur Zahlen vergleichen
		
		/*
		 * 		==
		 * 		!=
		 * 
		 * Diese Operatoren können Zahlen vergleichen.
		 * Diese Operatoren können boolean mit boolean vergleichen.
		 * Diese Operatoren liefern boolean-Ergebnis zurück.
		 */
		boolean b1 = true;
		System.out.println("b1 == false: " + (b1 == false)); // false // geht, aber nicht empfohlen (es geht mit ! einfacher)
		
		System.out.println("b1 != false: " + (b1 != false)); // true  // 
		
//		System.out.println(b1 == 0); // cf: boolean bitte nur mit boolean vergleichen
		
		int x1 = 3;
		System.out.println("x1 == 3.0: " + (x1 == 3.0)); // การเปรียบเทียบ 3.0 == 3.0 ให้ผลลัพธ์เป็น true   
														// เปรียบเทียบค่าที่มี ชนิดข้อมูลต่างกัน (int กับ double)
														// x1 (3 แบบ int) ถูกแปลงเป็น 3.0 (ชนิด double)
		System.out.println("x1 != 3.0: " + (x1 != 3.0)); // การเปรียบเทียบ 3.0 != 3.0 ให้ผลลัพธ์เป็น false   
														// เปรียบเทียบค่าที่มี ชนิดข้อมูลต่างกัน (int กับ double)
														// x1 (3 แบบ int) ถูกแปลงเป็น 3.0 (ชนิด double) 
		
		/*
		 * Achtung in der Praxis!
		 * Rechnung mit Gleitkommazahlen kann ungenau werden
		 */
		System.out.println("0.1 + 0.1 = " + (.1 + .1)); // 0.2
		System.out.println(".1 + .1 + .1 = " + (.1 + .1 + .1)); // 0.30000000000000004
		
		double d1 = .1 + .1 + .1;
		System.out.println("d1 == 0.3: " + (d1 == 0.3)); // false
	}

}
