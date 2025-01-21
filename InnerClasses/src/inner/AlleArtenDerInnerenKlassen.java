package inner;


//คำอธิบายเกี่ยวกับคลาสภายใน (Inner Class) สำหรับการสอบ OCP Java SE 8
//ใน Java SE 8, **Inner Class** คือคลาสที่ถูกประกาศไว้ภายในคลาสอื่น
//คลาสภายในช่วยในการจัดระเบียบโค้ดให้กระชับมากขึ้นและมีประโยชน์เมื่อคลาสภายในมีความสัมพันธ์ใกล้ชิดกับคลาสภายนอก
/*
 * ประเภทของ Inner Class:
 * - Member Inner Class: คลาสภายในที่ไม่ใช่ static ซึ่งเป็นสมาชิกของคลาสภายนอก
 * - Static Nested Class: คลาสภายในที่เป็น static และไม่ต้องการอินสแตนซ์ของคลาสภายนอก
 * - Local Inner Class: คลาสที่ถูกประกาศภายใน method ซึ่งมีขอบเขตจำกัด
 * - Anonymous Inner Class: คลาสภายในที่ไม่มีชื่อ ใช้ในการสร้างออบเจ็กต์ที่มีพฤติกรรมเฉพาะ
 */

class OuterKlassen{ // Top level class
	

	/*
	 * Elemente der OuterKlassen
	 */
	private static int staticAtt = 1 ; 	
	private static void  staticMethode() {	System.out.println("3"); }
	private int att = 2 ; 	
	private void  methode() { System.out.println("4"); }

	/*
	 *  inner ( nested ,  member)
	 *  
	 *  1. Member Inner Class (คลาสภายในที่เป็นสมาชิก)
	 *     คลาสที่ไม่ใช่ static และอยู่ภายในคลาสภายนอก สามารถเข้าถึงสมาชิกทุกตัวของคลาสภายนอกได้ 
	 *     ต้องการอินสแตนซ์ของคลาสภายนอกเพื่อสร้างอินสแตนซ์ของคลาสภายในนี้
	 */
	class InnerKlass{
		
		void testAccess() {

			System.out.println(staticAtt);					// เข้าถึงตัวแปร static
			System.out.println(OuterKlassen.staticAtt);		// เข้าถึงตัวแปร static
			
			staticMethode();
			OuterKlassen.staticMethode();
			
			/*
			 * instanz 
			 */
			System.out.println(att); 	// OuterKlassen.this.att;		
			System.out.println(OuterKlassen.this.att);
			methode();					// OuterKlassen.this.methode();						
			OuterKlassen.this.methode();   
		}	

//		static void testAccess2() {			cf : The method testAccess2 cannot be declared static; static methods can only be declared in a static or top level type
//			
//		}
		
			
	}// end of InnerKlass
	
	
	/*
	 * static inner (static nested , static member)
	 * 
	 * 2. Static Nested Class (คลาสภายในที่เป็น static)
	 * 	  เป็นคลาสที่สามารถสร้างได้โดยไม่ต้องใช้อินสแตนซ์ของคลาสภายนอก และเข้าถึงได้เฉพาะสมาชิกที่เป็น static ของคลาสภายนอกเท่านั้น
	 */
	static class InnerStaticKlass{
		private String name = "name";   // wie Static variable
		void testAccess() {

			System.out.println(staticAtt);						// เข้าถึงตัวแปร static
			System.out.println(OuterKlassen.staticAtt);			// เข้าถึงตัวแปร static
			
			staticMethode();
			OuterKlassen.staticMethode();
		
			/*
			 * instanz in static Methode like static
			 */
			System.out.println(name); 	
			
			/*
			 * instanz 
			 */
//			System.out.println(att); 		// cf 
//			methode();						// cf 
//			OuterKlassen.methode(); 		// cf 		
//			OuterKlassen.this.methode();    // cf
	
		}
		static void testAccess2() {			 // ok

			System.out.println(staticAtt);						// เข้าถึงตัวแปร static
			System.out.println(OuterKlassen.staticAtt);			// เข้าถึงตัวแปร static
			
			staticMethode();
			OuterKlassen.staticMethode();
			
			/*
			 * instanz 
			 */
//			System.out.println(att); 		// cf 
//			methode();						// cf 
//			OuterKlassen.methode(); 		// cf 		
//			OuterKlassen.this.methode();    // cf
		}
		
		
	}// end of InnerStaticKlass
	

	
	//*******************  Erzeuge Anonym Klasse  *******************************// 
	
	
	/*
	 * 3. Anonymous Inner Class (คลาสภายในที่ไม่ระบุตัวตน)
	 * 	  คลาสนี้ถูกสร้างขึ้นโดยไม่มีชื่อ ใช้ในสถานการณ์ที่ต้องการสร้างคลาสชั่วคราวที่มีพฤติกรรมเฉพาะ 
	 *    ไม่สามารถสร้าง constructor ได้โดยตรง และสามารถใช้ได้กับคลาสหรือ interface เท่านั้น
	 */
	static Object staticTest = new Object(){
		void testAccess() {  //  ( funktioniert wie static )
			System.out.println(staticAtt);
			System.out.println(OuterKlassen.staticAtt);
			staticMethode();
			OuterKlassen.staticMethode();
			
//			System.out.println(att); 		// cf 
//			methode();						// cf 
//			OuterKlassen.methode(); 		// cf 		
//			OuterKlassen.this.methode();    // cf   
		}	
	};
	
