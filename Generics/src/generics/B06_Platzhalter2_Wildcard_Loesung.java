package generics;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class TierS{
	String getName() { return "unbekannt"; }
}
class KatzeS extends TierS{}	// todo : Klasse fürs Speichern in einem HashSet gestalten
class HundS extends TierS{}
class WildHundS extends HundS{}

public class B06_Platzhalter2_Wildcard_Loesung {
	
	/*
	 * Platzhalter (eng : Wildcards)
	 */
	
	 /*
     * การใช้ Wildcards (เครื่องหมายตัวแทน) ใน Generics
     * 
     * Collection<? extends TierS> coll หมายความว่า:
     * คอลเลกชันนี้สามารถใช้กับ TierS หรือคลาสที่สืบทอดจาก TierS
     * แต่ไม่สามารถเพิ่มข้อมูลลงไปได้
     *
     * Collection<? super HundS> coll หมายความว่า:
     * คอลเลกชันนี้สามารถรับ HundS หรือคลาสที่เป็นพื้นฐานของ HundS เช่น TierS ได้
     * สามารถเพิ่ม HundS และ WildHundS ลงไปได้
     */
	

	public static void main(String[] args) {


		List<HundS> listHund = new ArrayList<HundS>();
		
		listHund.add(new HundS());
		listHund.add(new WildHundS());   //  Hund param = new WildHund()
										// 1. Hund <-IS-A <- WildHund  : OK 				
	
		// เรียกใช้งานเมธอด print ที่รองรับ Collection<? extends TierS>
		print(listHund);				// Collection coll = listHunde
										// 1. Collection <- IS-A <- List		- OK 
										// 2. <? extends Tier> erlaubt <Hund>	- OK 	
		
		
		// เรียกใช้งานเมธอด addZweiHunde ที่รองรับ Collection<? super HundS>
		addZweiHunde(listHund);			// Typ Collection<? super Hund> coll = listHunde
										// 1 Type Collection <- IS-A <-List
										// 2. <? super Hund> erlaubt <Hund>
		
		Set<KatzeS> setKatzen = new HashSet<KatzeS>();
		setKatzen.add(new KatzeS());
		setKatzen.add(new KatzeS());
		
		// เรียกใช้งานเมธอด print สำหรับ Set<KatzeS>
		print(setKatzen);				// Collection coll = setKatzen
										// 1. Collection <- IS-A <- Set 		- OK 
										// 2. <? extends Tier> erlaubt <Katzen>	- OK 	
	
		
	    // addZweiHunde(setKatzen);  // คอมไพล์ไม่ผ่าน เนื่องจาก <? super HundS> ไม่รองรับ <KatzeS>
//		addZweiHunde(setKatzen);		// cf :  darf nicht kompilieren
										// 1 Type Collection <- IS-A <-Set
										// 2. <? super Hund> erlaubt nicht <Katze>		// geschwister
		
		Collection<TierS> collTiere = new ArrayDeque<TierS>();
		collTiere.add(new HundS());
		collTiere.add(new WildHundS());
		collTiere.add(new KatzeS());
		
		 // เรียกใช้งานเมธอด print สำหรับ Collection<TierS>
		print(collTiere);				// 1.Collection coll = collTiere		- OK
										// 2. <? extends Tier> erlaubt <Tier>  	- OK
		
		 // เรียกใช้งานเมธอด addZweiHunde สำหรับ Collection<? super HundS>
		addZweiHunde(collTiere);		// Typ Collection<? super Hund>  coll = collTiere
										// 1 Type Collection <- IS-A <- Collection
										// 2. <? super Hund> erlaubt <Tier>
		
		Collection<Object> collObj = new ArrayList<>();
//		print(collObj);
		addZweiHunde(collObj); // สามารถเพิ่ม HundS และ WildHundS ลงไปได้
	}
	
	/*
	 * Collection <? super Hund> coll bedeutet : 
	 * 
	 * Bei der 2 Kontrolle der Zuweisung in die Referenz coll
	 * darf die rechte Referenz mit Hund parameterisiert sein 
	 * oder mit dem Basistyp von Hund
	 * เมื่อทำการตรวจสอบที่ 2 ในการกำหนดค่าให้กับตัวแปรอ้างอิง coll
	 * ตัวแปรอ้างอิงด้านขวามือสามารถกำหนดประเภทเป็น Hund หรือประเภทพื้นฐานของ Hund ได้
	 */
	
	  /*
     * การใช้ Collection <? super HundS> หมายความว่า:
     * การกำหนดค่าของตัวแปร coll สามารถกำหนดให้เป็น Collection ที่รองรับ HundS หรือคลาสพื้นฐานของ HundS (เช่น TierS)
     */
	static void addZweiHunde(Collection<? super HundS> coll) { 
		coll.add(new HundS());
		coll.add(new WildHundS());
		
//		coll.add(new KatzeS());		// cf 
//		coll.add(new TierS());
	}
	
	static void addZweiHunde2(Collection<? super TierS> coll) {   // alles objekt funktioniert
		coll.add(new HundS());
		coll.add(new WildHundS());		
		coll.add(new KatzeS());		
		coll.add(new TierS());
	}
	
//	private static void print(Collection<Hund> coll) { } 	//	 die Methode kann nicht übergaladet
//	private static void print(Collection<Katze> coll) { } 	//	 die Methode kann nicht übergaladet
	

	// One method for all types extending Tier
	static void print(Collection<? extends TierS> coll) { 
		
		System.out.println("size: + " + coll.size());
		
		for(Object t : coll) {
			System.out.println(t);
		}
		
		// Mit der Referenz kann nicht abrufen
		// ไม่สามารถเพิ่มข้อมูลลงไปในคอลเลกชันที่ใช้ <? extends TierS>
//		coll.add(new Tier()); 		// ไม่สามารถเพิ่ม Tier ได้
//      coll.add(new Hund()); 		// ไม่สามารถเพิ่ม Hund ได้
//      coll.add(new Katze()); 		// ไม่สามารถเพิ่ม Katze ได้
//      coll.add(new WildHund()); 	// ไม่สามารถเพิ่ม WildHund ได้
        

        coll.remove(new TierS());		// มีพารามิเตอร์เป็นวัตถุ
        coll.contains(new TierS());		// มีพารามิเตอร์เป็นวัตถุ
	}
	

	
	


}
