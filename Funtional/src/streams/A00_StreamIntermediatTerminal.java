package streams;

public class A00_StreamIntermediatTerminal {

	/*
	 * Intermediate Operations (การดำเนินการขั้นกลาง) พร้อม Return Type
	 * 
	 * Method                    | Return Type      | คำอธิบาย (ภาษาไทย)
	 * ------------------------- | ---------------- | --------------------------------------------------------
	 * filter(Predicate)          | Stream<T>        | กรองข้อมูลตามเงื่อนไขที่กำหนด เช่น กรองค่าที่มากกว่า 10
	 * map(Function)              | Stream<R>        | แปลงแต่ละองค์ประกอบใน Stream ไปเป็นรูปแบบใหม่
	 * flatMap(Function)          | Stream<R>        | แปลงและรวมหลาย Stream ย่อยให้อยู่ใน Stream เดียว
	 * distinct()                 | Stream<T>        | กำจัดค่าซ้ำใน Stream
	 * sorted()                   | Stream<T>        | เรียงลำดับองค์ประกอบ (ค่าเริ่มต้นเรียงตามธรรมชาติ)
	 * sorted(Comparator)         | Stream<T>        | เรียงลำดับองค์ประกอบด้วย Comparator ที่กำหนดเอง
	 * limit(long n)              | Stream<T>        | จำกัดจำนวนองค์ประกอบใน Stream ให้ไม่เกิน n
	 * skip(long n)               | Stream<T>        | ข้าม (ละเว้น) องค์ประกอบ n ตัวแรกใน Stream
	 * peek(Consumer)             | Stream<T>        | ใช้ตรวจสอบหรือดำเนินการบางอย่างกับแต่ละองค์ประกอบระหว่างการประมวลผล
	 * 
	 * 
	 * Primitive Stream Operations (การดำเนินการกับ Primitive Stream)
	 * 
	 * Method                    | Return Type       | คำอธิบาย (ภาษาไทย)
	 * ------------------------- | ----------------  | --------------------------------------------------------
	 * sum()                      | int              | ผลรวมของค่าทั้งหมดใน IntStream
	 * average()                  | OptionalDouble   | คำนวณค่าเฉลี่ยใน IntStream
	 * count()                    | long             | นับจำนวนองค์ประกอบใน IntStream
	 * max()                      | OptionalInt      | หาค่ามากที่สุดใน IntStream
	 * min()                      | OptionalInt      | หาค่าต่ำที่สุดใน IntStream
	 * anyMatch(Predicate)        | boolean          | ตรวจสอบว่ามีองค์ประกอบใน IntStream ที่ตรงตามเงื่อนไขหรือไม่
	 * allMatch(Predicate)        | boolean          | ตรวจสอบว่าองค์ประกอบทั้งหมดใน IntStream ตรงตามเงื่อนไขหรือไม่
	 * noneMatch(Predicate)       | boolean          | ตรวจสอบว่าไม่มีองค์ประกอบใดใน IntStream ที่ตรงตามเงื่อนไข
	 * forEach(Consumer)          | void             | ประมวลผลองค์ประกอบแต่ละตัวใน IntStream
	 * 
	 * 
	 * Terminal Operations (การดำเนินการสุดท้าย) พร้อม Return Type
	 * 
	 * Method                    | Return Type      | คำอธิบาย (ภาษาไทย)
	 * ------------------------- | ---------------- | --------------------------------------------------------
	 * forEach(Consumer)          | void             | ประมวลผลองค์ประกอบแต่ละตัวใน Stream (ไม่มีผลลัพธ์คืนกลับมา)
	 * forEachOrdered(Consumer)   | void             | เหมือน forEach() แต่รักษาลำดับของ Stream (สำหรับ Parallel Stream)
	 * toArray()                  | Object[]         | แปลง Stream เป็น Array
	 * reduce(BinaryOperator)     | Optional<T>      | รวมค่าหรือคำนวณค่าจากองค์ประกอบใน Stream
	 * collect(Collector)         | <R> R            | เก็บผลลัพธ์จาก Stream ใน Collection หรือรูปแบบอื่นๆ
	 * min(Comparator)            | Optional<T>      | หาค่าที่น้อยที่สุดใน Stream
	 * max(Comparator)            | Optional<T>      | หาค่าที่มากที่สุดใน Stream
	 * count()                    | long             | นับจำนวนองค์ประกอบใน Stream
	 * anyMatch(Predicate)        | boolean          | ตรวจสอบว่ามีองค์ประกอบใดที่ตรงตามเงื่อนไขหรือไม่
	 * allMatch(Predicate)        | boolean          | ตรวจสอบว่าองค์ประกอบทั้งหมดตรงตามเงื่อนไขหรือไม่
	 * noneMatch(Predicate)       | boolean          | ตรวจสอบว่าไม่มีองค์ประกอบใดตรงตามเงื่อนไข
	 * findFirst()                | Optional<T>      | คืนค่าองค์ประกอบแรกใน Stream (ถ้ามี)
	 * findAny()                  | Optional<T>      | คืนค่าองค์ประกอบใดๆ ใน Stream (เหมาะสำหรับ Parallel Stream)
	 * 
	 * ข้อควรทราบ
	 * 
	 * - Intermediate Operations:
	 *    - ไม่ทำงานจนกว่าจะมีการเรียก Terminal Operation
	 *    - ส่งคืน Stream<T> (หรือ Stream<R>) ที่สามารถใช้งานได้ต่อไป
	 * 
	 * - Terminal Operations:
	 *    - ทำงานทันทีและปิด Stream
	 *    - ส่งคืนค่าประเภทต่างๆ เช่น void, Optional<T>, long, boolean, หรือ Collection ขึ้นอยู่กับลักษณะการทำงาน
	 * 
	 * การเลือกใช้ Intermediate และ Terminal ให้เหมาะสมจะช่วยให้สามารถทำงานกับข้อมูลได้มีประสิทธิภาพสูงสุด!
	 */

}
