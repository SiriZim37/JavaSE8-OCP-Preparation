package func;

import java.util.function.Function;

public class B14_MethodenreferenzV1 {

	/*
	 *
	 * 
	 * Variante 1: Referenz auf eine statische Methode
	 * 
	 * Voraussetzungen:
	 * 
	 * 1. Der Rumpf hat genau eine Anweisung
	 * 
	 * 2. Diese Anweisung ist der Aufruf einer statischen Methode
	 *    (oder return mit dem Aufruf einer statischen Methode als 
	 *    return-Argument)
	 *    
	 * 3. Alle Parameter der zu realisierenden abstrakten Methode
	 *    werden als Argumente an die statische Methode übergeben
	 */
	/*
	 * Variante 1 เป็นรูปแบบที่ใช้สำหรับอ้างอิงถึงเมธอดสแตติกที่:
	 * 		1. บล็อกของคำสั่ง (Rumpf) มีเพียงคำสั่งเดียวเท่านั้น เช่น การเรียกใช้เมธอด หรือคำสั่ง return พร้อมกับการเรียกใช้เมธอด
	 * 		2. คำสั่งนั้นคือการเรียกใช้เมธอดแบบสแตติก (static method) หรืออาจเป็นคำสั่ง return ที่มีการส่งค่ากลับจากเมธอดแบบสแตติก
	 * 		3. พารามิเตอร์ทั้งหมดของเมธอดแบบนามธรรมที่ต้องการใช้งานจะถูกส่งไปยังเมธอดแบบสแตติก 
	 * 			หมายถึงว่า พารามิเตอร์ที่จำเป็นสำหรับเมธอด static จะถูกใช้เป็นอาร์กิวเมนต์ในการเรียกใช้เมธอดแบบสแตติก
	 * 
	 * 
	 *  			ClassName::staticMethodName
	 */
	public static void main(String[] args) {
		
		/*
		 *    public static Integer valueOf(String s) throws NumberFormatException {
			        return Integer.valueOf(parseInt(s, 10));
			  }
		 */
		
		class IntParser implements Function<String ,Integer>{
			public Integer apply(String s) {
				return Integer.valueOf(s);
			}
		}
		
		Function<String, Integer> f0 = new IntParser();
		Integer i0 = f0.apply("+42");
		System.out.println("i0 = " + i0);
		
		Function<String, Integer> f1 = new  Function<String ,Integer>(){
				public Integer apply(String s) {
					return Integer.valueOf(s);
				}
		};
		Integer i1 = f1.apply("+42");
		System.out.println("i1 = " + i1);
		
		// normale Lambda
		Function<String, Integer> f2 = (String s) -> {
			return Integer.valueOf(s);
		};
		Integer i2 = f2.apply("+42");
		System.out.println("i2 = " + i2);
		
//		Interface Function <T, R>
		Function<String, Integer> f3 = (String s) -> Integer.valueOf(s);  // (Integer valueOf(String s)) : 
																		  // String s :(Argument parameter)
																		  // Integer : (Return Rückgabe result) 
		Integer i3 = f3.apply("+42");
		System.out.println("i3 = " + i3);

		// Methodenreferenz
		Function<String, Integer> f4 = Integer::valueOf;		
		
		/*
		 * Klass nachbilden
		 * 
		 * 		class Blabla implements Supplier<Double>{
		 * 			public Integer apply(String s);{
		 * 				return Integer.valueOf(s);
		 * 			}
		 * 		}
		 */
		
		Integer i4 = f4.apply("+42");
		System.out.println("i4 = " + i4);
	}

}
