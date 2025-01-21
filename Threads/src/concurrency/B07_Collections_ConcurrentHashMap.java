package concurrency;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class B07_Collections_ConcurrentHashMap {

	/*
	 * ConcurrentHashMap ใน Java เป็นคลาสที่ใช้เก็บข้อมูลในรูปแบบ Map 
	 * และถูกออกแบบมาเพื่อรองรับการทำงานแบบ หลายเธรด (multi-threading)
	 * โดยไม่ต้องใช้การ synchronize ทั่วทั้งแผนที่เหมือนกับ HashTable ซึ่งทำให้มีประสิทธิภาพที่ดีกว่าเมื่อมีหลายเธรดทำงานพร้อมกัน
	 * 
	 * ข้อจำกัดของ ConcurrentHashMap
	 * - ไม่รองรับ null key และ null valu
	 * - ไม่ได้เป็นแบบ fully synchronized ดังนั้นหากต้องการความปลอดภัยระดับสูงกว่านี้ ต้องใช้วิธีอื่น เช่น Collections.synchronizedMap()
	 */

	public static void main(String[] args) {
		// สร้าง ConcurrentHashMap
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        // เพิ่มข้อมูลเข้าไปใน Map
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        // แสดงค่าทั้งหมด
        System.out.println("Initial Map: " + map);

        // ใช้งานหลายเธรดพร้อมกัน
        Runnable task1 = () -> map.put("D", 4);
        Runnable task2 = () -> map.put("E", 5);

        // สร้างเธรด
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        // เริ่มเธรด
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // แสดงผลลัพธ์หลังจากเธรดทำงานเสร็จ
        System.out.println("Updated Map: " + map);
		
	}
}
