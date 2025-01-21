package serialisieren;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class B02_BasisklasseIstNichtSerializable {

	/*
	 * Stellen wir uns vor, dass die Klasse GameObject
	 * nicht Serializable sein kann (z.B. ist Klasse aus einer externen Bibliothek).
	 */
	/*
	 * ในตัวอย่างนี้ เรามีคลาส GameObject ที่ไม่สามารถทำให้เป็น Serializable ได้ 
	 * (เช่น มาจากไลบรารีภายนอก)
	 * 
	 * คลาส Auto สืบทอดมาจาก GameObject และ implement Serializable 
	 * แต่จะมีปัญหากับ attribute ที่สืบทอดมาจาก GameObject ซึ่งไม่ใช่ Serializable
	 * 
	 * ในคลาส GameObject มี attribute id ซึ่งไม่ถูก serialize เมื่อทำการ serialize อ็อบเจ็กต์ a1 
	 * ของคลาส Auto เนื่องจาก GameObject ไม่ได้ implement Serializable 
	 * ดังนั้น attribute id จะถูกมอบค่าเริ่มต้น (ค่าเริ่มต้นของ int คือ 0)
	 * 
	 * เมื่อทำการ serialize อ็อบเจ็กต์ a1 ด้วย ObjectOutputStream 
	 * จะมีการเรียก writeObject() ซึ่งจะ serialize เฉพาะข้อมูลที่เป็น Serializable เท่านั้น 
	 * 
	 * เมื่อต้องการ deserialisieren อ็อบเจ็กต์ a2 จะได้รับค่าจากไฟล์ a1 
	 * เนื่องจาก GameObject ไม่ใช่ Serializable constructor ของ GameObject จะถูกเรียก 
	 * เพื่อสร้างอ็อบเจ็กต์ใหม่ แต่ attribute id จะมีค่าเป็น 0 เนื่องจากมันไม่ได้ถูก serialize
	 * 
	 * สรุปคือ ในกรณีที่มีคลาสพื้นฐาน (Base Class) ที่ไม่เป็น Serializable 
	 * จะมีผลต่อการ serialize ของคลาสลูก (Subclass) ด้วย 
	 * ข้อมูลจากคลาสที่ไม่เป็น Serializable จะไม่ถูกจัดเก็บ ทำให้ค่าของ attribute ที่สืบทอดมาจากคลาสนี้ 
	 * อาจจะมีค่าเป็นค่าเริ่มต้นเมื่อทำการ deserialisieren
	 */

	static class GameObject{
		int id; // wird beim Serialisieren von einem Auto nicht mirserialisiert
		
		GameObject() {
			System.out.println("GameObject()");
		}
	}
	
	// Auto สืบทอดจาก GameObject และ implement Serializable แต่จะมีปัญหากับแอตทริบิวต์ที่สืบทอดมาจาก GameObject
	static class Auto extends GameObject implements Serializable{ 
		String hersteller;
		int baujahr;
		
		public Auto() {
//			super();	// implizit aufrufen
			System.out.println("Auto()");
		}
		
		@Override
		public String toString() {
			return "id: " + id + ", hersteller: " + hersteller + ", baujahr: " + baujahr;  
		}
	}
	
	public static void main(String[] args) {

		String filleName = "a1";
		
		Auto a1 = new Auto();
		
		a1.id = 209;
		a1.baujahr = 2011;
		a1.hersteller = "VW";
		System.out.println(a1.id + " : " + a1.baujahr + " : " + a1.hersteller );
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filleName))){
			
			//Auto (a1) ลงในไฟล์ด้วย ObjectOutputStream จะมีการเรียก writeObject() ซึ่งจะทำการ serialize เฉพาะข้อมูลที่เป็น Serializable เท่านั้น
			
			oos.writeObject(a1);
			System.out.println("Serialisiert : " + a1); // 209, hersteller : VW, baujahr : 2011
            
			
		} catch (IOException e) {
			e.printStackTrace(); 
		}
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filleName))) {
			
		
			//เนื่องจาก GameObject ไม่ใช่ Serializable ดังนั้นแอตทริบิวต์ id จะไม่ถูก serialize และจะถูกมอบค่าเริ่มต้น (ค่าเริ่มต้นของ int คือ 0)
			Auto a2 = (Auto)ois.readObject(); 			// Konstruktor GameObject() wird aufgerufen // aber nicht Auto
														// GameObject และ Auto ซึ่งเป็นคลาสลูกที่สืบทอดมาจาก GameObject 
														// และมีการทำให้คลาส Auto เป็น Serializable แต่คลาส GameObject 
														// ไม่ได้ implement Serializable
			System.out.println("Deserialisiert : " + a2); //  id : 0, hersteller : VW, baujahr : 2011
			
			/*	เมื่อมีการ Deserialize:
				เมื่อคุณอ่านอ็อบเจ็กต์กลับมาจากไฟล์ด้วย ObjectInputStream จะมีการเรียก constructor 
				ของ GameObject ที่ไม่ได้ serialize เพื่อสร้างอ็อบเจ็กต์ใหม่ (จะถูกเรียกเมื่อมีการสร้าง Auto ในขั้นตอนนี้)
				อย่างไรก็ตาม เนื่องจาก id ไม่ถูก serialize ข้อมูลที่ได้จะมีค่าเป็น 0 
				และข้อมูลที่ serialize ได้จะเป็นแค่ hersteller และ baujahr เท่านั้น
			*/
		} catch (IOException e) {
			e.printStackTrace();		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();		
		}
		


	}

}
