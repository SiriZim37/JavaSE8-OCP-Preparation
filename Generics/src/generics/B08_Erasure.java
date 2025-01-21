package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B08_Erasure {
	/*
	 *Erasure คืออะไร?
	 *		Erasure หมายถึง การลบข้อมูลประเภท (generic type) 
	 *		เมื่อคอมไพเลอร์ทำการคอมไพล์โค้ด ซึ่งจะทำให้ข้อมูลประเภทต่างๆ หายไปในระหว่างการคอมไพล์ 
	 *		ทำให้ในช่วง runtime เราไม่สามารถตรวจสอบชนิดข้อมูลที่ถูกกำหนดให้กับ Generic ได้ 
	 *		(เช่น ArrayList<Integer> จะกลายเป็น ArrayList).
	 */
	/*
	 * Exam : 
	 * 
	 * 		Der Compiler wird nach dem Überprüfen der Korrektheit
	 * 		die generischen Angaben beim Übersetzen löschen
	 * 
	 * Nihct in der Prüfung 
	 * 
	 * 		Beim Erasing genereiert der Compiler oft 
	 * 		Sicherheitscode für Laufzeitkontrollen
	 * 
	 */
	public static void main(String[] args) {

		List<Integer> list; 		// Übersetzt : 32-Bit Referenz reservieren.
		
		new ArrayList<Integer>(); 	// übersetzt : erzeuge ein neues Object vom Typ ArrayList
		
		list = new ArrayList<Integer>();
		
		System.out.println(list.getClass());  // class java.util.ArrayList
		
		/*
		 * Exam : Folgender Code genereiert ClassCastExeption
		 */

		Object[] arr = {
				12 , 
				"22",
				-3
		};
		
		Arrays.sort(arr); // ClassCastException!! 
		
	}

}
