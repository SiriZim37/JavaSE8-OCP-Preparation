package streams.wdh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class B14_terminal_anyMatch_noneMatch {

		/*
		 *  - anyMatch, allMatch, noneMatch haben Predicate-Parameter 
		 *  - anyMatch, allMatch, noneMatch liefern boolean zurück 
		 *  - anyMatch, allMatch, noneMatch sind 'lazy' 
		 */
	
		/* 	
		 * 	 boolean allMatch(Predicate<? super T> predicate);
		 *   boolean anyMatch(Predicate<? super T> predicate);
		 *   boolean noneMatch(Predicate<? super T> predicate);
		 */
	public static void main(String[] args) {
	
		List<Integer> list = Arrays.asList(12,-7,33,4,85);
		
		Predicate<Integer> isNegativ = x -> x < 0;
		
		/*
		 * peek(x -> System.out.println("peek " + x)) จะทำให้เราเห็นค่าของ x แต่ละตัวที่ถูกประมวลผลในสตรีม
		 */
		boolean result = list.stream()
							.peek( x -> System.out.println("a. peek " + x) )	// 12 : เมื่อ x เป็น 12, มันจะพิมพ์ "a. peek 12" ออกมา ผลลัพธ์จะเป็น false
							.allMatch(isNegativ);  
		
		System.out.println("alle Elemente sint Negativ (allMatch)  : " + result);	// false
		
		System.out.println("------------------------------------------------------------------\n");
		
		result =list.stream()
					.peek( x -> System.out.println("b. peek " + x) )			// 12 , -7 : peek(x -> System.out.println("b. peek " + x)) จะพิมพ์ค่าของ x ที่ถูกประมวลผล (12, -7)
					.anyMatch(isNegativ);   
		
		System.out.println("mindestens ein Element ist Negativ (anyMatch) : " + result);	// true
		
		System.out.println("------------------------------------------------------------------\n");
		
		result =list.stream()
					.peek( x -> System.out.println("c. peek " + x) )			// 12 , -7 : peek(x -> System.out.println("c. peek " + x)) จะพิมพ์ค่าของ x (12, -7) เนื่องจากมีเลข -7 ที่เป็นเลขลบ ผลลัพธ์จะเป็น false

					.noneMatch(isNegativ);   
			
		System.out.println("kein einziges Element ist Negativ (noneMatch) : " + result);	// false
			
		
		System.out.println("\nend of main");
			
	}

}
