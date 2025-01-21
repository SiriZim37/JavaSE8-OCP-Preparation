package klausur;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
 Gegeben ist folgender Code, der kompiliert:

  try {
    File file = new File("autos.txt");
    FileWriter fw = new FileWriter(file);
    BufferedWriter out = new BufferedWriter( fw );
    out.write("VW Golf");
    out.close();
  } catch(IOException e) {
    System.out.println("IOE abgefangen"); 
  }

Was trifft zu?
Eine oder mehrere richtige Antworten sind möglich.

[ X ] Zu der Ausgabe "IOE abgefangen" kann es definitiv nicht kommen.
[ X ] Der Writer 'out' wird definitiv geschlossen.
[   ] Keine weiteren catch-Blöcke, die kompilieren würden, darf man hinzufügen.
[ X ] Zusätzlicher catch-Block für java.lang.RuntimeException würde kompilieren.
 */
public class TestIO3 {

	public static void main(String[] args) {
		  try {
			    File file = new File("autos.txt");
			    FileWriter fw = new FileWriter(file);
			    BufferedWriter out = new BufferedWriter( fw );
			    out.write("VW Golf");
			    out.close();
			  } catch(IOException e) {
			    System.out.println("IOE abgefangen"); 
			  }
	}
	
	  
}
