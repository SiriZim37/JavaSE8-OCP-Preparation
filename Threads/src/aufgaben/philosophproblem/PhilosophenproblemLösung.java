package aufgaben.philosophproblem;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// คลาสสำหรับนักปรัชญา ที่จะทำหน้าที่เป็น Thread
class Philosoph extends Thread {
    private String name; // ชื่อของนักปรัชญา
    private Lock leftLock; // ตัวล็อก (กุญแจ) สำหรับส้อมด้านซ้าย
    private Lock rightLock; // ตัวล็อก (กุญแจ) สำหรับส้อมด้านขวา

    // ตัวสร้างที่รับชื่อของนักปรัชญา
    public Philosoph(String name) {
        this.name = name;
    }

    // ตัวสร้างที่รับชื่อ และตัวล็อกของส้อมซ้ายและขวา
    public Philosoph(String name, Lock linkeGabel, Lock rechteGabel) {
        this.name = name;
        this.leftLock = linkeGabel;
        this.rightLock = rechteGabel;
    }

    // เมธอดสำหรับกำหนดตัวล็อกของส้อมด้านซ้าย
    public void setLeftGabel(Lock leftLock) {
        this.leftLock = leftLock;
    }

    // เมธอดสำหรับกำหนดตัวล็อกของส้อมด้านขวา
    public void setRightGabel(Lock rightLock) {
        this.rightLock = rightLock;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(name + " denkt nach..."); // นักปรัชญากำลังคิด
            Job(1000); // หยุดพักเพื่อแสดงว่าใช้เวลาในการคิด

            System.out.println(name + " hat Hunger"); // นักปรัชญาหิวแล้ว

            // พยายามล็อกส้อมด้านซ้าย
            if (leftLock.tryLock()) {
                try {
                    System.out.println(name + " nimmt die linkte Gabel..."); // หยิบส้อมซ้าย
                    // พยายามล็อกส้อมด้านขวา
                    if (rightLock.tryLock()) {
                        try {
                            System.out.println(name + " nimmt die rechte Gabel..."); // หยิบส้อมขวา
                            System.out.println(name + " isst..."); // เริ่มกินอาหาร
                            Job(3000); // ใช้เวลาในการกิน
                        } finally {
                            System.out.println(name + " legt die rechte Gabel ab..."); // วางส้อมขวา
                            rightLock.unlock();
                        }
                    } else {
                        System.out.println(name + " hat keine rechte Gabel gekriegt"); // ไม่มีส้อมขวา
                    }
                } finally {
                    System.out.println(name + " legt die linkte Gabel ab..."); // วางส้อมซ้าย
                    leftLock.unlock();
                }
            } else {
                System.out.println(name + " hat keine linke Gabel gekriegt"); // ไม่มีส้อมซ้าย
            }
        }
    }

    // เมธอดสำหรับการพัก (จำลองเวลา)
    private static void Job(long millis) {
        try {
            Thread.sleep(millis); // หยุดการทำงานของ Thread ชั่วคราว
        } catch (InterruptedException e) {
            throw new RuntimeException(e); // หากเกิดข้อผิดพลาด ให้โยน RuntimeException
        }
    }
}

public class PhilosophenproblemLösung {
	
