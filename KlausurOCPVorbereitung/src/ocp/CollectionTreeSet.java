package ocp;

public class CollectionTreeSet {
	/*
	 * public static void before() {
	 *   Set set = new TreeSet();
	 *   set.add("2");
	 *   set.add(3);
	 *   set.add("1");
	 *   Iterator it = set.iterator();
	 *   while (it.hasNext())
	 *     System.out.print(it.next() + " ");
	 * }
	 * public static void after() {
	 *   Set<String> set = new TreeSet<String>();
	 *   set.add("2");
	 *   set.add(3);
	 *   set.add("1");
	 *   for (String s : set)
	 *     System.out.print(s + " ");
	 * }
	 * Which of the following statements are true? (Choose all that apply.)
	 * 
	 * A. The before() method will print "1 2 "
	 * B. The before() method will print "1 2 3 "
	 * C. The before() method will print three numbers, but the order cannot be reliably determined
	 * D. The before() method will not compile
	 * E. The before() method will throw an exception at runtime
	 * F. The after() method will print "1 2 "
	 * G. The after() method will print "1 2 3 "
	 * H. The after() method will print three numbers, but the order cannot be reliably determined
	 * I. The after() method will not compile
	 * J. The after() method will throw an exception at runtime
	 * 
	 * 
	 * 
	 * 
	 * 
	 * E and I are correct. For both methods, the problem is trying to put both Strings and ints into the same TreeSet. 
	 * For before(), with no generics, the compiler has no way of knowing what type is appropriate for this TreeSet, 
	 * so it allows everything to compile. At runtime, however, the TreeSet will try to sort the elements as they're added, 
	 * and when it tries to compare an Integer with a String, it will throw a ClassCastException before printing anything. 
	 * For the after() method, with generics the compiler knows that set is a Set of Strings, 
	 * so it will give a compile error the moment you try to add an Integer. 
	 * Note that although the before() method does not use generics, it does (perhaps accidentally) use autoboxing. 
	 * This may be easy to overlook if you're thinking of code as using either JDK 1.4 or 5.0 features. 
	 * Code may use some new features and some old features mixed together.
	 * 
	 * A, B, C, D, F, G, H, and J are incorrect based on the above.
	 * 
	 * คำอธิบาย:
	 * - E: วิธี `before()` จะทำให้เกิด `ClassCastException` ในขณะทำงาน เพราะมีการพยายามเปรียบเทียบ 
	 * 		`Integer` กับ `String` ใน `TreeSet` ซึ่งไม่สามารถทำได้ ทำให้เกิดข้อผิดพลาดใน runtime
	 * - I: วิธี `after()` จะไม่ทำการคอมไพล์ เนื่องจาก `TreeSet` ถูกประกาศเป็น `Set<String>`, 
	 * 		เมื่อพยายามเพิ่ม `Integer` (เช่น `set.add(3);`) คอมไพเลอร์จะเกิดข้อผิดพลาดในระหว่างคอมไพล์
	 * 
	 * ข้อผิดพลาดที่เกิดขึ้นในทั้งสองกรณีคือการพยายามผสมประเภทข้อมูลที่ไม่สามารถเปรียบเทียบกันได้ใน `TreeSet` ที่ไม่มีการใช้ `Generics`
	 * 
	 * ข้ออื่นๆ (A, B, C, D, F, G, H, J) ไม่ถูกต้องตามคำอธิบายด้านบน
	 */

}
