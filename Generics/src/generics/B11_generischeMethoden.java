package generics;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class NormalKlasse{
	
	void normaleMethode() {}	
	
	<T> void generischeMethode() {}		 // เมธอดเจเนอริกจะใช้ตัวแปรประเภท (T) เพื่อระบุว่ามันสามารถทำงานกับข้อมูลประเภทใดก็ได้c
	 
	static <T> void  generischeMethode2(T param) {}	// เป็นเมธอดเจเนอริกที่สามารถรับพารามิเตอร์ประเภทใดก็ได้ (เช่น Integer, String, ฯลฯ)
	
	<T> T generischeMethode3(T param) { // เป็นเมธอดเจเนอริกที่รับพารามิเตอร์และส่งค่ากลับด้วยประเภทเดียวกัน
		T tmp = param;
		return tmp;
	}	
}
class GenerischeKlasse<E>{
	E normalMethode(E e) {return e ; } // ใช้ตัวแปรประเภท E ที่ถูกกำหนดเมื่อสร้างวัตถุ เพื่อกำหนดประเภทของข้อมูลที่ใช้ในเมธอดของคลา
	
	// Methode hat ihre eigene generische Variable
	// es ist nicht die generische Variable der Klasse
	// เป็นเมธอดเจเนอริกภายในคลาสเจเนอริกที่สามารถทำงานกับข้อมูลประเภทใดก็ได้ (Z)
	<Z> Z generischeMethode(Z param) {return param; }	
	
}

public class B11_generischeMethoden {

	/*
	 * generische Methode : Methode mit eigenen Typparameter
	 * (Typvariable)
	 */
	public static void main(String[] args) {
	
		/*
		 * Beispiel : Methode asList der Klasse Arrays : 
		 * 
		 * 		public static <T> List<T> asList(T...a)
		 * 	- <T> หมายความว่าเมธอดนี้ใช้ประเภทข้อมูลทั่วไป (Generics) ซึ่งประเภทจะถูกกำหนดในขณะรันไทม์
		 * 	- T...a หมายความว่าเราสามารถส่งข้อมูลหลายค่า (varargs) และมันจะถูกเก็บในรูปแบบของอาร์เรย์
		 */
		
		/*
		 * Parametrisieren durch das übergeben von Integer
		 */
		List<Integer> listInt =  Arrays.asList( 1 , 2 , 3 );
		
		/*
		 * Parametrisieren durch das Übergeben von String[]:
		 * 
		 * 		List<String> asList(String[] param)
		 * 
		 * ที่นี่เราส่งอาร์เรย์ String[] ไปให้ และเมธอดจะคืนค่าเป็น List<String>
		 *  		 
		 */
		List<String> listString =  Arrays.asList( "a" , "b", "c");
		
		/*
		 * Beispiel : Methode reverseOrder aus Comparator : 
		 * 
		 * 		<T extends Comparable<? super T>> Comparator<T> reverseOrder()
		 * 
		 *  ในกรณีนี้:
		 * 		 - T ต้องสามารถเปรียบเทียบได้ (ต้องเป็นประเภทที่ implement Comparable)
		 * 		 - เมธอดนี้คืนค่า Comparator ที่สามารถเปรียบเทียบในลำดับย้อนกลับ (จากมากไปน้อย)
		 * 
		 * Vereinfahcht : 
		 * 
		 * 		<T> Comparator <T> reverseOrder()
		 */
		Comparator<String> cmp = Comparator.reverseOrder();
		
		/*
		 * Typebound ist auch für generischeMethoden möglich
		 * 
		 * 		<T extends Comparable<? super T>> Comparator<T> reverseOrder()
		 * ในกรณีนี้:
		  	- ตัวแปร T ต้องเป็นประเภทที่สามารถเปรียบเทียบได้ (ต้อง implement หรือ extend Comparable)
		 *    - ดังนั้นหากใช้กับประเภทที่ไม่สามารถเปรียบเทียบได้ เช่น Thread, จะเกิดข้อผิดพลาด
		 *  
		 *  Einschränkung : T muss Comparable sein 
		 *  ข้อจำกัด: T ต้องเป็นประเภทที่สามารถใช้ Comparable ได้
		 
		 */
		// 	Comparator<Thread> cmp2 = Comparator.reverseOrder(); // ข้อผิดพลาด: Thread ไม่มีการ implement Comparable

		
		/*
		 * Beispiel : Methode reverseOrder aus Comparator : 
		 * 
		 * 		static <T extends Comparable<? super T>> void sort(List<T> list)
		 *  	- เมธอดนี้ใช้ Generic กับ Type Bound ที่บังคับให้ T ต้อง extend Comparable<? super T>
		 */	
		/* 
		 * Parameterisierung durch Argument List<String> : 
		 *
		 * 		void sort(List<T> list) 
		 * 
		 * 	- สามารถใช้ List<String> ได้อย่างไม่มีปัญหา เพราะ String implements Comparable
		 */
		List<String> listStr = Arrays.asList("mm","bb","ff","aa");
		Collections.sort(listStr);
		
		
		/*
		 * Parameterisierung durch Argument List<LocalDate> : 
		 * 
		 * 		void sort(List<LocalDate> list) 
		 */
		List<LocalDate> listDate = Collections.emptyList();
		Collections.sort(listDate);
		
		/*
		 * Parameterisierung durch Argument List<Thread> : 
		 * 
		 * 		void sort(List<T> list) 
		 * 
		 * Compilerfehler wegen des Typebond : 
		 * 
		 * 		Thread ist nicht Comparable
		 * 
		 *  - ใช้ List<Thread> จะเกิดข้อผิดพลาด เพราะ Thread ไม่ implement Comparable
		 *    Thread ไม่มีวิธีเปรียบเทียบตัวเองกับตัวอื่น ดังนั้นจึงไม่สามารถใช้เมธอด sort ได้
		 */
		List<Thread> listThread = Arrays.asList(new Thread() , new Thread());
//		Collections.sort(listThread); // cf 
	}

}
