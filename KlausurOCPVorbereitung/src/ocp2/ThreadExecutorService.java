package ocp2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
  QUESTION 73
 Given the code fragment:
 class CallerThread implements Callable<String>   {
    String str;
    public CallerThread(String s)    {this.str=s;}
    public String call() throws Exception {
        return str.concat(“Call”);
    }
 }
 and
 public static void main (String[] args) throws InterruptedException, ExecutionException
 {
    ExecutorService es = Executors.newFixedThreadPool(4);         //line n1
    Future f1 = es.submit (new CallerThread(“Call”));
    String str = f1.get().toString();
    System.out.println(str);
 }
 Which statement is true?
 A. The program prints Call Call and terminates.
 B. The program prints Call Call and does not terminate.
 C. A compilation error occurs at line n1.
 D. An ExecutionException is thrown at run time.
 */

class CallerThread implements Callable<String>   {
    String str;
    public CallerThread(String s)    {this.str=s;}
    public String call() throws Exception {
        return str.concat("Call");
    }
 }

public class ThreadExecutorService {

	
	 public static void main (String[] args) throws InterruptedException, ExecutionException
	 {
	    ExecutorService es = Executors.newFixedThreadPool(4);         //line n1
	    Future<String> f1 = es.submit (new CallerThread("Call"));
	    String str = f1.get().toString();
	    System.out.println(str);
	 }
}
