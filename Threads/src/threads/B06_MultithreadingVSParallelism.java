package threads;

public class B06_MultithreadingVSParallelism {

	/*
		 1. Thread (เธรด) - หน่วยการทำงานที่เล็กที่สุดในโปรแกรม
		 Thread ใน Java สามารถสร้างได้โดยการสืบทอดจากคลาส Thread หรือการใช้ Runnable interface
		 Thread (konkurrierende) จะช่วยให้โปรแกรมสามารถทำงานหลาย ๆ งานพร้อมกัน (แต่แบ่งเวลาการใช้ CPU) 
		 Thread (nicht unbedingt gleichzeitig ) ใช้สำหรับงานที่เล็กและทำได้เร็ว โดยไม่จำเป็นต้องทำงานพร้อมกันจริง ๆ
		 
		 2. Parallelism (การประมวลผลขนาน) - การทำงานหลายงานพร้อมกันจริง ๆ  (gleichzeitig)
		 การประมวลผลแบบขนาน (Parallelism) ต้องการหลายคอร์ของ CPU เพื่อให้แต่ละงานสามารถทำงานได้พร้อมกัน ( mehrere Prozessorkerne / zur gleichen Zeit )
		 ตัวอย่างการใช้ Parallelism ใน Java  เช่น ForkJoinPool, CompletableFuture, และ parallelStream()
		 เหมาะกับงานที่ต้องการประมวลผลข้อมูลจำนวนมากหรือการคำนวณที่ซับซ้อน (rechenintensive Aufgaben oder große Datenmengen)
	 */
	static class LogikA implements Runnable{
		int a;
		
		@Override
		public void run() {
			a = 12;
		}
	}

	static class LogikB implements Runnable{
		int b;
		
		@Override
		public void run() {
			b = 42;
		}
	}
	public static void main(String[] args) {
	
		LogikA vA = new LogikA();
		LogikB vB = new LogikB();
		
		/* การทำงานแบบ Sequential - ทำงานทีละตัว
		 * Aufgaben sequentiell lösen
		 * 
		 * 		a = 12
		 * 		b = 42
		 */
		vA.run();
		vB.run();
		
		//--------------------------------------------------------------------------------------
		
		/*
		 4. การทำงานด้วย Thread - ทำงานหลาย Thread พร้อมกัน
         ในกรณีที่เครื่องมี CPU เพียงตัวเดียว
         ผลลัพธ์ของการทำงานอาจเหมือนกัน แต่ลำดับการทำงานอาจเปลี่ยนไป
         */
		
		/*
		 * Aufgaben mit Thread lösen
		 * 
		 **** ถ้าเครื่องมี CPU เพียงตัวเดียว การทำงานจะเป็นลำดับทีละขั้นตอน (ไม่สามารถทำงานพร้อมกันได้)
		 * 
		 * Variante 1.
		 * 	- Rechner hat nur eine CPU
		 * 
		 * 		a = 12
		 * 		b = 42
		 * 
		 * Variante 2.
		 * 	- Rechner hat nur eine CPU
		 * 
		 * 		b = 42
		 * 		a = 12
		 * 
		 **** ถ้าเครื่องมี หลาย CPU การทำงานอาจจะเกิดขึ้นพร้อมกันได้จริง ๆ โดยที่แต่ละ Thread สามารถทำงานบน CPU ของตัวเอง
		 * 
		 * Variante 3.
		 * 	- Rechner hat mehrere CPU
		 * 
		 * 		CPU A		CPU B
		 * 		a = 12
		 * 		b = 42
		 * 	
		 * Variante 4.
		 * 	- Rechner hat mehrere CPU
		 * 
		 * 		CPU A		CPU B
		 * 		b = 42
		 * 		a = 12  
		 * 
		 * Variante 5.
		 * 	- Rechner hat mehrere CPUs
		 * 
		 * 		CPU A		CPU B
		 * 		b = 42
		 * 		  			a = 12
		 * 
		 * Variante 6.
		 * 	- Rechner hat mehrere CPUs
		 * 
		 * 		CPU A		CPU B
		 * 		a = 12
		 * 		  			b = 42	
		 * 
		 * Variante 7.					<- wirklich parallel การทำงานบนหลาย CPU จะเป็น parallel execution 
		 * 	- Rechner hat mehrere CPUs
		 * 
		 * 		CPU A		CPU B
		 * 		a = 12		b = 42       CPU A และ b = 42 จะถูกประมวลผลบน CPU B ในเวลาเดียวกัน 
		 * 								 ซึ่งทำให้โปรแกรมสามารถประมวลผลทั้งสองอย่างในเวลาเดียวกันจริง ๆ (parallelism)
		 * 		  				
		 */	
		new Thread(vA).run();		// Thread 1
		new Thread(vB).run();		// Thread 1
		
		
		/*
		 Thread:
			- Thread คือหน่วยการทำงานที่เล็กที่สุดของโปรแกรม ซึ่งจะทำงานทีละขั้นตอนและแบ่งการใช้งาน CPU กับ Thread อื่น ๆ ในโปรแกรมเดียวกัน
			- Thread เหมาะกับงานเล็ก ๆ ที่สามารถทำงานได้เร็ว และไม่จำเป็นต้องทำงานพร้อมกันจริง ๆ
			- ในตัวอย่าง vA.run() และ vB.run() จะทำงานทีละตัวแบบ Sequential (ตามลำดับ) โดยไม่ใช้หลาย Thread
		 Parallelism (การทำงานพร้อมกัน):	
		 	- Parallelism คือการทำงานหลาย ๆ งานพร้อมกันจริง ๆ โดยการใช้หลาย CPU คอร์ เพื่อให้ทุกงานสามารถทำงานพร้อมกันได้
			  ในตัวอย่าง new Thread(vA).run() และ new Thread(vB).run() จะเป็นการสร้าง Thread ใหม่ 
			  แต่ไม่การทำงานแบบ Parallel จริง ๆ เนื่องจากเราใช้ .run() แทนการใช้ .start() ที่ทำให้ Thread ทำงานจริง ๆ
		 */
	}
}
