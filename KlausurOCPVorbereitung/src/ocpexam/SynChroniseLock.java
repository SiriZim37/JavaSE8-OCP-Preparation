package ocpexam;

public class SynChroniseLock {

	/*
	 * 

	Which two statements are true about synchronization and locks? (Choose two.)
	
	A. A thread automatically acquires the intrinsic lock on a synchronized statement when executed.
	
	B. The intrinsic lock will be retained by a thread if return from a synchronized method is caused by an uncaught exception.
	
	C. A thread exclusively owns the intrinsic lock of an object between the time it acquires the lock and the time it releases it.
	
	D. A thread automatically acquires the intrinsic lock on a synchronized method’s object when entering that method.
	
	E. Threads cannot acquire intrinsic locks on classes.
	
	
	
	
	A. A thread automatically acquires the intrinsic lock on a synchronized statement when executed.
		ถูกต้อง: เมื่อเธรดทำงานในบล็อกที่มีคำสั่ง synchronized เธรดจะได้รับ ล็อคของวัตถุ ที่บล็อกนั้นถูกซิงโครไนซ์ไว้ทันที 
		ซึ่งทำให้มั่นใจได้ว่า เธรดหนึ่งจะทำงานในส่วนนี้ได้แค่ตัวเดียวในแต่ละครั้ง
		ตัวอย่าง: ถ้าเราใช้ 
		synchronized(block) {...}, 
		
		synchronized (someObject) {
			    // Critical section
			}
		เธรดจะต้องได้รับล็อคของวัตถุที่ถูกระบุใน block ก่อนถึงจะเข้าไปทำงานในบล็อกนั้นได้
		
	B. The intrinsic lock will be retained by a thread if return from a synchronized method is caused by an uncaught exception.
	ถูกต้อง: ถ้าเธรดทำงานใน เมธอดที่ซิงโครไนซ์ แล้วเกิดข้อผิดพลาด (exception) ที่ไม่ได้ถูกจับ (uncaught exception) ล็อคจะยังคงถูกเก็บไว้โดยเธรดนั้นจนกว่าเธรดจะออกจากเมธอดนั้นไป ไม่ว่าจะออกจากเมธอดนั้นปกติหรือเนื่องจากข้อผิดพลาด
	อธิบาย: เมื่อเธรดเสร็จจากการทำงาน (ไม่ว่าจะออกจากเมธอดปกติหรือเกิด exception) มันจะปล่อยล็อคออก
		public synchronized void someMethod() {
		    if (true) throw new RuntimeException("เกิดข้อผิดพลาด");
		}
		ในกรณีนี้ เธรดจะยังคงถือครองล็อคของวัตถุจนกว่าเมธอดจะเสร็จสิ้นการทำงาน แม้จะเกิดข้อผิดพลาด

	C. A thread exclusively owns the intrinsic lock of an object between the time it acquires the lock and the time it releases it.
		ถูกต้อง: เมื่อเธรดได้รับล็อคของวัตถุแล้ว เธรดนั้นจะเป็นเจ้าของล็อค โดยเฉพาะ และไม่สามารถให้เธรดอื่นมาใช้ล็อคนี้ได้จนกว่าเธรดนั้นจะปล่อยล็อคออก
		คำอธิบาย: ข้อนี้ก็เป็นความจริง แต่ไม่เกี่ยวข้องโดยตรงกับคำถามนี้ เพราะคำถามต้องการให้เลือกคำตอบที่เกี่ยวกับการซิงโครไนซ์และล็อคที่เธรดได้รับในขณะที่มันเริ่มทำงานและเก็บล็อค
		คำกล่าวนี้เป็นความจริง แต่มันไม่เกี่ยวข้องโดยตรงกับการซิงโครไนซ์ในตัวเลือกที่ถามในคำถามนี้ เพราะคำถามถามเกี่ยวกับการ เข้าถึงล็อค เมื่อเธรดเริ่มทำงานในเมธอดซิงโครไนซ์
	
	D. A thread automatically acquires the intrinsic lock on a synchronized method’s object when entering that method.
		ไม่ถูกต้อง: เธรดจะได้รับล็อคของ อินสแตนซ์ของวัตถุ (object instance) ที่เมธอดนั้นเป็นส่วนหนึ่ง (ถ้าเป็นเมธอดของอ็อบเจ็กต์) แต่ไม่ได้หมายความว่าเธรดจะได้รับล็อคโดยอัตโนมัติในทันทีทันใดโดยไม่มีเงื่อนไข
		อธิบาย: เธรดจะต้องได้รับล็อคของ อินสแตนซ์ของคลาส ถ้าเมธอดนั้นเป็นเมธอดของอินสแตนซ์ หรือ ล็อคของคลาส ถ้าเมธอดนั้นเป็น static
	
	E. Threads cannot acquire intrinsic locks on classes.
		ไม่ถูกต้อง: เธรดสามารถได้รับ ล็อคของคลาส ได้ โดยเฉพาะในกรณีของเมธอดที่เป็น static synchronized ซึ่งเธรดจะได้รับล็อคของคลาสนั้น ๆ แทนที่จะเป็นอินสแตนซ์ของวัตถุ
		ตัวอย่าง: ในเมธอด static synchronized, ล็อคที่เธรดได้รับจะเป็นล็อคของคลาส (class lock) แทนที่จะเป็นล็อคของอินสแตนซ์
	 * 
	 * 	ANSWER = A B 
	 */
	

	
	
}
