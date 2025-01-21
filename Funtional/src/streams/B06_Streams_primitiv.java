package streams;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class B06_Streams_primitiv {

	/*
	 * Java provides specialized stream interfaces for each 
	 * primitive type: IntStream, LongStream, and DoubleStream
	 * 
	 * Java มีอินเทอร์เฟซสตรีมเฉพาะสำหรับประเภทพื้นฐานแต่ละประเภท ได้แก่ IntStream, LongStream และ DoubleStream 
	 * สตรีมเหล่านี้ถูกออกแบบมาเพื่อทำงานกับประเภทพื้นฐานโดยตรง ทำให้มีประสิทธิภาพและสะดวกสบาย
	 * 
	 * adventages of Primitive Streams (ข้อดีของสตรีมประเภทพื้นฐาน)
	 * Performance: 
	 * 		-	Directly handling primitive types without boxing improves performance, 
	 * 			especially in large data sets. การจัดการกับประเภทพื้นฐานโดยตรงโดยไม่ต้องมีการบรรจุช่วยเพิ่มประสิทธิภาพ
	 * 			โดยเฉพาะอย่างยิ่งในชุดข้อมูลขนาดใหญ่
	 * 		-	Convenience: Provides specialized methods (like sum(), max(), etc.) 
	 * 			tailored for primitive types, which enhances code readability and efficiency.
	 * 			มีเมธอดเฉพาะ (เช่น sum(), max(), ฯลฯ) ที่ออกแบบมาเพื่อให้เหมาะสมกับประเภทพื้นฐาน ทำให้โค้ดอ่านง่ายและมีประสิทธิภาพ
	 */
	
	public static void main(String[] args) {
	
		/*
		 * Stream mit primitiven Variablen ( int double , long )
		 */
		
		Stream<Integer> stream = Stream.of(3, 4, 2, 1, 6, 5, 4, 3, 2, 1, 4, 5, 3, 2);
		
	
		IntStream intStream = IntStream.of(3, 4, 2, 1, 6, 5, 4, 3, 2, 1, 4, 5, 3, 2);

		
		int summe =  intStream.sum();
		System.out.println("summe = " + summe);	// 45
		
//		OptionalDouble optionalDurchschnitt =  intStream.average();	// cf : Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or close
		
		/*
		 * OptionalDouble average()
		 * 
		 * funktioniert nur mit primitive type:  ( int double , long )
		 * 
		 * Integer -> stream.mapToInt( i -> i.intValue())     คำนวณค่าเฉลี่ยใน IntStream
		 * Long -> stream.mapToLong( i -> i.doubleValue())    คำนวณค่าเฉลี่ยใน LongStream
		 * Double -> stream.mapToDouble( i -> i.longValue())  คำนวณค่าเฉลี่ยใน DoubleStream
		 */
		OptionalDouble optionalDurchschnitt =  stream.mapToInt( i -> i.intValue()).average(); //  คำนวณค่าเฉลี่ยใน IntStream
		
		/*
		 * .average() funktioniert nicht mit  Optional<?>
		 */
//		Optional<Double> optionalDurchschnitt1 =  stream.mapToInt( i -> i.intValue()).average();
		
		if(optionalDurchschnitt.isPresent()) {
			double durchschnitt = optionalDurchschnitt.getAsDouble();
			System.out.println("durchschnitt = " + durchschnitt);		// 3.2142857142857144
		}
		
		
		Integer[] arr1 = {1,2,3,4,5,6};
		stream = Arrays.stream(arr1);   	// Stream<Integer>

		int[] arr2 = {1,2,3,4,5,6};
		intStream = Arrays.stream(arr2);	// IntStream
		
		Random r = new Random();
		intStream = r.ints().limit(5);      // IntStream
		
		String s = "abcdefgh";
		s.chars().forEach( c -> System.out.println((char) c ));
		
		split();
		
		System.out.println("*** toArray() : ");
		
		Object[] objArr = Stream.of(3, 4, 2, 1, 6, 5, 4, 3, 2, 1, 4, 5, 3, 2)
								.filter( i -> i < 3)
								.toArray();
		System.out.println("Object Array : "  + Arrays.toString(objArr));
	
		Integer[] intArr = Stream.of(3, 4, 2, 1, 6, 5, 4, 3, 2, 1, 4, 5, 3, 2)
				.filter( i -> i < 3)
				.toArray(Integer[]::new);
		System.out.println("Integer Array : " + Arrays.toString(intArr));
		
		split();
		 /*
		  * Creating an IntStream that generates numbers from 1 to 9
		  */
        IntStream.range(1, 10)  							 //  from 1 to 9 (exclusive of 10)
                 .forEach( i -> System.out.print(" " + i));   //  1 2 3 4 5 6 7 8 9 
        
		split();
        /*
         *  Calculating the sum of even numbers from 1 to 10
         */
        int sumOfEvens = IntStream.rangeClosed(1, 10)  				// Creates a stream of integers from 1 to 10 (inclusive)
                                   .filter(n -> n % 2 == 0)  		// Filters the stream to include only even numbers
                                   .sum();  						// Sums up the remaining numbers in the stream
        System.out.println("Sum of even numbers from 1 to 10: " + sumOfEvens);
        
        split();
     	/*
     	 *  Finding the maximum value in a range of integers
     	 */
        int maxNumber = IntStream.range(1, 20)  			// Creates a stream of integers from 1 to 19
                                  .max()  					// Finds the maximum value in the stream
                                  .orElse(-1);  			// Returns -1 if the stream is empty
        System.out.println("Maximum number between 1 and 19: " + maxNumber);
	}

	static void split() {
		System.out.println("\n------------------------------------------------------");
	}
}
