package threads;

import java.util.ArrayList;
import java.util.List;


public class B12_Monitor_auswaelen {

	public static void main(String[] args) throws InterruptedException  {
		
//		test1();
//		test2();
//		test3();
		test4();
		
	}
	
	static void test4() throws InterruptedException {

	    List<Integer> valuesA = new ArrayList<>();

//	    Object monitor = new Object();	 // korrekt, nicht empfohlen
//	    Object monitor = "";			 // korrekt, nicht empfohlen
	    
	    Object monitor = valuesA; 		  // ใช้ valuesA เองเป็น monitor
	    
	    // สร้างงาน (task) สำหรับเธรด A ที่จะเพิ่มค่าตัวเลข 0-99 เข้าไปใน valuesA
	    Runnable taskA = () -> {
	        for (int i = 0; i < 20; i++) {
	            synchronized ( monitor) { 		 // ใช้ synchronized block เพื่อป้องกันการเข้าถึงพร้อมกัน
	                valuesA.add(i); 			
	            }
	        }
	    };

	    // สร้างงาน (task) สำหรับเธรด B ที่จะลบค่าตัวเลขที่ตำแหน่ง 0 จาก valuesA
	    Runnable taskB = () -> {
	        for (int i = 0; i < 30; i++) {
	            synchronized (monitor) { 		 // ใช้ synchronized block เพื่อป้องกันการเข้าถึงพร้อมกัน
	            	  valuesA.add(i); 			
	            }	
	        }
	    };

	    
	    /*
	     *  tA und tB lesen und ändern die Liste valuesA.
	     *  Die Liste kann auch als Monitor verwendet werden. 
	     */    
	    Thread tA = new Thread(taskA); 
	    Thread tB = new Thread(taskB); 

	    tA.start(); 			// size = 20		= Size=20
	    tB.start(); 			// size = 20+30		= Size=50
	    
	    System.out.println("1. " + valuesA.size()); 		// size = 0	
	    //------------------------------------------------------------------
	    /*
	     * โค้ดนี้ไม่ได้มีผลกระทบโดยตรงกับการทำงานของ valuesA ในโค้ดหลัก แต่จะช่วยให้เห็นการควบคุมการเข้าถึงข้อมูลในหลายๆ เธรด 
	     * (ในที่นี้ listX) โดยใช้ synchronized ซึ่งเป็นวิธีการที่ใช้ป้องกัน race condition 
	     * เมื่อทำงานกับข้อมูลที่อาจจะถูกแก้ไขจากหลายเธรดพร้อมกัน.
	     */
	    List<Integer> listX = new ArrayList<>(); 
	    Runnable task1 =  () -> {
	    	synchronized (monitor) {
	    		for (int i = 0; i < 10; i++) {
	    			valuesA.add(12);
				}
	    					   
			}    	
	    };
	    /*
	     *  tA und tB lesen und ändern die Liste listX.
	     *  Die Liste kann auch als Monitor verwendet werden. 
	     */ 
	    Thread t1 = new Thread(task1);
	    Thread t2 = new Thread(task1);
	    t1.start();			 // size = 20+30+10
	    t2.start();			 // size = 20+30+10+10	

	    //------------------------------------------------------------------
	    
	    tA.join(); 				 	
	    tB.join(); 				 
	    t1.join();				  
	    
	    
	    System.out.println("2. " + valuesA.size()); 	// size = 60 - 70 nicht sicher ,
	    												// weil das Programm nicht auf t2 wartet.	
	    											
	   
	    /*
	     * ในเมธอดนี้เราจะสร้างสองเธรด (tA และ tB) ที่ทำงานพร้อมกันเพื่อแก้ไขข้อมูลใน `valuesA` 
	     * โดยทั้งสองเธรดจะทำการเพิ่มค่าตัวเลขลงใน `valuesA` ผ่าน synchronized block เพื่อป้องกันการเข้าถึงพร้อมกันจากหลายเธรด
	     * ซึ่งจะช่วยป้องกันปัญหาการเกิด race condition.
	     * 
	     * เริ่มต้นด้วยการสร้างตัวแปร `monitor` เพื่อใช้ในการควบคุมการซิงโครไนซ์ โดยที่ในกรณีนี้เราใช้ `valuesA` 
	     * เองเป็น monitor ซึ่งอาจมีปัญหาถ้าหาก `valuesA` ถูกใช้ที่อื่นในโปรแกรมโดยไม่ได้รับการควบคุมการซิงโครไนซ์
	     * ซึ่งอาจทำให้เกิด race condition ซึ่งอาจทำให้เธรดหนึ่งเข้าถึง `valuesA` ในขณะที่เธรดอื่นกำลังทำการแก้ไข
	     * หรืออ่านค่าจาก `valuesA`.
	     *
	     * วิธีการที่ถูกต้องคือการใช้ object พิเศษสำหรับเป็น monitor ซึ่งจะช่วยป้องกันไม่ให้เกิด race condition
	     * หรือปัญหาจากการเข้าถึงข้อมูลพร้อมกันจากหลายเธรด.
	     *
	     * ในส่วนของโค้ด:
	     * - เราสร้าง `taskA` ซึ่งจะเพิ่มค่าตัวเลขจาก 0 ถึง 199,999 ลงใน `valuesA`
	     * - และ `taskB` ซึ่งจะเพิ่มค่าตัวเลขจาก 0 ถึง 299,999 ลงใน `valuesA`
	     * - ทั้งสอง task นี้จะทำงานในเธรดต่างๆ (`tA` และ `tB`) และใช้ synchronized block เพื่อซิงโครไนซ์การเข้าถึง `valuesA`.
	     *
	     * หลังจากนั้นจะสร้างอีก task หนึ่ง (`task1`) เพื่อเพิ่มค่า 12 ลงใน `listX` ซึ่งจะทำการซิงโครไนซ์การเข้าถึง
	     * ด้วย `monitor` เช่นกัน.
	     * 
	     * เมื่อทั้งสองเธรดทำงานเสร็จแล้ว จะเรียก `join()` เพื่อรอให้เธรดทั้งหมดทำงานเสร็จ จากนั้นจึงแสดงผล
	     * ขนาดของ `valuesA`.
	     *
	     * **ทำไมผลลัพธ์ถึงไม่ถูกต้องหรือคาดเดาไม่ได้?**
	     * ปัญหาคือการใช้ `valuesA` เป็น monitor ซึ่งอาจทำให้เกิด race condition ถ้า `valuesA`
	     * ถูกเข้าถึงที่อื่นในโปรแกรมโดยไม่ได้รับการควบคุมจากการซิงโครไนซ์.
	     * การใช้ `Object monitor = new Object();` จะเป็นทางเลือกที่ปลอดภัยและดีกว่าเพราะมันป้องกัน
	     * การเข้าถึง `valuesA` โดยไม่ได้รับการควบคุม.
	     */
	}
	