	/* 
    สิ่งที่เกิดขึ้นในโปรแกรม
	โปรแกรมนี้จำลองปัญหาของนักปรัชญา (Dining Philosophers Problem) ซึ่งเป็นปัญหาที่มักใช้ในการศึกษาการจัดการทรัพยากรที่ใช้ร่วมกันในระบบหลายเธรด (Multithreading) โดยมีเหตุการณ์ดังต่อไปนี้:
	
	การตั้งค่าเบื้องต้น:
	- ชื่อของนักปรัชญาถูกกำหนดในอาร์เรย์ names ซึ่งประกอบด้วยชื่อของนักปรัชญาที่มีชื่อเสียง
	- นักปรัชญาจำนวน 5 คน (ตามค่าของ anzahlPlatze) ถูกสร้างขึ้นมาในรูปของออบเจ็กต์ Philosoph และเก็บไว้ในลิสต์
	- ส้อม (หรือกุญแจล็อก) ถูกสร้างขึ้นตามจำนวนที่นั่ง โดยใช้ ReentrantLock เพื่อควบคุมการเข้าถึงทรัพยากร
	
	การแจกจ่ายส้อม:
	- นักปรัชญาแต่ละคนจะได้รับส้อมด้านซ้ายและด้านขวา โดยตำแหน่งของส้อมด้านขวาถูกคำนวณให้วนกลับมาที่ส้อมแรกเมื่อถึงจุดสิ้นสุด เพื่อให้เกิดความสมดุลในการใช้ทรัพยากร
	
	การเริ่มการทำงานของนักปรัชญา:
	- นักปรัชญาแต่ละคนถูกเริ่มต้นในฐานะ Thread ผ่านคำสั่ง Thread::start
	
	พฤติกรรมของนักปรัชญาในแต่ละรอบการทำงาน:
	- คิด: นักปรัชญาจะอยู่ในสถานะ "กำลังคิด" ชั่วครู่ (Job(1000))
	- หิว: เมื่อหิว นักปรัชญาจะพยายามหยิบส้อม
	    - หากสามารถล็อกส้อมด้านซ้ายได้ จะพยายามล็อกส้อมด้านขวา
	    - หากล็อกส้อมทั้งสองข้างสำเร็จ นักปรัชญาจะเริ่มกินอาหาร (Job(3000))
	    - เมื่อกินเสร็จ นักปรัชญาจะปลดล็อกส้อมทั้งสองข้าง
	    - หากไม่สามารถล็อกส้อมข้างใดข้างหนึ่งได้ จะปลดล็อกส้อมข้างที่ล็อกได้ (ถ้ามี) และเริ่มรอบใหม่
	
	การแก้ปัญหาความขัดแย้ง (Deadlock):
	- โปรแกรมใช้ tryLock() แทนการล็อกปกติ (lock()) เพื่อป้องกันปัญหา Deadlock ซึ่งจะเกิดขึ้นเมื่อทุกคนพยายามล็อกส้อมพร้อมกันและไม่มีใครสามารถกินอาหารได้
	
	ผลลัพธ์ที่แสดงออก:
	- โปรแกรมจะพิมพ์ข้อความแสดงสถานะของนักปรัชญาแต่ละคน เช่น "กำลังคิด", "หิว", "หยิบส้อม", "กำลังกิน", และ "วางส้อม" อย่างต่อเนื่อง
	
	จุดเด่น:
	- ใช้ ReentrantLock และ tryLock() เพื่อแก้ปัญหาทรัพยากรที่ใช้ร่วมกัน
	- ใช้โครงสร้างข้อมูล List และ Stream API ในการสร้างและแจกจ่ายทรัพยากรอย่างมีประสิทธิภาพ
	
	จุดที่ควรระวัง:
	- ถึงแม้จะหลีกเลี่ยง Deadlock ได้ แต่โปรแกรมอาจประสบปัญหา Starvation หากนักปรัชญาคนหนึ่งไม่ได้รับโอกาสใช้ทรัพยากรในระยะยาว
	*/

	
    // ชื่อของนักปรัชญา
    private static final String[] names = {
        "Sokrates", "Platon", "Aristoteles", "Bacon",
        "Descartes", "Hegel", "Kant", "Konfuzius"
    };

    public static void main(String[] args) {
        int anzahlPlatze = 5; // จำนวนที่นั่งของนักปรัชญา

        // สร้างลิสต์ของนักปรัชญาจากชื่อ และจำกัดจำนวนตามที่นั่ง
        List<Philosoph> philosophen = Arrays.stream(names)
                .limit(anzahlPlatze)
                .map(Philosoph::new) // สร้างออบเจ็กต์นักปรัชญา
                .collect(Collectors.toList());

        // สร้างลิสต์ของล็อกสำหรับส้อม (กุญแจ)
        List<Lock> gabeln = Stream.generate(ReentrantLock::new) // สร้าง ReentrantLock
                .limit(anzahlPlatze)
                .collect(Collectors.toList());

        // แจกจ่ายล็อกให้กับนักปรัชญาแต่ละคน
        for (int index = 0; index < anzahlPlatze; index++) {
            Philosoph p = philosophen.get(index);

            p.setLeftGabel(gabeln.get(index)); // ตั้งค่าล็อกของส้อมด้านซ้าย
            int indexRechteGabel = (index + 1) % anzahlPlatze; // คำนวณตำแหน่งของส้อมด้านขวา (วนรอบ)
            p.setRightGabel(gabeln.get(indexRechteGabel)); // ตั้งค่าล็อกของส้อมด้านขวา
        }

        // เริ่มการทำงานของ Thread สำหรับนักปรัชญาแต่ละคน
        philosophen.forEach(Thread::start);
    }
}
