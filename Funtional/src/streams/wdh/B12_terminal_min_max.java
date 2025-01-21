package streams.wdh;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class B12_terminal_min_max {

		/*
		 * 
		 * 	 Optional<T> max(Comparator<? super T> comparator)
		 *   Optional<T> min(Comparator<? super T> comparator)
		 */
	public static void main(String[] args) {

		Integer[] array = { 5, -6 ,77 ,12 ,-33};
		
		Comparator<Integer> cmp = Comparator.naturalOrder();
		
		/*
		 * Exam : 

		 */
//		Integer max =  Arrays.stream(array).max(cmp);	// cf 
		
		Optional<Integer> max =  Arrays.stream(array)
								  		.min(cmp);		// Liefert Optional zurück 
		
		Integer x2 = Arrays.stream(array)
							.max(cmp)		// Optional
							.get();			// Integer		
		
		System.out.println("end of main");
			
	}

}
