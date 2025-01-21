package concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class TestForkJoin {

	/*
	 * Was ist das Ergebnis?
	 * 
	 * A. Exception
	 * B. Reihenfolge der Ausgaben ist unvorhersehbar : mo fr oder fr mo
	 * C. mo fr
	 * D. fr
	 * 
	 * 
	 * C ist richtitg
	 */
 
	static class TaskB extends RecursiveTask<String>{
		
		@Override
		protected String compute() {
			System.out.println("mo");
			return "fr";
		}
	}
	public static void main(String[] args) {
		
		ForkJoinPool pool = new ForkJoinPool();
		String result = pool.invoke(new TaskB());		// invoke hält den main Thread an
														// Methode ist Synchronise
		System.out.println(result);
		
	}
}
