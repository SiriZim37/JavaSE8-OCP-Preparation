package set;

import java.util.HashSet;
import java.util.Set;

/*
	 สรุป
	ทำไมต้องมี equals และ hashCode?
	
	เพื่อให้ HashSet ทำงานได้ถูกต้องและหลีกเลี่ยงการเพิ่มออบเจ็กต์ซ้ำ
	equals ใช้เปรียบเทียบออบเจ็กต์ในเชิงเนื้อหา
	hashCode ช่วย HashSet ระบุกลุ่มของออบเจ็กต์ก่อนการตรวจสอบรายละเอียด
	ข้อดีของ hashCode ที่คำนวณจากคุณสมบัติ
	
	ทำให้ HashSet มีประสิทธิภาพสูงขึ้น เพราะลดการชนกัน (hash collision)
 */

class Tier{
	
	String name;
	int alter;
		
	public Tier(String name, int alter) {

		this.name = name;
		this.alter = alter;
	
	}

	public String toString() {
		return this.name + " (" + alter + ")";
	}
		

	 @Override
	public boolean equals(Object obj) {
		if (this == obj) return true; // ตรวจสอบว่าคือออบเจ็กต์เดียวกัน
	    if (obj == null || getClass() != obj.getClass()) return false; // ตรวจสอบคลาส
	     
		/*
		 * equals vergleicht Tiere nach Inhalten
		 */
		Tier t2 = (Tier) obj;
		return name.equals(t2.name) && alter == t2.alter;
	}
	
	/*
	 * hashCode() in Java gibt einen ganzzahligen Wert (Integer) zurück  จะคืนค่าเป็นตัวเลขจำนวนเต็ม (Integer) 
	 * 		1.	การทำงานร่วมกับ equals() Kombination mit equals() 
	 * 			ถ้าออบเจ็กต์สองตัวถือว่าเท่ากันตามเมธอด equals() ออบเจ็กต์ทั้งสองจะต้องคืนค่า hashCode ที่เหมือนกัน "เสมอ" 
	 * 			แต่ในทางกลับกัน ถ้าออบเจ็กต์สองตัวมีค่า hashCode เหมือนกันไม่ได้หมายความว่าออบเจ็กต์จะต้องเท่ากัน 
	 * 			ซึ่งสถานการณ์นี้เรียกว่า Hash Collision หรือการชนกันของแฮช
	 * 
	 * 		2.	ความสำคัญในโครงสร้างข้อมูลที่ใช้แฮช (Wichtigkeit in Hash-basierten Datenstrukturen:): 
	 * 			ในโครงสร้างข้อมูล เช่น HashSet, HashMap, หรือ Hashtable จะใช้ hashCode() และ equals() 
	 * 			ร่วมกันเพื่อตรวจสอบว่าออบเจ็กต์สองตัวเหมือนกันหรือไม่ โดย hashCode() จะถูกเรียกใช้ก่อนเพื่อค้นหากลุ่มที่เป็นไปได้ แล้วจึงใช้ equals() 
	 * 			เพื่อตรวจสอบว่าออบเจ็กต์นั้นเป็นออบเจ็กต์ที่เหมือนกันจริงหรือไม่
	 * 
	 * 		3.  การเพิ่มประสิทธิภาพ: Prüfung der Gleichheit: 
	 * 			เมธอด hashCode() วรได้รับการออกแบบให้มีการกระจายค่าที่สม่ำเสมอเพื่อหลีกเลี่ยงการชนกันของแฮช 
	 * 			ซึ่งจะทำให้การจัดเก็บและการค้นหาในโครงสร้างข้อมูลแฮชมีประสิทธิภาพมากขึ้น
	 */
	// เมธอด hashCode เพื่อการทำงานของ HashSet ที่ถูกต้อง
	 
