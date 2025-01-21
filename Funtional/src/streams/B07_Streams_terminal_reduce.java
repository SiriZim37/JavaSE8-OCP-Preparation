package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;



public class B07_Streams_terminal_reduce {

	public static void main(String[] args) { 
		
		/*
		 * .reduce() 
		 * 		ใช้สำหรับการรวมอิลิเมนต์ในสตรีมให้เป็นค่าหนึ่งค่าตามฟังก์ชันที่กำหนด โดยจะใช้กับอิลิเมนต์ในสตรีมเพื่อลดจำนวนอิลิเมนต์เหล่านั้นให้เหลือเพียงค่าเดียว
		 *  	เช่น การหาผลรวม, ผลคูณ, ค่ามากที่สุด หรือค่าที่ต้องการอื่น ๆ
		 */
	    // Optional<T> reduce(BinaryOperator<T> accumulator);
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		Optional<Integer> sum = numbers.stream().reduce((a, b) -> a + b);
		/*
		 * ในตัวอย่างนี้ a คือค่าที่สะสมในขณะนั้น และ b คือค่าถัดไปในสตรีม
		 * ผลลัพธ์ที่ได้จะเป็นค่าเดียวซึ่งเป็นผลลัพธ์จากการดำเนินการตามฟังก์ชันที่กำหนด
		 */
		
//		Stream.iterate(1,  i-> i+1).limit(100).forEach(System.out::println);


		
		// Variante 1: reduce(BinaryOperator)
		reduce_mit_BinaryOperator();

		// Variante 2: reduce(Identity, BinaryOperator) 
		reduce_mit_Identity_und_BinaryOperator();
		

		// Variante 3: reduce(Identity, BiFunction Accumulator, BinaryOperator  Combiner)
		reduce_mit_BiFunction_und_BinaryOperator();
	
		
	}

	static void reduce_mit_BinaryOperator() {
		split();
		
		System.out.println("***1. reduce(BinaryOperator) ");
	
		/*
		 * reduce Optional mit Integer
		 */	
		BinaryOperator<Integer> op = ( n1  , n2 ) -> n1 + n2 ;
		

		Optional<Integer> optSumme = Stream.iterate( 1 , i -> i+1).limit(100).reduce(op);
		
		if(optSumme.isPresent()) {
			Integer summe = optSumme.get();
			System.out.println("summe : " + summe);  		// 5050
		}else {
			System.out.println("Keine SUmme vorhanden");
		}
		
		
		System.out.println("\n***2. reduce(BinaryOperator) ");
		
		/*
		 * reduce Optional mit String
		 */	
		List<String> list = Arrays.asList("Wilma", "Fred", "Pebbles", "Barney", "Betty", "Bambam");
	
		System.out.println(list);
		
		BinaryOperator<String> stringOp = ( s1  , s2 ) -> s1 + " , " + s2 ;
		
		Optional<String> optName = list.stream().reduce(stringOp);
		
		System.out.println("1. optName = " + optName.orElseGet( () -> "Keine Namen vorhanden" ) );
		
	}

	static void reduce_mit_Identity_und_BinaryOperator() {
		split();
		
		List<String> list = Arrays.asList("Wilma", "Fred", "Pebbles", "Barney", "Betty", "Bambam");

		System.out.println("\n***1. reduce(identity ,BinaryOperator ) ");
		
		/*
		 * Integer  Mit identity 
		 *  
		 *  T reduce(T identity, BinaryOperator<T> accumulator)
		 *  
		 *  ค่าที่กำหนดแรกสุดในเมธอดนี้คือ 0 ซึ่งจะถูกใช้เป็นค่าผลลัพธ์เริ่มต้นในการรวมอิลิเมนต์
		 *  เมื่อเริ่มทำงานกับสตรีม ฟังก์ชัน op จะถูกเรียกใช้ครั้งแรกโดยใช้ 0 เป็นค่าที่สะสม (accumulator) และอิลิเมนต์แรกในสตรีมเป็นค่าถัดไป
		 */
		BinaryOperator<Integer> op = ( n1  , n2 ) -> n1 + n2 ;
		
		Integer summe = Stream.iterate( 1 , i -> i+1).limit(100).reduce(0 , op);
//		System.out.println("summe : " + summe); 			//  5050
		
		
		
		
		System.out.println("\n***3. reduce(identity ,accumulator ) ");
		/*
		 * String  Mit identity 
		 *  
		 *  T reduce(T identity, BinaryOperator<T> accumulator)
		 *  
		 *  ค่าที่กำหนดแรกสุดในเมธอดนี้คือ 0 ซึ่งจะถูกใช้เป็นค่าผลลัพธ์เริ่มต้นในการรวมอิลิเมนต์
		 *  เมื่อเริ่มทำงานกับสตรีม ฟังก์ชัน op จะถูกเรียกใช้ครั้งแรกโดยใช้ 0 เป็นค่าที่สะสม (accumulator) และอิลิเมนต์แรกในสตรีมเป็นค่าถัดไป
		 */		
		BinaryOperator<String> stringOp = ( s1  , s2 ) -> s1 + " , " + s2 ;
		
		String name = list.stream().reduce("" , stringOp);
	
		System.out.println("2. name : " + name); 
		
		System.out.println("3. name : " + name.substring(name.indexOf(",") + 1).trim()); 
		
		
	}

