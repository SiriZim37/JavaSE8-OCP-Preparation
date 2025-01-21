package aufgaben.concurrency;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

import words.Words;

public class TestExecutorServiceEnglishWords {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		List<String> list = Words.germanWords();
		
		test_A123(list);
		
		/*
		 * Ergebnis : 6832 : die Anzahl der Wörter ermittelt, die die Länge 5 haben.
		 */
		test_A5( list);
	
		
		/*
		 * Ergebnis : 6832 : die Anzahl der Wörter ermittelt, die die Länge 5 haben.
		 */
		test_A6v2(list);
		
//		long startTime = System.currentTimeMillis();
//		test_A6(list);
//		long endTime = System.currentTimeMillis();
//		 System.out.println("A6 newFixedThreadPool: " + (endTime - startTime) + " ms");
//		
//		 
//		startTime = System.currentTimeMillis();
//		test_A7(list);
//		endTime = System.currentTimeMillis();
//		System.out.println("A7 (newCachedThreadPool: " + (endTime - startTime) + " ms");
					
		
	}// end of main

	static void test_A7(List<String> list) throws InterruptedException, ExecutionException {
		System.out.println("\n***A7");
		
		ExecutorService service = Executors.newCachedThreadPool();
		
		int taskCount = 50; 
		int subTaskSize = list.size() / taskCount; // Teile die Liste in 50 Teile
		
		Collection<Callable<Long>> tasks = new ArrayList();
		
		for (int i = 0; i < taskCount; i++) {
			int startIndex = i * subTaskSize;
			int endIndex   = (i == taskCount -1 )? list.size() : (i+1)* subTaskSize;
			
//			System.out.println("startIndex: " + startIndex +": endIndex: " + endIndex 
//								 + " , " + Thread.currentThread().getName() );
			
			List<String> subList = list.subList(startIndex, endIndex);
			
			Callable<Long> task = () -> subList.stream()
												.filter(word -> word.length() == 5)
												.count();
			tasks.add(task); 
	    }
		
		List<Future<Long>> futures = service.invokeAll(tasks);
		
		long anzahl = 0 ;
		for (Future<Long> f : futures) {
			anzahl += f.get();
		}
		System.out.println("Anzahl der Wörter mit lenght 5: " + anzahl);
			
		try {
			service.awaitTermination(2000, TimeUnit.MILLISECONDS);
			System.out.println("main A7 nach awaitTermination"); 			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}

	static void test_A6(List<String> list) throws InterruptedException, ExecutionException {
		System.out.println("\n***A6");
		
		ExecutorService service = Executors.newFixedThreadPool(5);
		
		int taskCount = 50; 
		int subTaskSize = list.size() / taskCount; // Teile die Liste in 50 Teile
		
		Collection<Callable<Long>> tasks = new ArrayList();
		
		for (int i = 0; i < taskCount; i++) {
			int startIndex = i * subTaskSize;
			int endIndex   = (i == taskCount -1 )? list.size() : (i+1)* subTaskSize;
			
//			System.out.println("startIndex: " + startIndex +": endIndex: " + endIndex 
//								 + " , " + Thread.currentThread().getName());
			
			List<String> subList = list.subList(startIndex, endIndex);
			
			Callable<Long> task = () -> subList.stream()
												.filter(word -> word.length() == 5)
												.count();
			tasks.add(task); 
	    }
		
		List<Future<Long>> futures = service.invokeAll(tasks);
		
		long anzahl = 0 ;
		for (Future<Long> f : futures) {
			anzahl += f.get();
		}
		System.out.println("Anzahl der Wörter mit lenght 5: " + anzahl);
			
		try {
			service.awaitTermination(2000, TimeUnit.MILLISECONDS);
			System.out.println("main A6 nach awaitTermination"); 			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	static void test_A6v2(List<String> list) throws InterruptedException, ExecutionException {
		System.out.println("\n***A6");
		
	
		
		int taskCount = 50; 
		int subTaskSize = list.size() / taskCount; // Teile die Liste in 50 Teile
		System.out.println("word.size(): " + list.size());
		
		Collection<Callable<Long>> tasks = new ArrayList();
		
		/*
		 * Task mit SubList erzeugen
		 */
		for (int indexFrom = 0 , count = 0;  indexFrom < list.size() ; indexFrom += subTaskSize) {
			int indexTo = indexFrom + subTaskSize;
			if(indexTo > list.size()) {
				indexTo = list.size();
			}
			
//			System.out.printf("%02d.from: %d to %d %n" , count++ , indexFrom , indexTo);
			
			List<String> subList = list.subList(indexFrom, indexTo);
			
			Callable<Long> task = () -> subList.stream()
												.filter(word -> word.length() == 5)
												.count();
			tasks.add(task); 
			
		}

		/*
		 * Tasks parallel starten
		 */
		ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		
		List<Future<Long>> futures = service.invokeAll(tasks);
		
		long anzahl = 0 ;
		for (Future<Long> f : futures) {
			anzahl += f.get();
		}
		System.out.println("Anzahl der Wörter mit lenght 5: " + anzahl);
			
		try {
			service.awaitTermination(2000, TimeUnit.MILLISECONDS);
			System.out.println("main A6 nach awaitTermination"); 			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	static void test_A5(List<String> list) throws InterruptedException, ExecutionException {
		System.out.println("\n***A5");
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		
		Callable<Long> task = () -> {
			return list.stream().filter(word -> word.length()== 5).count();
		};
		
		Future<Long> future =  service.submit(task);
		long result = future.get();
		System.out.println("Anzahl der Wörter mit der Länge als 5: " + result);
		
		service.shutdown();
		
		try {
			service.awaitTermination(2000, TimeUnit.MILLISECONDS);
			System.out.println("main A5 nach awaitTermination"); 			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	static void test_A123(List<String> list) throws InterruptedException, ExecutionException {
		System.out.println("***A1 A2 A3");
		
		
		AtomicLong targetTask1 = new AtomicLong();
		
		// A1
		Runnable taskA1 = ()->{
			long anzahl = list.stream()
							 .filter( word -> word.indexOf("t") !=-1)
							 .count();	
//			System.out.println("Anzahl der Wörter mit 't': " + anzahl);
			targetTask1.set(anzahl);  // speichert in Atomic to increment
		};
		
		//A2
		Callable<Long> taskA2 = ()->{
			return list.stream().filter(word -> word.contains("oo")).count();
		};
		
		ExecutorService service = Executors.newCachedThreadPool();
		
		
		Future<?> future1 = service.submit(taskA1);
		Future<Long> future2 = service.submit(taskA2);
		
		future1.get(); // auf task1 warten
		System.out.println("Wörter mit 't': " + targetTask1.get());
		
		long count2 = future2.get();
		System.out.println("Wörter mit 'oo': " + count2);
		
		service.shutdown();

		try {
			service.awaitTermination(2000, TimeUnit.MILLISECONDS);
			System.out.println("main A1,A2,A3 nach awaitTermination"); 			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	

	}
	

}
