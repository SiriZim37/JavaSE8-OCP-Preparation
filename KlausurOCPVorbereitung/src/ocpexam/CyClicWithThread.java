package ocpexam;

import java.util.concurrent.*;

public class CyClicWithThread {

	public static void main(String[] args) {
		
		CyclicBarrier barrier = new CyclicBarrier(2, () -> System.out.println("X"));

        Runnable task = () -> {
            try {
                barrier.await();  
                System.out.println(" X");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        };

        // Create 4 threads
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(task);
        Thread thread4 = new Thread(task);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();


		
	}
}

