package ocp;

import java.util.OptionalDouble;
import java.util.stream.DoubleStream;

public class Stream3 {
	public static void main(String[] args) {
		
		DoubleStream ds = DoubleStream.of(406.0, 407.2, 408.1, 406.5, 407.8);
		OptionalDouble m = ds.filter(ppm -> ppm > 409.0).min();
		System.out.println(m.getAsDouble());
		
		/*

			What is the result? (Choose all that apply?)
	
			A.	409.0
	
			B.	0.0
	
			C.	m is an empty optional
	
			D.	Code does not compile
	
			E.	A NoSuchElementException runtime exception
	
	
	
	
	
	
	
	
	
	
	
	
			C and E are correct. m is an empty optional because min() returns an optional and the stream is empty when we call min(). 
			We are trying to get a value from m without checking first to make sure there's a value present.
	
			A, B, and D are incorrect.
	
			Explanation in Thai:
			C และ E ถูกต้อง เพราะว่า `min()` จะคืนค่าเป็น `OptionalDouble` และในกรณีนี้ Stream จะว่างเปล่าเนื่องจากไม่มีค่าใดที่ตรงกับเงื่อนไข `ppm > 409.0` 
			ที่กำหนดใน `filter` เมื่อพยายามเรียกใช้ `m.getAsDouble()` 
			โดยที่ไม่ได้ตรวจสอบว่ามีค่าหรือไม่ จะเกิดข้อผิดพลาด `NoSuchElementException` 
			เนื่องจากไม่มีค่าที่เก็บอยู่ใน OptionalDouble
	
			A, B และ D ผิด เนื่องจาก:
			- A ผิด เพราะไม่มีค่าใดใน Stream ที่มากกว่า 409.0
			- B ผิด เพราะค่าเริ่มต้นของ `OptionalDouble` ที่ว่างเปล่าไม่ใช่ 0.0
			- D ผิด เพราะโค้ดนี้สามารถคอมไพล์ได้ถูกต้อง
		*/


	}

}