	// Variante 3: reduce(Identity, BiFunction Accumulator, BinaryOperator  Combiner)
	
	static void reduce_mit_BiFunction_und_BinaryOperator() {
		split();

		
		System.out.println("\n***1. reduce(identity , accumulator ,  combiner) ");
		/*
		 * เพื่ออธิบายการใช้งานของ reduce ในการรวบรวมข้อมูลในสตรีม
		 * 
		 *  <U> U reduce(U identity,
                 BiFunction<U, ? super T, U> accumulator,
                 BinaryOperator<U> combiner);
                 
              สร้าง BiFunction ชื่อว่า biFunc ซึ่งรับพารามิเตอร์สองตัว คือ idOrPrevResult (ผลลัพธ์ก่อนหน้าหรือค่าปัจจุบัน)
              และ nextElement (องค์ประกอบถัดไปในสตรีม) ฟังก์ชันนี้จะคืนค่าผลรวมของ idOrPrevResult และความยาวของ nextElement
              
              สร้าง BinaryOperator ชื่อว่า intOp ซึ่งรับพารามิเตอร์สองตัว n1 และ n2 และจะคืนค่าผลคูณของ n1 และ n2
              
              ใช้ reduce โดยมีสามพารามิเตอร์:
				Identity (0): ค่าเริ่มต้นเป็น 0
				Accumulator (biFunc): ฟังก์ชันที่ใช้ในการรวมค่า (รวมความยาวของสตริง)
				Combiner (intOp): ฟังก์ชันที่ใช้ในการรวมผลลัพธ์ (ผลคูณของผลลัพธ์)
		 */
		
		String[] arr = { "a", "b" , "c" , "d"};
		
		BiFunction<Integer, String, Integer> biFunc = (Integer idOrPrevResult , String nextElement) -> {
														System.out.println("id : " + idOrPrevResult +  ", nextElement : "  + nextElement);
														System.out.println(idOrPrevResult + nextElement.length());
														return idOrPrevResult + nextElement.length();
													};
		
		BinaryOperator<Integer> intOp = (Integer n1 , Integer n2) -> {
													    System.out.println("n1 + n2 = " + (n1 + n2));
														return n1 + n2;
													};
		
		Integer count = Arrays.stream(arr).parallel()
				.reduce( 0 , biFunc , intOp);
		
		count = Arrays.stream(arr)
					.reduce( 0 , biFunc , intOp);
		
		System.out.println("4. count : " + count);
		
		System.out.println("\n----------------------------------------------------------------------");
		
		
		
		System.out.println("\n***2. reduce(identity , accumulator ,  combiner) ");
		   
		String[] arr2 = { "Wilma", "Fred", "Pebbles", "Barney", "Betty", "Bambam"};
		
		Integer idt = 0;
		
		BiFunction<Integer, String, Integer> func2 = (Integer idtOrPrevResult, String nextElement) -> idtOrPrevResult + nextElement.length();
		
		BinaryOperator<Integer> intOp2 = (i1, i2) -> i1 + i2;
		
		Integer count2 = Arrays.stream(arr2).reduce(idt, func2, intOp2);
		
		System.out.println("count2 = " + count2);

		
		System.out.println("\n----------------------------------------------------------------------");
		
		
	    System.out.println("\n***3. reduce(identity , accumulator ,  combiner) ");
	     
	    
	    Integer[] numbers = { 2, 3, 4, 5 };
	
	    BiFunction<Integer, Integer, Integer> acc = (sum, value) -> {
	        System.out.println("sum :" + sum + " value : " +value );
	        return value;
	    };
	
	
	   // BinaryOperator to combine (multiply) intermediate results
	   BinaryOperator<Integer> comb = (res1, res2) -> {
	       int combinedResult = res1 * res2;
	       System.out.println("res1: " + res1 + " * res2: " + res2 + " -> combinedResult: " + combinedResult);
	       return combinedResult;
	   };
	
	   // Identity element for multiplication (1 is the neutral element for multiplication)
	   Integer identity = 1;
	
	   Integer productResult = Arrays.stream(numbers)
	                                 .peek( x -> System.out.println("peek = " + x)) 
	                                 .reduce(identity, acc, comb);
	   
	   System.out.println("-----------------");
	   
	   // Reduce operation using a parallel stream
	   productResult = Arrays.stream(numbers)
	                                 .parallel() // Use parallel stream to demonstrate combining
	                                 .reduce(identity, acc, comb);
	   
	   System.out.println("Final Product Result: " + productResult);
	}
	
	static void split() {
		System.out.println("\n------------------------------------------------------");
	}
}
