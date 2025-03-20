package ocpexam;

public class NIOrelativeResolve {

	public static void main(String[] args) {
		
			/*Question:
			You are working with two file paths using Java NIO. The first path is
			 user/home/file.txt and the second path is cool\foo\bar (on Windows) or cool/foo/bar (on Unix-based systems). 
			 The task is to perform resolve() and relativize() operations between the two paths.

			Given the following code:

			import java.nio.file.*;

			public class NioPathExample {
			    public static void main(String[] args) {
			        Path p1 = Paths.get("user/home/file.txt");
			        Path p2 = Paths.get("cool/foo/bar");

			        Path resolvedPath = p1.resolve(p2);
			        Path relativePath = p1.relativize(p2);

			        System.out.println("Resolved Path: " + resolvedPath);
			        System.out.println("Relative Path: " + relativePath);
			    }
			}
			
			What will be the output of the program?

			A)
			
			Resolved Path: user/home/file.txt\cool\foo\bar
			Relative Path: cool/foo/bar
			
			B)
			
			Resolved Path: user/home/file.txt/cool/foo/bar
			Relative Path: ../../cool/foo/bar
			
			C)
			
			Resolved Path: user/home/cool/foo/bar
			Relative Path: cool/foo/bar
			
			D)
			
			Resolved Path: user/home/file.txt/cool/foo/bar
			Relative Path: ../cool/foo/bar





			Answer B)
			Explanation:
			resolve(Path other):
			
			The resolve() method is used to resolve the given path p2 against p1. It means that if p1 is not a directory, p2 will be appended to p1.
			Since p1 = user/home/file.txt and p2 = cool/foo/bar, the result will be: user/home/file.txt/cool/foo/bar.
			relativize(Path other):
			
			The relativize() method is used to find the relative path from p1 to p2.
			This means the relative path will be computed based on the common parts of both paths.
			Since the paths do not share a common root, the relative path will be calculated by going up from user/home/file.txt (using ..), and then moving into cool/foo/bar.
			So, the relative path is: ../../cool/foo/bar.

			
			*/
			
	}
}
