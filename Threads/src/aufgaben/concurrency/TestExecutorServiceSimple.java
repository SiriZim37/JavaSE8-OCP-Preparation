package aufgaben.concurrency;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.DoubleSupplier;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class TestExecutorServiceSimple {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		test_A1();
		test_A2();
		
		test_A3v1();
		test_A3v2();
	}
	
	static void test_A3v2() throws InterruptedException, ExecutionException {
		System.out.println("***A3v2 : Executor mit Callable");
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		
		Callable<Integer> task = () -> {
			return  ThreadLocalRandom.current().nextInt(); 
//			return 1;
		};
		
		List<Future<Integer>> futures = 
				Stream.generate( () -> service.submit(task) )		// Stream<Future<Integer>>
				.limit(10)
				.collect(Collectors.toList());
		
//		futures.stream()	
//				.map(Future::get)		// cf : deklariert checked Exceptions
		
		
		int summe = 0;		
		for (Future<Integer> f : futures) {
		   summe = f.get();
		}
		System.out.println("summe: "+ summe);
	}
	
	static void test_A3v1() throws InterruptedException, ExecutionException {
		System.out.println("***A3v1 : Executor mit Callable");
		
		ExecutorService service = Executors.newFixedThreadPool(10);
		
		Callable<Integer> task = () -> {
			return  ThreadLocalRandom.current().nextInt(); 
//			return 1;
		};
		
		 Collection<Callable<Integer>> tasks = 
			        Stream.generate(() -> task) // Stream<Callable<Integer>>
			        .limit(10)
			        .collect(Collectors.toList()); // Collect into a List


		List<Future<Integer>> futures = service.invokeAll(tasks);

		int summe = 0;	
		for (Future<Integer> f : futures) {
//			System.out.println(f.isDone() + " " + f.get());
			summe += f.get();
		}
		System.out.println("summe: "+ summe);
	}
	
	static void test_A2() {
		System.out.println("***A2 : Executor mit Callable");
		
		ExecutorService service = Executors.newCachedThreadPool();
		
		Double result = 0.0;
	
		Callable<Double> task = () -> {
			double sum = ThreadLocalRandom.current()
							.doubles(10)					// DoubleStream mit limit 10 
							.sum();
			return sum;
		};
		
		Future<Double> future =  service.submit(task);
		try {
			result = future.get();
			System.out.println("Summe : " + result);
		} catch (InterruptedException|ExecutionException e) {
			e.printStackTrace();
		}
		
		service.shutdown();
	}
		
		
	static void test_A1() {
		System.out.println("***A1 : Executor mit Runnable");
		
		ExecutorService service = Executors.newCachedThreadPool();
			
		Runnable taskRunnable  = ()->{
			System.out.println("task A1 Start ");
			
//			DoubleStream.generate(ThreadLocalRandom.current().nextDouble(10))
//					.limit(10); // ThreadLocalRandom here
//					 .forEach(System.out::println);        
	        // oder 
	        
			ThreadLocalRandom rand = ThreadLocalRandom.current();			
			DoubleSupplier supp =  new Random()::nextDouble;  // oder () -> rand.nextDouble(); 
			DoubleStream.generate(supp).limit(10).forEach(System.out::println);
			

			
			System.out.println("task A1 End ");
		};
		
		service.execute(taskRunnable);
		
		service.shutdown();

		
	}
}
