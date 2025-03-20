package ocpexam;

import java.io.File;
import java.io.IOException;




/*
Question No : 60
Given the code fragment:
Path path1 = Paths.get("/app/./sys/"); 
Path res1 = path1.resolve("log");
Path path2 = Paths.get("/server/exe/"); 
Path res2 = path1.resolve("/readme/"); 
System.out.println(res1); 
System.out.println(res2);
What is the result?
A. /app/sys/log 
/readme/server/exe 
B. /app/log/sys 
/server/exe/readme 
C. /app/./sys/log 
/readme
D. /app/./sys/log 
/server/exe/readme
Answer: C

//
/app/./sys/log
/readme

*/


	import java.nio.file.Path;
	import java.nio.file.Paths;

	public class NIOTest5 {

		public static void main(String[] args) {
		/*
		 Given the code fragment:

		 Path file = Paths.get ("courses.txt");
			// line n1
			
		Assume the courses.txt is accessible.
		Which code fragment can be inserted at line n1 to enable the code to print the content of the courses.txt file?
		
		A. List<String> fc = Files.list(file);
		   fc.stream().forEach(s -> System.out.println(s));
		   
		B. Stream<String> fc = Files.readAllLines(file);
		   fc.forEach(s -> System.out.println(s));
		   
		C. List<String> fc = Files.readAllLines(file);
		   fc.stream().forEach(s-> System.out.println(s));
		   
		D. Stream<String> fc = Files.list(file);
		   fc.forEach(s -> System.out.println(s));
		   
		    
		    
		    [Answer]
		C
		
		[Explanation]
		A. File.list return Stream<Path> and if path is not directory, NotDirectoryException will be thrown and NoSuchFileException if there no such file 
		B. Files.readAllLines(...) return List<>
		D. same as A.
		 */
		}
		
	}



