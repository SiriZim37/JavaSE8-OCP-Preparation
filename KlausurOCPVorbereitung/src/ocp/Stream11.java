package ocp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;



public class Stream11 {
	/*
	 * Given:
	 * Stream<IntStream> si = 
	 *    Stream.of(IntStream.of(1, 2, 3), IntStream.of(4, 5, 6), IntStream.of(7, 8, 9));
	 * // L1
	 * Which, inserted independently at line L1, will produce the output: 1 2 3 4 5 6 7 8 9
	 *
	 * A.
	 * si.forEach(i -> System.out.print(i + " "));
	 * 
	 * B.
	 * si.mapToInt(i -> i).forEach(i -> System.out.print(i + " "));
	 * 
	 * C.
	 * si.flatMapToInt(i -> i).forEach(i -> System.out.print(i + " "));
	 * 
	 * D.
	 * si.map(i -> i).forEach(i -> System.out.print(i + " "));
	 * 
	 * E.
	 * si.flatMap(i -> i).forEach(i -> System.out.print(i + " "));
	 * 
	 * 
	 * 
	 * **Answer: C.**
	 * 
	 * Explanation in Thai:
	 * คำตอบที่ถูกต้องคือ C. เนื่องจาก `si` เป็น Stream ของ IntStream ดังนั้นเราจึงต้องแปลงผลลัพธ์ให้อยู่ในรูปของ `IntStream`
	 * ด้วย `flatMapToInt()` เพื่อให้ได้ `IntStream` จาก Stream ของ IntStream และหลังจากนั้นก็สามารถใช้ `forEach()` เพื่อพิมพ์ค่าทั้งหมดได้
	 * 
	 * **เหตุผลที่คำตอบอื่นไม่ถูกต้อง:**
	 * - A: ใช้ `forEach()` โดยตรงบน Stream ของ IntStream ซึ่งจะไม่ได้ผลลัพธ์ที่ต้องการ เพราะมันจะพิมพ์ทั้ง `IntStream` แทนที่จะเป็นค่าใน `IntStream`
	 * - B: ใช้ `mapToInt()` ซึ่งไม่จำเป็นในกรณีนี้ เพราะ `si` เป็น Stream ของ IntStream แล้ว จึงไม่ต้องแปลงเป็น `IntStream` ด้วย `mapToInt()`
	 * - D: ใช้ `map()` ซึ่งจะไม่แปลง `IntStream` ให้เป็นค่าที่เราต้องการเหมือนกับ `flatMapToInt()`
	 * - E: ใช้ `flatMap()` ซึ่งจะให้ `Stream` แทน `IntStream` ที่เราต้องการ และไม่สามารถใช้งานได้ตรงกับการพิมพ์ค่าจาก `IntStream`
	 */



}
