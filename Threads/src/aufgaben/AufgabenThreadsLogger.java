package aufgaben;



class MyLogger {

	/*
	 * ข้อสังเกตเพิ่มเติม
	 * การใช้ StringBuffer จะทำให้โค้ดง่ายขึ้น เพราะ StringBuffer ดูแลเรื่อง thread safety ให้อยู่แล้ว
	 * หากคุณใช้ StringBuilder และไม่ต้องการจัดการล็อกเอง คุณอาจพิจารณาใช้โครงสร้างข้อมูลที่ Thread-safe เช่น java.util.concurrent หรือ Collections.synchronizedCollection
	 */
	private StringBuilder sb = new StringBuilder();	
//	private StringBuffer sb = new StringBuffer();	
	
	/*
	 * การใช้ synchronized ในฟังก์ชัน addMessage และ getLog จะช่วยให้เธรดแต่ละตัวล็อกการเข้าถึงตัวแปร sb
	 * เพื่อให้แน่ใจว่ามีเพียงเธรดเดียวเท่านั้นที่สามารถเพิ่มข้อความ หรืออ่านค่าจาก sb ได้ในช่วงเวลานั้น
	 */
	
	 /*
	  * ใช้ synchronized ในระดับเมธอด (method-level) ทั้งเมธอดถูกล็อก:
	  * เมื่อเธรดหนึ่งเรียกใช้งาน addMessage เธรดอื่นๆ จะต้องรอจนกว่าเธรดปัจจุบันจะทำงานเสร็จ
	  * ใช้ได้ผลดีถ้าเมธอดมีโค้ดที่เกี่ยวข้องกับทรัพยากรที่ใช้ร่วมกันทั้งหมด
	  */
	public synchronized void addMessage(String caller, String message) {		
		/*
		 *  สำหรับการเขียน (Writing):
		 *  ใน addMessage เธรดต้องล็อก sb เพื่อป้องกันปัญหา race condition ระหว่างการเพิ่มข้อความ
		 */
	        sb.append(caller)
	          .append(" - ")
	          .append(message)
	          .append("\n");
	}

//	public void addMessage(String caller, String message) {
	/*
	 * ใช้ synchronized ในระดับบล็อกโค้ด (block-level)
	 *  เฉพาะในบล็อกโค้ดที่เกี่ยวข้องกับ sb:
	 *  เธรดสามารถเข้าถึงส่วนอื่นๆ ของเมธอดได้โดยไม่ต้องรอ แต่เฉพาะบล็อกโค้ดที่อยู่ใน {} จะถูกล็อก
	 *  เหมาะในกรณีที่เมธอดมีโค้ดที่ไม่ได้เกี่ยวข้องกับทรัพยากรที่ใช้ร่วมกัน
	 */
//		synchronized (sb) {
//			sb.append(caller)
//	          .append(" - ")
//	          .append(message)
//	          .append("\n");
//		}    
//	}

	 public synchronized String getLog() {
			/*
			 *  สำหรับการอ่าน (Reading):
			 *  ใน getLog เธรดต้องล็อก sb เช่นกัน เพื่อป้องกันไม่ให้เธรดหนึ่งอ่านข้อมูลที่อาจยังเขียนไม่เสร็จโดยเธรดอื่น
			 */
	        return sb.toString();
	 }
} 


//class MyLogger {
////	private StringBuilder sb = new StringBuilder();
//	private StringBuffer sb = new StringBuffer();
//	public void addMessage(String caller, String message) {
//		sb.append(caller)
//		  .append(" - ")
//		  .append(message)
//		  .append("\n");
//	}
//	
//	public String getLog() {
//		return sb.toString();
//	}
//} 

/*
 * A3 : Wird das Ersetzen vom `StringBuilder`durch einen `StringBuffer` 
 * die Klasse `MyLogger` threadsicher gestalten?
 * 
 * Antwort : Nein
 * 		StringBuilder ist nicht thread-sicher.
 * 		StringBuffer ist thread-sicher, da seine Methoden intern synchronisiert sind.
 * 		Die Klasse `MyLogger` kann threadsicher funktionieren , 
 * 		muss jedoch auch die Methode addMessage synchronisiert werden.
 */

public class AufgabenThreadsLogger {

	public static void main(String[] args) throws InterruptedException {
		
		MyLogger myLogger = new MyLogger();
		
		Runnable task = ()->{		
			Thread curThread = Thread.currentThread();
			String message = ": no ";
			 for (int i = 0; i <= 20; i++) {	
				myLogger.addMessage(curThread.getName(), message + i);
			}
		};
		
		Thread th1 = new Thread(task , "Thread-1");
		Thread th2 = new Thread(task , "Thread-2") ;
		Thread th3 = new Thread(task , "Thread-3");
		
		th1.start();
		th2.start();
		th3.start();
		
		th1.join();
		th2.join();
		th3.join();
		
		System.out.println("Ergebnis:\n" + myLogger.getLog());	
		

	}

	/* Note: 
	 * StringBuffer : 
	 * 		 - ist langsamer als StringBuilder
	 * 	 	 - ist thread-sicher und synchronisiert (Multi-Threaded)
	 * 
	 * StringBuilder
	 * 		- ist schneller als StringBuffer
	 * 		- ist nicht synchronisiert und daher nicht thread-sicher (Single-Threaded)
	 */
	


}
