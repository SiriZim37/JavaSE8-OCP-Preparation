package threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadsRunnableVsCallable {

	/*
	 * Runnable Interface
		อยู่ในแพ็กเกจ java.lang
		ใช้สำหรับสร้างงานที่จะทำงานบน Thread
		ไม่คืนค่าใดๆ และ ไม่สามารถโยน checked exceptions ได้
		ใช้ร่วมกับคลาส Thread หรือ ExecutorService
	 

		@FunctionalInterface
		public interface Runnable {
		    void run(); // ไม่มีการคืนค่า
		}
	
	
	
	  Callable Interface
		อยู่ในแพ็กเกจ java.util.concurrent
		คล้ายกับ Runnable แต่ สามารถคืนค่าได้ และ โยน checked exceptions ได้
		ใช้ร่วมกับ ExecutorService และ Future
		
		@FunctionalInterface
		public interface Callable<V> {
	    	V call() throws Exception; // คืนค่าประเภท V และโยน Exception ได้
		}
	 */

	
	
	public static void main(String[] args) {
		
			Runnable task1 = () -> System.out.println("Runnable Task กำลังทำงาน...");
	        
	        Thread thread = new Thread(task1);
	        thread.start();

	
	        //------------------------------------------------------------------
	        
	        Callable<Integer> task = () -> {
	            System.out.println("Callable Task กำลังทำงาน...");
	            return 42; // คืนค่า 42
	        };

	        ExecutorService executor = Executors.newSingleThreadExecutor();
	        Future<Integer> result = executor.submit(task);

	        try {
	            System.out.println("ผลลัพธ์: " + result.get()); // รับค่าที่ Callable คืนมา
	        } catch (InterruptedException | ExecutionException e) {
	            e.printStackTrace();
	        } finally {
	            executor.shutdown();
	        }
	
	}

}
