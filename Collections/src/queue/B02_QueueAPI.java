package queue;

import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.Queue;

public class B02_QueueAPI {

	
	/*  "Queue API"
	 1: Queue Interface 
	  		- The Queue interface is a part of java.util package and extends the Collection interface
	  		  อินเทอร์เฟซ Queue เป็นส่วนหนึ่งของแพ็กเกจ java.util และขยายจากอินเทอร์เฟซ Collection

	    boolean add(E e)	แทรกองค์ประกอบที่ระบุเข้าไปในคิว คืนค่า true หากสำเร็จ	
		boolean offer(E e)	แทรกองค์ประกอบที่ระบุเข้าไปในคิว หรือคืนค่า false หากไม่สามารถเพิ่มได้ในขณะนี้	
		E remove()			ดึงและลบองค์ประกอบหัวของคิว หากคิวว่างจะโยน NoSuchElementException	
		E poll()			ดึงและลบองค์ประกอบหัวของคิว หรือคืนค่า null หากคิวว่าง	
		E element()			ดึงองค์ประกอบหัวของคิวแต่ไม่ลบ หากคิวว่างจะโยน NoSuchElementException	
		E peek()			ดึงองค์ประกอบหัวของคิวแต่ไม่ลบ หรือคืนค่า null หากคิวว่าง		
		boolean isEmpty()	ตรวจสอบว่าคิวว่างหรือไม่	
		int size()			คืนค่าจำนวนองค์ประกอบในคิว	

	 2: BlockingQueue Interface
	
	 	- 	The BlockingQueue interface extends Queue and provides additional 
	 		methods for blocking operations.
	 		อินเทอร์เฟซ BlockingQueue ขยายจาก Queue และมีวิธีการเพิ่มเติมสำหรับการทำงานที่บล็อก
	 	-	 It is useful in multi-threaded programming where a thread can wait 
	  		for the queue to become non-empty when retrieving an element, 
	  		or wait for space to become available when adding an element.
	  		เป็นประโยชน์ในโปรแกรมมัลติเธรดที่เธรดสามารถรอให้คิวไม่ว่างเมื่อดึงข้อมูล หรือรอให้มีพื้นที่ว่างเมื่อเพิ่มข้อมูล
	  		
	  	E take()			ดึงและลบองค์ประกอบหัวของคิว โดยรอหากจำเป็นจนกว่าจะมีองค์ประกอบพร้อมใช้งาน	
		E poll(long timeout, TimeUnit unit)	ดึงและลบองค์ประกอบหัวของคิว โดยรอสูงสุดตามเวลาที่กำหนดหากจำเป็น			
	 */
	
	public static void main(String[] args) {

		Queue<String> queue = new ArrayDeque<String>();
		
		queue.add("mo");
		queue.offer("di");
		System.out.println("1. queue: " + queue);  // [mo, di]
		
		queue.add("mi");
		queue.offer("do");
		System.out.println("2. queue: " + queue);  // [mo, di, mi, do]
		
		/*
		 * E element()	: ดึงองค์ประกอบหัวของคิวแต่ไม่ลบ หากคิวว่างจะโยน NoSuchElementException	
		 * E peek()		: ดึงองค์ประกอบหัวของคิวแต่ไม่ลบ หรือคืนค่า null หากคิวว่าง		
		 */
		String s = queue.element();
		System.out.println("element(): " + s );   // mo
		
		s = queue.peek();
		System.out.println("peek(): " + s );      // mo
		
		/*
		 * Original : [mo, di, mi, do]
		 */
		
		/*
		 * E remove() : ดึงและลบองค์ประกอบหัวของคิว หากคิวว่างจะโยน NoSuchElementException	
		 * E poll()	  : ดึงและลบองค์ประกอบหัวของคิว หรือคืนค่า null หากคิวว่าง	
		 */
		s = queue.poll();
		System.out.println("poll(): " + s ); 	    // mo
		System.out.println("4. queue: " + queue);  // [di, mi, do]
		
		s = queue.remove();
		System.out.println("remove(): " + s ); 	    // di
		System.out.println("5. queue: " + queue);  //  [mi, do]
		
		queue.clear();
		System.out.println("6. queue: " + queue);  // []
		
		try {
			s = queue.element();
		} catch (NoSuchElementException e) {
			System.out.println("Exception in lelment() : Die Schlage ist leer");
		}
		
		s = queue.peek();
		System.out.println("peek(): " + s); 	// null

		
		try {
			s = queue.remove();
		} catch (NoSuchElementException e) {
			System.out.println("Exception in remove() : Die Schlage ist leer");
		}
		
		s = queue.poll();
		System.out.println("poll(): " + s); 	// null
	}

}
