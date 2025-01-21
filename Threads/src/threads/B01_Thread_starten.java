package threads;

public class B01_Thread_starten {

	
	public static void main(String[] args) {
		
		
		/*
		 * Einen neuen Thread (Zustand: NEW) reservieren.
		 * การสร้าง Object ของคลาส Thread ขึ้นมา ซึ่งในขั้นตอนนี้เธรดจะอยู่ในสถานะ NEW หมายถึงมันยังไม่ได้เริ่มทำงานหรือถูกเรียกใช้งาน
		 */
		
		Thread th =	new Thread();
		
		/*
		 * Den Thread beim Schedular als Runable registieren.
		 * 
		 * เมื่อเรียกใช้ start() บนตัวแปร th (ที่เป็นอ็อบเจ็กต์ของคลาส Thread) เธรดนี้จะถูกลงทะเบียนกับ 
		 * ตัวจัดการเธรด (Scheduler) ซึ่งจะทำให้มันเปลี่ยนสถานะเป็น Runnable และพร้อมที่จะเริ่มทำงาน 
		 * (จะได้รับการจัดการและดำเนินการตามลำดับการทำงานที่จัดสรรให้จากตัวจัดการเธรด)
		 */
		th.start();
		/*
		 * Wenn der Schedular den extra-Thread in den Zustand RUNNABLE 
		 * versetzt , wird die Methode run() in diesem Thread ausgeführt : 
		 * 
		 * public void run(){
		 * 		 Runnable task = hier die Task suchen...
		 * 		 if (task != null) {
		 * 		  	hier die Task aktivieren
		 *       }
		 * }
		 */
		
		System.out.println("main");
	}
}
