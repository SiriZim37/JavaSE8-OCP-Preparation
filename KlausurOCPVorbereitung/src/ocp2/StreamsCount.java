package ocp2;

import java.util.Arrays;
import java.util.List;

public class StreamsCount {

	public static void main(String[] args) {
		List<String> listVal = Arrays.asList("Joe", "Paul", "Alice", "Tom");
		System.out.println(
		// line n1
		);

	}
}
	
	/*
	  Which code fragment, when inserted at line n1, enables the code 
	  to print the count of string elements 
	  whose length is greater than three?
		 A. listVal.stream().filter(x -> x.length()>3).count()
		 B. listVal.stream().map(x -> x.length()>3).count()
		 C. listVal.stream().peek(x -> x.length()>3).count().get()
		 D. listVal.stream().filter(x -> x.length()>3).mapToInt(x -> x).count(
	 */
	
	/*
	 /*
	คำอธิบายเกี่ยวกับตัวเลือกต่างๆ:
	
	เรามีโค้ดต่อไปนี้:
	List<String> listVal = Arrays.asList("Joe", "Paul", "Alice", "Tom");
	
	โค้ดนี้สร้างลิสต์ที่ประกอบไปด้วยสตริง 4 ตัว ได้แก่ "Joe", "Paul", "Alice", และ "Tom". เป้าหมายของเราคือการหาจำนวนสตริงที่มีความยาวมากกว่า 3 ตัวอักษร.
	
	ตัวเลือกต่างๆ ที่เราได้มาพิจารณาคือ:
	
	1. A. `listVal.stream().filter(x -> x.length() > 3).count()`
	
	    - **คำอธิบาย**:
	      - `stream()` สร้าง Stream จากลิสต์ `listVal` ซึ่งทำให้เราสามารถใช้งานการประมวลผลต่างๆ เช่น การกรอง (filter), การแปลง (map), การนับ (count) ฯลฯ
	      - `filter(x -> x.length() > 3)` ใช้กรอง (filter) เอาเฉพาะสตริงที่มีความยาวมากกว่า 3 ตัวอักษร
	      - `count()` นับจำนวนสตริงที่ผ่านเงื่อนไขการกรอง (ในที่นี้คือสตริงที่มีความยาวมากกว่า 3)
	    - **ผลลัพธ์**:
	      สตริงที่มีความยาวมากกว่า 3 ตัวอักษร ได้แก่ "Paul", "Alice", และ "Tom" ซึ่งมีจำนวนทั้งหมด 3 ตัว ดังนั้นคำตอบจะเป็น `3`
	    - **ผลลัพธ์ที่ได้**: **ถูกต้อง**
	
	2. B. `listVal.stream().map(x -> x.length() > 3).count()`
	
	    - **คำอธิบาย**:
	      - `map(x -> x.length() > 3)` จะทำการแปลงค่าของแต่ละสตริงให้เป็น `true` หรือ `false` ขึ้นอยู่กับว่าเงื่อนไข `x.length() > 3` เป็นจริงหรือไม่
	      - `count()` จะนับจำนวนค่าที่เป็น `true` (จำนวนสตริงที่มีความยาวมากกว่า 3)
	    - **ผลลัพธ์**:
	      ตัวเลือกนี้จะให้จำนวนของ `true` ที่เกิดจากการแปลงค่าเป็น `boolean` แต่เราต้องการแค่การกรองแล้วนับจำนวนสตริงที่ตรงกับเงื่อนไข ซึ่งตัวเลือกนี้ไม่ถูกต้องในการใช้งานแบบนี้
	    - **ผลลัพธ์ที่ได้**: **ไม่ถูกต้อง**
	
	3. C. `listVal.stream().peek(x -> x.length() > 3).count().get()`
	
	    - **คำอธิบาย**:
	      - `peek(x -> x.length() > 3)` ใช้สำหรับการตรวจสอบค่าของข้อมูลในสตรีม (โดยไม่เปลี่ยนแปลงข้อมูล) ซึ่งเหมาะสำหรับการดีบัก แต่ไม่ใช้สำหรับการกรองข้อมูล
	      - `count()` จะนับจำนวนอิลิเมนต์ในสตรีม (ที่ไม่ได้ถูกกรองจริงๆ) และคืนค่าผลลัพธ์เป็น `long`
	      - `.get()` ไม่สามารถใช้ได้กับ `long` ซึ่งเป็นผลลัพธ์จาก `count()`
	    - **ผลลัพธ์**:
	      ตัวเลือกนี้จะทำให้เกิดข้อผิดพลาดในโค้ด เนื่องจาก `.get()` ไม่สามารถใช้ได้กับ `count()` ซึ่งคืนค่าประเภท `long`
	    - **ผลลัพธ์ที่ได้**: **ไม่ถูกต้อง** (เกิดข้อผิดพลาดในการคอมไพล์)
	
	4. D. `listVal.stream().filter(x -> x.length() > 3).mapToInt(x -> x).count()`
	
	    - **คำอธิบาย**:
	      - `filter(x -> x.length() > 3)` ใช้กรองสตริงที่มีความยาวมากกว่า 3
	      - `mapToInt(x -> x)` พยายามแปลงค่าของแต่ละสตริงเป็น `int` แต่เนื่องจาก `x` เป็นสตริง เราไม่สามารถแปลงมันเป็น `int` ได้ในลักษณะนี้
	      - `count()` จะนับจำนวนอิลิเมนต์หลังจากการแปลง
	    - **ผลลัพธ์**:
	      ตัวเลือกนี้ไม่สามารถทำงานได้เพราะ `mapToInt(x -> x)` จะทำให้เกิดข้อผิดพลาดในการคอมไพล์ เนื่องจากไม่สามารถแปลงจากสตริงเป็น `int` ได้
	    - **ผลลัพธ์ที่ได้**: **ไม่ถูกต้อง**
	
	**คำตอบที่ถูกต้องคือ A**:
	`listVal.stream().filter(x -> x.length() > 3).count()` ใช้การกรองสตริงที่มีความยาวมากกว่า 3 ตัวอักษร จากนั้นนับจำนวนสตริงที่ตรงกับเงื่อนไขและแสดงผลลัพธ์ได้ถูกต้อง
	*/


