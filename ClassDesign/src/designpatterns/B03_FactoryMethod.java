package designpatterns;

import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

/*
 *  Factory Method คือ รูปแบบการออกแบบ (Design Pattern) 
 *  ที่ช่วยให้การสร้างออบเจ็กต์ (Object) เกิดขึ้นผ่านเมธอด (Method) 
 *  โดยที่เมธอดนี้จะรับผิดชอบในการสร้างออบเจ็กต์นั้นๆ แทนที่จะสร้างออบเจ็กต์โดยตรงจากคอนสตรัคเตอร์ของคลาส
 *  
 *  Factory Method ใช้เมื่อคุณต้องการให้คลาสหนึ่งสามารถสร้างอ็อบเจ็กต์หลายประเภทได้ โดยไม่ต้องบอกชนิดของอ็อบเจ็กต์ที่ต้องการสร้างในที่เดียว.
 */
//1. สร้าง Interface หรือ Abstract Class เพื่อกำหนดแม่แบบ
abstract class Product {
	public abstract void use();
}

//2. สร้าง Concrete Class (คลาสจริง) ที่จะถูกสร้าง
class ConcreteProductA extends Product {
 @Override
 public void use() {
     System.out.println("Using Product A");
 }
}

class ConcreteProductB extends Product {
 @Override
 public void use() {
     System.out.println("Using Product B");
 }
}

//3. สร้าง Factory Method ในคลาส
abstract class Creator {
	public abstract Product createProduct();
}

//4. Implement Factory Method สำหรับแต่ละชนิดของ Product
class ConcreteCreatorA extends Creator {
 @Override
 public Product createProduct() {
     return new ConcreteProductA();
 }
}

class ConcreteCreatorB extends Creator {
 @Override
 public Product createProduct() {
     return new ConcreteProductB();
 }
}

public class B03_FactoryMethod {

	/*
	 * Factory Method : Ein Objekt mithilfe einer Methode erzeugen , 
	 *  die das Bilden des Objektes übernimmt.
	 *  
	 *  Factory Method : ใช้เมธอดในการสร้างออบเจ็กต์ ที่รับผิดชอบในการสร้างออบเจ็กต์
	 *  
	 *  ข้อดีของการใช้ Factory Method:
	 *  1. คุณสามารถควบคุมวิธีการสร้างออบเจ็กต์ได้
	 *  2. สามารถแยกการสร้างออบเจ็กต์ออกจากส่วนอื่นๆ ของโปรแกรม
	 *  3. ช่วยให้โค้ดมีความยืดหยุ่นและสามารถปรับเปลี่ยนการสร้างออบเจ็กต์ได้ง่ายในภายหลัง
	 */
	public static void main(String[] args) {

		// ใช้ factory method จาก NumberFormat เพื่อสร้างออบเจ็กต์ NumberFormat
		NumberFormat nf = NumberFormat.getCurrencyInstance();		   // factory method  : NumberFormat.getCurrencyInstance()
		
		String text =  nf.format(12.789);
		System.out.println("text : " + text);	// text : 12,79 €
		
		/*
		 * weitere Beispiele
		 */
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MM"); 	//  factory method  : DateTimeFormatter.ofPattern("dd MM")
		Comparator<String> cmp =  Comparator.reverseOrder();			//  factory method  : Comparator.reverseOrder()
		//...
		
		
		 Creator creatorA = new ConcreteCreatorA();
	     Product productA = creatorA.createProduct();
	     productA.use(); // Output: Using Product A

	     Creator creatorB = new ConcreteCreatorB();
	     Product productB = creatorB.createProduct();
	     productB.use(); // Output: Using Product B
	}

}
