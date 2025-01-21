package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;



public class B04_Optional {
	/*
	 * Optional คือวัตถุที่ทำหน้าที่เป็นที่เก็บข้อมูลที่อาจมีหรือไม่มีค่าที่ไม่เป็น null อยู่ มันถูกใช้เพื่อหลีกเลี่ยง 
	 * NullPointerExceptions และเพื่อแสดงความไม่แน่นอนเกี่ยวกับค่าที่อาจมีอยู่ชัดเจนขึ้น Optional สามารถเก็บค่า 
	 * หรือเป็นค่าว่าง (empty) ซึ่งเป็นวิธีที่ปลอดภัยกว่าในการทำงานกับค่าที่อาจไม่มี
	 * 
	 * 
	 * คุณสมบัติหลักของ Optional:
	 * 1. **หลีกเลี่ยง Null**: มันช่วยกระตุ้นให้นักพัฒนาจัดการกับการไม่มีค่าโดยไม่ต้องใช้ null
	 * 2. **เมธอดทั่วไป**:
	 *    - `isPresent()`: คืนค่า true หากมีค่าอยู่
	 *    - `ifPresent(Consumer<? super T> action)`: ทำงานตามที่กำหนดเมื่อมีค่าอยู่
	 *    - `get()`: คืนค่าหากมีอยู่ มิฉะนั้นจะโยน NoSuchElementException
	 *    - `orElse(T other)`: คืนค่าหากมีอยู่ มิฉะนั้นจะคืนค่าตั้งต้นที่กำหนด
	 *    - `orElseGet(Supplier<? extends T> other)`: คล้ายกับ `orElse` แต่รับ Supplier สำหรับค่าตั้งต้น
	 */
	public static void main(String[] args) {

		List<String> list = Arrays.asList("Wilma", "Fred", "Pebbles", "Barney", "Betty", "Bambam");
		
        Optional<String> minimum = list.stream()
        							.filter(name -> name.equals("Luke"))
        							.min(Comparator.naturalOrder());
        System.out.println("minimum = " + minimum) ; 	// Optional[Bambam]
        
        System.out.println("minimum = " + minimum.orElseGet(()-> "Nicht vorhanden")) ; 
        
        if(minimum.isPresent()) {
        	String name = minimum.get();
        	System.out.println("minimum = " + name) ; 
        }

	}

}

