package ocp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class Comparator3 {
	
	public static void main(String[] args) {
		  String[] words = { "Good", "Bad", "Ugly" };
		  Sorter s = new Sorter();
		  Arrays.sort(words, s);
		  for (String s1 : words) {
			System.out.println(s1);
		}
		 
	}
	
	static class Sorter implements Comparator<String>{
	      public int compare(String s1, String s2) {
	        return s2.charAt(1) - s1.charAt(1);
	      }
	    }
	    
			


	
}
