package aufgaben.sort.a1;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class TestTreeSetInteger {

	public static void main(String[] args) {

		// #### A1.
		
		TreeSet<Integer> set1 = new TreeSet<Integer>();
		
		Random rnd = new Random();
		while (set1.size() < 100) {
			int zahl = rnd.nextInt(1001);	// zufällige Integer aus dem Bereich [0 .. 1000]
			set1.add(zahl);
		}
		
		System.out.println("a.1. size: " + set1.size());
	    System.out.println("a.2. aufsteigend: " + set1);
		
		
	    // Absteigendes Set
		Comparator<Integer> cmp = Comparator.reverseOrder();
		TreeSet<Integer> set2 = new TreeSet<Integer>(cmp);
		set2.addAll(set1);
		
		System.out.println("b.1. size: " + set2.size());
        System.out.println("b.2. absteigend: " + set2);
		
		// #### A2.

        // Subset im aufsteigenden Set 
        NavigableSet<Integer> subset1 = set1.subSet(800, true , 900 , true); //  true : 900 inklusive
		System.out.println("c.1 Subset1 size: " + subset1.size());
		System.out.println("c.2 Subset1 der Elemente im Bereich [800 .. 900]: " + subset1);
		        
		// Subset im absteigenden Set 
		NavigableSet<Integer> subset2 =  set2.subSet(900, true , 800 , true); // true : 800 inklusive
		System.out.println("d.1 Subset2 size: " + subset2.size());
        System.out.println("d.2 Subset2 der Elemente im Bereich [800 .. 900]: " + subset2);

		

	}


}
