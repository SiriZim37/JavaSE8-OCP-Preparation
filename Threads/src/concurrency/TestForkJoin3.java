package concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

import concurrency.TestForkJoin.TaskB;

public class TestForkJoin3 {

	
	static class TaskB extends RecursiveTask<String>{
		@Override
		protected String compute() {
			return "mo";
		}
	}
	
	static class TaskC extends RecursiveTask<String>{
		@Override
		protected String compute() {
			return "di";
		}
	} 
	
	static class TaskA extends RecursiveTask<String>{
	
		@Override
		protected String compute() {
			TaskB tb = new TaskB();
			TaskC tc = new TaskC();
			tc.fork();		
			return tb.compute() + tc.join();
		}
	}
	

	/*
	 * Was ist das Ergebnis?
	 * 
	 * A. mo di ODER di mo
	 * B. mo di
	 * C. di mo
	 * D. Exception
	 * 
	 * 
	 * B	<- richtig
	 */
	public static void main(String[] args) {
		
		ForkJoinPool pool = new ForkJoinPool();
		String result = pool.invoke(new TaskA());		
		System.out.println(result);
	}
}
