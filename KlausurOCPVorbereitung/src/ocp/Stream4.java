package ocp;

import java.util.ArrayList;
import java.util.List;

class Bloom {
    String name;
    String month;
    public Bloom(String n, String m) {
        this.name = n; this.month = m;
    }
    public String getName() { return this.name; }
    public String getMonth() { return this.month; }
    public String toString() { return name + ": " + month; }
}



public class Stream4 {
	
	public static void main(String[] args) {
		List<Bloom> flowers = new ArrayList<>();
		flowers.add(new Bloom("Apple", "May"));
		flowers.add(new Bloom("Cherry", "April"));
		flowers.add(new Bloom("Dahlia", "June"));
		flowers.add(new Bloom("Poppy", "June"));
		flowers.add(new Bloom("Zinnia", "May"));
		flowers.add(new Bloom("Cosmos", "July"));
		flowers.add(new Bloom("Heather", "July"));
		flowers.add(new Bloom("Allium", "August"));
		// L1 
		//springFlowers.forEach((b, f) -> { if (b) { System.out.print(f + " "); }});
	}
	
	/*
	 *  * Which code fragment(s) could you insert independently at line L1 so that 
	 *   the code compiles and prints 
	 *	 all flowers that bloom in May or June? (Choose all that apply.)
	 * 
	 * A. 	List<Bloom> springFlowers = 
	 *             flowers.stream() 
	 *                 .collect(Collectors.toList(Bloom::getMonth)); 
	 * 
	 * B.	Map<Boolean, List<Bloom>> springFlowers = 
	 *             flowers.stream() 
	 *                 .collect(Collectors.groupingBy(
	 *                            f -> f.getMonth().equals("May") ||
	 *                                 f.getMonth().equals("June"))); 
	 * 
	 * C.	 Map<Boolean, List<Bloom>> springFlowers = 
	 *             flowers.stream() 
	 *                 .collect(Collectors.partitioningBy(
	 *                            f -> f.getMonth().equals("May") ||
	 *                                 f.getMonth().equals("June"))); 
	 * 
	 * D.	List<Bloom> springFlowers = 
	 *              flowers.stream() 
	 *                 .collect(Collectors.toList(
	 *                            f -> f.getMonth().equals("May") ||
	 *                                 f.getMonth().equals("June"))); 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * Correct Answers: B and C
	 * 
	 * Explanation:
	 * - **B**: This is correct because `groupingBy()` groups flowers into a `Map` where the keys are Boolean values. 
	 *           The Boolean is true if the flowers bloom in May or June, and false otherwise. This grouping creates 
	 *           a structure that can be used with the lambda at L1.
	 * - **C**: This is also correct because `partitioningBy()` creates a similar `Map` as B, grouping flowers based 
	 *           on a Predicate (true for May or June). Both B and C will compile and work with the given lambda at L1.
	 * 
	 * - **A**: Incorrect because `toList()` does not accept a Function. It collects elements into a `List` directly 
	 *           without filtering or transforming.
	 * - **D**: Incorrect because the use of `toList()` with a lambda is invalid. The `toList()` method does not accept 
	 *           arguments, so this will not compile.
	 * 
	 * คำอธิบาย (ภาษาไทย):
	 * - **B**: ข้อนี้ถูกต้อง เพราะ `groupingBy()` สร้าง Map ที่มี Boolean เป็น key โดย key จะเป็น true 
	 *           ถ้าดอกไม้บานในเดือนพฤษภาคมหรือมิถุนายน และ false สำหรับเดือนอื่น ๆ โครงสร้าง Map นี้สามารถ 
	 *           ใช้ได้กับ lambda ที่ L1
	 * - **C**: ข้อนี้ก็ถูกต้อง เพราะ `partitioningBy()` สร้าง Map ที่คล้ายกับ B โดยแบ่งกลุ่มดอกไม้ตาม Predicate 
	 *           ซึ่งให้ค่า true ถ้าบานในเดือนพฤษภาคมหรือมิถุนายน ทั้ง B และ C สามารถคอมไพล์และใช้งานได้
	 * 
	 * - **A**: ไม่ถูกต้อง เพราะ `toList()` ไม่สามารถรับ Function ได้ มันจะรวบรวม elements ลงใน List โดยตรง 
	 *           โดยไม่มีการกรองหรือแปลง
	 * - **D**: ไม่ถูกต้อง เพราะ `toList()` ไม่รองรับ lambda การใช้แบบนี้จะทำให้คอมไพล์ไม่ได้
	 */
	 
}
