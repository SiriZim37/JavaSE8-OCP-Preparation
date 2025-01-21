package concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class TestRecursiveTask {

    static class SumTask extends RecursiveTask<Integer> {
        private final int[] numbers;
        private final int start, end;

        private static final int THRESHOLD = 10; // ขนาดขั้นต่ำที่จะแบ่งงาน

        public SumTask(int[] numbers, int start, int end) {
            this.numbers = numbers;
            this.start = start;
            this.end = end; 
        }

        @Override
        protected Integer compute() {
            if (end - start <= THRESHOLD) {
                // ถ้างานเล็กพอ คำนวณตรง ๆ
                int sum = 0;
                for (int i = start; i < end; i++) {
                    sum += numbers[i];
                }
                return sum;
            } else {
                // ถ้างานใหญ่เกินไป ให้แบ่งงาน
                int mid = (start + end) / 2;
                SumTask leftTask = new SumTask(numbers, start, mid);
                SumTask rightTask = new SumTask(numbers, mid, end);

                leftTask.fork(); // Fork งานซ้าย
                int rightResult = rightTask.compute(); // ประมวลผลงานขวา
                int leftResult = leftTask.join(); // รอผลลัพธ์จากงานซ้าย

                return leftResult + rightResult; // รวมผลลัพธ์
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = new int[100];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1; // ใส่ค่า 1 ถึง 100
        }

        ForkJoinPool pool = new ForkJoinPool();
        SumTask task = new SumTask(numbers, 0, numbers.length);

        int result = pool.invoke(task); // เรียกใช้งาน ForkJoinPool
        System.out.println("Sum: " + result);
    }
}