package serialisieren;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


import serialisieren.B01_Regeln.Auto;
import serialisieren.B01_Regeln.Motor;
import serialisieren.B02_BasisklasseIstNichtSerializable.GameObject;

public class B03_AttributeIstNichtSerialiizable {

	/*
	 * Stellen wir uns vor, dass die Klasse Motor
	 * nicht Serializable sein kann (z.B. ist Klasse aus einer externen Bibliothek).
	 */
	
	/*
	 * ในตัวอย่างนี้เรามีคลาส Motor ซึ่งไม่สามารถทำให้เป็น Serializable ได้ (เช่น มาจากไลบรารีภายนอก) 
	 * 
	 * คลาส Auto ที่ทำการ implements Serializable มี attribute motor ที่เป็นประเภท Motor
	 * โดย attribute motor ถูกกำหนดเป็น transient ซึ่งหมายความว่าจะถูกข้ามไปเมื่อทำการ serialisieren
	 * 
	 * เมื่อต้องการทำการ serialisieren อ็อบเจ็กต์ a1 ของคลาส Auto จะถูกสร้างขึ้น 
	 * โดยมีการกำหนดค่าให้กับ baujahr และ motor
	 * 
	 * เมื่อทำการ serialisieren อ็อบเจ็กต์ a1 จะถูกเขียนลงไฟล์ชื่อ a3 แต่ attribute motor จะไม่ถูก serialisiert
	 * 
	 * เมื่อทำการ deserialisieren อ็อบเจ็กต์ a2 จะได้รับค่าจากไฟล์ a3 
	 * แต่ attribute motor จะเป็น null เพราะมันถูกข้ามไปในกระบวนการ serialisieren
	 * 
	 * สรุปคือ การใช้ transient ทำให้ attribute นั้นไม่ถูกจัดเก็บเมื่อทำการ serialisieren 
	 * ซึ่งเป็นวิธีที่ใช้ในการละเว้นข้อมูลที่ไม่ต้องการเก็บในกระบวนการนี้
	 */


	
	static class Motor {
	}
	
	static class Auto implements Serializable {
		
		transient Motor motor; // wird beim Serialisieren übersprungen (transient)
		
		int baujahr;
		
		@Override
		public String toString() {
			return "Auto. Baujahr: " + baujahr + ". Motor: " + motor;
		}
	}
	public static void main(String[] args) {
		
		String fileName = "a3";
		Auto a1 = new Auto();
		
		a1.baujahr = 2011;
		a1.motor = new Motor();
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
			oos.writeObject(a1); // motor wird nicht serialisiert
			System.out.println("Serialisiert: " + a1); 
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Auto a2 = null;
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
			a2 = (Auto)ois.readObject(); 
			System.out.println("Deserialisiert: " + a2); // motor ist null
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		

	}

}
