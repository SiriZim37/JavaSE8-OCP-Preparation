package threads;


class StaticValueHolder{
	/*
	 * StaticValueHolder class: คลาสนี้มีตัวแปร value ที่เป็น static 
	 * ซึ่งหมายความว่ามันเป็นตัวแปรที่แชร์ระหว่างทุกอินสแตนซ์ของคลาสนี้ 
	 * เมธอด inc() ใช้สำหรับเพิ่มค่าของ value ทีละ 1 ทุกครั้งที่ถูกเรียกใช้
	 */
	
	
	private static int value;
	
	/*
	 * Die Lösung ist gut.
	 * 
	 * Das Class-Objekt wird empfohlen fürs Synchronisieren der
	 * Zugriffe auf statische Attribute einer Klasse.
	 * 
	 * ใช้ synchronized (StaticValueHolder.class) เพื่อซิงโครไนซ์การเข้าถึงตัวแปร value
	 * โดยใช้อ็อบเจ็กต์ StaticValueHolder.class เป็นล็อก
	 */
	
//	public static void inc() {
//		synchronized (StaticValueHolder.class) {
//			value++;
//		}
//	}
	
	
	
	/*
	 * Dieselbe Lösung kompakter:
	 * 
	 * Wenn statische Methode synchronized ist, wir der Rumpf de Methode
	 * mit dem Class-Objekt synchroniiert.
	 * 
	 * เมธอด inc() เองถูกทำให้เป็น synchronized ซึ่งหมายความว่าในเมื่อเมธอดเป็น synchronized 
	 * การซิงโครไนซ์จะเกิดขึ้นโดยอัตโนมัติ โดยที่ล็อกจะถูกใช้กับคลาส StaticValueHolder.class โดยตรง
	 */
	
	public synchronized static void inc() {
		value++;
	}
	
	public static int getValue() {
		return value;
	}
}

/*
 * การใช้ synchronized static ทำให้สามารถควบคุมการเข้าถึงตัวแปร static 
 * โดยการล็อกที่ 'ระดับคลาส' แทนที่จะเป็น 'อินสแตนซ์ของคลาส' 
 * 
 * 
 * ทำไมต้องใช้ synchronized:
 * เนื่องจาก value เป็นตัวแปร static และถูกใช้ร่วมกันระหว่างเธรดหลายตัว 
 * หากไม่มีการซิงโครไนซ์ เธรดสองตัวอาจจะเข้าถึงและเปลี่ยนแปลงค่าของ value พร้อมกัน 
 * ซึ่งจะทำให้เกิด race condition และทำให้ค่า value ที่ได้ไม่ถูกต้อง
 * 
 * การใช้ synchronized ทำให้มั่นใจว่าในแต่ละครั้งจะมีแค่เธรดเดียวที่สามารถเข้าไปในเมธอด inc() 
 * เพื่อเพิ่มค่า value ได้ ซึ่งจะช่วยป้องกันปัญหานี้
 */

public class B13_statische_Methoden_synchronisieren {

	public static void main(String[] args) throws InterruptedException {
		
		
		Runnable task = () ->{
			for (int i = 0; i < 1_000_000; i++) {
				StaticValueHolder.inc();
			}
		};
		
		Thread tA = new Thread(task); 
		Thread tB = new Thread(task); 
	
		tA.start(); 
		tB.start(); 
	
	
		tA.join(); 
		tB.join(); 
	
		System.out.println("value: " + StaticValueHolder.getValue()); 	

	}
}
