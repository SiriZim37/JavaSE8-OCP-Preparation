package ocpexam;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CyClicWithThreadAtomic {

	public static void main(String[] args) throws InterruptedException {
	
			AtomicInteger atomicValue = new AtomicInteger(0);
	        int numThreads = 4;
	        
	        CyclicBarrier barrier = new CyclicBarrier(numThreads, 
	            () -> System.out.println("All threads are at the barrier, value: " + atomicValue.get()));

	        Runnable task = () -> {
	            for (int i = 0; i < 5; i++) {
	                atomicValue.incrementAndGet();
	                System.out.println(Thread.currentThread().getName() + " incremented value to " + atomicValue.get());
	            }

	            try {
	                barrier.await();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        };

	        // Create and start 4 threads
	        Thread thread1 = new Thread(task);
	        Thread thread2 = new Thread(task);
	        Thread thread3 = new Thread(task);
	        Thread thread4 = new Thread(task);

	        thread1.start();
	        thread2.start();
	        thread3.start();
	        thread4.start();

	        // Wait for all threads to finish
	        thread1.join();
	        thread2.join();
	        thread3.join();
	        thread4.join();


		
	}
}

