package klausur;

/*
 Gegeben ist folgender Code:

21. void method() {
22.   Thread t = new Thread();
23.   t.start();
24.   t.sleep(2000);
25.   t.join();
26. }

Was trifft zu?
Eine oder mehrere richtige Antworten sind möglich.

[   ] Zeile 22 kompiliert
[   ] Zeile 23 kompiliert
[   ] Zeile 24 kompiliert
[   ] Zeile 25 kompiliert
 */
public class TestThread1 {

	 void method() {
		   Thread t = new Thread();
		   t.start();
//		   t.sleep(2000);
//		   t.join();
	}
	 
	public static void main(String[] args) {

	}
}
