package klausur;
/*
 Wie startet man einen extra Thread?
Eine oder mehrere richtige Antworten sind möglich.

[   ] new Thread(  () -> {}  ).start();

[   ] new Thread(  () -> {}  ).run();

[   ] new Thread() { 
         public void run() {
           // source code 
         }
       }.start();

[   ] new Thread() { 
         public void run() {
           // source code 
         }
       }.start(this);

 */
public class TestThread2 {

	public static void main(String[] args) {
		
		 new Thread(  () -> {}  ).start();
		 
		 new Thread(  () -> {}  ).run();
		 
		 new Thread() { 
	         public void run() {
	           // source code 
	         }
	       }.start();
	       
//	     new Thread() { 
//	           public void run() {
//	             // source code 
//	           }
//	         }.start(this);
	}
}
