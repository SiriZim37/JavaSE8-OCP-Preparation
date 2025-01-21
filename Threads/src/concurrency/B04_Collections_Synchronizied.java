package concurrency;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

public class B04_Collections_Synchronizied {

	/*
	 * การหลีกเลี่ยงปัญหาที่เกี่ยวกับการทำงานพร้อมกัน (Concurrency Issues):
	 * 
	 * โดยการใช้ Collections.synchronized... โปรแกรมนี้จะช่วยป้องกันปัญหาที่อาจเกิดขึ้นจากการเข้าถึงข้อมูล
	 * โดยเธรดหลายตัวพร้อมกัน เช่น race condition และ data inconsistency ซึ่งอาจเกิดขึ้นเมื่อข้อมูลในคอลเล็กชัน
	 * ถูกปรับปรุงโดยเธรดหลายตัวในเวลาเดียวกัน ซึ่งอาจทำให้ข้อมูลเสียหายหรือไม่ตรงกัน
	 * 
	 * วัตถุประสงค์ของโปรแกรม:
	 * โปรแกรมนี้ออกแบบมาเพื่อทดสอบการทำงานของคอลเล็กชันที่รองรับการเข้าถึงจากหลายเธรด (multi-threaded environment)
	 * โดยการใช้คอลเล็กชันที่มีความปลอดภัยเมื่อถูกเข้าถึงพร้อมกัน เช่น Collections.synchronizedList,
	 * Collections.synchronizedSet, และ Collections.synchronizedCollection เพื่อให้คอลเล็กชันเหล่านี้ทำงานได้อย่าง
	 * ถูกต้องและปลอดภัยในสภาพแวดล้อมที่มีเธรดหลายตัวทำงานพร้อมกัน
	 */

	public static void main(String[] args) {
		
		/*
		 * Vector ist wie ArrayList , aber threadsicher
		 */
		test(new Vector<>());
		
		/*
		 * static <T> List<T> synchronizedList(List<T> list)  , liefert threadsichere List zurück
		 */
		List<Integer> list1 =  Collections.synchronizedList(new ArrayList<>());	
		test(list1);
		
		List<Integer> list2 =  Collections.synchronizedList(new LinkedList<>());	
		test(list2);
		
		/*
		 * static <T> Set<T> synchronizedSet(Set<T> s) 	 , liefert threadsichere Set zurück
		 */
		Set<Integer> set1 =  Collections.synchronizedSet(new HashSet<>());	
		test(set1);
		Set<Integer> set2 =  Collections.synchronizedSet(new LinkedHashSet<>());	
		test(set2);
		Set<Integer> set3 =  Collections.synchronizedSet(new TreeSet<>());	
		test(set3);
		
		/*
		 * static <T> Collection<T> synchronizedCollection(Collection<T> c)  , liefert threadsichere Collection zurück
		 */
		Collection<Integer> coll1 = Collections.synchronizedCollection(new PriorityQueue<>());
		test(coll1);
		Collection<Integer> coll2 = Collections.synchronizedCollection(new ArrayDeque<>());
		test(coll2);
		
	}

	
	 static void test(Collection<Integer> coll) {
		 System.out.println("*** " + coll.getClass().getSimpleName() );
		 
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
