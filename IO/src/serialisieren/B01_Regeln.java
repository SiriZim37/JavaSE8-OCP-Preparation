package serialisieren;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class B01_Regeln {

	static class Motor implements Serializable {
		String typ = "T1";
	}
	
	static class Auto implements Serializable {
		Motor motor = new Motor();
		int baujahr;
		
		@Override
		public String toString() {
			return "Auto. Baujahr: " + baujahr + ". Motor: " + motor.typ;
		}
	}
	
	/*
	 * Ein Objekt ist serialisierbar wenn:
	 * 
	 * 		- seine Klasse IST Serializable
	 *        und alle Attribute (rekursiv) erfüllen die Regeln fürs Serialisieren.
	 *        - Primitive Attribute sind automatisch serialisierbar.
	 *        - transient-Attribute werden beim Serialisieren übersprungen.
	 *        
	 * 		- Objekt ist ein Array (Arrays sind serialisierbar)
	 * 		  - alle Elemente von einem Referenzen-Array (rekursiv) 
	 *          müssen die Regeln fürs Serialisieren erfüllen 
	 *        - Primitive Elemente sind automatisch serialisierbar.
	 * 
	 * Deserialisieren:
	 * 
	 * 		- Beim Deserialisieren wird der noargs-Konstruktor der 
	 *        (in der Vererbungshierarchie) tiefsten Nicht-Serializable-Basisklasse
	 *        aufgerufen.
	 *        Wenn diese Nicht-Serializable-Basisklasse keinen noargs-Konstruktor hat,
	 *        gibt es beim Deserialisiren eine Exception.
	 *        
	 *        Z.B.:
	 *        
	 *           Object
	 *              |
	 *           GameObject      Serializable
	 *              |               |
	 *              ----------------
	 *                      |
	 *                     Auto
	 *                     
	 *   	  Klasse GameObject muss den noargs-Konstruktor haben, 
	 *        damit ein Auto-Objekt deserialisiert werden kann.
	 *   
	 */
	
	/*
	 * อ็อบเจ็กต์สามารถทำให้เป็น serializable ได้เมื่อ:
	 * 
	 *     - คลาสของมันต้องเป็น Serializable
	 *        และทุก attribute (เรียกซ้ำได้) ต้องปฏิบัติตามกฎการทำให้ serializable
	 *     - แอตทริบิวต์ประเภท Primitive จะถูกทำให้เป็น serializable โดยอัตโนมัติ
	 *     - แอตทริบิวต์ที่เป็น transient จะถูกข้ามไปเมื่อทำการ serialisieren
	 *        
	 *     - อ็อบเจ็กต์นั้นเป็น Array (อาร์เรย์สามารถทำให้เป็น serializable ได้)
	 * 
	 * การทำ Deserialisieren:
	 * 
	 *     -  เมื่อทำการ deserialisieren จะมีการเรียก no-argument constructor ของ
	 *        คลาสพื้นฐานที่ไม่ใช่ Serializable ที่ลึกที่สุดในลำดับชั้นการสืบทอด
	 *        หากคลาสพื้นฐานที่ไม่ใช่ Serializable นั้นไม่มี no-argument constructor,
	 *        จะเกิด Exception ขึ้นเมื่อทำการ deserialisieren
	 */

	
	public static void main(String[] args) {

		String fileName = "a1";
		Auto a1 = new Auto();
		
		a1.baujahr = 2011;
		a1.motor.typ = "MX22";
		
		System.out.println(a1.baujahr + " : " + a1.motor.typ );
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
			
			oos.writeObject(a1);
			System.out.println("Serialisiert : " + a1); // แสดงข้อความว่าอ็อบเจ็กต์ถูกทำให้เป็น serializable
            
			
		} catch (IOException e) {
			e.printStackTrace(); // // หากไม่สามารถทำให้ serializable ได้ จะเกิด java.io.NotSerializableException
								// wenn Serializable dem Auto class nicht implementiert wird, 
								// gibt java.io.NotSerializableException: serialisieren.B01_Regeln$Auto 
		}
		
		Auto a2 = null;
//		fileName = "a2";
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
			
			a2 = (Auto) ois.readObject();
			System.out.println("Deserialisiert : " + a2);  // แสดงข้อความว่าอ็อบเจ็กต์ถูก deserialized
			
		} catch (IOException e) {
			e.printStackTrace();		// แสดงข้อผิดพลาดหากไม่สามารถอ่านไฟล์ได้
		} catch (ClassNotFoundException e) {
			e.printStackTrace();		// หากไม่พบคลาสจะเกิด ClassNotFoundException
		}
		
		System.out.println("Referenzen unterschiedlich: " + (a1 != a2)); // true
	}

}
