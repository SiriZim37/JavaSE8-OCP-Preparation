package ocp;

public class ComparatorComparable2Theorie {
	/*
	 * Which are true? (Choose all that apply.)
	 * 
	 * A.  You can use java.lang.Comparable and java.util.Comparator to sort collections whose 
	 *     elements are of any valid Java type, as long as all of the collection's elements 
	 *     are of the same class.
	 * 
	 * B.  The java.lang.Object class implements the java.lang.Comparable interface.
	 * 
	 * C.  Many commonly used classes in the Java API (such as String, Integer, Date, and so on) 
	 *     implement the java.lang.Comparable interface.
	 * 
	 * D.  If your class implements java.lang.Comparable but you don't explicitly override 
	 *     Comparable's method, collections containing elements of your class will be sorted 
	 *     in natural order by default.
	 * 
	 * E.  When using the java.util.Comparator interface, you will typically create a separate class 
	 *     for every different sort sequence you want to implement, or you will use a lambda expression 
	 *     to stand in for the Comparator.
	 * 
	 * F.  The java.util.Comparator interface's method can take either one or two arguments.
	 * 
	 * G.  The binarySearch(), reverse(), and reverseOrder() methods in the java.util.Collections class 
	 *     all require that the collection is sorted before the method can be invoked successfully.
	 * 
	 * C and E are correct statements.
	 * 
	 * A, B, D, F, and G are incorrect.
	 * 
	 * คำอธิบาย:
	 * - C (ถูกต้อง): หลายคลาสใน Java API เช่น String, Integer และ Date ได้ implement 
	 * 			อินเทอร์เฟซ Comparable ซึ่งช่วยให้สามารถจัดเรียงตามลำดับธรรมชาติ (natural order) ได้ง่าย
	 * - E (ถูกต้อง): ในการใช้งาน Comparator มักจะสร้างคลาสแยกสำหรับลำดับที่แตกต่างกัน 
	 * 		หรือใช้ lambda expression เพื่อกำหนดลำดับได้สะดวก
	 * 
	 * เหตุผลว่าทำไมข้ออื่นไม่ถูกต้อง:
	 * - A: ไม่ถูกต้อง เพราะคลาสที่เป็น final และไม่ได้ implement Comparable อยู่แล้ว ไม่สามารถใช้ Comparable ในการจัดเรียงได้
	 * - B: ไม่ถูกต้อง เพราะคลาส java.lang.Object ไม่ได้ implement อินเทอร์เฟซ Comparable
	 * - D: ไม่ถูกต้อง เพราะถ้าคลาส implement Comparable จะต้อง implement เมธอด compareTo() เสมอ มิฉะนั้นจะเกิดข้อผิดพลาด
	 * - F: ไม่ถูกต้อง เพราะเมธอด compare() ของ Comparator รับพารามิเตอร์ได้เพียงสองตัวเท่านั้น
	 * - G: ไม่ถูกต้อง เพราะเมธอด reverse() ไม่ต้องการให้ collection ถูกจัดเรียงก่อน (แต่ binarySearch() และ reverseOrder() ต้องการ)
	 */

}
