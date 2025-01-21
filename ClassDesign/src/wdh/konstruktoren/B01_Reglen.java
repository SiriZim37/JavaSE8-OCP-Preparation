package wdh.konstruktoren;

/*
 *  ตัวอย่าง:
 * - C1 มี Default Constructor โดยอัตโนมัติ
 * - C2 ไม่มี Default Constructor เพราะมันมี Constructor ที่ถูกกำหนดเอง
 * - C3, C4, C5, C6, C7 แสดงให้เห็นถึงการใช้งานของ Constructor ที่มีการเรียก super() หรือ this() ภายใน
 */
class C1 {
	
	/*  Die Klasse hat den Default-Konstruktor
	 	
	 	public C2() { // implizit konstruktor
		}
	 */
}

class C2{

	/*
	 * Die Klasse hat keinen default-Konstruktor , 
	 * da sie den Explizit KOnstruktor hat.
	 */
	C2() {
		
		//super(); 	// super();  generiert !
	
	}
}

class C3{

	C3() {
		super(); 	// explizit super(); generiert !
		
	}
}

class C4{
	
	C4(int x) {
		super();  	// implizit super();generiert !
		
	}
}

class C5{
	
	C5() {
		// super();  	// implizit super();generiert !
	
	}
	
	C5(int x) {
		this();		
	}
}

class C6{
	int x ;
	String y ;
	boolean z ; 
	
	C6() {
		// super();  			// implizit super();generiert !
		// this.x = 0 ;			// implizit generiert 
		// this.y = null;		// implizit generiert 
		// this.z = false;		// implizit generiert 
	}
	
	C6(int x) {
		this();		
	}
	
	C6(String y){
		 //super();  			// implizit super();generiert !
		 //this.x = 0 ;		// implizit generiert 
		 //this.y = null;		// implizit generiert 
		 //this.z = false;	// implizit generiert 
		 System.out.println("C6(String). this.y = "+ this.y) ; // this.y = null
	}
}

class C7{
	int x = 42;
	
	C7(int x){
		 //super();  			// implizit super();generiert !
		this.x = x ; 
		System.out.println("C7(int). this.x = "+ this.x) ; // this.x = x
	}
	
	C7() {
		//super();  			// implizit super();generiert !
		//this.x = 42 ;			// implizit generiert 
		System.out.println("C7(). this.x = "+ this.x) ; // this.x = 42
	}
	
}


public class B01_Reglen {

	public static void main(String[] args) {
	
		/*
		 * 1. Jede Klasse hat mindestens einen Konstruktor
		 * 
		 * 2. Wenn eine Klasse keinen expliziten Konstruktor hat , 
		 * 		wird der default-Konstruktor generirt : 
		 * 		- Sichtbarkeit wie die der Klasse
		 * 		- Keine Parameter (noargs)
		 * 		- Alle Reglen aus dem Punkt 3 
		 * 
		 * 3. Alle Konstruktoren (auch der default-Konstruktor)
		 * 		werden DEI BEDARF vorvollständigt so dass : 
		 * 
		 * 		- die erste Anweisung ist der Aufruf eines anderen
		 * 			Konstruktor mit dem Schlüßelwort this oder super
		 * 			Wenn der Compiler die Anweisung generirt , 
		 * 			dann nur als 'super()'
		 * 	
		 * 		- Wenn der Konstruktoren einen Super-Aufruf hat ,
		 * 			werden alle Attribute vor dem 1. Lesen 
		 * 			initialisiert
		 * 	
		 * 4. Wenn die Klasse Init-Blöcke hat, werden sie in alle Konstruktoren 
		 * 	  die einen super-Aufruf haben, inteliigent direkt nach dem super-Aufruf integriert
		 * 
		 * 
		 * 
		 * 1. ทุกคลาสต้องมี Constructor อย่างน้อย 1 ตัว
		 * 
		 * 2. ถ้าคลาสไม่มี Constructor ที่ถูกกำหนดไว้โดยเฉพาะ (Explicit Constructor) 
		 *    จะมีการสร้าง Default Constructor โดยอัตโนมัติ:
		 *    - ตัว default constructor จะมีความสามารถในการเข้าถึงตามการมองเห็น (Visibility) ของคลาส
		 *    - ไม่มีพารามิเตอร์ (no-args constructor)
		 *    - การทำงานใน default constructor จะทำการเรียก super() โดยอัตโนมัติ
		 * 
		 * 3. ทุก Constructor (รวมถึง Default Constructor) จะได้รับการเติมเต็มโดยอัตโนมัติ (โดยคอมไพเลอร์) ดังนี้:
		 *    - คำสั่งแรกใน Constructor จะเป็นการเรียกใช้ Constructor อื่นด้วยคำสำคัญ `this()` หรือ `super()`
		 *      ถ้าคอมไพเลอร์สร้างคำสั่งนี้ขึ้นมาเอง จะใช้ `super()` เป็นค่าเริ่มต้น
		 * 	  - ถ้า Constructor มีการเรียกใช้ super(), ระบบจะทำการกำหนดค่าให้กับ Attribute ทั้งหมด 
		 *    ก่อนที่มันจะถูกอ่านครั้งแรก	
		 *    
		 *   4. ถ้าคลาสมี Init-Blöcke (Initialisierung-Blöcke หรือ บล็อกการเริ่มต้น)
		 *    จะมีการนำบล็อกเหล่านั้นเข้าไปในทุก Constructor ที่มีการเรียกใช้ `super()` โดยอัตโนมัติ
		 *    ซึ่งจะเกิดขึ้นหลังจาก `super()` ถูกเรียกใช้งาน:
		 *    
		 *    - ในกรณีนี้, บล็อกการเริ่มต้น (Init Block) จะถูกนำเข้าไปทำงานในทุกๆ Constructor 
		 *    	ที่มีการเรียก `super()` ก่อนที่จะเริ่มการทำงานของโค้ดใน Constructor
		 *    - การทำงานของ Init Block จะเกิดขึ้นเพียงครั้งเดียวในการสร้างอ็อบเจ็กต์และทำงานก่อนการเริ่มต้นคำสั่งภายใน Constructor
		 *    
		 *    ตัวอย่าง:
		 *    หากเรามีคลาสที่มี `Init Block` และ `super()` ถูกเรียกใน Constructor คลาสลูก (Subclass),
		 *    บล็อก Init จะทำงานทันทีหลังจาก `super()` ถูกเรียกใช้
		 *    
		 */
			
		new C6("moin"); 	// y = null;
		new C7(111);		// x = 111
		new C7();			// x = 42 ( this.x = 42)

	}

}
