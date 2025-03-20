package interfaces;

/*
 * 	Wenn eine Klasse mehrere Interfaces implementiert 
 * 	und die Interfaces haben default-Methoden mit derselben Signatur , 
 * 	MUSS die Klasse die default-Methode selbst überschreiben.
 */
/*
 *  เมื่อคลาสนำอินเทอร์เฟซหลายตัวไปใช้งาน (implement) 
 *  และอินเทอร์เฟซเหล่านั้นมี default method ที่มีชื่อและพารามิเตอร์เหมือนกัน
 *  คลาสที่นำไปใช้งานจำเป็น **ต้องเขียนทับ** (override) เมท็อด default เอง
 */
interface MyContainer {
	default int size() { return 0 ; }
}

interface MyValues {
	default int size() { return -1 ; } // abstrakte Methode 
}

class PairV1 implements MyContainer {
	
}

//PairV2 ใช้อินเทอร์เฟซ MyContainer และ MyValues พร้อมกัน
//*** Error: เนื่องจากทั้งสองอินเทอร์เฟซมี default method ชื่อ size() เหมือนกัน

//class PairV2 implements MyContainer, MyValues {	// cf 
//
//}}


//PairV3 ใช้อินเทอร์เฟซ MyContainer และ MyValues พร้อมกัน
//แต่ได้เขียนทับ (override) เมท็อด size() เพื่อแก้ปัญหาความขัดแย้ง
class PairV3 implements MyContainer , MyValues {	 	// ok
	public int size() { return 0 ;}
}

interface MyContainerString {
	default String size() { return "0" ; }
}

//PairV4 พยายามใช้อินเทอร์เฟซ MyContainer, MyValues และ MyContainerString พร้อมกัน
//*** Error: เนื่องจาก return type ของเมท็อด size() ใน MyContainerString เป็น String
//ซึ่งไม่สามารถเข้ากันได้กับ return type ของเมท็อด size() ใน MyContainer และ MyValues

//class PairV4 implements MyContainer, MyValues, MyContainerString {	// cf 
// public int size() {
//     return 0;  
// }
//}


interface MyContainerString2 {
	default String size(int a) { return "0" ; }
}

class PairV4 implements MyContainer, MyValues, MyContainerString2 {	
		public int size() {
		  return 0;  
		}
		
		public String size(int a) {
			  return "a";  
			}
}

/*
 *  Eine Klasse , die default-Methoden erbt , 
 *  kann die-Methode aus dem Basisinterface explizit aufrufen.
 *  ---> S. B06 
 */
/*
 *  คลาสที่สืบทอด default method สามารถเรียกใช้งานเมท็อดจากอินเทอร์เฟซฐาน
 *  ได้โดยตรงผ่านชื่อของอินเทอร์เฟซ (explicit call)
 *  ตัวอย่างเพิ่มเติมสามารถดูได้ในไฟล์ B06
 */

public class B05_defaaultUndMehrfaceVererbung {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
