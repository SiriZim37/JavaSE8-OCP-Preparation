package serialisieren;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class B04_manuell_Serialisieren {

	/*
	 * ในตัวอย่างนี้ เรามีคลาส GameObject ที่ไม่สามารถทำให้เป็น Serializable ได้ 
	 * (เช่น มาจากไลบรารีภายนอก) และคลาส Motor ที่ก็ไม่สามารถทำให้เป็น Serializable ได้ 
	 * 
	 * คลาส Auto สืบทอดมาจาก GameObject และ implement Serializable 
	 * โดยมี attribute motor ที่ถูกประกาศเป็น transient 
	 * ซึ่งหมายความว่าข้อมูลของ motor จะไม่ถูก serialize โดยอัตโนมัติ
	 * 
	 * เพื่อจัดการกับการ serialize และ deserialize ของ attribute ที่ไม่เป็น Serializable 
	 * เราจึงต้องใช้วิธีการ writeObject และ readObject
	 * 
	 * - ในเมธอด writeObject: 
	 *   - เรียก oos.defaultWriteObject() เพื่อ serialize ข้อมูลที่เป็น Serializable 
	 *   - จากนั้น เขียน id และ motor.typ โดยใช้ oos.writeInt() และ oos.writeUTF()
	 * 
	 * - ในเมธอด readObject: 
	 *   - เรียก ois.defaultReadObject() เพื่อ deserialisieren ข้อมูลที่เป็น Serializable 
	 *   - จากนั้นอ่าน id และสร้างอ็อบเจ็กต์ใหม่ของ Motor โดยใช้ ois.readUTF() 
	 *     เพื่อกำหนดค่า motor.typ
	 * 
	 * ในเมธอด main เราสร้างอ็อบเจ็กต์ a1 ของคลาส Auto และตั้งค่า attribute ต่าง ๆ 
	 * จากนั้นเราจะ serialize อ็อบเจ็กต์นี้ลงในไฟล์ a4 
	 * และเมื่อ deserialisieren เราจะได้อ็อบเจ็กต์ใหม่ a2 ซึ่งจะมีข้อมูลที่ถูกอ่านกลับมา
	 * 
	 * สุดท้ายจะแสดงผลข้อมูลที่ถูก serialisieren และ deserialisieren
	 */

	
	/*
	 * Stellen wir uns vor, dass die Klasse GameObject
	 * nicht Serializable sein kann (z.B. ist Klasse aus einer externen Bibliothek).
	 */
	static class GameObject {
		int id; 
	}
	
	/*
	 * Stellen wir uns vor, dass die Klasse Motor
	 * nicht Serializable sein kann (z.B. ist Klasse aus einer externen Bibliothek).
	 */
	static class Motor {
		String typ;
		
		public String toString() {
			return typ;
		}
	}
	
	static class Auto extends GameObject implements Serializable {
		String hersteller;
		int baujahr;
		
		transient Motor motor; 
		
		public String toString() {
			return "id: " + id + 
					", hersteller: " + hersteller + 
					", baujahr: " + baujahr + 
					", motor: " + motor;
		}
		
		private void writeObject(ObjectOutputStream oos) throws IOException {
			System.out.println("in meiner writeObject");
			
			oos.defaultWriteObject();  //  เพื่อ serialize ข้อมูลที่เป็น Serializable 
			
			oos.writeInt(id);
			oos.writeUTF(motor.typ);
		}
		
		private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
			System.out.println("in meiner readObject");
			
			ois.defaultReadObject(); //  เพื่อ deserialisieren ข้อมูลที่เป็น Serializable 
			
			this.id = ois.readInt();
			
			this.motor = new Motor();
			this.motor.typ = ois.readUTF();
		}
	}
	
	
	public static void main(String[] args) {

		String fileName = "a4";
		Auto a1 = new Auto();
		
		a1.id = 771;
		a1.hersteller = "VW";
		a1.baujahr = 2023;
		
		a1.motor = new Motor();
		a1.motor.typ = "MS18";

		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
			oos.writeObject(a1);
			System.out.println("Serialisiert: " + a1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Auto a2 = null;
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
			a2 = (Auto)ois.readObject();
			
			System.out.println("Deserialisiert: " + a2);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
