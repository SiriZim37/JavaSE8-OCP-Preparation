package streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamsSortedUndReversed {

	public static void main(String[] args) {


		 List<Temperature> temperatureList = new ArrayList<>();
	        
	     // Adding some sample data
	     temperatureList.add(new Temperature("Berlin", 15.5));
	     temperatureList.add(new Temperature("Hamburg", 17.3));
	     temperatureList.add(new Temperature("Munich", 19.8));
	     temperatureList.add(new Temperature("Cologne", 16.7));
	     temperatureList.add(new Temperature("Frankfurt", 18.1));
	      
	     
	     Comparator<Temperature> cmp = ( t1 , t2) -> t1.getTemp().compareTo(t2.getTemp());
	     
	     // Reverseed 
	     List<Temperature> list = temperatureList
			    		 .stream()
			    		 .sorted(cmp.reversed()).
			    		 collect(Collectors.toList());
	     
	     System.out.println("list : " + list);

	     /*
	      * [Temp : Munich was 19.8, Temp : Frankfurt was 18.1, Temp : Hamburg was 17.3, Temp : Cologne was 16.7, Temp : Berlin was 15.5]

	      */
	     
	     // Terminate print list
		// sorted location 
	     
	     temperatureList.stream()
			    	.sorted((loc1 , loc2) -> loc1.getLocation().compareTo(loc2.getLocation()))
			        .forEach(System.out::println);

	}

}
