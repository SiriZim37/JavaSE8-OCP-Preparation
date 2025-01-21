package klausur;

/*
 Gegeben sind das Interface 'I' und die Klasse 'C':

  interface I {  
    void m(); 
  }
  class C implements I { 
    public void m() {} 
  }

Was kompiliert?
Eine oder mehrere richtige Antworten sind möglich.

[   ]   I var = C::new;
[   ]   I var = C::m;
[   ]   I var = System::console;
[   ]   I var = new Object()::toString;
 */


interface I {  
    void m(); 
  }

class C implements I { 
    public void m() {} 
}
  

public class TestInterface2 {
	/*
	 * Antwort 1 :  correct  
	 *  I var1 = C::new; 
	 */
	class Blabla implements I{
		public void m() {
			new C();
		}
	}
	
	/*
	 * Antwort 2 :  incorrect  
	 *  I var2 = C::m;	
	 */
//	class Blabla2 implements I{
//		public void m() {
//			C.m();
//		}
//	}
	
	/*
	 * Antwort 3 :  correct  
	 * I var3 = System::console;
	 */
	class Blabla3 implements I{
		public void m() {
			System.console();
		}
	}
	
	/*
	 * Antwort 4 :  correct  
	 * I var3 = System::console;
	 */
	class Blabla4 implements I{
		public void m() {
			new Object().toString();
		}
	}
	
	public static void main(String[] args) {
		
			 I var1 = C::new;			// ok > Reference to a Constructor 
			 
//			 I var2 = C::m;				// cf > Reference to an Instance Method of a Particular Object
			 C val = new C();
			 I val22 = val::m;
			 
			 I var3 = System::console;	// System::console เป็น method reference สำหรับเมธอด console() 
			 							// ที่เป็นเมธอดสแตติก (static method) ในคลาส System ของ Java
			 							// เมธอด console() ในคลาส System จะคืนค่า Console object หรือคืนค่า null ถ้าระบบไม่รองรับ console

			 
			 I var4 = new Object()::toString; /// ???????????????
	}

}

/*

Syntax ของ Method Reference:

		1. Reference to a Static Method
			การอ้างถึงเมธอดแบบสแตติก (Static Method Reference) ใช้ในกรณีที่เราต้องการอ้างถึงเมธอดที่เป็น static โดยตรงผ่านชื่อคลาส
				
				ClassName::staticMethodName
		
		2. Reference to an Instance Method of a Particular Object
			การอ้างถึงเมธอดของออบเจกต์เฉพาะ
				
				instance::instanceMethodName
		
		3. Reference to an Instance Method of an Arbitrary Object of a Particular Type
			การอ้างถึงเมธอดของออบเจกต์ใดๆ ในคลาสที่กำหนด
					
				ClassName::instanceMethodName
		
		4. Reference to a Constructor 
			การอ้างถึงคอนสตรักเตอร์ (Constructor Reference) ใช้เพื่อสร้างออบเจกต์ใหม่
		
				ClassName::new

*/

