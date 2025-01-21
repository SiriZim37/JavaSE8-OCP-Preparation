package streams.wdh;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class B13_terminal_findFirst_findAny {

	/*
	 * Optional<T> findFirst()
	 * Optional<T> findAny()
	 */
	public static void main(String[] args) {

		a_findFirst();
		b_findAny();
		
			
	}


	private static void a_findFirst() {
		List<Integer> list = Arrays.asList(-9 , 13 , 11 , -7);
		Set<Integer>  set = new  HashSet<Integer>(list);
		/*
		 * Exam : 
		 * 
		 */
//		Integer x1 = list.stream().findFirst(); 	// cf : findFirst liefert Optional zurück
		
		Optional<Integer> mayInt = list.stream().findFirst(); 
		Integer x1 = list.stream().findFirst().get();
		
		
		/*
		 * - Datenquelle ist geordnet
		 * - Stream ist sequentiell 
		 * - findFirst
		 */
		System.out.println("1. result : " + 
							 list.stream()		// Stream<Integer>
								 .findFirst()	// Optional<Integer>
								 .get()			// Integer
						  );					//result : -9		
		
		/*
		 * - Datenquelle ist ungeordnet!!
		 * - Stream ist sequentiell 
		 * - findFirst
		 */
		System.out.println("2. result : " + 
							 set.stream()		// Stream<Integer>
								 .findFirst()	// Optional<Integer>
								 .get()			// Integer
						  );					// result : -7  		// unbestimmt
		
		
		/*
		 * - Datenquelle ist ungeordnet!!
		 * - Stream ist parallelStream 
		 * - findFirst
		 */
		System.out.println("3. result : " + 
							 set.parallelStream()		// Stream<Integer>
								 .findFirst()			// Optional<Integer>
								 .get()					// Integer
						  );							// result : -9  		// unbestimmt

		System.out.println("end of findFirst");
	}

	private static void b_findAny() {

		List<Integer> list = Arrays.asList(-9 , 13 , 11 , -7);
		Set<Integer>  set = new  HashSet<Integer>(list);
		
		/*
		 * - Datenquelle ist geordnet!!
		 * - Stream ist sequentiell 
		 * - findAny
		 */
		System.out.println("3. result : " + 
							 set.stream()		// Stream<Integer>
								 .findAny()		// Optional<Integer>
								 .get()			// Integer	
						  );					// result : -7 		// unbestimmt ,obwohl Datenquelle geordnet
																	// ist und der Stream nicht parallel ist.
		 
		System.out.println("end of findAny");
		
	}

}
