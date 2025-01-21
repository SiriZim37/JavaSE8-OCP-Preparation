package aufgaben.interact;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.Stream;



public class AufgabeThreadsInteractA2 {
	
	static volatile int count;
	
	public static void main(String[] args){
		
		Thread th = new Thread( () -> {
			for (int i = 0; i < 1_000_000; i++) {
				count++;
			}
		});
		
		th.start();
		
    	try {
    		th.join();  
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    	
    	System.out.println("main-count : " + count);  
    	
	}
	
}
