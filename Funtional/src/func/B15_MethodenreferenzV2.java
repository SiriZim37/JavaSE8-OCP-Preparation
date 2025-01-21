package func;

import java.util.function.BiFunction;
import java.util.function.Function;

public class B15_MethodenreferenzV2 {


	/*
	 * Variante 2: Referenz auf einen Konstruktor
	 * 
	 * Voraussetzungen:
	 * 
	 * 1. Der Rumpf hat genau eine Anweisung
	 * 
	 * 2. Diese Anweisung ist der Aufruf eines Konstruktors
	 *    (oder return mit dem Aufruf eines Konstruktors als 
	 *    return-Argument)
	 *    
	 * 3. Alle Parameter der zu realisierenden abstrakten Methode
	 *    werden als Argumente an den Konstruktor übergeben
	 */
	
	/*
	 *  Variante 2: การอ้างอิงถึงคอนสตรักเตอร์ (Referenz auf einen Konstruktor) 
	 *  ใน Java โดยใช้ Method Reference เพื่ออ้างถึงคอนสตรักเตอร์โดยตรง 
	 *  ซึ่งช่วยลดความซับซ้อนของ Lambda Expression หรือ Anonymous Class ในบางกรณี
	 *  
	 *  เงื่อนไขของการใช้งาน (Voraussetzungen):
	 *  	1.บล็อกของคำสั่ง (Rumpf) มีเพียงคำสั่งเดียวเท่านั้น
	 *  		- คำสั่งนั้นคือการเรียกใช้คอนสตรักเตอร์
	 * 		2.คำสั่งนั้นต้องเป็นการสร้างอินสแตนซ์ใหม่ด้วยคอนสตรักเตอร์
	 *  		- หรือ return พร้อมกับการสร้างอินสแตนซ์ใหม่
	 *  	3. พารามิเตอร์ของเมธอดนามธรรมต้องถูกส่งไปยังคอนสตรักเตอร์โดยตรง
	 *  		- เช่นเดียวกับการส่งค่าผ่าน Lambda Expression
	 *  
	 *  			Constructor::new
	 */
	public static void main(String[] args) {
		
		/*
		 *   public StringBuilder(String str) {
        		super(str);
    		 }	
		 */
		// anonyme Klasse
		Function<String,StringBuilder> f1 = new Function<String, StringBuilder>() {
			public StringBuilder apply(String s) {
				return new StringBuilder(s);
			}
		};
		StringBuilder sb1 = f1.apply("Heute ist");
		sb1.append("Di");
		System.out.println(sb1 );
		
		
		// normale Lambda
		Function<String,StringBuilder> f2 = (String s) -> new StringBuilder(s);
		StringBuilder sb2 = f2.apply("Heute ist");
		sb2.append("Mi");
		System.out.println(sb2 );
		
		
		// Methodenreferenz
		Function<String, StringBuilder> f3 = StringBuilder::new;
		/*
		 * Klass nachbilden
		 * 
		 * 		class Blabla implements Function<String, StringBuilder>{
		 * 			public StringBuilder apply(String s){
		 * 				return new StringBuilder(s));
		 * 			}
		 * 		}
		 */
		StringBuilder sb3 = f3.apply("Heute ist");
		sb3.append("Do");
		System.out.println(sb3 );
		
		
		/*
		 * public int compareTo(String anotherString)
		 * 
		 * T is the type of the first input parameter (e.g., String),
			U is the type of the second input parameter (e.g., String),
			R is the return type (e.g., Integer).

		 */
		// method signature: (String, String) -> Integer.
		BiFunction<String, String, Integer> compareStrings = String::compareTo;
		Integer result = compareStrings.apply("apple", "banana");
        System.out.println("Result: " + result);
        
	}

}
