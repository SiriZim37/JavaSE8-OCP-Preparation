package ocpexam;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;

public class FuntionFuntionTest {

	public static void main(String[] args) {
		/*
		IntStream stream = IntStream.of(1, 2, 3);	
		IntFunction<Integer> inFu =  x -> y -> x * y; // line n1
		IntStream newStream = stream.map(inFu.apply(10)); // line n2
		newStream.forEach(System.out::print);
		*/
		
		// A Replace n1 with 	IntFunction<UnaryOperator> inFu = x -> y -> x * y;
		// B Replace n1 with 	IntFunction<IntUnaryOperator> inFu = x -> y -> x * y;
		// C Replace n1 with 	BiFunction<IntUnaryOperator> inFu = x -> y -> x * y;
		// D Replace n2 with 	IntStream newStream = stream.map(inFu.applyAsInt(10));
		
		
		
		IntStream stream = IntStream.of(1, 2, 3);	
		IntFunction<IntUnaryOperator> inFu = x -> y -> x * y; // line n1
		IntStream newStream = stream.map(inFu.apply(10)); // line n2
		newStream.forEach(System.out::print);
		

		
	}

}

/*
 Stream<T>
- Stream elements Type: T

IntStream
- Stream elements Type: Int

IntFunction<R> 
- Argument Type: Int
- Return Type: R

UnaryOperator<T>
- Argument Type: T
- Return Type: T

IntUnaryOperator
- Argument Type: Int
- Return Type: Int

BiFunction<T, U, R>
- First Argument Type: T
- Second Argument Type: U
- Return Type: R

map(IntUnaryOperator mapper)
- จากโจทย์ IntStream newStream = stream.map(inFu.apply(10)); 10 ไปใส่ใน x
- จากโจทย์ newStream.forEach(System.out::print); จะเริ่มวนลูปแล้วเอาค่า 1, 2, 3 ไปใส่ใน y และทำการปริ้นทีละตัว
*/
