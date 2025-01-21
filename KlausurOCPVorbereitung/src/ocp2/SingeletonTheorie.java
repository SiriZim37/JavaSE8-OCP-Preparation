package ocp2;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class SingeletonTheorie {

	/*
	 
		  You want to create a singleton class by using the Singleton design pattern. 
		  Which two statements enforce the singleton nature of the design? (Choose two.)
		 A. Make the class static.
		 B. Make the constructor private.
		 C. Override equals() and hashCode() methods of the java.lang.Object class.
		 D. Use a static reference to point to the single instance.
		 E. Implement the Serializable interface.
 
 
 
		 
		คำอธิบาย:
		ความเข้าใจเกี่ยวกับ Singleton Design Pattern:
		Singleton เป็นรูปแบบการออกแบบ (Design Pattern) ที่ช่วยให้คลาสสร้างอินสแตนซ์ได้เพียงแค่หนึ่งครั้งเท่านั้นตลอดการทำงานของโปรแกรม
		ให้จุดเข้าถึง (Access Point) ที่เป็นแบบ Global สำหรับการใช้งานอินสแตนซ์นี้
		
		คำตอบที่ถูกต้อง:
		B. Make the constructor private:
		การทำให้คอนสตรัคเตอร์เป็น private จะป้องกันไม่ให้คลาสอื่นสร้างอินสแตนซ์ใหม่ของคลาส Singleton ได้ ซึ่งเป็นการบังคับให้มีอินสแตนซ์เดียว
		
		D. Use a static reference to point to the single instance:
		ต้องใช้ตัวแปร static เพื่อเก็บอ้างอิงไปยังอินสแตนซ์ของคลาส
		ตัวแปรนี้ช่วยให้สามารถเข้าถึงอินสแตนซ์ได้แบบ Global โดยไม่ต้องสร้างใหม่หลายครั้ง
		
		
		
		ทำไมตัวเลือกอื่นถึงไม่ถูกต้อง:
		A. Make the class static:
		คลาสไม่สามารถทำให้เป็น static ได้ ยกเว้นคลาสที่อยู่ภายใน (Nested Class) และการทำให้คลาสเป็น static ไม่ได้ช่วยให้คลาสเป็น Singleton
		
		C. Override equals() และ hashCode():
		แม้ว่าเมธอดเหล่านี้มีประโยชน์สำหรับการเปรียบเทียบวัตถุ แต่ไม่ได้เกี่ยวข้องกับการทำให้คลาสเป็น Singleton
		
		E. Implement the Serializable interface:
		การใช้ Serializable ไม่จำเป็นสำหรับ Singleton และอาจทำให้รูปแบบ Singleton ถูกทำลายได้หากไม่มีการใช้งานเมธอด readResolve() 
		เพื่อคืนค่าอินสแตนซ์เดิมหลังการ Deserialize
		
		
		
		ตัวอย่างการใช้งาน Singleton:
		public class Singleton {
		    // ตัวแปร static สำหรับเก็บอ้างอิงของอินสแตนซ์
		    private static Singleton instance;
		
		    // คอนสตรัคเตอร์ private
		    private Singleton() {}
		
		    // เมธอด public สำหรับเข้าถึงอินสแตนซ์
		    public static Singleton getInstance() {
		        if (instance == null) {
		            instance = new Singleton();
		        }
		        return instance;
		    }
		}
		
		สรุป:
		การใช้ private constructor (B) จะป้องกันการสร้างอินสแตนซ์ใหม่จากภายนอก
		การใช้ตัวแปร static (D) จะช่วยจัดการและเข้าถึงอินสแตนซ์เดียวในโปรแกรม
		*/


	public static void main(String[] args) {
		
	
		 
	}
}

class SingletonDD {
    // ตัวแปร static สำหรับเก็บอ้างอิงของอินสแตนซ์
    private static SingletonDD instance;

    // คอนสตรัคเตอร์ private
    private SingletonDD() {}

    // เมธอด public สำหรับเข้าถึงอินสแตนซ์
    public static SingletonDD getInstance() {
        if (instance == null) {
            instance = new SingletonDD();
        }
        return instance;
    }
}

