package aufgaben.interact;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import aufgaben.MyThreadUtils;

class TaskRunnable implements Runnable{
	
	private List<Integer> intlist  = new ArrayList<>();
	private int count;
	
	public TaskRunnable(int count) {
		this.count = count;
	}
	 
	@Override
	public void run() {
		Random rnd = new Random();
		Thread th = Thread.currentThread();
		for (int i = 0; i < this.count; i++) {
			int randomNum =  rnd.nextInt(50)+1;
			intlist.add(randomNum);
			System.out.printf("%-3d | Thread ID: %s | Name : %s %n" , randomNum , th.getId() , th.getName());
		}
		System.out.println(th.getName() + " wurde beendet " );
	}
	
	public List<Integer> getIntList() {
		return new ArrayList<>(intlist);
	}
	
	public int getCount() {
		return this.intlist.size();
	}
	

}
public class AufgabenInteractSimple {

	volatile static int count;
	
	public static void main(String[] args) {
		System.out.println("***A1");
		// A1
		TaskRunnable taskA = new TaskRunnable(20);
		TaskRunnable taskB = new TaskRunnable(30);
		
		Thread threadA = new Thread(taskA,"Thread-A");
		Thread threadB = new Thread(taskB,"Thread-B");

		threadA.start();
		threadB.start();
		
	   // Warten bis threadA & threadB  beendet sind
		try {	
			threadA.join();
			threadB.join();
		} catch (InterruptedException e) {
			   e.printStackTrace();
		}
		
		int sum = 0;
		for (int value : taskA.getIntList()) {
			sum += value;
		}
    	for (int value : taskB.getIntList()) {
			sum += value;
		}
    	System.out.println("sum: " + sum);

    	
    	//--------------------------------------------------------------
    	
    	// A2   
    	System.out.println("\n***A2");
    	Runnable taskA2 = () ->{
    		Thread th = Thread.currentThread();
			for (int i = 0; i < 1_000_000; i++) {
				count++;
			}
			System.out.println(th.getName() + " wurde beendet " );
		};
		
    	Thread threadA2 = new Thread(taskA2 , "Thread-A2");
    	threadA2.start();
    	
    	// Warten bis der threadExtra beendet ist.
    	try {
    		threadA2.join();  
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    	
    	System.out.println("main-count : " + count);  
    	
    	//--------------------------------------------------------------
    	
    	// A3   
    	System.out.println("\n***A3");
    	Runnable taskA3 = () -> {
    		Thread th = Thread.currentThread();
    		while (!th.isInterrupted()) { 
    	       try {
    	           Thread.sleep(1000);  // 1 sec
    	       } catch (InterruptedException e) {
    	         	System.out.println(th.getName() + " wurde interrupted");
    	            break; 
    	        }
    	    }
    	};
    	
    	
    	Thread threadA3 = new Thread(taskA3, "Thread-A3");
    	System.out.println("main-Thread startet den Extra-Thread " + threadA3.getName());
    	threadA3.start();
		
		System.out.println("main-Thread wartet..");
		MyThreadUtils.pause(5000);		// 5 sec
		
		System.out.println("main-Thread beendet den Extra-Thread " + threadA3.getName());
		threadA3.interrupt();
		   
		// Warten bis der threadA3 beendet ist.
		try {
			threadA3.join();
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }

	    System.out.println("Programm beendet.");
	
	}
	
	
}
