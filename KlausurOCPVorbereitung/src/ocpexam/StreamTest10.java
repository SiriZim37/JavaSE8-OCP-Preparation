package ocpexam;


import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
Question No : 115

Given the code fragment:

	Stream<List<String>> iStr= Stream.of (
	Arrays.asList ("1", "John"),
	Arrays.asList ("2", null));
	Stream<String> nInSt = iStr.flatMapToInt ((x) -> x.stream ());
	nInSt.forEach (System.out :: print);
	
What is the result?

A. 1John2null
B. 12
C. A NullPointerException is thrown at run time.
D. A compilation error occurs.

Answer: D (flatMapToInt return IntStream)
 */


public class StreamTest10 {
	

	public static void main(String[] args) {

//				Stream<List<String>> iStr= Stream.of (
//				Arrays.asList ("1", "John"),
//				Arrays.asList ("2", null));
//				Stream<String> nInSt = iStr.flatMapToInt ((x) -> x.stream());	// cf
//				nInSt.forEach (System.out :: print);
				
				
				Stream<List<String>> iStr = Stream.of(
					    Arrays.asList("1", "John"),
					    Arrays.asList("2", null)
					);
					Stream<String> nInSt = iStr.flatMap(x -> x.stream());
					nInSt.forEach(System.out::print);
	}
}