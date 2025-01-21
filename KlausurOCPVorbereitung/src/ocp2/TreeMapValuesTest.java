package ocp2;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapValuesTest {

	public static void main(String[] args) {
		 Map<Integer, String> books = new TreeMap<>();
		 books.put (1007, "A");
		 books.put (1002, "C2");
		 books.put (1001, "B");
		 books.put (1003, "B");
		 System.out.println (books);
		 
			/*
			 * 
			 *   A. {1007 = A, 1002 = C, 1001 = B, 1003 = B}
				 B. {1001 = B, 1002 = C, 1003 = B, 1007 = A}
				 C. {1002 = C, 1003 = B, 1007 = A}
				 D. {1007 = A, 1001 = B, 1003 = B, 1002 = C}
				 
				 
				 
				 B is Correct
			 */
		 
		 
		 Map<Integer, String> books2 = new LinkedHashMap();
		 books2.put (1007, "A");
		 books2.put (1002, "C2");
		 books2.put (1001, "B");
		 books2.put (1003, "B");
		 System.out.println (books2);
		 
		 // {1007=A, 1002=C2, 1001=B, 1003=B}
	}

}
