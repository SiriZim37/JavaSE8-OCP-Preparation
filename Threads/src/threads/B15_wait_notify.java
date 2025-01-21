package threads;

import java.time.LocalTime;

import org.junit.platform.commons.function.Try;

import aufgaben.MyThreadUtils;
/*
 * wait และ notify เป็นส่วนหนึ่งของการจัดการการทำงานแบบหลายเธรด (Multithreading) 
 * ซึ่งเกี่ยวข้องกับการควบคุมการสื่อสารระหว่างเธรดที่ทำงานร่วมกัน โดยเฉพาะในกรณีที่ต้องการหลีกเลี่ยงปัญหา Busy Waiting
 * หรือการรอคอยโดยใช้ทรัพยากรมากเกินไป เช่นในกรณีที่เธรดหนึ่งกำลังรอข้อมูลจากอีกเธรดหนึ่ง
 * 
 * ความเข้าใจเกี่ยวกับ wait และ notify ใน Java SE 8 (OCP):
 * ใน Java SE 8 เทคนิค wait และ notify เป็นส่วนหนึ่งของการจัดการการทำงานแบบหลายเธรด (Multithreading)
 * ซึ่งเกี่ยวข้องกับการควบคุมการสื่อสารระหว่างเธรดที่ทำงานร่วมกัน โดยเฉพาะในกรณีที่ต้องการหลีกเลี่ยงปัญหา Busy Waiting 
 * หรือการรอคอยโดยใช้ทรัพยากรมากเกินไป เช่นในกรณีที่เธรดหนึ่งกำลังรอข้อมูลจากอีกเธรดหนึ่ง
 * 
 * wait และ notify คืออะไร?
 * 1. wait:
 *    - เป็นเมธอดของคลาส Object ใช้สำหรับทำให้เธรดที่กำลังทำงานเข้าสู่สถานะ "รอ" (Waiting State) จนกว่าจะได้รับการปลุกจากเธรดอื่น
 *    - เมื่อเธรดเรียกใช้ wait จะ:
 *      - ปล่อยล็อกที่ครอบครอง (Monitor Lock) ให้เธรดอื่นเข้ามาใช้งานทรัพยากรได้
 *      - รอจนกว่าเธรดอื่นจะเรียกใช้ notify หรือ notifyAll
 * 
 * 2. notify:
 *    - เป็นเมธอดของคลาส Object ใช้สำหรับปลุกเธรดที่อยู่ในสถานะรอ (Waiting State) ให้กลับมาทำงาน
 *    - ถ้ามีหลายเธรดที่รออยู่ notify จะปลุกเพียงหนึ่งเธรด ในขณะที่ notifyAll จะปลุกทุกเธรดที่กำลังรอ
 * 
 * notify():
 * ใช้เพื่อปลุก เธรดหนึ่งตัว ที่รออยู่ในบล็อก synchronized (รอการรับข้อมูลหรือทรัพยากรที่ล็อกอยู่)
 * ถ้ามีหลายเธรดที่รออยู่ notify() จะปลุกแค่ เธรดแรก ที่รออยู่ในคิว
 * เป็นวิธีที่ใช้เมื่อเราต้องการปลุกเธรดเพียงตัวเดียว เช่น ในกรณีที่ข้อมูลที่รอคอยมีเพียงพอแล้วให้เธรดหนึ่งทำงานต่อไป
 * 
 * notifyAll():
 * ใช้เพื่อปลุก ทุกเธรด ที่รออยู่ในบล็อก synchronized
 * เมื่อเรียก notifyAll(), เธรดทั้งหมดที่รออยู่จะได้รับการปลุกให้ลองทำงานต่อ
 * เหมาะสมในกรณีที่เราต้องการให้ทุกเธรดที่รออยู่ได้รับข้อมูลหรือการแจ้งเตือน เพื่อให้ทุกเธรดมีโอกาสทำงาน
 * 
 * การใช้งาน wait และ notify:
 * ข้อกำหนดสำคัญ:
 * 1. ต้องใช้ในบล็อก synchronized เท่านั้น:
 *    - การเรียก wait หรือ notify จำเป็นต้องครอบคลุมด้วย synchronized เพื่อป้องกันปัญหา Race Condition (การเข้าถึงทรัพยากรพร้อมกัน)
 * 2. Monitor Lock:
 *    - เธรดที่ใช้ wait จะปล่อยล็อก และเธรดอื่นที่เรียกใช้ notify ต้องครอบครองล็อกนี้
 * 
 * 
 * โค้ดนี้เป็นตัวอย่างของการทำงานแบบหลายเธรด (Multithreading) โดยมีสองคลาสหลักคือ 
 * Producer และ Consumer ซึ่งทำงานร่วมกันในลักษณะการผลิตและบริโภคข้อมูล แต่โค้ดนี้ 
 * ไม่มีการใช้เทคนิค wait/notify ทำให้เกิดปัญหา Busy Waiting หรือการรอคอยโดยไม่ประสิทธิภาพ 
 * เนื่องจากเธรด Consumer จะวนลูปเพื่อตรวจสอบข้อมูลตลอดเวลา
 * 
 * อธิบายการทำงาน:
 * 
 * 1. การทำงานของ Producer:
 *    - Producer เป็น Thread ที่ทำหน้าที่สร้างข้อมูลใหม่ (data) ทุก ๆ 2 วินาที
 *    - ข้อมูลที่สร้างขึ้นจะอยู่ในรูปแบบ "Neue Daten von <เวลา>" โดยใช้ LocalTime.now() 
 *      เพื่อบันทึกเวลาปัจจุบัน
 *    - เมธอดสำคัญของ Producer:
 *      - `getData()`: คืนค่าข้อมูลล่าสุดและตั้งค่า `data` ให้เป็น null
 *      - `hasData()`: ตรวจสอบว่ามีข้อมูลใหม่หรือไม่ (คืนค่า true หาก `data` ไม่ใช่ null)
 * 
 * 2. การทำงานของ Consumer:
 *    - Consumer เป็น Thread ที่ทำหน้าที่ตรวจสอบข้อมูลจาก Producer
 *    - ถ้าพบว่ามีข้อมูลใหม่ (จาก `hasData()`):
 *      - ดึงข้อมูลโดยใช้ `getData()` และพิมพ์ข้อความว่า "Consumer hat NEUE DATEN erhalten"
 *    - ถ้าไม่มีข้อมูลใหม่:
 *      - พิมพ์ข้อความว่า "Consumer hat nichts neues gefunden"
 *    - Consumer จะวนลูปเช็คข้อมูลตลอดเวลา ซึ่งเป็นต้นเหตุของปัญหา Busy Waiting
 * 
 * 3. ปัญหาที่เกิดขึ้นในโค้ด:
 *    - Consumer ใช้ Busy Waiting โดยวนลูปตรวจสอบ `hasData()` ซ้ำไปมา 
 *      แม้ว่าข้อมูลยังไม่พร้อมใช้งาน
 *    - การวนลูปนี้ทำให้ CPU ถูกใช้งานตลอดเวลาโดยไม่จำเป็น ส่งผลให้ประสิทธิภาพระบบลดลง
 * 
 * 4. วิธีแก้ไข:
 *    สามารถใช้เทคนิค wait/notify เพื่อแก้ปัญหา Busy Waiting ดังนี้:
 *    - ใช้ `wait()` เพื่อให้ Consumer รอจนกว่า Producer จะสร้างข้อมูลใหม่
 *    - ใช้ `notify()` ใน Producer เพื่อปลุก Consumer เมื่อข้อมูลใหม่พร้อมใช้งาน
 * 
 * การปรับปรุงโค้ด (wait/notify):
 * 
 * 1. เพิ่ม synchronized:
 *    - ใช้ `synchronized` เพื่อป้องกันการเข้าถึงตัวแปร `data` พร้อมกันจากทั้งสองเธรด
 * 
 * 2. เพิ่มการแจ้งเตือน:
 *    - Producer เรียก `notify()` หลังจากสร้างข้อมูลใหม่
 *    - Consumer เรียก `wait()` หากไม่มีข้อมูลใหม่และต้องรอจนกว่า Producer จะสร้างข้อมูล
 */


