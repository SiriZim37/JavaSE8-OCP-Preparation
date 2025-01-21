package streams.wdh;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class B22_terminal_collect_mapping {


	public static void main(String[] args) {
	
		List<Integer> datenquelle = Arrays.asList(1,5,3,4,5 , 1);
		
		/*
		 * ohne mapping-Collector
		 */
		Collector<String, ?, Set<String>> c1 = Collectors.toSet();
		
		Function<Integer, String> f1 = i -> "<" + i + ">";
		
		Set<String> set1 = datenquelle.stream() // Stream<Integer>
							.map(f1)			// Stream<String>
							.collect(c1);	
		
		System.out.println("set1 = " + set1);	// set1 = [<5>, <4>, <3>, <1>]
		
		System.out.println("\n---------------------------------------------------------------");
		
		
		
		/*
		 * mit mapping-Collector
		 * 
		 * seine Logiken
		 * 
		 * supplier	    : 	die supllier-Logik des downstream-Collecor
		 * 					ใช้ในการสร้างคอลเลคเตอร์ใหม่ (downstream collector) ที่จะใช้รวบรวมผลลัพธ์ที่ได้จากการแปลง
		 * 
		 * accumulator  : 	mit der mapper-Function jedes Element der Pipeline umrechnen
		 * 				 	einen Wert berechnen.
		 * 					Den berechneten Wert dem dowstream-accumulator übergeben
		 * 					ฟังก์ชันที่ใช้ในการแปลงค่าในสตรีม โดยใช้ mapper ฟังก์ชันในการแปลงแต่ละองค์ประกอบในสตรีม 
		 * 				 	และผลลัพธ์ที่ได้จะถูกส่งต่อไปยัง accumulator ของ downstream
		 * combiner     :	die Combiner-Logik des dowstream-Collector
		 * 					ใช้ในการรวมคอลเลคเตอร์ที่สร้างขึ้นจากเธรดที่แตกต่างกัน (หากการประมวลผลแบบขนานถูกใช้งาน)
		 */
		
		// Variante 1 
		Function<Integer, String> mapper = num -> "(" + String.valueOf(num) + ")";
		
		Collector<String, ?, Set<String>> dowstream = Collectors.toSet();
		
		Collector<Integer, ?, Set<String>> c2 = Collectors.mapping(mapper, dowstream);
		
		Set<String> set2 = datenquelle.stream().collect(c2);
		
		System.out.println("set2 : " + set2);		// set2 : [(1), (5), (4), (3)]
		
		// Variante 2
		
		Set<String> set3 = datenquelle.stream()
									.collect(Collectors.mapping( n -> "| " +  n + " |" 
																, Collectors.toSet())	    
											);
		
		System.out.println("set3 : " + set3);		// [| 3 |, | 1 |, | 4 |, | 5 |]
	}


	
}
