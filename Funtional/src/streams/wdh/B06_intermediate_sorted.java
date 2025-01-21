package streams.wdh;

import java.net.Socket;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class B06_intermediate_sorted {

	public static void main(String[] args) {
	
		/*
		 *  Stream<T> sorted();
		 */
		Stream.of("hh","gg","mm","bb")
			  .sorted()
			  .forEach(System.out::println);
		 
		System.out.println();
		
		/*
		*    Stream<T> sorted(Comparator<? super T> comparator);
		*/
		Stream.of("hh","gg","mm","bb")
			  .sorted(Comparator.reverseOrder())
			  .forEach(System.out::println);
		 
		/*
		 * Exam! Auf namen achten
		 */
		
		List<Integer> list = Arrays.asList(2,-4,33,-2);
		Comparator<Integer> cmp = Comparator.reverseOrder();
		
		Collections.sort(list);
		Collections.sort(list , cmp);
		
//		list.sort(); // cf : es gibt keine Methode 'sort'
		list.sort(cmp);
		
		list.stream().sorted();
		list.stream().sorted(cmp);
	}

}