class Producer implements Runnable{
	private String data;
	
	@Override
	public void run() {
		while(true) {
			System.out.println("Producer produziert...");
			MyThreadUtils.pause(2000);
			
			synchronized(this) {
				data = "Neue Daten von " + LocalTime.now();
				this.notifyAll();
			}
		}
	}
	
	public String getData() {
		String tmp = data;
		data = null;
		return tmp;
	}
	public boolean hasData() {
		return data != null;
	}
	
	
}

class Consumer implements Runnable{
	Producer producer;
	
	public Consumer(Producer producer) {
		this.producer = producer;
	}
	
	@Override
	public void run() {
		while(true) {	
			synchronized (producer) {
				Thread curThread = Thread.currentThread();
				if(producer.hasData()) {
					String data = producer.getData();
					System.out.println(curThread.getName() + " Consumer hat NEUE DATEN erhalten " +data);
				}else {
					System.out.println(curThread.getName() + " Consumer hat nichts neues gefunden");
					try {
						producer.wait();
//						"".wait();			//IllegalMonitorStateException
					}catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
		}
	}
	
}

public class B15_wait_notify {
	/*
	 * wait/notify-Technik ist unwahrscheinlich in der Prüfung
	 * 
	 * Regeln:
	 * 
	 *   - wait, notify und notifyAll sind Methoden der Klasse Object
	 *   - wait, notify und notifyAll müssen aus einem synchronized-Block
	 *     aufgerufen werden.
	 *   - in der wait gibt der Thread den Lock ab 
	 */
	public static void main(String[] args) {

		Producer prodA = new Producer();
		Consumer consumA = new Consumer(prodA);
		Consumer consumB = new Consumer(prodA);
		
		new Thread(prodA).start();
		new Thread(consumA , "A").start();
		new Thread(consumB , "B").start();
		
		System.out.println("End");
	}

}
