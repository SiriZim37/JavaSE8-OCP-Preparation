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


public class B21_terminal_collect_toXxx {

	/*
	 	 	Collectors.toList();
			Collectors.toSet();
			Collectors.toCollection(null);
			Collectors.toMap(null, null);
	 */
	public static void main(String[] args) {
		Integer[] array = { 1,5,3,4,5};
		
		bsp_toList(array);
		bsp_toSet(array);
		bsp_toCollection(array);
		bsp_toMap();
	}



	private static void bsp_toList(Integer[] array) {

		/*
		 * Collectors.toList();
		 * รวบรวมองค์ประกอบของสตรีมลงใน List
		 * 
		 * 	supplier 	- erzeugt ein List
		 * 	accumulator - einzelne Elemente in einem List speichern
		 * 	combiner    - List kombinieren
		 */

		Collector<Integer, ?, List<Integer>> c1 =  Collectors.toList();
		
		List<Integer> list = Arrays.stream(array).collect(c1);
			
		System.out.println("list : " + list);
		
		System.out.println("\n---------------------------------------------------------------");
	}

	private static void bsp_toSet(Integer[] array) {
		/*
		 * Collectors.toSet();
		 * รวบรวมองค์ประกอบของสตรีมลงใน Set และลบข้อมูลที่ซ้ำกัน
		 */
		
		/*
		 * toSet()
		 * 
		 * 	supplier 	- erzeugt ein Set
		 * 	accumulator - einzelne Elemente in einem Set speichern
		 * 	combiner    - Sets kombinieren
		 */
		Collector<Integer, ?, Set<Integer>> c2 =  Collectors.toSet();
		
		Set<Integer> set = Arrays.stream(array).collect(c2);
			
		System.out.println("set : " + set);
		
		System.out.println("\n---------------------------------------------------------------");
	}
	
	private static void bsp_toCollection(Integer[] array) {
	
		/*
		 * Collectors.toCollection( Supplier<C> collectionFactory )
		 * 		คอลเลคเตอร์นี้ให้คุณสามารถรวบรวมองค์ประกอบจากสตรีมไปยังประเภทของ Collection 
		 * 		ที่เฉพาะเจาะจง โดยจะต้องระบุ Supplier ที่สร้างคอลเลคชัน
		 * 
		 * 	supplier 	- die Lögik fehlt
		 * 	accumulator - einzelne Elemente in einem Collection speichern
		 * 	combiner    - Collections kombinieren
		 */

		Supplier<TreeSet<Integer>> supp = () -> new TreeSet();	
		
		Collector<Integer, ?, TreeSet<Integer>> c3 = Collectors.toCollection(supp);
		c3 = Collectors.toCollection(TreeSet::new);
		
		TreeSet<Integer> treeSet = Arrays.stream(array).collect(c3);
			
		System.out.println("treeSet : " + treeSet);
		
		System.out.println("\n---------------------------------------------------------------");
	}

	

	private static void bsp_toMap() {
		/*
		 * Collectors.toMap(Function<? super T, ? extends K> keyMapper, 
		 * 					Function<? super T, ? extends U> valueMapper)
		 * 	
		 * 	 public interface Function<T, R>{
		 *  		 R apply(T t);
		 *   }
		 * รวบรวมองค์ประกอบของสตรีมลงใน Map โดยกำหนดวิธีการดึงคีย์และค่า
		 * 	-	keyMapper: ฟังก์ชันที่ใช้ดึงคีย์จากองค์ประกอบ
		 * 	-	valueMapper: ฟังก์ชันที่ใช้ดึงค่าจากองค์ประกอบ
		 * 
		 * 	supplier 	- eine Map erzeugen
		 * 	accumulator - einzelne Elemente in der Map speichern 
		 * 					, dabei werden aus Element der Key und Value berechnet 
		 * 	combiner    - Maps kombinieren
		 */
		List<String> datenQuelle = Arrays.asList("ccc" , "a","bb","dddd");
		
		
		Function<String , Integer> keyMapper = (String s)  -> s.length();  // key   : return Integer
		Function<String , String> valueMapper =  (String s ) -> s ;		   // value : retuen String
		
		 Collector<String, ?, Map<Integer, String>> c4 = Collectors.toMap(keyMapper, valueMapper);
		
		 Map<Integer, String> map = datenQuelle.stream().collect(c4);
		
		 map.forEach( (key,value)-> System.out.println( key + " : " + value));
		 
		 System.out.println("map: " + map);
			
		
		
		System.out.println("\n---------------------------------------------------------------");
	}
	
}
