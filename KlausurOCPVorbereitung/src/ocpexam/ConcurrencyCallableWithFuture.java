package ocpexam;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ConcurrencyCallableWithFuture {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		
		ExecutorService executorService = Executors.newFixedThreadPool(2);

        Callable<Void> callableTask = () -> {
            System.out.println("Executing task");
            return null;  // Returning null instead of void
        };

        Future<Void> future = executorService.submit(callableTask);  // Submit callable to executor

        // Wait for the task to finish
        future.get();  // This blocks until the task completes

        System.out.println("Task completed!");

        executorService.shutdown();
	        
	}
}
