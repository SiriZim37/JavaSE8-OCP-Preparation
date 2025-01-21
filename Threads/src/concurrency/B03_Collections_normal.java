package concurrency;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.TreeSet;
import java.util.Vector;

public class B03_Collections_normal {

	public static void main(String[] args) {
		
		/*
		 * Es wird irgendwann Exception  
		 * Ergebnis :   java.lang.ArrayIndexOutOfBoundsException: Index 75 out of bounds for length 15
		 * 				size(): 1010
		 */
	
		/*
		 * Race Condition bei allen
		 */
		test(new ArrayList<>());       // es kann sein : java.lang.ArrayIndexOutOfBoundsException: arraycopy: length -45 is negative
//		test(new LinkedList<>());
//		test(new HashSet<>());
//		test(new LinkedHashSet<>());
//		test(new TreeSet<>());			// es kann sein Exception in thread "Thread-0" java.lang.NullPointerException:
//		test(new PriorityQueue<>());	//Exception in thread "Thread-1" java.lang.NullPointerException
//		test(new ArrayDeque<>());		// es kann sein : java.lang.ArrayIndexOutOfBoundsException: arraycopy: length -45 is negative
		
		
		/*
		 * Vector ist threadsicher
		 */
//		test(new Vector<>());		// size : 2000
		
		
	}

	
	 static void test(Collection<Integer> coll) {
	
		 Runnable task = () -> {
			 for (int i = 0; i < 1_000; i++) {
				 coll.add(i);
			}
		 };
		 
		 Thread t0 = new Thread(task);
		 Thread t1 = new Thread(task);
		
		 t0.start();
		 t1.start();
		 
		 try {
			t0.join();
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		 
		 System.out.println("size(): " + coll.size());
	}
}
