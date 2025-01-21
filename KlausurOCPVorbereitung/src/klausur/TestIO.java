package klausur;

import java.nio.file.Path;
import java.nio.file.Paths;

/*
 Frage 6. (3 Punkte)

Gegeben:

  Path d1 = Paths.get("lang", "java");
  Path d2 = d1.resolve("pro");
  System.out.println(d2);

Der Code kompiliert. Welche Ausgabe erwarten Sie?

[   ] ..\..\pro
[ X ] lang\java\pro
[   ] pro\lang\java
[   ] Keine Ausgabe

 */
public class TestIO {

	public static void main(String[] args) {
		  Path d1 = Paths.get("lang", "java");
		  Path d2 = d1.resolve("pro");
		  System.out.println(d2);
	}
}
