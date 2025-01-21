package ocp;

public class ComperatorComparable {
	
	/*
	 * import java.util.*;
	 * class Flubber {
	 *   public static void main(String[] args) {
	 *     List<String> x = new ArrayList<String>();
	 *     x.add(" x"); x.add("xx"); x.add("Xx");
	 *     // insert code here
	 *     for(String s: x) System.out.print(s + " ");
	 *   }
	 * }
	 * 
	 * Output:
	 * xx Xx  x
	 * 
	 * Which, inserted at // insert code here, will produce the preceding output?
	 * 
	 * A. Collections.sort(x);
	 * B. Comparable c = Collections.reverse();
	 *    Collections.sort(x, c);
	 * C. Comparator c = Collections.reverse();
	 *    Collections.sort(x, c);
	 * D. Comparable c = Collections.reverseOrder();
	 *    Collections.sort(x, c);
	 * E. Comparator c = Collections.reverseOrder();
	 *    Collections.sort(x, c);
	 * 
	 * E is correct. Natural ordering would produce output in reverse sequence to that listed. 
	 * The Collections.reverseOrder() method returns a Comparator, not a Comparable, to re-sort a Collection.
	 * 
	 * A, B, C, and D are incorrect based on the above.
	 * 
	 * 
	 * 
	 * ในลำดับการจัดเรียงตามปกติ:
	 * "Xx" จะมาก่อน "xx" เพราะตัวอักษร "X" มีค่า Unicode น้อยกว่าตัว "x".
	 * " x" (ที่มีช่องว่างข้างหน้า) จะถูกจัดเรียงหลังสุดในลำดับปกติ.
	 * >>>> " Xx", "xx", " x"
	 * 

	 * เมื่อใช้ Collections.reverseOrder() การจัดเรียงจะกลับลำดับจากการจัดเรียงตามปกติ:
	 * "x" ซึ่งปกติจะอยู่หลังสุด (เนื่องจากช่องว่าง) จะกลายเป็นตัวแรกในลำดับที่ย้อนกลับ.
	 * "xx" ซึ่งปกติจะอยู่ก่อน "Xx" จะถูกจัดให้อยู่หลัง "Xx" เพราะการกลับลำดับจะทำให้ "xx" ถูกจัดอยู่หลัง "Xx".
	 * "Xx" ซึ่งปกติจะอยู่ก่อน "xx" จะอยู่แรกสุดในลำดับย้อนกลับ.
	 * >>> xx Xx  x
	 * 
	 * คำอธิบาย:
	 * - A: ข้อนี้ไม่ถูกต้อง เพราะ `Collections.sort(x)` จะทำการเรียงลำดับตามลำดับปกติ (natural order) 
	 * 		ของข้อความ ซึ่งจะได้ผลลัพธ์ " x xx Xx" แต่ไม่ตรงกับผลลัพธ์ที่ต้องการ
	 * - B: ข้อนี้ไม่ถูกต้อง เพราะ `Collections.reverse()` ไม่สามารถใช้ได้โดยตรงกับการจัดเรียงในแบบ 
	 * 		`Comparable` ได้ และ `reverse()` ไม่มีการส่งคืนค่า `Comparator`
	 * - C: ข้อนี้ไม่ถูกต้อง เพราะ `Collections.reverse()` ก็ไม่สามารถใช้ได้เหมือนในข้อ B เนื่องจากมันไม่ได้คืนค่า
	 * 		 `Comparator` ที่สามารถนำมาใช้ใน `sort`
	 * - D: ข้อนี้ไม่ถูกต้อง เพราะ `Collections.reverseOrder()` ต้องการ `Comparator` และไม่สามารถใช้กับ 
	 * 		`Comparable` ได้ ข้อผิดพลาดคือการใช้ `Comparable` แทน `Comparator`
	 * - E: ข้อนี้ถูกต้อง เนื่องจาก `Collections.reverseOrder()` คืนค่าตัว `Comparator` 
	 * 		ซึ่งสามารถใช้ในการจัดเรียงลำดับในแบบย้อนกลับได้ และจะทำให้ผลลัพธ์ที่ได้เป็น "xx Xx  x"
	 */


}
