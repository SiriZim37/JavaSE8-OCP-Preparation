package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamsCollectorsPartitioningBy {

	public static void main(String[] args) {
		 List<Temperature> temperatureList = new ArrayList<>();
	        
	     // Adding some sample data
	     temperatureList.add(new Temperature("Berlin", 15.5));
	     temperatureList.add(new Temperature("Hamburg", 17.3));
	     temperatureList.add(new Temperature("Munich", 19.8));
	     temperatureList.add(new Temperature("Cologne", 16.7));
	     temperatureList.add(new Temperature("Frankfurt", 18.1));
	      

	     Predicate<Temperature> pred =  t -> t.getTemp() > 100 ;   
	     Function<Temperature , Double> func = t -> t.getTemp();
	     Collector<Object, ?, List<Object>> dowstream = Collectors.toList();
	    
		/*
		 * Map< key, value> 						  
		 */
	     /*
	        Collector <Temperature, ?, Map <Boolean, List <Object>>> java.util.stream.Collectors.partitioningBy (
			
			Predicate <? super Temperature> predicate	, 
			
			Collector <? super Temperature, Object, List <Object>> downstream
			)
	      */
	     Map<Boolean, List<Object>> tempOver100 = 
	    		 temperatureList.stream()
	     						.collect( Collectors.partitioningBy( pred , Collectors.mapping(func , dowstream) ) );// map in List
	   
	     System.out.println(tempOver100);
	     
	     
	     // Alternativ
	
	    Map<Boolean, List<Object>>  map =  temperatureList.stream()
	    			.collect( Collectors.partitioningBy( t -> t.getTemp() > 100 , 
	    												Collectors.mapping(   t -> t.getTemp() , 
	    														 			  Collectors.toList()) ) );
	    System.out.println(tempOver100);
	    
	
	}

}
