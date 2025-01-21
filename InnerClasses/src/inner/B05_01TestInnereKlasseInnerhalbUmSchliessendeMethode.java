package inner;


/*
 * kann eine lokale Klasse in ihren Methoden auf die lokalen Variablen 
 * der umschliessenden Methode zugreifen?
 * 
 * 	Ja, eine lokale Klasse kann in ihren Methoden auf die lokalen Variablen
 * 	der umschließenden Methode zugreifen, aber diese Variablen dürfen nach
 * 	ihrer Initialisierung nicht mehr verändert werden. Sie müssen also entweder
 * 	`final` oder effektiv `final` sein.
 */
/*
 * คลาสภายในที่อยู่ในเมธอดสามารถเข้าถึงตัวแปรท้องถิ่นของเมธอดที่ล้อมรอบได้หรือไม่?
 * 
 * ใช่, คลาสภายในที่อยู่ในเมธอดสามารถเข้าถึงตัวแปรท้องถิ่นของเมธอดที่ล้อมรอบได้
 * แต่ตัวแปรเหล่านั้นไม่สามารถถูกแก้ไขหลังจากที่มันถูกกำหนดค่าแล้ว
 * ดังนั้น ตัวแปรเหล่านั้นจะต้องเป็น `final` หรือ `effectively final` เท่านั้น
 */
class OuterClass{
	private static int staticAtt = 1 ;
	void UmschliessendeMethode() {
		 	
		final int s = 10;  // explizit final
		int x = 5;         // effektiv final		
		int y = 3;         // effektiv final, weil y nicht verändert wird

		int z = 2;
		z = 1;
		
		class LocalClass{    // lokale Klass
			
			void printVariable() {
				System.out.println("s : " + s);  // ok
				System.out.println("x : " + x);  // ok
				System.out.println("y : " + y);  // ok 
//				System.out.println("z : " + z);  // cf 
				System.out.println(staticAtt);  // ok
			}			
		} // end of LocalClass

//		y = 30; // an sich ok , aber dadurch ensteht 
				// ein Compiliertfehler in der printVariable der Klasse UmschliessendeMethode
	

		abstract class AbstractGame2{
			 abstract void printMessage();
		}	
		class ConcreteInner extends AbstractGame2 {
	          void printMessage() {
	                System.out.println("Concrete implementation!");
	         }
	    }
//		Game2 g2 = new Game2();   // cf 
		
		AbstractGame2 instance = new ConcreteInner();
        instance.printMessage();
	} 
	
	
	
} // end of OuterClass




public class B05_01TestInnereKlasseInnerhalbUmSchliessendeMethode {

	public static void main(String[] args) {

		OuterClass o = new OuterClass();
		o.UmschliessendeMethode();
	}

}
