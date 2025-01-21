package ocp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Stream6 {
	

	public static void main(String[] args) {
		List<String> eagles = new ArrayList<>();
		eagles.add("Bald eagle "); 
		eagles.add("Golden eagle "); 
		eagles.add("Bateleur eagle ");
		eagles.stream()
		      .filter(e -> e.startsWith("B"))
		      .peek(System.out::print)
		      .map(e -> e.toLowerCase());
		
		// will show peek (count and filter activ )
		long count = eagles.stream()
			      .filter(e -> e.startsWith("B"))
			      .peek(System.out::print)
			      .map(e -> e.toLowerCase())
				  .count();	

	}
}
/*
 * List<String> eagles = new ArrayList<>();
 * eagles.add("Bald eagle "); 
 * eagles.add("Golden eagle "); 
 * eagles.add("Bateleur eagle ");
 * eagles.stream()
 *       .filter(e -> e.startsWith("B"))
 *       .peek(System.out::print)
 *       .map(e -> e.toLowerCase());
 * What is the result?
 *
 * A. Bald eagle Golden eagle Bateleur eagle
 * 
 * B. bald eagle golden eagle bateleur eagle
 * 
 * C. Bald eagle Bateleur eagle
 * 
 * D. bald eagle bateleur eagle
 * 
 * E. No output is produced
 * 
 * 
 * 
 * E is correct. The stream has no terminal operation, so none of the stream operations are executed.
 * 
 * A, B, C, and D are incorrect.
 * 
 * คำอธิบาย:
 * - A, B, C, D: ข้อความทั้งหมดนี้ไม่ถูกต้อง เพราะไม่มีการใช้ terminal operation ในสตรีมทำให้ไม่มีผลลัพธ์ใด ๆ ถูกผลิต
 * - E: ข้อความนี้ถูกต้อง เพราะเมื่อไม่มี terminal operation เช่น forEach(), collect(), หรือ any other terminal operation ที่จะทำให้สตรีมถูกกระตุ้นให้ทำงาน ไม่มีการประมวลผลใด ๆ เกิดขึ้น ดังนั้นจะไม่มีการแสดงผลออกมา
 * 
 * ในกรณีนี้ถึงแม้จะมีการใช้ peek และ map แต่เนื่องจากไม่มี terminal operation เพื่อกระตุ้นการทำงานของ stream จึงไม่มีผลลัพธ์ที่เกิดขึ้น
 */

