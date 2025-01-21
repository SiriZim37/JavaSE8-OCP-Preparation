package threads;


class ValueHolder {
    private int value;

    /*
     * Die Lösung ist gut:
     * 
     *  ใช้ synchronized (StaticValueHolder.class) เพื่อซิงโครไนซ์การเข้าถึงตัวแปร value
     *  โดยใช้อ็อบเจ็กต์ StaticValueHolder.class เป็นล็อก
     */
    // void inc() {
    //     synchronized (this) {
    //         value++;
    //     }
    // }

    /*
     * Dieselbe Lösung kompakter:
     * 
     * Wenn eine Methode synchronized ist, wird der Rumpf der Methode mit "this" synchronisiert.
     * 
     * เมธอด inc() ถูกทำให้เป็น synchronized ซึ่งหมายความว่าในเมื่อเมธอดนี้เป็น synchronized
     * การซิงโครไนซ์จะเกิดขึ้นโดยอัตโนมัติ โดยที่ล็อกจะถูกใช้กับอินสแตนซ์ของคลาสนี้ (this)
     */
    synchronized void inc() {
        value++;  // เพิ่มค่าของ value อย่างปลอดภัย
    }

    public int getValue() {
        return value;  // คืนค่าของ value
    }

}

/*
 * การใช้ synchronized ทำให้สามารถควบคุมการเข้าถึงตัวแปรภายในคลาส (instance variable) 
 * โดยการล็อกที่ "ระดับอินสแตนซ์" แทนที่จะเป็น "ระดับคลาส"
 * 
 * ทำไมต้องใช้ synchronized:
 * เนื่องจาก value เป็นตัวแปรที่สามารถถูกเข้าถึงและแก้ไขได้จากหลายเธรด
 * หากไม่มีการซิงโครไนซ์ เธรดหลายตัวอาจจะเข้าถึงและเปลี่ยนแปลงค่าของ value 
 * พร้อมกัน ซึ่งอาจทำให้เกิด race condition และค่าของ value ที่ไม่ถูกต้อง
 * 
 * การใช้ synchronized ทำให้มั่นใจได้ว่าในแต่ละครั้ง จะมีแค่เธรดเดียวที่สามารถเข้าถึงเมธอด inc()
 * และเพิ่มค่า value ได้ ซึ่งจะช่วยป้องกันปัญหา race condition นี้
 */

public class B14_Instanzmethode_snynchronizieren {
	
	public static void main(String[] args) throws InterruptedException {
		
		ValueHolder vh1 = new ValueHolder();
		ValueHolder vh2 = new ValueHolder();
		
		// สร้างงาน (task) สำหรับเพิ่มค่า value ใน vh1 1,000,000 ครั้ง
		Runnable taskA = () -> {
			for (int i = 0; i < 1_000_000; i++) {
				vh1.inc();   			// เรียกใช้ inc() เพื่อเพิ่มค่า value ใน vh1
			}
		};
		
		/*
		 * t1 und t2 ändern value aus vh1
		 */
		Thread t1 = new Thread(taskA); 
		Thread t2 = new Thread(taskA); 

		
		//-----------------------------------------------------------
		 // สร้างงาน (task) สำหรับเพิ่มค่า value ใน vh2 1,000,000 ครั้ง
		Runnable taskB = () -> {
			for (int i = 0; i < 1_000_000; i++) {
				vh2.inc();
			}
		};
		
		/*
		 * t3 ändert value aus vh2
		 * 
         * t3 จะทำงานและเปลี่ยนแปลงค่า value ใน vh2
		 */
		Thread t3 = new Thread(taskB); 

		 // เริ่มทำงานของทุกเธรด
		t1.start(); 
		t2.start(); 
		t3.start();
		
		// รอจนกว่าเธรดทั้งหมดจะทำงานเสร็จ
		t1.join(); 
		t2.join(); 
		t3.join();
		
		
	     // พิมพ์ค่าของ value ใน vh1 และ vh2 หลังจากทั้งสองเธรดทำงานเสร็จ
        System.out.println("value: " + vh1.getValue());  // ค่าของ value ใน vh1
        System.out.println("value: " + vh2.getValue());  // ค่าของ value ใน vh2
	}
}
