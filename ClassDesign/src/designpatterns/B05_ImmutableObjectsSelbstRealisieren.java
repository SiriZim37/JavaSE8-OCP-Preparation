package designpatterns;

import java.util.Arrays;
import java.util.Random;

/*
 * Immutable Objects ซึ่งหมายถึงออบเจ็กต์ที่ไม่สามารถเปลี่ยนแปลงค่าได้หลังจากที่ถูกสร้างขึ้นแล้ว 
 * นั่นหมายความว่าเมื่อเราสร้างออบเจ็กต์แล้ว เราจะไม่สามารถเปลี่ยนแปลงค่าภายในของมันได้ 
 * เช่น การแก้ไขค่าของฟิลด์หรือคุณสมบัติของออบเจ็กต์นั้นๆ
 */

/*
 * 	Entwickler Tom garantiert ,dass Laden-Objekte immutable sind! 
 */

/*****  NUR GET ABER NICHT SET ! FÜR IMMUTABLE ! *******/

/*  1. การป้องกันการเปลี่ยนแปลงค่าของฟิลด์
 * 		 - ฟิลด์นี้ถูกประกาศเป็น private และไม่ได้รับการเปลี่ยนแปลงจากภายนอกโดยตรง (ไม่มี setter ที่สามารถแก้ไขค่าของฟิลด์นี้ได้)
 *		 - ในการสร้างออบเจ็กต์ของ Laden เราจะใช้ Defensive Copying ซึ่งหมายความว่าเราจะทำการคัดลอกค่าในอาร์เรย์ produkte 
 * 	 	   เพื่อป้องกันไม่ให้มีการแก้ไขค่าอาร์เรย์ภายนอก
 * 
 *  2.  การใช้ Defensive Copying
 *  	- เมื่อมีการส่งอาร์เรย์ produkte เข้ามาในคอนสตรัคเตอร์ของ Laden (เช่น Laden(String... produkte)), 
 *  	  แทนที่จะเก็บอาร์เรย์ต้นฉบับไว้ตรงๆ เราจะใช้ Arrays.copyOf(produkte, produkte.length) เพื่อสร้างสำเนาของอาร์เรย์ที่ส่งเข้ามา ซึ่งจะทำให้ไม่สามารถเปลี่ยนแปลงค่าในอาร์เรย์ของ Laden ได้จากภายนอก
 *  	- นอกจากนี้ในฟังก์ชัน getProdukte() ก็ทำการคัดลอกอาร์เรย์นี้ก่อนที่จะคืนค่าออกไป 
 *  	  เพื่อให้มั่นใจว่าไม่สามารถแก้ไขค่าภายในของ produkte ได้จากภายนอก
 *  
 *  3. การทำให้คลาสเป็น Immutable
 * 	 	- คลาส Laden ถูกประกาศเป็น final ซึ่งหมายความว่าไม่สามารถ subclass 
 * 	      คลาสนี้ได้เพื่อป้องกันไม่ให้มีการเปลี่ยนแปลงพฤติกรรมของมันในอนาคต
 *  	- ไม่มี setter method ที่สามารถเปลี่ยนแปลงค่าของฟิลด์ produkte
 *  	- ฟังก์ชัน getProdukte() คืนค่าของอาร์เรย์ produkte แต่ไม่คืนค่าอาร์เรย์เดิม แต่ทำการคัดลอกมันออกมาเป็นอาร์เรย์ใหม่ 
 *  	  เพื่อป้องกันการแก้ไขค่าในอาร์เรย์ต้นฉบับ
 *  
 *  4. การใช้งานในโปรแกรม
 *  	- ในเมธอด main(), เราสร้างออบเจ็กต์ Laden ผ่านเมธอด getInstance() ซึ่งจะใช้คอนสตรัคเตอร์ Laden เพื่อสร้างออบเจ็กต์
 *  	- หลังจากนั้นเราแสดงผลลัพธ์ของ Laden โดยใช้ System.out.println(laden) ซึ่งจะเรียก toString() ของคลาส Laden
 *  	- การเปลี่ยนแปลงค่าในอาร์เรย์ arr หรือค่าภายในของออบเจ็กต์ที่ถูกคืนจาก getProdukte() 
 *  	  จะไม่ส่งผลกระทบต่อค่าของ Laden เนื่องจากมันเป็นออบเจ็กต์ที่ immutable
 *  
 *  5. ข้อดีของ Immutable Objects
 *  	- Thread-Safe: เนื่องจากไม่สามารถเปลี่ยนแปลงค่าภายในได้ จึงทำให้การใช้งานในหลายเธรดปลอดภัย
 *  	- ปราศจากผลข้างเคียง: การไม่สามารถเปลี่ยนแปลงค่าในออบเจ็กต์ทำให้สามารถมั่นใจได้ว่าออบเจ็กต์จะไม่ถูกเปลี่ยนแปลงโดยไม่ได้ตั้งใจ
 *  	- ง่ายในการทดสอบ: เนื่องจากออบเจ็กต์ไม่สามารถเปลี่ยนแปลงค่าได้หลังจากสร้าง จึงง่ายต่อการทดสอบ
 *  
 *  6. ข้อควรระวัง
 *  	- ควรระมัดระวังการใช้ mutable objects ภายใน immutable class เพราะมันจะทำให้ class ของเรากลับมามีความไม่ปลอดภัยได้
 *  	- ตัวอย่างเช่น หากเราเก็บ List หรือ Map ที่สามารถแก้ไขได้ภายในออบเจ็กต์ immutable ก็จะทำให้เกิดความผิดพลาดในการรักษาความปลอดภัยของข้อมูล
 */

