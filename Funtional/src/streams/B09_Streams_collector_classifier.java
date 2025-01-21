package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class B09_Streams_collector_classifier {

	public static void main(String[] args) {

		/*
		 * Collectors.groupingBy ใช้สำหรับจัดกลุ่มข้อมูลในสตรีมตามกฎที่กำหนด โดยจะสร้าง 
		 * Map ที่เก็บค่าเป็นกลุ่ม ซึ่งคีย์ของ Map จะเป็นผลลัพธ์จากฟังก์ชันที่ใช้ในการจัดกลุ่ม 
		 * และค่าเป็นรายการ (List) ขององค์ประกอบที่ตรงตามคีย์นั้น ๆ
		 * 	- Return Type : Map ที่มีคีย์เป็นผลลัพธ์ของการจัดกลุ่ม (เช่น คุณลักษณะหรือการคำนวณ) และมีค่าเป็นรายการขององค์ประกอบที่อยู่ในกลุ่มนั้น
		 * 
		 * Collectors.partitioningBy ใช้สำหรับแบ่งข้อมูลออกเป็นสองกลุ่มตามเงื่อนไขที่กำหนด 
		 * โดยจะสร้าง Map ที่มีคีย์เป็น Boolean (true หรือ false) ซึ่งหมายถึงกลุ่มที่ตรงตามเงื่อนไข (true) 
		 * และกลุ่มที่ไม่ตรงตามเงื่อนไข (false) ค่าใน Map จะเป็นรายการ (List) ขององค์ประกอบที่ตรงตามเงื่อนไขนั้น
		 * 	- Return Type :  Map<Boolean, List<T>> ที่คีย์เป็น Boolean (true หรือ false) 
		 * 
		 * Collectors.joining เป็นฟังก์ชันใน Java Stream API ที่ใช้สำหรับการรวมองค์ประกอบใน Stream 
		 * ให้เป็นสตริงเดียว โดยคุณสามารถกำหนดตัวคั่น (delimiter) ก่อนและหลังผลลัพธ์ที่ได้
		 */
		
		
		List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");

		/*
		 *  ใช้ Collectors.groupingBy เพื่อจัดกลุ่มชื่อ ตามตัวอักษรตัวแรก
		 *  สร้าง Map ที่คีย์เป็นตัวอักษรตัวแรก และค่าเป็นรายการของชื่อที่ตรงตามคีย์นั้น
		 */
		Map<Character, List<String>> groupedByFirstLetter = names.stream()
								.collect(Collectors.groupingBy(name -> name.charAt(0)));
	
		groupedByFirstLetter.forEach((key, value) -> System.out.println(key + ": " + value));
	
	
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
	
		/*
		 * ใช้ Collectors.partitioningBy เพื่อแบ่งกลุ่มตัวเลขเป็นคู่และคี่
		 * สร้าง Map ที่คีย์เป็น Boolean (true/false) และค่าเป็นรายการของตัวเลขในแต่ละกลุ่ม
		 */
		Map<Boolean, Set<Integer>> partitioned = numbers.stream()
								.collect(Collectors.partitioningBy(num -> num % 2 == 0 , Collectors.toSet()));

		partitioned.forEach((key, value) -> System.out.println(key ? "Even: " + value : "Odd: " + value));
	        
	        
		List<String> arrNames = Arrays.asList("Alice", "Bob", "Charlie", "David");

        // ใช้ Collectors.joining เพื่อรวมชื่อเป็นสตริงเดียว โดยใช้เครื่องหมายจุลภาคและช่องว่างเป็นตัวคั่น
        String result = arrNames.stream().collect(Collectors.joining(", "));
        System.out.println(result); // ผลลัพธ์: Alice, Bob, Charlie, David

        // ใช้ Collectors.joining เพื่อรวมชื่อเป็นสตริงเดียว โดยมี "[" และ "]" ล้อมรอบ
        
        /*
         * static Collector<CharSequence, ?, String> joining(CharSequence delimiter,
                                                             CharSequence prefix,
                                                             CharSequence suffix)
         */
        String resultWithBrackets = arrNames.stream().collect(Collectors.joining(", ", "[", "]"));
        System.out.println(resultWithBrackets); // ผลลัพธ์: [Alice, Bob, Charlie, David]
        
        
		split() ;
		
		
		   
		   
		Integer[] arr = { 12, -7, 22, -1000, 333, 5, 12, 0 };

		
		System.out.println("\nG1. \n");
		 /*
         * การเก็บผลลัพธ์ใน Map โดยใช้ Collectors.groupingBy
         */
        
		Function<Integer, String> classifier = i -> i > 0 ? "positiv" : "negativ";
        
//		Map<String, List<Integer>> mapGroup = Arrays.stream(arr).collect(Collectors.groupingBy(classifier));
//		for (String key : mapGroup.keySet()) {
//			System.out.println(mapGroup.get(key));
//		}

        Arrays.stream(arr)
               .collect(Collectors.groupingBy(classifier))
               .forEach((key, value) -> System.out.println(key + " : " + value));

      

        System.out.println("\nG2. \n");
       
        Predicate<Integer> pred = i -> i % 2 == 0;
        /*
         *  partitioningBy เพื่อตรวจสอบว่าหมายเลขเป็นคู่หรือคี่
         */
        Arrays.stream(arr)
               .collect(Collectors.partitioningBy(pred))
               .forEach((key, value) -> System.out.println(key + " : " + value));

        // ใช้ partitioningBy เพื่อนับจำนวนของคู่และคี่
        Arrays.stream(arr)
               .collect(Collectors.partitioningBy(pred, Collectors.counting()))
               .forEach((key, value) -> System.out.println(key.equals(true) ? "gerade" : "ungerade" + ": " + value));

        System.out.println("\nG3. \n");
        // ใช้ groupingBy เพื่อนับจำนวนตามประเภท
        Arrays.stream(arr)
              .collect(Collectors.groupingBy(classifier, Collectors.counting()))
              .forEach((key, value) -> System.out.println(key + ": " + value));

        /*
         * ตัวอย่าง: นับจำนวนชื่อในรายการตามตัวอักษรตัวแรก โดยใช้ Java Stream API
         * และ Collectors เพื่อจัดกลุ่มและนับชื่อในแต่ละกลุ่ม
         */
        List<String> list = Arrays.asList("Wilma", "Fred", "Pebbles", "Barney", "Betty", "Bambam");
        
        // ใช้ groupingBy เพื่อจัดกลุ่มชื่อตามตัวอักษรตัวแรกและนับจำนวนในแต่ละกลุ่ม
        list.stream()
            .collect(Collectors.groupingBy(s -> s.charAt(0), Collectors.counting()))
            .forEach((key, value) -> System.out.println(key + " : " + value));

        
        
	}
	
	static void split() {
		System.out.println("\n------------------------------------------------------");
	}

}