	static void test3() throws InterruptedException {

	    List<Integer> valuesA = new ArrayList<>();

	    // สร้างงาน (task) สำหรับเธรด A ที่จะเพิ่มค่าตัวเลข 0-99 เข้าไปใน valuesA
	    Runnable taskA = () -> {
	        for (int i = 0; i < 20; i++) {
	                valuesA.add(i); 			// เพิ่มค่า i ลงใน valuesA
	            
	        }
	    };

	    // สร้างงาน (task) สำหรับเธรด B ที่จะลบค่าตัวเลขที่ตำแหน่ง 0 จาก valuesA
	    Runnable taskB = () -> {
	        for (int i = 0; i < 30; i++) {       
	              if (valuesA.size() > 0) { 			// ตรวจสอบว่ามีค่าที่จะลบหรือไม่
	                  valuesA.remove(0); 				// ลบค่าตำแหน่ง 0 ของ valuesA
	              }
	         
	        }
	    };
 
	    Thread tA = new Thread(taskA); 
	    Thread tB = new Thread(taskB); 

	    tA.start(); 
	    tB.start(); 


	    tA.join(); 
	    tB.join(); 

	    System.out.println(valuesA.size()); 	
	    
	    /*
	     * **ทำไมผลลัพธ์ถึงไม่ถูกต้องหรือคาดเดาไม่ได้?**
	     * ปัญหาคือไม่มีการซิงโครไนซ์ (synchronization) ในการเข้าถึง `valuesA` โดยตรงจากหลายเธรด,
	     * ทำให้เกิด **race condition** ซึ่งหมายถึงการที่เธรดหนึ่งอาจทำการเปลี่ยนแปลง `valuesA`
	     * ในขณะที่อีกเธรดหนึ่งกำลังทำการเปลี่ยนแปลงหรืออ่านค่าจาก `valuesA` โดยไม่ได้รับการควบคุม.
	     *
	     * เนื่องจากเธรดทั้งสอง (tA และ tB) ทำงานพร้อมกัน, การเพิ่มและลบค่าใน `valuesA` อาจเกิดขึ้น
	     * ในลำดับที่ไม่สามารถคาดเดาได้. ตัวอย่างเช่น เธรด A อาจเพิ่มค่า 0 ในขณะที่เธรด B ลบค่าแรก.
	     * สิ่งนี้อาจทำให้เกิดการแก้ไขค่าใน `valuesA` ที่ไม่สมบูรณ์หรือมีการเข้าถึงข้อมูลแบบขัดแย้งกัน.
	     *
	     * วิธีแก้ไขปัญหานี้คือการใช้ `synchronized` ในการควบคุมการเข้าถึง `valuesA` โดยให้เธรดหนึ่ง
	     * สามารถทำงานกับ `valuesA` ได้ทีละตัว, ซึ่งจะป้องกันไม่ให้เกิดการเข้าถึงหรือการเปลี่ยนแปลงข้อมูล
	     * โดยพร้อมกันจากหลายเธรด.
	     */
	}
	
