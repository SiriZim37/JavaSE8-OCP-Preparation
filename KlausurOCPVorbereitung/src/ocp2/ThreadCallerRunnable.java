package ocp2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Caller implements Callable<String> {
    String str;
    public Caller(String s) { this.str = s; }
    public String call() throws Exception { 
        return str.concat("Caller");
    }
}

class Runner implements Runnable {
    String str;
    public Runner(String s) { this.str = s; }
    public void run() { 
        System.out.println(str.concat("Runner"));
    }
}
  
public class ThreadCallerRunnable {



	public static void main(String[] args) throws InterruptedException, ExecutionException {
	    ExecutorService es = Executors.newFixedThreadPool(2);
	    Future f1 = es.submit(new Caller("Call"));
	    Future f2 = es.submit(new Runner("Run"));
	    String str1 = (String) f1.get();
	    String str2 = (String) f2.get();  // line n1
	    System.out.println(   str1 + ":" + str2);
	    
	    
	    // es.shutdown() >>> es wird Terminate
	}
	
	/*
		 A. The program prints:
		 Run Runner
		 Call Caller : null
		 And the program does not terminate.
		 
		 B. The program terminates after printing:
		 Run Runner
		 Call Caller : Run
		
		 C. A compilation error occurs at line n1.
		
		 D. An Execution is thrown at run time.
	 */
	/*
	 	สรุปคำอธิบายของโค้ดในภาษาไทย:
		โค้ดตัวอย่างนี้มีการใช้งาน Callable และ Runnable ในการทำงานพร้อมกันโดยใช้ ExecutorService และ Future สำหรับการทำงานแบบมัลติเธรด (Multithreading) โดยมีการแยกกันทำงานในแต่ละเธรด (thread):
		
		1. คลาส Caller (Callable)
		Callable<String> ใช้เพื่อทำงานที่ต้องการให้ผลลัพธ์กลับมาเป็นประเภท String.
		ในคลาสนี้มีการกำหนดเมธอด call() ซึ่งจะเชื่อมข้อความจาก str และคำว่า "Caller" แล้วส่งคืนค่าผลลัพธ์นั้น.
		2. คลาส Runner (Runnable)
		Runnable ใช้สำหรับทำงานที่ไม่ต้องการผลลัพธ์กลับมา.
		เมธอด run() ของ Runner จะทำการแสดงผลข้อความจาก str และเชื่อมกับคำว่า "Runner" ผ่าน System.out.println().
		3. ในคลาส ThreadCallerRunnable
		มีการสร้าง ExecutorService ด้วย Executors.newFixedThreadPool(2) เพื่อกำหนดจำนวนเธรดที่ทำงานพร้อมกันเป็น 2 เธรด.
		Future f1 จะรับการทำงานของคลาส Caller ซึ่งจะใช้ f1.get() เพื่อรับค่าผลลัพธ์จาก call() (ผลลัพธ์จะเป็น String).
		Future f2 จะรับการทำงานของคลาส Runner ซึ่ง f2.get() จะคืนค่า null เพราะ run() ของ Runnable ไม่มีค่าผลลัพธ์คืน (ผลลัพธ์จะเป็น void).
		ปัญหาที่เกิดขึ้น:
		f2.get() ในกรณีของ Runner จะเกิด null เพราะว่า Runnable ไม่สามารถส่งค่าผลลัพธ์กลับมาได้.
		ในขณะที่ f1.get() จะได้รับค่าผลลัพธ์จาก call() ของ Caller.
		ผลลัพธ์ของโปรแกรม:
		โปรแกรมจะพิมพ์ข้อความจาก Runner ในเธรดแรกที่ทำงาน (ซึ่งจะพิมพ์ "RunRunner") และจาก Caller ในเธรดที่สอง (ซึ่งจะคืนค่าผลลัพธ์เป็น "CallCaller").
		
		สรุปผลลัพธ์:
		
		str1 จะได้ผลลัพธ์จาก f1.get() ซึ่งเป็น "CallCaller".
		str2 จะได้ null จาก f2.get() เนื่องจาก Runnable ไม่คืนค่าผลลัพธ์.
	 */
}