final class Laden {
	/*
	 * Klasse gut kapseln
	 */
	private String[] produkte;
	
	Laden(String... produkte){
//		this.produkte = produkte;	// falsch , der Parameter ist mutable
		
		// 'defensiv' das mutable Argument behandeln : 
		this.produkte = Arrays.copyOf(produkte, produkte.length); // Kopie Immutuble Objekt erzeugen
	}
	/*
	 * es darf keine Methoden geben, die das Laden-Objekt ändern ! 
	 */
//	public void setProdukte(String[] produkte) {
//		
//	}
	
	public String[] getProdukte() {
//		return produkte; 	// falsch, das Attribut ist mutable
		
		// 'defensiv' das mutable Argument behandeln : 
		return Arrays.copyOf(produkte, produkte.length);
	}
	
	@Override
	public String toString() {
		return "Laden hat " + Arrays.toString(produkte);
	}
	
}

public class B05_ImmutableObjectsSelbstRealisieren {

	/*
	 * Entwicklerint Ute realisiert eine Fabrikmethode
	 */
	static Laden getInstance(String... produkte) {
		return new Laden(produkte);
	}
		
//	static class RandomLaden extends Laden{		//  cf : es ist nicht möglich sein : final class Laden {//...}
//		public RandomLaden(String... produkte) {
//			super(produkte);
//		}
//		
//		@Override
//		public String toString() {
//			if(new Random().nextBoolean()) {
//				return Arrays.toString(new String[] { "mo" , "di", "di"});
//			}
//			return super.toString();
//		}
//	}
	
	public static void main(String[] args) {
		/*
		 * Entwickler Jerry verwendet die Klasse laden
		 */
	
		String[] arr = {"Milch" , "Wurst" , "Brot"};
		final Laden laden = getInstance(arr);
		System.out.println("1. " + laden); 		// Milch, Wurst, Brot
		
//		laden.produkte[0] = "Butter";
		arr[0] = "Butter";
		laden.getProdukte()[0] = "Zitronen";	// ändert nicht
		
		//...
		// Bevor die Cipher schutzen wird , wird noch   Butter, Wurst, Brot 
		// Nachdem Kopie Liefert 
		System.out.println("2. " + laden);		// Milch, Wurst, Brot  
		
	} // end of main


	
	
}
