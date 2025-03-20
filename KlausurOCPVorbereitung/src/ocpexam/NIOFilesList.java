package ocpexam;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class NIOFilesList {

	public static void main(String[] args) {
		
		Path path = Paths.get("Home/dir");
		try (Stream<Path> paths = Files.list(path)) {
		    paths.forEach(System.out::println);
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		
		/*
		 * 
		 What will be the output of this code?

		a) The files in the folder "Home/dir"
		b) All files and folders under "Home"
		c) All files and folders in "Home/dir"
		d) A list of all directories under "Home/dir"


		 */
	}
}
