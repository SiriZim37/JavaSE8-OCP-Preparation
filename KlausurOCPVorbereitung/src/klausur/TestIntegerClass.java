package klausur;



/*
 Welche Entwurfsmuster realisiert die Klasse 'Integer' ? 
Eine oder mehrere richtige Antworten sind möglich.

[   ] Iterable
[ X ] Wrapper
[ X ] Immutable Objects
[   ] Singleton
 */
public class TestIntegerClass {

	public static void main(String[] args) {
		
		Integer i;
		
		
		
		/*
		 * public final class Integer extends Number
		 *      implements Comparable<Integer>, Constable, ConstantDesc
		 *      
		 * Integer ist final  (Immutable Objects)
		 */
		
		/*
		 * คุณสมบัติของคลาส Integer
		 * - Immutable Object: อ็อบเจ็กต์ของ Integer ไม่สามารถเปลี่ยนแปลงค่าได้ หากคุณต้องการเปลี่ยนค่าต้องสร้างอ็อบเจ็กต์ใหม่
		 * - Wrapper Class: ทำหน้าที่แปลงค่าประเภท primitive (int) เป็นอ็อบเจ็กต์ และรองรับฟังก์ชันเพิ่มเติม เช่น การแปลงเป็น String หรือการแปลงเลขฐาน
		 * - Caching Mechanism: Java มีการใช้กลไกแคชสำหรับค่าของ Integer ในช่วง -128 ถึง 127 เพื่อเพิ่มประสิทธิภาพ ตัวอย่าง:
		 */
   
	}
	
}
