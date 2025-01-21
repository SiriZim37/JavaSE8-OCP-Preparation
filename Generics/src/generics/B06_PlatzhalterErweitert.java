package generics;

import java.util.Comparator;

public class B06_PlatzhalterErweitert {

	/*
	 *  <? extends X beschreibt eine Menge : X und abgeleitet von X
	 *  ? super Y beschreibt eine Menge : Y und Basistypen von Y
	 *  	(diese Menge ist oben von Object beschränkt)
	 *  
	 *  <Z> beschreibt eine Menge : Z 
	 *  
	 *  2. Zuweisungskontrolle ist OK , wenn die Menge links kompplett
	 *  die rechte Menge einschliesst.
	 */
	/*
	 * การอธิบายการใช้ ? extends X และ ? super Y ใน Generics:
	 * 
	 * <? extends X>:
	 * หมายถึงการใช้ประเภทที่เป็น X หรือ ชนิดที่สืบทอดจาก X
	 * ตัวอย่างเช่น Comparator<? extends Integer> หมายถึง Comparator ที่รับค่าประเภท Integer หรือประเภทที่สืบทอดจาก Integer (เช่น Long, Short)
	 * ตัวอย่างในโค้ด:
	 * cmpExtendsInt = cmpInt; — ทำงานได้เพราะ Integer สืบทอดจาก Number และ <? extends Integer> ยอมรับ Integer ได้
	 * cmpExtendsNum = cmpInt; — ทำงานได้เช่นกัน เพราะ Integer เป็นชนิดที่สืบทอดจาก Number
	 * 
	 * <? super Y>:
	 * หมายถึงการใช้ประเภทที่เป็น Y หรือ ประเภทที่เป็นพื้นฐานของ Y
	 * ตัวอย่างเช่น Comparator<? super Integer> หมายถึง Comparator ที่รับค่าประเภท Integer หรือ ชนิดที่เป็นพื้นฐานของ Integer (เช่น Number หรือ Object)
	 * ตัวอย่างในโค้ด:
	 * cmpSuperInt = cmpNum; — ทำงานได้เพราะ Number เป็น superclass ของ Integer
	 * cmpSuperInt = cmpObj; — ทำงานได้เช่นกัน เพราะ Object เป็น superclass ของ Integer
	 * 
	 * <Z>:
	 * หมายถึงการใช้ ชนิดที่แน่นอน ซึ่งในกรณีนี้คือ Comparator<Z> จะรับเฉพาะค่าที่เป็น Z เท่านั้น เช่น Comparator<Integer> จะรับเฉพาะ Integer เท่านั้น
	 */


	public static void main(String[] args) {

		Comparator<Number> cmpNum = null;
		Comparator<Integer> cmpInt = null;
		Comparator<Object> cmpObj = null;
		
		Comparator<? extends Integer> cmpExtendsInt = null;
		Comparator<? extends Number> cmpExtendsNum = null;
		Comparator<? extends Object> cmpExtendsObj = null;
		
		Comparator<? super Integer> cmpSuperInt = null;
		Comparator<? super Number> cmpSuperNum = null;
		Comparator<? super Object> cmpSuperObj = null;
		
//		cmpNum = cmpInt ;		 		 // cf : <Number> erlaubt nicht <Integer> 
		
		cmpExtendsInt = cmpInt;			 // ok : <? extends Integer> erlaubt <Integer>   ทำงานได้เพราะ Integer สืบทอดจาก Number และ <? extends Integer> ยอมรับ Integer ได้
		 
//		cmpExtendsInt = cmpNum;	 		 // cf : <? extends Integer> erlaubt nicht <Number>  
		
		cmpExtendsNum = cmpNum;			 // ok : <? extends Number> erlaubt <Number>
		
		cmpExtendsNum = cmpInt;			 // ok : <? extends Number> erlaubt <Integer> ทำงานได้เช่นกัน เพราะ Integer เป็นชนิดที่สืบทอดจาก Number
		
		cmpExtendsNum = cmpExtendsInt;	 // ok : <? extends Number> erlaubt <? extends Integer> 
		
//		cmpExtendsInt = cmpExtendsNum ;  // cf :  <? extends Integer> erlaubt <? extends Number> 
		
		
		/*<? super Integer>: หมายถึง "ประเภทพื้นฐานของ Integer" 
		 * ซึ่งจะรวมทั้ง Integer และคลาสที่เป็นพื้นฐานของ Integer เช่น Number หรือ Object
		 * 
		 * ดังนั้น Comparator<? super Integer> คือ Comparator ที่รองรับ Integer
		 * และคลาสที่เป็นพื้นฐานของ Integer (เช่น Number, Object)
		 */
	
//		cmpSuperInt = cmpExtendsInt;	// cf  : <? extends Integer> is not subtype or superclass of Number.
										// ไม่สามารถคอมไพล์ได้ เพราะ <? extends Integer> ไม่ได้เป็นซับคลาสหรือซูเปอร์คลาสของ Number
		
//		cmpSuperInt = cmpExtendsNum;	// cf  : <? extends Integer> is not subtype or superclass of Number.
										// ไม่สามารถคอมไพล์ได้ เพราะ <? extends Integer> ไม่ได้เป็นซับคลาสหรือซูเปอร์คลาสของ Number 
		
		cmpSuperInt = cmpNum; 		// ok : ทำงานได้เพราะว่า Comparator<Number> สามารถแทนที่ Comparator<? super Integer> ได้
									// เนื่องจากว่า Number เป็น superclass ของ Integer
		
		cmpSuperInt = cmpInt;    	// OK: Integer is a subtype of Integer.
	
		cmpSuperInt = cmpNum;   	// OK: Number is a superclass of Integer.
		
		cmpSuperInt = cmpObj;    	// OK: Object is a superclass of Integer.
		
		cmpSuperObj = cmpObj;
		
		cmpObj = cmpSuperObj;		// ok : Der Compilier weißt , dass
									// Object keine Basisklasse hat
		
//		cmpInt = cmpExtendsInt; 	// cf : keine Ausnahme , obwohl < ? extends Integer>
									// nur die Klasse Integer beschreibt , 
									// da Integer final ist.
		
	}

}
