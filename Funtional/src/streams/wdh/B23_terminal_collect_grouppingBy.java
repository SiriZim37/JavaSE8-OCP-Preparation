package streams.wdh;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class B23_terminal_collect_grouppingBy {

	/*
	 * Collector<T, ?, Map<K, List<T>>>
	 * 			groupingBy(Function<? super T, ? extends K> classifier)
	 * 
	 * 
	 * Collector<T, ?, Map<K, D>> groupingBy(Function<? super T, ? extends K> classifier,
	 *  									  Collector<? super T, A, D> downstream) 
	 *  
	 *  
 	 * Collector<T, ?, M> groupingBy(Function<? super T, ? extends K> classifier,
	 *                                Supplier<M> mapFactory,
	 *                                Collector<? super T, A, D> downstream)
	 */

	public static void main(String[] args) {

		testV1();
		testV2();	
		testV3();
		
		
	}

	private static void testV1() {
		System.out.println("*** grouppingBy. V1");
		
		/*
		 * static <T, K> Collector<T, ?, Map<K, List<T>>>
		 * 			groupingBy(Function<? super T, ? extends K> classifier)
		 * 			
		 * groupingBy Collector : เป็นฟังก์ชันที่ใช้ในการจัดกลุ่มข้อมูลในสตรีมโดยใช้ฟังก์ชันที่เรียกว่า classifier 
		 * 						 เพื่อสร้างแผนที่ (Map) ที่เก็บข้อมูลตามกลุ่มที่กำหนดไว้
		 * 
		 * Der erzeugte Collecor hat die Logiken : 
		 * 
		 * supplier 		: eine Map erzeugen
		 * 
		 * accumulator 		: aus jedem Element der Pipeline wird mit der classifier-Function
		 * 					  der Key seiner Gruppe berechnet. 
		 * 					  จากแต่ละองค์ประกอบในสตรีม จะใช้ฟังก์ชัน classifier เพื่อคำนวณคีย์ (Key) ของกลุ่ม
		 * 
		 * 						- falls es in der Map (s. supplier-Logik) den Key noch nicht gibt,
		 * 						  > dann wird die Liste für die neue Gruppe erzeugt, 
		 * 						  	(หากคีย์นั้นยังไม่มีใน Map (ตามลอจิกของ supplier) จะสร้างรายการ (List) สำหรับกลุ่มใหม่)
		 * 						  > das Elelment in der Liste gespeichert, 
		 * 						  	(จากนั้นจะเก็บองค์ประกอบในรายการนั้น)
		 * 						  > die Key und sie Liste als Value werden in der Map gespeichert
		 * 							(สุดท้ายจะเก็บคีย์และรายการเป็นค่า (Value) ใน Map)
		 * 						
		 * 						- falls es in der Map (s. supplier-Logik) den Key berets gibt 
		 * 						  > wird in der vorhandene Liste das Element gespeichert.
		 * 						    (หาก key มีอยู่แล้วใน Map, จะเพิ่มองค์ประกอบลงไปในรายการที่มีอยู่)
		 * combiner 		 : die Gruppen aus der 2. Map in die richtigen Gruppen der 1 Map kopieren
		 * 						จะรวมกลุ่มต่าง ๆ ที่อยู่ใน Map ของเธรดที่แตกต่างกันให้เป็นกลุ่มเดียวกันใน Map สุดท้าย
		 */
		
		List<Integer> datenquelle = Arrays.asList(1,2,3,4,5,6,7);
		
		
		/*
		 * Aufgaben : 
		 * 
		 * "ungerade" -> 1 3 5 7 
		 * "gerade"   -> 2 4 6 
		 */
		Function<Integer, String> classifier = i -> {
			if( i % 2 == 0)
				return "gerade";
			else 
				return "ungerade";	
		};
		
		Collector<Integer, ?, Map<String,List<Integer>>> c1 = 
							Collectors.groupingBy(classifier);
		
		Map<String, List<Integer>> gruppenMap = datenquelle.stream().collect(c1);
				
		System.out.println( "gruppenMap : " + gruppenMap);
		
		System.out.println("\n---------------------------------------------------------------");
		
	}

	private static void testV2() {
		System.out.println("*** grouppingBy. V2");
		
		/*
		 * Collector<T, ?, Map<K, D>> groupingBy(Function<? super T, ? extends K> classifier,
		 *  									  Collector<? super T, A, D> downstream) 
		 *    
		 * 			
		 * groupingBy Collector : เป็นฟังก์ชันที่ใช้ในการจัดกลุ่มข้อมูลในสตรีมโดยใช้ฟังก์ชันที่เรียกว่า classifier 
		 * 						 เพื่อสร้างแผนที่ (Map) ที่เก็บข้อมูลตามกลุ่มที่กำหนดไว้
		 * 
		 * Der erzeugte Collector hat die Logiken : 
		 * 
		 * supplier 		: eine Map erzeugen
		 * 
		 * accumulator 		: aus jedem Element der Pipeline wird mit der classifier-Function
		 * 					  der Key seiner Gruppe berechnet. 
		 * 					  จากแต่ละองค์ประกอบในสตรีม จะใช้ฟังก์ชัน classifier เพื่อคำนวณคีย์ (Key) ของกลุ่ม
		 * 
		 * 						- falls es in der Map (s. supplier-Logik) den Key noch nicht gibt,
		 * 						  > dann wird das Bilden des Zielcontainer dem Downstream-Collector
		 * 							überlassen und das Element der Pipeline dem Downstream-Collector übergeben.
		 * 						  > จะส่งไปให้ Downstream-Collector จัดเก็บกลุ่มและองค์ประกอบของสตรีมนั้น
		 * 						  > das Element in der Liste gespeichert, 
		 * 						  	(จากนั้นจะเก็บองค์ประกอบในรายการนั้น)
		 * 						  > die Key und sie Liste als Value werden in der Map gespeichert
		 * 							(สุดท้ายจะเก็บคีย์และรายการเป็นค่า (Value) ใน Map)
		 * 
		 * 						- falls es in der Map (s. supplier-Logik) den Key bereits gibt 
		 * 						  > wird das Element der Pipeline dem Downstream-Collector übergeben
		 * 							(ถ้าคีย์นั้นมีอยู่ใน Map แล้ว จะส่งองค์ประกอบของสตรีมไปให้ Downstream-Collector)
		 * 
		 * combiner 		 : die Gruppen aus der 2. Map in die richtigen Gruppen der 1 Map kopieren
		 * 						จะรวมกลุ่มต่าง ๆ ที่อยู่ใน Map ของเธรดที่แตกต่างกันให้เป็นกลุ่มเดียวกันใน Map สุดท้าย
		 * 
		 * downstream 		 : Die Logiken zum Verwalten der Elemente einer Gruppe 
		 * 						ลอจิกที่ใช้ในการจัดการองค์ประกอบภายในแต่ละกลุ่ม
		 */

		
		List<Integer> datenquelle = Arrays.asList(1,2,3,4,5,6,7);
		
		
		/*
		 * Aufgaben : 
		 * 
		 * "ungerade" -> 1 3 5 7 
		 * "gerade"   -> 2 4 6 
		 * 
		 * Die Element einer Gruppe sollen in einem ArrayDeque gespeichert werden
		 */
		
		
		Function<Integer, String> classifier = (Integer n) -> n % 2 == 0 ? "gerade" : "ungerade";
		
	    Collector<Integer, ?, ArrayDeque<Integer>> downstream = Collectors.toCollection(ArrayDeque::new);

		Collector<Integer, ? , Map<String, ArrayDeque<Integer>>> c1 = Collectors.groupingBy(classifier , downstream);
		
		Map<String, ArrayDeque<Integer>> gruppenMap1 =   datenquelle.stream().collect(c1);
		
		System.out.println("gruppenMap (String-to-ArrayDeque) : " + gruppenMap1);
		
		System.out.println("\n---------------------------------------------------------------");
		
		

		/*
		 * Aufgaben : 
		 * 
		 * "ungerade" -> 1 3 5 7 
		 * "gerade"   -> 2 4 6 
		 * 
		 * Die Element einer Gruppe sollen in einem TreeSet gespeichert werden, 
		 * absteigend sortiert
		 */
		Comparator<Integer> cmp = (n1, n2) -> n2.compareTo(n1);
  
	    Supplier<TreeSet<Integer>> factory = () -> new TreeSet<>(cmp);
	    
	    factory = () -> new TreeSet<>(Comparator.reverseOrder());
	    
		Collector<Integer, ?, TreeSet<Integer>> downstream2 = Collectors.toCollection(factory);
		
		Collector<Integer, ?, Map<String, TreeSet<Integer>>> c2 = Collectors.groupingBy(classifier , downstream2); 
		
		Map<String, TreeSet<Integer>> gruppenMap2 = datenquelle.stream().collect(c2);
		
		System.out.println("gruppenMap2 (String-to-TreeSet absteigend sortiert) : " + gruppenMap2);
		
		
		/*
		 * Exam 
		 */
		Map<String, TreeSet<Integer>> gruppenMap3  = datenquelle.stream()
				  .collect( Collectors.groupingBy( n -> n%2==0? "gerade" : "ungerade" ,
												  Collectors.toCollection(()-> new TreeSet<>(Comparator.reverseOrder()))));
		
		System.out.println("gruppenMap3 : " + gruppenMap3);
		
		System.out.println("\n---------------------------------------------------------------");
	}
	
	private static void testV3() {
		System.out.println("*** grouppingBy. V3");
		
		/*
		 * Collector<T, ?, M> groupingBy(Function<? super T, ? extends K> classifier,
		 *                                Supplier<M> mapFactory,
		 *                                Collector<? super T, A, D> downstream)
		 *
		 * groupingBy Collector: Diese Funktion wird verwendet, um Elemente eines Streams 
		 *                       basierend auf einer Klassifikationsfunktion zu gruppieren 
		 *                       und eine Map zu erstellen, die die Daten nach bestimmten 
		 *                       Gruppen speichert.
		 *                       (ฟังก์ชันนี้ใช้ในการจัดกลุ่มองค์ประกอบของสตรีมตามฟังก์ชันการจัดประเภท 
		 *                        เพื่อสร้างแผนที่ (Map) ที่เก็บข้อมูลตามกลุ่มที่กำหนดไว้)
		 *
		 * Der erzeugte Collector hat die folgende Logik:(Collector ที่สร้างขึ้นมีลอจิกดังต่อไปนี้)
		 *
		 * supplier: Erzeugt eine neue Map, um die gruppierten Elemente zu speichern.
		 * 					 (สร้างแผนที่ใหม่เพื่อเก็บองค์ประกอบที่ถูกจัดกลุ่ม)
		 *classifier: Eine Funktion, die verwendet wird, um den Schlüssel jeder Gruppe 
		 *             aus jedem Element der Pipeline zu berechnen.
		 *             (ฟังก์ชันที่ใช้ในการคำนวณคีย์ของแต่ละกลุ่มจากแต่ละองค์ประกอบในเธรน)
		 * accumulator: Für jedes Element in der Pipeline wird die Klassifikationsfunktion 
		 *               angewendet, um den Schlüssel seiner Gruppe zu berechnen.
		 *               (สำหรับแต่ละองค์ประกอบในเธรนจะใช้ฟังก์ชันการจัดประเภท 
		 *                เพื่อคำนวณคีย์ของกลุ่ม)
		 *               - Wenn der Schlüssel noch nicht in der Map (gemäß der Lieferlogik) 
		 *                 existiert, ist der Downstream-Collector dafür verantwortlich, 
		 *                 den Zielcontainer zu erstellen, und das aktuelle Element wird 
		 *                 ihm übergeben.
		 *                 (ถ้าคีย์ยังไม่มีในแผนที่ตามลอจิกของผู้จัดหา 
		 *                  Downstream-Collector จะต้องรับผิดชอบในการสร้างตัวเก็บข้อมูล 
		 *                  และส่งองค์ประกอบปัจจุบันให้กับมัน)
		 *               - Dies bedeutet, dass das Element in der Liste für diesen Schlüssel 
		 *                 gespeichert wird, wobei der Schlüssel und seine Liste als Wert 
		 *                 in der Map gespeichert werden.
		 *                 (ซึ่งหมายความว่าองค์ประกอบจะถูกเก็บในรายการสำหรับคีย์นี้ 
		 *                  โดยที่คีย์และรายการของมันจะถูกเก็บเป็นค่าในแผนที่)
		 *               - Wenn der Schlüssel bereits in der Map vorhanden ist, wird das 
		 *                 Element an den Downstream-Collector übergeben.
		 *                 (ถ้าคีย์นั้นมีอยู่ใน Map แล้ว องค์ประกอบจะถูกส่งไปที่ 
		 *                  Downstream-Collector)
		 *
		 * combiner: Führt Gruppen aus der zweiten Map in die entsprechenden Gruppen 
		 *            der ersten Map zusammen, wenn sie parallel verarbeitet werden.
		 *            (รวมกลุ่มจากแผนที่ที่สองเข้าไปในกลุ่มที่เกี่ยวข้องในแผนที่แรก 
		 *             เมื่อดำเนินการแบบขนาน)
		 *
		 * downstream: Logik zur Verwaltung der Elemente innerhalb jeder Gruppe.
		 *             (ลอจิกในการจัดการองค์ประกอบภายในแต่ละกลุ่ม)
		 *             - Dies definiert, wie die Elemente jeder Gruppe unter Verwendung 
		 *               des bereitgestellten Downstream-Collectors gesammelt werden.
		 *               (ซึ่งกำหนดว่าองค์ประกอบของแต่ละกลุ่มจะถูกเก็บรวบรวม 
		 *                โดยใช้ Downstream-Collector ที่จัดเตรียมไว้)
		 */

                                  
		List<Integer> datenquelle = Arrays.asList(1,2,3,4,5,6,7);
		
		/*
		 * Aufgaben :  zwei Gruppen bilden
		 * 
		 * "ungerade" -> 1 3 5 7 
		 * "gerade"   -> 2 4 6 
		 * 
		 * Die Element einer Gruppe sollen in einem ArrayDeque gespeichert werden, 
		 * 
		 * Die Gruppen-Map soll eine TreeMap sein.
		 */
		
		Function<Integer, String> classifier = (Integer n) -> n % 2 == 0 ? "gerade" : "ungerade";
		
		Collector<Integer, ?, ArrayDeque<Integer>> downstream = Collectors.toCollection(ArrayDeque::new); 
		
		Supplier<TreeMap<String, ArrayDeque<Integer>>> mapFactory = TreeMap::new;
		
		Collector<Integer, ?, TreeMap<String, ArrayDeque<Integer>>> c1 = Collectors.groupingBy(classifier, mapFactory, downstream);
		 
		TreeMap<String, ArrayDeque<Integer>> gruppenMap = datenquelle.stream().collect(c1);
		
		System.out.println("gruppenMap: " + gruppenMap);
		
		
		/*
		 * Exam 
		 */
		TreeMap<String, ArrayDeque<Integer>> gruppenMap2  = datenquelle.stream()
				  .collect( Collectors.groupingBy( n -> n%2==0? "gerade" : "ungerade" ,
						  						 TreeMap::new,
												  Collectors.toCollection(()-> new ArrayDeque<>())));
		
		System.out.println("gruppenMap2 : " + gruppenMap2);
		
	}

	
}
