package ocp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;



public class Stream12 {
	/*
	 * Stream<String> names = Stream.of("minnie", "mickey", "donald", "daffy");
	 * Optional<String> louie = names.filter(n -> n.equals("louie")).findFirst();
	 * 
	 * Which of the following will cause the code to display:
	 *  Sorry, no Louie in the console? Choose all that apply.
	 * 
	 * A.
	 * if (louie.get().equals("louie")) { 
	 *     System.out.println(louie); 
	 * } else { 
	 *     System.out.println("Sorry, no Louie"); 
	 * }
	 * 
	 * B.
	 * if (louie.get() != null) { 
	 *     System.out.println(louie); 
	 * } else { 
	 *     System.out.println("Sorry, no Louie"); 
	 * }
	 * 
	 * C.
	 * if (louie.isPresent()) { 
	 *     System.out.println(louie); 
	 * } else { 
	 *     System.out.println("Sorry, no Louie"); 
	 * }
	 * 
	 * D.
	 * louie.ifPresent(System.out::println);
	 * 
	 * E.
	 * System.out.println(louie.orElse("Sorry, no Louie"));
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
	 * C and E are correct. E is the preferred solution, but C also works.
	 * 
	 * A, B, and D are incorrect. A and B cause a NoSuchElementException to be thrown because louie is an empty optional. D runs, but doesn't print "Sorry, no Louie" in the case that louie is empty, which it is.
	 * 
	 * คำอธิบาย:
	 * - A: ข้อนี้ไม่ถูกต้อง เพราะหาก `louie` เป็น Optional ว่าง (empty), การเรียก `.get()` จะทำให้เกิด `NoSuchElementException`
	 * - B: ข้อนี้ไม่ถูกต้องเช่นกัน เพราะหาก `louie` เป็น Optional ว่าง, การตรวจสอบว่าไม่เป็น `null` ก็จะไม่ช่วยได้ และยังคงเกิด `NoSuchElementException`
	 * - C: ข้อนี้ถูกต้อง เพราะการใช้ `isPresent()` จะตรวจสอบว่า `louie` มีค่าอยู่หรือไม่ และถ้ามีค่าจะพิมพ์ค่าออกมา แต่ถ้าไม่มีก็จะพิมพ์ "Sorry, no Louie"
	 * - D: ข้อนี้ไม่ถูกต้อง เพราะ `ifPresent()` จะทำงานเฉพาะเมื่อมีค่าใน Optional ถ้าไม่มีค่าจะไม่ทำอะไรเลย ดังนั้นจะไม่พิมพ์ "Sorry, no Louie"
	 * - E: ข้อนี้ถูกต้องและเป็นวิธีที่แนะนำที่สุด เนื่องจาก `orElse()` จะคืนค่า "Sorry, no Louie" หาก `louie` เป็น Optional ว่าง
	 */



}
