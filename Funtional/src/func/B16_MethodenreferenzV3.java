package func;

import java.util.Locale;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class B16_MethodenreferenzV3 {


	/*
	 * Variante 3: Referenz auf eine Instanzmethode eines
	 * vorhandenen Objektes
	 * (Reference to an instance method of a particular object)
	 * 
	 * Voraussetzungen:
	 * 
	 * 1. Der Rumpf hat genau eine Anweisung
	 * 
	 * 2. Diese Anweisung ist der Aufruf einer Instanzmethode
	 *    mit einer bekannten Referenz
	 *    (oder return mit dem Aufruf einer Instanzmethode
	 *     mit einer bekannten Referenz als return-Argument)
	 *    
	 * 3. Alle Parameter der zu realisierenden abstrakten Methode
	 *    werden als Argumente an die Instanzmethode übergeben
	 */
	/*
	 * Variante 3: การอ้างอิงถึงเมธอดของออบเจกต์ที่มีอยู่แล้ว (Referenz auf eine Instanzmethode eines vorhandenen Objektes) 
	 * ใน Java โดยใช้ Method Reference ซึ่งเป็นวิธีการที่ช่วยลดความซับซ้อนของโค้ดในกรณีที่ต้องเรียกใช้เมธอดของออบเจกต์ที่มีอยู่แล้ว
	 * 
	 * เงื่อนไขการใช้งาน (Voraussetzungen):
	 * 		1. บล็อกคำสั่ง (Rumpf) มีคำสั่งเพียงหนึ่งคำสั่ง
	 * 			-คำสั่งนั้นคือการเรียกใช้อินสแตนซ์เมธอดผ่านออบเจกต์ที่มีอยู่แล้ว
	 * 		2. คำสั่งนั้นต้องเรียกใช้อินสแตนซ์เมธอดผ่านรีเฟอเรนซ์ที่รู้จัก
	 * 			- หรือ return พร้อมกับเรียกใช้อินสแตนซ์เมธอ
	 * 		3. พารามิเตอร์ทั้งหมดของเมธอดนามธรรม จะถูกส่งไปยังอินสแตนซ์เมธอด
	 */
	
	public static void main(String[] args) {
		
		// ในโค้ดนี้มีตัวแปร ref ที่เป็น Integer ซึ่งเราต้องการเรียกใช้เมธอด doubleValue() ผ่านรูปแบบต่าง ๆ ดังนี้:
		
		/*
		 * public double doubleValue() {
        		return (double)value;
    		}
		 */
		Integer ref = 42;
		
		//anonyme Klasse
		Supplier<Double> s1 = new Supplier<Double>() {
			public Double get() {
				return ref.doubleValue();
			}
		};
		
		Double d1 = s1.get();
		System.out.println("d1: " + d1);
		
		
		// normale Lambda
		Supplier<Double> s2 = () -> ref.doubleValue();
		
		Double d2 = s2.get();
		System.out.println("d2: "+d2);
		
		// Methodenreferenz
		Supplier<Double> s3 = ref::doubleValue;
		Double d3 = s3.get();
		System.out.println("d3: "+d3);
		
		// Test
		Supplier<Double> s4 = new Integer(42)::doubleValue;
//		Supplier<Double> s5 = new ????????????????
		
		//-------------------------------------------------------------//
	
		 // Object ที่เราจะใช้อ้างถึง
		
		/*
		 *  public String toUpperCase() {
		        return toUpperCase(Locale.getDefault());
		    }
		 */
		
        String text = "hello world";

        // ใช้ anonymous class
        Supplier<String> a1 = new Supplier<String>() {
            public String get() {
                return text.toUpperCase();
            }
        };
        System.out.println(a1.get()); // Output: HELLO WORLD

        // ใช้ lambda expression
        Supplier<String> a2 = () -> text.toUpperCase();
        System.out.println(a2.get()); // Output: HELLO WORLD

        // ใช้ method reference
        Supplier<String> a3 = text::toUpperCase;
        System.out.println(a3.get()); // Output: HELLO WORLD
        
	
	}
	
	
}
