package ocp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;



public class Stream10 {
	/*
	 * public class Reading {
	 *       int year;
	 *       double extent;
	 *       public Reading(int y, double e) { this.year = y; this.extent = e; }
	 *       public int getYear() { return this.year; }
	 *       public double getExtent() { return this.extent; }
	 *       public String toString() { return extent + " in " + year; } 
	 * }
	 *
	 * List<Reading> readings = new ArrayList<>();
	 * readings.add(new Reading(2002, 5.98)); 
	 * readings.add(new Reading(2007, 4.32)); 
	 * readings.add(new Reading(2012, 3.63)); 
	 * readings.add(new Reading(2017, 4.64)); 
	 * // L1
	 * 
	 * Which code fragment(s), inserted independently at line L1, will cause the code to compile 
	 * and print the year field of the Readings in the List readings to the console? (Choose all that apply.)
	 *
	 * A.
	 *		Function<Reading, Integer> f = r -> r.getYear();
	 *   		 readings.stream().map(f).forEach(System.out::println);
	 *
	 * B.
	 *		 Function<Reading, Integer> f = r -> r.getYear();
	 *   		 readings.stream().map(f.apply()).forEach(System.out::println);
	 *
	 * C.
	 * 		UnaryOperator<Reading, Integer> f = r -> r.getYear();
	 *    		readings.stream().map(f).forEach(System.out::println);
	 *
	 * D.
	 * 		readings.stream().map((r) -> r.getYear()).forEach(System.out::println);
	 *
	 * E.
	 * 		readings.stream().mapToInt((r) -> r.getYear()).forEach(System.out::println);
	 *
	 *
	 *
	 * A, D, and E are correct. In A and D, note that we are mapping from Stream<Reading> to Stream<Integer>, while in E, we are mapping from Stream<Reading> to IntStream.
	 *
	 * B and C are incorrect. In B, we are calling f.apply(), but map() is responsible for calling the apply() method of the Function we pass in behind the scenes. In C, f is a Function, not an operator (the argument type is different from the return type).
	 *
	 * คำอธิบาย:
	 * - A: ในตัวเลือก A ใช้ Function<Reading, Integer> ที่ส่งคืนปีจากการใช้ method getYear() ใน class Reading ซึ่งเป็นวิธีที่ถูกต้องในการใช้ stream ในการแปลงค่าจาก Stream<Reading> เป็น Stream<Integer> แล้วใช้ forEach เพื่อพิมพ์ค่าปี
	 * - D: ตัวเลือก D ใช้รูปแบบ lambda (r) -> r.getYear() ที่ทำให้แปลงจาก Stream<Reading> เป็น Stream<Integer> เช่นเดียวกับใน A และใช้ forEach พิมพ์ปี
	 * - E: ในตัวเลือก E ใช้ mapToInt ซึ่งจะทำการแปลงจาก Stream<Reading> เป็น IntStream ซึ่งเหมาะสมกับการแปลงข้อมูลชนิด int และพิมพ์ปีออกมา
	 * 
	 * - B: ตัวเลือก B ผิด เพราะ map() ไม่ต้องใช้การเรียก f.apply() เราจะต้องใช้ lambda expression ตรงๆ ใน map ซึ่งจะทำให้ map() เรียก apply() โดยอัตโนมัติ
	 * - C: ตัวเลือก C ผิด เพราะ UnaryOperator เป็นตัวที่ใช้กับค่าเดิมและค่าใหม่ที่ตรงกัน (การแปลงค่าที่เป็นประเภทเดียวกัน) แต่ในที่นี้เราใช้ Function ซึ่งการส่งคืนค่าไม่ตรงกับประเภทที่ UnaryOperator คาดหวัง
	 */



}
