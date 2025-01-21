package streams;

import java.util.Arrays;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;



public class B03_Streams_intermediate {

	/*
	 * den Piepline wird von link nach recht durchführen !
	 */
	
	/*
		Stream intermediate operations ใน Java SE 8 ใช้ในการ transform หรือ modify ข้อมูลใน stream
		โดยที่มันไม่ให้ผลลัพธ์ทันที เช่น การใช้ filter() เพื่อกรองข้อมูล, map() เพื่อเปลี่ยนข้อมูล 
		หรือ sorted() เพื่อเรียงลำดับข้อมูล การดำเนินการเหล่านี้จะเป็นแบบ "lazy" execution
		ซึ่งหมายความว่ามันจะยังไม่ถูกประมวลผลจนกว่าจะมี terminal operation มากระตุ้น
		ตัวอย่างของ terminal operations ได้แก่ forEach(), collect(), reduce() 
		
		Common Terminal Operations:
		
		 1. forEach()
		    - Executes a block of code for each element in the stream.
		    - ตัวอย่าง:
		      list.stream().forEach(System.out::println);
		      // forEach() จะทำงานกับแต่ละ element ใน stream และพิมพ์ออกมาทาง console
		
		 2. forEachOrdered()
		    - Similar to forEach(), but guarantees to process elements in the order they appear in the stream.
		    - ตัวอย่าง:
		      list.stream().forEachOrdered(System.out::println);
		      // forEachOrdered() จะทำงานตามลำดับที่ element ปรากฏใน stream
		
		 3. collect()
		    - Gathers the stream's elements into a collection or another data structure.
		    - ตัวอย่าง:
		      List<String> result = list.stream().collect(Collectors.toList());
		      // collect() จะเก็บข้อมูลที่ผ่าน stream ลงในโครงสร้างข้อมูลเช่น List หรือ Set
		
		 4. reduce()
		    - Reduces the elements of the stream to a single value using a BinaryOperator.
		    - ตัวอย่าง:
		      int sum = list.stream().mapToInt(String::length).reduce(0, Integer::sum);
		      // reduce() จะรวมค่าใน stream ให้อยู่ในรูปของค่าผลรวมเดียว
		
		 5. count()
		    - Counts the number of elements in the stream.
		    - ตัวอย่าง:
		      long count = list.stream().count();
		      // count() ใช้ในการนับจำนวน elements ที่อยู่ใน stream
		
		 6. findFirst() / findAny()
		    - Finds the first or any element in the stream.
		    - ตัวอย่าง:
		      Optional<String> first = list.stream().findFirst();
		      // findFirst() ใช้ในการดึงค่า element แรกที่อยู่ใน stream
		
		 7. allMatch(), anyMatch(), noneMatch()
		    - Check if all, any, or none of the stream elements match a given predicate.
		    - ตัวอย่าง:
		      boolean allMatch = list.stream().allMatch(name -> name.startsWith("B"));
		      // allMatch() เช็คว่าทุก element ตรงตามเงื่อนไขหรือไม่
		
		 8. toArray()
		    - Converts the stream into an array.
		    - ตัวอย่าง:
		      String[] array = list.stream().toArray(String[]::new);
		      // toArray() จะเก็บข้อมูลจาก stream ลงใน array
		
		 9. min() / max()
		    - Finds the minimum or maximum element in the stream based on a comparator.
		    - ตัวอย่าง:
		      Optional<String> min = list.stream().min(String::compareTo);
		      // min() ใช้ในการหาค่าต่ำสุดใน stream
		
		 10. anyMatch()
		     - Checks if any elements of the stream match the provided predicate.
		     - ตัวอย่าง:
		       boolean hasB = list.stream().anyMatch(name -> name.startsWith("B"));
		       // anyMatch() เช็คว่ามี element ใดที่ตรงตามเงื่อนไขหรือไม่
		
		 11. noneMatch()
		     - Checks if no elements of the stream match the provided predicate.
		     - ตัวอย่าง:
		       boolean noneStartWithB = list.stream().noneMatch(name -> name.startsWith("B"));
		       // noneMatch() เช็คว่าทุก element ไม่ตรงตามเงื่อนไข
		
		 12. sum()
		     - Calculates the sum of the elements in the stream (for numeric streams).
		     - ตัวอย่าง:
		       int totalLength = list.stream().mapToInt(String::length).sum();
		       // sum() จะคำนวณผลรวมของความยาวของทุก element ใน stream
		
		 Summary:
		 - Streams_terminal (English): Final operation that triggers processing of elements.
		 - Streams_terminal (Thai): การดำเนินการสุดท้ายที่ทำให้ stream ประมวลผล
	 */
	
