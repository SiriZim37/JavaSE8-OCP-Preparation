package klausur;

import java.util.ArrayList;
import java.util.List;

/*
 Gegeben:

  List listA = new ArrayList();	// A
  List<?> listB = new ArrayList<Object>();	// B
  List<Integer> listC = new ArrayList<>();	// C
  List<Integer> listD = new ArrayList<?>();	// D

Welche Zeilen kompilieren, wenn alle Typen richtig importiert wurden?
Eine oder mehrere richtige Antworten sind möglich.

[   ] A
[   ] B
[   ] C
[   ] D

 */
public class Test5 {

	public static void main(String[] args) {
		
		  List listA = new ArrayList();	// A
		  List<?> listB = new ArrayList<Object>();	// B
		  List<Integer> listC = new ArrayList<>();	// C
//		  List<Integer> listD = new ArrayList<?>();	// D
		  
	}
}
