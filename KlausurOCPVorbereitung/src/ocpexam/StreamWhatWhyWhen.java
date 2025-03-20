package ocpexam;

import java.util.Arrays;
import java.util.List;

public class StreamWhatWhyWhen {

	public static void main(String[] args) {
		
		
		List<String> words = Arrays.asList("why", "when", "where");

        // Using "what" as the identity value in the reduce operation
        String result = words.stream()
                             .reduce("what", (a, b) -> a + " " + b);  // Identity value "what"
                             
        System.out.println(result);  // Output the result
        
        
        
        
        // what why when where

	}
}
