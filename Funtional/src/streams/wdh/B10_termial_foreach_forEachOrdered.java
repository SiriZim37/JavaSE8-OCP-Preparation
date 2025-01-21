package streams.wdh;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;



public class B10_termial_foreach_forEachOrdered {

	public static void main(String[] args) {


		List<Integer> list = Arrays.asList(-7, 13, 11, -9, 5);
		Set<Integer> set = new HashSet<Integer>(list);
		
		
		
		/*
		 *  Bsp.1  การใช้งาน list.stream()
		 *  
		 * - Datenquelle ist geordnet : แหล่งข้อมูล (Data Source) เป็น Ordered (มีการเรียงลำดับ)
		 * - Stream ist sequentiell
		 * - terminal forEach
		 */
		list.stream()
			.forEach(x -> System.out.print(x + " ")); // -7 13 11 -9 5 
		System.out.println();
		
		/*
		 *  Bsp.2  การใช้งาน set.stream()
		 *  
		 * - Datenquelle ist ungeordnet !!! : Set ::: HashSet ไม่รักษาลำดับ:
		 * - Stream ist sequentiell
		 * - terminal forEach
		 */
		set.stream()
			.forEach(x -> System.out.print(x + " ")); // Reihenfolge unbestimmt
		System.out.println();
		
		
		/*
		 *  Bsp.3  การใช้งาน list.parallelStream()
		 *  
		 * - Datenquelle ist geordnet 
		 * - Stream ist parallel !!! : parallelStream() ลำดับของผลลัพธ์ไม่แน่นอนเนื่องจากการทำงานแบบขนาน
		 * 												 ทำให้การพิมพ์อาจไม่แสดงลำดับที่เก็บไว้ใน 
		 * - terminal forEach
		 */
		list.parallelStream()
			.forEach(x -> System.out.print(x + " "));  // Reihenfolge unbestimmt
		System.out.println();

		/*
		 *  Bsp.4   การใช้งาน list.parallelStream() กับ forEachOrdered() 
		 *  		จะแสดงผลในลำดับที่ถูกต้องตามที่เก็บไว้ใน list: -7 13 11 -9 5
		 *  
		 * - Datenquelle ist geordnet  !  
		 * - Stream ist parallel       !
		 * - terminal forEachOrdered   !
		 * 
		 * 
		 */
		list.parallelStream()
			//...
			.forEachOrdered(x -> System.out.print(x + " ")); // -7 13 11 -9 5 
		System.out.println();

		/*
		 * noch ein Test
		 * 
		 * การใช้งาน Stream.of() พร้อมกับการกรองและเปลี่ยนค่า
		 * 
		 * - Datenquelle ist geordnet 				: แหล่งข้อมูลเป็น Ordered
		 * - Stream ist parallel       				: Stream เป็น Parallel
		 * - filter to select only odd numbers.		: มีการใช้ filter เพื่อกรองเฉพาะค่าคี่
		 * - terminal forEachOrdered+
		 * 
		 * - 
		 */
		Stream.of(1, 2, 3, 4, 5)
			.parallel()
			.filter(x -> x % 2 != 0)
			.map(x -> x + "!")
			.forEachOrdered(System.out::println);  // ผลลัพธ์: จะแสดงค่าคี่ในลำดับที่ถูกต้องและมี ! ต่อท้าย: 1! 3! 5!
	}

}
