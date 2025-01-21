package generics;

import java.util.ArrayList;
import java.util.List;

public class B00_ArraysUndGenerics<T> {

	 T att;
	 
	 void test() {
//		 T[] ref = new T[2];	// cf : keine Generic-Array möglich
		 
		 List<T> lref2 = new ArrayList<T>();
	 }
	
	/*
	 * Arrays unterstützen Genereics schlecht
	 */
	public static void main(String[] args) {

		Number[] arr = new Integer[10];
		testGenericUndArray(22.0, arr);
		
		//Zum Vergleich 
		List<Number> list = new ArrayList<Number>(); // cf : es gibt kein Generic 
		
		//วิธีการแก้ไข:
		List<Number> list1 = new ArrayList<Number>();  // OK : ใช้ประเภทที่ตรงกัน
		ArrayList<Integer> list2 = new ArrayList<>();  // OK :ใช้เฉพาะ Integer
	}
	
	/*
	 * ข้อผิดพลาดการคอมไพล์ในบรรทัดนี้: List<Number> list = new ArrayList<Integer>(); 
	 *  
	 *  List<Number> list = new ArrayList<Integer>();  // จะเกิดข้อผิดพลาด
	 *  
	 * สาเหตุ: Generics ของ Java ไม่สามารถทำการแปลงชนิดระหว่างคอลเลกชันที่ใช้ประเภทข้อมูลที่แคบกว่า 
	 * (เช่น ArrayList<Integer>) กับคอลเลกชันที่ใช้ประเภทข้อมูลที่กว้างกว่า (เช่น List<Number>) ได้
	 * 
	 * - ArrayList<Integer> เก็บได้เฉพาะ Integer แต่ 
	 *   List<Number> สามารถเก็บ Number อื่นๆ ได้ (เช่น Integer, Double, Float)
	 * - Java ไม่สามารถรับประกันว่า `ArrayList<Integer>` จะสามารถเก็บ `Number` ที่ไม่ใช่ `Integer` ได้
	 * 
	 * วิธีการแก้ไข:
	 * - ใช้ List<Number> กับ ArrayList<Number>:
	 *    List<Number> list = new ArrayList<Number>();  // ใช้ประเภทที่ตรงกัน
	 * - หรือใช้ ArrayList ที่กำหนดประเภทอย่างชัดเจน:
	 *    ArrayList<Integer> list = new ArrayList<>();  // ใช้เฉพาะ Integer
	 */
	
	
	
	static <A> void testGenericUndArray(A value , A...arr) {
		// Generics garantieren keine absolüte Typsicherheit
		// bei Arrays. Das Array kann beschädigt werden : 
		if(arr.length>0) {
			arr[0] = value; 	// evtl. java.lang.ArrayStoreException
		}
	}

}
