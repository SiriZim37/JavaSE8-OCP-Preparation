package threads;

import java.util.concurrent.ConcurrentHashMap;

public class ThreadsConcurrentHashMap {

	/*
	 * 
	 * 		Welche Methode would delete John from the map onöy of his values was still equal to 23 ?
	 */
	public static void main(String[] args) {
		
		ConcurrentHashMap<String,Integer> ages = new ConcurrentHashMap();
		ages.put("John",23);
		
		 System.out.println(ages);
		
		//****** 
		
		 // ลบ John ออกจาก Map ถ้าค่าปัจจุบันยังเป็น 23
        boolean isRemoved = ages.remove("John", 23);

        // ตรวจสอบว่าลบสำเร็จหรือไม่
        if (isRemoved) {
            System.out.println("John ถูกลบออกจาก Map");
        } else {
            System.out.println("John ไม่ถูกลบ เพราะค่าไม่ตรงกัน");
        }

        // แสดง Map หลังลบ
        System.out.println("หลังลบ: " + ages);
		
	}
	
	/*
	 * หากต้องการลบคีย์ "John" ออกจาก ConcurrentHashMap แต่มีเงื่อนไขว่า ค่าของ John ต้องเท่ากับ 23 เท่านั้น 
	 * สามารถใช้ remove(Object key, Object value) เมธอดได้
	 * 
	 * คำอธิบายเมธอด remove(Object key, Object value)
	 * เมธอดนี้จะทำการลบข้อมูล (key, value) ออกจาก ConcurrentHashMap ก็ต่อเมื่อ ค่าปัจจุบันของ key ตรงกับค่า (value) ที่กำหนดไว้
	 * หากค่าที่กำหนดไม่ตรงกับค่าปัจจุบันของ key นั้น จะไม่มีการลบใดๆ เกิดขึ้น
	 */
}