		/*
		 * Erzeuge Anonym Klasse : สำหรับ instance member
		 */
	Object test = new Object(){
		void testAccess() { 				 //  ( funktioniert wie nicht-static )
			System.out.println(staticAtt);
			System.out.println(OuterKlassen.staticAtt);
			staticMethode();
			OuterKlassen.staticMethode();
				
			System.out.println(att); 	//  ok : OuterKlassen.this.att;		
			System.out.println(OuterKlassen.this.att);
			methode();					// ok :  OuterKlassen.this.methode();						
			OuterKlassen.this.methode();    
		}	
	};
	
	//*******************  Erzeuge innere Klasse mit umschließende Methode *******************************// 
	
	/*
	 * 4. Local Inner Class (คลาสภายในที่อยู่ภายใน method)
	 *    คลาสที่อยู่ภายใน method ใด method หนึ่ง สามารถเป็นได้ทั้งแบบ static และ non-static ขึ้นอยู่กับ method ที่ล้อมรอบ
	 *    สามารถเข้าถึงตัวแปรที่เป็น final หรือ effectively final ได้
	 */
	/*
	 * การกำหนดคลาสภายใน (Inner Class) ให้เป็น static ภายในเมธอดนั้น 'ไม่สามารถทำได้'
	 * เนื่องจากใน Java กฎระบุว่า Local Inner Class ภายในเมธอดไม่สามารถประกาศเป็น static ได้ แม้ว่าเมธอดนั้นจะเป็นเมธอดแบบ static ก็ตาม
	 */		
	
	/*
	 *  statische umschließende Methode
	 *  
	 **** ใน static method คลาสนี้ทำงานเหมือน static inner class:
	 */
	static void staticMethodeWithLocalClasses() {
		
		final String localMessage = "Hello from Local inner class!";
		// Local inner class
        class Local {
            public void show() {
                System.out.println(localMessage); // เข้าถึงตัวแปรใน method
            }
        }

        Local local = new Local();
        local.show();
        
		/*
		 * lokale Klasse (wie eine statische Klasse )
		 */
		class StaticLocalClass{  
			
			void testAccess() { 		 //  ( funktioniert wie static )
				System.out.println(staticAtt);								// เข้าถึงตัวแปร static
				System.out.println(OuterKlassen.staticAtt); 				// เข้าถึงตัวแปร static
				staticMethode();
				OuterKlassen.staticMethode();
				System.out.println(localMessage);
				/*
				 * instanz 
				 */
//				System.out.println(att); 		// cf 
//				methode();						// cf 
//				OuterKlassen.methode(); 		// cf 		
//				OuterKlassen.this.methode();    // cf
			}
		}		
	}
	
	/*
	 * nicht-statische umschließende Methode
	 * ใน static method คลาสนี้ทำงานเหมือน static inner class:
	 */
	void methodeWithLocalClasses() {
		/*
		 * lokale Klasse (wie eine nichtstatische innere Klasse )
		 */
		class StaticLocalClass{   
			void testAccess() { 		//  ( funktioniert wie nicht-static )
				System.out.println(staticAtt);							// เข้าถึงตัวแปร static
				System.out.println(OuterKlassen.staticAtt);				// เข้าถึงตัวแปร static
				
				staticMethode();
				OuterKlassen.staticMethode();
				
				/*
				 * instanz 
				 */
				System.out.println(att); 	// OuterKlassen.this.att;		
				System.out.println(OuterKlassen.this.att);
				methode();					// OuterKlassen.this.methode();						
				OuterKlassen.this.methode();   
			}	
		}
	}
	
