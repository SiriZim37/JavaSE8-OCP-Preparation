package set;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class B04_TreeSetMitInteger {

	public static void main(String[] args) {
		 System.out.println("\n***TreeSet mit der Standard-Sortiereung");

		  Set<Integer> set = new TreeSet<Integer>();

		  set.add(56);
		  set.add(56);
		  set.add(56);
		  set.add(56);
	        
	      System.out.println("1. size: " + set.size());		// 1
	      
	      set.add(-13);
		  set.add(2);
		  set.add(-7);
		  set.add(100);
		  
	      System.out.println("2. set: " + set);	 // [-13, -7, 2, 56, 100]

	      
	      
	      System.out.println("\n***TreeSet mit der absteigenden Sortiereung");
	     
	      Comparator<Integer> cmp = Comparator.reverseOrder();
	      
	      Set<Integer> set2 = new TreeSet<Integer>(cmp);

	      set.add(-7);
		  set.add(100);
		  set.add(-50);
		  set.add(9);
	      
		  System.out.println("3. set: " + set);	 // [-50, -13, -7, 2, 9, 56, 100]
	}

}
