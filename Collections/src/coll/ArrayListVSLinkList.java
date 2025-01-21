package coll;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayListVSLinkList {

	/*
	 *  ArrayList และ LinkedList เป็นคลาสที่ใช้ในการจัดการกับรายการ (List) 
	 *  โดยทั้งคู่เป็นส่วนหนึ่งของ Java Collections Framework 
	 *  แต่มีความแตกต่างกันในเรื่องโครงสร้างข้อมูลและประสิทธิภาพการทำงาน 
	 *  ขอสรุปความแตกต่างระหว่าง ArrayList และ LinkedList
	 *  
	 * 1. Data Structure
	 * 		- ArrayList: 
	 * 				+ Uses an array data structure to store elements.  
	 * 					ใช้หน่วยความจำมากกว่าในบางครั้ง เนื่องจากต้องจัดสรรพื้นที่สำหรับอาเรย์
	 * 				+ The size of the array can grow dynamically when needed. 
	 * 					ขนาดอาเรย์ต้องมีการขยายเมื่อข้อมูลเกินขนาด
	 * 		- LinkedList:
	 * 				+ Uses a linked list data structure, which consists of nodes  
	 * 					that store data and reference the next node. 
	 * 					ช้หน่วยความจำมากขึ้นในการจัดเก็บข้อมูลเนื่องจากต้องเก็บอ้างอิงไปยังโหนดถัดไป
	 * 				+ Data is stored in a non-contiguous memory location. 
	 * 					มีการใช้หน่วยความจำที่มีประสิทธิภาพมากกว่าเมื่อมีการเพิ่มหรือลบโหนดบ่อย ๆ
	 */
	public static void main(String[] args) {

		/*
		 * 2. Accessing Elements
		 * 
		 * 		- ArrayList : Accessing elements is fast!  (O(1)) 
		 * 				because you can directly access them using an index.
		 * 		- LinkedList :  Accessing elements is slower!  (O(n)) 
		 * 				because you have to traverse each node until you reach the desired node.
		 */
		
		ArrayList<String> list1 = new ArrayList<>();
		String item1 = list1.get(2); // // Accessing using an index เข้าถึงอาเรย์โดยใช้ดัชนี 
	
		
		LinkedList<String> list2 = new LinkedList<>();
		String item2 = list2.get(2); // Must traverse nodes ต้องเดินผ่านโหนดทีละโหนด

		
		/*
		 * 3. Adding and Removing Elements
		 * 
		 * 		- ArrayList:
		 * 				- 	Adding elements (especially in the middle) and removing elements 
		 * 					(especially from the middle) is slower!! (O(n)) 
		 * 					because you have to shift elements in the array.
		 * 					(การเพิ่มข้อมูล (โดยเฉพาะที่ตำแหน่งกลาง) และการลบข้อมูล (โดยเฉพาะจากตำแหน่งกลาง) 
		 * 					จะช้ากว่า (O(n)) เนื่องจากต้องเลื่อนข้อมูลในอาเรย์)
		 * 				-	 Adding elements at the end of the array (O(1)) is fast!! as long as 
		 * 					there is space available.  (การเพิ่มข้อมูลที่ท้ายอาเรย์ (O(1)) จะรวดเร็วตราบใดที่มีพื้นที่ว่าง)
		 * 
		 * 		- LinkedList:
		 * 				-	Adding and removing elements is faster! (O(1))
		 * 					 if you have a reference to the node you want to add or remove.
		 * 					(การเพิ่มและลบข้อมูลทำได้รวดเร็ว (O(1)) หากมีการอ้างอิงถึงโหนดที่ต้องการ)
		 */
		
		LinkedList<String> list = new LinkedList<>();
		list.addFirst("A"); // Add at the beginning
		list.addLast("B"); // Add at the end
		
		
		/*
		 * 4. Memmory 
		 * 		-	ArrayList: 
		 * 				-	May use more memory at times because it needs to allocate space for the array.
		 * 					ใช้หน่วยความจำมากกว่าในบางครั้ง เนื่องจากต้องจัดสรรพื้นที่สำหรับอาเรย์ 
		 * 				-	The size of the array needs to be increased when the data exceeds its capacity.
		 * 					ขนาดอาเรย์ต้องมีการขยายเมื่อข้อมูลเกินขนาด 
		 * 		-LinkedList:
		 * 				-	Uses more memory to store data because it needs to keep references to the next node.
		 * 					ใช้หน่วยความจำมากขึ้นในการจัดเก็บข้อมูลเนื่องจากต้องเก็บอ้างอิงไปยังโหนดถัดไป
		 * 				-	It can be more memory-efficient when there are frequent additions or deletions of nodes.
		 * 					มีการใช้หน่วยความจำที่มีประสิทธิภาพมากกว่าเมื่อมีการเพิ่มหรือลบโหนดบ่อย ๆ
		 */
		
		
		/*
		 * ArrayList และ LinkedList มีคุณสมบัติที่แตกต่างกันตามความต้องการในการใช้งาน 
		 * หากคุณต้องการการเข้าถึงที่รวดเร็วและข้อมูลไม่เปลี่ยนแปลงบ่อย ๆ ArrayList จะเป็นตัวเลือกที่ดีกว่า 
		 * แต่ถ้าคุณต้องการเพิ่มหรือลบข้อมูลบ่อย ๆ LinkedList จะเหมาะสมกว่า.
		 */
		
	}

}
