package ocp;





public class ThreadSynchronise {

	public static synchronized void main(String[] args) throws InterruptedException {
		
		Thread t =  new Thread();
		t.start();
		System.out.println("A");
		synchronized (t) {
			t.wait(10000);
		}
//		t.wait(10000);
		System.out.println("B");
		/*
		 * Ergebnis : A
			Exception in thread "main" java.lang.IllegalMonitorStateException: current thread is not owner
		 */
	}
	
	
	/*
	 * Lösung
	 * 		Thread t =  new Thread();
		t.start();
		System.out.println("A");
		synchronized (t) {   			>>> t muss synchonized werden
			t.wait(10000);
		}
		System.out.println("B");
	 */
	
}
