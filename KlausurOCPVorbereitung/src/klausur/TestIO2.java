package klausur;

import java.nio.file.Path;
import java.nio.file.Paths;

/*
Gegeben ist der Code:

  Path p1 = Paths.get("/a/b/c/d");
  Path p2 = Paths.get("a/b/e/f");
  Path p3 = p1.relativize(p2);
  System.out.print( p3 );

Was ist das Ergebnis, wenn alle im Code verwendeten Typen korrekt importiert wurden?

[   ] Compilerfehler
[   ] Exception
[   ] ..\..\c\d
[   ] ..\..\e\f

 */
public class TestIO2 {

	public static void main(String[] args) {
		  Path p1 = Paths.get("/a/b/c/d");
		  Path p2 = Paths.get("a/b/e/f");
		  Path p3 = p1.relativize(p2);
		  System.out.print( p3 );
	}
}
