package ocpexam;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ForkJoinPoolRecursiveActionWithExcute {



	static class MyTask extends RecursiveAction {
	    private static final int THRESHOLD = 5;
	    private int start;
	    private int end;
	
	    MyTask(int start, int end) {
	        this.start = start;
	        this.end = end;
	    }
	
	    @Override
	    protected void compute() {
	        if (end - start <= THRESHOLD) {
	            for (int i = start; i <= end; i++) {
	                System.out.println(Thread.currentThread().getName() + ": " + i);
	            }
	        } else {
	            int middle = (start + end) / 2;
	            MyTask task1 = new MyTask(start, middle);
	            MyTask task2 = new MyTask(middle + 1, end);
	            task1.fork(); // Fork task1 to be processed in parallel
	            task2.fork(); // Fork task2 to be processed in parallel
	            task1.join(); // Wait for task1 to complete
	            task2.join(); // Wait for task2 to complete
	        }
	    }
	}

	  public static void main(String[] args) {
	        ForkJoinPool forkJoinPool = new ForkJoinPool();
	        MyTask task = new MyTask(1, 20);
	        forkJoinPool.execute(task);
	    }
	  
	   
	  
	  /*
	   
	   You can't use fork() and join() together as you're showing in this example:
	   
		MyTask task1 = new MyTask(start, middle).fork();
		MyTask task2 = new MyTask(middle + 1, end).join();
		
	   */
}
