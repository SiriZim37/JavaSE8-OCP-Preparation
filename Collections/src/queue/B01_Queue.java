package queue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class B01_Queue {

	/*
	 * 	1.  boolean add(E e): 	เพิ่มองค์ประกอบที่ระบุเข้าไปในคิว จะเกิดข้อยกเว้นหากไม่สามารถเพิ่มองค์ประกอบได้
		2.	boolean offer(E e): เพิ่มองค์ประกอบที่ระบุเข้าไปในคิว คืนค่า true หากสำเร็จและ false หากไม่สำเร็จ
		3.	E remove():		ลบและคืนค่าหัวของคิว จะเกิดข้อยกเว้นหากคิวว่าง
		4.	E poll(): 		ลบและคืนค่าหัวของคิว คืนค่า null หากคิวว่าง
		5.	E peek(): 		ดึงแต่ไม่ลบหัวของคิว คืนค่า null หากคิวว่าง
		6.	int size():		คืนค่าจำนวนองค์ประกอบในคิว
	 */
	public static void main(String[] args) {
	
		System.out.println("*** LinkList als Queue");
		Queue<Integer> queue = new LinkedList<>();		// FIFO : First in first Out
		
		queue.add(23);
		queue.add(-7);
		queue.add(5);

		System.out.println("1. queue: " + queue); 	// [23, -7, 5]
		
		System.out.println(queue.remove());	  		// 23 
		
		 while (!queue.isEmpty()) {
			 Integer next = queue.remove();
	         System.out.println( next + " ");
	     }
		 
		 System.out.println( "2. queue : " + queue);
		 
		 
		 /*
		  * PriorityQueue : das kleineste Elemete hat die höchste Priorität
		  *  (ใน PriorityQueue องค์ประกอบที่มี ลำดับความสำคัญสูง จะถูกนำออกจากคิวก่อน แม้ว่าจะถูกเพิ่มเข้ามาทีหลัง)
		  *  	
		  *  *_________________________________________________________________________*
		  *  	ตัวอย่างการทำงาน
				  	PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

			        // เพิ่มองค์ประกอบลงใน PriorityQueue
			        priorityQueue.add(5); // ลำดับความสำคัญต่ำ
			        priorityQueue.add(1); // ลำดับความสำคัญสูง
			        priorityQueue.add(3); // ลำดับความสำคัญกลาง
			
			        // แสดงลำดับการนำออกตามลำดับความสำคัญ
			        System.out.println("กำลังนำองค์ประกอบออกจาก PriorityQueue ตามลำดับความสำคัญ:");
			        while (!priorityQueue.isEmpty()) {
			            System.out.println(priorityQueue.poll()); // ผลลัพธ์: 1, 3, 5
			        }
			  *_________________________________________________________________________*
			        
		  * PriorityQueue funktioniert als sortierte Collection
		  *
		  * bei den Methoden 
		  * 	element(): 	ดึงองค์ประกอบที่มีลำดับความสำคัญสูงสุดโดยไม่ลบออก; จะโยนข้อผิดพลาดหากคิวว่าง
		  * 	peek(): 	ดึงองค์ประกอบที่มีลำดับความสำคัญสูงสุดโดยไม่ลบออก; จะคืนค่า null หากคิวว่าง
		  * 	poll(): 	ดึงและลบองค์ประกอบที่มีลำดับความสำคัญสูงสุด; 	 จะคืนค่า null หากคิวว่าง
		  */
		 System.out.println("\n*** PriorityQueue als Queue");
		 queue = new PriorityQueue<>();
		 
		 queue.add(23);
		 queue.add(-7);
		 queue.add(5);
		 
		 System.out.println("3. queue : " + queue);		//[-7, 23, 5]
		 
		 while (!queue.isEmpty()) {
			 Integer next = queue.remove();
			 System.out.print( next + " ");			// ผลลัพธ์: -7 5 23
	     }
		 
		 queue = new PriorityQueue<>();
		 queue.add(23);
		 queue.add(-7);
		 queue.add(5);
		 
		 /*
		  *   E element(); : ดึงข้อมูลองค์ประกอบที่หัวของคิว (องค์ประกอบที่มีลำดับความสำคัญสูงสุด) โดยไม่ลบออก  
		  *   				 หากคิวว่าง จะมีการโยน NoSuchElementException
		  */
		 int head = queue.element(); // คืนค่า  -7 (ลำดับความสำคัญสูงสุด)
		 System.out.println("\nหัวของคิวด้วย element(): " + head);
		 System.out.println( "3. queue : " + queue); 	// [-7, 23, 5]
		 
		 /*
		  *   E peek(); : ดึงข้อมูลองค์ประกอบที่หัวของคิว โดยไม่ลบออก หากคิวว่าง จะคืนค่า null แทนที่จะโยนข้อผิดพลาด
		  */
		 Integer head2 = queue.peek(); // คืนค่า -7 (ลำดับความสำคัญสูงสุด)
		 if (head2 != null) {
		     System.out.println("หัวของคิวด้วย peek(): " + head2);	// -7
		 } else {
		     System.out.println("คิวว่างเปล่า");
		 }
		 System.out.println( "4. queue : " + queue); 	// [-7, 23, 5]
		 
		 /*
		  *   E poll(); : ดึงข้อมูลและลบองค์ประกอบที่หัวของคิว หากคิวว่าง จะคืนค่า null แทนที่จะโยนข้อผิดพลาด
		  */
		 Integer removedHead = queue.poll(); // ดึงและลบ -7
		 if (removedHead != null) {
		     System.out.println("ลบหัวของคิวด้วย poll(): " + removedHead);
		 } else {
		     System.out.println("คิวว่างเปล่า");
		 }
		 System.out.println( "5. queue : " + queue); 	// [5, 23]
	}
	


}
