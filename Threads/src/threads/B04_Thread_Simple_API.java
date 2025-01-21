package threads;

	

public class B04_Thread_Simple_API {
	
	public static void main(String[] args) {
		
		Runnable task = () -> {};

		String name = "My Thread";
		
		/*! prüfung
		 * Konstruktoren 
		 */
		new Thread();						// สร้างเธรดใหม่โดยไม่ระบุ Runnable หรือชื่อ
		new Thread(task);					// สร้างเธรดใหม่พร้อม Runnable
		new Thread(name);					// สร้างเธรดใหม่พร้อมชื่อ
		new Thread(task , name);			// สร้างเธรดใหม่พร้อมทั้ง Runnable และชื่อ
	
		System.out.println();
		//--------------------------------------------------------------------------
		
		/* ! prüfung
		 * getName/setname 
		 */
		
		Thread t1 = new Thread();
		System.out.println("t1.getName(): " + t1.getName());
	
		t1.setName("Tom");
		System.out.println("t1.getName(): " + t1.getName());	   // Tom
		
		Thread t2 = new Thread("Jerry");
		System.out.println("t2.getname(): " + t2.getName());     // Jerry
		
		System.out.println();
		//--------------------------------------------------------------------------
		
		/*! prüfung
		 * Java 8 : 
		 * 
		 * long getId()
		 * 
		 * Ab Java 10 : ThreadId();
		 */
		
		long id = t1.getId();
		System.out.println("t1.getId(): " + id);
		
		System.out.println();
		//--------------------------------------------------------------------------
		
		/*
		 * setPriority/getPriority
		 * 
		 * Es gibt keine Garantie , dass Prioritäten eine Wirkung zeigen
		 *  เธรดมีความสำคัญของการทำงาน (priority) แต่ไม่ได้หมายความว่ามันจะทำงานตามลำดับที่ตั้งไว้
		 */
		
		int priotity = t1.getPriority();
		System.out.println("t1.getPriority(): " + priotity);
		
//		t1.setPriority(Thread.MAX_PRIORITY);	// 10 	 ตั้งเป็นค่าความสำคัญสูงสุด
		t1.setPriority(Thread.NORM_PRIORITY);	// 5	 ตั้งเป็นค่าความสำคัญปกติ
//		t1.setPriority(Thread.MIN_PRIORITY);	// 1  	 ตั้งเป็นค่าความสำคัญต่ำสุด
		
		System.out.println();
		//--------------------------------------------------------------------------
		
		/*
		 * static native Thread currentThread()
		 */
		Thread currentThread  = Thread.currentThread();
		System.out.println("currentThread: " + currentThread.getName());		// main
		
		System.out.println();
		//--------------------------------------------------------------------------
		
		/*
		 * static void yield()
		 * 
		 * A hint to the scheduler that the current thread is willing 
		 * to yield its current use of a processor. 
		 * The scheduler is free to ignore this hint. 
		 * 
		 * yield() คือเมธอดของคลาส Thread ที่ใช้แจ้งให้ Thread Scheduler ทราบว่าเธรดปัจจุบันยินดีที่จะหยุดการทำงานชั่วคราว 
		 * เพื่อให้เธรดอื่น ๆ ที่มีความสำคัญเท่ากันสามารถทำงานได้
		 * 
		 * อย่างไรก็ตาม การเรียกใช้ yield() เป็นเพียงคำแนะนำ (hint) ให้กับ Thread Scheduler 
		 * และไม่การันตีว่าเธรดอื่นจะเริ่มทำงานทันที เนื่องจาก Thread Scheduler อาจเลือกที่จะไม่ทำตามคำแนะนำนี้
		 * การใช้ yield() มักใช้ในสถานการณ์ที่ต้องการให้เธรดอื่นได้ใช้เวลา CPU ในการทำงานบ้าง
		 * 
		 * yield() ไม่ได้บังคับให้หยุดการทำงานของเธรดทันที และไม่ได้ใช้ในการควบคุมลำดับของการทำงานในแอปพลิเคชันที่ต้องการความแม่นยำสูง.
		 */



		Thread.yield();
		
		System.out.println();
		//--------------------------------------------------------------------------
	}
}
