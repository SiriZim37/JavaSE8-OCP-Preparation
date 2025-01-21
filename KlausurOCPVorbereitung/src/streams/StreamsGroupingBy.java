package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamsGroupingBy {

	public static void main(String[] args) {

		List<Duck> ducks = Arrays.asList(
				new Duck("Tom" , "mottled" , 5 ),
				new Duck("Jerry" , "yellow" , 1 ),
				new Duck("Huey" , "mottled" , 3 ));

		
		ducks.stream()
			.collect(Collectors.groupingBy(Duck::getColor))
			.forEach( (_key , _value) -> {
				   System.out.print( "Duck who are " + _key + " : " );
				   _value.forEach( d -> System.out.print( d.getName() + " "));
				   System.out.println();
			});
		
		/* Result : 
		 * Duck who are mottled : Tom Huey 
		 * Duck who are yellow : Jerry 
		 */
					
	}

}
