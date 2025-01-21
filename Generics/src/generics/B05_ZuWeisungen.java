package generics;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class B05_ZuWeisungen {

	public static void main(String[] args) {
		/*
		 * Zuweisung bei 'normalen' Referenzen
		 * 
		 * Compiler kontroliiert die IS-A-Beziehung von rechts nach links
		 * Compiler จะตรวจสอบความสัมพันธ์ IS-A จากขวาไปซ้าย
 		 */
		Number  n1 = null ; 
		Integer i1 = null ; 
		Double  d1 = null ;
		  
		
		i1 = i1 ;  // Integer <- IS-A <- Integer
		n1 = i1 ;  // Number <- IS-A <- Integer
		n1 = d1 ;  // Number <- IS-A <- Double
		
		/*
		 * Zuweisungen bei parameterisierten Referenzen
		 * von generischen Typen hat zwei Compilier-Kontrollen : 
		 * การกำหนดค่าสำหรับอ้างอิงที่มีการกำหนดพารามิเตอร์
		 * 
		 * 1. IS-A-Beziehung von rechts nach links
		 * 2. Parameterisierungen müssen gleich sein.
		 * 		Vererbung
		 * 		(Platzhalter / Wildcards besprochen)
		 */
		
		List<Integer> listInt ; 
		Set<Integer> setInt;
		Collection<Number> collNum =  new ArrayDeque<>(); ;
		
		listInt = new LinkedList<Integer>();
		
		/*
		 * Zwei punkte check ist wichtig 
		 */
//		setInt = listInt;   //  1. Set <- IS-Kein <- List  : cf 
							// ( Set<> und LinkedList<>() sind geschwister )
		
//		collNum = listint;   // 1. Collection <- IS-A <- List  : OK
							 // 2. <Number> nicht gleich <Integer> - cf
		  					// (การกำหนดค่าไม่สามารถทำได้เนื่องจากประเภทต่างกัน)
		
//		listint = collNum; 	 // 1. List <- IS-KEIN<- Collection  : cf
						     // (ไม่สามารถกำหนดค่าได้, เนื่องจาก Collection ไม่ได้สืบทอดมาจาก List)
		 
		// da die Zuweisung collNum = list nicht kompiliert ,
		// bleibt LinkedList-Objekt typischer, sont wäre es weiter möglich
		// เนื่องจากการกำหนดค่า collNum = listInt ไม่สามารถคอมไพล์ได้
        // จึงสามารถเพิ่มค่า n1, i1, d1 ลงใน collNum ได้
		collNum.add(n1);
		collNum.add(i1);
		collNum.add(d1);
		
		Collection<Integer> collInt ; 
		
		collInt = listInt;  	// 1. Collection <- IS-A <- List  : OK
								// 2. Integer <- IS-A <- Integer - cf
		 						// (การกำหนดค่าทำได้เพราะ Integer เป็นชนิดที่ถูกต้อง)

		
		//LinkedList-Objekt bleict typischer , dann   : 
		//auch mit der collInt können nur Integer-Elemete
		//gespeichert werden.
		
        collInt.add(i1); // เพิ่มค่า i1 ลงใน collInt
//      collInt.add(n1); // cf  (ไม่สามารถเพิ่ม n1 ได้ เพราะ n1 เป็น Number และไม่ใช่ Integer)
//      collInt.add(d1); // cf  (ไม่สามารถเพิ่ม d1 ได้ เพราะ d1 เป็น Double และไม่ใช่ Integer)
		
        /*
         	1. LinkedList-Objekt bleict typischer:
			หมายถึงว่าวัตถุ LinkedList ยังคงมีประเภทที่เฉพาะเจาะจง และยังคงรักษาความเป็นธรรมชาติของประเภทที่กำหนดไว้
			2. dann auch mit der collInt können nur Integer-Elemete gespeichert werden:
			นี่หมายความว่า ใน collInt ซึ่งถูกกำหนดให้เป็น Collection<Integer> จะสามารถเก็บเฉพาะค่า 
			Integer เท่านั้น และไม่สามารถเก็บค่าประเภทอื่น เช่น Double หรือ Number ได้
         */
	}

}
