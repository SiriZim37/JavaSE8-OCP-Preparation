package ocp2;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathNormalizeRelativize {

	public static void main(String[] args) {
		
		
		Path p1 = Paths.get("/software/././sys/readme.txt");
		System.out.println(p1);
		Path p2 = p1.normalize();
		System.out.println(p2);
		Path p3 = p2.relativize(p1);
		System.out.println(p3.normalize()+".");
		
		System.out.println(p1.getNameCount());
		System.out.println(p2.getNameCount());
		System.out.println(p3.getNameCount());
	}
}
