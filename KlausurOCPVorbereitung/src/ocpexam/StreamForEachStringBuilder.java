package ocpexam;

import java.util.Arrays;
import java.util.List;

public class StreamForEachStringBuilder {
	
	private int numA = 0 ;
	
	
	public static void main(String[] args) {
		
		StringBuilder a = new StringBuilder("Test ");
		StringBuilder b = new StringBuilder("Java ");
		
		List<StringBuilder> list = Arrays.asList(a,b);
		
		list.stream().forEach( s -> s.append("Hi "));
		
		list.forEach( s ->
			{
				s.insert(4, ",");	
				System.out.println( s );
			}
			);
		
	}
	
	
	
}
