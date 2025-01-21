package streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsToList {

	public static void main(String[] args) throws IOException {

		
		try (	Stream<String> stream = Files.lines(Paths.get("herrscher.txt"))) {
		
			// L1 
			List<String> list1 = stream.sorted().collect(Collectors.toList());			// richtig ! 
			
			
//			List<String> list1 = stream.sorted().toList(); // cf : toList ab Java 16

//			List<String> list1 = stream.comparing(...).collect(Collectors.toList) // cf : intermediat call before Collect 
			
					
			System.out.println( "Sort list : " +  list1);
			
		} catch (IOException e) {
			System.out.println(e);
		}
		
		
		

	}

}
