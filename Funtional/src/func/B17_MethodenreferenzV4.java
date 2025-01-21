package func;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class B17_MethodenreferenzV4 {

	/*
	 * Variante 4: Referenz auf eine Instanzmethode eines
	 * unbestimmten Objektes von einem bekannten Typ
	 * (Reference to an instance method of an arbitrary object 
	 *  of a particular type)
	 *  
	 * Anders gesagt:
	 * 
	 * Referenz auf die Instanzmethode des ersten Parameters
	 * (der zu realisierenden abstrakten Methode)
	 *  
	 * 
	 * Voraussetzungen:
	 * 
	 * 1. Der Rumpf hat genau eine Anweisung
	 * 
	 * 2. Diese Anweisung ist der Aufruf einer Instanzmethode
	 *    mit dem ersten Parameter der zu realisierenden abstrakten Methode
	 *    (oder return mit dem Aufruf dieser Instanzmethode)
	 *    
	 * 3. Alle weiteren Parameter der zu realisierenden abstrakten Methode
	 *    werden als Argumente an die Instanzmethode übergeben
	 */
	
	/*
	 * ใน Variante 4 เราอ้างถึง instance method ของ object ที่ไม่กำหนด (arbitrary object)
	 * แต่ ต้องเป็นประเภทที่เรารู้จัก (particular type) โดยอิงตาม parameter แรกของ functional interface ที่กำหนด
	 * 
	 * เงื่อนไข (Voraussetzungen):
	 * 
	 * 		1. Method Reference ชี้ไปที่ instance method: เมธอดต้องเป็น instance method ที่สามารถเรียกใช้ได้
	 * 		2.ใช้ parameter ตัวแรกของ abstract method:
	 * 			- parameter แรกจะถูกใช้เป็น object ที่เรียกใช้ instance method
	 * 		3.Parameter อื่น ๆ ถูกส่งเป็น argument:
	 *	 		-parameter อื่นที่เหลือใน abstract method จะถูกส่งต่อให้ instance method
	 *
	 *				ClassName::methodName
	 *
	 *	- ClassName: ประเภทของ object
	 *	- methodName: ชื่อ instance method ที่ต้องการอ้างถึง
	 *	- ใช้กับ functional interface ที่มี parameter ตัวแรกตรงกับประเภทของ object
	 */
	public static void main(String[] args) {
		
		// anonyme Klasse
		BinaryOperator<String> op1 =  new BinaryOperator<String>() {
			public String apply(String s1, String s2) {
				return s1.concat(s2);
			}
		};
		
		String str1 = op1.apply("ja", "va");
		System.out.println("str1 ="+str1);
		
		// normale Lambda
		BinaryOperator<String> op2 = (s1 , s2) -> s1.concat(s2);
		String str2 = op2.apply("ja", "va");
		System.out.println("str2 ="+str2);
		
		// Methodenreferenz	
		BinaryOperator<String> op3 = String::concat;
		String st3 = op3.apply("ja", "va");
		System.out.println("st3 ="+st3);
	
		// UnaryOperator<T> extends Function<T, T> 
//		UnaryOperator<String> op4 = String::concat;		// cf 
		
		/*
		 * UnaryOperator<T> เป็นการดำเนินการที่รับค่าเข้า 1 ตัวของประเภท T และส่งคืนค่าออกเป็นประเภทเดียวกัน (T)
		 */

		//2. การแปลงตัวอักษรเป็นพิมพ์ใหญ่ด้วย UnaryOperator
		UnaryOperator<String> op4 = String::toUpperCase;
		/*
		 * อธิบาย:
		 * UnaryOperator<String> รับ String หนึ่งตัวและคืนค่า String
		 * เมธอด String::toUpperCase ถูกเรียกบน String ที่เป็น parameter ของ apply()
		 */
		
		
		/*	
		 *  ในกรณีของ String::concat นั้น เมธอดนี้ใช้ในการนำ String สองตัวมาต่อกัน 
		 *  (ตัวแรกคือ String ที่เรียกใช้เมธอด และตัวที่สองคือ String ที่ต้องการนำมาต่อ)
		 *  ซึ่งไม่ตรงกับเงื่อนไขของ UnaryOperator<T>
		 */
		// BinaryOperator  เพราะมันทำงานกับข้อมูล 2 ตัว:
		BinaryOperator<String> op5 = String::concat;
		
		
		// 1. การเชื่อม String ด้วย BinaryOperator
		BinaryOperator<String> op6 = String::concat;
		String result = op3.apply("Hello, ", "World!");
		System.out.println(result); // Output: Hello, World!
		/*
		 * อธิบาย:
		 * 
		 * BinaryOperator<String> เป็น functional interface ที่รับ String สองตัวและคืนค่า String
		 * 
		 * เมธอด String::concat จะใช้ parameter ตัวแรก (เช่น "Hello, ") เป็น object 
		 * ที่เรียก concat() และ parameter ตัวที่สอง (เช่น "World!") เป็น argument
		 */
		
		//---------------------------------------------------------------------------------------//
		
//		!!!!! ข้อควรรู้: กรณีที่ใช้ UnaryOperator กับ String::concat: !!!
		
//		UnaryOperator<String> op = String::concat; // ไม่ได้! (compile error)
		
		//เหตุผล: String::concat ต้องการ String สองตัว: ตัวแรกคือ object ที่เรียกใช้ และตัวที่สองคือ argument 
		// แต่ UnaryOperator รับเพียง parameter เดียว
	}
	
	
}
