package ocp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;



public class Stream13 {
	/*
	 * Which of the following could you use to multiply 202 by 3 to get the result 606? (Choose all that apply.)
	 * 
	 * A. 
	 * IntStream.iterate(3, i -> i + 3).limit(202).max().getAsInt();
	 * 
	 * B. 
	 * Stream.iterate(3, i -> i + 3).limit(202).mapToInt(i->i).max().getAsInt();
	 * 
	 * C. 
	 * Stream.generate(() -> 3 * 202).limit(1).findFirst().get();
	 * 
	 * D. 
	 * IntStream.of(202, 202, 202).sum();
	 * 
	 * E. 
	 * Stream.of(202, 202, 202).mapToInt(i->i).sum();
	 * 
	 * F. 
	 * IntStream.of(202, 202, 202).reduce(0, (r1, r2) -> r1 + r2);
	 * 
	 * A, B, C, D, E, and F are correct. All of these solutions multiply 202 * 3 to get 606, just in different ways.
	 * None are incorrect.
	 * 
	  คำอธิบายเพิ่มเติมในภาษาไทย: คำถามนี้ต้องการให้เราหาวิธีต่าง ๆ ในการคูณ 202 ด้วย 3 เพื่อให้ได้ผลลัพธ์เป็น 606 
	  ซึ่งทุกตัวเลือก A, B, C, D, E, F ต่างก็เป็นวิธีที่สามารถทำได้ในลักษณะต่าง ๆ ทั้งการใช้ 
	  IntStream, Stream, หรือการใช้ reduce และ sum เพื่อให้ได้ผลลัพธ์ที่ตรงกัน โดยวิธีเหล่านี้ทำงานต่างกันแต่สามารถให้ผลลัพธ์เดียวกันได้

		A: ใช้ IntStream.iterate() เพื่อทำซ้ำเพิ่มค่า 3 จาก 3 ไปจนถึง 202 ครั้งแล้วหาค่าสูงสุด
		B: ใช้ Stream.iterate() เพื่อเพิ่ม 3 แล้วแปลงเป็น IntStream จากนั้นหาค่าสูงสุด
		C: ใช้ Stream.generate() สร้างค่า 3 * 202 และหาผลลัพธ์แรก
		D: ใช้ IntStream.of() เพื่อหาผลรวมของ 202 สามครั้ง
		E: ใช้ Stream.of() และแปลงเป็น IntStream แล้วหาผลรวม
		F: ใช้ IntStream.of() และใช้ reduce() ในการหาผลรวม
		ทั้งหมดนี้ทำงานได้อย่างถูกต้องในการคูณ 202 * 3 และให้ผลลัพธ์เป็น 606
	 */



}
