package ocpexam;

import java.nio.file.Path;
import java.nio.file.Paths;

public class NIOStreamListFiles {

	public static void main(String[] args) {
		
		  Path path = Paths.get("Home/dir");
		  
	}
	
	
	/*
	 * 
	 *You are given a directory path. Which of the following code snippets correctly lists all 
	 *the files in that directory using NIO and Streams in Java?
	 *
	a)
	Files.list(path).forEach(System.out::println);
	
	b)
	Files.walk(path).filter(Files::isRegularFile).forEach(System.out::println);
	
	c)
	Files.walk(path, 1).forEach(System.out::println);
	
	d)
	Files.listAll(path).forEach(System.out::println);
	
	
	
	
	
	Correct Answer:
	a) Files.list(path).forEach(System.out::println);
	
	Explanation:
	Option a is the correct choice for listing files directly in the directory.
	Files.list(path) returns a Stream<Path>, which iterates over the files in the specified directory.
	Explanation of other options:
	b) Files.walk(path).filter(Files::isRegularFile).forEach(System.out::println);
	
	Files.walk returns a Stream<Path> for all files in the directory and its subdirectories (depth > 1). You need to filter them to only get regular files.
	c) Files.walk(path, 1).forEach(System.out::println);
	
	This lists the files in the directory and the files in subdirectories up to a depth of 1, not just the files in the current directory.
	d) Files.listAll(path).forEach(System.out::println);
	
	Incorrect option. Files.listAll() is not a valid method in Java NIO. The correct method for listing files is Files.list(). This option would lead to a compile-time error

	 */
	

}

