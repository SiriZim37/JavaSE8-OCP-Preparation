package ocp;

import java.util.Arrays;
import java.util.Comparator;

public class Comparator2 {
	
	public static void main(String[] args) {
		  String[] words = { "Good", "Bad", "Ugly" };
		  
		  Comparator<String> best = new Comparator<String>() {
		      public int compare(String s1, String s2) {
		        return s2.charAt(1) - s1.charAt(1);
		      }
		    };
		    Arrays.sort(words, best);
		    System.out.println(Arrays.toString(words));
		    System.out.println(words[0]);
	}
			
	/*
	 * 
	 * What is the result?
	 * 
	 * A.  Good
	 * 
	 * B.  Bad
	 * 
	 * C.  Ugly
	 * 
	 * D.  The code does not compile
	 * 
	 * E.  An exception is thrown at runtime
	 * 
	 * A is correct. There are a couple of things to notice. First, it's fine to declare the Comparator as an inner class. 
	 * Second, the compare() method, as implemented, reverses the natural order... using the array element's SECOND character. Ouch!
	 * 
	 * B, C, D, and E are incorrect based on the above.
	 * 
	 * คำอธิบาย:
	 * - A: ผลลัพธ์คือ "Good" เพราะ `compare()` เปรียบเทียบตัวอักษรที่ตำแหน่งที่ 1 ของแต่ละคำ 
	 * 		(เริ่มนับจาก 0) และทำการเรียงลำดับจากมากไปหาน้อย (Reverse Order) โดยใช้ตัวอักษรที่ตำแหน่งที่ 1 
	 * 		ของคำเท่านั้น ซึ่งจะได้คำว่า "Good" เป็นคำที่อยู่ตำแหน่งแรกหลังจากการจัดเรียง
	 * 		
	 * 		Good.charAt(1) > o
	 * 		Bad.charAt(1)  > a
	 * 		Ugly.charAt(1) > g
	 * 			
	 * - B, C: ข้อความ "Bad" และ "Ugly" จะไม่ถูกจัดลำดับให้อยู่ในตำแหน่งแรก 
	 * 		เพราะการเปรียบเทียบใช้ตัวอักษรที่ตำแหน่งที่ 1 (o, a, u) และ "o" ของ "Good" จะมากกว่าทั้ง "a" และ "u"
	 * - D: โค้ดจะสามารถคอมไพล์ได้ ไม่มีปัญหากับการประกาศ Comparator เป็นคลาสภายใน
	 * - E: ไม่มีข้อผิดพลาดที่ทำให้เกิด Exception ในการทำงานของโค้ดนี้
	 */

	
}
