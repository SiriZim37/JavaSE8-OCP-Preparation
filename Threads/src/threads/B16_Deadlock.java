package threads;

/*
 * Deadlock (การล็อกตาย) เกิดขึ้นเมื่อสองเธรด (A และ B) พยายามเข้าถึงทรัพยากรที่ถูกล็อกในลำดับที่ขัดแย้งกัน
 * ทำให้เกิดวงจรที่ไม่สามารถออกจากสถานะได้ เนื่องจากเธรดแต่ละตัวต้องการทรัพยากรที่ถูกล็อกโดยเธรดอื่น
 * การทำงานของโค้ด:
 * Deadlock class:
 * - มีการสร้างสองวัตถุ m1 และ m2 ซึ่งจะใช้เป็นตัวล็อกในบล็อก synchronized
 * - ใน run() method เธรดจะพยายามล็อก m1 และจากนั้นล็อก m2
 * - หลังจากนั้นเธรดจะพยายามล็อก m2 และล็อก m1 ต่อ ซึ่งเป็นการขัดแย้งกับการล็อกที่เกิดขึ้นในขั้นตอนก่อนหน้า
 * ใน main() method:
 * - สร้าง Runnable task ที่เป็น instance ของ Deadlock
 * - สร้างสองเธรด (A และ B) และให้ทำงานด้วย task
 * - ทั้งสองเธรดจะทำงานพร้อมกัน และพยายามล็อก m1 และ m2 สลับกัน
 *
 * ตัวอย่าง Deadlock:
 * - เธรด A เข้าถึง m1 และพยายามเข้าถึง m2
 * - เธรด B เข้าถึง m2 และพยายามเข้าถึง m1
 * สถานการณ์นี้จะทำให้ทั้งสองเธรดหยุดนิ่งเนื่องจากพวกเขารอการเข้าถึงทรัพยากรที่กันและกันครอบครองอยู่
 * เรียกว่า Deadlock
 *
 * วิธีการหลีกเลี่ยง Deadlock:
 *
 * 1. ใช้ tryLock() เพื่อล็อกทรัพยากรโดยไม่ต้องรอ:
 * - ถ้าไม่สามารถล็อกได้ทันที เธรดจะไม่ค้างและสามารถทำงานต่อไปได้
 * - การใช้ tryLock() ช่วยลดปัญหาการค้างของเธรดที่อาจเกิดจากการรอทรัพยากร
 * - ถ้าเธรดหนึ่งไม่สามารถล็อกทรัพยากรได้ มันก็จะดำเนินการในงานอื่น ๆ ได้แทน โดยไม่ต้องรอให้ทรัพยากรถูกปลดล็อก
 *
 * 2. ใช้ wait/notify เพื่อควบคุมการสื่อสารระหว่างเธรด:
 * - ถ้าเธรดหนึ่งต้องการทรัพยากรที่ถูกล็อก มันจะเรียก wait() เพื่อรอการปลดล็อก
 * - เมื่อเธรดอื่นปลดล็อกทรัพยากรแล้ว มันจะใช้ notify() เพื่อปลุกเธรดที่รอให้ทำงานต่อ
 * - วิธีนี้ช่วยป้องกันการใช้ทรัพยากรโดยไม่จำเป็น (Busy Waiting) และทำให้เธรดสามารถทำงานได้อย่างมีประสิทธิภาพ
 */

class Deadlock implements Runnable {
	static Object m1 = new Object();
	static Object m2 = new Object(); 
	
	@Override
	public void run() {
		synchronized (m1) {
			System.out.println("m1");
			//Thread 2 kommt hier an und hat den Lock auf m1
			synchronized (m2) {
				System.out.println("m1.m2");
			}
		}
		synchronized (m2) {
			System.out.println("m2");
			
			//Thread 1 kommt hier an und hat den Lock auf m2
			synchronized (m1) {
				System.out.println("m2.m1");
			}
		}
	}
	
} 
/*
 * Ausgaabe :
 * Deadlock : m1					   Normal : m1
 * 			  m1.m2							 	m1.m2
 * 			  m2								m2
 * 			  m1								m2.m1
 * 							  					m1
 * 												m1.m2
 * 												m2
 * 												m2.m1
 */

public class B16_Deadlock {

	/*
	 * Achtung! Deadlock potentiell möclich ist,
	 * soll der Code der Anwendung geändert werden!
	 */
	public static void main(String[] args) {
		
		Runnable task = new Deadlock();
		
		new Thread(task , "A").start();
		new Thread(task , "B").start();
	}
}
