package ocpexam;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveAction;


public class ForkJoinPoolRecursiveActionWithSubmit {


    static class MyTask extends RecursiveAction {
        private static final int THRESHOLD = 5;  // Threshold to stop splitting the task
        private int start;
        private int end;

        MyTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            if (end - start <= THRESHOLD) {
                // Base case: perform the task directly
                for (int i = start; i <= end; i++) {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                }
            } else {
                // Recursive case: split the task into smaller tasks
                int middle = (start + end) / 2;
                MyTask task1 = new MyTask(start, middle);  // Create task1
                MyTask task2 = new MyTask(middle + 1, end);  // Create task2

                task1.fork();  // Fork task1 to execute asynchronously
                task2.fork();  // Fork task2 to execute asynchronously
                task1.join();  // Wait for task1 to finish
                task2.join();  // Wait for task2 to finish
            }
        }
    }

    public static void main(String[] args) throws Exception {
        ForkJoinPool forkJoinPool = new ForkJoinPool();  

        MyTask task = new MyTask(1, 20);

        Future<?> future = forkJoinPool.submit(task); 

        future.get();
    }
	  
}
