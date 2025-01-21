package concurrency;

import java.time.LocalDate;
import java.util.concurrent.Callable;

public class B14_CallableVsRunnable { 
	/*
			คุณสมบัติ			Runnable					Callable
			--------------------------------------------------------------------
			อินเทอร์เฟซ		    Runnable					Callable<V>
			--------------------------------------------------------------------
			เมธอดหลัก		     run()						call()
			--------------------------------------------------------------------
			ผลลัพธ์		ไม่มีค่าที่ส่งกลับ (void)			ส่งค่ากลับได้ (Generic Type <V>)
			--------------------------------------------------------------------
			โยนข้อยกเว้น		ไม่สามารถโยนข้อยกเว้นที่ตรวจสอบได้ 		  สามารถโยนข้อยกเว้นที่ตรวจสอบได้
						(checked exceptions)	
			--------------------------------------------------------------------
			การใช้งาน		ใช้กับ Thread หรือ 				 ใช้กับ ExecutorService เท่านั้น
						ExecutorService
			--------------------------------------------------------------------
	*/
	
	public static void main(String[] args) {
		
		class MyRunnable implements  Runnable {
			public void run() {
				
			}
		};
		
		class MyCallable implements Callable<LocalDate>{
			public LocalDate call() throws Exception {
				return LocalDate.now();
			}
		}
	}
}
