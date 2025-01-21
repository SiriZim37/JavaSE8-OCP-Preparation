package streams;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class StreamFindAnyFindFirst {

	public static void main(String[] args) {
		 List<Temperature> temperatureList = new ArrayList<>();
	        
	     // Adding some sample data
	     temperatureList.add(new Temperature("Hamburg", 17.3));
	     temperatureList.add(new Temperature("Munich", 19.8));
	     temperatureList.add(new Temperature("Cologne", 16.7));
	     temperatureList.add(new Temperature("Berlin", 15.5));
	     temperatureList.add(new Temperature("Frankfurt", 18.1));
	      
	     
	     Comparator<Temperature> cmp = ( t1 , t2) -> t1.getTemp().compareTo(t2.getTemp());
	     
	     Optional<Temperature> tempMin =   temperatureList.stream().min(cmp);
	     
	     if(tempMin.isPresent())
	     System.out.println("Optional<Temperature> : " + tempMin.get());


	     OptionalDouble tempMin2 =   temperatureList.stream().mapToDouble( t -> t.getTemp().doubleValue()).min();
	     
	     if(tempMin2.isPresent())
	    	 System.out.println("OptionalDouble : " + tempMin2.getAsDouble());
	     
	     Optional<Temperature> findAny =  temperatureList.stream().filter( t -> t.getTemp() < 17.5).findAny();
	     if(findAny.isPresent())
	    	 System.out.println("findAny : " + findAny.get());
	     
	     
	     Optional<Temperature> findfirst =  temperatureList.stream().filter( t -> t.getTemp() < 17.5).findFirst();

	     if(findfirst.isPresent())
	    	 System.out.println("findFirst : " + findfirst.get());
	}

}
