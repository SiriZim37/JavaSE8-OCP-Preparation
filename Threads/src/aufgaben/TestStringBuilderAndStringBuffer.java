package aufgaben;

public class TestStringBuilderAndStringBuffer {

	public static void main(String[] args) throws InterruptedException {

		/* Note: 
		 * StringBuffer : 
		 * 		 - ist langsamer als StringBuilder
		 * 	 	 - ist thread-sicher und synchronisiert (Multi-Threaded)
		 * 
		 * StringBuilder
		 * 		- ist schneller als StringBuffer
		 * 		- ist nicht synchronisiert und daher nicht thread-sicher (Single-Threaded)
		 */
		
		class MyLoggerMitStringBuilder {
			 private StringBuilder sb = new StringBuilder();		    
			 public void addMessage(String message) {
			     sb.append(message).append("\n");
			 }			    
			 public String getLog() {
			     return sb.toString();
			 }	 
		} 

		class MyLoggerMitStringBuffer {
		    private StringBuffer sb = new StringBuffer();	    
		    public void addMessage(String message) {
		        sb.append(message).append("\n");
		    }	    
		    public String getLog() {
		        return sb.toString();
		    }
		} 	
		System.out.println("***Test\n");
		MyLoggerMitStringBuilder log1 = new MyLoggerMitStringBuilder();
		MyLoggerMitStringBuffer log2 = new MyLoggerMitStringBuffer();
		Runnable taskSB = () -> {
	        for (int i = 0; i < 50; i++) {
	        	 String message = Thread.currentThread().getName() + ": log " + i;
	        	 log1.addMessage(message);
	        	 log2.addMessage(message);
	        }
	    };
	    Thread th3 = new Thread(taskSB, "Thread-SB");
	    Thread th4 = new Thread(taskSB, "Thread-SBF");
	    
	    th3.start();
	    th4.start();
	    
	    th3.join();
	    th4.join();
	    

	    System.out.println("StringBuilder (nicht sicher):\n" + log1.getLog());
	    System.out.println("StringBuffer (sicher):\n" + log2.getLog());
	}
}
