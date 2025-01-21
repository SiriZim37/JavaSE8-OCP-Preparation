package streams;

import java.util.Arrays;
import java.util.List;


public class StreamsCount {

	public static void main(String[] args) {


		List<Duck> ducks = Arrays.asList(
					new Duck("Jerry" , "yellow" , 1 ),
					new Duck("Huey" , "mottled" , 3 ));

		long count = ducks.stream().filter(d -> d.getColor().equals("mottled")).count(); // 1 
		System.out.println("count1 : " + count);
		
		long count2 = ducks.stream().filter(d -> d.equals("mottled")).count(); // 0 :  d ist nicht String but d ist Object 
		System.out.println("count2 : " + count2);
	}

}
