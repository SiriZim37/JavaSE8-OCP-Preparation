package ocp;

public class StreamGenerateSupplyAndConsume {
	/*
	 * class Dog {
	 *     String name;
	 *     public Dog() { this.name = "Fido"; }
	 *     public String toString() { return "Dog, named " + name; }
	 * }
	 * 
	 * and this fragment:
	 * 
	 * Stream<Dog> sd = Stream.generate( F1 );
	 * List<Dog> dogs = sd.limit(4).collect(Collectors.toList());
	 * dogs.forEach( F2 );
	 * 
	 * Which of the following, inserted independently at F1 and F2, will cause the code to compile and produce the output:
	 * 
	 * Dog, named Fido
	 * Dog, named Fido
	 * Dog, named Fido
	 * Dog, named Fido
	 * 
	 * Choose all that apply.
	 * 
	 * A. new Dog()                   // F1
	 *    System.out.println()         // F2
	 * 
	 * B. Dog::new                    // F1
	 *    System.out::println()        // F2
	 * 
	 * C. Dog::new                    // F1
	 *    System.out::println          // F2
	 * 
	 * D. () -> new Dog()             // F1
	 *    (d) -> System.out.println(d) // F2
	 * 
	 * E. Dog.new                     // F1
	 *    System.out.println           // F2
	 * 
	 * 
	 * 
	 * 
	 * 
	 * C and D are correct. F1 requires a Supplier to supply new Dogs to Stream.generate(), 
	 * and we can either use a lambda expression to call new Dog() or use a constructor method reference. 
	 * F2 requires a Consumer, which again, we can represent either with a lambda expression that takes a value 
	 * and does not return a value or a method reference that stands in for that Consumer.
	 * 
	 * A, B, and E are incorrect.
	 * 
	 * คำอธิบาย:
	 * - F1 ต้องการ Supplier ซึ่งคือฟังก์ชันที่ให้ค่า (ในที่นี้คือการสร้างอ็อบเจ็กต์ Dog ใหม่) และในกรณีนี้ เราสามารถใช้การอ้างอิงเมธอด constructor (Dog::new) หรือใช้ lambda expression ที่สร้าง Dog ใหม่ ( () -> new Dog() )
	 * - F2 ต้องการ Consumer ซึ่งเป็นฟังก์ชันที่รับค่าเข้าและไม่คืนค่าอะไร (เช่น การพิมพ์ค่าออกมา) ดังนั้นเราสามารถใช้ method reference สำหรับ System.out.println หรือ lambda expression ที่รับค่าและพิมพ์ออก ( (d) -> System.out.println(d) )
	 * 
	 * ข้อที่ถูกต้อง:
	 * - C: ใช้การอ้างอิงเมธอด constructor (Dog::new) และการอ้างอิงเมธอดสำหรับพิมพ์ (System.out::println)
	 * - D: ใช้ lambda expression ในการสร้าง Dog ใหม่ ( () -> new Dog() ) และ lambda expression สำหรับพิมพ์ ( (d) -> System.out.println(d) )
	 * 
	 * ข้อที่ไม่ถูกต้อง:
	 * - A: ไม่ถูกต้อง เพราะ System.out.println() เป็น method ที่ไม่ได้รับค่า และไม่สามารถใช้เป็น Consumer ได้
	 * - B: ไม่ถูกต้อง เพราะ System.out::println ต้องการการอ้างอิงเมธอดที่ใช้กับตัวแปร ไม่สามารถใช้เป็น Consumer ได้
	 * - E: ไม่ถูกต้อง เพราะ Dog.new ไม่มีอยู่ใน Java
	 */

}
