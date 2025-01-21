package coll;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class B02_Iterator {

	/*
	 * Interface Iterator 
	 * 
	 * Iterator (อิเทเรเตอร์) คือวัตถุที่ช่วยให้สามารถวนลูปผ่านองค์ประกอบต่าง ๆ ของ Collection 
	 * (เช่น List, Set ฯลฯ) โดยไม่เปิดเผยโครงสร้างภายในของ Collection นั้น ๆ 
	 * 
	 *  	- bolean hasNext()
	 *  	- T next()
	 *  	- void remove()
	 *  
	 *  - การปิดบังข้อมูล Kapselung (Encapsulation): Iterator จะปิดบังการทำงานภายในของ Collection 
	 *  										ทำให้คุณไม่ต้องกังวลเกี่ยวกับรายละเอียดเฉพาะของ Collection
	 *  - ความยืดหยุ่น Flexibilität: สามารถใช้ Iterator ในการวนลูปผ่าน Collection 
	 *  						ที่แตกต่างกันโดยไม่ต้องเปลี่ยนแปลงโค้ด
	 *  - การลบองค์ประกอบ Entfernen von Elementen: : คุณสามารถลบองค์ประกอบระหว่างการวนลูปได้โดยไม่ต้องเสี่ยงที่จะเกิด 
	 *  										 ConcurrentModificationException 
	 *  										 ตราบใดที่คุณใช้เมธอด remove() ของ Iterator

	 *  ***********************************
	 * Interface Iterable<T>
	 *  
	 *  Iterable<T> เป็นอินเตอร์เฟซแบบเจนเนอริกที่ใช้พารามิเตอร์ประเภท T ซึ่งระบุประเภทขององค์ประกอบที่ชุดข้อมูลนั้นประกอบด้วย
	 *  
	 *  	- Iterator<T> iterator();
	 *  
	 *  อินเตอร์เฟซ Iterable ช่วยให้สามารถใช้ลูป for ขยาย (หรือที่เรียกว่า "for-each" loop) 
	 *  ซึ่งทำให้โค้ดอ่านง่ายและสะดวกขึ้น
	 *  เนื่องจากคลาสมาตรฐานหลาย ๆ คลาส เช่น ArrayList, HashSet และคลาส Collection อื่น ๆ 
	 *  ต่างก็ได้ทำการ implement Iterable จึงทำให้คุณสามารถใช้ลูปนี้ร่วมกับคลาสเหล่านี้ได้
	 *  
	 */
	public static void main(String[] args) {
		
		
		Collection<Integer> coll =  new ArrayList<Integer>();
		coll.add(12);		
		coll.add(14);
		coll.add(13);
		
		/*
		 * Bsp 1 
		 */
		System.out.println("*** mit der while-Schleife");
		
		Iterable<Integer> iterable = coll ; // Iterable <- IS-A <- Collection
		
		Iterator<Integer> it = iterable.iterator();
		
		while (it.hasNext()) {
			Integer x = it.next();
			System.out.println( "x = " + x);
		}
		
		/*
		 * Bsp 2 
		 */
		System.out.println("*** mit der for-Schleife");
		
		for (Iterator<Integer> myItor = coll.iterator(); myItor.hasNext() ; ) {
			Integer x = myItor.next();
			System.out.println("x = " + x);
		}

		/*
		 * Bsp 2 
		 * 
		 * Im Hintergrund ist die foreach-Schleife mit einer normalen Schleife realisiert
		 */
		System.out.println("*** mit der foreach-Schleife");
		
		for(Integer x : coll) {
			System.out.println("x = " + x);
		}
	}

}
