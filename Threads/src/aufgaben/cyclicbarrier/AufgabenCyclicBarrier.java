package aufgaben.cyclicbarrier;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.*;
import java.util.stream.Stream;

class RaceCar implements Runnable {
	public static Map<String, LocalTime> finishTimes = Collections.synchronizedMap(new HashMap<>());
    private String name;
    private List<RaceCar> finish;
    private CyclicBarrier barrier;

    
    public RaceCar(String name, List<RaceCar> finish, CyclicBarrier barrier) {
        this.name = name;
        this.finish = finish;
        this.barrier = barrier;
    }
    
	public void run() {
	
		try {

			  System.out.println(name + " started.");
	          LocalTime timeArrive = LocalTime.now().truncatedTo(ChronoUnit.MILLIS);
	          
	          finish.add(this);
	          
	          finishTimes.put(name, timeArrive);    // Record the arrival time before awaiting the barrier
	        									    // Wait for other cars to arrive
	          System.out.println(name + " finished.");
	          barrier.await();  
		} catch (InterruptedException |BrokenBarrierException e) {
			e.printStackTrace();
		} 
		
	}
	
	

    @Override
    public String toString() {
        return name;
    }
}

public class AufgabenCyclicBarrier {
	
    public static void main(String[] args) throws InterruptedException {
       
    	int partiesCar = 4; 

//        List<RaceCar> finish = Collections.synchronizedList(new ArrayList<>());  // Race Con

        List<RaceCar> finish = new CopyOnWriteArrayList<>();
        
        Runnable taskBarrier = () -> {
        	
            System.out.println("\nAll cars departed");
            LocalTime timeArrive = LocalTime.now().truncatedTo(ChronoUnit.MILLIS);
            finish.forEach(car -> System.out.println(car + " : " + timeArrive));
            System.out.println("All cars arrived.\n");
        };

        CyclicBarrier barrier = new CyclicBarrier(partiesCar, taskBarrier);

//      ExecutorService executorService = Executors.newSingleThreadExecutor();  	// only 1 Thread -> Wrong result
//      ExecutorService executorService = Executors.newCachedThreadPool();			// ok
        ExecutorService executorService = Executors.newFixedThreadPool(partiesCar);

        RaceCar carA = new RaceCar("Car A", finish, barrier);
        RaceCar carB = new RaceCar("Car B", finish, barrier);
        RaceCar carC = new RaceCar("Car C", finish, barrier);
        RaceCar carD = new RaceCar("Car D", finish, barrier);

        executorService.submit(carA);
        executorService.submit(carB);
        executorService.submit(carC);
        executorService.submit(carD);

        executorService.shutdown();
              
        
        //-------------------------------------------------------------------------------//
       
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();						

        Runnable task = () -> {
        	try {
        		 System.out.println("\nScore!");
        	     Optional<LocalTime> winnerTimeStamp = RaceCar.finishTimes
										        	        	.values()
										        	        	.stream()
										        	        	.min(LocalTime::compareTo);
        	        
        	     Comparator<Map.Entry<String, LocalTime>> cmp = ( map1 , map2) -> {
	        	        	 int compare = map1.getValue().compareTo(map2.getValue());
	                         if (compare == 0) {
	                             return map1.getKey().compareTo(map2.getKey());
	                         }
	                         return compare;
        	        };
        	        										
        	     RaceCar.finishTimes.entrySet()
        	        		   .stream()
        	        		   .sorted(cmp)
				        	   .forEach(entry -> {
				        	      if (entry.getValue().equals(winnerTimeStamp.get())) {
				        	          System.out.println(entry.getKey() + " is the Winner! Finished at " + entry.getValue());
				        	      } else {
				        	         System.out.println(entry.getKey() + " finished at " + entry.getValue());
				        	      }
				        	    });
        	     
			} catch (Exception e) {
				e.printStackTrace();
			}      	
        };
        
		service.schedule(task , 2 , TimeUnit.SECONDS);		
		service.shutdown();
    }
}
