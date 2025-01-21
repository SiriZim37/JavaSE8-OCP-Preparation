package concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class TestSubmit {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService service = Executors.newFixedThreadPool(4);
		 
		/*
		 *  void execute(Runnable command);
		 *  
		 * เมธอด execute() ใช้สำหรับส่งงานที่เป็นประเภท Runnable ที่ไม่คืนค่า
		 * 
         * เมธอดนี้จะรับพารามิเตอร์เป็นคำสั่งที่ต้องการให้ทำงาน (Runnable) และ
         * ทำงานใน Thread ที่จัดเตรียมไว้ใน ExecutorService โดยไม่สนใจว่าจะมีผลลัพธ์อะไรคืนมา
		 */
		Runnable task1 = ()-> System.out.println("task 1 ");
		service.execute(task1);
		
		
		//------------------------------------------------------------------------------------------------//
		/*
		 * <T> Future<T> submit(Callable<T> task);
		 * 
		 * เมธอด submit(Callable<T>) ใช้สำหรับส่งงานที่ต้องการผลลัพธ์ (ที่สามารถคืนค่าได้)
         * และสามารถโยนข้อผิดพลาด (Exception) ได้ด้วย
         * เมธอดนี้จะรับงานที่เป็นประเภท Callable ซึ่งสามารถคำนวณและคืนค่าผลลัพธ์ได้
		 */
		Callable<Integer> task2 = ()->{
			System.out.println("task 2");
			int summe = 0 ;
			for (int i = 1; i < 100; i++) {
				summe+=i;
			}
			return summe;
		};
		
		Future<Integer> future2 = service.submit(task2);
		
		try {
			System.out.println("Ergebnisse aus task 2: " + future2.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		
		//------------------------------------------------------------------------------------------------//
		/*
		 *   Future<?> submit(Runnable task);
		 *   
		 * เมธอด submit(Runnable) ใช้สำหรับส่งงานที่เป็นประเภท Runnable ที่ไม่คืนค่า
         * เมธอดนี้จะรับงานประเภท Runnable และไม่คำนึงถึงผลลัพธ์ของงานที่ทำ
         * โดยจะคืนค่าเป็น Future<?> ซึ่งหมายถึงว่าจะสามารถรอให้การทำงานเสร็จสิ้นได้
		 */
		
		StringBuilder targetForTask3 = new StringBuilder();
		
		Runnable task3 = ()->{
			System.out.println("task 3");
			
			String s = "";
			for (char i = 'a'; i < 'z'; i++) {
				targetForTask3.append(i);
			}
			
		};
		Future<?> future3 = service.submit(task3);
		try {
			future3.get(); // warten bis task3 fertig ist
		} catch (InterruptedException |  ExecutionException e) {
			e.printStackTrace();
		} 		
		System.out.println("main. task3 hat das Ergebnis im StringBuilder gespeichert:\n> " 
							+ targetForTask3  );
		
		
		//------------------------------------------------------------------------------------------------//
		
		/*
		 *   <T> Future<T> submit(Runnable task, T result);
		 *   
		 * เมธอด submit(Runnable, T) ใช้สำหรับส่งงานประเภท Runnable และกำหนดผลลัพธ์ที่ต้องการคืนกลับ
         * เมธอดนี้จะรับงานประเภท Runnable และผลลัพธ์ที่ต้องการคืนค่าในกรณีที่งานเสร็จสิ้น
         * ซึ่งจะคืนค่าผลลัพธ์นั้นผ่าน Future<T>
		 */
		StringBuilder targetForTask4 = new StringBuilder();
		
		Runnable task4 = ()->{
			System.out.println("task 3");
			
			String s = "";
			for (char i = 'A'; i < 'Z'; i++) {
				targetForTask4.append(i);
			}
			
		};
		Future<StringBuilder> future4 = service.submit(task4 , targetForTask4);
		
		System.out.println("main. Ergebnis aus task4: " + future4.get());
		
		service.shutdown();
	}
}