	static void test2() throws InterruptedException {
	      
		List<Integer> valuesA = new ArrayList<>();
		
		Runnable taskA = () ->{
			for (int i = 0 ; i < 100 ; i++) {
				valuesA.add(i);
			}
		};
		
		Runnable taskB = () ->{
			for (int i = 0 ; i < 100 ; i++) {
				valuesA.add(i);
			}
		};
		
		Thread tA = new Thread(taskA);
		Thread tB = new Thread(taskB);
		
		tA.start();
		tB.start();
		
		tA.join();
		tB.join();
		
		// พิมพ์ขนาดของ valuesA ซึ่งควรจะเป็น 200 แต่ในบางกรณีอาจเกิด ArrayIndexOutOfBoundsException
	    System.out.println(valuesA.size()); // ArrayIndexOutOfBoundsException:

	    /*
	     * **ทำไมถึงเกิดปัญหาในกรณีนี้?**
	     * ปัญหาคือการที่หลายเธรด (ในที่นี้คือ tA และ tB) ทำงานพร้อมกัน และทั้งสองเธรดพยายามที่จะ
	     * แก้ไขหรือเพิ่มข้อมูลใน `valuesA` พร้อมกัน ซึ่งส่งผลให้เกิด **race condition**.
	     * โดยที่ไม่มีการป้องกันให้แน่ใจว่าเธรดหนึ่งทำงานเสร็จก่อนที่จะให้เธรดถัดไปทำงาน
	     *
	     * ถ้าเธรดหนึ่งกำลังเพิ่มค่าลงไปใน `valuesA` แล้วแต่ยังไม่ได้ปรับขนาดของ List 
	     * (ไม่สามารถเก็บค่าที่เพิ่มได้เพราะขนาดของมันไม่เหมาะสม) ขณะที่เธรดที่สองเข้ามาทำการเพิ่มค่าใหม่เช่นกัน 
	     * อาจทำให้ `valuesA` ถูกแก้ไขอย่างไม่สมบูรณ์ และอาจทำให้ขนาดของ List ไม่ถูกต้อง.
	     * 
	     * ในกรณีนี้, การที่หลายเธรดทำงานพร้อมกันและแก้ไข `valuesA` โดยไม่มีการซิงโครไนซ์ (synchronization)
	     * อาจทำให้ข้อมูลใน `valuesA` ขัดแย้งกัน หรืออาจทำให้การเพิ่มค่าใหม่ไม่สมบูรณ์
	     * ซึ่งจะนำไปสู่ปัญหาอื่น ๆ เช่น ขนาดของ `valuesA` ไม่ตรงตามที่คาด (คาดว่าจะเป็น 200) 
	     * หรืออาจทำให้เกิดข้อผิดพลาด เช่น `ArrayIndexOutOfBoundsException`.
	     * 
	     * **ทำไมถึงเกิด ArrayIndexOutOfBoundsException?**
	     * ในบางกรณี, เนื่องจากไม่มีการป้องกันที่เหมาะสม เธรดทั้งสองอาจพยายามเพิ่มค่าลงใน `valuesA`
	     * ซึ่งอาจทำให้ขนาดของ List ไม่ถูกอัปเดตอย่างถูกต้อง
	     * เมื่อโปรแกรมพยายามเข้าถึงตำแหน่งใน List ที่ยังไม่ได้รับการอัปเดต หรือขนาดของ List ไม่ตรงกับข้อมูลที่เพิ่มเข้าไปแล้ว
	     * จึงทำให้เกิด `ArrayIndexOutOfBoundsException` เพราะโปรแกรมพยายามเข้าถึงตำแหน่งที่ไม่สามารถเข้าถึงได้
	     *
	     * วิธีการที่ถูกต้องในการป้องกันปัญหานี้คือการใช้การซิงโครไนซ์ (synchronize) 
	     * เพื่อให้มั่นใจว่าเธรดหนึ่งจะทำงานเสร็จเรียบร้อยก่อนที่จะให้เธรดถัดไปทำงานต่อ
	     * โดยการใช้ `synchronized` จะทำให้การเข้าถึงและการปรับเปลี่ยน `valuesA` 
	     * สามารถทำได้ทีละเธรด ทำให้ไม่เกิดการขัดแย้งกันระหว่างเธรด
	     */

	}
	
