package aufgaben.philosophproblem;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.management.RuntimeErrorException;

class PhilosophDeadLock extends Thread {
    private String name;
    private Object linkeGabel; // ส้อมซ้าย
    private Object rechteGabel; // ส้อมขวา

    public PhilosophDeadLock(String name) {
        this.name = name;
    }

    public void setLinkeGabel(Object linkeGabel) {
        this.linkeGabel = linkeGabel;
    }

    public void setRechteGabel(Object rechteGabel) {
        this.rechteGabel = rechteGabel;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(name + " denkt nach...");
            Job(1000); // คิดเป็นเวลา 1 วินาที

            System.out.println(name + " hat Hunger");

            synchronized (linkeGabel) { // พยายามล็อกส้อมซ้าย
                System.out.println(name + " nimmt die linkte Gabel...");

                synchronized (rechteGabel) { // พยายามล็อกส้อมขวา
                    System.out.println(name + " nimmt die rechte Gabel...");
                    System.out.println(name + " isst...");
                    Job(3000); // กินเป็นเวลา 3 วินาที
                    System.out.println(name + " legt die rechte Gabel ab...");
                }
            }
            System.out.println(name + " legt die linkte Gabel ab...");
        }
    }

    private static void Job(long millis) {
        try {
            Thread.sleep(millis); // หยุดชั่วคราวตามระยะเวลาที่กำหนด
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


public class PhilosophenproblemDeadLock {
	 /* 
    สิ่งที่เกิดขึ้นในโปรแกรม
    สร้างนักปรัชญา (Philosophen)
    - โปรแกรมกำหนดชื่อนักปรัชญาล่วงหน้าในตัวแปร names เช่น "Sokrates", "Platon" เป็นต้น
    - ผู้ใช้สามารถกำหนดจำนวนของนักปรัชญา (anzahlPlatze) ได้ง่าย ๆ โดยเลือกจำนวนจากรายการ names
    - นักปรัชญาแต่ละคนจะถูกสร้างเป็นออบเจกต์ Philosoph และเก็บไว้ใน List<Philosoph>
    
    สร้างทรัพยากรที่ใช้ร่วมกัน (ส้อม - Gabeln)
    - ส้อมแต่ละอันถูกสร้างเป็น Object และเก็บไว้ใน List<Object> 
    - ซึ่งจำนวนส้อมจะเท่ากับจำนวนนักปรัชญา
    - นักปรัชญาแต่ละคนจะมีส้อมซ้าย (linkeGabel) และส้อมขวา (rechteGabel)
      ที่แบ่งปันกับเพื่อนบ้านของเขา
    
    จัดสรรทรัพยากร (แจกส้อม)
    - ใช้ลูปเพื่อกำหนดว่านักปรัชญาแต่ละคนจะใช้ส้อมซ้าย (linkeGabel) และส้อมขวา (rechteGabel)
    - นักปรัชญาคนสุดท้าย (index = n - 1) จะใช้ส้อมขวาจากนักปรัชญาคนแรก (index = 0) เพื่อเชื่อมวนรอบ

    การทำงานของแต่ละ Thread
    - นักปรัชญาแต่ละคนจะวนลูปทำกิจกรรมต่อเนื่อง:
      1. คิด (denken) ใช้เวลา 1 วินาที (1000 ms)
      2. หิว (hat Hunger)
      3. พยายามล็อกส้อมซ้ายและขวา (synchronized)
      4. ถ้าล็อกสำเร็จ: กิน (isst) ใช้เวลา 3 วินาที (3000 ms)
      5. ปลดล็อกส้อมขวาและซ้ายหลังจากกินเสร็จ

    เกิด Deadlock ได้อย่างไร
    - ถ้านักปรัชญาทุกคนหยิบส้อมซ้ายพร้อมกันแล้วรอส้อมขวา จะเกิด Deadlock
      เพราะทุก Thread ติดอยู่ในสถานะรอ (waiting)
    
    วิธีแก้ไข Deadlock
    - ใช้ tryLock เพื่อหลีกเลี่ยงการรอแบบไม่มีที่สิ้นสุด
    - จัดลำดับการล็อกทรัพยากรใหม่
    */
	
	private static String[] names =  {
		"Sokrates" , "Platon" , "Aristoteles" ,"Bacon" ,
		"Decartes" , "Hegel" ,"Kant" ,"Konfuziou"	
	};
	
	public static void main(String[] args) {

		int anzahlPlatze = 3; // กำหนดจำนวนของนักปรัชญา
		
		// สร้างนักปรัชญาตามจำนวนที่กำหนด
		List<PhilosophDeadLock> philosophen =  Arrays.stream(names)
											.limit(anzahlPlatze)
											.map(PhilosophDeadLock::new)
											.collect(Collectors.toList());

		
		 // สร้างทรัพยากรส้อม
		List<Object> gebeln = Stream.generate(Object::new)
									.limit(anzahlPlatze)
									.collect(Collectors.toList());
		
		// Gabeln verteilen // แจกส้อมให้นักปรัชญาแต่ละคน
		for (int index = 0; index < anzahlPlatze; index++) {
			PhilosophDeadLock p = philosophen.get(index);
			
			p.setLinkeGabel(gebeln.get(index));
			
			 // กำหนดส้อมขวา (เชื่อมวนรอบสำหรับคนสุดท้าย)
			int indexRechteGabel = index +1 ;
			if(index == anzahlPlatze -1 ) {
				indexRechteGabel = 0;	// Gabel für den letzten Philosophen
										//นักปรัชญาคนสุดท้าย (index = n - 1) จะใช้ส้อมขวาจากนักปรัชญาคนแรก (index = 0) เพื่อเชื่อมวนรอบ
			}
			
			p.setRechteGabel(gebeln.get(indexRechteGabel));
		}
		
//		Thread starten  // เริ่ม Thread ของนักปรัชญา
		philosophen.forEach(PhilosophDeadLock::start);
		
	
		
	}
//	


}
