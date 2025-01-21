package streams.wdh;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class B16_17_18_terminal_reduce {

	/*
	 * reduce : für immutable Reduction ( keine Objekte aus dem Kontext ändern)
	 * 
	 * reduce เป็นเครื่องมือที่มีประโยชน์ในการทำงานกับข้อมูลที่ไม่เปลี่ยนแปลง (immutable) 
	 * ช่วยให้เราสามารถรวมค่าต่าง ๆ จาก Stream ได้อย่างมีประสิทธิภาพ โดยไม่ต้องเปลี่ยนแปลงข้อมูลต้นฉบับ
	 * 
	 * การใช้งาน:
	 * มักใช้ในการคำนวณค่าต่าง ๆ เช่น 
	 * 		ผลรวม (sum), 
	 * 		ผลคูณ (product),
	 * 		หาค่าต่ำสุด (minimum), 
	 * 		หาค่าสูงสุด (maximum) 
	 * 		หรือแม้กระทั่งการเชื่อมต่อสตริง (concatenation)
	 * 
	 * 
	 * - reduce: für immutable Reduction (keine Objekte aus dem Kontext ändern)
	 * 
	 * 1. Optional<T> reduce(BinaryOperator<T> accumulator)
	 * 
	 * 		- kann den Datentyp nicht ändern.
	 * 		- imparallelen Modus wird der Accumulator wird als auch als Combiner verwendet.
	 * 
	 * 2. T reduce(T identity, BinaryOperator<T> accumulator)
	 * 
	 * 3. <U> U reduce(U identity,BiFunction<U, ? super T, U> accumulator,BinaryOperator<U> combiner)
	 * 		
	 * 		- kann den Datentyp  ändern.
	 */
	public static void main(String[] args) {
	
		
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		
		/* Variante 1
		 * 
		 * Optional<T> reduce(BinaryOperator<T> accumulator)
		 * 
		 * 		- kann den Datentyp  ändern.
		 * 		- imparallelen Modus wird der Accumulator wird als auch als Combiner verwendet.
		 */
		
		BinaryOperator<Integer> acc = (x1 , x2) -> x1 + x2 ;
		
		
		Optional<Integer> mayInt =  list.stream()		// Stream<Integer>
										.reduce(acc);	// Optional<Integer>
		System.out.println("summ : " + mayInt.get());
		
		/*
		 * reduce , sequentiell
		 * 
		 * Daten : 1 2 3 4 5 
		 * 
		 * Schritt 1: 
		 * 		x1 = 1 
		 *  	x2 = 2 
		 *  	ergebnis = acc.apply(x1,x2) = 3 
		 * Schritt 2: 
		 * 		x1 = 3  (erg aus Schritt 1)
		 *  	x2 = 3  (nächstes Element)
		 *  	ergebnis = acc.apply(x1,x2) = 6 
		 * Schritt 3: 
		 * 		x1 = 6   (erg aus Schritt 2)
		 *  	x2 = 4   (nächstes Element)
		 *  	ergebnis = acc.apply(x1,x2) = 10
		 * Schritt 4: 
		 * 		x1 = 10  (erg aus Schritt 3)
		 *  	x2 = 5   (nächstes Element)
		 *  	ergebnis = acc.apply(x1,x2) = 15 <<< Das Ergebnis zurückliefert! 
		 */
		
		System.out.println("------------------------------------------------------------------\n");
		
		
		
		/* Variante 2
		 * 
		 * T reduce(T identity, BinaryOperator<T> accumulator)
		 * 
		 */	
		
		Integer identity = 0 ; //  'berechnungsneutraler' Wert
		Integer summ = list.stream()					// Stream<Integer>
						   .reduce(identity , acc);		// Integer
				
		System.out.println("summ : " + summ);
		
		/*
		 * reduce , sequentiell
		 * 
		 * Daten : 1 2 3 4 5 
		 * 
		 * Schritt 0: 
		 * 		identity = 0 
		 *  	x1 = 1
		 *  	ergebnis = acc.apply(identity,x1) = 2 
		 * Schritt 1: 
		 * 		x1 = 1 
		 *  	x2 = 2 
		 *  	ergebnis = acc.apply(x1,x2) = 3 
		 * Schritt 2: 
		 * 		x1 = 3  (erg aus Schritt 1)
		 *  	x2 = 3  (nächstes Element)
		 *  	ergebnis = acc.apply(x1,x2) = 6 
		 * Schritt 3: 
		 * 		x1 = 6   (erg aus Schritt 2)
		 *  	x2 = 4   (nächstes Element)
		 *  	ergebnis = acc.apply(x1,x2) = 10
		 * Schritt 4: 
		 * 		x1 = 10  (erg aus Schritt 3)
		 *  	x2 = 5   (nächstes Element)
		 *  	ergebnis = acc.apply(x1,x2) = 15 <<< Das Ergebnis zurückliefert! 
		 */
		
		
		System.out.println("------------------------------------------------------------------\n");
		
		/* Variante 3
		 * 
		 *  <U> U reduce(U identity,BiFunction<U, ? super T, U> accumulator,BinaryOperator<U> combiner)
		 *  
		 */	
		bsp1();
		bsp2();
		bsp3();
		bsp4();
		

	}

	static void bsp1(){
		System.out.println("Bsp. 1 ");
		
		/* <U> U reduce(U identity,
		 * 				BiFunction<U, ? super T, U> accumulator,
		 * 				BinaryOperator<U> combiner)
		 * 	
		 * 		- kann den Datentyp nicht ändern.
		 */
		
		/* - sequentiell
		 * - Datentyp wird nicht geändert.
		 */
		
		List<Integer> list = Arrays.asList(1,2,3,4,5);
			
		int identity = 0 ; 	
		BiFunction<Integer, Integer, Integer> acc = ( element , nextElement) -> {
			System.out.println("acc : " +  element + "+" + nextElement + " = " + (element + nextElement) );
			return element + nextElement;
		};
		BinaryOperator<Integer>	combiner = (x , y) -> x*1111; // sinnlose wird später geändert !
 		
		int summ = list.stream()							// Stream<Integer>
					.reduce(identity, acc , combiner);		// Integer
				
		System.out.println("summ : " + summ);
		
		/*
		 * reduce  
		 * 
		 * Daten : 1 2 3 4 5 
		 * 
		 * Schritt 0: 
		 * 		element = identity
		 *  	nextElement = 1	
		 *  	ergebnis = acc.apply(element,nextElement) = 2 
		 * Schritt 1: 
		 * 		element = 1 
		 *  	nextElement = 2 
		 *  	ergebnis = acc.apply(element,nextElement) = 3 
		 * Schritt 2: 
		 * 		element = 3  (erg aus Schritt 1)
		 *  	nextElement = 3  (nächstes Element)
		 *  	ergebnis = acc.apply(element,nextElement) = 6 
		 * Schritt 3: 
		 * 		element = 6   (erg aus Schritt 2)
		 *  	nextElement = 4   (nächstes Element)
		 *  	ergebnis = acc.apply(element,nextElement) = 10
		 * Schritt 4: 
		 * 		element = 10  (erg aus Schritt 3)
		 *  	nextElement = 5   (nächstes Element)
		 *  	ergebnis = acc.apply(element,nextElement) = 15 <<< Das Ergebnis zurückliefert! 
		 */
		System.out.println("------------------------------------------------------------------\n");
	}

	static void bsp2(){
		System.out.println("Bsp. 2 ");
		
		/* <U> U reduce(U identity,
		 * 				BiFunction<U, ? super T, U> accumulator,
		 * 				BinaryOperator<U> combiner)
		 * 
		 */
		
		/* 
		 * - sequentiell
		 * - Datentyp wird  geändert.
		 * 
		 * Aufgaben hier : Zahlen in Strings verwandeln und 
		 * solche Strings zu einem Gesamtstring zu Koontaktieren.
		 */
	
		List<Integer> list = Arrays.asList(1,2,3,4,5);
				
		String idt = "";
		BiFunction<String, Integer, String> acc = (String str ,Integer index) -> {
			System.out.println("acc : " +  str + "+" + index + " = " + (str + index) );
			return str + index;
		};
		BinaryOperator<String> cmb = (str1 , str2 ) -> "moin";	// sinnlos , wird später geändert
		
		String s = list.stream()					// Stream<Integer>
						.reduce(idt , acc , cmb);
		
		System.out.println("Ergebnis :" + s);
		/*
		 * reduce  
		 * 
		 * Daten : 1 2 3 4 5 
		 * 
		 * Schritt 1: 
		 * 		str = "" 
		 *  	index = 1	 (1. Element)
		 *  	ergebnis = acc.apply(str,index) = "1"
		 * Schritt 2: 
		 * 		str = "1" 
		 *  	index = 2	 (2. Element)
		 *  	ergebnis = acc.apply(str,index) = "12"
		 * Schritt 3: 
		 * 		str = "12" 
		 *  	index = 3	 (3. Element)
		 *  	ergebnis = acc.apply(str,index) = "123"
		 * Schritt 4: 
		 * 		str = "123" 
		 *  	index = 4	 (4. Element)
		 *  	ergebnis = acc.apply(str,index) = "1234"
		 * Schritt 5: 
		 * 		str = "1234" 
		 *  	index = 5	 (5. Element)
		 *  	ergebnis = acc.apply(str,index) = "12345" <<< Das Ergebnis zurückliefert! 
		 */
		System.out.println("------------------------------------------------------------------\n");
	}
	

	private static void bsp3() {
		System.out.println("Bsp. 3");
		
		/* <U> U reduce(U identity,
		 * 				BiFunction<U, ? super T, U> accumulator,
		 * 				BinaryOperator<U> combiner)
		 * 
		 * 	- kann den Datentyp ändern
		 * 
		 */
		
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		
		Integer idt = 0;
		 BiFunction<Integer, Integer, Integer> acc = (a, b) -> {
	            System.out.println("thread " + Thread.currentThread().getId() +", acc : " + a + " + " + b + " = " + (a + b));
	            return a + b;
	        };

	        BinaryOperator<Integer> cmb = (element1, element2) -> {
	            System.out.println("thread " +  Thread.currentThread().getId() +",comb : " + element1 + " + " + element2 + " = " + (element1 + element2));
	            return element1 + element2;
	        };

		Integer sum = list.stream()
							.parallel()
							.reduce(idt, acc , cmb);
		System.out.println("Ergenis : sum = " + sum);

		/* 
		 * - parallel
		 * - Datentyp wird nicht geändert. (Aufgabe : Summe berechnen)
		 * 
		 * Beispiel für zwei CPUs :
		 * 
		 * 
		 * 
		 * 		 CPU A			 				|		  	  CPU B
		 * 							 			|	
		 * Daten : 1 , 2 						| Daten :  3 , 4 , 5 
		 * 										|
		 * Schreitt 1.							| Schreitt 1.
		 * 										|
		 * a = 0 	(identity)					| a = 0 	(identity)
		 * b = 1 	(nächste Element)			| b = 3 	(eigenes Element)
		 * erg = acc.apply(a,b) = 1				| erg = acc.apply(a,b) = 3	
		 *										|
		 *Schreitt 2.							| Schreitt 2.
		 * 										|
		 * a = 1 	(erg aus Schritt 1)			| a = 3 	(erg aus Schritt 1)
		 * b = 2 	(nächste Element)			| b = 4 	(nächste Element)
		 * erg = acc.apply(a,b) = 3				| erg = acc.apply(a,b) = 7	
		 *										|
		 *										| Schreitt 3.
		 * 										|
		 *  									| a = 7 	(erg aus Schritt 2)
		 *										| b = 5 	(nächste Element)
		 * 										| erg = acc.apply(a,b) = 12
		 * Teilergebnis zum Gesamtergebnis
		 * kombinieren : 
		 * 
		 * 	x =  3 (Ergebnis der CPU A)
		 * 	y = 12 (Ergebnis der CPU B)
		 * 	
		 *  ergebnis = cmb.apply(x,y)	= 15 	
		 *  
		 *  Gesamtergebnis zurückliefer	 				 
		 */	
		System.out.println("------------------------------------------------------------------\n");

	}

	private static void bsp4() {
		System.out.println("Bsp. 4");

		/* <U> U reduce(U identity,
		 * 				BiFunction<U, ? super T, U> accumulator,
		 * 				BinaryOperator<U> combiner)
		 * 
		 * 	- kann den Datentyp ändern
		 * 
		 */
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		
		String idt = "";
		BiFunction<String, Integer, String> acc = (String element , Integer nextElement) -> {
			System.out.println("thread " + Thread.currentThread().getId() +", acc : " + element + " + " + nextElement + "= " + element + nextElement);
			return element + nextElement;
		};
		BinaryOperator<String> comb = ( e1 , e2 ) -> {
			System.out.println("thread " +  Thread.currentThread().getId() +",comb : " + " : " + e1 + " + " + e2 + "= " + e1 + e2);
			return  e1.concat(e2);
		};
		
		String s = list.stream()
					.parallel()
					.reduce(idt ,acc , comb);
	
		/* 
		 * - parallel
		 * - Datentyp wird nicht geändert. (Aufgabe : Summe berechnen)
		 * 
		 * Beispiel für zwei CPUs :
		 * 
		 * 
		 * 
		 * 		 CPU A			 				|		  	  CPU B
		 * 							 			|	
		 * Daten : 1 , 2 						| Daten :  3 , 4 , 5 
		 * 										|
		 * Schreitt 1.							| Schreitt 1.
		 * 										|
		 * a = "" 	(identity)					| a = "" 	(identity)
		 * b = 1 	(nächste Element)			| b = 3 	(eigenes Element)
		 * erg = acc.apply(a,b) = "1"			| erg = acc.apply(a,b) = "3"	
		 *										|
		 *Schreitt 2.							| Schreitt 2.
		 * 										|
		 * a = "1" 	(erg aus dem Schritt 1)		| a = "3" 	(erg aus demSchritt 1)
		 * b = 2 	(nächste Element)			| b = 4 	(nächste Element)
		 * erg = acc.apply(a,b) = "12"			| erg = acc.apply(a,b) = "34"	
		 *										|
		 *										| Schreitt 3.
		 * 										|
		 *  									| a = "34" 	(erg aus dem Schritt 2)
		 *										| b = 5 	(nächste Element)
		 * 										| erg = acc.apply(a,b) = "345"
		 * Teilergebnis zum Gesamtergebnis
		 * kombinieren : 
		 * 
		 * 	x = "12" (Ergebnis der CPU A)
		 * 	y = "345" (Ergebnis der CPU B)
		 * 	
		 *  ergebnis = cmb.apply(x,y)	 = "12345"	
		 *  
		 *  Gesamtergebnis zurückliefer	 				 
		 */	
		
		System.out.println("Ergebnis s = " + s);
	}


	
}
