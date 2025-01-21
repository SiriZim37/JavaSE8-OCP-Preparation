package streams.wdh;


import java.util.Arrays;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class B08_intermediate_peek {

	public static void main(String[] args) {
	
		/*
		 *  Stream<T> peek(Consumer<? super T> action);
		 */
		/*
		 * Peek-Methode ดูข้อมูลระหว่างการประมวลผล (ไม่เปลี่ยนข้อมูล)
		 * 
		 * ใช้ peek() กับ Consumer เพื่อดูข้อมูลใน stream ระหว่างการดำเนินการ
		 * 
		 * Peek brauct Consumer
		 * 
		 * peek() ใน Stream และวิธีการใช้กับ Consumer เพื่อดูข้อมูลระหว่างการประมวลผล 
		 * โดยที่ peek() จะช่วยให้เรา "มองเห็น" ข้อมูลระหว่างการประมวลผลใน Stream โดยไม่เปลี่ยนแปลงข้อมูล
		 */
		
		/*
		 * Bsp1.
		 */
		System.out.println("***Bsp1.");
		Stream.of(1,2,3)
			  .peek( x -> System.out.println(x)); 	// keine Ausgaben
		
		/*
		 * peek =1
		 * 1
		 * peek =2
		 * 2
		 * peek =3
		 * 3
		 */
		System.out.println("***Bsp2.");
		Stream.of(1,2,3)
		  .peek( x -> System.out.println("peek =" + x))
		  .forEach(System.out::println);	

		System.out.println("main");
		
		/*
		 * Bsp3. ?????????????????????
		 * 
		 * ใน Bsp.3 มีการพิมพ์ 1 2 3 ออกมา แต่เราไม่เห็นผลของการนับจำนวน เพราะไม่มีการพิมพ์ตัวแปรที่เก็บค่า count ออก
		 * In Bsp.3 gibt es die Ausgabe 1 2 3, aber wir sehen nicht das Ergebnis der Zählung, da wir die Variable count nicht ausgeben.
		 * 
		 * 
		 * Bsp. 3. Was ist das Ergebnis?
		 * 
		 * A.  1 2 3 4 5              <- richtig
		 * B.  keine Ausgaben         
		 */
		
		System.out.println("***Bsp.3");
		Stream.of(1, 2, 3, 4, 5)
			.filter(x -> true)
			.peek(x -> System.out.print(x + " ")) 
			.count(); // aktiviert die Pipeline auch mit Java 21, da es filter gibt.

		System.out.println("main");
		
		/*
		 * Bsp.4
		 * 
		 * ใน Bsp.4 มีการพิมพ์ 1 2 3 และตามด้วย 3 ซึ่งเป็นจำนวนที่นับได้จาก Stream
		 * In Bsp.4 sehen wir 1 2 3 und danach 3, was die gezählte Anzahl ist.
		 */
		System.out.println("***Bsp.4");
		long count = Stream.of(1,2,3,4,5)
						  .peek( x -> System.out.print( x + " "))
						  .count();	
	
		System.out.println(count);
	}

}
