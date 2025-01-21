package ocp;

import java.io.*;
class Animal {
  Animal() { System.out.print("a"); }
}

class Dog extends Animal implements Serializable {
  Dog() { System.out.print("d"); }
}

public class IO_Serializable1 extends Dog {
	
	/*
	 * If an instance of class Beagle is created, then Serialized, then deSerialized, what is the result?
	 * 
	 * A. ad
	 * 
	 * B. ada
	 * 
	 * C. add
	 * 
	 * D. adad
	 * 
	 * E. Compilation fails
	 * 
	 * F. An exception is thrown at runtime
	 * 
	 * B is correct. When an object is deserialized, the Serializable's constructor is not run.
	 * 
	 * A, C, D, E, and F are incorrect based on the above.
	 * 
	 * คำอธิบาย:
	 * - A: ข้อนี้ไม่ถูกต้อง เพราะเมื่อตัวแปรของคลาส Beagle ถูกสร้างขึ้น การทำงานของคอนสตรัคเตอร์ในคลาส `Dog` และ `Animal` จะถูกเรียกก่อน
	 * - B: ข้อนี้ถูกต้อง เพราะเมื่ออ็อบเจ็กต์ถูก deserialized คอนสตรัคเตอร์ของ `Serializable` จะไม่ถูกเรียกซ้ำ ซึ่งหมายความว่าคอนสตรัคเตอร์ของ `Dog` จะทำงานแล้วพิมพ์ "d" และคอนสตรัคเตอร์ของ `Animal` จะทำงานแล้วพิมพ์ "a"
	 * - C: ข้อนี้ไม่ถูกต้อง เพราะไม่ได้เกิดการเรียกคอนสตรัคเตอร์ของ `Dog` ซ้ำ
	 * - D: ข้อนี้ไม่ถูกต้อง เพราะไม่ใช่การพิมพ์ "adad" ทั้งสองครั้ง
	 * - E: ข้อนี้ไม่ถูกต้อง เพราะไม่เกิดข้อผิดพลาดในการคอมไพล์
	 * - F: ข้อนี้ไม่ถูกต้อง เพราะไม่มีข้อยกเว้นที่เกิดขึ้นในขณะทำงาน
	 * 
	 * 
	 * 
	 * อ็อบเจ็กต์สามารถทำให้เป็น serializable ได้เมื่อ:
	 * 
	 *     - คลาสของมันต้องเป็น Serializable
	 *        และทุก attribute (เรียกซ้ำได้) ต้องปฏิบัติตามกฎการทำให้ serializable
	 *     - แอตทริบิวต์ประเภท Primitive จะถูกทำให้เป็น serializable โดยอัตโนมัติ
	 *     - แอตทริบิวต์ที่เป็น transient จะถูกข้ามไปเมื่อทำการ serialisieren
	 *        
	 *     - อ็อบเจ็กต์นั้นเป็น Array (อาร์เรย์สามารถทำให้เป็น serializable ได้)
	 * 
	 * การทำ Deserialisieren:!
	 * 
	 *     -  เมื่อทำการ deserialisieren จะมีการเรียก no-argument constructor ของ
	 *        คลาสพื้นฐานที่ไม่ใช่ Serializable ที่ลึกที่สุดในลำดับชั้นการสืบทอด
	 *        หากคลาสพื้นฐานที่ไม่ใช่ Serializable นั้นไม่มี no-argument constructor,
	 *        จะเกิด Exception ขึ้นเมื่อทำการ deserialisieren
	 */

	public static void main(String[] args) {
		 try {
	            // Create an instance of Beagle
		      System.out.println("---");
			 IO_Serializable1 beagle = new IO_Serializable1();
		      System.out.println("\n---");
		      
	            // Serialize the Beagle object to a file
	            FileOutputStream fileOut = new FileOutputStream("beagle.ser");
	            ObjectOutputStream out = new ObjectOutputStream(fileOut);
	            out.writeObject(beagle);
	            out.close();
	            fileOut.close();
	            System.out.println("\nSerialized Beagle object");

	            // Deserialize the Beagle object from the file
	            FileInputStream fileIn = new FileInputStream("beagle.ser");
	            ObjectInputStream in = new ObjectInputStream(fileIn);
	            System.out.println("---");
	            IO_Serializable1 deserializedBeagle = (IO_Serializable1) in.readObject();
	            System.out.println("\n---");
	            in.close();
	            fileIn.close();
	            System.out.println("\nDeserialized Beagle object");

	        } catch (IOException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	}
}