	public static void main(String[] args) {

		List<String> list = Arrays.asList("Wilma " , "Fred " , "Pebbles ", "Barney " , "Betty " , "Bambam ");
		
		Predicate<String> pred = name -> name.startsWith("B");
		
		System.out.println("***#A1. filter-Methode mit Predicate ****");
	
		/*
		 *  filter-Methode mit Predicate
		 *  
		 *  ใช้ filter() เพื่อเลือกเฉพาะชื่อที่ตรงตามเงื่อนไข
		 *  
		 */
		// Ausgabe : Barney Betty	Bambam
		list.stream().filter(pred).forEach(System.out::print);
		
		split();
		
		System.out.println("\n\n***#A2. sorted-Methode mit Comparator ****");
		/*
		 * sorted-Methode mit Comparator
		 * 
		 * sorted() kann irgendwo aufrufen.
		 * sorted() เรียงลำดับตามอักษรโดยอัตโนมัติ
		 */
		// Ausgabe : Bambam Barney Betty 
		list.stream().filter(name -> name.startsWith("B")).sorted().forEach(System.out::print);
		
		
		System.out.println("\n1. sort : ");
		
		
		// Ausgabe : Bambam Barney Betty	
		list.stream().sorted().filter(name -> name.startsWith("B")).forEach(System.out::print); //*** Reihen folge sorted -limit wichtig
		
		
		System.out.println("\n2**. sort : ");
		//  Stream<T> sorted(Comparator<? super T> comparator)
		
		// Ausgabe : Betty Barney Bambam 
		list.stream().sorted(Comparator.reverseOrder()).filter(name -> name.startsWith("B")).forEach(System.out::print);
		
		split();
		
		System.out.println("\n\n***#A3. Limit-Methode ****");
		/*
		 * Limit Methode 
		 * จำกัดจำนวนข้อมูลใน stream
		 * 
		 * ใช้ limit() เพื่อลดจำนวนข้อมูลที่จะประมวลผล
		 *  sorted() kann irgendwo aufrufen. 
		 *  
		 *  !! Das Ergebnis ist immer gleich
		 */
		
		System.out.println("3. sort : ");
		
		// Ausgabe : Wilma Fred Pebbles 
		list.stream().limit(3).forEach(System.out::print);
		
		System.out.println("\n4. limit und dann sorted  : ");
		
		// Ausgabe : Fred Pebbles Wilma 
		list.stream().limit(3).sorted().forEach(System.out::print);
		
		System.out.println("\n5. sorted und dann limit ");
	
		// Ausgabe : Bambam Barney Betty 
		list.stream().sorted().limit(3).forEach(System.out::print);	 // Reihen folge sorted -limit wichtig
		
		
		split();
	
		System.out.println("\n\n***#A4. Skip-Methode ****");
			/*
		 * Skip Methode  ข้ามข้อมูล n elements แรก
		 * 
		 * ใช้ skip() เพื่อข้ามข้อมูล
		 */
		// Ausgabe : Barney Betty Bambam 
		list.stream().skip(3).forEach(System.out::print);	
		
		
		split();
		
		System.out.println("\n\n***#A5. Map-Methode ****");
		/*
		 * map Methode แปลงข้อมูลเป็นอย่างอื่น
		 * 
		 * ใช้ map() ในการแปลงข้อมูล เช่นเปลี่ยนเป็นตัวพิมพ์ใหญ่
		 * 
		 * Reigenfolge spiel mit map keine Rolle
		 * 
		 * !! Das Ergebnis ist immer gleich
		 */
		Function<String , String> f1 = s-> s.toUpperCase();
		UnaryOperator<String> op = s-> s.toUpperCase();
		// Methode-Referenz
		f1 = String::toUpperCase;
		op = String::toUpperCase;
		
		System.out.println("\n1. filter und dann map : ");
		
		// Ausgabe : BARNEY BETTY BAMBAM  
		list.stream().map(f1).filter(name -> name.startsWith("B")).forEach(System.out::print);	
		
		System.out.println("\n2. map und dann filter  : ");
		
		// Ausgabe BARNEY BETTY BAMBAM  
		list.stream().filter(name -> name.startsWith("B")).map(f1).forEach(System.out::print);	 // Reihenfolge wichtig!
		
		
		
		System.out.println("\n3. map length (filter transform): ");
		
		Function<String, Integer> f2 = String::length;
		/*
		 *  'Wilma ' , 'Fred ' , 'Pebbles ' , 'Barney ' , 'Betty ' , 'Bambam '
		 *  6	  		 5			8			7				6		7
		 */
		list.stream().forEach(System.out::print);
		
		
		list.stream().map(f2).forEach(System.out::print); // 6 5 8 7 6 7
		
		long anZahl = list.stream().map(f2).count();
		System.out.println("anzahl = " + anZahl);		// 6

		int summe = list.stream().map(f2).mapToInt(i->i).sum();
		System.out.println("summe = " + summe);		//39
		
		split();
		
		System.out.println("\n\n***#A6 distinct-Methode");
		/*
		 * distinct-Methode ลบข้อมูลที่ซ้ำกัน
		 */

		list.stream().distinct().forEach(System.out::println);
		
		
		split();
		
		System.out.println("\n\n***#A7 Peek-Methode");
	
		
		/*
		 * Peek-Methode ดูข้อมูลระหว่างการประมวลผล (ไม่เปลี่ยนข้อมูล)
		 * 
		 * ใช้ peek() กับ Consumer เพื่อดูข้อมูลใน stream ระหว่างการดำเนินการ
		 * 
		 * Peek brauct Consumer
		 * 
		 * peek() ใน Stream และวิธีการใช้กับ Consumer เพื่อดูข้อมูลระหว่างการประมวลผล 
		 * โดยที่ peek() จะช่วยให้เรา "มองเห็น" ข้อมูลระหว่างการประมวลผลใน Stream โดยไม่เปลี่ยนแปลงข้อมูล
		 */
		
		
		// Ausgabe : BAMBAM BARNEY BETTY 
        // กรองชื่อที่เริ่มต้นด้วย 'B', แปลงเป็นตัวพิมพ์ใหญ่, จัดเรียง แล้วพิมพ์ผลลัพธ์
        list.stream()
            .filter(name -> name.startsWith("B"))  // กรองชื่อที่เริ่มต้นด้วย 'B'
            .map(String::toUpperCase)  // แปลงเป็นตัวพิมพ์ใหญ่
            .sorted()  // จัดเรียงชื่อ
            .forEach(System.out::print);  // พิมพ์ผลลัพธ์
        
        
		System.out.println("\n1. peek : \n");
	
		// สร้าง Consumer ที่จะใช้ใน peek() เพื่อพิมพ์ข้อมูลออกมา
		Consumer<String> consumer = s -> System.out.println("peek = " + s);
				
		 // ใช้ peek() เพื่อมองเห็นข้อมูลระหว่างการประมวลผล โดยไม่ทำให้ข้อมูลเปลี่ยนแปลง
		list.stream()
			.distinct()
			.filter(name -> name.startsWith("B"))		 // กรองชื่อที่เริ่มต้นด้วย 'B'
			.peek(consumer)
			.map(String::toUpperCase)					// แปลงเป็นตัวพิมพ์ใหญ่
			.sorted()									// จัดเรียงชื่อ
			.forEach(System.out::println);
		
		
		/*Ausgabe
		 * 		peek = Barney 
				peek = Betty 
				peek = Bambam 
				BAMBAM 
				BARNEY 
				BETTY 
		 */
		// ใช้ peek() เพื่อมองเห็นข้อมูลระหว่างการประมวลผล โดยไม่ทำให้ข้อมูลเปลี่ยนแปลง
        list.stream()
            .distinct() 									 // กรองค่าที่ซ้ำกันออก
            .filter(name -> name.startsWith("B")) 			 // กรองชื่อที่เริ่มต้นด้วย 'B'
            .peek(consumer)  								// ใช้ peek() เพื่อมองเห็นข้อมูลระหว่างการประมวลผล
            .map(String::toUpperCase)  						// แปลงเป็นตัวพิมพ์ใหญ่
            .sorted()  										// จัดเรียงชื่อ
            .forEach(System.out::println);  				// พิมพ์ผลลัพธ์

        System.out.println("\n1. peek : ");
	
		/*
		 * Stream sind lazy (faul) , sie werden nur angestoßen , 
		 * wenn eine terminal-Operation am Ende vorhanden
		 * 
		 * Streams เป็นแบบ "lazy" จะไม่ทำงานจนกว่าจะมี terminal operation
		 */
   
	}
	
	
	static void split() {
		System.out.println("\n-----------------------------------------------------------");
	}
}
