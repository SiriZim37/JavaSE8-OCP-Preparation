package klausur;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/*
 Gegeben ist der Code:

 Collection<String> numbers = Arrays.asList("a", "b", "bb", "c", "cc", "ccc");
 Predicate<String> predicate = s -> s.length() == 2;
 Collector<String, ?, Map<Boolean, List<String>>> collector 
        = Collectors.partitioningBy(predicate);
    
 Map<Boolean, List<String>> result = numbers.stream().collect(collector);
 System.out.println(result);

Was ist das Ergebnis, wenn alle Typen richtig importiert wurden?

[   ] Compilerfehler
[   ] {false=[a, b, c, ccc], true=[bb, cc]}
[   ] {4=[a, b, c, ccc], 2=[bb, cc]}
[   ] [[a, b, c, ccc], [bb, cc]]

 */
public class TestStream1 {

	public static void main(String[] args) {
	

			 Collection<String> numbers = Arrays.asList("a", "b", "bb", "c", "cc", "ccc");
			 Predicate<String> predicate = s -> s.length() == 2;
			 Collector<String, ?, Map<Boolean, List<String>>> collector 
			        = Collectors.partitioningBy(predicate);
			    
			 Map<Boolean, List<String>> result = numbers.stream().collect(collector);
			 System.out.println(result);

	}
}
