package threads;

public class TestThreadStarten {

	public static void main(String[] args) {
		
//		f1();
//		
//		System.out.println();
//		
//		f2();
//		
//		System.out.println();
		
		f3();
		
//		f4();
	}


	/*
	 * Ergebnis : a c 
	 */
	private static void f1() {
	
		System.out.println("a");
		
		Runnable task = () -> System.out.println("b");
		
		Thread t1 = new Thread();
		
		System.out.println("c");
		
		
	}
	
	/*
	 * Ergebnis : a b c 
	 */
	private static void f2() {
		
		System.out.println("a");
		
		Runnable task = () -> System.out.println("b");
		
		Thread t1 = new Thread(task);
		
		t1.run();		// in dem main-Thread aufgerufen (blöd)
		/*
		 * run ist nicht null dann run wirk aktivieren
		 */
		
		System.out.println("c");
	
	}
	
	/*
	 * Ergebnis : a b c oder a c b
	 */
	private static void f3() {
		System.out.println("a");
		
		Runnable task = () -> System.out.println("b");
		
		Thread t1 = new Thread(task);
		t1.start();
		
		System.out.println("c");
		
	}
	
	/*
	 * Ergebnis : a und danach Exception
	 */
	static void f4() {
		System.out.println("a");
		
		Runnable task = () -> System.out.println("b");
		
		Thread t1 = new Thread(task);
		t1.start();		// NEW -> RUNNABLE
		t1.start();  	// Exception! Der Thread kann nur aus dem Zustand NEW gestarten wurde.
		
		System.out.println("c");
		
	}
	
	

}
