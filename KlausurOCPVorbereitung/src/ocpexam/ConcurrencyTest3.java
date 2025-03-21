package ocpexam;

import java.util.concurrent.Callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;




class ConcurrencyTest3 extends RecursiveAction { // line n1

	static final int THRESHOLD_SIZE = 3;
	int stIndex, lstIndex;
	int[] data;

	public ConcurrencyTest3(int[] data, int start, int end) {
		this.data = data;
		this.stIndex = start;
		this.lstIndex = end;
	}

	@Override
	protected void compute() {
		int sum = 0;
		if (lstIndex - stIndex <= THRESHOLD_SIZE) {
			for (int i = stIndex; i < lstIndex; i++) {
				sum += data[i];
			}
			System.out.println(sum);
		} else {
			new ConcurrencyTest3(data, stIndex + THRESHOLD_SIZE, lstIndex).fork();
			new ConcurrencyTest3(data, stIndex, Math.min(lstIndex, stIndex + THRESHOLD_SIZE)).compute();
		}
	}

	public static void main(String args[]) {
		ForkJoinPool fjPool = new ForkJoinPool();
		int data[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		fjPool.invoke(new ConcurrencyTest3(data, 0, data.length));
	}
}


	/*				
	Given:
	class Sum extends RecursiveAction { //line n1
		static final int THRESHOLD_SIZE = 3;
		int stIndex, lstIndex;
		int [ ] data;
		
		public Sum (int []data , int start, int end) {
			this.data = data;
			this stIndex = start;
			this. lstIndex = end;
		}
	
		protected void compute ( ) {
			int sum = 0;
			if (lstIndex – stIndex <= THRESHOLD_SIZE) {
				for (int i = stIndex; i < lstIndex; i++) {
					sum += data [i];
				}
				System.out.println(sum);
			}else{
				new Sum (data, stIndex + THRESHOLD_SIZE, lstIndex).fork( );
				new Sum (data, stIndex,
				Math.min (lstIndex, stIndex + THRESHOLD_SIZE)).compute ();
			}
		}
	}
	
	and the code fragment:
	
	ForkJoinPool fjPool = new ForkJoinPool ();
	int data [ ] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
	fjPool.invoke (new Sum (data, 0, data.length));
	
	and given that the sum of all integers from 1 to 10 is 55.
	
	Which statement is true?
	
	A. The program prints several values that total 55.
	B. The program prints 55.
	C. A compilation error occurs at line n1.
	D. The program prints several values whose sum exceeds 55.
	
	Answer: A
	
	Basic Use
	
	The first step for using the fork/join framework is to write code that performs a segment of the work. Your code should look similar to the following pseudocode:
	
	if (my portion of the work is small enough)
	  	do the work directly
	else
		split problem into independent parts
		fork new subtasks to solve each part
		join all subtasks		
		compose result from subresults
		
	see MyRecursiveAction and MyRecursiveTask	
		
	

	 */
	
	