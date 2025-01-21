package generics;


// Typparameter kann den Namen wie ein Java-Identifier 
// bekommen (sollte aber aus Grossbuchstaben bestehen) ,
// โดยทั่วไปชื่อพารามิเตอร์ควรเป็นตัวอักษรใหญ่ (เช่น T, E) เพื่อให้เข้าใจง่ายขึ้นในการใช้งาน ซึ่งจะเป็นแนวปฏิบัติที่ดีในกรณีของการใช้ Generics.

class C1 <BuchStaBen_1234_$> {  // geht aber nicht so gut
	
}

class C2 <A> {  // ok
	
}
public class B01_Begriffe {

	public static void main(String[] args) {
		/*
		 * Z.B das Interface java.util.List aus der Standardbibliothek : 
		 * 
		 * Definition : 
		 * 	
		 * 		public interface List <E>... 
		 *
		 *	List<E>		- generischer Typ   เป็นตัวอย่างของการใช้ Generics ในอินเทอร์เฟซของจาวา 
		 * 
		 * 	E			- formaler Typparameter (Typvariable)  คือพารามิเตอร์ของชนิดข้อมูล
		 * 
		 * ****************************
		 * 
		 *  Programmieren mit List
		 *  
		 *  	List<String> list = ...; 
		 * 
		 * 	String				- aktueller Typparameter (Parametrisierung) จะเป็นพารามิเตอร์ของชนิดข้อมูลที่เป็นปัจจุบัน
		 * 	List<String>		- Parametrisierter Typ  เป็นชนิดที่ได้รับการระบุพารามิเตอร์เรียบร้อยแล้ว 
		 * 
		 * ****************************
		 * 
		 * Programmieren mit List
		 * 
		 * 		List list = ...; // bitte nielmals so programmieren
		 * 
		 * 	List 				- raw type (Originaltyp) ที่ไม่มีพารามิเตอร์ใด ๆ เป็น raw type หรือ "ชนิดดั้งเดิม" ซึ่งควรหลีกเลี่ยงในการใช้งาน.
		 * 
		 * 
		 * ****************************
		 * 
		 * Definition einer generischen Klasse :  ในการสร้างคลาส Generics
		 * 
		 * 		class Steckdosen <T extends TV >
		 * 
		 * T extends TV 	- type bound (Typeinschränkung)
		 * 
		 * T คือพารามิเตอร์ของชนิดข้อมูลที่กำหนดให้ T ต้องเป็นคลาสที่สืบทอดจาก TV ซึ่งเราเรียกการจำกัดประเภทนี้ว่า type bound (การจำกัดชนิดข้อมูล).
		 */

	}

}