	static void test1() throws InterruptedException {
      
		List<Integer> valuesA = new ArrayList<Integer>();
		
		Runnable taskA = () ->{
			valuesA.add(12);
		};
		Runnable taskB = () ->{
			valuesA.add(42);
		};
		
		Thread tA = new Thread(taskA);
		Thread tB = new Thread(taskB);
		
		tA.start();
		tB.start();
		
		tA.join();
		tB.join();
		
		System.out.println(valuesA);			// Ergebnis : NOT RICHTIG! 
		/*
         * **ทำไมผลลัพธ์ถึงไม่ถูกต้องหรือคาดเดาไม่ได้?**
         * ปัญหาคือไม่มีการซิงโครไนซ์ (synchronization) ในการเข้าถึง `valuesA` โดยตรงจากหลายเธรด
         * ซึ่งทำให้เกิด **race condition** หรือการที่เธรดหนึ่งทำงานและเปลี่ยนแปลง `valuesA` 
         * ในขณะที่อีกเธรดหนึ่งก็สามารถทำเช่นเดียวกันได้.
         * 
         * เพราะว่าเธรดทั้งสอง (tA และ tB) ทำงานพร้อมกัน, การเพิ่มค่า 12 และ 42 เข้าไปใน 
         * `valuesA` สามารถเกิดขึ้นในลำดับใดก็ได้ (ขึ้นอยู่กับว่าเธรดไหนทำงานเสร็จเร็วกว่า)
         * ซึ่งอาจทำให้ลำดับของค่าที่แสดงผลไม่สามารถคาดเดาได้หรือมีการแก้ไขค่าแบบไม่สมบูรณ์.
         *
         * วิธีแก้ไขปัญหานี้คือการใช้ `synchronized` เพื่อป้องกันการเข้าถึง `valuesA` โดยหลายเธรดพร้อมกัน
         * ซึ่งจะทำให้แน่ใจว่าแต่ละเธรดจะสามารถทำงานกับ `valuesA` ได้ทีละตัว และไม่เกิดการแก้ไขข้อมูลพร้อมกัน
         */
	}
}
