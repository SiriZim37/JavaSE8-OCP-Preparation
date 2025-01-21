package aufgaben.blocking;

import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadsBlockingPermutaionA2 {

    public static void main(String[] args) {
        char[] array = { 'a', 'b', 'c' };

        int queueCapacity = 6; 
        ArrayBlockingQueue<char[]> queue = new ArrayBlockingQueue<>(queueCapacity);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Runnable producerTask = () -> {
            try {
                permutate(array, array.length, queue);     
                queue.put(new char[0]); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        Runnable consumerTask = () -> {
            try {
                while (true) {
                    char[] permutation = queue.take();
                    if (permutation.length == 0) break;
                    System.out.printf("%s %n", Arrays.toString(permutation));
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };


        executor.execute(producerTask);
        executor.execute(consumerTask);

        executor.shutdown();
    }


    public static void permutate(char[] arr, int pointer, BlockingQueue<char[]> queue) throws InterruptedException {
        if (pointer == 1) {
            queue.put(arr.clone());
            return;
        }

        for (int i = 0; i < pointer - 1; i++) {
            permutate(arr, pointer - 1, queue);

            if (pointer % 2 == 0) {
                char tmp = arr[pointer - 1];
                arr[pointer - 1] = arr[i];
                arr[i] = tmp;
            } else {
                char tmp = arr[pointer - 1];
                arr[pointer - 1] = arr[0];
                arr[0] = tmp;
            }
        }

        permutate(arr, pointer - 1, queue);
    }
}