	//*******************  Erzeuge innere Anonyme Klasse mit umschließende Methode *******************************// 
	
	/*
	 * lokale anonyme Klasse (wie eine statische Klasse )
	 * 
	 * 5. Anonymous Local Inner Class (คลาสภายในที่ไม่ระบุตัวตนในระดับ method)
	 * เป็นคลาสภายในที่สร้างขึ้นใน method และทำงานเหมือนคลาสภายในที่ไม่ระบุตัวตนในระดับ method
	 * 
	 */
	
	static void staticMethodeWithLocalAnonymeClasses() {
		
		/*
		 * ใน static method:
		 * lokale anonyme Klasse (wie eine statische Klasse ) 
		 */
		new Object() {
			void testAccess() {  		//  ( funktioniert wie static )
				System.out.println(staticAtt);								// เข้าถึงตัวแปร static
				System.out.println(OuterKlassen.staticAtt);					// เข้าถึงตัวแปร static
				
				staticMethode();
				OuterKlassen.staticMethode();
				
				/*
				 * instanz 
				 */
//				System.out.println(att); 		// cf 
//				methode();						// cf 
//				OuterKlassen.methode(); 		// cf 		
//				OuterKlassen.this.methode();    // cf
			}	
		};   // immmer mit semicolon 
	}
	
	/*
	 * nicht-statische umschließende Methode
	 * ใน static method คลาสนี้ทำงานเหมือน static inner class:
	 */
	void methodeWithLocalAnonymeClasses() {
		
		/*
		 * ใน non-static method:
		 * lokale anonyme Klasse (wie eine nichtstatische innere Klasse )
		 */
		new Object() {
			void testAccess() {  		//  ( funktioniert wie nicht-static )
				System.out.println(staticAtt);							// เข้าถึงตัวแปร static
				System.out.println(OuterKlassen.staticAtt);				// เข้าถึงตัวแปร static
				
				staticMethode();
				OuterKlassen.staticMethode();
				
				/*
				 * instanz 
				 */
				System.out.println(att); 	//  ok : OuterKlassen.this.att;		
				System.out.println(OuterKlassen.this.att);
				methode();					// ok :  OuterKlassen.this.methode();						
				OuterKlassen.this.methode();   
			}	
		};   // immmer mit semicolon 
	}
	
	
} // end of OuterKlassen


/*
 * **จุดสำคัญสำหรับการสอบ OCP:**
 * - Member Inner Class: ต้องมีอินสแตนซ์ของคลาสภายนอก และสามารถเข้าถึงสมาชิกทั้งหมดได้
 * - Static Nested Class: สามารถสร้างได้โดยไม่ต้องมีอินสแตนซ์ของคลาสภายนอก และเข้าถึงได้เฉพาะสมาชิกที่เป็น static
 * - Local Inner Class: ถูกประกาศใน method; สามารถเข้าถึงตัวแปรใน method ที่เป็น final หรือ effectively final ได้
 * - Anonymous Inner Class: ใช้สำหรับการสร้างออบเจ็กต์จาก interface หรือ abstract class ที่มีพฤติกรรมเฉพาะ
 * 
 * **ข้อดีของการใช้ Inner Class:**
 * - **Encapsulation**: คลาสภายในช่วยในการซ่อนการทำงานที่ไม่ต้องการให้คลาสภายนอกเข้าถึง
 * - **เข้าถึงสมาชิกของคลาสภายนอกได้ง่าย**: โดยเฉพาะใน Member Inner Class สามารถเข้าถึงสมาชิกของคลาสภายนอกได้โดยตรง
 * - **ใช้ในสถานการณ์ที่จำเป็นเท่านั้น**: เหมาะสำหรับคลาสที่ใช้ในที่เดียว เช่น anonymous หรือ local inner class
 */


public class AlleArtenDerInnerenKlassen {

	public static void main(String[] args) {

		OuterKlassen.InnerKlass o1 = new OuterKlassen().new InnerKlass();
//		InnerKlass o2 = new OuterKlassen.InnerKlass();  // cf : Es muss importieren 
														// import inner.OuterKlassen.InnerKlass;
		
		OuterKlassen.InnerStaticKlass o2 = new OuterKlassen.InnerStaticKlass();
		

	}

}
