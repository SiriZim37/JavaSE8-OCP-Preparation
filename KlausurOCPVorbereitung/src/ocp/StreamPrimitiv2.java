package ocp;

import java.util.stream.IntStream;

public class StreamPrimitiv2 {

	/*
	 * IntStream.iterate(0, i -> i + 2)
	 *          .filter(i -> i % 10 == 0)
	 *        // L1
	 *        .forEach(i -> System.out.print(i + " "));
	 * 
	 * Which code fragment(s), inserted independently at line L1, will display even numbers 
	 * divisible by 10 up through the number 50?
	 * 
	 * A. .range(0, 50)
	 * 
	 * B. .limit(50)
	 * 
	 * C. .limit(5)
	 * 
	 * D. .limit(6)
	 * 
	 * E. .skip(50)
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
	 * D is correct. Calling limit(6) limits the results to the first six even numbers: 0, 10, 20, 30, 40, 50.
	 * 
	 * A, B, C, and E are incorrect:
	 * - A: The method range() is a static method of IntStream, and it doesn’t apply here because we are not using a stream 
	 *      created from a range; instead, we are iterating with specific logic.
	 * - B: limit(50) will limit the stream to the first 50 numbers, not stopping at the value 50.
	 * - C: limit(5) will limit the stream to the first five numbers, which are 0, 10, 20, 30, and 40, so it excludes 50.
	 * - E: skip(50) will skip the first 50 numbers in the stream, leaving none in this case because our stream generates 
	 *      numbers in increments of 2 starting at 0, and we are filtering by multiples of 10.
	 * 
	 * คำอธิบายเพิ่มเติม (ไทย):
	 * - D: การใช้ `.limit(6)` จะจำกัดผลลัพธ์ให้อยู่ที่ตัวเลขคู่แรกที่หารด้วย 10 ได้ลงตัว 6 ตัว ได้แก่ 0, 10, 20, 30, 40, และ 50 ซึ่งเป็นคำตอบที่ถูกต้อง
	 * 
	 * - A: ไม่ถูกต้อง เนื่องจาก `.range()` เป็นเมธอดแบบสแตติกของ IntStream และไม่สามารถใช้ร่วมกับ `.iterate()` ได้ 
	 *       เพราะ `.range()` ใช้สำหรับสร้างสตรีมจากช่วงตัวเลข
	 * 
	 * - B: ไม่ถูกต้อง เพราะ `.limit(50)` จะจำกัดจำนวนตัวเลขไว้ที่ 50 ตัวแรกของสตรีม ไม่ได้จำกัดให้ถึงตัวเลข 50
	 * 
	 * - C: ไม่ถูกต้อง เนื่องจาก `.limit(5)` จะหยุดที่ตัวเลข 5 ตัวแรก ได้แก่ 0, 10, 20, 30, และ 40 ซึ่งไม่รวม 50
	 * 
	 * - E: ไม่ถูกต้อง เพราะ `.skip(50)` จะข้ามตัวเลข 50 ตัวแรกในสตรีม ซึ่งในกรณีนี้จะไม่เหลือตัวเลขใดเลย เนื่องจากสตรีมของเราสร้างตัวเลขคู่ทีละ 2 เริ่มจาก 0 และมีตัวกรองที่ทำให้เหลือเฉพาะตัวที่หารด้วย 10 ลงตัว
	 */
	
	
	public static void main(String[] args) {
		IntStream.iterate(0, i -> i + 2)					  // สร้าง Stream ตัวเลขเริ่มจาก 0 และเพิ่มทีละ 2
        .filter(i -> i % 10 == 0)							  // เลือกเฉพาะตัวเลขที่หารด้วย 10 ลงตัว
        .peek( (i) -> System.out.println( "peek=" +( i )) )	  // peek 0 10 20 30 40 50 
        .limit(6)										      // จำกัดผลลัพธ์แค่ 6 ตัวเลขแรก
        .forEach(i -> System.out.println("res= " + i + " ")); // แสดงตัวเลขสุดท้ายใน Stream
	}
}
