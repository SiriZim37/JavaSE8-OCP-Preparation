package klausur;

import java.util.ArrayList;
import java.util.List;

/*
 Was kompiliert, wenn alle Typen richtig importiert wurden?
Eine oder mehrere richtige Antworten sind möglich.

[   ] List<Integer> list = new ArrayList<Integer>();
[   ] List<Double> list = new ArrayList<Integer>();
[   ] Comparable<String> var = "String ist Comparable";
[   ] List<? super Integer> list = new ArrayList();
 */
public class Test3 {

	public static void main(String[] args) {

			List<Integer> list1 = new ArrayList<Integer>();		
//			List<Double> list2 = new ArrayList<Integer>();
			Comparable<String> var = "String ist Comparable";
			List<? super Integer> list3 = new ArrayList();
	}
}
