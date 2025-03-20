package ocpexam;

import java.util.*;

public class StreamCourseJava {

	public static void main(String[] args) {
		
		 List<String> words = Arrays.asList("Course::Java");

	        words.stream()
	             .map(word -> word.substring(2))  // Apply substring(2) to the entire string
	             .forEach(word -> System.out.print(word + " "));
		
	        
	// urse::Java 
	
	}
	
	
	
}
