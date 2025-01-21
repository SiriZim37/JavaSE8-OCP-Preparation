package concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

import concurrency.TestForkJoin.TaskB;

public class TestForkJoin4 {

	
	static class TaskB extends RecursiveTask<String>{
		@Override
		protected String compute() {
			System.out.println("b ");
			return "mo ";
		} 
	}
	
	static class TaskC extends RecursiveTask<String>{
		@Override
		protected String compute() {
			System.out.println("c ");
			return "di ";
		}
	}
	
	static class TaskA extends RecursiveTask<String>{
	
		@Override
		protected String compute() {
			TaskB tb = new TaskB();
			TaskC tc = new TaskC();
			
			/*
			 * Achtung in der Praxis
			 * 
			 * Die Reihenfolge sollte so sein: 
			 * 
			 * tc.fork()	 		<- tc parallel
			 * tb.compute()			<- tb im aktuellen Thread
			 * tc.join()			<- im aktuellen Thread auf tc-Ergebnis warten
			 * 
			 * Der Code , So wie es er hier steht, vernichtet paralleles Ausführen:
			 * tc.fork()			<- tc parallel
			 * tc.join				<- im aktuellen Thread auf tc-Ergebnis warten
			 * tb.compute()   		<- tb im aktuellen Thread
			 */
			tc.fork();		
			return tc.join() + tb.compute()  ;
		}
	}
	

	public static void main(String[] args) {
		
		ForkJoinPool pool = new ForkJoinPool();
		String result = pool.invoke(new TaskA());		
		System.out.println(result);
	}
}
