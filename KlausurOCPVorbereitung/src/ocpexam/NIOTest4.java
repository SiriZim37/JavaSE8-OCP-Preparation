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

	public class NIOTest4 {

		public static void main(String[] args) {
			Path path1 = Paths.get("/app/./sys/"); 
			Path res1 = path1.resolve("log");
			Path path2 = Paths.get("/server/exe/"); 
			Path res2 = path1.resolve("/readme/"); 
			System.out.println(res1); 
			System.out.println(res2);
			
			//define the fix path
	        Path base_1 = Paths.get("C:/tutorial/Java/JavaFX");
	        Path base_2 = Paths.get("C:/tutorial/Java/JavaFX/Topic.txt");
	        //Resolve the given path against this path.
	        //resolve Topic.txt file
	        Path path_1 = base_1.resolve("Topic.txt");
	        System.out.println(path_1.toString());

	        //resolve Demo.txt file
	        Path path_2 = base_1.resolve("Demo.txt");
	        System.out.println(path_2.toString());
	        //resolve the given path against this path's parent
	        Path path_3 = base_1.resolveSibling("JavaXX");
	        System.out.println(path_3.toString());
		}
		
	}



