package aufgaben.interact;

import aufgaben.MyThreadUtils;

public class AufgabeThreadsInteractA3 {
	

	public static void main(String[] args) throws InterruptedException{

		Runnable task = () -> {
    		Thread curThreadt = Thread.currentThread();
    		while (true) { 
    			System.out.println(curThreadt + " läuft..");
    	       try {
    	           Thread.sleep(1000);  // 1 sec
    	       } catch (InterruptedException e) {
    	         	System.out.println(curThreadt.getName() + " wurde interrupted");
    	            break; 
    	        }
    	    }
    	};
    	
    	Thread th = new Thread(task, "Thread-A3");
    	th.start();

    	Thread.sleep(5000);

		System.out.println("main ruft interrupt() auf");
		
		th.interrupt();
		
		/*	Thread[	ID   NAME  GROUP ]
		 *  Thread[#21,Thread-A3,5,main] läuft..
			Thread[#21,Thread-A3,5,main] läuft..
			Thread[#21,Thread-A3,5,main] läuft..
			Thread[#21,Thread-A3,5,main] läuft..
			Thread[#21,Thread-A3,5,main] läuft..
			main ruft interrupt() auf
			Thread-A3 wurde interrupted
		 */
    	
	}
	
}
