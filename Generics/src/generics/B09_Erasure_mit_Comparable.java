package generics;

import java.util.Arrays;
import java.util.Collection;

class PersonV1 {
	public int compareTo(PersonV1 p1) {
		return 0 ; 
	}
	
	public int compareTo(Object obj) {
		return 0 ; 
	}
}

class PersonV2 implements Comparable<PersonV2> {
	
	/*
	 * Erasure :
	 * 		Der Compilier löschet beim Übersetzen 
	 * 		die generischen Angaben. Die Klasse   
	 * 		( เมื่อคอมไพเลอร์แปลโปรแกรม มันจะลบข้อมูลประเภทที่ระบุไว้ใน Generics หลังจากนั้น คลาสจะกลายเป็น:)
	 * 		ist dann so : 
	 * 
	 * 		class PersonV2 implements Comparable{...}
	 * 
	 * 		Dabei ändert der Compiler die CompareTo auch ändern: 
	 * 		การเปลี่ยนแปลงนี้จะทำให้เมธอด `compareTo` ถูกเปลี่ยนเป็น:
	 * 
	 * 		public int compareTo(Object obj){
	 * 			PersonV2 p2 = (PersonV2) obj; // generiert vom Compiler  คอมไพเลอร์จะสร้างการแคสต์นี้ให้
	 * 			//...
	 * 			return 0 ;
	 * 		}
	 */
	
	/*
	 * Erasure :
	 * 	- เมื่อคอมไพเลอร์แปลโปรแกรม มันจะลบข้อมูลประเภทที่ระบุไว้ใน Generics
	 * 	- ตัวอย่างเช่น: เมื่อคุณเขียนคลาสที่ใช้ Generics ในการเปรียบเทียบ เช่น `Comparable<T>`, 
	 * 		คอมไพเลอร์จะลบประเภท `T` ออกเมื่อแปลโปรแกรม
	 * 		ทำให้คลาสกลายเป็นคลาสที่ไม่มีข้อมูลประเภทและจะเปลี่ยนเมธอด `compareTo` 
	 * 		ให้เป็นเมธอดที่รับพารามิเตอร์เป็น `Object`
	 * 
	 *  ตัวอย่างเช่น `PersonV2`:
	 * 	- การใช้ `Comparable<PersonV2>` ถูกเปลี่ยนเป็น `Comparable` 
	 * 	- เมธอด `compareTo` จะเปลี่ยนเป็น `compareTo(Object obj)` 
	 * 		และคอมไพเลอร์จะทำการแคสต์ (cast) ค่าเป็น `PersonV2`
	 */

	/*
	 * ตัวอย่างนี้แสดงให้เห็นถึงการใช้ Object[] ที่มีชนิดข้อมูลต่างๆ เช่น Integer, String และการเรียกใช้ Arrays.sort()
	 * ซึ่งจะเกิดข้อผิดพลาด ClassCastException เนื่องจากไม่สามารถเปรียบเทียบชนิดข้อมูลที่แตกต่างกันได้
	 * 
	 * ในโค้ดนี้:
	 * 	- มีการสร้าง array ที่ประกอบไปด้วย Integer, String และ Integer
	 * 	- เรียกใช้ `Arrays.sort()` ซึ่งจะพยายามเปรียบเทียบค่าภายใน array 
	 * 	- ผลที่เกิดขึ้นคือ ClassCastException เพราะไม่สามารถเปรียบเทียบ Integer กับ String ได้
	 */
	public int compareTo(PersonV2 p2) {
		return 0;
	}
	
	/*
	 * Die metode kompiliert nicht: da beim Erasure
	 * eine Methode compareTo(Object) bereits entsteht
	 */
	
//	public int compareTo(Object obj) {
//		return 0 ; 
//	}

	
}
public class B09_Erasure_mit_Comparable {

	/*
	 * Das Bsp. ist nicht prüfungsrelevant
	 */
	public static void main(String[] args) {
	
		/*
		 * Warum gibt es ClassCastException
		 */
		Object[] arr = {
				12 , 
				"22",
				-3
		};
		
		
		/*
		 * หลักการ Erasure (ลบข้อมูลประเภท): ตัวอย่างนี้แสดงให้เห็นถึงการใช้ Object[] 
		 * ที่มีชนิดข้อมูลต่างๆ เช่น Integer, String และการเรียกใช้ Arrays.sort() 
		 * ซึ่งไม่สามารถทำงานได้ถูกต้องเมื่อพยายามเปรียบเทียบชนิดที่ต่างกัน
		 * 
		 */
		try {
			Arrays.sort(arr); // ClassCasting
		} catch (ClassCastException e) {
			System.out.println("1. ClassCastException" + e );
		}
	
		
		/*
		 * nachbilden der Arbeit der sort beim Vergleichen :
		 */
		Object element0 = arr[0];
		Comparable element1 = (Comparable)arr[1];

		/*
		 * 	
		 * หลักการ Erasure (ลบข้อมูลประเภท): ตัวอย่างนี้แสดงให้เห็นถึงการใช้ Object[] 
		 * ที่มีชนิดข้อมูลต่างๆ เช่น Integer, String และการเรียกใช้ Arrays.sort() 
		 * ซึ่งไม่สามารถทำงานได้ถูกต้องเมื่อพยายามเปรียบเทียบชนิดที่ต่างกัน
		 * 
		 * ClassCastException: เมื่อพยายามใช้ compareTo 
		 * กับอ็อบเจ็กต์ที่เป็นชนิดต่างกัน (เช่น String กับ Integer), 
		 * จะเกิด ClassCastException เนื่องจากไม่สามารถเปรียบเทียบชนิดต่างๆ กันได้
		 */
		try {
			int res = element1.compareTo(element0);
			// eventuell positionen tauschen...
			System.out.println(res);
		} catch (Exception e) {
			System.out.println("2. ClassCastException");
		}
	
		/*
		 * Ein weiteres Bsp. von Erasure:
		 * 
		 * Es ist nicht möglich eine Methode zu überladen,
		 * wenn die Varianten sich nur durch Parametrisierungen 
		 * unterscheiden.
		 * 
		 *  S. die Methoden m
		 */
		
		/*
		 * ตัวอย่างอื่นของ Erasure:
		 * 	- ใน Java ไม่สามารถทำการโอเวอร์โหลดเมธอดที่มีพารามิเตอร์ที่แตกต่างกันเพียงแค่การใช้งาน Generics
		 * 	- ตัวอย่างเช่นการสร้างเมธอด `m(Collection<Number>)` และ `m(Collection<Integer>)` 
		 * 		จะไม่สามารถแยกแยะกันได้เมื่อคอมไพล์เพราะข้อมูลประเภทจะถูกลบออกในระหว่างการแปลโปรแกรม
		 */
		
	} // end of main
	
//	static void m(Collection<Number> c) {}
//	static void m(Collection<Integer> c) {} 
}
