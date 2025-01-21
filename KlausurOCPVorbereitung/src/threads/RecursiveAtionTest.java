package threads;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

class Sum extends RecursiveAction   {                 //line n1
    static final int THRESHOLD_SIZE  = 3;
    int stIndex, lstIndex;
    int [ ] data;
    public Sum (int [ ]data, int start, int end)   {
        this.data = data;
        this.stIndex = start;
        this.lstIndex = end;
    }
    protected void compute ( )    {
        int sum = 0;
        if (lstIndex - stIndex <= THRESHOLD_SIZE) {
            for (int i = stIndex; i < lstIndex; i++) {
                sum += data[i];
            }
            System.out.println(sum);
        } else {
            new Sum (data, stIndex + THRESHOLD_SIZE, lstIndex).fork( );
            new Sum (data, stIndex,
                    Math.min  (lstIndex, stIndex + THRESHOLD_SIZE)
                    ).compute ();
        }
    }
 }


public class RecursiveAtionTest {

	public static void main(String[] args) {
		ForkJoinPool fjPool = new ForkJoinPool ( );
		 int data [ ] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		 fjPool.invoke (new Sum (data, 0, data.length));
	}
	
	/*
	 *  and given that the sum of all integers from 1 to 10 is 55.
		 Which statement is true?
		 A. The program prints several values that total 55
	 */
}

class Sum2 extends RecursiveAction {
    static final int THRESHOLD_SIZE = 3;
    int stIndex, lstIndex;
    int[] data;

    public Sum2(int[] data, int start, int end) {
        this.data = data;
        this.stIndex = start;
        this.lstIndex = end;
    }

    protected void compute() {
        int sum = 0;
        if (lstIndex - stIndex <= THRESHOLD_SIZE) {
            for (int i = stIndex; i < lstIndex; i++) {
                sum += data[i];
            }
            System.out.println(sum);
        } else {
            // Forking two tasks for parallel execution
            Sum task1 = new Sum(data, stIndex, Math.min(lstIndex, stIndex + THRESHOLD_SIZE));
            Sum task2 = new Sum(data, stIndex + THRESHOLD_SIZE, lstIndex);
            task1.fork();
            task2.fork();
            
            // Wait for both tasks to complete
            task1.join();
            task2.join();
        }
    }
}
