package aufgaben;



public class MyThreadUtils {

	public static void pause(int sec) {
		try {
			 Thread.sleep(sec);   
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}		
	}

}
