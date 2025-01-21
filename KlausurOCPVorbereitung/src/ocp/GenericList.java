package ocp;

public class GenericList {
	/*
	 * import java.util.*;
	 * class Apple { }
	 * class Macintosh extends Apple {
	 *   public static void main(String[] munch) {
	 *     List<Apple> a = new ArrayList<Apple>();
	 *     basket(a);
	 *   }
	 *   // insert code here
	 * }
	 * 
	 * Which, inserted at // insert code here, will compile? (Choose all that apply.)
	 * 
	 * A. static void basket(List<? super Apple> list) {list.add(new Object()); }
	 * 
	 * B. static void basket(List<? super Apple> list) {list.add(new Apple()); }
	 * 
	 * C. static void basket(List<Apple> list) {list.add(new Object()); }
	 * 
	 * D. static void basket(List<Apple> list) {list.add(new Apple()); }
	 * 
	 * E. static void basket(List<?> list) {list.add(new Apple()); }
	 * 
	 * F. static void basket(List<?> list) {list.size(); }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * B, D, and F are correct; they use generics rules and syntax correctly.
	 * 
	 * A, C, and E are incorrect. A and C are incorrect because a supertype object (in this case of type Object) 
	 * can't be inserted into a List of Apples. E is incorrect because the add() method isn't compatible with the ? syntax.
	 * 
	 * คำอธิบาย:
	 * 
	 * - A: ไม่ถูกต้อง เพราะ `List<? super Apple>` อนุญาตเฉพาะการเพิ่มออบเจ็กต์ที่เป็น `Apple` หรือชนิดย่อยของมัน 
	 *       การเพิ่ม `new Object()` จะทำให้เกิดข้อผิดพลาดการคอมไพล์
	 * 
	 * - B: ถูกต้อง เพราะ `List<? super Apple>` รองรับ `Apple` และชนิดย่อยของมัน การเพิ่ม `new Apple()` จึงทำได้
	 * 
	 * - C: ไม่ถูกต้อง เพราะ `List<Apple>` รับเฉพาะออบเจ็กต์ `Apple` การเพิ่ม `new Object()` จะไม่สามารถทำได้
	 * 
	 * - D: ถูกต้อง เพราะ `List<Apple>` รองรับการเพิ่มออบเจ็กต์ชนิด `Apple` การเพิ่ม `new Apple()` จึงใช้งานได้
	 * 
	 * - E: ไม่ถูกต้อง เพราะ `List<?>` เป็น wildcard ที่ไม่สามารถเพิ่มออบเจ็กต์ใหม่ใด ๆ ได้ 
	 *       แม้แต่ `Apple` ก็ไม่สามารถเพิ่มเข้าไปในลิสต์ได้
	 * 
	 * - F: ถูกต้อง เพราะ `List<?>` รองรับการเรียกใช้เมธอดที่ไม่ต้องการข้อมูลชนิด เช่น `size()` 
	 *       แต่ไม่สามารถเพิ่มหรือเปลี่ยนออบเจ็กต์ในลิสต์ได้
	 */

}
