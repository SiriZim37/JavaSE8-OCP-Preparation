package concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
	
/*
 * โค้ดนี้แสดงถึงการใช้ `BlockingQueue` ในการสื่อสารระหว่างเธรดในรูปแบบ Producer-Consumer
 * โดยใช้ `ArrayBlockingQueue` ที่มีความจุจำกัด และใช้กลไกบล็อกเมื่อเกิดสถานการณ์ที่คิวเต็มหรือว่าง
 */

/*
 * Producer:
 * - เธรด Producer สร้างข้อมูล (เลขสุ่ม) ทุก 1 วินาที และพยายามเพิ่มข้อมูลในคิว
 * - ใช้เมธอด `offer()` กับ timeout (1000 มิลลิวินาที)
 * - ถ้าคิวไม่เต็ม จะเพิ่มข้อมูลสำเร็จ และพิมพ์ข้อความ "Daten produziert und übergeben"
 * - ถ้าคิวเต็ม และหมดเวลา timeout จะพิมพ์ข้อความ "Daten produziert aber verworfen"
 */

/*
 * Consumer:
 * - เธรด Consumer พยายามดึงข้อมูลจากคิวทุก 500 มิลลิวินาที
 * - ใช้เมธอด `poll()` กับ timeout (500 มิลลิวินาที)
 * - ถ้าคิวไม่ว่าง จะดึงข้อมูลสำเร็จ และพิมพ์ข้อความ "konsumiert: <ข้อมูล>"
 * - ถ้าคิวว่าง และหมดเวลา timeout จะพิมพ์ข้อความ "keine neuen Daten in der Zeit erschienen"
 */

/*
 * TestBlockingQueue:
 * - คลาสหลักที่สร้าง `ArrayBlockingQueue` ขนาด 1000
 * - สร้างและเริ่มต้นเธรด Producer 1 ตัว และ Consumer 2 ตัว
 * - ทั้งหมดทำงานพร้อมกัน (Concurrent Execution) และสื่อสารผ่านคิวเดียวกัน
 */

/*
 * `offer()`:
 * - ใช้สำหรับเพิ่มข้อมูลในคิวแบบมี timeout
 * - ถ้าคิวเต็ม จะบล็อกจนกว่าจะมีที่ว่าง หรือหมดเวลาที่กำหนด
 *
 * `poll()`:
 * - ใช้สำหรับดึงข้อมูลจากคิวแบบมี timeout
 * - ถ้าคิวว่าง จะบล็อกจนกว่าจะมีข้อมูลในคิว หรือหมดเวลาที่กำหนด
 */


//คลาส Producer ที่ทำหน้าที่ผลิตข้อมูลและส่งไปยัง BlockingQueue
class Producer implements Runnable {
	
	private BlockingQueue<Integer> data; 		// ตัวแปรเก็บคิวที่ใช้สำหรับส่งข้อมูล
	
	  // คอนสตรัคเตอร์สำหรับรับคิว
	public Producer(BlockingQueue<Integer> data) {
		this.data = data;
	}
	
	@Override
	public void run() {

		// สร้างอินสแตนซ์ของ ThreadLocalRandom สำหรับการสุ่มค่า
		ThreadLocalRandom rnd = ThreadLocalRandom.current();
		
		while(true) {
			
			try {
				int value = rnd.nextInt();
				Thread.sleep(1000);
				
//				data.put(value);
//				System.out.println("Daten produziert und übergeben: " + value);
				
				 // กำหนด timeout เป็น 1000 มิลลิวินาที
				long timeout = 1000;
				TimeUnit unit = TimeUnit.MILLISECONDS;
				
				 // ใช้ offer เพื่อพยายามเพิ่มค่าในคิว ถ้าคิวเต็มจะคืนค่าผลลัพธ์ว่าเพิ่มข้อมูลได้หรือไม่
				boolean result = data.offer(value, timeout, unit);
				
				if(result) {
					System.out.println("Daten produziert und übergeben");
				} else {
					System.out.println("Daten produziert  aber verworfen");
				}

				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

//คลาส Consumer ที่ทำหน้าที่ดึงข้อมูลจากคิวและใช้ข้อมูลนั้น
class Consumer implements Runnable {
	
	private BlockingQueue<Integer> data; // ตัวแปรเก็บคิวที่ใช้สำหรับดึงข้อมูล
	
	public Consumer(BlockingQueue<Integer> data) {
		this.data = data;
	}

	@Override
	public void run() {
		while(true) {
			try {
//				Integer e = data.take();
//				System.out.println("konsumiert: " + e);
				
				  // กำหนด timeout เป็น 500 มิลลิวินาที
				long timeout = 500;
				TimeUnit unit = TimeUnit.MILLISECONDS;
				
				// ใช้ poll เพื่อลองดึงข้อมูลจากคิว ถ้าคิวว่างจะรอจนกว่าจะมีข้อมูลหรือหมดเวลา
				Integer e = data.poll(timeout, unit);
				
				if(e!=null) {
					System.out.println("konsumiert: " + e);
				} else {
					System.out.println("keine neuen Daten in der Zeit erschienen");
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class TestBlockingQueue {

	public static void main(String[] args) {
		
		 // สร้าง ArrayBlockingQueue ขนาด 1000 สำหรับเก็บข้อมูล
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1000);

		Runnable producerTask = new Producer(queue);
		new Thread(producerTask).start();
		
		Consumer consumerTask1 = new Consumer(queue);
		new Thread(consumerTask1).start();
		
		Consumer consumerTask2 = new Consumer(queue);
		new Thread(consumerTask2).start();

	}

}