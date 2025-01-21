package klausur;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
     public static void main(String[] args) 
		throws InterruptedException, ExecutionException {

        ExecutorService service = Executors.newCachedThreadPool();
        
        Callable<String> t1 = () -> "a ";
        Callable<String> t2 = () -> "b ";
        
        Collection<Callable<String>> coll = Arrays.asList(t1, t2);
        
        List<Future<String>> result = service.invokeAll(coll);
        
        for (Future<String> f : result) {
            System.out.print(f.isDone() + " ");
            System.out.print(f.get());
        }

        service.shutdown();
    }
 */
public class TestConcurrency {

	public static void main(String[] args) throws Exception  {

	        ExecutorService service = Executors.newCachedThreadPool();
	        
	        Callable<String> t1 = () -> "a ";
	        Callable<String> t2 = () -> "b ";
	        
	        Collection<Callable<String>> coll = Arrays.asList(t1, t2);
	        
	        List<Future<String>> result = service.invokeAll(coll);
	        
	        for (Future<String> f : result) {
	            System.out.print(f.isDone() + " ");
	            System.out.print(f.get());
	        }

	        service.shutdown();
	    }
}
