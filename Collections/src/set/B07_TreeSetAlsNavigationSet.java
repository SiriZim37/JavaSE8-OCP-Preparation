package set;

import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class B07_TreeSetAlsNavigationSet {

/*
 * TreeSet Methods:
 *
 * E first()           : Returns the first (lowest) element in the set. 
 *                       Throws NoSuchElementException if the set is empty.
 *                       : คืนค่าองค์ประกอบแรก (ต่ำสุด) ในเซ็ต
 *                       : โยน NoSuchElementException หากเซ็ตว่าง
 *
 * E last()            : Returns the last (highest) element in the set. 
 *                       Throws NoSuchElementException if the set is empty.
 *                       : คืนค่าองค์ประกอบสุดท้าย (สูงสุด) ในเซ็ต
 *                       : โยน NoSuchElementException หากเซ็ตว่าง
 *
 * E higher(E e)       : Returns the least element in the set that is strictly greater than 'e'.
 *                       Returns null if no such element exists.
 *                       : คืนค่าหมายเลขที่น้อยที่สุดในเซ็ตที่มากกว่า 'e'
 *                       : คืนค่า null หากไม่มีองค์ประกอบดังกล่าว
 *
 * E ceiling(E e)      : Returns the least element in the set that is greater than or equal to 'e'.
 *                       Returns null if no such element exists.
 *                       : คืนค่าหมายเลขที่น้อยที่สุดในเซ็ตที่มากกว่าหรือเท่ากับ 'e'
 *                       : คืนค่า null หากไม่มีองค์ประกอบดังกล่าว
 *
 * E floor(E e)        : Returns the greatest element in the set that is less than or equal to 'e'.
 *                       Returns null if no such element exists.
 *                       : คืนค่าหมายเลขที่มากที่สุดในเซ็ตที่น้อยกว่าหรือเท่ากับ 'e'
 *                       : คืนค่า null หากไม่มีองค์ประกอบดังกล่าว
 *
 * NavigableSet<E> headSet(E toElement) : Returns a view of the portion of the set whose 
 *                                         elements are strictly less than 'toElement'.
 *                                         : คืนค่ามุมมองของส่วนหนึ่งของเซ็ตที่ 
 *                                         : องค์ประกอบน้อยกว่า 'toElement'
 *
 * NavigableSet<E> tailSet(E fromElement) : Returns a view of the portion of the set whose 
 *                                           elements are greater than or equal to 'fromElement'.
 *                                           : คืนค่ามุมมองของส่วนหนึ่งของเซ็ตที่
 *                                           : องค์ประกอบมากกว่าหรือเท่ากับ 'fromElement'
 *
 * NavigableSet<E> subSet(E fromElement, E toElement) : Returns a view of the portion of the set 
 *                                                      whose elements range from 'fromElement' (inclusive)
 *                                                      to 'toElement' (exclusive).
 *                                                      : คืนค่ามุมมองของส่วนหนึ่งของเซ็ตที่
 *                                                      : องค์ประกอบอยู่ระหว่าง 'fromElement' (รวม)
 *                                                      : ถึง 'toElement' (ไม่รวม)
 */

	public static void main(String[] args) {

		TreeSet<Integer> set = new TreeSet<>();
		
		set.add(67);
		set.add(-5);
		set.add(-5);
		set.add(101);
		set.add(-33);
		set.add(27);
		set.add(51);
		
		/*
		 * sortieren
		 * 
		 * [-33, -5, 27, 51, 67, 101] 
		 */
		System.out.println("1. set : " + set); 
		
		/*
		 * E first()  : erste Elemete zurücklierfert
		 * E getFirst() : this.first();
		 * 
		 * E last()  : last Elemete zurücklierfert
		 * E getLast() : this.last();
		 */
		Integer x = set.first();
		x = set.getFirst();
		
		System.out.println("2. first() : " + x ); 		// -33
		
		x = set.last();
		x = set.getLast();
		
		System.out.println("3. last() : " + x ); 		// 101
		
		/*
		 *  E higher(E e) 
		 */
		Integer key = 51;
		x = set.higher(key);
		System.out.println("4. higher(51) : " + x  );  	// 67

		x = set.lower(key);
		System.out.println("5. lower(51) : " + x  );  	// 27
		
		/*
		 * E ceiling(E e) : (sucht Element >= key) Returns the least key greater than or equal to the given key,
		 * 					เพดานของตัวเลขคือค่าต่ำสุดในเซตที่ มากกว่าหรือเท่ากับ ตัวเลขนั้น
		 * 					ตัวอย่าง:หาก TreeSet ของคุณมีเลข {-33, -5, 27, 51, 67, 101} และคุณต้องการหาค่าเพดานของ 51:
		 * 					ค่าเพดานคือ 67 เพราะมันเป็นค่าต่ำสุดที่มากกว่า 51
		 * 
		 * E floor(E e)  : (sucht Element < 0 key)Returns the greatest key less than or equal to the given key,
		 * 					พื้นของตัวเลขคือค่าสูงสุดในเซตที่ "น้อยกว่าหรือเท่ากับ" ตัวเลขนั้น
		 * 					ตัวอย่าง: ใช้เซตเดียวกัน {-33, -5, 27, 51, 67, 101} และมองหาค่าพื้นของ 51:
		 * 					ค่าพื้นคือ 51 เพราะมันเป็นค่าสูงสุดที่น้อยกว่า 51
		 * 
		 */
		x = set.ceiling(key);
		System.out.println("6. ceiling(51) : " + x  );  // 51	

		x = set.floor(key);
		System.out.println("7. floor(51) : " + x  );  // 51	
		
		key = 52;
		x = set.ceiling(key);
		System.out.println("8. ceiling(52) : " + x  );  // 67	
		key = 50;
		x = set.floor(key);
		System.out.println("8. floor(50) : " + x  );  // 27	
		
		/*
		 * headSet ใช้เพื่อดึงมุมมองของเซตที่มีองค์ประกอบที่น้อยกว่าค่าที่ระบุ 
		 * ซึ่งมีประโยชน์เมื่อคุณต้องการรับส่วนหนึ่งของ TreeSet โดยไม่ต้องเปลี่ยนแปลงเซตต้นฉบับ
		 * 
		 */
		
		/*
		 * Original : [-33, -5, 27, 51, 67, 101]
		 * headset1	: [-33, -5, 27]
		 */
		Integer toElement = 51 ;
		SortedSet<Integer> headset1 = set.headSet(toElement) ;  // Obergrenze exklusive  
		System.out.println("headset1 : " + headset1 );
		
		/* 
		 * Original : [-33, -5, 27, 51, 67, 101]
		 * headset1	: [-33, -5, 27, 51]
		 */
		boolean isInclusive = true; 
		SortedSet<Integer> headset2 = set.headSet(toElement , isInclusive) ; 
		System.out.println("headset2 : " + headset2 );
		

		/* 
		 * Original : [-33, -5, 27, 51, 67, 101]
		 * tailSet1	: [27, 51, 67, 101]
		 */
		Integer fromElemte = 27 ;
		SortedSet<Integer> tailSet1 = set.tailSet(fromElemte) ;  // Untergrenze inklusive  
		System.out.println("tailSet1 : " + tailSet1 );
		
		/* 
		 * Original : [-33, -5, 27, 51, 67, 101]
		 * tailSet2	: [51, 67, 101]
		 */
		NavigableSet<Integer> tailSet2 = set.tailSet(fromElemte ,false) ;  // Untergrenze exklusive  
		System.out.println("tailSet2 : " + tailSet2 );
		
		
		/* 
		 * Original : [-33, -5, 27, 51, 67, 101]
		 * subSet1	: [-5, 27, 51]
		 */
		fromElemte = -5 ;
		toElement = 67 ;
		SortedSet<Integer> subSet1 = set.subSet(fromElemte , toElement) ; // Untergrenze inklusive
																	      // Obergrenze  exklusive  
		System.out.println("subSet1 : " + subSet1 );
		
		/* 
		 * Original : [-33, -5, 27, 51, 67, 101]
		 * subSet2	: [27, 51, 67]
		 */
		NavigableSet<Integer> subSet2 = set.subSet(fromElemte ,false , toElement , true) ;  // Untergrenze exklusive
																							// Obergrenze inklusive  
		System.out.println("subSet2 : " + subSet2 );
		

		/*
		 * Achtung in der Praxis 
		 * headSet , tailSet , subSet liefern backed-Sets zurück ! 
		 */
		
		System.out.println("***a. set : " + set);			// [-33, -5, 27, 51, 67, 101]
		System.out.println("***a. subSet1 : " + subSet1);	//  [-5, 27, 51]
		
		/*
		 * add 10 in set 
		 * 				0    1   2   3   4    5   6
		 * Original : [-33, -5, 10, 27, 51,  67,  101]
		 * subSet1	: [-5,  10, 27, 51]
		 */
		set.add(10);
		System.out.println("***b. set : " + set);			// [-33, -5, 27, 51, 67, 101]
		System.out.println("***b. subSet1 : " + subSet1);	//  [-5, 10, 27, 51]
		
		/*
		 * add 35 in subSet1 
		 * 				0    1   2   3  4   5   6   7
		 * Original : [-33, -5, 10, 27, 35, 51, 67, 101]
		 * subSet1	: [-5,  10, 27, 35  51]
		 */
		subSet1.add(35);
		System.out.println("***c. set : " + set);			// [-33, -5, 10, 27, 35, 51, 67, 101]
		System.out.println("***c. subSet1 : " + subSet1);	//  [-5, 10, 27, 35, 51]
		
		
		set.add(1000);			// ok. TreeSet hat keine Grenzen
		System.out.println("***d. set : " + set);			//set :     [-33, -5, 10, 27, 35, 51, 67, 101, 1000]
		System.out.println("***d. subSet1 : " + subSet1);	//subSet1 : [-5, 10, 27, 35, 51]
		subSet1.add(1000);		// Exception.  subSet1 hat Grenzen [-5 ..67]
		/*
		 *  Exception คือการพยายามเพิ่มค่า 1000 เข้าไปใน subSet1 ซึ่ง subSet1
		 *  เป็น SubSet ที่มีขอบเขตการกำหนดช่วง (range-bound) อยู่ที่ [-5, 67) (รวม -5 แต่ไม่รวม 67) 
		 *  ตามการกำหนดในคำสั่ง set.subSet(fromElement, toElement):
		 */
	}

}
