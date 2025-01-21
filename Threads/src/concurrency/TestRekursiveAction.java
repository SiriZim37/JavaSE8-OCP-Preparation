package concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
 
public class TestRekursiveAction {
	
	static class SumTask extends RecursiveAction {
        private static final int THRESHOLD = 10; // Threshold for splitting tasks
        private int[] numbers;
        private int start, end;
        private long result; // The computed sum for this task

        public SumTask(int[] numbers, int start, int end) {
            this.numbers = numbers;
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            if (end - start <= THRESHOLD) {
                // If the task is small enough, compute directly
                for (int i = start; i < end; i++) {
                    result += numbers[i];
                }
            } else {
                // Split the task into two smaller tasks
                int middle = (start + end) / 2;
                SumTask leftTask = new SumTask(numbers, start, middle);
                SumTask rightTask = new SumTask(numbers, middle, end);

                // Fork the subtasks
                leftTask.fork();
                rightTask.compute(); // Compute the right task directly
                leftTask.join(); // Wait for the left task to complete

                // Combine results
                result = leftTask.result + rightTask.result;
            }
        }

        public long getResult() {
            return result;
        }
    }

    public static void main(String[] args) {
        // Create an array to sum
        int[] numbers = new int[100];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1; // Fill with 1 to 100
        }

        // Create a ForkJoinPool
        ForkJoinPool pool = new ForkJoinPool();

        // Create and invoke the root task
        SumTask task = new SumTask(numbers, 0, numbers.length);
        pool.invoke(task);

        // Print the result
        System.out.println("Sum: " + task.getResult());
    }
}