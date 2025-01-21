package klausur;

import java.io.IOException;
/*
 Gegeben:

  Path arg = Paths.get("hallo");
		
  Stream<Path> var1 = Files.walk(arg);	//A
  Stream<Path> var2 = Files.find(arg, 1, (p,a)->true);	//B
  Stream<Path> var3 = Files.lines(arg);	//C
  Stream<Path> var4 = Files.list(arg);	//D

Was ist richtig, wenn alle im Code verwendeten Typen korrekt importiert wurden und alle möglichen checked Exceptions abgefangen wurden?
Eine oder mehrere richtige Antworten sind möglich.

[   ] Zeile A kompiliert.
[   ] Zeile B kompiliert.
[   ] Zeile C kompiliert.
[   ] Zeile D kompiliert.
 */
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TestSreamPath1 {

	public static void main(String[] args) throws IOException {
		  Path arg = Paths.get("hallo");
			
		  Stream<Path> var1 = Files.walk(arg);	//A
		  Stream<Path> var2 = Files.find(arg, 1, (p,a)->true);	//B
//		  Stream<Path> var3 = Files.lines(arg);	//C
		  Stream<Path> var4 = Files.list(arg);	//D
	}
}
