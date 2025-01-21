package generics;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Tier{}
class Katze extends Tier{}	// todo : Klasse fürs Speichern in einem HashSet gestalten
class Hund extends Tier{}
class WildHund extends Hund{}

public class B06_Platzhalter {
	/*
	 * สรุป:
	 * - โค้ดนี้แสดงให้เห็นถึงการใช้การสืบทอดและความสัมพันธ์ระหว่างประเภทต่าง ๆ ใน Java 
	 *   โดยการจัดการกับ Collection 
	 * - การใช้ wildcard (? extends) ช่วยให้สามารถรับ Collection ของประเภทที่สืบทอดจาก Tier ได้ 
	 *   แต่ไม่สามารถเพิ่มวัตถุใหม่ลงไปใน Collection นี้ได้ 
	 * - มีการสอนเกี่ยวกับการควบคุมประเภท (type safety) ใน Java 
	 *   เพื่อหลีกเลี่ยงการเพิ่มวัตถุที่ไม่ถูกต้องลงใน Collection
	 */
	public static void main(String[] args) {


		List<Hund> listHund = new ArrayList<Hund>();
		
		listHund.add(new Hund());
		listHund.add(new WildHund());  //  Hund param = new WildHund()
										// 1. Hund <-IS-A <- WildHund  : OK 
		
		
		print(listHund);		
								/* bsp2.
								 * print(Collection<Tier> list)
								 */
								// Collection coll = listHunde
								// 1. Collection <- IS-A <- List		- OK 
								// <Tier> nicht gleich <Hund>			- OK 
		
								/* bsp1.
								 * print(List<Hund> list)
								 */
								// List<Hund list = listHunde
								// 1. List <- IS-A <- List
								// <Hund> gleich <Hund>
		
		Set<Katze> setKatzen = new HashSet<Katze>();
		setKatzen.add(new Katze());
		setKatzen.add(new Katze());
		
		print(setKatzen);		
								/* bsp2.
								 * print(Collection<Tier> list)
								 */							
								// Collection coll = setKatzen
								// 1. Collection <- IS-A <- Set 	- OK 
								// 2. <Tier> nicht gleich <Katze>  	- cf

								/* bsp1.
								 * print(List<Hund> list)
								 */
								// List<Hund list = listHunde 
								// 1. List <- ---  <- Set			// cf 
								
		
		Collection<Tier> collTiere = new ArrayDeque<Tier>();
		collTiere.add(new Hund());
		collTiere.add(new WildHund());
		collTiere.add(new Katze());
		
		print(collTiere);		
								/* bsp2.
								 * print(Collection<Tier> list)
								 */	
								// Collection coll = collTiere		- OK
								// 2. <Tier> gleich <Tier>  		- OK
						
								/* bsp1.
								 * print(List<Hund> list)
								 */
								// 1. Collection <- IS-A <- Collection 	- OK 
								// List<Hund list = listHunde
								// 1. List <- ---  <- Collection		// cf 
		
		

	}
	
	 /*
     * Collection< ? extend Tier> coll bedeutet : 
     * 
     * Bei der 2.Kontrolle der Zuweisung in die Referenz coll 
     * darf die rechte Refernze mit Tier parameterisiert sein 
     * oder mit dem von Tier abgeleiteten Typ. 
     * (ในการตรวจสอบการกำหนดค่าครั้งที่ 2 ในการอ้างอิง coll การอ้างอิงด้านขวาต้องกำหนดพารามิเตอร์ด้วย Tier หรือต้องเป็นประเภทที่ได้จาก Tier)
     * 
	 * Hinweis:
	 * <?> ist die Ankürzung für <? extends Object>
	 * 
	 * 
     * Unwahrscheinlich in der Prüfung : 
     * (ไม่น่าจะเกิดขึ้นในการสอบ:)
     * Die mit ' ? extends ' parametrisierte Referen kann nicht 
     * benutzt werden , um eine Methode mit dem generischen Parameter 
     * (การอ้างอิงที่กำหนดด้วย ' ? extends ' จะไม่สามารถ ใช้เรียกใช้เมธอดที่มีพารามิเตอร์แบบเจนริกได้)
     */
	
	// **bsp3. funktioniert  alle
	// เมธอด print สำหรับ Collection ของ Tier หรือประเภทที่ได้จาก Tier
	//การใช้ wildcard (? extends Tier) ในการกำหนดประเภทของ Collection
	//ซึ่งจะช่วยให้สามารถจัดการกับ Collection ของประเภทที่สืบทอดจาก Tier ได้ 
	//โดยที่ไม่สามารถเพิ่มวัตถุใหม่ลงไปใน Collection นี้ได้ แต่สามารถใช้เมธอดอื่น ๆ เช่น remove() และ contains() ได้ตามปกติ
	//!!ไม่สามารถเพิ่มวัตถุใหม่ลงใน Collection นี้ได้ 
	private static void print(Collection<? extends Tier> coll) { 
		
		System.out.println("size: + " + coll.size());
		
		 // coll.add(new Tier()); // ไม่สามารถเพิ่ม Tier ได้
        // coll.add(new Hund()); // ไม่สามารถเพิ่ม Hund ได้
        // coll.add(new Katze()); // ไม่สามารถเพิ่ม Katze ได้
        // coll.add(new WildHund()); // ไม่สามารถเพิ่ม WildHund ได้
        
        coll.remove(new Tier());		// มีพารามิเตอร์เป็นวัตถุ
        coll.contains(new Tier());		// มีพารามิเตอร์เป็นวัตถุ

	}

	// **bsp2. funktioniert IS-A aber <T> cf 
//	private static void print(Collection<Tier> coll) {
//		
//		for (Tier t : coll) {
//			System.out.println(t);
//		}	
//		coll.add(new Tier());
//		coll.add(new Hund());
//		coll.add(new Katze());
//		coll.add(new WildHund());
//	}
	

	// **bsp1. funktioniert nur listHunde
	
//	private static void print(List<Hund> list) {	
//		for (Hund o : list) {
//			System.out.println(o);
//		}	
//	}

}
