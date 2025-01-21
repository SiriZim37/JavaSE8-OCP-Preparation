package set;

import java.util.HashSet;
import java.util.Set;

public class B02_HashSetMitInteger {

	public static void main(String[] args) {

		Set<Integer> set =  new HashSet<Integer>();
		
		System.out.println("1. size: " + set.size());		// 0 
		
		set.add(11);
		set.add(2);
		set.add(11);
		set.add(-7);
		set.add(11);
		set.add(900);
		set.add(11);
		set.add(900);
		
		System.out.println("2. size: " + set.size());		// 4
		
		System.out.println("3. set: " + set);				//[2, 900, -7, 11]			
	}

}