	 /*
	  * Korrekte hashCode : 
	  * 	-	gleiche Objekte haben delselben HashCode
	  * Sinnvolle hashCode :
	  * 	- HashCode aus den Attribute berechnen , 
	  * 	  die in der equals zum Vergleichen wervendet werden. 
	  */
    @Override
    public int hashCode() {
//    	return 7 ; // korrekt , aber nicht sinnvoll	
    				// -	ประสิทธิภาพต่ำลง: เมื่อออบเจ็กต์ทั้งหมดใช้ Bucket เดียวกัน 
    				//		โครงสร้างข้อมูลจะต้องใช้เมธอด equals() เพื่อตรวจสอบออบเจ็กต์ทุกครั้งว่าซ้ำหรือไม่
    				// -	การใช้แฮชโค้ด 7 สำหรับทุกออบเจ็กต์จะไม่ทำให้เกิดการกระจายนี้
    	
    	// แม้ว่า return 7; จะถูกต้องทางไวยากรณ์ แต่ในเชิงการทำงานจะทำให้ประสิทธิภาพลดลง 
    	// ดังนั้นควรคำนวณค่าแฮชโค้ดตามแอตทริบิวต์ของออบเจ็กต์เพื่อให้เกิดการกระจายที่ดีในโครงสร้างข้อมูลแฮช
    	
    	//** ใช้แอตทริบิวต์ในการคำนวณค่าแฮชโค้ด
        return name.hashCode() + alter; // Kombination von Name und Alter zur Erzeugung eines eindeutigen Hashcodes
        								// ใช้ชื่อและอายุในการคำนวณค่าแฮชโค้ดที่ไม่ซ้ำกัน
    }
		
}

public class B03_HashSetMitTieren {

	public static void main(String[] args) {
		
		Set<Tier> set = new HashSet<Tier>();
		
		Tier t1 = new Tier("Tom", 5);
		
		set.add(t1);
		set.add(t1);
		
		System.out.println("a. size: " + set.size());	// 1 
		
		set.add(new Tier("Jerry", 7));
		
		System.out.println("b. size: " + set.size());	// 2
		
		/*
		 * Bevor hasCode und equal() implmentiert wurden.
		 */
		set.add(new Tier("Tom", 5));
		System.out.println("c. size: " + set.size());	// 3
		//เพราะ HashSet จะใช้ Object.hashCode และ Object.equals (ค่าเริ่มต้น) ซึ่งออบเจ็กต์ใหม่จะถูกมองว่าเป็นออบเจ็กต์ที่แตกต่าง
		//HashSet จะมองว่าออบเจ็กต์นี้เหมือนออบเจ็กต์ที่มีอยู่แล้วในเซ็ต และจะไม่เพิ่มเข้าไป
		/*
		 * เพื่อให้โค้ดในตัวอย่างของคุณแสดงขนาดเป็น 2 ในขั้นตอน "c" (แทนที่จะแสดงเป็น 3), 
		 * คุณต้องทำให้แน่ใจว่าได้เขียนเมธอด equals() และ hashCode() ในคลาส Tier อย่างถูกต้อง 
		 * ในโค้ดปัจจุบันคุณเริ่มต้นการเขียนเมธอด equals() แล้ว แต่ยังไม่เสร็จสมบูรณ์ 
		 * และยังไม่มีการเขียนเมธอด hashCode() ซึ่งเป็นสิ่งจำเป็นสำหรับการทำงานของ HashSet
		 * 
		 * วิธีการแก้ไข:
		 * 		1.	เขียนเมธอด equals() ให้สมบูรณ์: ให้ตรวจสอบชื่อ (name) และอายุ (alter) ของวัตถุ
		 * 		2.	เขียนเมธอด hashCode(): เพื่อให้ HashSet ใช้ในการจัดเก็บวัตถุอย่างถูกต้อง
		 */
		
		/*
		 * Nach dem hasCode und equal() implmentiert wurden.
		 */
		set.add(new Tier("Tom", 5)); // จะไม่ถูกเพิ่มเพราะเป็นตัวเดียวกับที่มีอยู่แล้ว
		
		System.out.println("d. size: " + set.size());	// 2
		
		
	}

}
