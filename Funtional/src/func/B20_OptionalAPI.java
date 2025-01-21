package func;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Consumer;

public class B20_OptionalAPI {

	public static void main(String[] args) {
		
		/*
		 * Optional mit statischen Fabrikmethoden erzeugen
		 * 
		 * ใน Java Optional ใช้เพื่อจัดการกับค่าที่อาจเป็น null อย่างปลอดภัย 
		 * และเราสามารถสร้างอินสแตนซ์ของ Optional ด้วยเมธอดแบบสถิต (static factory methods) ต่อไปนี้:
		 */
		
		//1. ใช้สำหรับสร้าง Optional ว่าง ซึ่งบ่งบอกว่าค่าไม่มีอยู่ (equivalent to null).
		Optional<Integer> op1 = Optional.empty();
		
		//2. ใช้สำหรับสร้าง Optional ที่มีค่า ซึ่งค่าที่ใส่เข้าไปต้องไม่เป็น null หากใส่ null จะเกิด NullPointerException
		Optional<Integer> op2 = Optional.of(12);
		
		//3.ใช้สำหรับสร้าง Optional ที่อาจมีค่า หรืออาจไม่มีค่า (เป็น null)
		//ถ้าค่าที่ใส่เป็น null จะคืน Optional.empty(), ถ้าไม่เป็น null ก็จะคืน Optional.of(value)
		Optional<Integer> op3 = Optional.ofNullable(12);
		Optional<Integer> op4 = Optional.ofNullable(null);
		
		/*
		 * eigene InstanzMethoden
		 * 
		 * 		- boolean isPresent() : ใช้ตรวจสอบว่า Optional นี้มีค่าหรือไม่
		 * 		- T get() : ใช้ดึงค่าจาก Optional ถ้าค่ามี ถ้าไม่มีจะเกิดข้อผิดพลาด
		 * 		- void ifPresent(Consumer action) : ใช้ดำเนินการบางอย่างกับค่าภายใน Optional ถ้ามีค่า
		 */
		
		Optional<Integer> maybeInt = Optional.of(12);
		
		if(maybeInt.isPresent()) {
			Integer value = maybeInt.get();
			System.out.println("vale = " + value);
		}
		
		// เปลี่ยน maybeInt เป็น Optional ว่าง
		maybeInt = Optional.empty();
		try {
			// เรียกใช้ get() กับ Optional ว่าง จะเกิด NoSuchElementException
			maybeInt.get(); // NoSuchElementException java.util.NoSuchElementException: No value present
		} catch (NoSuchElementException e) { 
			System.out.println("NoSuchElementException " + e );  // จะแสดงข้อความว่าไม่พบค่า
		}
		
		// สร้าง Consumer เพื่อใช้กับ ifPresent
		Consumer<Integer> action = x -> System.out.println("x = " + x);
		
		System.out.println("\n* Test mit empty-Optional");
		// ทดสอบกับ Optional ว่าง
		maybeInt.ifPresent(action); // maybeInt ว่าง จึงไม่ทำอะไร
		
		System.out.println("\n* Test mit empty-Optional, das einen Integer hat");
		// กำหนดค่าให้ maybeInt เป็น Optional ที่มีค่า 12
		maybeInt = Optional.of(12);
		maybeInt.ifPresent(action);  // จะทำการแสดงค่า x = 12
		


	}

}
