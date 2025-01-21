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
Gegeben ist die Klasse Worker:

  class Worker implements Callable<String> {
    public String call() throws Exception {
      return "work ";
    }
  }

Und folgende main-Methode:

  public static void main(String[] args) throws Exception {
    ExecutorService service = Executors.newFixedThreadPool(4); 
    Future<String> f = service.submit(new Worker());
    String str = f.get().toString();
    System.out.println(str);
  }

Was ist richtig, wenn alle notwendigen import-Anweisungen existieren?

[  ] Die main gibt "work" aus. Die Anwendung wird danach beendet.
[ X ] Die main gibt "work" aus. Die Anwendung wird danach nicht beendet.
[   ] Es gibt einen Compilerfehler in der main-Methode.
[   ] Eine Exception wird in der main-Methode geworfen.
 */

class Worker implements Callable<String> {
    public String call() throws Exception {
      return "work ";
    }
  }

public class TestConcurrency2 {

	  public static void main(String[] args) throws Exception {
		    ExecutorService service = Executors.newFixedThreadPool(4); 
		    Future<String> f = service.submit(new Worker());
		    String str = f.get().toString();
		    System.out.println(str);
		    
	
		  }
}
