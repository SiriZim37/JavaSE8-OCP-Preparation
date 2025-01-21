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

    Object result = Arrays.asList("aa", "bb", "c", "d")
            .stream()
            .reduce(0, (i, s) -> i + s.length(), (j, k) -> j+k );
    System.out.println(result);

Was ist das Ergebnis?

[   ] Compilerfehler
[   ] 4
[   ] 6
[   ] aabbcd

 */
public class TestStream2 {

	public static void main(String[] args) {
	

		Object result = Arrays.asList("aa", "bb", "c", "d")
	            .stream()
	            .reduce(0, (i, s) -> i + s.length(), (j, k) -> j+k );
	    System.out.println(result);


	}
}
