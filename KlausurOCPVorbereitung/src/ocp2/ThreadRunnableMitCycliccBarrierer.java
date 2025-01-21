package ocp2;

import java.util.concurrent.CyclicBarrier;


/*
		  QUESTION 57
		 Given:
		 class Worker extends Thread  {
		    CyclicBarrier cb;
		    public Worker(CyclicBarrier cb) { this.cb = cb; }
		    public void run ()  {
		        try  {
		            cb.await();
		            System.out.println(“Worker…”);
		        } catch (Exception ex)  {  }
		    }
		 }
		 class Master implements Runnable {   //line n1
		    public void run ()   {
		        System.out.println(“Master…”);
		    }
		 }
		
		 and the code fragment:
		 Master master = new Master();
		 //line n2
		 Worker worker = new Worker(cb);
		 worker.start();
		 You have been asked to ensure that the run methods of both the Worker and Master classes are executed.
		 Which modification meets the requirement?
		 A. At line n2, insert CyclicBarrier cb = new CyclicBarrier(2, master);
		 B. Replace line n1 with class Master extends Thread {
		 C. At line n2, insert CyclicBarrier cb = new CyclicBarrier(1, master);
		 D. At line n2, insert CyclicBarrier cb = new CyclicBarrier(master);
 
 */
class Worker extends Thread {
    CyclicBarrier cb;

    public Worker(CyclicBarrier cb) {
        this.cb = cb;
    }

    public void run() {
        try {
            cb.await();  // Wait for the other thread to reach the barrier
            System.out.println("Worker...");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

class Master implements Runnable {
    public void run() {
        System.out.println("Master...");
    }
}


public class ThreadRunnableMitCycliccBarrierer {


	public static void main(String[] args) {
			Master master = new Master();
	        CyclicBarrier cb = new CyclicBarrier(2,  master);

	        Worker worker = new Worker(cb);
	        worker.start();

	        try {
	            cb.await();  // Main thread waits at the barrier for Worker to reach it
	            System.out.println("Main thread reached the barrier...");
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	}
	
	/*
	 
	 ในคำถามนี้ เราต้องการให้เมธอด run() ของทั้งคลาส Worker และคลาส Master ถูกเรียกใช้ เรามาดูคำอธิบายของแต่ละตัวเลือกกัน:

	คำอธิบายของคำตอบ C:
	C. ที่บรรทัด n2, ใส่ CyclicBarrier cb = new CyclicBarrier(1, master);
	
	การใช้งาน CyclicBarrier: CyclicBarrier เป็นเครื่องมือที่ใช้ในการซิงโครไนซ์การทำงานของหลายเธรด 
	โดยจะรอให้เธรดทั้งหมดที่มาถึง barrier เดียวกันเสร็จสิ้นก่อนที่จะดำเนินการต่อไป
	
	จำนวนเธรดที่ต้องรอ (2 หรือ 1?): ในกรณีนี้ เรากำหนดให้ CyclicBarrier รอแค่ 1 เธรด (CyclicBarrier(1, master)) 
	ซึ่งหมายความว่าเธรดหนึ่ง (คือ worker) จะต้องมาถึง barrier ก่อน จากนั้น master.run() จะถูกเรียกหลังจากที่ worker ถึง barrier 
	และทำให้ master ทำงานตามที่ต้องการ
	
	ทำไมคำตอบ C ถึงถูกต้อง:
	
	เมื่อ worker เธรดมาถึง barrier (ผ่านการเรียก cb.await() ใน worker.run()), มันจะทำให้ master.run() ถูกเรียกในตอนนั้นเลย
	นี่คือการใช้ CyclicBarrier เพื่อล็อคการทำงานร่วมกันของทั้งสองเธรด โดยที่ worker รอให้ master ทำงาน
	ตัว CyclicBarrier(1, master) จะบังคับให้ master ถูกเรียกในขณะที่ worker ถึง barrier
	ข้อผิดพลาดในตัวเลือกอื่นๆ:
	
	A. At line n2, insert CyclicBarrier(2, master): CyclicBarrier(2, master)
	 หมายความว่าจะต้องมีสองเธรดที่มาถึง barrier ก่อนที่ master.run() จะถูกเรียก แต่ในกรณีนี้เรามีแค่ worker เท่านั้น 
	 ดังนั้นเธรดที่สองไม่สามารถมาได้ ทำให้ไม่ตรงกับความต้องการในคำถาม
	
	B. Replace line n1 with class Master extends Thread: การทำให้ Master เป็น Thread ไม่จำเป็นในที่นี้
	 เพราะ Master สามารถเป็น Runnable ได้อยู่แล้ว การใช้ Runnable เป็นการออกแบบที่ถูกต้องและไม่จำเป็นต้องเปลี่ยนเป็น Thread
	
	D. At line n2, insert CyclicBarrier(master): การใช้ CyclicBarrier(master) 
	จะทำให้เกิดข้อผิดพลาดในการคอมไพล์เนื่องจากคอนสตรัคเตอร์ของ CyclicBarrier ต้องการจำนวนเธรดที่ต้องรอและไม่สามารถใช้ master เป็นอาร์กิวเมนต์ได้ในรูปแบบนี้
	
	สรุป:
	การใช้ CyclicBarrier(1, master) ในตัวเลือก C ช่วยให้เมื่อ worker เธรดมาถึง barrier มันจะทำให้ master.run() ถูกเรียกตามที่ต้องการ ซึ่งทำให้ทั้ง Worker และ Master ทำงานร่วมกันได้ตามที่คำถามต้องการ

	 */
}
