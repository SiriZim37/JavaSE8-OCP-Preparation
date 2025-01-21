package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class B08_Streams_termial_three {

	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("Wilma", "Fred", "Pebbles", "Barney", "Betty", "Bambam");

		/*
		 *  ใช้  Stream เพื่อเก็บชื่อใน List ใหม่
		 */
		List<String> name = list.stream().collect(Collectors.toList());
		

		/*
		 *  ใช้ Stream เพื่อเก็บชื่อใน ArrayList ใหม่
		 *  ที่นี่ ArrayList::new ใช้สำหรับสร้าง ArrayList ใหม่.
		 */
		ArrayList<String> arrayListName = list.stream().collect(Collectors.toCollection(ArrayList::new));
		

		/*
		 * ใช้ Stream เพื่อเก็บชื่อใน Set (ไม่ให้มีชื่อซ้ำ)
		 * Set จะไม่เก็บค่าที่ซ้ำกัน (duplicate).
		 */
		Set<String> setNamen = list.stream().collect(Collectors.toSet());
		setNamen.forEach(System.out::println);
		
		split() ;
		
		/*
		 *  ใช้ Stream เพื่อเชื่อมชื่อใน List ด้วย ", " และเก็บใน String
		 */
		String namen = list.stream().collect(Collectors.joining(", ")); 
		System.out.println(namen);
		
		
		split() ;
		
		System.out.println("***Bsp1. list combined : \n");
		
		/*
		 *  Bsp : รวมชื่อจากรายการ (list) เป็นข้อความเดียวที่อยู่ในรูปแบบของ StringBuilder 
                  โดยใช้การประมวลผลแบบขนาน (parallel processing) เพื่อเพิ่มประสิทธิภาพเมื่อมีข้อมูลจำนวนมาก
		 */
		 
		/*
    		<R> R collect(Supplier<R> supplier,
                  BiConsumer<R, ? super T> accumulator,
                  BiConsumer<R, R> combiner);
  
		 */
			
		// ประกาศ accumulator สำหรับสะสม StringBuilder
        BiConsumer<StringBuilder, String> accumulator = (sb1, sb2) -> sb1.append(sb2);

        // ประกาศ combiner สำหรับการรวม StringBuilder
        BiConsumer<StringBuilder, StringBuilder> combiner = (sb1, sb2) -> sb1.append(sb2);

        StringBuilder nameSB = list.stream()
                                    .parallel() // ใช้การประมวลผลแบบขนาน
                                    .collect(StringBuilder::new, accumulator, combiner);

        System.out.println("Names: " + nameSB.toString());
        
		
        split() ;
        
    	
		
	}
	static void split() {
		System.out.println("\n------------------------------------------------------");
	}
}
