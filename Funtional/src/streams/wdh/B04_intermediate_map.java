package streams.wdh;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class B04_intermediate_map {

	/*
	 * <R> Stream<R> map(Function<? super T, ? extends R> mapper)
	 */
	
	public static void main(String[] args) {
		
		System.out.println("***Bsp. 1");
		
		List<String> list = Arrays.asList("a" ,"bb" , "c" , "dddd");
		
		list.stream()						// Stream<String> : a bb c dddd
			.map(s -> "(" + s + ")")		// Stream<String> : (a),(bb),(c),(dddd) 	
			.map(String::length)			// Stream<Integer> :length : (a)=3  , (bb)=4, (c)=3 , (dddd)=6 
			.forEach(System.out::println);	// Ergebnis : 3 4 3 6 
		
		System.out.println("***Bsp. 2");
		
		Function<String, String>  func1 = s -> "(" + s + ")";
		Function<String, Integer> func2 = s -> s.length(); 		// oder String::length
		Consumer<Integer> c1 = c -> System.out.println(c);  	// oder  System.out::println
		
		list.stream()						// Stream<String> : a bb c dddd
				.map(func1)					// Stream<String> : (a),(bb),(c),(dddd) 	
				.map(func2)					// Stream<Integer> :length : (a)=3  , (bb)=4, (c)=3 , (dddd)=6 
				.forEach(c1);				// Ergebnis : 3 4 3 6 
	}

}
