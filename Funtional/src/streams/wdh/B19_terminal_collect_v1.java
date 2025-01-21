package streams.wdh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class B19_terminal_collect_v1 {

	/*
	 * collect :  mutable Reduction( der 1. Parameter ist der Zielcontainer)
	 *          เป็นฟังก์ชันที่ใช้สำหรับการรวมข้อมูลจาก Stream ไปยังคอนเทนเนอร์ (เช่น List, Set, Map) 
	 *          โดยใช้วิธีการที่กำหนดไว้ใน supplier, accumulator, และ combiner.
	 * 
	 *    <R> R collect(Supplier<R> supplier,
	 *                 BiConsumer<R, ? super T> accumulator,
	 *                 BiConsumer<R, R> combiner);
	 *      
	 *    supplier : Die Logik, mit der ein Zielcontainer erzeugt werden kann
	 *               เป็นฟังก์ชันที่ใช้สร้างคอนเทนเนอร์ใหม่ เช่น ถ้าต้องการรวมข้อมูลใน List ก็จะใช้ Supplier เพื่อสร้าง List ใหม่.
	 *    
	 *    			  public interface BiConsumer<T, U> {
	 *     				void accept(T t, U u);
	 *   			  }
	 *   
	 *    accumulator : Die Logik zum Speichern in einem collect-Schritt von dem nächsten Element
	 *                  der Pipeline in dem Zielcontainer
	 *                  เป็นฟังก์ชันที่ใช้สำหรับการเพิ่มองค์ประกอบใหม่ลงในคอนเทนเนอร์ โดยมันจะถูกเรียกใช้เมื่อมีข้อมูลใหม่เข้ามาใน Stream.
	 *                  
	 *                  
	 *    
	 *    combiner :  kombiniert die Zielcontainer, die in einzelnen Threads
	 *                 mit Teildaten erstellt werden, zu dem Gesamtergebnis
	 *                 ใช้สำหรับการรวมคอนเทนเนอร์ที่สร้างขึ้นจากเธรดที่แตกต่างกัน ซึ่งใช้ในการประมวลผลแบบขนาน 
	 *                 (parallel processing) เพื่อรวมผลลัพธ์ของคอนเทนเนอร์ที่สร้างในแต่ละเธรดให้เป็นผลลัพธ์รวม.
	 *    
	 */
	
	public static void main(String[] args) {
	
		Integer[] array = { 1,2,3,4,5};
		
		/*
		 * Aufgabe : Integer aus dem Array in einer List speichern
		 */
		
		/*
		 * - sequentiell
		 * 
		 * Zielcontainer erzeugen
		 *   
		 * Schritt 1
		 * 
		 * targetList = der erzeugt Zielcontainer
		 * nextElement = 1 
		 * acc.apply(targetList,nextElement) 
		 * 
		 * Schritt2
		 * 
		 * targetList = der erzeugt Zielcontainer
		 * nextElement = 2
		 * acc.apply(targetList,nextElement) 
		 * 
		 * Schritt 3
		 * 
		 * targetList = der erzeugt Zielcontainer
		 * nextElement = 3 
		 * acc.apply(targetList,nextElement)  
		 * 
		 * ...
		 *  
		 * Am Ende den Zielcontainer zurückliefern -> [1, 2, 3, 4, 5]
		 * 
		 */

		 
		System.out.println("Bsp.1 ");
		
		Supplier<List<Integer>> supp = () -> new ArrayList<>();
		// BiConsumer <im Zielcontainer  , das nächtes Element Pipeline>
		BiConsumer<List<Integer>, Integer> acc = (targetList , nextElement) -> targetList.add(nextElement) ; 
		BiConsumer<List<Integer> , List<Integer>> comb = (a , b ) -> {} ; // sinnlos , wrd blan geändern
		
		
		List<Integer> list = Arrays.stream(array)
									.collect(supp, acc, comb);
		
		System.out.println("1. list : " + list);
		
		
		System.out.println("------------------------------------------------------------------\n");
		
		System.out.println("Bsp.2 ");
		
		/*
		 * - parallel
		 * Beispiel für 2 CPUs									
		 * 
		 * 
		 * CPU A											|  CPU A
		 * Daten : 1 , 2 , 3 								|  Daten : 4 , 5 
		 * 													|
		 * Zielcontainer A erzeugen							|  Zielcontainer B erzeugen
		 *   												|
		 * Schritt 1										|
		 * 													|
		 * targetList = Zielcontainer A						|  targetList = Zielcontainer B
		 * nextElement = 1 									|  nextElement = 4 
		 * acc.apply(targetList,nextElement) 				|  acc.apply(targetList,nextElement) 
		 * 													|
		 * Schritt2											|
		 * 													|
		 * targetList = Zielcontainer A						|  targetList = Zielcontainer B
		 * nextElement = 2 									|  nextElement = 5 
		 * acc.apply(targetList,nextElement) 				|  acc.apply(targetList,nextElement) 
		 * 													|
		 * Schritt 3										|
		 * 													|
		 * targetList = Zielcontainer A						|
		 * nextElement = 3 									|
		 * acc.apply(targetList,nextElement)				|  
		 * 
		 * 
		 * Abwarten ( wenn nötig ) bis die Arbeit auf der CPU b fertig ist. 
		 * 
		 * In dem Zielcontainer A die Daten aus dem Zielcontainer B übernehemen
		 * 		listA = Zielcontainer A
		 * 		listB = Zielcontainer B
		 * 
		 * 		cmb.accept(listA , listB) -> ergebnis = [1, 2, 3, 4, 5]
		 * 
		 * 
		 * 
		 * Am Ende den Zielcontainer zurückliefern
		 * 
		 */
		
		Supplier<List<Integer>> supp2 = () -> new ArrayList<>();
		BiConsumer<List<Integer>, Integer> acc2 = (targetList , nextElement) -> targetList.add(nextElement) ; 
		BiConsumer<List<Integer> , List<Integer>> comb2 = ( listA , listB ) -> listA.addAll(listB) ;
		
		
		List<Integer> list2 = Arrays.stream(array)			// Stram<Integer>
									.parallel()
									.collect(supp2, acc2, comb2);

		System.out.println("2. list2 : " + list2);
	}


	
}
