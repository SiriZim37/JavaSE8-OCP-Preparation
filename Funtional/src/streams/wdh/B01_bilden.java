package streams.wdh;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.IntConsumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class B01_bilden {

	public static void main(String[] args) {
		/*
		 * Methode Interface Stream
		 */
		wdh1();		
		wdh2();
		wdh3();
		wdh4();
		wdh5();
		wdh6();
		wdh7();
		
		/*
		 * Methode der Klasse Arrays
		 */
		wdh8();
		wdh9();

		/*
		 * Weitere prüfungsrelevante Methoden , die ein Stream bilden,
		 * werden im Projekt IO präsentiert
		 */
		wdh10_11();
		

		/*
		 * Weitere (nicht prüfungsrelevanten) methoden gibt es
		 * in vielen Klassen der Standardbibliothek
		 * 
		 * Z.B. : 97 98 99 68 69 70
		 * 
		 */
		wdh12();
		
	} // End of main

	
	
	private static void wdh1() {
		System.out.println("***Bsp. 1");
		/*
		 * wdh1.
		 * 
		 * static<T> Stream of(T...values)
		 * 
		 * 2 4 6 8
		 */
		Stream<Integer> s1 = Stream.of(2,4,6,8);
		s1.forEach(System.out::println);
	}
	
	private static void wdh2() {
		
		System.out.println("***Bsp. 2");
		/*
		 * wdh2.
		 * 
		 * static<T> Stream<T> of(T... values) 
		 * 
		 * 1 2 3
		 */
		Integer[] a1 = {1,2,3};
		Stream<Integer> s2 = Stream.of(a1);
		s2.forEach(System.out::println);
		
	}
	
	private static void wdh3() {
		System.out.println("***Bsp. 3");
		
		/*
		 * wdh3.
		 * 
		 * static<T> Stream<T> of(T values) 
		 * 
		 *	a1. nur Referenz
		 * [Ljava.lang.Integer;@5b1d2887
		 * [Ljava.lang.Integer;@5b1d2887
		 * 
		 * a1 ist aufruf von Generic
		 * 		Stream<Integer[]>
		 * a3. 
		 * 1 2 3 1 2 3
		 * 
		 */
		Integer[] a1 = {1,2,3};
		// a1.
		Stream.of(a1 , a1 ).forEach(System.out::println);
		// a1 ist aufruf von Generic
		Stream.<Integer[]>of(a1).forEach(System.out::println); 
		// a2
		Stream.of(a1 , a1 ).flatMap(Arrays::stream).forEach(System.out::println);
	}
	
	private static void wdh4() {
		System.out.println("***Bsp. 4");
		/* wdh4
		 * .
		 * static<T> Stream<T> generate(Supplier<? extends T> s)
		 * 
		 * a1.
		 * 	Das Stream Ende nicht ( Endlose )...
		 * 
		 * 42 42 42 ...
		 * 
		 * a2.
		 * 	 Stream<T> limit(long maxSize)
		 *  
		 *  42 42 42
		 */
		Supplier<Integer> sup1 = ()-> 42 ;
		// a1.
//		Stream.generate(sup1).forEach(System.out::println); // ( 42... Endlose )
		// a2.
		Stream.generate(sup1).limit(3) .forEach(System.out::println); 
	}
	
	
	private static void wdh5() {
		System.out.println("***Bsp. 5");
		/* wdh5
		 * .
		 * static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f) 
		 * - seed the initial element
		 * a1.
		 * 	Das Stream Ende nicht ( Endlose )... irgend wann IntOverflow...
		 * 
		 * 1 3 5  ...
		 * 
		 * a2.
		 * 	 Stream<T> limit(long maxSize)
		 *  
		 *  1 3 5 
		 */
		UnaryOperator<Integer> op1 = x -> x+2;
		//a1
//		Stream.iterate(1, op1).forEach(System.out::println); // (1 2 3... Endlose )
		//a2
		Stream.iterate(1, op1).limit(3).forEach(System.out::println);
	}
	
	private static void wdh6() {
		System.out.println("***Bsp. 6");
		/*
		 * wdh5.
		 * 
		 *  static <T> Stream<T> concat(Stream<? extends T> a, Stream<? extends T> b)
		 * 
		 * 1 2 3 4 5 
		 */
		Stream<Integer> sA = Stream.of(1,2,3);
		Stream<Integer> sB =Stream.of(4,5);
		
		Stream.concat(sA, sB).forEach(System.out::println);
		
	}
	
	private static void wdh7() {
		System.out.println("***Bsp. 7");
		/*
		 * wdh7.
		 * 
		 * static<T> Stream<T> empty() 
		 */
		Stream.empty().forEach(System.out::println);
		
	}


	private static void wdh8() {
		System.out.println("***Bsp. 8");
		/*
		 * wdh8.
		 *  static <T> Stream<T> stream(T[] array, int startInclusive, int endExclusive) 
		 */
		//	index   	 0  1  2  3  4  5  6	
		Integer[] arr = {10,11,12,13,14,15,16};
		Arrays.stream(arr , 1 , 5 ).forEach(System.out::println);
		
	}
	
	private static void wdh9() {
		System.out.println("***Bsp. 9");
		/*
		 * wdh9.
		 *  static <T> Stream<T> stream(T[] array, int startInclusive, int endExclusive) 
		 */
		//index   	     0  1  2  3  4  5  6	
		Integer[] arr = {10,11,12,13,14,15,16};
		Arrays.stream(arr).forEach(System.out::println);	// ok : 10,11,12,13,14,15,16
		//Arrays.stream(7 , 8 , 9  ).forEach(System.out::println);	// Compiler Fehler 
	}
	
	private static void wdh10_11() {		
		System.out.println("***Bsp. 10,11");
	
		Collection<Integer> coll = Arrays.asList(5,6,7,8);
		
		System.out.println("***Bsp. 10");
		/*
		 * stream() เพื่อประมวลผลคอลเล็กชันแบบเรียงลำดับ (Sequential Stream)
		 * ซึ่งจะพิมพ์ค่าทั้งหมดในลำดับที่เหมือนเดิม:
		 * 
		 * z.B : 5 6 7 8 
		 */
		coll.stream().forEach(System.out::println);
	
		
		System.out.println("***Bsp. 11");
		/*
		 * parallelStream() เพื่อประมวลผลคอลเล็กชันแบบขนาน (Parallel) 
		 * ซึ่งจะใช้หลายเธรดในการพิมพ์ค่าออกมา เนื่องจากการทำงานขนานกัน 
		 * อาจทำให้ลำดับการพิมพ์ไม่เรียงตามเดิมเสมอไป ขึ้นอยู่กับการจัดการของระบบ:
		 * (ลำดับของผลลัพธ์อาจเปลี่ยนไป เนื่องจากการประมวลผลแบบขนานในหลายเธรด)
		 * 
		 * z.B : 7 8 6 5 
		 */
		coll.parallelStream().forEach(System.out::println);
		
	}

	private static void wdh12() {
		System.out.println("***Bsp. 12");

		String str = "abcDEF";
		
		IntStream intstream = str.chars(); // IntStream
		/*
		 * wdh10.
		 * IntStream chars() 
		 * forEach(IntConsumer action)
		 * 
		 * Z.B. : 97 98 99 68 69 70
		 */
		str.chars() // IntStream
				.forEach(System.out::println);
		
	}
	
}
