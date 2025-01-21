package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class B04_Streams_terminal {
	
	/*
	 * Streams_terminal in Java
	 *
	 * A terminal operation in Java Streams is the final operation in a stream pipeline 
	 * that triggers the processing of the stream elements. 
	 * การดำเนินการแบบเทอร์มินัลใน Stream คือขั้นตอนสุดท้ายที่ทำให้เกิดการประมวลผลจริงในข้อมูลของ stream 
	 * หลังจากที่ terminal operation ถูกใช้งาน stream จะถูก "ปิด" และไม่สามารถใช้งานซ้ำได้อีก 
	 *
	 * Common Terminal Operations:
	 *
	 * 1. forEach()
	 *    - Executes a block of code for each element in the stream.
	 *    - ตัวอย่าง:
	 *      list.stream().forEach(System.out::println);
	 *      // forEach() จะทำงานกับแต่ละ element ใน stream และพิมพ์ออกมาทาง console
	 *
	 * 2. forEachOrdered()
	 *    - Similar to forEach(), but guarantees to process elements in the order they appear in the stream.
	 *    - ตัวอย่าง:
	 *      list.stream().forEachOrdered(System.out::println);
	 *      // forEachOrdered() จะทำงานตามลำดับที่ element ปรากฏใน stream
	 *
	 * 3. collect()
	 *    - Gathers the stream's elements into a collection or another data structure.
	 *    - ตัวอย่าง:
	 *      List<String> result = list.stream().collect(Collectors.toList());
	 *      // collect() จะเก็บข้อมูลที่ผ่าน stream ลงในโครงสร้างข้อมูลเช่น List หรือ Set
	 *
	 * 4. reduce()
	 *    - Reduces the elements of the stream to a single value using a BinaryOperator.
	 *    - ตัวอย่าง:
	 *      int sum = list.stream().mapToInt(String::length).reduce(0, Integer::sum);
	 *      // reduce() จะรวมค่าใน stream ให้อยู่ในรูปของค่าผลรวมเดียว
	 *
	 * 5. count()
	 *    - Counts the number of elements in the stream.
	 *    - ตัวอย่าง:
	 *      long count = list.stream().count();
	 *      // count() ใช้ในการนับจำนวน elements ที่อยู่ใน stream
	 *
	 * 6. findFirst() / findAny()
	 *    - Finds the first or any element in the stream.
	 *    - ตัวอย่าง:
	 *      Optional<String> first = list.stream().findFirst();
	 *      // findFirst() ใช้ในการดึงค่า element แรกที่อยู่ใน stream
	 *
	 * 7. allMatch(), anyMatch(), noneMatch()
	 *    - Check if all, any, or none of the stream elements match a given predicate.
	 *    - ตัวอย่าง:
	 *      boolean allMatch = list.stream().allMatch(name -> name.startsWith("B"));
	 *      // allMatch() เช็คว่าทุก element ตรงตามเงื่อนไขหรือไม่
	 *
	 * 8. toArray()
	 *    - Converts the stream into an array.
	 *    - ตัวอย่าง:
	 *      String[] array = list.stream().toArray(String[]::new);
	 *      // toArray() จะเก็บข้อมูลจาก stream ลงใน array
	 *
	 * 9. min() / max()
	 *    - Finds the minimum or maximum element in the stream based on a comparator.
	 *    - ตัวอย่าง:
	 *      Optional<String> min = list.stream().min(String::compareTo);
	 *      // min() ใช้ในการหาค่าต่ำสุดใน stream
	 *
	 * 10. anyMatch()
	 *     - Checks if any elements of the stream match the provided predicate.
	 *     - ตัวอย่าง:
	 *       boolean hasB = list.stream().anyMatch(name -> name.startsWith("B"));
	 *       // anyMatch() เช็คว่ามี element ใดที่ตรงตามเงื่อนไขหรือไม่
	 *
	 * 11. noneMatch()
	 *     - Checks if no elements of the stream match the provided predicate.
	 *     - ตัวอย่าง:
	 *       boolean noneStartWithB = list.stream().noneMatch(name -> name.startsWith("B"));
	 *       // noneMatch() เช็คว่าทุก element ไม่ตรงตามเงื่อนไข
	 *
	 * 12. sum()
	 *     - Calculates the sum of the elements in the stream (for numeric streams).
	 *     - ตัวอย่าง:
	 *       int totalLength = list.stream().mapToInt(String::length).sum();
	 *       // sum() จะคำนวณผลรวมของความยาวของทุก element ใน stream
	 *
	 * Summary:
	 * - Streams_terminal (English): Final operation that triggers processing of elements.
	 * - Streams_terminal (Thai): การดำเนินการสุดท้ายที่ทำให้ stream ประมวลผล
	 */

	public static void main(String[] args) {

		System.out.println("***normale forEach ");
		// forEach
		// Reihenfolge bei parallelen Streams nicht vorhersehbar
		
		Stream.of(1,2,3,4,5,6)
			.parallel()
			.map( i -> i*10)
			.forEach(System.out::println);
		
		System.out.println("\n***forEachOrdered ");
		// forEachOrdered
		// Reihenfolge auch bei parallelen Streams vorhersehbar
		Stream.of(1,2,3,4,5,6)
			.parallel()
			.map( i -> i*10)
			.forEachOrdered(System.out::println);
		
		long anzahl = Stream.of(1,2,3,4,5,6).count();
		System.out.println("Anzahl = " + anzahl); 	//	 6
		
		int summe = Stream.of(1,2,3,4,5,6).mapToInt( i -> i).sum();
		System.out.println("Summe = " + summe);  	//	21
		
		//min und max
		IntStream stream = new Random().ints(10 , 100 , 200);
		System.out.println("min : " + stream.min());		
		
		stream = new Random().ints(10 , 100 , 200);
		System.out.println("max : " + stream.max());
		
		List<String> list = Arrays.asList("Wilma", "Fred", "Pebbles", "Barney", "Betty", "Bambam");

		System.out.println("min : " + list.stream().min(Comparator.naturalOrder()));
		System.out.println("max : " + list.stream().max(Comparator.naturalOrder()));
		
		
	    Comparator<String> cmp = (String s1, String s2) -> s1.compareTo(s2);
	    System.out.println("min : " + list.stream()
										    .min(cmp)
										    .orElse("No minimum found")); // Bambam

        System.out.println("max : " + list.stream()
									        .min( (s1,s2) -> s2.compareTo(s1) )
									        .orElse("No minimum found")
									        );  //  Wilma
        
        
       
	}

}
