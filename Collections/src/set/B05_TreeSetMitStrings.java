package set;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class B05_TreeSetMitStrings {

	public static void main(String[] args) {


		  Set<String> set = new TreeSet<String>();

		  set.add("gg");
		  set.add("kk");
		  set.add("gg");
		  set.add("bb");
		  set.add("gg");
		  set.add("yy");
	        
	      System.out.println("1. size: " + set.size());		// 4
	        
	      System.out.println("2. set: " + set);	 //[bb, gg, kk, yy]

	      
	      System.out.println("\n***TreeSet mit der absteigenden Sortiereung");
	      
	      Comparator<String> cmp = Comparator.reverseOrder();
	      
	      Set<String> set2 = new TreeSet<String>(cmp);
	      
	      set2.addAll(set);
	      System.out.println("4. size: " + set2.size());	// 4 
	      
		  System.out.println("5. set: " + set2);			// [yy, kk, gg, bb]	
	      
	}

}
