package queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class B03_Deque {

	/*	
	 	"Deque"
	 	
	   ใน Java, อินเทอร์เฟซ Deque เป็นส่วนหนึ่งของ Java Collections Framework
	   และมันขยายจากอินเทอร์เฟซ Queue คลาสหลักที่ทำงานร่วมกับอินเทอร์เฟซ Deque ได้แก่:

		- ArrayDeque als eine Queue : FIFO : 
					ใช้การจัดเก็บข้อมูลแบบอาเรย์ที่ปรับขนาดได้ เป็นตัวเลือกที่ดีเมื่อคุณต้องการคิวที่มีขนาดปรับได้และไม่ถูกบล็อก
		- LinkedList: 
					ใช้รายการเชื่อมสองทางในการจัดเก็บข้อมูล ซึ่งช่วยให้สามารถเพิ่มและลบข้อมูลที่ทั้งสองด้านได้อย่างมีประสิทธิภาพ
		
		void addFirst(E e)	เพิ่มองค์ประกอบที่ระบุที่ด้านหน้าของ Deque
		void addLast(E e)	เพิ่มองค์ประกอบที่ระบุที่ด้านท้ายของ Deque
		boolean offerFirst(E e)	เพิ่มองค์ประกอบที่ระบุที่ด้านหน้า (คืนค่า true หากสำเร็จ, false หากไม่สำเร็จ)
		boolean offerLast(E e)	เพิ่มองค์ประกอบที่ระบุที่ด้านท้าย (คืนค่า true หากสำเร็จ, false หากไม่สำเร็จ)
		
		E removeFirst()		ดึงและลบองค์ประกอบแรก; จะโยน NoSuchElementException หาก Deque ว่าง
		E removeLast()		ดึงและลบองค์ประกอบสุดท้าย; จะโยน NoSuchElementException หาก Deque ว่าง
		E pollFirst()		ดึงและลบองค์ประกอบแรก (หัว) ของ Deque คืนค่า null หาก Deque ว่าง
		E pollLast()		ดึงและลบองค์ประกอบสุดท้าย (ท้าย) ของ Deque คืนค่า null หาก Deque ว่าง
		
		E getFirst()		ดึง (แต่ไม่ลบ) องค์ประกอบแรกของ deque หาก deque ว่าง จะโยน NoSuchElementException
		E peekFirst()		ดึงข้อมูลแต่ไม่ลบองค์ประกอบแรก; คืนค่า null หาก Deque ว่าง
		E getLast()			ดึง (แต่ไม่ลบ) องค์ประกอบสุดท้ายของ deque หาก deque ว่าง จะโยน NoSuchElementException
		E peekLast()		ดึงข้อมูลแต่ไม่ลบองค์ประกอบสุดท้าย; คืนค่า null หาก Deque ว่าง
	
		int size()			คืนค่าจำนวนองค์ประกอบใน Deque
		boolean isEmpty()	ตรวจสอบว่าคิวว่างหรือไม่
		void clear()		ลบองค์ประกอบทั้งหมดจาก Deque
		boolean removeFirstOccurrence(Object o)	ลบการเกิดขึ้นครั้งแรกขององค์ประกอบที่ระบุจาก Deque ถ้ามีอยู่
		boolean removeLastOccurrence(Object o)	ลบการเกิดขึ้นครั้งสุดท้ายขององค์ประกอบที่ระบุจาก Deque ถ้ามีอยู่
 	
	 */
	public static void main(String[] args) {

		Deque<Integer> deque = new ArrayDeque<Integer>();
		
		/*
		 * 
		 */
		deque.addFirst(1);
		deque.addLast(2);
		deque.offerFirst(3);
		deque.offerLast(4);
		System.out.println("1. deque : " + deque ); // HEAD [3 , 1 , 2 , 4] TAIL
		
		deque.addLast(5);
		System.out.println("2. deque : " + deque ); // HEAD [3 , 1 , 2 , 4 , 5 ] TAIL
		
		deque.offerLast(6);
		System.out.println("3. deque : " + deque ); // HEAD [3 , 1 , 2 , 4 , 5 , 6 ] TAIL
		
		Integer x =  deque.pollFirst();
		System.out.println("4. pollFirst  : x =  " + x ); // 3
		


	/*
		TAIL METHODS:
		
			boolean add(E e): 	เพิ่มที่ด้านท้ายของคิว Add to the end of the queue.
			boolean offer(E e): พยายามเพิ่มที่ด้านท้าย (คืนค่า false ถ้าล้มเหลว) Try to add to the end (returns false if it fails). 
			
		HEAD METHODS:
				
			E element(): 	ดึงองค์ประกอบแรก (โยนข้อผิดพลาดหากว่าง) Get the first item (throws if empty).
			E peek(): 		ดึงองค์ประกอบแรก (คืนค่า null หากว่าง) Get the first item (returns null if empty).
			E remove(): 	ลบและคืนค่าองค์ประกอบแรก (โยนข้อผิดพลาดหากว่าง) Remove and return the first item (throws if empty).
			E poll(): 		ลบและคืนค่าองค์ประกอบแรก (คืนค่า null หากว่าง) Remove and return the first item (returns null if empty).
			
		HEAD METHODS for Stack:
				
			void push(E e): เพิ่มที่ยอดAdd to the top. 
			E peek(): 		ดูที่องค์ประกอบยอดของสแตกโดยไม่ลบออก Retrieves the top item from the stack without removing it.
			E pop():  		ลบและคืนค่าองค์ประกอบยอด (โยนข้อผิดพลาดหากว่าง)Remove and return the top item (throws if empty).
	 */
		
		// HEAD [1, 2, 4, 5, 6] TAIL
		System.out.println("5. deque : " + deque );
		deque.add(-3);			// HEAD [1, 2, 4, 5, 6] TAIL [1, 2, 4, 5, 6, -3]
		deque.offer(17);		// HEAD [1, 2, 4, 5, 6] TAIL [1, 2, 4, 5, 6, -3, 17]
		
		System.out.println("6. deque : " + deque );
		
		System.out.println("7. element() : " + deque.element() );	// 1
		
		System.out.println("8. poll() : " + deque.poll() );		// 1
		
		// HEAD [2, 4, 5, 6, -3, 17] TAIL
		System.out.println("9. deque : " + deque ); // [2, 4, 5, 6, -3, 17]   		

		
		/*
		 * องค์ประกอบที่ถูกเพิ่มล่าสุด (ยอด) จะถูกลบออกเป็นองค์ประกอบแรก ตามหลักการ Last-In-First-Out (LIFO)
		 */
		deque.push(101);		// HEAD [101, 2, 4, 5, 6, -3, 17] TAIL
		System.out.println("10. deque : " + deque );  
		
		/*
		 * Frage 1 : 
		 * 	
		 * 		Compiler Fehler
		 */
//		System.out.println("11. deque" +deque.remove()  + "  " +  deque.push(92) );  // cf : push(E e) : void
		
		
		/*
		 * Frage 1 : 
		 * 		
		 * 		 101  true
		 */
		
		System.out.println("12. deque : " + deque.remove()  + "  " +  deque.add(92) ); // 101  true
		
		
		
		// HEAD [2, 4, 5, 6, -3, 17, 92] TAIL
		System.out.println("9. deque : " + deque );
		
		
		/*
		 * Hinweis:
		 */
		// add Tail 
		// HEAD [2, 4, 5, 6, -3, 17, 92 , 100] TAIL
		System.out.println(deque.add(100));
		// HEAD [2, 4, 5, 6, -3, 17, 92 , 100 , 100] TAIL
		System.out.println(deque.offer(100));
		
//		System.out.println(deque.push(100));			// cf : push ist void (kein rückgabe)
		
		// HEAD [100, 2, 4, 5, 6, -3, 17, 92 , 100 , 100] TAIL
		deque.push(100);
		System.out.println(deque);
	}

}
