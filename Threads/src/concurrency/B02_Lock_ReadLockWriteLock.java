package concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

	
	/*

		
		ReadLock และ WriteLock คืออะไร?
		ReadLock และ WriteLock เป็นส่วนหนึ่งของ ReentrantReadWriteLock ซึ่งอยู่ในแพ็กเกจ java.util.concurrent.locks ใน Java
		ถูกออกแบบมาเพื่อช่วยให้หลายเธรดทำงานร่วมกันได้อย่างปลอดภัย โดยใช้กลไกการล็อกที่เหมาะสม
		
		ReentrantReadWriteLock ทำงานอย่างไร?
		มันแยกการล็อกออกเป็น ReadLock และ WriteLock
		ทำให้ หลายเธรด สามารถ อ่านข้อมูลพร้อมกันได้ (ReadLock) ตราบใดที่ไม่มีเธรดใดทำการเขียน
		แต่เมื่อมีการ เขียนข้อมูล (WriteLock) เธรดอื่นจะไม่สามารถอ่านหรือเขียนได้จนกว่าการล็อกเขียนจะเสร็จสิ้น
		
		ReadLock คืออะไร?
			ReadLock ใช้สำหรับการล็อกเมื่อมี หลายเธรด ต้องการอ่านข้อมูลพร้อมกัน
			หลายเธรดสามารถถือ ReadLock ได้พร้อมๆ กัน แต่จะไม่สามารถใช้ WriteLock ได้ในขณะเดียวกัน
			เหมาะสำหรับกรณีที่ การอ่านข้อมูลไม่ต้องการแก้ไขค่า
		
		WriteLock คืออะไร?
			WriteLock ใช้สำหรับการล็อกเมื่อมีการ เขียนข้อมูล หรือ แก้ไขข้อมูล
			ในขณะที่เธรดใดเธรดหนึ่งถือ WriteLock อยู่
			เธรดอื่นจะไม่สามารถถือ ReadLock หรือ WriteLock ได้
			ทำให้มั่นใจได้ว่าข้อมูลจะไม่ถูกเปลี่ยนแปลงจากเธรดอื่นพร้อมกัน

		|---------------------------------------------------------------------------------------|	
		|					    ข้อแตกต่างระหว่าง ReadLock และ WriteLock								|
		|---------------------------------------------------------------------------------------|											|
		|	คุณสมบัติ				|	ReadLock					|	WriteLock					|
		|	การใช้งาน				|	อ่านข้อมูลอย่างเดียว					|	แก้ไข/เขียนข้อมูล					|
		|	จำนวนเธรด				|	หลายเธรดถือ ReadLock พร้อมกันได้	|	มีได้แค่ 1 เธรดเท่านั้นที่ถือ WriteLock	|
		|	ความปลอดภัย			|	ปลอดภัยสำหรับการอ่าน				|	ปลอดภัยสำหรับการเขียน				|
		|	การปิดกั้น (Blocking)	|	ปิดกั้น WriteLock				|	ปิดกั้นทั้ง ReadLock และ WriteLock	|
		|---------------------------------------------------------------------------------------|
		
			ข้อควรระวังในการสอบ OCP
			1.	ReadLock หลายเธรดถือได้พร้อมกัน:
					ถ้าไม่มี WriteLock ค้างอยู่ ReadLock สามารถถูกถือโดยหลายเธรดได้
			2.	WriteLock เป็นการล็อกแบบ Exclusive:			
					ในขณะที่ WriteLock ถูกถือโดยเธรดหนึ่ง เธรดอื่นไม่สามารถใช้ทั้ง ReadLock และ WriteLock ได้
			3.  Deadlock ระวัง!		
					การล็อกหลายครั้งซ้อนกัน (Nested Locking) อาจทำให้เกิด Deadlock ได้ ถ้าไม่ใช้ unlock() อย่างถูกต้อง
			5.	วิธีปลดล็อก (unlock)			
					ต้องแน่ใจว่าทุกครั้งที่มีการ lock() ต้องมีการ unlock() เสมอ เพื่อไม่ให้เกิดปัญหาล็อกค้าง
					
			คำถามที่อาจเจอในข้อสอบ OCP
			1.	สถานการณ์การล็อกหลายเธรด
					ให้เลือกว่าล็อกใด (ReadLock/WriteLock) สามารถทำงานพร้อมกันได้
			2.  โค้ดที่มี Deadlock ซ่อนอยู่			
					ให้วิเคราะห์ว่าโค้ดใดจะทำให้เกิด Deadlock
			3.	เมธอดที่ใช้ร่วมกับ ReadWriteLock		
					เช่น lock(), unlock(), tryLock()
			4.	การใช้ tryLock() กับ ReadLock หรือ WriteLock		
					ถามว่าการใช้ tryLock() ทำให้โปรแกรมไม่ค้างได้อย่างไร

	 */

	

public class B02_Lock_ReadLockWriteLock {

	 private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	    private static final ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
	    private static final ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

	    private static int data = 0;

	    public static void main(String[] args) {
	        // Thread สำหรับอ่าน
	        Thread reader1 = new Thread(() -> {
	            readLock.lock();
	            try {
	                System.out.println("Reader 1 อ่านค่า: " + data);
	            } finally {
	                readLock.unlock();
	            }
	        });

	        // Thread สำหรับเขียน
	        Thread writer1 = new Thread(() -> {
	            writeLock.lock();
	            try {
	                data++;
	                System.out.println("Writer 1 เขียนค่าใหม่: " + data);
	            } finally {
	                writeLock.unlock();
	            }
	        });

	        reader1.start();
	        writer1.start();
}}
