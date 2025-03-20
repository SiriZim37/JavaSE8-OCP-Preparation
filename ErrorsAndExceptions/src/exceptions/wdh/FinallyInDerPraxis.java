package exceptions.wdh;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FinallyInDerPraxis {

	/*
	 * Nicht in der Prüfung
	 */
	public static void main(String[] args) {
		
		Lock m = new ReentrantLock(); 
		/*
		 *  in einem Thread : 
		 */
		try {
			m.lock();
			
			// more code here 
			
		}finally {
			m.unlock();		// egal was in dem try-Block passiert , 
							// wird das Lock-Objekt damit freigegben.
		}
		
		
		
		
		

	}

}
