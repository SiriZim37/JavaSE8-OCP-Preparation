package serialisieren;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TestKonstruktorBeimDeserialisieren {

	static class Auto{
//		public Auto() { // ok 
//		}
		public Auto(int i) {
			System.out.println("Auto(int)");
		}
	}
	
	static class PKW extends Auto implements Serializable{
		public PKW() {
//			super();		// ok 
			super(10);
			System.out.println("PWK");
		}
	}
	
	public static void main(String[] args) {
		
		/*
		 * Serializable: การทำให้คลาส PKW implements Serializable 
		 * ทำให้สามารถเก็บสถานะของอ็อบเจ็กต์ PKW ได้ 
		 * แต่คลาส Auto ไม่ได้ทำการ implement Serializable อย่างชัดเจน
		 * 
		 * ##### Es kann execute mit No-Arg Konstruktor!!! 
		 * 
		 * Ergebnis : serialisieren.TestKonstruktorBeimDeserialisieren$PKW; no valid constructor 
		 * นั่นหมายความว่าเกิดปัญหาเกี่ยวกับการ Deserialization เนื่องจาก Java 
		 * ไม่สามารถหาคอนสตรัคเตอร์ที่ถูกต้องในการสร้างอ็อบเจ็กต์ PKW จากไฟล์ที่ทำการ Serialization ไว้.
		 * 
		 * สาเหตุของปัญหา
		 * Java ต้องการคอนสตรัคเตอร์ที่ไม่มีพารามิเตอร์ในการสร้างอ็อบเจ็กต์เมื่อทำ Deserialization 
		 * โดยอัตโนมัติ (ซึ่งเป็นสิ่งที่ Java จะใช้เพื่อเรียกสร้างอ็อบเจ็กต์ใหม่จากไฟล์ที่บันทึกไว้). ในกรณีนี้:
		 * 
		 * คลาส PKW มีคอนสตรัคเตอร์ที่รับพารามิเตอร์ (super(10)), ซึ่งไม่ได้มีคอนสตรัคเตอร์ที่ไม่มีพารามิเตอร์ (no-arg constructor).
		 * การทำ Deserialization ใน Java ต้องการคอนสตรัคเตอร์ที่ไม่มีพารามิเตอร์สำหรับการสร้างอ็อบเจ็กต์,
		 * ซึ่งทำให้เกิดข้อผิดพลาด InvalidClassException.
		 * 
		 * วิธีการแก้ไข
		 * พิ่มคอนสตรัคเตอร์ที่ไม่มีพารามิเตอร์ในคลาส PKW:
		 * การเพิ่มคอนสตรัคเตอร์ที่ไม่มีพารามิเตอร์ในคลาส PKW จะทำให้ Java สามารถใช้คอนสตรัคเตอร์นี้ในการสร้างอ็อบเจ็กต์ใหม่ในระหว่างการ Deserialization ได้.
		 */
		serialisieren();
		deserialisieren();
	}
	
	static void serialisieren() {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("b.bin"))) {
			oos.writeObject(new PKW());
			oos.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void deserialisieren() {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("b.bin"))) {
			PKW pkw = (PKW)ois.readObject();
			ois.close();
			System.out.println("Deserialisieren: " + pkw);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
