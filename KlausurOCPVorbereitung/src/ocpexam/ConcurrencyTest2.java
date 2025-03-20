package ocpexam;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@FunctionalInterface
interface Converter<F,T>{
	T convert(F from);
}

class Caller implements Callable<String> {
	String str;
	public Caller (String s) {
		this.str=s;
	}
	public String call() throws Exception { 
		//System.out.println("Caller");
		return str.concat ("Caller");
		} 
}
class Runner implements Runnable {
String str;
	public Runner (String s) {
		this.str=s;
	}
	public void run () { 
		/*try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.println (str.concat("Runner"));
	} 
}

public class ConcurrencyTest2 {
	public static void main (String[] args) throws InterruptedException, ExecutionException/*, TimeoutException*/  { // Future.get thrown exception 
		ExecutorService es = Executors.newFixedThreadPool(2);
		//ExecutorService es = Executors.newSingleThreadExecutor();
		Future f1 = es.submit (new Caller ("Call"));
		Future f2 = es.submit (new Runner ("Run"));
		String str1 = (String) f1.get();
		String str2 = (String) f2.get(); /*f2.get(1, TimeUnit.SECONDS)*/;//line n1  // Exception in thread "main" java.util.concurrent.TimeoutException
		
		System.out.println(str1+ ":" + str2);
		/*es.shutdown();*/
		/*Converter<String , Integer> converter = Integer::valueOf;
		converter.convert("123");*/
	}
}




	/*					>>>> OCP Test ***
	class Caller implements Callable<String> {
	String str;
	public Caller (String s) {this.str=s;}
	public String call()throws Exception { return str.concat (“Caller”);} }
	class Runner implements Runnable {
	String str;
	public Runner (String s) {this.str=s;}
	public void run () { System.out.println (str.concat (“Runner”));} }
	and
	public static void main (String[] args) InterruptedException, ExecutionException { 
	ExecutorService es = Executors.newFixedThreadPool(2);
	Future f1 = es.submit (new Caller (“Call”));
	Future f2 = es.submit (new Runner (“Run”));
	String str1 = (String) f1.get();
	String str2 = (String) f2.get();//line n1 System.out.println(str1+ “:” + str2);
	}
	What is the result?
	A. The program prints:
	Run Runner
	Call Caller : null
	And the program does not terminate.
	B. The program terminates after printing: Run Runner
	Call Caller : Run
	C. A compilation error occurs at line n1.
	
	
	
	The Callable interface is similar to Runnable, 
	in that both are designed for classes whose instances are potentially executed by another thread. 
	A Runnable, however, does not return a result and cannot throw a checked exception.
	
	https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ExecutorService.html
	
	Callables can be submitted to executor services just like runnables. 
	But what about the callables result? Since submit() doesn't wait until the task completes, 
	the executor service cannot return the result of the callable directly. 
	Instead the executor returns a special result of type 
	Future which can be used to retrieve the actual result at a later point in time.
	 */
	
	