package ocp;

public class Concurrency8 {
	/*
	 * double[] ppms = { 405.91, 405.98, 406.14, 406.48, 406.20, 
	 *                   406.03, 405.91, 406.91, 407.37 };
	 * DoubleStream s = Arrays.stream(ppms);
	 * long result = s.parallel()
	 *                .filter(d -> d > 406.5)
	 *                .peek(d -> System.out.print(d + " ")).count();
	 * 
	 * What is the result?
	 * 
	 * A. 407.37 406.91
	 * B. 406.91 407.37
	 * C. 407.37 406.91 or 406.91 407.37
	 * D. A compile-time error
	 * E. A runtime error
	 * 
	 * Correct Answer: C
	 * 
	 * Explanation:
	 * C is correct. We are parallel streaming doubles and calling filter() and peek(). 
	 * Because two threads may process the numbers in an unpredictable order, 
	 * we can’t tell in advance which number > 406.5 we will see first.
	 * 
	 * A, B, D, and E are incorrect.
	 * 
	 * คำอธิบาย:
	 * - คำตอบ C ถูกต้อง เนื่องจากเราใช้ parallel stream กับข้อมูลประเภท double และเรียกใช้ 
	 *   filter() เพื่อกรองข้อมูลที่มากกว่า 406.5 และ peek() เพื่อพิมพ์ค่าที่กรองได้ 
	 *   ลำดับของค่าที่แสดงผลอาจแตกต่างกันในแต่ละครั้งที่รันโปรแกรม เพราะการประมวลผลแบบขนาน 
	 *   อาจทำให้แต่ละเธรดประมวลผลข้อมูลในลำดับที่ไม่สามารถคาดการณ์ได้
	 * 
	 * - A และ B ไม่ถูกต้อง เพราะเราไม่สามารถคาดเดาลำดับของผลลัพธ์ที่แสดงได้
	 * - D ไม่ถูกต้อง เพราะโค้ดไม่มีข้อผิดพลาดในขณะคอมไพล์
	 * - E ไม่ถูกต้อง เพราะโค้ดไม่มีข้อผิดพลาดในขณะรัน
	 */

}
